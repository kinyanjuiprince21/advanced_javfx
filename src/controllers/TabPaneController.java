package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TabPaneController implements Initializable {

    @FXML
    private ImageView imgNew;

    @FXML
    private ImageView imgOpen;

    @FXML
    private ImageView imgPrint;

    @FXML
    private Label lblNewText;

    @FXML
    private Label lblOpen;

    @FXML
    private Label lblPrint;

    @FXML
    private Tab tbNew;

    @FXML
    private Tab tbOpen;

    @FXML
    private Tab tbPrint;

    @FXML
    private Button btnExit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblNewText.setText("New tab is selected");
        Image imageNew = new Image("/resources/newFile.png");
        imgNew.setImage(imageNew);

        lblOpen.setText("Open tab is selected");
        Image imageOpen = new Image("/resources/open.png");
        imgOpen.setImage(imageOpen);

        lblPrint.setText("Print tab is selected");
        Image imagePrint = new Image("/resources/print.png");
        imgPrint.setImage(imagePrint);


        btnExit.setOnAction(e -> {
            try {
                SplitPaneController.loadMainWindow(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
