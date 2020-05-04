package com.company;

import java.awt.image.RasterOp;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        new WindowsClass("queasier",1);
        int step = 1;
        MainWindowsClass windowsClass = new MainWindowsClass();
//        windowsClass.insert();
        windowsClass.insert("这是第1页",step++);
        windowsClass.insert("这是第2页",step++);
        windowsClass.insert("这是第3页",step++);
        windowsClass.insert("这是第4页",step++);
        windowsClass.insert("这是第5页",step++);
        windowsClass.insert("这是第6页",step++);
        windowsClass.show();
    }
}
