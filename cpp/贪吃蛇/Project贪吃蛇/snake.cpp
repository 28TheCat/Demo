#define _CRT_SECURE_NO_WARNINGS 1
#include <graphics.h>
#include <conio.h>

void main()
{
	initgraph(640, 480);

	int x = 320;
	int y = 240;

	// 画初始图形
	setcolor(YELLOW);
	setfillcolor(GREEN);
	fillcircle(x, y, 20);

	int c;
	while ((c = _getch()) != 27)
	{	// 先擦掉上次显示的旧图形
		setcolor(BLACK);
		setfillcolor(BLACK);
		fillcircle(x, 240, 20);

		// 根据输入，计算新的坐标
		switch (c)
		{
			  case 72: (x>0?--x:x);break;
			  case 80: x++;break;
			  case 75: (y>0 ? --y:y);break;
			 case 77: ++y;break;
			  
			//////////设置任意热键 
		case 0xE0:
			switch (c = _getch())
			{
			case 75:
				(x > 0 ? --x : x); break;
			case 77:
				x++; break;
				case 72:
				(y>0 ? --y:y);break;
				case 80:
				 ++y;break;
			default:break;
			}
		default:break;
		}
		// 绘制新的图形
		setcolor(YELLOW);
		setfillcolor(GREEN);
		fillcircle(x, 240, 20);

		// 延时
		Sleep(10);
	}

	closegraph();
}
