package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private CheckMenuItem chkCheck;

    @FXML
    private ToggleGroup color;

    @FXML
    private MenuItem mnAbout;

    @FXML
    private MenuItem mnClose;

    @FXML
    private Menu mnColor;

    @FXML
    private MenuItem mnDelete;

    @FXML
    private Menu mnEdit;

    @FXML
    private Menu mnHelp;

    @FXML
    private MenuItem mnMac;

    @FXML
    private MenuItem mnNew;

    @FXML
    private MenuItem mnOpen;

    @FXML
    private MenuItem mnPrint;

    @FXML
    private MenuItem mnUnix;

    @FXML
    private MenuItem mnWindows;

    @FXML
    private RadioMenuItem rbtBlue;

    @FXML
    private RadioMenuItem rbtGreen;

    @FXML
    private RadioMenuItem rbtRed;

    @FXML
    private VBox vBoxMain;

    @FXML
    private MenuBar mnbBar;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ContextMenu contextMenu = new ContextMenu();
        ImageView imageViewNew = new ImageView("resources/newFile.png");
        ImageView imageViewOpen = new ImageView("resources/open.png");
        ImageView imageViewPrint = new ImageView("resources/print.png");

        imageViewNew.setFitWidth(20.0);
        imageViewNew.setFitHeight(20.0);
        imageViewOpen.setFitWidth(20.0);
        imageViewOpen.setFitHeight(20.0);
        imageViewPrint.setFitWidth(20.0);
        imageViewPrint.setFitHeight(20.0);

        MenuItem menuItemNew = new MenuItem("New", imageViewNew);
        MenuItem menuItemOpen = new MenuItem("Open",imageViewOpen );
        MenuItem menuItemPrint = new MenuItem("Print", imageViewPrint);

        menuItemNew.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        menuItemOpen.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        menuItemPrint.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));

        contextMenu.getItems().addAll(menuItemNew,menuItemOpen,menuItemPrint);

        vBoxMain.setOnContextMenuRequested(e ->
            contextMenu.show(vBoxMain.getScene().getWindow(),e.getScreenX(),e.getScreenY())
        );

        mnOpen.setOnAction(e -> {
            try {
                loadSplitWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        mnNew.setOnAction(e -> {
            try {
                loadTabWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        mnAbout.setOnAction(e -> {
            try {
                loadTableView();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void loadWindow(String viewPath, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(viewPath));
        Stage stage = (Stage) mnbBar.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
    public void loadSplitWindow() throws IOException {
        loadWindow("/views/splitpane.fxml","SplitPane");
    }

    public void loadTabWindow() throws IOException {
        loadWindow("/views/tabpane.fxml","Tab Pane");
    }

    public void loadTableView() throws IOException {
        loadWindow("/views/table.fxml","Table View");
    }

    public void print() {
        PrinterJob job = PrinterJob.createPrinterJob();

        if(job != null && job.showPrintDialog(vBoxMain.getScene().getWindow())) {
            Printer printer = job.getPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE,Printer.MarginType.HARDWARE_MINIMUM);

        }
    }
}
