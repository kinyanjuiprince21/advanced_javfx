package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import run.Main;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplitPaneController implements Initializable {

    @FXML
    private ImageView imgImage;

    @FXML
    private ToggleGroup menusOption;

    @FXML
    private RadioButton rbtNew;

    @FXML
    private RadioButton rbtOpen;

    @FXML
    private RadioButton rbtPrint;

    @FXML
    private TextArea txtText;

    @FXML
    private Button btnExit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image newImage = new Image("/resources/newFile.png");
        imgImage.setImage(newImage);
        rbtNew.setOnAction(e -> {
            imgImage.setImage(newImage);
            txtText.setText("New radiobutton was clicked!");
        });

        rbtOpen.setOnAction(e -> {
            Image openImage = new Image("/resources/open.png");
            imgImage.setImage(openImage);
            txtText.setText("Open radiobutton was clicked!");
        });

        rbtPrint.setOnAction(e -> {
            Image printImage = new Image("/resources/print.png");
            imgImage.setImage(printImage);
            txtText.setText("Print radiobutton was clicked!");
        });


        btnExit.setOnAction(e -> {
            try {
                loadMainWindow(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public static void loadMainWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(SplitPaneController.class.getResource("/views/menus.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("File explorer");
        stage.show();
    }
}
