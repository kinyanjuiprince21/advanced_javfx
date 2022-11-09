package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import models.Country;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML
    private Button btnAddRow;

    @FXML
    private CheckBox chkDemocratic;

    @FXML
    private TableView<Country> tableView;

    @FXML
    private TableColumn<Country, String> tblCapital;

    @FXML
    private TableColumn<Country, String> tblCountry;

    @FXML
    private TableColumn<Country, Boolean> tblDemocratic;

    @FXML
    private TableColumn<Country, Double> tblPopulation;

    @FXML
    private TextField txtCapital;

    @FXML
    private TextField txtCountry;

    @FXML
    private TextField txtPopulation;

    @FXML
    private Button btnExit;


    public void initWidgets() {
        tblCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        tblCapital.setCellValueFactory(new PropertyValueFactory<>("capital"));
        tblPopulation.setCellValueFactory(new PropertyValueFactory<>("population"));
        tblDemocratic.setCellValueFactory(new PropertyValueFactory<>("democratic"));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initWidgets();

        ObservableList<Country> data = FXCollections.observableArrayList(
                new Country("Kenya", "Nairobi",50.0,true),
                new Country("Uganda","Kampala",30.0,true),
                new Country("Ethiopia","Addis Ababa",60.0,true)
        );
        tableView.setItems(data);
        tableView.setEditable(true);
        tblCapital.setCellFactory(TextFieldTableCell.forTableColumn());
        tblCapital.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Country,String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Country, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setCountry(
                        event.getNewValue()
                );
            }
        });
        btnAddRow.setOnAction(e -> {
            data.add(new Country(txtCountry.getText(), txtCapital.getText(), Double.parseDouble(txtPopulation.getText()), chkDemocratic.isSelected()));
            txtCountry.clear();
            txtCapital.clear();
            txtPopulation.clear();
        });
        btnExit.setOnAction(e -> {
            try {
                SplitPaneController.loadMainWindow(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
