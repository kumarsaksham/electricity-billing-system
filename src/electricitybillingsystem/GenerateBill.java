/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitybillingsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author saksh
 */
public class GenerateBill extends JFrame implements ActionListener{
    JLabel l1;
    JTextArea t1;
    JButton b1;
    Choice c1,c2;
    JPanel p1;
    
    GenerateBill(){
        setSize(500,900);
        setLayout(new BorderLayout());
        
        p1 = new JPanel();
        l1 = new JLabel("Generate Bill");   
        
        c1 = new Choice();
        c1.add("1001");
        c1.add("1002");
        c1.add("1003");
        c1.add("1004");
        c1.add("1005");
        c1.add("1006");
        c1.add("1007");
        c1.add("1008");
        c1.add("1009");
        c1.add("1010");
        
        c2 = new Choice();
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        
        t1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif",Font.ITALIC,18));
        
        b1 = new JButton("Generate Bill");
        
        p1.add(l1);
        p1.add(c1);
        p1.add(c2);
        add(p1,"North");
        add(jsp,"Center");
        add(b1,"South");
        
        b1.addActionListener(this);
        
        setLocation(350,40);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            String month = c2.getSelectedItem();
            t1.setText("\tMY POWER LIMITED\n\tElectricity Bill for the month of " + month + " 2021\n\n\n");
            
            String q = "SELECT * FROM emp WHERE meter_number=" + c1.getSelectedItem();
            ResultSet rs = c.s.executeQuery(q);
            
            if(rs.next()){
                t1.append("\nCustomer Name : " + rs.getString("name"));
                t1.append("\nMeter Number  : " + rs.getString("meter_number"));
                t1.append("\nAddress       : " + rs.getString("address"));
                t1.append("\nState         : " + rs.getString("state"));
                t1.append("\nCity          : " + rs.getString("city"));
                t1.append("\nEmail         : " + rs.getString("email"));
                t1.append("\nPhone Number  : " + rs.getString("phone"));
                t1.append("\n----------------------------------------------------");
                t1.append("\n");                
            }
            
            rs = c.s.executeQuery("SELECT * FROM tax");
            if(rs.next()){
                t1.append("\nMeter Location : " + rs.getString("meter_location"));
                t1.append("\nMeter Type     : " + rs.getString("meter_type"));
                t1.append("\nPhase Code     : " + rs.getString("phase_code"));
                t1.append("\nBill Type      : " + rs.getString("bill_type"));
                t1.append("\nNo. of Days    : " + rs.getString("days"));
                t1.append("\n");
                t1.append("\n-------------------------------------------------");
                t1.append("\n\n");
                t1.append("\nMeter Rent  : " + rs.getString("meter_rent"));
                t1.append("\nMCB Rent    : " + rs.getString("mcb_rent"));
                t1.append("\nService Tax : " + rs.getString("service_rent"));
                t1.append("\nGST@9%      : " + rs.getString("gst"));
            }
            
            rs = c.s.executeQuery("SELECT * FROM bill WHERE meter_number=" + c1.getSelectedItem());
            if(rs.next()){
                t1.append("\nCurrent Month  : " + rs.getString("month"));
                t1.append("\nUnits Consumed : " + rs.getString("units"));
                t1.append("\nTotal Charges  : " + rs.getString("amount"));
                t1.append("\n-----------------------------------------------------");
                t1.append("\nTOTAL PAYABLE : " + rs.getString("amount"));
                
            }
            
        }catch(Exception e){
            
        }
    }
    
    public static void main(String[] args){
        new GenerateBill().setVisible(true);
    }
}
