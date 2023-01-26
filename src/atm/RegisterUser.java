package atm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class RegisterUser extends JFrame {

	private JPanel contentPane;
	private JTextField accnum;
	private JTextField username;
	private JPasswordField userpin;
	private JTextField aadharnum;
	private JTextField mobilenum;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField email;
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement p;
	private final Action action = new SwingAction();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUser frame = new RegisterUser();
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
	public RegisterUser() {
		setTitle("Register New User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register User");
		lblNewLabel.setBackground(new Color(176, 224, 230));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(20, 10, 156, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account Number :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(21, 61, 155, 30);
		contentPane.add(lblNewLabel_1);
		
		accnum = new JTextField();
		accnum.setFont(new Font("Times New Roman", Font.BOLD, 18));
		accnum.setBounds(186, 62, 237, 30);
		contentPane.add(accnum);
		accnum.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Name :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(21, 100, 155, 30);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.BOLD, 18));
		username.setColumns(10);
		username.setBounds(186, 103, 237, 30);
		contentPane.add(username);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("User Pin :");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(21, 142, 155, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		userpin = new JPasswordField();
		userpin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userpin.setBounds(186, 144, 237, 30);
		contentPane.add(userpin);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Aadhar Number :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1_1_1.setBounds(21, 225, 155, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		aadharnum = new JTextField();
		aadharnum.setFont(new Font("Times New Roman", Font.BOLD, 18));
		aadharnum.setColumns(10);
		aadharnum.setBounds(186, 225, 237, 30);
		contentPane.add(aadharnum);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Mobile Number :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1_1_1_1.setBounds(21, 266, 155, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		mobilenum = new JTextField();
		mobilenum.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mobilenum.setColumns(10);
		mobilenum.setBounds(186, 266, 237, 30);
		contentPane.add(mobilenum);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Gender :");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(21, 307, 155, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JRadioButton male = new JRadioButton("Male");
		buttonGroup.add(male);
		male.setFont(new Font("Times New Roman", Font.BOLD, 18));
		male.setBounds(185, 303, 78, 30);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("FeMale");
		buttonGroup.add(female);
		female.setFont(new Font("Times New Roman", Font.BOLD, 18));
		female.setBounds(273, 303, 101, 30);
		contentPane.add(female);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Email Address :");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(21, 348, 155, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.BOLD, 18));
		email.setColumns(10);
		email.setBounds(186, 348, 237, 30);
		contentPane.add(email);
		
		JLabel lblNewLabel_1_2 = new JLabel("Account Type :");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(21, 183, 155, 30);
		contentPane.add(lblNewLabel_1_2);
		
		JRadioButton current = new JRadioButton("Current");
		buttonGroup_1.add(current);
		current.setFont(new Font("Times New Roman", Font.BOLD, 18));
		current.setBounds(186, 181, 94, 30);
		contentPane.add(current);
		
		JRadioButton saving = new JRadioButton("Saving");
		buttonGroup_1.add(saving);
		saving.setFont(new Font("Times New Roman", Font.BOLD, 18));
		saving.setBounds(280, 181, 94, 30);
		contentPane.add(saving);
		
		JButton register = new JButton("Regiser");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
					st=con.createStatement();
					String accountnumber=accnum.getText();
					String uname=username.getText();
					String upin=new String(userpin.getPassword());
					String aadhar=aadharnum.getText();
					String mobile=mobilenum.getText();
					String emailid=email.getText();
					String gender="";
					if(male.isSelected()) {
						gender+=male.getText();
					}else if(female.isSelected()) {
						gender+=female.getText();
					}
					String acctype="";
					if(current.isSelected()) {
						acctype+=current.getText();
					}else if(saving.isSelected()) {
						acctype+=saving.getText();
					}
					String balance="0";
					String mobileRecharge="0";
					
					p=con.prepareStatement("insert into registeruser values(?,?,?,?,?,?,?,?,?,?,?)");
					p.setString(1, accountnumber);
					p.setString(2, uname);
					p.setString(3, upin);
					p.setString(4, acctype);
					p.setString(5, aadhar);
					p.setString(6, mobile);
					p.setString(7, gender);
					p.setString(8, emailid);
					p.setString(9, balance);
					p.setString(10, mobileRecharge);
					p.setString(11, getSystemTime());
					long l=p.executeUpdate();
					if(l>0) {
						JOptionPane.showMessageDialog(getParent(), "Registered Successful!");
						accnum.setText("");
						username.setText("");
						userpin.setText("");
						aadharnum.setText("");
						mobilenum.setText("");
						email.setText("");
						buttonGroup.clearSelection();
						buttonGroup_1.clearSelection();
					}else {
						JOptionPane.showMessageDialog(getParent(), "Registration not completed, Try Again!");
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				finally {
					try {
						con.close();
						st.close();
					} catch (SQLException ea) {
						// TODO Auto-generated catch block
						ea.printStackTrace();
					}
				}
			}
		});
		register.setFont(new Font("Tahoma", Font.BOLD, 24));
		register.setBounds(110, 385, 139, 38);
		contentPane.add(register);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accnum.setText("");
				username.setText("");
				userpin.setText("");
				aadharnum.setText("");
				mobilenum.setText("");
				email.setText("");
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
			}
		});
		reset.setFont(new Font("Tahoma", Font.BOLD, 24));
		reset.setBounds(303, 385, 139, 38);
		contentPane.add(reset);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home hm=new home();
				hm.setVisible(true);
				dispose();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLogin.setBounds(438, 10, 139, 38);
		contentPane.add(btnLogin);
		
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public static String getSystemTime()
	{
		java.util.Date date=new java.util.Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss:SS");
		String strDate=formatter.format(date);
		return strDate;
	}
	
}
