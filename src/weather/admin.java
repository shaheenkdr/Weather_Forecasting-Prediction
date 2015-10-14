package weather;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 347);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("GENARATE PREDICTION VALUE");
		btnNewButton.setBorder(new LineBorder(new Color(0, 100, 0)));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				predict page=new predict();
	 	        page.setVisible(true);
	 	       setVisible(false);
			    dispose();
			}
		});
		btnNewButton.setBounds(43, 241, 190, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" SAVE FORECAST DATA");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 255)));
		btnNewButton_1.setBackground(new Color(238, 130, 238));
		btnNewButton_1.setForeground(new Color(153, 50, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				forcastdata page=new forcastdata();
	 	        page.setVisible(true);
	 	       setVisible(false);
			    dispose();
			}
		});
		btnNewButton_1.setBounds(43, 62, 190, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SAVE PREDICTION DATA");
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 100, 0)));
		btnNewButton_2.setBackground(new Color(50, 205, 50));
		btnNewButton_2.setForeground(new Color(0, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				predictiondata page=new predictiondata();
	 	        page.setVisible(true);
	 	       setVisible(false);
			    dispose();
			}
		});
		btnNewButton_2.setBounds(43, 196, 190, 23);
		panel.add(btnNewButton_2);
		
		JButton btnBack = new JButton("logout");
		btnBack.setBackground(new Color(0, 100, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setForeground(new Color(224, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tb secondform = new tb();
			    secondform.setVisible(true);
			    setVisible(false);
			    dispose();
			}
		});
		btnBack.setBounds(325, 11, 89, 23);
		panel.add(btnBack);
		
		JButton btnNewButton_3 = new JButton("GENERATE FORECAST DATA");
		btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 255)));
		btnNewButton_3.setBackground(new Color(238, 130, 238));
		btnNewButton_3.setForeground(new Color(153, 50, 204));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				adminforcastdata secondform = new adminforcastdata();
			    secondform.setVisible(true);
			    setVisible(false);
			    dispose();
			}
		});
		btnNewButton_3.setBounds(43, 109, 190, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\dataeclipse\\weather\\images\\sun 3 - Copy.jpg"));
		lblNewLabel.setBounds(0, 0, 463, 347);
		panel.add(lblNewLabel);
	}
}
