package com.mycompany.coursey;

import javafx.scene.control.Alert;

public class MessageDialog {
    public static void messageAuth(){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Message");
    alert.setHeaderText("Authentificate: ");
    alert.setContentText("was succeful");
    alert.showAndWait();
    
    }
    
    public static void messageNonAuth(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Information Message");
    alert.setHeaderText("Authentificate: ");
    alert.setContentText("dont was succeful");
    alert.showAndWait();
      
    }
    
    public static void messageAboutProgram(){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("About program");
    alert.setHeaderText("Developer: ");
    alert.setContentText(" Viacheslav Bondarchuk");
    alert.showAndWait();
    
    }
    
    public static void messageHelp(){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Help");
    alert.setContentText("                       Звичайна робота"
            + "\n" +  "1.Натисніть кнопку \"Genarate Secret Key\""
            + "\n" + "2.Заповніть пусті поля"
            + "\n" + "3.Натисніть кнопку \"Send Data\""
            + "\n" + "4.Натисніть кнопку \"Authentificate\""
            + "\n" + "\n" + "                             Тестування"
            + "\n" + "1.Натисніть кнопку \"Genarate Secret Key\""
            + "\n" + "2.Заповніть пусті поля"
            + "\n" + "3.Натисніть кнопку \"Send Data\""
            + "\n" + "4.Натисніть кнопку \"Generate Number\""
            + "\n" + "5.Натисніть кнопку \"Authentificate\"");
    alert.showAndWait();
    
    
    }
}
