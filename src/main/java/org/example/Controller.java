package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import org.example.Sort.*;
import org.example.test.Test;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> sortMethodChoose;

    @FXML
    private Button startButton;

    @FXML
    private Button drawGrafButton;

    @FXML
    private Button aboutButton;

    @FXML
    private LineChart graf;

    private ObservableList<XYChart.Data<Integer, Long>> datas = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        ObservableList<String> lang = FXCollections.observableArrayList("Сортировка Шелла","Шейкерная сортировка",
                "Быстрая сортировка", "Сортировка вставками","Сортировка расчёской");
        sortMethodChoose.setItems(lang);

        Test test = new Test(1000);

        startButton.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {



            switch (sortMethodChoose.getSelectionModel().getSelectedItem()){
                case "Сортировка Шелла": test.StartSort(1000,new ShellSortMethod());
                break;

                case "Шейкерная сортировка": test.StartSort(1000, new ShakerSortMethod());
                break;

                case "Быстрая сортировка": test.StartSort(1000, new QuickSortMethod());
                break;

                case "Сортировка вставками": test.StartSort(1000, new InsertionSortMethod());
                break;

                case "Сортировка расчёской": test.StartSort(1000, new CombSortMethod());
                break;
            }

            datas.clear();
            graf.getData().clear();

            XYChart.Series series1 = new XYChart.Series();
            //series1.setName("Time series");

            for (int i=0; i<test.getTimeRes().size();i++){
                datas.add(new XYChart.Data(i,test.getTimeRes().get(i)));
            }
            series1.setData(datas);
            graf.getData().setAll(series1);
            graf.setVisible(true);

        });


/*ObservableList<XYChart.Data> data = FXCollections.observableArrayList();

                for (int i=0;i<test.getTimeRes().size();i++){
                    data.add(new XYChart.Data(i,test.getTimeRes().get(i)));
                }*/





    }
}
