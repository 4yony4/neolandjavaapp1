package com.neoland;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal implements ActionListener {
    private JFrame jFrameMain;
    private JLabel jLabel;
    private JButton jButton;
    private JButton jButton2;

    public static void main(String args[]){
        Principal principal=new Principal();
        principal.initScreen();
    }

    public Principal(){
        System.out.println(mathSum(5,10));
        System.out.println(mathSum(13.5,22.78));
    }

    public void initScreen(){
        jFrameMain=new JFrame();

        //START PANEL CENTER CREATION
        JPanel panelCenter=new JPanel();
        //panelCenter.setLayout(new BorderLayout());
        panelCenter.setPreferredSize(new Dimension(1200, 800));
        panelCenter.setBackground(Color.ORANGE);
        jLabel=new JLabel();
        jLabel.setText("HELLO WORLD");
        panelCenter.add(jLabel, BorderLayout.CENTER);
        //END PANEL CENTER CREATION

        //START PANEL EAST CREATION
        JPanel panelEast=new JPanel();
        panelEast.setPreferredSize(new Dimension(200, 400));
        panelEast.setBackground(Color.blue);
        jButton=new JButton();
        jButton.setText("PRESS ME");
        jButton.addActionListener(this);
        panelEast.add(jButton,BorderLayout.CENTER);

        jButton2=new JButton();
        jButton2.setText("SECOND BTN");
        jButton2.addActionListener(this);
        panelEast.add(jButton2,BorderLayout.SOUTH);
        //END PANEL EAST CREATION

        jFrameMain.add(panelCenter, BorderLayout.CENTER);
        jFrameMain.add(panelEast, BorderLayout.EAST);
        jFrameMain.pack();
        jFrameMain.setVisible(true);
    }

    public int mathSum(int a, int b){
        return a+b;
    }

    public double mathSum(double a, double b){
        return a+b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButtonAction=(JButton)e.getSource();
        if(jButtonAction == jButton){
            jLabel.setText("GOODBYE");
        }
        else if(jButtonAction == jButton2){
            jLabel.setText("WE ARE LEARNING JAVA");
        }


    }
}
