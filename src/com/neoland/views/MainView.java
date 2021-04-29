package com.neoland.views;

import com.neoland.infraestructure.Building;
import com.neoland.infraestructure.Bungalow;
import com.neoland.infraestructure.Complex;
import com.neoland.infraestructure.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Class that will draw our VIEW side of our APP.
 */
public class MainView implements ActionListener, WindowListener {
    private JFrame  jFrameMain =      null;
    private JLabel  jLabel     =      null;
    private JButton jButtonProperty    =      null;
    private JButton jButtonCreateFloor   =      null;
    private JButton jButtonExit   =      null;
    private JButton jButtonBuilding   =      null;
    private JButton jButtonBungalow   =      null;
    private JButton jButtonComplex   =      null;
    private JButton jButtonCalculatePrice =null;
    private JPanel  panelCenter=      null;
    private JPanel  panelEast  =      null;
    private JTextField jTextFieldEIR=null;
    /*private Building building=null;
    private Complex complex=null;
    private Bungalow bungalow=null;*/
    private Property property=null;

    private JPanel panelCreatePropertyForm = null;


    public MainView(){
        initScreen();
    }

    public void initScreen(){
        jFrameMain=new JFrame();
        jFrameMain.addWindowListener(this);

        initPanels();
        initLabels();
        initButtons();
        initTextField();
        linkComponents();

        jFrameMain.pack();
        jFrameMain.setVisible(true);
    }

    /**
     * This function creates the Panels
     */
    private void initPanels(){
        panelCenter=new JPanel();
        //panelCenter.setLayout(new BorderLayout());
        panelCenter.setPreferredSize(new Dimension(1200, 800));
        panelCenter.setBackground(Color.ORANGE);

        panelEast=new JPanel();
        //panelEast.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        panelEast.setLayout(new GridLayout(0,1,0,10));
        panelEast.setPreferredSize(new Dimension(200, 400));
        panelEast.setBackground(Color.blue);

        panelCreatePropertyForm=new JPanel();
        //panelCreatePropertyForm.setLayout(new BorderLayout());
        panelCreatePropertyForm.setPreferredSize(new Dimension(1200, 800));
        panelCreatePropertyForm.setVisible(false);
    }

    /**
     * This function creates the Labels
     */
    private void initLabels(){
        jLabel=new JLabel();
        jLabel.setText("PROPERTY CREATION SIMULATOR");
    }

    private void initButtons(){
        jButtonProperty=new JButton();
        jButtonProperty.setText("Create Property");
        jButtonProperty.addActionListener(this);

        jButtonCreateFloor=new JButton();
        jButtonCreateFloor.setEnabled(false);
        jButtonCreateFloor.setText("Create Floor");
        jButtonCreateFloor.addActionListener(this);

        jButtonExit=new JButton();
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(this);

        jButtonBuilding=new JButton();
        jButtonBuilding.setText("Create Building");
        jButtonBuilding.addActionListener(this);

        jButtonBungalow=new JButton();
        jButtonBungalow.setText("Create Bungalow");
        jButtonBungalow.addActionListener(this);

        jButtonComplex=new JButton();
        jButtonComplex.setText("Create Complex");
        jButtonComplex.addActionListener(this);

        jButtonCalculatePrice=new JButton();
        jButtonCalculatePrice.setEnabled(false);
        jButtonCalculatePrice.setText("GET PROPERTY PRICE");
        jButtonCalculatePrice.addActionListener(this);
    }

    private void initTextField(){
        jTextFieldEIR=new JTextField("WRITE EIR CODE FOR PROPERTY");
    }

    /**
     * This function links the created visual elements to each other.
     * !!IMPORTANT!! you have to use it AFTER the initializations.
     */
    private void linkComponents(){
        panelCenter.add(jLabel, BorderLayout.CENTER);
        panelCenter.add(panelCreatePropertyForm,BorderLayout.CENTER);
        panelCreatePropertyForm.add(jButtonBuilding,BorderLayout.WEST);
        panelCreatePropertyForm.add(jButtonBungalow,BorderLayout.SOUTH);
        panelCreatePropertyForm.add(jButtonComplex,BorderLayout.EAST);
        panelCreatePropertyForm.add(jTextFieldEIR,BorderLayout.CENTER);
        panelEast.add(jButtonProperty);
        panelEast.add(jButtonCreateFloor);
        panelEast.add(jButtonCalculatePrice);
        panelEast.add(jButtonExit);
        jFrameMain.add(panelCenter, BorderLayout.CENTER);
        jFrameMain.add(panelEast, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //JButton jButtonAction=(JButton)e.getSource();
        if(e.getSource() == jButtonProperty){
            panelCreatePropertyForm.setVisible(true);
        }
        else if(e.getSource() == jButtonExit){
            //jLabel.setText("WE ARE LEARNING JAVA");
            System.exit(0);
        }
        else if(e.getSource() == jButtonBuilding){
            if(property==null){
                property=new Building(jTextFieldEIR.getText());
                property.addNewFloor(4);
                property.addNewFloor(4);
                property.addNewFloor(4);
                jLabel.setText("JUST CREATED A BUILDING WITH EIR: "+jTextFieldEIR.getText());
                jButtonCalculatePrice.setEnabled(true);
                jButtonCreateFloor.setEnabled(true);
            }
            else{
                jLabel.setText("YOU ALREADY CREATED A BUILDING  ");
            }

        }
        else if(e.getSource() == jButtonBungalow){
            property=new Bungalow(jTextFieldEIR.getText());
            jButtonCalculatePrice.setEnabled(true);
            jButtonCreateFloor.setEnabled(true);
            jLabel.setText("JUST CREATED A Bungalow WITH EIR: "+jTextFieldEIR.getText());
        }
        else if(e.getSource() == jButtonComplex){
            property=new Complex(jTextFieldEIR.getText());
            jButtonCalculatePrice.setEnabled(true);
            jButtonCreateFloor.setEnabled(true);
            jLabel.setText("JUST CREATED A Complex WITH EIR: "+jTextFieldEIR.getText());
        }
        else if(e.getSource()==jButtonCalculatePrice){
            double finalPrice=property.getdPrice();
            jLabel.setText("THE PRICE IS: "+finalPrice);

        }

    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);

    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
