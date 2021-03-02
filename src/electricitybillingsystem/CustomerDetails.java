/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitybillingsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author saksh
 */
public class CustomerDetails extends JFrame implements ActionListener{
    JTable t1;
    JButton b1;
    String x[] = {"Emp Name", "Meter No.", "Address", "State", "City", "Email", "Phone No."};
    String y[][] = new String[20][8];
    int i=0, j=0;
    
    CustomerDetails(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(200,200);
        
        /* GETTING DATA FROM DATABASE */
        try{
            Conn c1 = new Conn();
            String q = "SELECT * FROM emp";
            ResultSet rs = c1.s.executeQuery(q);
            while(rs.next()){
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("meter_number");
                y[i][j++] = rs.getString("address");
                y[i][j++] = rs.getString("state");
                y[i][j++] = rs.getString("city");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("phone");
                i++;
                j=0;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        t1= new JTable(y,x);
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
           t1.print(); 
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new CustomerDetails().setVisible(true);
    }
}
