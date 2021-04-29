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
 * THE VIEW
 * Class that will draw our VIEW side of our APP.
 */
public class MainView {
    public JFrame  jFrameMain =      null;
    public JLabel  jLabel     =      null;
    public JButton jButtonProperty    =      null;
    public JButton jButtonCreateFloor   =      null;
    public JButton jButtonExit   =      null;
    public JButton jButtonBuilding   =      null;
    public JButton jButtonBungalow   =      null;
    public JButton jButtonComplex   =      null;
    public JButton jButtonCalculatePrice =null;
    public JPanel  panelCenter=      null;
    public JPanel  panelEast  =      null;
    public JTextField jTextFieldEIR=null;
    /*private Building building=null;
    private Complex complex=null;
    private Bungalow bungalow=null;*/
    public Property property=null;

    public JPanel panelCreatePropertyForm = null;

    private MainViewEventsAdmin mainViewEventsAdmin;


    public MainView(){
        mainViewEventsAdmin=new MainViewEventsAdmin(this);
        initScreen();
    }

    public void initScreen(){
        jFrameMain=new JFrame();
        jFrameMain.addWindowListener(mainViewEventsAdmin);

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
        jButtonProperty.addActionListener(mainViewEventsAdmin);

        jButtonCreateFloor=new JButton();
        jButtonCreateFloor.setEnabled(false);
        jButtonCreateFloor.setText("Create Floor");
        jButtonCreateFloor.addActionListener(mainViewEventsAdmin);

        jButtonExit=new JButton();
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(mainViewEventsAdmin);

        jButtonBuilding=new JButton();
        jButtonBuilding.setText("Create Building");
        jButtonBuilding.addActionListener(mainViewEventsAdmin);

        jButtonBungalow=new JButton();
        jButtonBungalow.setText("Create Bungalow");
        jButtonBungalow.addActionListener(mainViewEventsAdmin);

        jButtonComplex=new JButton();
        jButtonComplex.setText("Create Complex");
        jButtonComplex.addActionListener(mainViewEventsAdmin);

        jButtonCalculatePrice=new JButton();
        jButtonCalculatePrice.setEnabled(false);
        jButtonCalculatePrice.setText("GET PROPERTY PRICE");
        jButtonCalculatePrice.addActionListener(mainViewEventsAdmin);
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


}
