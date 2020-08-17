package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ServiceController implements Initializable {
    @FXML
    private TimeCountController timeCountController;
    public void timeTest(){
        timeCountController.timeTest();
    }


    @FXML
    public void back(){
        timeCountController.stop();
        if(HomeController.node!=null){
            HomeController.node.setVisible(false);
            HomeController.node.setManaged(false);
            if(HomeController.infoFxml !=null){
                HomeController.infoFxml.setVisible(true);
                HomeController.infoFxml.setManaged(true);
            }



        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
