package com.mycompany.coursey;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class SideB {
    private static String Login;
    private static String Password;
    private static String Number;
    private static SecretKey key;
    
    private static String LoginHashSideA;
    private static String PasswordHashSideA;
    private static String NumberHashSideA;
    
    private static String LoginCheckHash;
    private static String PasswordCheckHash;
    private static String NumberCheckHash;
    
    public static void setNumber(String Number) {
        SideB.Number = Number;
    }

    public SideB(String Login, String Password, String Number, SecretKey key, String LoginHashSideA, String PasswordHashSideA, String NumberHashSideA) {
        this.Login = Login;
        this.Password = Password;
        this.Number = Number;
        this.key = key;
        this.LoginHashSideA = LoginHashSideA;
        this.PasswordHashSideA = PasswordHashSideA;
        this.NumberHashSideA = NumberHashSideA;
    }
    
     protected static void getHmacLogin() throws NoSuchAlgorithmException, InvalidKeyException{
    Mac mac = Mac.getInstance("HmacMD5");
    mac.init(key);
    mac.reset();
    mac.update(Login.getBytes());
    byte[] b = mac.doFinal();   
    LoginCheckHash = HexBin.encode(b);
    char[] a = LoginCheckHash.toCharArray();
            for(int i = 0;i < 16;i++){
                LoginCheckHash += a[i];
            }
        
    }
    
    protected static void getHmacPassword() throws NoSuchAlgorithmException, InvalidKeyException{
    Mac mac = Mac.getInstance("HmacMD5");
    mac.init(key);
    mac.reset();
    mac.update(Password.getBytes());
    byte[] b = mac.doFinal();   
    PasswordCheckHash = HexBin.encode(b);
    char[] a = PasswordCheckHash.toCharArray();
            for(int i = 0;i < 16;i++){
                PasswordCheckHash += a[i];
            }
        
    }
    
    
    protected static void getHmacNumber() throws NoSuchAlgorithmException, InvalidKeyException{
    Mac mac = Mac.getInstance("HmacMD5");
    mac.init(key);
    mac.reset();
    mac.update(Number.getBytes());
    byte[] b = mac.doFinal();   
    NumberCheckHash = HexBin.encode(b);
    char[] a = NumberCheckHash.toCharArray();
            for(int i = 0;i < 16;i++){
                NumberCheckHash += a[i];
            }
      
    }
    
    protected static void checkedData(){
    
    if(LoginHashSideA.equals(LoginCheckHash) && PasswordHashSideA.equals(PasswordCheckHash) && NumberHashSideA.equals(NumberCheckHash)){MessageDialog.messageAuth();}else{MessageDialog.messageNonAuth();}
    
    
    }
    
}
