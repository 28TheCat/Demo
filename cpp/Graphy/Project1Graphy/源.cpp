#define _CRT_SECURE_NO_WARNINGS 1
#include <conio.h>
#include<graphics.h>
#include<conio.h>
#include<time.h>
int randxy(int n) {//xy初始点随机化
	srand((unsigned)time(NULL) * (unsigned)rand());
	return rand() % n;
}
int RandXY() {//随机角度
	srand((unsigned)time(NULL) + (unsigned)rand());
	int x = rand() % 6;
	while (x == 0) {
		x = rand() % 6;
	}
	return x;
}

int main() {
	initgraph(640, 720);
	setbkcolor(LIGHTBLUE);
	cleardevice();

	int x = randxy(640);
	int y = randxy(720);//xy出生点
	
	int rx = RandXY();//xy随机角度
	int ry = RandXY();

	while (!(_kbhit()&& _getch() == 27)) {
		if ((x + rx + 10) > 640) {//边界检测
			rx = rx - RandXY();
			x = rx + x;
		}
		else if ((x + rx - 10) < 0) {
			rx = RandXY();
			x = rx;
		}
		if ((y + ry + 10) > 720) {//边界检测
			ry = ry - RandXY();
			y = ry + y;
		}
		else if ((y + ry - 10) < 0) {
			ry = RandXY();
			y = ry;
		}
		
		setcolor(LIGHTBLUE);
		setfillcolor(YELLOW);
		fillcircle(x, y, 10);
		Sleep(25);
	
		setfillcolor(LIGHTBLUE);//去除残影
		fillcircle(x, y, 10);
		
		x = rx + x;
		y = ry + y;
	}
	closegraph();
	return 0;
}