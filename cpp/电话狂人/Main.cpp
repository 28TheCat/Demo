#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define PHONE_LENGTH 11          // 定义电话号码的长度
#define HASH_TABLE_SIZE 100003   // 定义哈希表的大小，选择质数以减少冲突

// 定义用户信息结构体
typedef struct UserInfo {
    char phoneNumber[PHONE_LENGTH + 1];  // 存储电话号码，+1是为了存储字符串结束符'\0'
    int callCount;                     // 存储该电话号码出现的通话次数
    struct UserInfo* next;             // 指向下一个UserInfo节点，用于链地址法处理哈希冲突
} UserInfo;

UserInfo* hashTable[HASH_TABLE_SIZE];  // 哈希表，每个元素是一个链表头指针

// 哈希函数：将手机号码转换为哈希值
unsigned int hash(const char* phoneNumber) {
    unsigned int hashValue = 0;
    for (int i = 0; i < PHONE_LENGTH; i++) {
        hashValue = (hashValue * 31 + phoneNumber[i]) % HASH_TABLE_SIZE;  // 计算哈希值
    }
    return hashValue;
}

// 查找用户，如果不存在则添加
UserInfo* findOrAddUser(const char* phoneNumber) {
    unsigned int index = hash(phoneNumber);  // 获取哈希值对应的索引

    // 查找哈希表
    UserInfo* current = hashTable[index];
    while (current != NULL) {
        if (strcmp(current->phoneNumber, phoneNumber) == 0) {
            return current;  // 找到用户，返回该用户的指针
        }
        current = current->next;
    }

    // 用户不存在，创建新用户
    UserInfo* newUser = (UserInfo*)malloc(sizeof(UserInfo));  // 分配内存
    strcpy(newUser->phoneNumber, phoneNumber);                 // 复制电话号码
    newUser->callCount = 0;                                    // 初始化通话次数为0
    newUser->next = hashTable[index];                          // 插入到链表头部
    hashTable[index] = newUser;

    return newUser;
}

int main() {
   

    int recordCount;
    scanf("%d", &recordCount);  // 读取通话记录的数量

    // 初始化哈希表
    for (int i = 0; i < HASH_TABLE_SIZE; i++) {
        hashTable[i] = NULL;  // 将所有哈希表项初始化为空
    }

    // 读取通话记录并统计通话次数
    for (int i = 0; i < recordCount; i++) {
        char caller[PHONE_LENGTH + 1], callee[PHONE_LENGTH + 1];
        scanf("%s %s", caller, callee);  // 读取主叫和被叫电话号码

        UserInfo* callerUser = findOrAddUser(caller);  // 查找或添加主叫用户
        UserInfo* calleeUser = findOrAddUser(callee);  // 查找或添加被叫用户

        callerUser->callCount++;  // 主叫用户的通话次数加1
        calleeUser->callCount++;  // 被叫用户的通话次数加1
    }


    // 找出通话次数最多的用户
    int maxCallCount = 0;
    int sameCount = 0;
    UserInfo* mostFrequentUser = NULL;

    for (int i = 0; i < HASH_TABLE_SIZE; i++) {  // 遍历整个哈希表
        UserInfo* current = hashTable[i];  // 获取当前哈希桶的第一个用户
        while (current != NULL) {  // 遍历哈希桶中的所有用户
            if (current->callCount > maxCallCount) {  // 发现更大的通话次数
                maxCallCount = current->callCount;  // 更新最大通话次数
                sameCount = 1;  // 重置相同次数的用户计数
                mostFrequentUser = current;  // 更新为当前用户
            }
            else if (current->callCount == maxCallCount) {  // 发现相同的最大通话次数
                sameCount++;  // 计数增加
                // 选择字典序更小的电话号码
                if (mostFrequentUser == NULL || strcmp(current->phoneNumber, mostFrequentUser->phoneNumber) < 0) {
                    mostFrequentUser = current;
                }
            }
            current = current->next;  // 继续遍历当前桶中的下一个用户
        }
    }


    if (sameCount == 1) {
        printf("%s %d\n", mostFrequentUser->phoneNumber, mostFrequentUser->callCount);  // 输出通话次数最多的用户及其通话次数
    }
    else {
        printf("%s %d %d\n", mostFrequentUser->phoneNumber, mostFrequentUser->callCount, sameCount);  // 输出通话次数最多的用户及其通话次数和相同通话次数的用户数量
    }

    // 释放哈希表中的动态内存
    for (int i = 0; i < HASH_TABLE_SIZE; i++) {
        UserInfo* current = hashTable[i];
        while (current != NULL) {
            UserInfo* temp = current;
            current = current->next;
            free(temp);  // 释放每个UserInfo节点的内存
        }
    }

    return 0;
}



