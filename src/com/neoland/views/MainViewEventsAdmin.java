package com.neoland.views;

import com.neoland.infraestructure.Building;
import com.neoland.infraestructure.Bungalow;
import com.neoland.infraestructure.Complex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * MY CONTROLLER
 */
public class MainViewEventsAdmin implements ActionListener, WindowListener {

    private MainView mainView;

    public MainViewEventsAdmin(MainView mainView){
        this.mainView=mainView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //JButton jButtonAction=(JButton)e.getSource();
        if(e.getSource() == mainView.jButtonProperty){
            mainView.panelCreatePropertyForm.setVisible(true);
        }
        else if(e.getSource() == mainView.jButtonExit){
            //jLabel.setText("WE ARE LEARNING JAVA");
            System.exit(0);
        }
        else if(e.getSource() == mainView.jButtonBuilding){
            if(mainView.property==null){
                mainView.property=new Building(mainView.jTextFieldEIR.getText());
                mainView.property.addNewFloor(4);
                mainView.property.addNewFloor(4);
                mainView.property.addNewFloor(4);
                mainView.jLabel.setText("JUST CREATED A BUILDING WITH EIR: "+mainView.jTextFieldEIR.getText());
                mainView.jButtonCalculatePrice.setEnabled(true);
                mainView.jButtonCreateFloor.setEnabled(true);
            }
            else{
                mainView.jLabel.setText("YOU ALREADY CREATED A BUILDING  ");
            }

        }
        else if(e.getSource() == mainView.jButtonBungalow){
            mainView.property=new Bungalow(mainView.jTextFieldEIR.getText());
            mainView.jButtonCalculatePrice.setEnabled(true);
            mainView.jButtonCreateFloor.setEnabled(true);
            mainView.jLabel.setText("JUST CREATED A Bungalow WITH EIR: "+mainView.jTextFieldEIR.getText());
        }
        else if(e.getSource() == mainView.jButtonComplex){
            mainView.property=new Complex(mainView.jTextFieldEIR.getText());
            mainView.jButtonCalculatePrice.setEnabled(true);
            mainView.jButtonCreateFloor.setEnabled(true);
            mainView.jLabel.setText("JUST CREATED A Complex WITH EIR: "+mainView.jTextFieldEIR.getText());
        }
        else if(e.getSource()==mainView.jButtonCalculatePrice){
            double finalPrice=mainView.property.getdPrice();
            mainView.jLabel.setText("THE PRICE IS: "+finalPrice);

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
}
