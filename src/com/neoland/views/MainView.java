package com.neoland.views;

import com.neoland.dataclass.User;
import com.neoland.infraestructure.Building;
import com.neoland.infraestructure.Bungalow;
import com.neoland.infraestructure.Complex;
import com.neoland.infraestructure.Property;
import com.neoland.model.DBAdmin;
import com.neoland.model.DBAdminListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

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
    public Property propertyGlobal=null;
    public int iPropertyCreationType=0;

    public JPanel panelCreatePropertyForm = null;

    private MainViewEventsAdmin mainViewEventsAdmin;

    DBAdmin dbAdmin;

    public MainView(DBAdmin dbAdmin){
        mainViewEventsAdmin=new MainViewEventsAdmin();

        initScreen();

        this.dbAdmin=dbAdmin;
        dbAdmin.addListener(mainViewEventsAdmin);
        //dbAdmin.initPostgresConnection();
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

    public class MainViewEventsAdmin implements ActionListener, WindowListener, DBAdminListener {
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
                //if(propertyGlobal==null){
                    iPropertyCreationType=1;
                    dbAdmin.getPropertyByEIRCode(jTextFieldEIR.getText());
                //}
                //else{
               //     jLabel.setText("YOU ALREADY CREATED A PROPERTY  ");
                //}

            }
            else if(e.getSource() == jButtonBungalow){
                //if(propertyGlobal==null){
                    iPropertyCreationType=2;
                    dbAdmin.getPropertyByEIRCode(jTextFieldEIR.getText());
                //}
               // else{
                    jLabel.setText("YOU ALREADY CREATED A PROPERTY  ");
                //}

            }
            else if(e.getSource() == jButtonComplex){
                //if(propertyGlobal==null){
                    iPropertyCreationType=3;
                    dbAdmin.getPropertyByEIRCode(jTextFieldEIR.getText());
                //}
                //else{
                //    jLabel.setText("YOU ALREADY CREATED A PROPERTY  ");
                //}


            }
            else if(e.getSource()==jButtonCalculatePrice){
                double finalPrice=propertyGlobal.getdPrice();
                jLabel.setText("THE PRICE IS: "+finalPrice);

            }
        }

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }

        @Override
        public void conexionSuccess(boolean blSuccess) {
            jLabel.setText("THE CONEXION WAS "+blSuccess);
            System.out.println("MAIN VIEW LISTENER: ->> CONEXION WAS: "+blSuccess);
        }

        @Override
        public void dbResponseUsers(HashMap<String, User> mapUsers) {
            System.out.println("MAIN VIEW LISTENER: ->> USERS ARE: "+mapUsers);
            jLabel.setText("FIRST USER NAME: "+mapUsers.get("1").iname);
        }

        @Override
        public void dbResponseProperyElement(Property property) {

            if(property==null){
                if(iPropertyCreationType==1){
                    property=new Building(jTextFieldEIR.getText());
                }
                else if(iPropertyCreationType==2){
                    property=new Bungalow(jTextFieldEIR.getText());
                }
                else if(iPropertyCreationType==3){
                    property=new Complex(jTextFieldEIR.getText());
                }

                jLabel.setText("JUST CREATED A PROPERTY WITH EIR: "+jTextFieldEIR.getText());
                dbAdmin.insertProperty(property);

            }
            else{
                jLabel.setText("PROPERTY ALREADY EXISTS "+jTextFieldEIR.getText());
            }

            propertyGlobal=property;
            //property.addNewFloor(4);
            //property.addNewFloor(4);
            //property.addNewFloor(4);

            jButtonCalculatePrice.setEnabled(true);
            jButtonCreateFloor.setEnabled(true);
            //System.out.println("MAIN VIEW LISTENER: ->> PROPERTY IS: "+property);
        }
    }
}


