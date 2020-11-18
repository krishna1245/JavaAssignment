package com.fazua.eds.controller;



import com.fazua.eds.exception.ValidationException;
import com.fazua.eds.validator.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class EDSController {

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

    private Validator validate;

    static  boolean serial_number_d_validate;
    static  boolean software_v_d_validate;
    static  boolean motoar_serial_number_d_validate;
    static  boolean serialNumber_b_validate;
    static  boolean torqueNumber_validate;
    static  boolean serialNumber_r_validate;
    static  boolean HMI_boardNumber_validate;

    ArrayList<ValidationException> validationMessageExceptionList;

    private static void clearForm(){
        serial_number_d_validate = false;
        software_v_d_validate = false;
        motoar_serial_number_d_validate = false;
        serialNumber_b_validate = false;
        torqueNumber_validate = false;
        serialNumber_r_validate = false;
        HMI_boardNumber_validate = false;
    }
    @FXML
    void onSumbit(ActionEvent event) {
        Alert dg = new Alert(Alert.AlertType.INFORMATION);
        dg.setTitle("Result");
        dg.setContentText("Program successfully tested");
        dg.show();
    }
    @FXML
    void onValidate(ActionEvent event) throws ValidationException {
        validate = new Validator();
        validationMessageExceptionList =new ArrayList<>();
        validationMessageExceptionList.add(new ValidationException("\n ++++ Validation status results +++\n"));
        try {
            serial_number_d_validate = validate.validateSerial_number_d(serial_number_d);
            validationMessageExceptionList.add(new ValidationException("***Drive pack - given Serial number is valid: " +
                    validate.getSerial_number_d()));
            System.out.println(validate.getSerial_number_d());
        }catch (ValidationException e){
            validationMessageExceptionList.add(e);
        }

        try {
            software_v_d_validate = validate.validateSoftwareVersion_d(software_v_d);
            validationMessageExceptionList.add(new ValidationException("***Drive pack - given Software version is valid: " +
                    validate.getSoftware_v_d()));
            System.out.println(validate.getSoftware_v_d());
        }catch (ValidationException e){
            validationMessageExceptionList.add(e);
        }

        try {
            motoar_serial_number_d_validate = validate.validateMotoar_serial_number_d(motoar_serial_number_d);
            validationMessageExceptionList.add(new ValidationException("***Drive pack - given Motor serial number is valid: " +
                    validate.getMotoar_serial_number_d()));
            System.out.println(validate.getMotoar_serial_number_d());
        }catch (ValidationException e){
            validationMessageExceptionList.add(e);
        }

        try {
            serialNumber_b_validate = validate.validateSerial_number_b(serial_number_b);
            validationMessageExceptionList.add(new ValidationException("***Bottom bracket - given Serial number is valid: " +
                    validate.getSerial_number_b()));
            System.out.println(validate.getSerial_number_b());
        }catch (ValidationException e){
            validationMessageExceptionList.add(e);
        }

        try {
            torqueNumber_validate = validate.validateTorqueSerialNumber_b(torque_sensor_serial_number_b);
            validationMessageExceptionList.add(new ValidationException("***Bottom bracket - given Torque number is valid: " +
                    validate.getTorque_sensor_serial_number_b()));
            System.out.println(validate.getTorque_sensor_serial_number_b());
        }catch (ValidationException e){
            validationMessageExceptionList.add(e);
        }

        try {
            serialNumber_r_validate = validate.validateSerial_number_r(serial_number_r);
            validationMessageExceptionList.add(new ValidationException("***Remote - given Serial number is valid: " +
                    validate.getSerial_number_r()));
            System.out.println(validate.getSerial_number_r());
        }catch (ValidationException e){
            validationMessageExceptionList.add(e);
        }

        try {
            HMI_boardNumber_validate = validate.validateHMIboardSerialNumber_r(HMI_board_serial_number_r);
            validationMessageExceptionList.add(new ValidationException("***Remote - given HMI board number is valid: " +
                    validate.getHMI_board_serial_number_r()));
            System.out.println(validate.getHMI_board_serial_number_r());
        }catch (ValidationException e){
            validationMessageExceptionList.add(e);
        }



        if(serial_number_d_validate && software_v_d_validate && motoar_serial_number_d_validate &&
                serialNumber_b_validate && torqueNumber_validate &&
                serialNumber_r_validate && HMI_boardNumber_validate){

            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Test Result");

            Random random = new Random();
            int rand = random.nextInt(150 - 80 + 1) + 80;

            validationMessageExceptionList.add(new ValidationException("\n\n ++++ Test Result Status +++++\n"));

            if(rand > 85 && rand < 140){
                validationMessageExceptionList.add(new ValidationException("Test value is: "+ rand + " Test passed successfully"));
                clearForm();

            }else{
                validationMessageExceptionList.add(new ValidationException("Test value is: "+ rand + " Test failed"));
            }



            VBox dialogVbox = new VBox(10);
            for(Exception validationMessageException: validationMessageExceptionList){
                dialogVbox.getChildren().add(new Text(validationMessageException.getMessage()));
            }
            Scene dialogScene = new Scene(dialogVbox, 500, 400);

            dialog.setScene(dialogScene);
            dialog.show();

        }else{
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Invalid Input");
            VBox dialogVbox = new VBox(10);
            for(Exception validationMessageException: validationMessageExceptionList){
                dialogVbox.getChildren().add(new Text(validationMessageException.getMessage()));
            }
            Scene dialogScene = new Scene(dialogVbox, 600, 300);

            dialog.setScene(dialogScene);
            dialog.show();
        }
    }
}
