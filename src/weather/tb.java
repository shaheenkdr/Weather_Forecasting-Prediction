package weather;





import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;
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
import java.io.OutputStream;
import javax.swing.JTextArea;
import java.io.IOException;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class tb extends JFrame implements ActionListener
{
        JTabbedPane t1=new JTabbedPane();
       
        JPanel p1,p2,p3,p4,p5,displayadminPanel,displayforcastPanel,displaypredictPanel;
        private JPanel p1_1;
        Container c;
        Container c1;
        Connection con;	
      
        JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9, l10, l11;
        JTextField text1,text2,text3,text4,text5,text6,text8,text9,text10,text11,text12,text13,text14,text15;
        JPasswordField t_pass;
        JButton b2,b3;
        private JLabel lblNewLabel;
        private JLabel lblNewLabel_1;
        private JTextField textField;
        private JTextArea textArea;
        private JLabel lblNewLabel_2;
        private JLabel lblHereYouCan_1;
        private JLabel lblAdminLogin;
        private JLabel label_2;
        private JLabel lblHpa;
        private JLabel label_5;
        private JLabel lblKmh;
        private JLabel lblc;
        

        public tb()
        {
        	setResizable(false);
        	setSize(new Dimension(438, 472));
        	setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\dataeclipse\\weather\\images\\FLOWER.JPG"));
        	setForeground(new Color(139, 69, 19));
        	setBackground(new Color(25, 25, 112));   
        	
                p1=new JPanel();
                p3=new JPanel();
                p3.setBackground(SystemColor.textHighlight);
                p4=new JPanel();
                p4.setBackground(SystemColor.textHighlight);
                p5=new JPanel();
                JPanel p6=new JPanel();
                p6.setAlignmentY(Component.BOTTOM_ALIGNMENT);
                p6.setAlignmentX(Component.RIGHT_ALIGNMENT);
                p6.setBackground(SystemColor.textHighlight);
                displayadminPanel  = new JPanel();
                displayforcastPanel = new JPanel();
                displaypredictPanel = new JPanel();
                displaypredictPanel.setBackground(SystemColor.textHighlight);
                displaypredictPanel.setForeground(SystemColor.textHighlight);
                         
                c1=getContentPane();
             

                l1=new JLabel("TEMPERATURE INFORMATION SYSTEM");
                l2=new JLabel("GETTEMPERATURE");
                l3=new JLabel("Humidity"); 
                l4=new JLabel("Pressure");
                l5=new JLabel("windDirection");
                l6=new JLabel("windspeed");
                l7=new JLabel("Temperature");
                l8=new JLabel("today"); 
                l9=new JLabel("upto");
                l10=new JLabel("username"); 
                l11=new JLabel("password");
                text3=new JTextField(10);
                text6=new JTextField(10);
                text8=new JTextField(10);
                text8.setCaretColor(new Color(153, 50, 204));
                text8.setBounds(159, 60, 86, 20);
              
                t_pass=new JPasswordField(10);
                t_pass.setCaretColor(new Color(153, 50, 204));
                t_pass.setBounds(159, 121, 86, 20);
                text10=new JTextField(10);
                text11=new JTextField(10);
                text12=new JTextField(10);
                text13=new JTextField(10);
                text14=new JTextField(10);
                text15=new JTextField(10);
                b2=new JButton("forecast");
                b2.setBorder(new LineBorder(new Color(0, 0, 255)));
               
                b2.addActionListener(new ActionListener() 
                {
                	
                	public void actionPerformed(ActionEvent arg0)
                	{
                	
                		 try {
                		      
                		    //  String forcastdata = "forecast4.arff";
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
                		     textArea.setSize(225,250);
                		   //  textArea.setPreferredSize(new Dimension(225,290));
                             textArea.setBounds(158, 70, 225, 270);
                             textArea.setEditable(true);
                           //  textArea.setLineWrap(true);
                             textArea.setBackground(Color.WHITE);
                             textArea.setFont(new Font("Lucida Console", Font.PLAIN, 13));
                             textArea.setForeground(Color.blue);
                             
                             p4.add(textArea);
                           
                		     
                		     
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
                              
                             // p4.add(textArea);
                		    
                		    } 
                		catch (Exception ex)
                		{ex.printStackTrace();
                		}
                	}
                
                				
                				
                				
                				
 });
               
                b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
                b2.setBounds(10, 74, 103, 34);
                b3=new JButton("login");
                b3.setBorder(new LineBorder(new Color(153, 50, 204)));
                b3.setBounds(93, 189, 103, 34);
                b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
                b2.setForeground(new Color(0, 100, 0));
                b2.setBackground(new Color(204, 204, 255));
                b3.setForeground(new Color(0, 100, 0));
                b3.setBackground(new Color(204, 204, 255));
               
              
         
                
               displaypredictPanel.setLayout(new BorderLayout());
               setContentPane(new JLabel(new ImageIcon("D:\\dataeclipse\\weather\\src\\FLOWER.JPG")));
               displaypredictPanel.add(p3, BorderLayout.SOUTH);
               p3.setLayout(null);
             
       
                displayforcastPanel.setLayout(new BorderLayout());
                displayforcastPanel.add(p4, BorderLayout.CENTER);
                p4.setLayout(null);
                 p4.add(b2);
                 
          /*       JTextArea textArea = new JTextArea();
                 textArea.setBounds(158, 70, 225, 290);
                 p4.add(textArea);
           */      
                 
                 lblHereYouCan_1 = new JLabel("Here you can forecast coming days Temperature ");
                 lblHereYouCan_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
                 lblHereYouCan_1.setForeground(new Color(255, 255, 255));
                 lblHereYouCan_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                 lblHereYouCan_1.setBounds(41, 11, 359, 29);
                 p4.add(lblHereYouCan_1);
                 lblNewLabel_1 = new JLabel("New label");
                 lblNewLabel_1.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\received_727132534063862 - Copy.jpeg"));
                 lblNewLabel_1.setBounds(0, 0, 427, 415);
                 p4.add(lblNewLabel_1);
        
              
              displayadminPanel.setLayout(new BorderLayout());
              displayadminPanel.add(p6, BorderLayout.CENTER);
              p6.setLayout(null);
           
             
              JLabel label = new JLabel("username ");
              label.setBounds(35, 59, 86, 19);
              label.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
              label.setForeground(Color.WHITE);
              label.setBackground(Color.WHITE);
              p6.add(label);
              p6.add(text8);
              JLabel label_1 = new JLabel("password");
              label_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
              label_1.setBounds(35, 120, 70, 19);
              label_1.setForeground(Color.WHITE);
              p6.add(label_1);
              p6.add(t_pass);
             
              p6.add(b3);
              
              lblAdminLogin = new JLabel("   Admin Login");
              lblAdminLogin.setBorder(new LineBorder(new Color(240, 255, 255)));
              lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
              lblAdminLogin.setForeground(new Color(255, 255, 255));
              lblAdminLogin.setBounds(75, 11, 121, 27);
              p6.add(lblAdminLogin);
              
              lblNewLabel = new JLabel("New label");
              lblNewLabel.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\received_727132530730529 - Copy (2).jpeg"));
              lblNewLabel.setBounds(0, 0, 425, 415);
              p6.add(lblNewLabel);
               c=getContentPane();
                c.setLayout(new BorderLayout());
                t1.setForeground(new Color(0, 0, 255));
                t1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
                t1.setBackground(new Color(255, 255, 255));

                t1.addTab("predict",displaypredictPanel);
                p2=new JPanel();
                p2.setMaximumSize(new Dimension(32767, 32744));
                displaypredictPanel.add(p2, BorderLayout.CENTER);
                p2.setBackground(SystemColor.textHighlight);
                p2.setLayout(null);
                p1_1 = new JPanel();
                p1_1.setBounds(0, 0, 427, 414);
                p2.add(p1_1);
                p1_1.setForeground(Color.LIGHT_GRAY);
                p1_1.setBackground(SystemColor.textHighlight);
                
                 

                 text1=new JTextField(10);
                 text1.setForeground(new Color(0, 0, 255));
                 text1.setBounds(194, 71, 122, 22);
                 text2=new JTextField(10);
                 text2.setForeground(new Color(0, 0, 255));
                 text2.setBounds(194, 123, 122, 22);
                 text4=new JTextField(10);
                 text4.setForeground(new Color(0, 0, 255));
                 text4.setBounds(194, 218, 122, 22);
                 
             //   b1.setPreferredSize(new Dimension(150,80));
               //   p1_1.setPreferredSize(new Dimension(200,250));
                  //   text5.setPreferredSize(new Dimension(200,30));
                //    text1.setPreferredSize(new Dimension(86,20));
                     p1_1.setLayout(null);
              
              textField = new JTextField();
              textField.setForeground(new Color(0, 0, 255));
              textField.setBounds(194, 171, 122, 20);
              p1_1.add(textField);
              textField.setColumns(10);
                     
              
              JLabel label_3 =  new JLabel("Humidity");
              label_3.setBounds(30, 63, 88, 37);
              label_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
              label_3.setForeground(new Color(230, 230, 250));
              p1_1.add(label_3);
              p1_1.add(text1);
              JLabel label_4 = new JLabel("Pressure");
              label_4.setBounds(30, 115, 88, 37);
              label_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
              label_4.setForeground(new Color(230, 230, 250));
              p1_1.add(label_4);
              p1_1.add(text2);
              JLabel lblWinddirection = new JLabel("WindDirection");
              lblWinddirection.setBounds(30, 155, 111, 50);
              lblWinddirection.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
              lblWinddirection.setForeground(new Color(230, 230, 250));
              p1_1.add(lblWinddirection);
              JLabel lblWindspeed = new JLabel("WindSpeed");
              lblWindspeed.setBounds(30, 210, 105, 37);
              lblWindspeed.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
              lblWindspeed.setForeground(new Color(230, 230, 250));
              p1_1.add(lblWindspeed);
              p1_1.add(text4);
             
              
              JButton b1=new JButton("gettemp");
              b1.setBorder(new LineBorder(Color.BLUE));
              b1.setBounds(95, 281, 124, 27);
              p1_1.add(b1);
               b1.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent arg0)
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
            		String st=arg0.getActionCommand();
            		if(st.equals("gettemp"))
            		{
            				String se=text1.getText();
            				if(se.equals("")) {JOptionPane.showMessageDialog(null,"plz enter humidity");}	
            				String te=text2.getText();
            				if(te.equals("")) {JOptionPane.showMessageDialog(null,"plz enter pressure");}	
            				String re=text4.getText();
            				if(re.equals("")) {JOptionPane.showMessageDialog(null,"plz enter windspeed");}	
            				String we=textField.getText();
            				if(we.equals("")) {JOptionPane.showMessageDialog(null,"plz enter winddirection");}	
            			//	String pe=text5.getText();
            				double Humidity= Double.parseDouble(se);
            				double Pressure= Double.parseDouble(te);
            				double windspeed= Double.parseDouble(re);
            				double windDirection= Double.parseDouble(we);
            			//	double Temperature= Double.parseDouble(pe);
            				
            				double hum = 0;
        					double pres = 0;
        					double  wdir = 0;
        					double wspeed = 0;
        					double constant = 0;
            				
            				
            			try{
            				
            				Statement stmt=con.createStatement();
            				
            				rs = ((java.sql.Statement) stmt).executeQuery(" SELECT * FROM prediction ORDER BY id DESC LIMIT 1");
            				
            				
            				
            				
            				 ResultSetMetaData rsmd = rs.getMetaData();
            				while(rs.next())
            				{
            					
            					
            					hum = rs.getDouble(3);
            					pres = rs.getDouble(4);
            					wdir = rs.getDouble(5);
            					wspeed = rs.getDouble(6);
            					constant = rs.getDouble(7);
            					
            				//	text5.setText(rs.getString(""));
            					
            				}
            				
            				double temperature;
            				
            				
            				temperature = (hum * Humidity) + (pres * Pressure) + (wspeed * windspeed) +(wdir * windDirection )+ constant;
            				
            				text5.setText(String.valueOf(temperature));
            				
            				
            				}
            				catch(Exception ex)
            				{}
            			
            			}
            		}
              	
              });     
               
              b1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
              b1.setAlignmentX(Component.RIGHT_ALIGNMENT);
              

                   b1.setForeground(new Color(0, 100, 0));
                   b1.setBackground(new Color(204, 204, 255));
                   text5=new JTextField(15);
                   text5.setBounds(194, 339, 122, 22);
                   p1_1.add(text5);
                   text5.setForeground(new Color(0, 0, 255));
                   text5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                   JLabel label_7 = new JLabel("Temperature");
                   label_7.setBounds(29, 337, 112, 22);
                   p1_1.add(label_7);
                   label_7.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
                   label_7.setHorizontalAlignment(SwingConstants.RIGHT);
                   label_7.setForeground(new Color(230, 230, 250));
                   label_7.setAlignmentX(Component.RIGHT_ALIGNMENT);
                   
                   JButton btnNewButton = new JButton("clear");
                   btnNewButton.setBorder(new LineBorder(new Color(0, 0, 255)));
                   btnNewButton.setForeground(new Color(0, 100, 0));
                   btnNewButton.setBackground(new Color(204, 204, 255));
                   btnNewButton.addActionListener(new ActionListener() 
                   {
                   	public void actionPerformed(ActionEvent arg0) 
                   	{
                   		text1.setText("");
            			text2.setText("");
            			textField.setText("");
            			text4.setText("");
            			text5.setText("");
            			
                   	}
                   });
                   btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
                   btnNewButton.setBounds(108, 376, 111, 27);
                   p1_1.add(btnNewButton);
                   
                   JLabel lblHereYouCan = new JLabel("Here you can predict the Temperature");
                   lblHereYouCan.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
                   lblHereYouCan.setForeground(new Color(255, 255, 255));
                   lblHereYouCan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
                   lblHereYouCan.setBounds(58, 11, 316, 31);
                   p1_1.add(lblHereYouCan);
                   
                   label_2 = new JLabel("%");
                   label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
                   label_2.setForeground(new Color(128, 0, 0));
                   label_2.setBounds(326, 75, 46, 14);
                   p1_1.add(label_2);
                   
                   lblHpa = new JLabel("hPa");
                   lblHpa.setForeground(new Color(128, 0, 0));
                   lblHpa.setFont(new Font("Tahoma", Font.BOLD, 11));
                   lblHpa.setBounds(326, 127, 46, 14);
                   p1_1.add(lblHpa);
                   
                   label_5 = new JLabel("\u00B0");
                   label_5.setForeground(new Color(128, 0, 0));
                   label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
                   label_5.setBounds(326, 174, 46, 14);
                   p1_1.add(label_5);
                   
                   lblKmh = new JLabel("km/h");
                   lblKmh.setForeground(new Color(128, 0, 0));
                   lblKmh.setFont(new Font("Tahoma", Font.BOLD, 11));
                   lblKmh.setBounds(326, 222, 46, 14);
                   p1_1.add(lblKmh);
                   
                   lblc = new JLabel("\u00B0C");
                   lblc.setFont(new Font("Tahoma", Font.BOLD, 11));
                   lblc.setForeground(new Color(128, 0, 0));
                   lblc.setBounds(326, 343, 46, 14);
                   p1_1.add(lblc);
                   
                   lblNewLabel_2 = new JLabel("New label");
                   lblNewLabel_2.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\received_727132530730529 - Copy.jpeg"));
                   lblNewLabel_2.setBounds(0, 1, 427, 413);
                   p1_1.add(lblNewLabel_2);
                t1.addTab("forecast", displayforcastPanel);
                t1.addTab("admin",displayadminPanel);
                c.add(t1);
                setTitle("TEMPERATURE  INFORMATION SYSTEM");
        		   b3.addActionListener(this);
        		 //  b1.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae)
        {
        String value1=text8.getText();
        if(value1.equals("")) {JOptionPane.showMessageDialog(null,"plz enter username");}
        String value2=t_pass.getText();
      
		if(value2.equals("")) {JOptionPane.showMessageDialog(null,"plz enter password");}
      
        
        if (value1.equals("123") && value2.equals("123")) {
        	admin page=new admin();
        page.setVisible(true);
        setVisible(false);
	    dispose();
    
        }
        else{
        System.out.println("enter the valid username and password");
        JOptionPane.showMessageDialog(this,"Incorrect login or password",
        "Error",JOptionPane.ERROR_MESSAGE);
        }
        text8.setText("");
    	t_pass.setText("");
        
                
}
        public static void main(String args[])
        {try
        {
        	tb tdemo=new tb();
                tdemo.setSize(438,472);
        		  tdemo.setVisible(true); }
       catch(Exception e)
        		   {JOptionPane.showMessageDialog(null, e.getMessage());}
        }
}
