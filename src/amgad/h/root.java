/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amgad.h;

import Controller.LoginController;
import Controller.RootViewController;
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
            System.out.println("amgad.h.root.InitRoot()  "+LoginSec.getLoggedUser().getUName());
            
            Management m = new Management();
            StudentAffair sa = new StudentAffair();
            TeachingStaff ts = new TeachingStaff();
            m.setMainApp(this);
            sa.setMainApp(this);
            ts.setMainApp(this);
            
            RootViewController Rcontroller = loader.getController();
            Rcontroller.setMainApp(m,sa,ts);
            

            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
