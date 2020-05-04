package com.company;

import javax.swing.plaf.synth.SynthListUI;
import java.awt.image.RasterOp;

public class MainWindowsClass {
    public WindowsClass head;
    public WindowsClass tail;
    private Integer step = 1;
    public MainWindowsClass(){
        head = new WindowsClass("Welcome to this Wizard",0);
        tail = head;
    }
//    insert("这是第一页wizard",setp);
    public void insert(String question,Integer step){

        WindowsClass cur = new WindowsClass(question,step);
        this.step++;
        tail.next = cur;
        cur.previous = tail;
        tail = tail.Next();
    }
    public void show(){
        head.setVisible(true);
    }

}
