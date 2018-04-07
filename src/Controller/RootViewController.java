/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class RootViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
//        Dialogs.create()
//                .title("المروة")
//                .masthead("معلومات")
//                .message(
//                        "بواسطة : عبدالله رمضان \n للتواصل: abdo.ramadan29@gmail.com")
//                .showInformation();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
    