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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Abdo
 */
public class Management {
    private Main MainApp;

	public void setMainApp(Main mainApp) {
		this.MainApp = mainApp;
	}
        
        public void ShowCode1() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader(
					Main.class.getResource("/view/Code/CodeSafe.fxml"));
			// loader.setLocation(Main.class.getResource("/view/Code/CodeSafe.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

//			CodeSafeController controller = loader.getController();

//			controller.setMainApp(MainApp);
//			controller.setSafe(cs);

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.getIcons().add(
					new Image(Main.class
							.getResourceAsStream("/view/Icon-1.png")));
			dialogStage.setTitle("تكويد الخزن");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(MainApp.getPrimaryStage());
			Scene scene = new Scene(page);
			scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
			dialogStage.setScene(scene);
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();
			// return controller.isOkClicked();
//			return true;
		} catch (IOException e) {
			e.printStackTrace();
//			return false;
		}
	}
}
