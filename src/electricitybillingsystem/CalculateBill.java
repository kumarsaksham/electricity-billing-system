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
public class CalculateBill extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1;
    Choice c1,c2;
    JButton b1,b2;
    JPanel p;
    
    CalculateBill(){
        p = new JPanel();
        p.setLayout(new GridLayout(4,2,30,30));
        p.setBackground(Color.WHITE);
        
        l1 = new JLabel("Calculate Electricity Bill");
        l2 = new JLabel("Meter No.");
        l3 = new JLabel("Month");
        l4 = new JLabel("Units Consumed");
        
        t1 = new JTextField();
        
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
        
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i1 = ic1.getImage().getScaledInstance(180, 270, Image.SCALE_DEFAULT);
        ImageIcon icc1 = new ImageIcon(i1);
        l5 = new JLabel(icc1);
        
        l1.setFont(new Font("Senserif",Font.PLAIN,26));
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        p.add(l2);
        p.add(c1);
        p.add(l3);
        p.add(c2);
        p.add(l4);
        p.add(t1);
        p.add(b1);
        p.add(b2);
        
        setLayout(new BorderLayout(30,30));
        
        add(l1,"North");
        add(p,"Center");
        add(l5,"West");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(700,600);
        setLocation(350,220);        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String a = c1.getSelectedItem();
            String b = c2.getSelectedItem();
            String c = t1.getText();
        
            int p1 = Integer.parseInt(c);
            int p2 = p1*7;
            int p3 = p2+50+12+102+20+50;

            String q = "INSERT INTO bill values('"+a+"','"+b+"','"+c+"','"+p3+"')";
            try{
            Conn c1 = new Conn();
            c1.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Bill Updated");
            this.setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new CalculateBill().setVisible(true);
    }
}
