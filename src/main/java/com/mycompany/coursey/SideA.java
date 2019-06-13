package com.mycompany.coursey;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class SideA {
    private static String Login;
    private static String Password;
    private static String Number;
    private static SecretKey key;
    
    private static String LoginHash;
    private static String PasswordHash;
    private static String NumberHash;
    
    public static String getLoginHash() {
        return LoginHash;
    }

    public static String getPasswordHash() {
        return PasswordHash;
    }

    public static String getNumberHash() {
        return NumberHash;
    }
    
    public SideA(String Login, String Password, String Number, SecretKey key) {
        this.Login = Login;
        this.Password = Password;
        this.Number = Number;
        this.key = key;
    }
    
    protected static void getHmacLogin() throws NoSuchAlgorithmException, InvalidKeyException{
    Mac mac = Mac.getInstance("HmacMD5");
    mac.init(key);
    mac.reset();
    mac.update(Login.getBytes());
    byte[] b = mac.doFinal();   
    LoginHash = HexBin.encode(b);
    char[] a = LoginHash.toCharArray();
            for(int i = 0;i < 16;i++){
                LoginHash += a[i];
            }
            
    }
    
    protected static void getHmacPassword() throws NoSuchAlgorithmException, InvalidKeyException{
    Mac mac = Mac.getInstance("HmacMD5");
    mac.init(key);
    mac.reset();
    mac.update(Password.getBytes());
    byte[] b = mac.doFinal();   
    PasswordHash = HexBin.encode(b);
    char[] a = PasswordHash.toCharArray();
            for(int i = 0;i < 16;i++){
                PasswordHash += a[i];
            }
        
    }
    
    
    protected static void getHmacNumber() throws NoSuchAlgorithmException, InvalidKeyException{
    Mac mac = Mac.getInstance("HmacMD5");
    mac.init(key);
    mac.reset();
    mac.update(Number.getBytes());
    byte[] b = mac.doFinal();   
    NumberHash = HexBin.encode(b);
    char[] a = NumberHash.toCharArray();
            for(int i = 0;i < 16;i++){
                NumberHash += a[i];
            }
        
      
    }
    
    protected static void sendSideB(){
    
        new SideB(Login,Password,Number,key,LoginHash,PasswordHash,NumberHash);
    
    
    }
    
}
