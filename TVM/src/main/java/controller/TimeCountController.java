package main.java.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class TimeCountController implements Initializable {
    @FXML

    private Label timeCount;

    private String S = "";
    private int tmp = 300;
    public static Timeline animation;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public  void timeTest(){
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> timelabel()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    private void timelabel() {
        tmp--;
        S = tmp + "";
        timeCount.setText(S);
        if(tmp == 0 ){
            if(HomeController.node!=null){
                HomeController.node.setVisible(false);
                HomeController.node.setManaged(false);
                if(HomeController.infoFxml !=null){
                    HomeController.infoFxml.setVisible(true);
                    HomeController.infoFxml.setManaged(true);
                }
            }
            tmp=300;
            return;
        }
    }
    public void stop(){
        animation.stop();
        animation=null;
        tmp=300;
        timeCount.setText("300");

}



}
