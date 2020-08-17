package main.java.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class TicketSearchController implements Initializable {
    @FXML
    private TimeCountController timeCountController;

    public void timeTest(){
        timeCountController.timeTest();
    }

 /*返回主页*/
    @FXML
    public void back(){
       timeCountController.stop();
       /* Node looker = HomeController.bodyPane.lookup("#ticketSearchFxml");
        HomeController.node=looker;*/
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
