package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;                //package stored in jar file

public class FlightInfo extends JFrame{
    
    public FlightInfo() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table = new JTable();
        
        try {
            Conn conn = new Conn();
            
            ResultSet rs = conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));     //to display exact table from db 
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);    //to addd scrollbar
        jsp.setBounds(0, 0, 800, 500);
        add(jsp);
        
        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlightInfo();
    }
}