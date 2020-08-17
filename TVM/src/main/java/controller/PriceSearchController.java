package main.java.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PriceSearchController implements Initializable {

    @FXML
    private Pane lineImg;
    @FXML
    private HBox lineButton;
    @FXML
    private TimeCountController timeCountController;
    public void timeTest(){
        timeCountController.timeTest();
    }

    @FXML
    /*返回*/
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
    /* 点击线路按钮*/
    public void initialize(URL location, ResourceBundle resources) {
        //遍历线路按钮
        int count = lineButton.getChildren().size();

        for(int i=0;i<count;i++){
            ImageView img = (ImageView) lineButton.getChildren().get(i);
            int index = i;
            img.setOnMouseClicked(new EventHandler () {
                @Override
                public void handle(Event event) {
                    System.out.println("点击" +index);

                    for(int j=0;j<count;j++){
                        if(index==j){
                            lineImg.getChildren().get(j).setVisible(true);
                            lineImg.getChildren().get(j).setManaged(true);
                        }else{
                            lineImg.getChildren().get(j).setVisible(false);
                            lineImg.getChildren().get(j).setManaged(false);
                        }
                    }



                }


            });
        }
    }
}

