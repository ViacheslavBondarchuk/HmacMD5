package com.mycompany.coursey;

import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class FXMLController implements Initializable {
    
    private SecretKey secretKey;
    private String Login;
    private String Password;
    private String Number;
    
  
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button btnSndData;

    @FXML
    private TextField lableHashLoggin;

    @FXML
    private TextField lableHashPassword;

    @FXML
    private TextField lableHashNumber;

    @FXML
    private Button btnGenNumber;

    @FXML
    private Button btnClose;

    @FXML
    private TextField txtFieldSecretKey;

    @FXML
    private Button btnGenSecretKey;

    @FXML
    private Button btnAuth;

    @FXML
    private TextField numberField;
    
    @FXML
    private Menu Menu;

    @FXML
    private MenuItem itemHelp;

    @FXML
    private MenuItem itemAboutProgram;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        btnGenSecretKey.setOnAction(event ->{try {
            generateSecretKey();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }});
        btnSndData.setOnAction(event ->{try {
            getData();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }});
        
        btnAuth.setOnAction(event ->{try {
            Auth();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        btnGenNumber.setOnAction(event ->{generateNumber();});
        btnClose.setOnAction(event->{System.exit(0);});
        itemHelp.setOnAction(event->{MessageDialog.messageHelp();});
        itemAboutProgram.setOnAction(event->{MessageDialog.messageAboutProgram();});
        
    }    
    
    
    
    private void generateSecretKey() throws NoSuchAlgorithmException{
    
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        keyGenerator.init(192);
        secretKey = keyGenerator.generateKey();
        
        txtFieldSecretKey.setText(secretKey.toString());
        
    }
    
    private void getData() throws NoSuchAlgorithmException, InvalidKeyException{
    
    Login = loginField.getText();
    Password = passwordField.getText();
    Number = numberField.getText();
    
    new SideA(Login,Password,Number,secretKey);
    
    SideA.getHmacLogin();
    SideA.getHmacPassword();
    SideA.getHmacNumber();
    
    lableHashLoggin.setText(SideA.getLoginHash());
    lableHashPassword.setText(SideA.getPasswordHash());
    lableHashNumber.setText(SideA.getNumberHash());
  
    
    SideA.sendSideB();
    
    }
    
    private void Auth() throws NoSuchAlgorithmException, InvalidKeyException{
        
    SideB.getHmacLogin();
    SideB.getHmacPassword();
    SideB.getHmacNumber();
    
        SideB.checkedData();
    
    }
    
    private void generateNumber(){
    Random rnd = new Random();
    Integer a;
    a = rnd.nextInt(1000);
    numberField.setText(a.toString());
    SideB.setNumber(a.toString());
    
    
    }
    
}
