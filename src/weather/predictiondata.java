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



public class predictiondata extends JFrame 
{
	
	JLabel lbl_title,lbl_Humidity,lbl_Pressure,lbl_windDirection,lbl_windspeed,lbl_Temperature;
	JTextField txt_Humidity,txt_Pressure,txt_windspeed,txt_windDirection,txt_Temperature;
	JPanel p1,p2,displayadminPanel;	
	Connection con;	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JLabel label_1;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	


public predictiondata()
	  {
	setResizable(false);
	setSize(new Dimension(445, 457));
	setBackground(Color.RED);
	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\dataeclipse\\weather\\images\\FLOWER.JPG"));
		lbl_title=new JLabel("WEATHER INFORMATION SYSTEM");
	
		
		lbl_Humidity=new JLabel("Humidity");
		lbl_Pressure=new JLabel("Pressure");
		lbl_windDirection=new JLabel("windDirection");
		lbl_windspeed=new JLabel("windspeed");
		lbl_Temperature=new JLabel("Temperature");
		txt_Humidity=new JTextField(10);
		txt_Humidity.setForeground(new Color(153, 50, 204));
		txt_Humidity.setBounds(176, 36, 166, 25);
		txt_Pressure=new JTextField(10);
		txt_Pressure.setForeground(new Color(153, 50, 204));
		txt_Pressure.setBounds(176, 89, 166, 25);
		txt_windDirection=new JTextField(10);
		txt_windDirection.setForeground(new Color(153, 50, 204));
		txt_windDirection.setBounds(176, 150, 166, 25);
		txt_windspeed=new JTextField(10);
		txt_windspeed.setForeground(new Color(153, 50, 204));
		txt_windspeed.setBounds(176, 212, 166, 25);
		txt_Temperature=new JTextField(10);
		txt_Temperature.setForeground(new Color(153, 50, 204));
		txt_Temperature.setBounds(176, 267, 166, 25);
		
		p1=new JPanel();
		p1.setBounds(0, 0, 644, 61);
		p2=new JPanel();
		p2.setBounds(0, 31, 439, 398);
		 displayadminPanel  = new JPanel();
		 displayadminPanel.setForeground(SystemColor.textHighlight);
		 displayadminPanel.setLayout(null);
		 displayadminPanel.add(p1);
		 displayadminPanel.add(p2	);
		p1.setLayout(null);
		
		JLabel lblPredictionDataEntry = new JLabel("prediction data entry");
		lblPredictionDataEntry.setBounds(130, 5, 275, 22);
		lblPredictionDataEntry.setForeground(new Color(0, 255, 255));
		lblPredictionDataEntry.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		p1.add(lblPredictionDataEntry);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\received_727132534063862 - Copy.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 443, 428);
		p1.add(lblNewLabel_1);
		 p2.setLayout(null);
		 JLabel label_2 = new JLabel("Humidity");
		 label_2.setBounds(26, 34, 65, 25);
		 label_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 label_2.setForeground(new Color(255, 255, 255));
		 p2.add(label_2);
         p2.add(txt_Humidity);
         JLabel label_3 = new JLabel("Pressure");
         label_3.setBounds(26, 87, 79, 25);
         label_3.setForeground(new Color(255, 255, 255));
         label_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         p2.add(label_3);
         p2.add(txt_Pressure);
         JLabel label_4 = new JLabel("windDirection");
         label_4.setBounds(26, 148, 93, 25);
         label_4.setForeground(new Color(255, 255, 255));
         label_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         p2.add(label_4);
         p2.add(txt_windDirection);
         JLabel label_5 = new JLabel("windspeed");
         label_5.setBounds(26, 210, 93, 25);
         label_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         label_5.setForeground(new Color(255, 255, 255));
         p2.add(label_5);
         p2.add(txt_windspeed);
         JLabel label_6 = new JLabel("Temperature");
         label_6.setBounds(26, 265, 102, 25);
         label_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         label_6.setForeground(new Color(255, 255, 255));
         p2.add(label_6);
         p2.add(txt_Temperature);
         
         
         
         
         
         JButton btnNewButton_1 = new JButton("save");
         btnNewButton_1.setBorder(new LineBorder(new Color(153, 50, 204)));
         btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
         btnNewButton_1.setForeground(new Color(153, 50, 204));
         btnNewButton_1.setBounds(60, 313, 89, 23);
         p2.add(btnNewButton_1);
         btnNewButton_1.addActionListener(new ActionListener()
         {
         	public void actionPerformed(ActionEvent arg0) 
         	{
         	
    		String s4=txt_Humidity.getText();
    			String s5=txt_Pressure.getText();
    			String s6=txt_windDirection.getText();
    			String s7=txt_windspeed.getText();
    			String s8=txt_Temperature.getText();
    			
			     
    			
					double Humidity= Double.parseDouble(s4);
					double Pressure= Double.parseDouble(s5);
					int windDirection= Integer.parseInt(s6);
					double windspeed= Double.parseDouble(s7);
					double Temperature= Double.parseDouble(s8);   
					try{
					
						String csv = "datafortraining11.csv";
					CSVWriter writer=new CSVWriter(new FileWriter(csv,true));
					
					String [] s9 =new String[5];
					s9[0]=s4;
					s9[1]=s5;
					s9[2]=s6;
					s9[3]=s7;
					s9[4]=s8;
					String [] record=s9;
					writer.writeNext(record);
					writer.close();
					txt_Humidity.setText("");
					txt_Pressure.setText("");
					txt_windspeed.setText("");
					txt_windDirection.setText("");
					txt_Temperature.setText("");
					JOptionPane.showMessageDialog(null,"Successfully inserted");
					}
					catch(Exception ex)
					{
						System.out.println(ex.getMessage());
					}
        		
					
         	}  });
         
         btnNewButton = new JButton("clear");
         btnNewButton.setBorder(new LineBorder(new Color(153, 50, 204)));
         btnNewButton.setForeground(new Color(153, 50, 204));
         btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent arg0) 
         	{
         		txt_Humidity.setText("");
				txt_Pressure.setText("");
				txt_windspeed.setText("");
				txt_windDirection.setText("");
				txt_Temperature.setText("");
         	}
         });
         btnNewButton.setBounds(198, 313, 89, 23);
         p2.add(btnNewButton);
         
         btnNewButton_2 = new JButton("<--back");
         btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
         btnNewButton_2.setForeground(new Color(0, 128, 0));
         btnNewButton_2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) 
         	{
         		admin secondform = new admin();
			    secondform.setVisible(true);
			    setVisible(false);
			    dispose();
         	}
         });
         btnNewButton_2.setBounds(2, 364, 89, 23);
         p2.add(btnNewButton_2);
         
         JLabel label = new JLabel("%");
         label.setForeground(new Color(128, 0, 0));
         label.setFont(new Font("Tahoma", Font.BOLD, 11));
         label.setBounds(349, 41, 46, 14);
         p2.add(label);
         
         label_1 = new JLabel("hPa");
         label_1.setForeground(new Color(128, 0, 0));
         label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
         label_1.setBounds(352, 94, 46, 14);
         p2.add(label_1);
         
         label_7 = new JLabel("\u00B0");
         label_7.setForeground(new Color(128, 0, 0));
         label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
         label_7.setBounds(352, 155, 46, 14);
         p2.add(label_7);
         
         label_8 = new JLabel("km/h");
         label_8.setForeground(new Color(128, 0, 0));
         label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
         label_8.setBounds(352, 217, 46, 14);
         p2.add(label_8);
         
         label_9 = new JLabel("\u00B0C");
         label_9.setForeground(new Color(128, 0, 0));
         label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
         label_9.setBounds(352, 272, 46, 14);
         p2.add(label_9);
         
         lblNewLabel = new JLabel("New label");
         lblNewLabel.setBounds(0, -29, 440, 427);
         lblNewLabel.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\received_727132534063862 - Copy.jpeg"));
         p2.add(lblNewLabel);
 
		
		Container c=getContentPane();
		 c.setLayout(new BorderLayout());
		
	
		 c.add(displayadminPanel);
		setTitle("ADMIN prediction data");
	}


	
	
	public static void main(String args[])
	{
		predictiondata weather=new predictiondata();
		weather.setVisible(true);
		weather.addWindowListener(new WindowAdapter()
		{ 
  			public void windowClosing(WindowEvent e)
			{  
               			System.exit(0);       
			}         
		});
		weather.setSize(new Dimension(445,433));
		weather.setVisible(true);
	}
}



