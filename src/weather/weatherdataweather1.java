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



public class weatherdataweather1 extends JFrame implements ActionListener
{
	private static final String NEW_LINE_SEPARATOR = "\n";
	JLabel lbl_title,lbl_Date,lbl_Time,lbl_Humidity,lbl_Pressure,lbl_windDirection,lbl_windspeed,lbl_Temperature;
	JButton btn_edit,btn_delete,btn_search,btn_clear,btn_logout;
	JTextField txt_Date,txt_Time,txt_Humidity,txt_Pressure,txt_windspeed,txt_windDirection,txt_Temperature;
	JPanel p1,p2,p3,displayadminPanel;	
	Connection con;	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	


public weatherdataweather1()
	  {
	setResizable(false);
	setSize(new Dimension(571, 504));
	setBackground(Color.RED);
	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\dataeclipse\\weather\\images\\FLOWER.JPG"));
		lbl_title=new JLabel("WEATHER INFORMATION SYSTEM");
	
		lbl_Date=new JLabel("Date");
		lbl_Time=new JLabel("Time");
		lbl_Humidity=new JLabel("Humidity");
		lbl_Pressure=new JLabel("Pressure");
		lbl_windDirection=new JLabel("windDirection");
		lbl_windspeed=new JLabel("windspeed");
		lbl_Temperature=new JLabel("Temperature");
		
	
		txt_Date=new JTextField(20);
		txt_Date.setBounds(176, 2, 166, 25);
	
		txt_Time=new JTextField(10);
		txt_Time.setBounds(176, 48, 166, 25);
		txt_Humidity=new JTextField(10);
		txt_Humidity.setBounds(176, 92, 166, 25);
		txt_Pressure=new JTextField(10);
		txt_Pressure.setBounds(176, 142, 166, 25);
		txt_windDirection=new JTextField(10);
		txt_windDirection.setBounds(176, 187, 166, 25);
		txt_windspeed=new JTextField(10);
		txt_windspeed.setBounds(176, 230, 166, 25);
		txt_Temperature=new JTextField(10);
		txt_Temperature.setBounds(176, 279, 166, 25);
		
		p1=new JPanel();
		p1.setBounds(0, 0, 644, 61);
		p2=new JPanel();
		p2.setBounds(0, 59, 617, 346);
		 displayadminPanel  = new JPanel();
		 displayadminPanel.setForeground(SystemColor.textHighlight);
		 displayadminPanel.setLayout(null);
		 displayadminPanel.add(p1);
		 
		 
		 JButton btn_save=new JButton("Save");
		 btn_save.setBounds(11, 11, 65, 27);
		 btn_save.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		 btn_save.setForeground(new Color(34, 139, 34));
		 btn_edit=new JButton("edit");
		 btn_edit.setBounds(175, 11, 81, 27);
		 btn_edit.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		 btn_edit.setForeground(new Color(46, 139, 87));
		 btn_delete=new JButton("Delete");
		 btn_delete.setBounds(266, 11, 77, 27);
		 btn_delete.setForeground(new Color(46, 139, 87));
		 btn_delete.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		 btn_search=new JButton("Search");
		 btn_search.setBounds(86, 11, 79, 27);
		 btn_search.setForeground(new Color(34, 139, 34));
		 btn_search.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		 
		 btn_clear=new JButton("Clear");
		 btn_clear.setBounds(353, 11, 69, 27);
		 btn_clear.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		 btn_clear.setForeground(new Color(46, 139, 87));
		 
		 btn_save.addActionListener(this);
		 btn_edit.addActionListener(this);
		 btn_delete.addActionListener(this);
		 btn_search.addActionListener(this);
		 
		 	btn_clear.addActionListener(this);
		 	p3=new JPanel();
		 	p3.setBounds(0, 398, 643, 87);
		 	displayadminPanel.add(p3	);
		 	p3.setLayout(null);
		 	
		 	p3.add(btn_save);
		 	p3.add(btn_search);
		 	p3.add(btn_edit);
		 	p3.add(btn_delete);
		 	p3.add(btn_clear);
		 	
		 	JButton btnNewButton = new JButton("Prediction ");
		 	btnNewButton.setBounds(476, 43, 89, 23);
		 	p3.add(btnNewButton);
		 	btnNewButton.addActionListener(new ActionListener()
		 	{
		 		public void actionPerformed(ActionEvent arg0) {
		 			predict page=new predict();
		 	        page.setVisible(true);
		 		}
		 	});   
		 	
		 //	btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		 	btnNewButton.setForeground(new Color(178, 34, 34));
		 	btnNewButton.setBackground(new Color(255, 228, 196));
		 	
		 	lblNewLabel_2 = new JLabel("New label");
		 	lblNewLabel_2.setBounds(-27, -378, 592, 453);
		 	lblNewLabel_2.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\freshness-hd-wallpaper-2560x1600.jpeg"));
		 	p3.add(lblNewLabel_2);
		 displayadminPanel.add(p2	);
		p1.setLayout(null);
		
		JLabel label_7 = new JLabel("WEATHER INFORMATION SYSTEM");
		label_7.setBounds(130, 5, 275, 22);
		label_7.setForeground(new Color(139, 0, 0));
		label_7.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		p1.add(label_7);
		btn_logout=new JButton("logout");
		btn_logout.setBounds(484, 5, 81, 22);
		p1.add(btn_logout);
		btn_logout.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		btn_logout.setForeground(new Color(46, 139, 87));
		btn_logout.addActionListener(this);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\freshness-hd-wallpaper-2560x1600.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 565, 399);
		p1.add(lblNewLabel_1);
		 p2.setLayout(null);
		
		 JLabel label = new JLabel("Date");
		 label.setBounds(33, 1, 72, 23);
		 label.setForeground(Color.RED);
		 label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 p2.add(label);
         p2.add(txt_Date);
         JLabel label_1 = new JLabel("Time");
         label_1.setBounds(33, 46, 72, 25);
         label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         label_1.setForeground(Color.RED);
         p2.add(label_1);
         p2.add(txt_Time);
		 JLabel label_2 = new JLabel("Humidity");
		 label_2.setBounds(33, 90, 65, 25);
		 label_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 label_2.setForeground(Color.RED);
		 p2.add(label_2);
         p2.add(txt_Humidity);
         JLabel label_3 = new JLabel("Pressure");
         label_3.setBounds(33, 140, 79, 25);
         label_3.setForeground(Color.RED);
         label_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         p2.add(label_3);
         p2.add(txt_Pressure);
         JLabel label_4 = new JLabel("windDirection");
         label_4.setBounds(33, 185, 93, 25);
         label_4.setForeground(Color.RED);
         label_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         p2.add(label_4);
         p2.add(txt_windDirection);
         JLabel label_5 = new JLabel("windspeed");
         label_5.setBounds(33, 228, 93, 25);
         label_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         label_5.setForeground(Color.RED);
         p2.add(label_5);
         p2.add(txt_windspeed);
         JLabel label_6 = new JLabel("Temperature");
         label_6.setBounds(33, 277, 102, 25);
         label_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
         label_6.setForeground(Color.RED);
         p2.add(label_6);
         p2.add(txt_Temperature);
         
         
         
         
         
         JButton btnNewButton_1 = new JButton("savecsv");
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
					
					
					
				/*	String s1=s4;
					String s2=s5;
					String s3="windDirection";
					String s4="windspeed";
					String s5="Temperature";
				*/	
			/*		writer.append("Humidity");
					writer.append(',');
					writer.append("Pressure");
					writer.append(',');
					writer.append("windDirection");
					writer.append(',');
					writer.append("windspeed");
					writer.append(',');
					writer.append("Temperature");
	
					//writer.append('/n');

					writer.append(txt_Humidity.getText());
					writer.append(',');
					writer.append(txt_Pressure.getText());
					writer.append(',');
					writer.append(txt_windDirection.getText());
					writer.append(',');
					writer.append(txt_windspeed.getText());
					writer.append(',');
					writer.append(txt_Temperature.getText);
			*/	
				
					
			//	String [] record ="Humidity,Pressure,windDirection,windspeed,Temperature".split(",");
					
			//		writer.writeNext(record);
				//	writer.close();
				
					}
					catch(Exception ex)
					{
						System.out.println(ex.getMessage());
					}
        		
					
         	}  });
       
         
         
         
         btnNewButton_1.setBounds(414, 280, 89, 23);
         p2.add(btnNewButton_1);
         
         lblNewLabel = new JLabel("New label");
         lblNewLabel.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\freshness-hd-wallpaper-2560x1600.jpeg"));
         lblNewLabel.setBounds(0, -45, 565, 398);
         p2.add(lblNewLabel);
 
		
		Container c=getContentPane();
		 c.setLayout(new BorderLayout());
		
	
		 c.add(displayadminPanel);
		setTitle("ADMIN");
	}


	public void actionPerformed(ActionEvent ae)		
	{
	ResultSet rs = null; 
	
		try
                        {
			
			
			
			
			
			Class.forName("com.mysql.jdbc.Driver");  
			con =DriverManager.getConnection("jdbc:mysql://localhost/weather","root","");
	            }
		catch(Exception ex)
	            {
			System.out.println(ex.getMessage());
		 }
		String st=ae.getActionCommand();
		
		if(st.equals("Clear"))
		{
			
			txt_Date.setText("");
			txt_Time.setText("");
			txt_Humidity.setText("");
			txt_Pressure.setText("");
			txt_windspeed.setText("");
			txt_windDirection.setText("");
			txt_Temperature.setText("");
		} 
		
		if(st.equals("logout"))
		{System.exit(0); 
			//tb page=new tb();
      // page.setVisible(true);
		
		}
		if(st.equals("Search"))
		{
			String se=txt_Date.getText();
			String te=txt_Time.getText();
			if(se.equals("")) {JOptionPane.showMessageDialog(null,"plz enter date");}
			if(te.equals("")) {JOptionPane.showMessageDialog(null,"plz enter time");}
			try{
			
			Statement stmt=con.createStatement();
			rs = ((java.sql.Statement) stmt).executeQuery("Select *from weatherdata where Date ='"+ se +"' && Time='"+ te +"'");
			
			 ResultSetMetaData rsmd = rs.getMetaData();
			if(rs.next())
			{
				
				txt_Date.setText(rs.getString("Date"));
				txt_Time.setText(rs.getString("Time"));
				txt_Humidity.setText(rs.getString("Humidity"));
				txt_Pressure.setText(rs.getString("Pressure"));	
				txt_windspeed.setText(rs.getString("windspeed"));
				txt_windDirection.setText(rs.getString("windDirection"));
				txt_Temperature.setText(rs.getString("Temperature"));
			}
			else {

                JOptionPane.showMessageDialog(null, "data not Found");

            }
			}
			catch(Exception ex)
			{		//	if(.equals(""))	JOptionPane.showMessageDialog(null,"no search results");	
							}
		
		}
		if(st.equals("Delete"))
		
		{String se=txt_Date.getText();
		String te=txt_Time.getText();
		if(se.equals("")) {JOptionPane.showMessageDialog(null,"plz enter date");}
		if(te.equals("")) {JOptionPane.showMessageDialog(null,"plz enter time");}
			try{
			Statement st2=con.createStatement();
			
			String query2="DELETE  from weatherdata WHERE Date='" + se + "' && Time='"+ te +"'";
			
		PreparedStatement ps= con.prepareStatement(query2);
			st2.executeUpdate(query2);
			}
			catch(Exception ex)
			{
			}
			
			txt_Date.setText("");
			txt_Time.setText("");
			txt_Humidity.setText("");
			txt_Pressure.setText("");
			txt_windspeed.setText("");
			txt_windDirection.setText("");
			txt_Temperature.setText("");
			JOptionPane.showMessageDialog(null,"Successfully deleted");
		}
		
	if(st.equals("edit"))
		{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");  
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String se=txt_Date.getText();
		String te=txt_Time.getText();	
		if(se.equals("")) {JOptionPane.showMessageDialog(null,"plz enter date");}
		if(te.equals("")) {JOptionPane.showMessageDialog(null,"plz enter time");}
			String s1=txt_Date.getText();
			String s2=txt_Time.getText();
			String s3=txt_Humidity.getText();
			String s4=txt_Pressure.getText();
			String s5=txt_windspeed.getText();
			String s6=txt_windDirection.getText();
			String s7=txt_Temperature.getText();
		
		DateFormat formatter2 = new SimpleDateFormat("hh:mm:ss");
		
			double Humidity= Double.parseDouble(s3);
			double Pressure= Double.parseDouble(s4);
			double windspeed= Double.parseDouble(s5);
		    int windDirection= Integer.parseInt(s6); 
			double Temperature= Double.parseDouble(s7);
			
		
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(Humidity);
			System.out.println(Pressure);
			System.out.println(windspeed);
			System.out.println(windDirection);
			System.out.println(Temperature);
			
			
			try{
			String query="UPDATE weatherdata SET Date=?,Time=?,Humidity=?,Pressure=?,windspeed=?,windDirection=?,Temperature=? WHERE Date='" + se + "' && Time='"+ te +"'";
				PreparedStatement ps= con.prepareStatement(query);
				
				 Date date2 = formatter.parse(s1);  
						
				
			
				
				ps.setString(1, s1);
				
				ps.setString(2, s2);
				ps.setDouble(3,Humidity);
				ps.setDouble(4,Pressure);
				ps.setDouble(5,windspeed);				
				ps.setInt(6, windDirection);
				ps.setDouble(7,Temperature);
				System.out.println(ps);
				
				int yesno = ps.executeUpdate();
				System.out.println(yesno);
				if(yesno == 1){
					System.out.println("Successfully updated");
				}else{
					System.out.println("Some error Occured");
				}
				
				
				txt_Date.setText("");
				txt_Time.setText("");
				txt_Humidity.setText("");
				txt_Pressure.setText("");
				txt_windspeed.setText("");
				txt_windDirection.setText("");
				txt_Temperature.setText("");
				
				JOptionPane.showMessageDialog(null,"Successfully edited");		
				
				
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}

	
				
				
	
		if(st.equals("Save"))
		{	
		/*	String se=txt_Date.getText();
			String te=txt_Time.getText();
			String le=txt_Date.getText();
			String fe=txt_Time.getText();
			if(se.equals("")) {JOptionPane.showMessageDialog(null,"plz enter date");}
			if(te.equals("")) {JOptionPane.showMessageDialog(null,"plz enter time");}
		*/	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");  
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		
		
		 
	
			
			String s2=txt_Date.getText();
			String s3=txt_Time.getText();
			String s4=txt_Humidity.getText();
			String s5=txt_Pressure.getText();
			String s6=txt_windspeed.getText();
			String s7=txt_windDirection.getText();
			String s8=txt_Temperature.getText();
			if(s2.equals("")) {JOptionPane.showMessageDialog(null,"plz enter date");}
			else if(s3.equals("")) {JOptionPane.showMessageDialog(null,"plz enter time");}
			else if(s4.equals("")) {JOptionPane.showMessageDialog(null,"plz enter humidity");}
			else if(s5.equals("")) {JOptionPane.showMessageDialog(null,"plz enter pressure");}
			else if(s6.equals("")) {JOptionPane.showMessageDialog(null,"plz enter wind speed");}
			else if(s7.equals("")) {JOptionPane.showMessageDialog(null,"plz enter wind direction");}
			else if(s8.equals("")) {JOptionPane.showMessageDialog(null,"plz enter temperature");}
			
			DateFormat formatter2 = new SimpleDateFormat("hh:mm:ss");
			
			     
			
						double Humidity= Double.parseDouble(s4);
			double Pressure= Double.parseDouble(s5);
			double windspeed= Double.parseDouble(s6);
		    int windDirection= Integer.parseInt(s7); 
			double Temperature= Double.parseDouble(s8);
			
		
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(Humidity);
			System.out.println(Pressure);
			System.out.println(windspeed);
			System.out.println(windDirection);
			System.out.println(Temperature);
		
			try{ 

				String query="insert into weatherdata (Date,Time,Humidity,Pressure,windDirection,windspeed,Temperature) values(?,?,?,?,?,?,?)"; 
				PreparedStatement ps= con.prepareStatement(query);
			
				
				 Date date2 = formatter.parse(s2);   
				
				
			
				
				
				
				
			ps.setString(1, s2);
				
				ps.setString(2, s3);
				ps.setDouble(3,Humidity);
				ps.setDouble(4,Pressure);
				ps.setDouble(6,windspeed);				
				ps.setInt(5, windDirection);
				ps.setDouble(7,Temperature);
				System.out.println(ps);
				
				int yesno = ps.executeUpdate();
				System.out.println(yesno);
				if(yesno == 1){
					System.out.println("Successfully Inserted");
				}else{
					System.out.println("Some error Occured");
				}
				
				
				txt_Date.setText("");
				txt_Time.setText("");
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
		}

	}
	

	
	
	public static void main(String args[])
	{
		weatherdataweather1 weather=new weatherdataweather1();
		weather.setVisible(true);
		weather.addWindowListener(new WindowAdapter()
		{ 
  			public void windowClosing(WindowEvent e)
			{  
               			System.exit(0);       
			}         
		});
		weather.setSize(new Dimension(571,504));
		weather.setVisible(true);
	}
}



