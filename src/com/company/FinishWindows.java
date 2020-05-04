package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FinishWindows extends JFrame{
    private static  FinishWindows finishWindows= null;
    private FinishWindows(String Answer){
        JPanel paContent = new JPanel(new FlowLayout(FlowLayout.CENTER));
        paContent.setPreferredSize(new Dimension(300, 300));
        this.setLocation(300, 200);
        this.setTitle("Finished");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextField jTextField = new JTextField(Answer);
        paContent.add(jTextField);
        this.setContentPane(paContent);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
//                System.out.println("触发windowClosing事件");

                finishWindows.dispose();
                finishWindows = null;
            }
        });
    }

    public static FinishWindows GetFinish(String Answer){
        if(FinishWindows.finishWindows==null){
            finishWindows = new FinishWindows(Answer);
//            finishWindows.Create(Answer);
        }
        return finishWindows;
    }
}
