 package Controller;
 
 import amgad.h.Management;
 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.CheckBox;
 import javafx.scene.control.Label;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class EditEmpPayrollStatusController
   implements Initializable
 {
   @FXML
   Label name;
   @FXML
   Label date;
   @FXML
   CheckBox status;
   
   public void initialize(URL url, ResourceBundle rb) {
/* 38 */     System.out.println("name " + Management.getEditPayrollStatus().getPId().getName());
/* 39 */     this.name.setText(Management.getEditPayrollStatus().getPId().getName());
/* 40 */     this.date.setText(Management.getEditPayrollStatus().getPrDate().toString());
/* 41 */     this.status.setSelected(Management.getEditPayrollStatus().getPrStatus());
   }
   
   @FXML
   public void handleDone() {
/* 46 */     Management TS = new Management();
/* 47 */     Management.getEditPayrollStatus().setPrStatus(this.status.isSelected());
/* 48 */     TS.UpdatePenaltyStatus();
/* 49 */     Management.getDialogStage2().close();
   }
 }


/* Location:              C:\Users\Abdo\Documents\Amgad-H.jar!\Controller\EditEmpPayrollStatusController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.0
 */