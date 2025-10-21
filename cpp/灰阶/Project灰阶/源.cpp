#define _CRT_SECURE_NO_WARNINGS 1
#include<graphics.h>
#include<conio.h>
#include<stdio.h>
#include<mmsystem.h>
IMAGE imgBg;
int main() {
	initgraph(640, 480);
	loadimage(&imgBg, "test.jpg");
	int c;
	for(int x = 0; x < 320; x++) {
		for (int y = 0; y < 480; y++) {
			c = getpixel(x, y);
			c = (0xff0000 - (c & 0xff0000)) | (0x00ff00 - (c & 0x00ff00)) | (0x0000ff - (c & 0x0000ff));
			putpixel(x, y, c);
		}
		_getch();
		closegraph();
	}
}