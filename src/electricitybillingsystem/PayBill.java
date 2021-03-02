package electricitybillingsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class PayBill{
    PayBill(){
        try {
            Desktop.getDesktop().browse(new URL("https://paytm.com/electricity-bill-payment").toURI());
        } catch (Exception e) {
            
        }
    }
    
    public static void main(String[] args){
        new PayBill();
    }
}
