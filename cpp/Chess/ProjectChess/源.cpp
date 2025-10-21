#define _CRT_SECURE_NO_WARNINGS 1
#include<graphics.h>
#include<conio.h>
#define X 50
#define Y 50

int main() {
	initgraph(800 + 100, 900 + 100);
	setbkcolor(RGB(184, 154, 108));
	cleardevice();
	
	settextcolor(BLACK);
	settextstyle(80, 50, _T("楷体"));
	outtextxy(100 + X, 410 + Y, _T("楚河"));
	outtextxy(500 + X, 410 + Y, _T("漢界"));

	setlinecolor(BLACK);
	line(0 + X, 400 + Y, 0 + X, 500 + Y);
	line(800 + X, 400 + Y, 800 + X, 500 + Y);

	line(X - 5, Y - 5, 0 + X - 5, 800 + Y + 5);
	line(800 + X + 5, Y - 5, 800 + X + 5, 800 + Y + 5);
	line(X - 5, Y - 5, 0 + X + 800, Y - 5);
	line(800+X + 5, Y - 5, 800+ X,  Y - 5);
	



	for (int i = 0; i < 10; i++) {
		line(0 + X, 100 * i + Y, 800 + X, 100 * i + Y);
		line(100 * i + X, 0 + Y, 100 * i + X, 400 + Y);
		line(100 * i + X, 500 + Y, 100 * i + X, 800 + Y);
	}
	setlinestyle(PS_DASH);
	line(300 + 50, 0 + 50, 500 + 50, 200 + 50);
	line(300 + 50, 200 + 50, 500 + 50, 0 + 50);
	line(300 + 50, 700 + 50, 500 + 50, 900 + 50);
	line(300 + 50, 900 + 50, 500 + 50, 700 + 50);

	//象棋炮和兵下的十字
	setlinestyle(PS_SOLID);
	for (int i = 0; i < 4; i++) {//兵
		line(5 + 200 * i+50, 270+50, 5 + 200 * i+50, 295+50);
		line(5 + 200 * i+50, 295+50, 25 + 200 * i+50, 295+50);
		line(5 + 200 * i + 50, 570 + 50, 5 + 200 * i + 50, 595 + 50);
		line(5 + 200 * i + 50, 595 + 50, 25 + 200 * i + 50, 595 + 50);
		line(5 + 200 * i + X, 330 + Y, 5 + 200 * i + X, 305 + Y);
		line(5 + 200 * i + X, 305 + Y, 25 + 200 * i + X, 305 + Y);
		line(5 + 200 * i + X, 630 + Y, 5 + 200 * i + X, 605 + Y);
		line(5 + 200 * i + X, 605 + Y, 25 + 200 * i + X, 605 + Y);
		line(195 + 200 * i + 50, 270 + 50, 195 + 200 * i + 50, 295 + 50);
		line(195 + 200 * i + 50, 295 + 50, 170 + 200 * i + 50, 295 + 50);
		line(195 + 200 * i + 50, 570 + 50, 195 + 200 * i + 50, 595 + 50);
		line(195 + 200 * i + 50, 595 + 50, 170 + 200 * i + 50, 595 + 50);
		line(195 + 200 * i + X, 330 + Y, 195 + 200 * i + X, 305 + Y);
		line(195 + 200 * i + X, 305 + Y, 170 + 200 * i + X, 305 + Y);
		line(195 + 200 * i + X, 630 + Y, 195 + 200 * i + X, 605 + Y);
		line(195 + 200 * i + X, 605 + Y, 170 + 200 * i + X, 605 + Y);

	}
	line(95 + X, 170 + Y, 95 + X, 195 + Y);//炮
	line(95 + X, 195 + Y, 70 + X, 195 + Y);
	line(105 + X, 170 + Y, 105 + X, 195 + Y);
	line(105 + X, 195 + Y, 125 + X, 195 + Y);

	line(95 + X + 600, 170 + Y, 95 + X + 600, 195 + Y);
	line(95 + X + 600, 195 + Y, 70 + X + 600, 195 + Y);
	line(105 + X + 600, 170 + Y, 105 + X + 600, 195 + Y);
	line(105 + X + 600, 195 + Y, 125 + X + 600, 195 + Y);
	
	line(95 + X, 170 + Y+500, 95 + X, 195 + Y + 500);
	line(95 + X, 195 + Y + 500, 70 + X, 195 + Y + 500);
	line(105 + X, 170 + Y + 500, 105 + X, 195 + Y + 500);
	line(105 + X, 195 + Y + 500, 125 + X, 195 + Y + 500);

	line(95 + X + 600, 170 + Y + 500, 95 + X + 600, 195 + Y + 500);
	line(95 + X + 600, 195 + Y + 500, 70 + X + 600, 195 + Y + 500);
	line(105 + X + 600, 170 + Y + 500, 105 + X + 600, 195 + Y + 500);
	line(105 + X + 600, 195 + Y + 500, 125 + X + 600, 195 + Y + 500);

	line(95 + X, 230 + Y, 95 + X, 205 + Y);
	line(95 + X, 205 + Y, 70 + X, 205 + Y);
	line(105 + X, 230 + Y, 105 + X, 205 + Y);
	line(105 + X, 205 + Y, 125 + X, 205 + Y);

	line(95 + X+600, 230 + Y, 95 + X + 600, 205 + Y);
	line(95 + X + 600, 205 + Y, 70 + X + 600, 205 + Y);
	line(105 + X + 600, 230 + Y, 105 + X + 600, 205 + Y);
	line(105 + X + 600, 205 + Y, 125 + X + 600, 205 + Y);

	line(95 + X, 230 + Y+500, 95 + X, 205 + Y + 500);
	line(95 + X, 205 + Y + 500, 70 + X, 205 + Y + 500);
	line(105 + X, 230 + Y + 500, 105 + X, 205 + Y + 500);
	line(105 + X, 205 + Y + 500, 125 + X, 205 + Y + 500);

	line(95 + X + 600, 230 + Y + 500, 95 + X + 600, 205 + Y + 500);
	line(95 + X + 600, 205 + Y + 500, 70 + X + 600, 205 + Y + 500);
	line(105 + X + 600, 230 + Y + 500, 105 + X + 600, 205 + Y + 500);
	line(105 + X + 600, 205 + Y + 500, 125 + X + 600, 205 + Y + 500);

	setfillcolor(RGB(184, 154, 108));//棋子
	settextcolor(BLACK);
	settextstyle(50, 25, _T("楷体"));
	
	fillcircle(300 + X, 100 + Y, 45);
	circle(300 + X, 100 + Y, 41);
	outtextxy(300 + X - 25, 100 + Y - 25, _T("将"));

	fillcircle(100 + X, 200 + Y, 45);
	circle(100 + X, 200 + Y, 41);
	outtextxy(100 + X - 25, 200 + Y - 25, _T("炮"));
	
	fillcircle(X, 500 + Y, 45);
	circle(X, 500 + Y, 41);
	outtextxy(X - 25, 500 + Y - 25, _T("卒"));

	fillcircle(400+X, 800 + Y, 45);
	circle(400+X, 800 + Y, 41);
	outtextxy(400+X - 25, 800 + Y - 25, _T("卒"));

	fillcircle(500 + X, 600 + Y, 45);
	circle(500 + X, 600 + Y, 41);
	outtextxy(500 + X - 25, 600 + Y - 25, _T("卒"));

	fillcircle(400 + X, 200 + Y, 45);
	circle(400 + X, 200 + Y, 41);
	outtextxy(400 + X - 25, 200 + Y - 25, _T("相"));

	settextcolor(RED);//红方
	fillcircle(500 + X, 900 + Y, 45);
	circle(500 + X, 900 + Y, 41);
	outtextxy(500 + X - 25, 900 + Y - 25, _T("帅"));

	fillcircle(500 + X, 300 + Y, 45);
	circle(500 + X, 300 + Y, 41);
	outtextxy(500 + X - 25, 300 + Y - 25, _T("车"));

	fillcircle(600 + X, 200 + Y, 45);
	circle(600 + X, 200 + Y, 41);
	outtextxy(600 + X - 25, 200 + Y - 25, _T("炮"));

	fillcircle(400 + X, 300 + Y, 45);
	circle(400 + X, 300 + Y, 41);
	outtextxy(400 + X - 25, 300 + Y - 25, _T("兵"));
	Sleep(10000);
	_getch();
	closegraph();
}