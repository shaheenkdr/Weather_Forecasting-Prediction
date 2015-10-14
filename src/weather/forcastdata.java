package weather;







import javax.swing.*;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileReader;
import java.util.Arrays;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.File;
import java.io.Writer;
import java.io.IOException;

import com.csvreader.CsvWriter;
import javax.swing.border.LineBorder;



public class forcastdata extends JFrame 
{
	
	JLabel lbl_title,lbl_Humidity,lbl_Pressure,lbl_windDirection,lbl_windspeed,lbl_Temperature;
	JTextField txt_Date,txt_Temperature;
	JPanel displayadminPanel;	
	Connection con;	
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblForcastEntry;
	private JLabel lblTimePm;
	


public forcastdata()
	  {
	setResizable(false);
	setSize(new Dimension(418, 434));
	setBackground(Color.RED);
	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\dataeclipse\\weather\\images\\FLOWER.JPG"));
		lbl_title=new JLabel("WEATHER INFORMATION SYSTEM");
	
		
		lbl_Humidity=new JLabel("Humidity");
		lbl_Pressure=new JLabel("Pressure");
		lbl_windDirection=new JLabel("windDirection");
		lbl_windspeed=new JLabel("windspeed");
		lbl_Temperature=new JLabel("Temperature");
		 displayadminPanel  = new JPanel();
		 displayadminPanel.setForeground(SystemColor.textHighlight);
 
		
		Container c=getContentPane();
		 c.setLayout(new BorderLayout());
		
	
		 c.add(displayadminPanel);
		 displayadminPanel.setLayout(null);
		 JLabel lblDate = new JLabel("Date");
		 lblDate.setBounds(28, 182, 65, 25);
		 displayadminPanel.add(lblDate);
		 lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 lblDate.setForeground(Color.WHITE);
		 txt_Date=new JTextField(10);
		 txt_Date.setForeground(new Color(153, 50, 204));
		 txt_Date.setBounds(161, 184, 166, 25);
		 displayadminPanel.add(txt_Date);
		 JLabel lblTemperature = new JLabel("Temperature");
		 lblTemperature.setBounds(28, 132, 93, 25);
		 displayadminPanel.add(lblTemperature);
		 lblTemperature.setForeground(Color.WHITE);
		 lblTemperature.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 txt_Temperature=new JTextField(10);
		 txt_Temperature.setForeground(new Color(153, 50, 204));
		 txt_Temperature.setBounds(161, 134, 166, 25);
		 displayadminPanel.add(txt_Temperature);
		 
		 
		 btnNewButton = new JButton("save");
		 btnNewButton.setBackground(new Color(230, 230, 250));
		 btnNewButton.setBorder(new LineBorder(new Color(153, 50, 204)));
		 btnNewButton.setForeground(new Color(153, 50, 204));
		 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		 btnNewButton.setBounds(64, 250, 89, 23);
		 btnNewButton.addActionListener(new ActionListener()
		 {
		 	public void actionPerformed(ActionEvent arg0)
		 	{
		 		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");  
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
				
				String s8=txt_Temperature.getText();
				String s2=txt_Date.getText();
			//	String s3=txt_Time.getText();
		 		
		 		DateFormat formatter2 = new SimpleDateFormat("hh:mm:ss");
		 		double Temperature= Double.parseDouble(s8); 
		 		 
		 		try{
		 			 Date date2 = formatter.parse(s2);  
					String csv = "forcsv.csv";
				CSVWriter writer=new CSVWriter(new FileWriter(csv,true));
				
				String [] s9 =new String[2];
				s9[0]=s8;
				//s9[1]=s3;
				s9[1]=s2;
				
				String [] record=s9;
				writer.writeNext(record);
				writer.close();
				txt_Temperature.setText("");
				txt_Date.setText("");
			//	txt_Time.setText("");
				
				
				
				JOptionPane.showMessageDialog(null,"Successfully inserted");
						
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
    		
		 	}
		 });
		 displayadminPanel.add(btnNewButton);
		 
		 btnNewButton_1 = new JButton("clear entry");
		 btnNewButton_1.setBackground(new Color(230, 230, 250));
		 btnNewButton_1.setBorder(new LineBorder(new Color(153, 50, 204)));
		 btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		 btnNewButton_1.setForeground(new Color(153, 50, 204));
		 btnNewButton_1.setBounds(199, 250, 100, 23);
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) 
		 	{
		 		txt_Date.setText("");
			//	txt_Time.setText("");
				
				txt_Temperature.setText("");
		 	}
		 });
		 displayadminPanel.add(btnNewButton_1);
		 
		 lblForcastEntry = new JLabel("Forecast  Data Entry");
		 lblForcastEntry.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		 lblForcastEntry.setForeground(new Color(0, 255, 255));
		 lblForcastEntry.setBounds(93, 11, 187, 25);
		 displayadminPanel.add(lblForcastEntry);
		 
		 JButton btnNewButton_2 = new JButton("<--back");
		 btnNewButton_2.setBackground(new Color(240, 240, 240));
		 btnNewButton_2.setBorder(new LineBorder(new Color(0, 100, 0)));
		 btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		 btnNewButton_2.setForeground(new Color(0, 100, 0));
		 btnNewButton_2.addActionListener(new ActionListener() {
		 	
			 public void actionPerformed(ActionEvent arg0) 
			 {
				 admin secondform = new admin();
				    secondform.setVisible(true);
				    setVisible(false);
				    dispose();
		 	}
		 });
		 
		 JLabel lblYyyymmdd = new JLabel("yyyy-MM-dd");
		 lblYyyymmdd.setFont(new Font("Tahoma", Font.PLAIN, 9));
		 lblYyyymmdd.setBounds(337, 189, 65, 14);
		 displayadminPanel.add(lblYyyymmdd);
		 
		 btnNewButton_2.setBounds(10, 329, 89, 23);
		 displayadminPanel.add(btnNewButton_2);
		 
		 lblTimePm = new JLabel("Time :2.30 pm");
		 lblTimePm.setFont(new Font("Tahoma", Font.BOLD, 13));
		 lblTimePm.setForeground(new Color(255, 239, 213));
		 lblTimePm.setBounds(107, 73, 100, 14);
		 displayadminPanel.add(lblTimePm);
		 
		 JLabel lblc = new JLabel("\u00B0C");
		 lblc.setBounds(338, 139, 46, 14);
		 displayadminPanel.add(lblc);
		 
		 lblNewLabel = new JLabel("New label");
		 lblNewLabel.setBounds(0, 0, 416, 407);
		 lblNewLabel.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\received_727132527397196 - Copy.jpeg"));
		 displayadminPanel.add(lblNewLabel);
		setTitle("ADMIN forcast");
	}


	
	
	public static void main(String args[])
	{
		forcastdata weather=new forcastdata();
		weather.setVisible(true);
		weather.addWindowListener(new WindowAdapter()
		{ 
  			public void windowClosing(WindowEvent e)
			{  
               			System.exit(0);       
			}         
		});
		weather.setSize(new Dimension(418,434));
		weather.setVisible(true);
	}
}



