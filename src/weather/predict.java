package weather;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.*;
//import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class predict extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Connection con;	
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					predict frame = new predict();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public predict() 
	{
		setTitle("Admin Predict");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\dataeclipse\\weather\\images\\FLOWER.JPG"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(475, 103, 223, 369);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(153, 50, 204));
		textField_4.setBounds(104, 237, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("constant");
		lblNewLabel_11.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_11.setForeground(new Color(139, 0, 0));
		lblNewLabel_11.setBounds(10, 240, 74, 14);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblL = new JLabel("Humidity");
		lblL.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblL.setForeground(new Color(139, 0, 0));
		lblL.setBounds(10, 79, 74, 14);
		panel_1.add(lblL);
		
		textField = new JTextField();
		textField.setForeground(new Color(153, 50, 204));
		textField.setBounds(104, 76, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pressure");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setBounds(10, 121, 74, 14);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(153, 50, 204));
		textField_1.setBounds(104, 118, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("windDirection");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(139, 0, 0));
		lblNewLabel_2.setBounds(10, 163, 94, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(153, 50, 204));
		textField_2.setBounds(104, 160, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("windspeed");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_3.setForeground(new Color(139, 0, 0));
		lblNewLabel_3.setBounds(10, 204, 74, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(153, 50, 204));
		textField_3.setBounds(104, 201, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 255)));
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{ResultSet rs = null; 
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
if(st.equals("submit"))
{		String s1=textField.getText();
if(s1.equals("")) {JOptionPane.showMessageDialog(null,"plz enter humidity");}
	String s2=textField_1.getText();
	if(s2.equals("")) {JOptionPane.showMessageDialog(null,"plz enter pressure");}	
	String s3=textField_2.getText();
	if(s3.equals("")) {JOptionPane.showMessageDialog(null,"plz enter winddirection");}
	String s4=textField_3.getText();
	if(s4.equals("")) {JOptionPane.showMessageDialog(null,"plz enter windspeed");}
	String s5=textField_4.getText();
	if(s5.equals("")) {JOptionPane.showMessageDialog(null,"plz enter constantvalue");}
	double Humidity= Double.parseDouble(s1);
	double Pressure= Double.parseDouble(s2);
	double windDirection= Double.parseDouble(s3); 
	double windspeed= Double.parseDouble(s4);
	double constant = Double.parseDouble(s5);
		 
try{ 

	String query="insert into prediction (Humidity,Pressure,windDirection,windspeed,constant) values(?,?,?,?,?)"; 
	PreparedStatement ps= con.prepareStatement(query);
	ps.setDouble(1,Humidity);
	ps.setDouble(2,Pressure);
	ps.setDouble(3,windDirection);
	ps.setDouble(4,windspeed);
	ps.setDouble(5,constant);
	
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
	textField_2.setText("");
	textField_3.setText("");
	textField_4.setText("");
	
	
	JOptionPane.showMessageDialog(null,"Successfully inserted");
	

}


			catch(Exception ex)
						{
								System.out.println(ex.getMessage());
								}
		}

			}
	}
		);
	
		
		
		
		btnNewButton_1.setBounds(65, 281, 89, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(204, 204, 255));
		btnNewButton_1.setForeground(new Color(0, 100, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Enter Genarated Values ");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setForeground(new Color(240, 255, 255));
		lblNewLabel_5.setBounds(10, 23, 164, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(-462, -146, 812, 474);
		panel_1.add(lblNewLabel_9);
		lblNewLabel_9.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\most-beautiful-landscape-world-view-high-resolution-wallpaper-download-free.jpg"));
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 39, 311, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 205)));
		btnNewButton.setForeground(new Color(139, 0, 139));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(101, 47, 114, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Generate value");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(10, 11, 249, 14);
		panel.add(lblNewLabel);
		final JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(138, 43, 226));
		textArea.setBounds(78, 111, 227, 251);
		panel.add(textArea);
		
		JLabel lblNewLabel_6 = new JLabel("Values are");
		lblNewLabel_6.setForeground(new Color(240, 255, 255));
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(10, 81, 107, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(0, -49, 311, 427);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\most-beautiful-landscape-world-view-high-resolution-wallpaper-download-free.jpg"));
		
		JButton btnNewButton_2 = new JButton("<--back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
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
		btnNewButton_2.setBounds(10, 401, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\most-beautiful-landscape-world-view-high-resolution-wallpaper-download-free.jpg"));
		lblNewLabel_7.setBounds(0, -43, 736, 485);
		contentPane.add(lblNewLabel_7);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			
			{
				try
				{
				DataSource source = new DataSource("datafortraining11.csv");
			//	DataSource source = new DataSource("wd2.csv");
				Instances dataset = source.getDataSet();
				//set class index to the last attribute
				dataset.setClassIndex(dataset.numAttributes()-1);
				
				//build model
				LinearRegression lr = new LinearRegression();
				lr.buildClassifier(dataset);
				//output model
				//System.out.println(dataset.numAttributes());
				System.out.println(lr);
			//	textArea.settext(lr.getString("lr"));
				String str= new String();
				str=lr.toString();
				
				textArea.setText(str);
				
				
			}
						
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			 }
			}
		});
	}

public static void main(String args[])
{
	predict weather=new predict();
	weather.setVisible(true);
	weather.addWindowListener(new WindowAdapter()
	{ 
			public void windowClosing(WindowEvent e)
		{  
           			System.exit(0);       
		}         
	});
	weather.setSize(new Dimension(742,462));
	weather.setVisible(true);
}




}
