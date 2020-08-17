package main.java.controller;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    @FXML
    private Label nowDate;
    @FXML
    private Label nowTime;
    @FXML
    private HBox InfoFxml;

    @FXML
    private TicketSearchController ticketSearchFxmlController;
    @FXML
    private LineSearchController lineSearchFxmlController;
    @FXML
    private PriceSearchController priceSearchFxmlController;
    @FXML
    private PassengerController passengerFxmlController;
    @FXML
    private ServiceController serviceFxmlController;
    @FXML
    private TimeTableController timeTableFxmlController;
    public static Pane bodyPane;
    @FXML
    private Pane homeBodyPane;
    public static Node node = null;
    public static HBox infoFxml = null;

    /*车票查询*/
    public void TicketSearch(ActionEvent event) throws IOException {
        System.out.println("车票查询");
        InfoFxml.setVisible(false);
        InfoFxml.setManaged(false);
        System.out.println(bodyPane);
        Node lookup = bodyPane.lookup("#ticketSearchFxml");
        lookup.setVisible(true);
        lookup.setManaged(true);
        ticketSearchFxmlController.timeTest();

        node = lookup;
    }

    /*  线路查询*/
    public void LineSearch(ActionEvent event) throws IOException {
        System.out.println("线路查询");
        InfoFxml.setVisible(false);
        InfoFxml.setManaged(false);
        Node lookup = bodyPane.lookup("#lineSearchFxml");
        lookup.setVisible(true);
        lookup.setManaged(true);
        lineSearchFxmlController.timeTest();
        node = lookup;

    }

    /*  票价查询*/
    public void PriceSearch(ActionEvent event) throws IOException {
        System.out.println("票价查询");
        InfoFxml.setVisible(false);
        InfoFxml.setManaged(false);
        Node lookup = bodyPane.lookup("#priceSearchFxml");
        lookup.setVisible(true);
        lookup.setManaged(true);
        priceSearchFxmlController.timeTest();
        node = lookup;

    }

    /* 乘客须知*/
    public void Passenger(ActionEvent event) throws IOException {
        System.out.println("乘客须知");
        InfoFxml.setVisible(false);
        InfoFxml.setManaged(false);
        Node lookup = bodyPane.lookup("#passengerFxml");
        lookup.setVisible(true);
        lookup.setManaged(true);
        node = lookup;
        passengerFxmlController.timeTest();


    }

    /* 基础服务设施*/
    public void Service(ActionEvent event) throws IOException {
        System.out.println("基础服务设施");
        InfoFxml.setVisible(false);
        InfoFxml.setManaged(false);
        Node lookup = bodyPane.lookup("#serviceFxml");
        lookup.setVisible(true);
        lookup.setManaged(true);
        node = lookup;
        serviceFxmlController.timeTest();

    }

    /* 首末班时刻表*/
    public void TimeTable(ActionEvent event) throws IOException {
        System.out.println("首末班时刻表");
        InfoFxml.setVisible(false);
        InfoFxml.setManaged(false);
        Node lookup = bodyPane.lookup("#timeTableFxml");
        lookup.setVisible(true);
        lookup.setManaged(true);
        node = lookup;
        timeTableFxmlController.timeTest();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        infoFxml = InfoFxml;
        bodyPane = homeBodyPane;


        Date now = new Date();
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd ");
        // Model Data
        String dateTimeString = df.format(now);
        nowDate.setText(dateTimeString);


        DateFormat dtime = new SimpleDateFormat(" HH:mm:ss");
        EventHandler<ActionEvent> eventHandler = e -> {
            // Model Data
            Date time = new Date();
            String TimeString = dtime.format(time);
            nowTime.setText(TimeString);
            //System.out.println(TimeString);
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


    }
}
