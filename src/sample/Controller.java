package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.PopupWindow;

public class Controller {

    @FXML
    private TextField serial_number_d;

    @FXML
    private TextField software_v_d;

    @FXML
    private TextField motoar_serial_number_d;

    @FXML
    private TextField serial_number_b;

    @FXML
    private TextField torque_sensor_serial_number_b;

    @FXML
    private TextField serial_number_r;

    @FXML
    private TextField HMI_board_serial_number_r;

    @FXML
    void onSumbit(ActionEvent event) {
        Alert dg = new Alert(Alert.AlertType.INFORMATION);
        dg.setTitle("Result");
        dg.setContentText("Program successfully tested");
        dg.show();

    }

    @FXML
    void onValidate(ActionEvent event) {
        //int serialNumber_d = Integer.parseInt(serial_number_d.getText());
        //double softwareVersion_d = Double.parseDouble(software_v_d.getText());
        //short motorSerialNumber_d = Short.parseShort(motoar_serial_number_d.getText());
        //int serialNumber_b = Integer.parseInt(serial_number_b.getText());
        //int torqueSensorSerialNumber_b = Integer.parseInt(torque_sensor_serial_number_b.getText());
        //int serialNumber_r = Integer.parseInt(serial_number_r.getText());
        //short HMI_boardSerialNumber_r = Short.parseShort(HMI_board_serial_number_r.getText());

        //System.out.println(serialNumber_d);

    }

}
