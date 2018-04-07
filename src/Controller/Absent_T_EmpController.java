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
public class Absent_T_EmpController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    ComboAbsentType.getItems().removeAll(ComboAbsentType.getItems());
        ComboAbsentType.getItems().addAll("تأخير", "استئذان","عارضة","مرضي","سنوية","غياب");
        ComboAbsentType.getSelectionModel().select(1);
        //remove menubutton from fxml file
        
        ComboTimeType.getItems().removeAll(ComboTimeType.getItems());
        ComboTimeType.getItems().addAll("دقائق", "ايام");
        ComboTimeType.getSelectionModel().select(1);
    }

    @FXML
    private ComboBox ComboAbsentType;
    @FXML
    private ComboBox ComboTimeType;
    
    
}
