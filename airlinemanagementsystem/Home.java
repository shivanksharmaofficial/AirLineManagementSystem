package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    public Home() {
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);           //cant add image directly so label
        image.setBounds(0, 0, 1600, 800);
        add(image);
        
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500, 40, 1200, 50);
        heading.setForeground(Color.BLUE);     //to set font color
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));   //(fontfamily,fontTYPE,fontsize)
        image.add(heading);     //to mention heading over image so image.add
        
        JMenuBar menubar = new JMenuBar();    //class to adddd menubatt
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");  
        menubar.add(details);                 //menu will appear on screen
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");   
        flightDetails.addActionListener(this);
        details.add(flightDetails);                  //to add flight deatils item into deails menubar
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");   
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);          //to add boarding pass item into ticket menubar
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);     //to provide full screen to home frame
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            new CancelTicket();
        }
        else if (text.equals("Boarding Pass")){
            new BoardingPass();
        }
        
    }
    
    public static void main(String[] args) {
        new Home();
    }
}