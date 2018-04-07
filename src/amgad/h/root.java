/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amgad.h;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Abdo
 */
public class root {

    private AmgadH ah = new AmgadH();

    public void setMainApp(AmgadH mainApp) {
        this.ah = mainApp;
    }

    public void InitRoot() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Root.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(root.class.
                    getResourceAsStream("/resources/6.jpg")));
            dialogStage.setTitle("مدرسة الأمجاد الخاصة");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(ah.getPrimaryStage());
            Scene scene = new Scene(root);
            scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            dialogStage.setScene(scene);
            // Show the dialog and wait until the user closes it
//            this.ah.getPrimaryStage()
            dialogStage.show();
            // return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
