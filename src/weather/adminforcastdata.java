package weather;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.util.Date;
import java.util.Vector; 
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.io.*;
import java.util.List;

import weka.core.Instances;
import weka.classifiers.evaluation.NumericPrediction;
import weka.classifiers.timeseries.WekaForecaster;
import weka.classifiers.timeseries.core.TSLagMaker;
import weka.classifiers.functions.GaussianProcesses;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.*;
//import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.FileWriter;
import java.io.File;
import java.io.PrintStream;
import java.io.Writer;
import java.io.IOException;

import com.csvreader.CsvWriter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class adminforcastdata extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Connection con;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminforcastdata frame = new adminforcastdata();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminforcastdata() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\dataeclipse\\weather\\images\\FLOWER.JPG"));
		setTitle("Admin Forcast");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("forecast data entry");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(151, 11, 153, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("forecast");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 255)));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try {
      		      
					String forcastdata = "forcsv.csv";
            		
      		      
      		      Instances fdata = new Instances(new BufferedReader(new FileReader(forcastdata)));

      		      
      		      WekaForecaster forecaster = new WekaForecaster();

      		      
      		      forecaster.setFieldsToForecast("Temperature");

      		      
      		      forecaster.setBaseForecaster(new GaussianProcesses());

      		      forecaster.getTSLagMaker().setTimeStampField("Date"); 
      		  forecaster.getTSLagMaker().setMinLag(1);
      		  forecaster.getTSLagMaker().setMaxLag(90); 

      		      
      		     forecaster.getTSLagMaker().setAddDayOfWeek(true);
      		     
      		     forecaster.getTSLagMaker().setAddWeekendIndicator(true);
      		     
      		    forecaster.buildForecaster(fdata, System.out);

      		     
      		      forecaster.primeForecaster(fdata);

      		     
      		      PrintStream data1 = new PrintStream(System.out);
      		      
      		      
      		      List<List<NumericPrediction>> forecast = forecaster.forecast(7, data1);
      		      double[] result = new double[10]; // to store result in double
      		      
      		      String forecastedData = new String(); // to store result converted from double 
      		      String ka= new String();
      		      ka = " ";
      		      
      		     forecastedData = " ";
      		     
      		     JTextArea textArea = new JTextArea();
                   textArea.setBounds(22, 114, 155, 235);
                   textArea.setEditable(true);
                   textArea.setLineWrap(true);
                   textArea.setBackground(Color.WHITE);
                   textArea.setFont(new Font("Lucida Console", Font.PLAIN, 13));
                   textArea.setForeground(Color.blue);
                   contentPane.add(textArea);
                 
      		     
      		     
      		      for (int i = 0; i < 7; i++) 
      		      {
      		        List<NumericPrediction> predsAtStep = forecast.get(i);
      		        for (int j = 0; j < 1; j++)
      		        {
      		          NumericPrediction predForTarget = predsAtStep.get(j);
      		         // System.out.print("" + predForTarget.predicted() + " ");
      		          result[i]= predForTarget.predicted();
      		          
      		          
      		          
      		          /*     String str= new String();
      		               str="" + predForTarget.predicted() + " ".toString();
      				//str=predForTarget.toString();             					
      		               textArea.setText(str);
      		         */
      		         
      		        }
      		       // System.out.println(data1);
      		        
      		        System.out.println(result[i]);
      		        
      		        
      		        //forecastedData = forecastedData.concat(Double.toString(result[i]));
      		       
      		        ka = ka.concat(Double.toString(result[i])) ;
      		        ka = ka.concat(" \n ") ;
      		     //   ka = ka.concat(" \n ") ;
      		       // textArea.setText(ka);
      		       
      	/*	        JTextArea textArea = new JTextArea();
                      textArea.setBounds(158, 70, 225, 290);
                      textArea.setEditable(true);
                      textArea.setLineWrap(true);
                      textArea.setBackground(Color.WHITE);
                      textArea.setFont(new Font("Lucida Console", Font.PLAIN, 13));
                      textArea.setForeground(Color.blue);
                    
                      p4.add(textArea);
      		        textArea.append(ka);
      		        textArea.setText(ka);
      		 */       
      		      }

      		   textArea.setText(ka);
                    
      		// contentPane.add(textArea);
      		    
      		    } 
      		catch (Exception ex)
      		{ex.printStackTrace();
      		}
      	}
		});
		btnNewButton.setBounds(22, 53, 89, 23);
		contentPane.add(btnNewButton);
		
	/*	JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 114, 147, 231);
		contentPane.add(textArea);
	*/	
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setBounds(194, 156, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Temperature");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(194, 211, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setForeground(new Color(153, 50, 204));
		textField.setBounds(290, 153, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(153, 50, 204));
		textField_1.setBounds(290, 205, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("save");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 255)));
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(0, 100, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
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
				String st=e.getActionCommand();
				if(st.equals("save"))
				{	
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");  
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
				
				
				 
			
					
					String s2=textField.getText();
					String s3=textField_1.getText();
				
					DateFormat formatter2 = new SimpleDateFormat("hh:mm:ss");
					
					     
					
					double Temperature= Double.parseDouble(s3);
					
					
				
					System.out.println(s2);
					System.out.println(s3);
				
					try{ 

						String query="insert into forcast (Date,Temperature) values(?,?)"; 
						PreparedStatement ps= con.prepareStatement(query);
					
						
						 Date date2 = formatter.parse(s2);  
						
						
						 ps.setString(1, s2);
							
							
							ps.setDouble(2,Temperature);
						
						
						
						
					
					
						System.out.println(ps);
						
						int yesno = ps.executeUpdate();
						System.out.println(yesno);
						if(yesno == 1){
							System.out.println("Successfully Inserted");
						}else{
							System.out.println("Some error Occured");
						}
						
						
						textField.setText("");
						textField_1.setText("");
					
						JOptionPane.showMessageDialog(null,"Successfully inserted");	
						
					}
					catch(Exception ex)
					{
						System.out.println(ex.getMessage());
					}
				}

			}
		});
		btnNewButton_1.setBounds(211, 263, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<--back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				admin secondform = new admin();
			    secondform.setVisible(true);
			    setVisible(false);
			    dispose();
			}
		});
		btnNewButton_2.setBounds(0, 372, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\most-beautiful-landscape-world-view-high-resolution-wallpaper-download-free.jpg"));
		lblNewLabel_3.setBounds(0, 0, 433, 406);
		contentPane.add(lblNewLabel_3);
	}
}
