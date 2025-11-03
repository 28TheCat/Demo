import requests
import re
import os
import time
import random
import jieba
from wordcloud import WordCloud
from imageio import imread

# 保存弹幕文件路径
comment_file_path = os.path.join(os.getcwd(), 'bilibili_danmu.csv')


def get_fav_videos(media_id, cookie=None, pages=5, page_size=50):
    videos = []
    headers = {'User-Agent': 'Mozilla/5.0'}
    if cookie:
        headers['cookie'] = cookie

    for pn in range(1, pages + 1):
        url = f'https://api.bilibili.com/x/v3/fav/resource/list?media_id={media_id}&pn={pn}&ps={page_size}'
        resp = requests.get(url, headers=headers)
        data = resp.json()
        if data.get('code') != 0:
            print("获取收藏夹失败:", data.get("message"))
            break

        items = data['data'].get('medias', [])
        if not items:
            break

        for item in items:
            videos.append(item['bvid'])

        time.sleep(random.uniform(0.8, 1.5))

    return list(set(videos))  # 去重返回


def get_cid_list(bvid, cookie=None):
    """支持多 P 视频，返回所有 cid 列表"""
    headers = {'User-Agent': 'Mozilla/5.0'}
    if cookie:
        headers['cookie'] = cookie
    url = f'https://api.bilibili.com/x/web-interface/view?bvid={bvid}'
    resp = requests.get(url, headers=headers)
    data = resp.json()

    if data.get('code') == 0:
        pages = data['data'].get('pages', [])
        return [p['cid'] for p in pages]
    return []


def spider_page(cid, bvid=None, cookie=None):
    headers = {
        'referer': f'https://www.bilibili.com/video/{bvid}',
        'User-Agent': 'Mozilla/5.0'
    }
    if cookie:
        headers['cookie'] = cookie

    url = f'https://comment.bilibili.com/{cid}.xml'
    resp = requests.get(url, headers=headers)
    resp.encoding = resp.apparent_encoding

    if resp.status_code == 200:
        return re.findall(r'<d p=".*?">(.*?)</d>', resp.text)
    return []


def save_comments(all_comments):
    all_comments = list(set(all_comments))  # 去重
    with open(comment_file_path, 'w', encoding='utf-8') as f:
        for comment in all_comments:
            f.write(comment + '\n')
    print(f'✅ 已保存弹幕：{len(all_comments)} 条 → {comment_file_path}')


def data_visual(mask_image='mask.png', output_file='danmu_wordcloud.png'):
    if not os.path.exists(comment_file_path):
        print("⚠️ 弹幕文件不存在，请先爬取。")
        return

    # 读取弹幕文本
    with open(comment_file_path, encoding='utf-8') as f:
        text = f.read()

    stopwords_path = r"E:\Demo\python\pythonDemo\bangDream\cn_stopwords.txt"

    if os.path.exists(stopwords_path):
        with open(stopwords_path, encoding='utf-8') as f:
            stopwords = set(f.read().splitlines())
            print("已从自定义路径加载停用词")
    else:
        print("未找到停用词文件：", stopwords_path)

    # 中文分词并去掉停用词
    words = [w for w in jieba.lcut_for_search(text) if w.strip() and w not in stopwords]
    new_words = ' '.join(words)

    mask = imread(mask_image) if os.path.exists(mask_image) else None

    wordcloud = WordCloud(
        font_path='msyh.ttc',
        mask=mask,
        width=1000,
        height=700,
        background_color='white'
    ).generate(new_words)

    wordcloud.to_file(output_file)
    print(f'🎉 词云生成成功：{output_file}')


if __name__ == "__main__":
    media_id = '3422272704'  # 收藏夹 ID
    cookie = None  # 建议填登录 cookie，不然部分视频弹幕访问被拒

    print("📍 正在获取收藏夹视频列表...")
    bvids = get_fav_videos(media_id, cookie=cookie, pages=3, page_size=30)
    print(f"📌 获取到 {len(bvids)} 个视频")

    all_comments = []

    for bvid in bvids:
        cid_list = get_cid_list(bvid, cookie=cookie)
        for cid in cid_list:
            print(f'⏳ 爬取弹幕：BV{bvid}  CID={cid}')
            comments = spider_page(cid, bvid=bvid, cookie=cookie)
            all_comments.extend(comments)
            time.sleep(random.uniform(0.8, 1.5))

    save_comments(all_comments)
    data_visual(mask_image='img_1.png', output_file='bilibili_danmu_wordcloud.png')
