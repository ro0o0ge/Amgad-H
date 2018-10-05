/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import amgad.h.root;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Abdo
 */
public class ViewImageController implements Initializable {

    @FXML
    ImageView i;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        try {
            i.setImage(new Image(new File(root.f.getPath()).toURI().toString()));
        } catch (Exception e) {
            System.out.println("Image not Found "+ (root.f.getPath()));
        }

    }

}
