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
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class GradesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComboYear.getItems().removeAll(ComboYear.getItems());
        //add from table study years
        
//        ComboYear.getItems().addAll("العنوان", "التاريخ");
//        ComboYear.getSelectionModel().select(1);
        
        ComboSubject.getItems().removeAll(ComboSubject.getItems());
        //add from table subjecs
        
//        ComboSubject.getItems().addAll("العنوان", "التاريخ");
//        ComboSubject.getSelectionModel().select(1);
    }

    @FXML
    private ComboBox ComboYear;    
    
    @FXML
    private ComboBox ComboSubject;   
}
