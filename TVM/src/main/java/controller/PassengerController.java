package main.java.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.security.auth.callback.Callback;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PassengerController implements Initializable {
    @FXML
    private Pane passengerImg;
    @FXML
    public VBox passengerButton;

    @FXML
    private Pagination pagination;
    @FXML
    private  Pane firstBox;
    @FXML
    private TimeCountController timeCountController;
    public void timeTest(){
        timeCountController.timeTest();
    }



    @FXML
   /* 返回*/
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

        //当前选中第一页
        pagination.setCurrentPageIndex(0);
        //小圆圈
        //pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
        pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("当前第"+newValue.intValue()+"页");
                //当前页数
                int pagenum =newValue.intValue();
                for(int i=0;i<passengerButton.getChildren().size();i++){
                    if(pagenum==i){
                        System.out.println("第"+i+"张图片出现");
                        firstBox.getChildren().get(i).setManaged(true);
                        firstBox.getChildren().get(i).setVisible(true);
                    }else{
                        firstBox.getChildren().get(i).setManaged(false);
                        firstBox.getChildren().get(i).setVisible(false);
                    }
                }
            }
        });



        /* 点击右侧按钮*/
        //遍历右侧按钮
        int count = passengerButton.getChildren().size();
         for(int i=0;i<count;i++){
            ImageView img = (ImageView) passengerButton.getChildren().get(i);
             int index = i;
            img.setOnMouseClicked(new EventHandler() {
                @Override
                public void handle(Event event) {
                    System.out.println("当前右侧点击第" +index);
                 if(index==1||index==3){
                     pagination.setPageCount(3);
                 }else   if(index==0||index==2){
                     pagination.setPageCount(4);
                 }



                    for(int j=0;j<count;j++){
                        if(index==j){
                            passengerImg.getChildren().get(j).setVisible(true);
                            passengerImg.getChildren().get(j).setManaged(true);
                            Pane panNode = (Pane)passengerImg.getChildren().get(j);
                            //当前选中第一页
                            pagination.setCurrentPageIndex(0);
                            //小圆圈
                           // pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
                            pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
                                @Override
                                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                                    System.out.println("当前分页"+newValue.intValue());
                                    //当前页数
                                    int pagenum =newValue.intValue();
                                    for(int i=0;i<panNode.getChildren().size();i++){
                                        if(pagenum==i){
                                            System.out.println("第"+i+"张出现");
                                            panNode.getChildren().get(i).setManaged(true);
                                            panNode.getChildren().get(i).setVisible(true);
                                        }else{
                                            panNode.getChildren().get(i).setManaged(false);
                                            panNode.getChildren().get(i).setVisible(false);
                                        }
                                    }
                                }
                            });

                        }else{
                            passengerImg.getChildren().get(j).setVisible(false);
                            passengerImg.getChildren().get(j).setManaged(false);
                        }
                    }
                }
            });
        }







    }




}
