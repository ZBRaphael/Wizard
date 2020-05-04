package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowsClass extends JFrame {
    public   WindowsClass next = null;
    public WindowsClass previous = null;

    public String getAnswer() {
        return answer;
    }

    private String answer = null;

    public WindowsClass Next(){
        return this.next;
    }
    public WindowsClass Previous(){
        return this.previous;
    }
    public WindowsClass(String question, Integer step){
        JPanel paContent = new JPanel(new FlowLayout(FlowLayout.CENTER));
        paContent.setPreferredSize(new Dimension(300, 250));
        this.setTitle("step"+step.toString());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        //button

        JButton btn_close = new JButton("Close");
        btn_close.setPreferredSize(new Dimension(200, 25));
        // 向面板中加载按钮
        btn_close.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });

        JButton btn_next = new JButton("Next");
        btn_next.setPreferredSize(new Dimension(200, 25));
        // 向面板中加载按钮

        btn_next.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(next==null){
                    btn_next.setEnabled(false);
                }
                else{
                    next();
                }


            }
        });

        JButton btn_previous = new JButton("Previous");
        btn_previous.setPreferredSize(new Dimension(200, 25));
        // 向面板中加载按钮

        btn_previous.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(previous==null){
                    btn_previous.setEnabled(false);
                }
                else{
                    previous();
                }

            }
        });

        JButton btn_finish = new JButton("Finish");
        btn_finish.setPreferredSize(new Dimension(200, 25));
        // 向面板中加载按钮
        btn_finish.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                finish();
            }
        });

        //Textarea

        JLabel text = new JLabel(question);

        //
        JRadioButton jRadioButton_yes = new JRadioButton("Yes");
        JRadioButton jRadioButton_no = new JRadioButton("No");
        jRadioButton_yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer = "yes";
            }
        });
        jRadioButton_no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer = "no";
            }
        });

        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
//                System.out.println("触发windowClosing事件");

                closeFrame();
            }

            public void windowClosed(WindowEvent e)
            {
//                System.out.println("触发windowClosed事件");
            }
        });
        paContent.add(text);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton_no);
        buttonGroup.add(jRadioButton_yes);
        paContent.add(jRadioButton_yes);
        paContent.add(jRadioButton_no);
//        paContent.add(buttonGroup);
        paContent.add(btn_previous);
        paContent.add(btn_next);
        paContent.add(btn_finish);
        paContent.add(btn_close);

        this.setContentPane(paContent);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    private void closeFrame()
    {
        System.out.println("调用窗体关闭功能");
        int result = JOptionPane.showConfirmDialog(null, "是否要退出？", "退出确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            System.exit(0);
        }
    }
    private void close(){
        closeFrame();
    }
    private void next(){
        this.setVisible(false);
        this.next.setVisible(true);
    }
    private void previous(){
        this.setVisible(false);
        this.previous.setVisible(true);
    }
    private void finish(){
//        System.out.println("finish");
        WindowsClass cur = this;
        String Answer = "";
        while(cur!= null){
            Answer = cur.answer+" "+Answer;
            cur = cur.previous;
        }
        FinishWindows.GetFinish(Answer);
//        System.exit(0);
    }
}
