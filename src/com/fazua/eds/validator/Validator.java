package com.fazua.eds.validator;

import com.fazua.eds.exception.ValidationException;
import javafx.scene.control.TextField;

import java.nio.charset.Charset;

public class Validator {
    private static int serial_number_d;
    private static String software_v_d;
    private static Short motoar_serial_number_d;
    private static int serial_number_b;
    private static String torque_sensor_serial_number_b;
    private static int serial_number_r;
    private static short HMI_board_serial_number_r;
    private static boolean onTest;

    public boolean validateSerial_number_d(TextField serial_number_d) throws ValidationException {
        try {
            if(Integer.parseInt(serial_number_d.getText()) >=0 && serial_number_d.getText() !=null ){
                int serialNumber = Integer.parseInt(serial_number_d.getText());
                setSerial_number_d(serialNumber);
                setOnTest(true);
            }else{
                throw new ValidationException("Error message - Driver pack - Serial number - allowed values in the range of 0 to 2147483647");
            }
        }catch (Exception e){
            throw new ValidationException("Error message - Driver pack - Serial number - allowed values in the range of 0 to 2147483647");
        }

        return isOnTest();
    }

    public boolean validateSoftwareVersion_d(TextField software_v_d) throws ValidationException {
        short msb;
        short lsb;
        try {
            if (software_v_d.getText().contains(",") && software_v_d.getText() != null) {
                String[] msbLsb= software_v_d.getText().split(",");
                msb = Short.parseShort(msbLsb[0]);
                lsb = Short.parseShort(msbLsb[1]);
                int result = (lsb << 8) + msb;
                String softwareVersion = Integer.toHexString(result);
                setSoftware_v_d("0x"+softwareVersion);
            }else{
                throw new ValidationException("Error message - Driver pack - Software version - allowed only double positive values ex.4,19");
            }
        }catch (Exception e){
            throw new ValidationException("Error message - Driver pack - Software version - allowed only double positive values ex.4,19");
        }
        return isOnTest();
    }

    public boolean validateMotoar_serial_number_d(TextField motoar_serial_number_d) throws ValidationException {
        try {
            if(Short.parseShort(motoar_serial_number_d.getText()) >=0 && motoar_serial_number_d.getText() !=null ){
                setMotoar_serial_number_d(Short.parseShort(motoar_serial_number_d.getText()));
                setOnTest(true);
            }else{
                throw new ValidationException("Error message - Driver pack - Motor serial number - allowed values in the range of 0 to 32,767");
            }
        }catch (Exception e){
            throw new ValidationException("Error message - Driver pack - Motor serial number - allowed values in the range of 0 to 32,767");
        }
        return isOnTest();
    }


    public boolean validateSerial_number_b(TextField serial_number_b) throws ValidationException {
        try {
            if(Integer.parseInt(serial_number_b.getText()) >=0 && serial_number_b.getText() !=null ){
                int serialNumber = Integer.parseInt(serial_number_b.getText());
                setSerial_number_b(serialNumber);
                setOnTest(true);
            }else{
                throw new ValidationException("Error message - Bottom bracket: Serial number-allowed values in the range of 0 to 2147483647");
            }
        }catch (Exception e){
            throw new ValidationException("Error message - Bottom bracket: Serial number-allowed values in the range of 0 to 2147483647");
        }
        return isOnTest();
    }

    public boolean validateTorqueSerialNumber_b(TextField torque_sensor_serial_number_b) throws ValidationException {
        try {
            if(Charset.forName("US-ASCII").newEncoder().canEncode(torque_sensor_serial_number_b.getText()) &&
                    torque_sensor_serial_number_b.getText().length() <=12){
                setTorque_sensor_serial_number_b(torque_sensor_serial_number_b.getText());
                setOnTest(true);
            }else{
                throw new ValidationException("Error message - Bottom Bracket: Torque Sensor Serial number-allowed maximum 12 ASCII digits");
            }
        }catch (Exception e){
            throw new ValidationException("Error message - Bottom Bracket: Torque Sensor Serial number-allowed maximum 12 ASCII digits");
        }
        return isOnTest();
    }

    public boolean validateSerial_number_r(TextField serial_number_r) throws ValidationException {
        try {
            if(Integer.parseInt(serial_number_r.getText()) >=0 && serial_number_r.getText() !=null ){
                int serialNumber = Integer.parseInt(serial_number_r.getText());
                setSerial_number_r(serialNumber);
                setOnTest(true);
            }else{
                throw new ValidationException("Error message - Remote: Serial number-allowed values in the range of 0 to 2147483647");
            }
        }catch (Exception e){
            throw new ValidationException("Error message - Remote: Serial number-allowed values in the range of 0 to 2147483647");
        }
        return isOnTest();
    }
    public boolean validateHMIboardSerialNumber_r(TextField HMI_board_serial_number_r) throws ValidationException {
        try {
            if(Short.parseShort(HMI_board_serial_number_r.getText()) >=0 && HMI_board_serial_number_r.getText() !=null ){
                short serialNumber = Short.parseShort(HMI_board_serial_number_r.getText());
                setHMI_board_serial_number_r(serialNumber);
                setOnTest(true);
            }else{
                throw new ValidationException("Error message - Remote: HMI board Serial number-allowed values in the range of 0 to 32,767");
            }
        }catch (Exception e){
            throw new ValidationException("Error message - Remote: HMI board Serial number-allowed values in the range of 0 to 32,767");
        }
        return isOnTest();
    }
    public int getSerial_number_d() {
        return serial_number_d;
    }

    public void setSerial_number_d(int serial_number_d) {
        this.serial_number_d = serial_number_d;
    }

    public String getSoftware_v_d() {
        return software_v_d;
    }

    public void setSoftware_v_d(String software_v_d) {
        this.software_v_d = software_v_d;
    }

    public Short getMotoar_serial_number_d() {
        return motoar_serial_number_d;
    }

    public void setMotoar_serial_number_d(Short motoar_serial_number_d) {
        this.motoar_serial_number_d = motoar_serial_number_d;
    }

    public int getSerial_number_b() {
        return serial_number_b;
    }

    public void setSerial_number_b(int serial_number_b) {
        this.serial_number_b = serial_number_b;
    }

    public String getTorque_sensor_serial_number_b() {
        return torque_sensor_serial_number_b;
    }

    public void setTorque_sensor_serial_number_b(String torque_sensor_serial_number_b) {
        this.torque_sensor_serial_number_b = torque_sensor_serial_number_b;
    }

    public int getSerial_number_r() {
        return serial_number_r;
    }

    public void setSerial_number_r(int serial_number_r) {
        this.serial_number_r = serial_number_r;
    }

    public short getHMI_board_serial_number_r() {
        return HMI_board_serial_number_r;
    }

    public void setHMI_board_serial_number_r(short HMI_board_serial_number_r) {
        this.HMI_board_serial_number_r = HMI_board_serial_number_r;
    }

    public boolean isOnTest() {
        return onTest;
    }

    public void setOnTest(boolean onTest) {
        this.onTest = onTest;
    }
}
