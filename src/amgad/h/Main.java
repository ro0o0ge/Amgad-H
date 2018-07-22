/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amgad.h;

import Controller.LoginController;
import Controller.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.stage.WindowEvent;

/**
 *
 * @author Abdo
 */
public class Main extends Application {

    public Main() {

    }

    private Stage primaryStage;
    private AnchorPane mainLayout;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("مدرسة الأمجاد الخاصة");
            this.primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Main.fxml"));
            mainLayout = loader.load();
            Scene scene = new Scene(mainLayout, 580, 600);
            scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            this.primaryStage.setScene(scene);

            MainController Mcontroller = loader.getController();
            Mcontroller.setMainApp(this);

            this.primaryStage.show();

            this.primaryStage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                System.exit(0);
            });
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("يوجد خطأ");
            alert.setContentText(e.getLocalizedMessage());
            alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            alert.showAndWait();
        }
    }

    public void rootView() {
        root r = new root();
        r.InitRoot();
        this.primaryStage.close();
    }

    public void login() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Login.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));

            dialogStage.setTitle("تسجيل الدخول");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.getPrimaryStage());
            Scene scene = new Scene(page);
            scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            dialogStage.setScene(scene);

            LoginController Lcontroller = loader.getController();
            Lcontroller.setMainApp(this);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
