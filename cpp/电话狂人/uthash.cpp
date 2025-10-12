//#include "uthash.h"
//typedef struct {
//    int key; //可以就只有key不加value
//    int value;
//    UT_hash_handle hh;
//} Hash;
//Hash* hashtable = NULL;
//
//struct Hash* hash_find(int ikey) {
//    struct Hash* tmp;
//    HASH_FIND_INT(hashtable, &ikey, tmp);
//    return tmp;
//}
//void hash_insert(int ikey, int ival) {
//    struct Hash* it = find(ikey);
//    if (it == NULL) {
//        struct Hash* tmp = malloc(sizeof(struct Hash));
//        tmp->key = ikey, tmp->val = ival;
//        HASH_ADD_INT(hashtable, key, tmp);
//    }
//    else {
//        it->val = ival;
//    }
//}
//int hash_delete(int ikey) {
//    struct Hash* it = find(ikey);
//    if (it != NULL) {
//        HASH_DEL(hashtable, it);
//        free(it);
//        it = NULL;
//        return 1;
//    }
//    else {
//        return 0;
//    }
//}
#include<iostream>

int main() {
	int n 
}