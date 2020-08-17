package main.java.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.internal.instrumentation.Logger;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class InfoController implements Initializable {

    private static Map<String,Object> map=new HashMap<>();

 public void TicketSearch(ActionEvent event) throws IOException {
    System.out.println("车票查询");
    //页面跳转
    Node node = (Node) event.getSource();
    Stage stage = (Stage) node.getScene().getWindow();
    //stage.setMaximized(true);
    stage.close();
    URL resource = getClass().getResource("../../resoures/web/pages/ticketSearch.fxml");
    Parent root = FXMLLoader.load(resource);
    stage.setTitle("TVM");
    stage.setScene(new Scene(root, 1024, 652));
    stage.show();

}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      /*  map.put("fxmlId","#InfoFxml");
        int count = headNavigationId.getChildren().size();
        for (int i = 0; i < count; i++){
            Button btn = (Button) headNavigationId.getChildren().get(i);

            int index = i;
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("点击" + btn.getText());
                }
            });
        }

*/









    }
}
