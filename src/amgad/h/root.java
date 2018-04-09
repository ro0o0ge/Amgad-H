/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amgad.h;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Util.LoginSec;

/**
 *
 * @author Abdo
 */
public class root {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public void InitRoot() {
        try {
            this.primaryStage = new Stage();
            this.primaryStage.setTitle("مدرسة الأمجاد الخاصة");
            this.primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/resources/6.jpg")));
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Root.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout, 580, 600);
            scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            this.primaryStage.setScene(scene);
            System.out.println("amgad.h.root.InitRoot()  "+LoginSec.getLoggedUser().getUName() );
//            MainController Mcontroller = loader.getController();
//            
//            Mcontroller.setMainApp(this);
            
            this.primaryStage.show();
            
//            Parent root = FXMLLoader.load(getClass().getResource("/View/Root.fxml"));
//            Stage dialogStage = new Stage();
//            dialogStage.getIcons().add(new Image(root.class.
//                    getResourceAsStream("/resources/6.jpg")));
//            dialogStage.setTitle("مدرسة الأمجاد الخاصة");
//            dialogStage.initModality(Modality.WINDOW_MODAL);
////            dialogStage.initOwner(MainApp.getPrimaryStage());
//            Scene scene = new Scene(root);
//            scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
//            dialogStage.setScene(scene);
//            // Show the dialog and wait until the user closes it
////            this.ah.getPrimaryStage()
//            dialogStage.show();
            // return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
