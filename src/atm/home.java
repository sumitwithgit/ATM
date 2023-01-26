package atm;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class home extends JFrame {
	int count=0;
	private JPanel contentPane;
	private JPasswordField password;
	String userid;
	Connection con;
	Statement st;
	ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setTitle("Login Our Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alex\\Pictures\\icon\\Bank-of-Baroda-logo.png"));
		lblNewLabel.setBounds(197, 11, 170, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the pin");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(113, 93, 338, 76);
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.BOLD, 18));
		password.setBounds(149, 180, 267, 42);
		contentPane.add(password);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
					st=con.createStatement();
					String upin=new String(password.getPassword());
					rs=st.executeQuery("select * from registeruser where userpin='"+upin+"'");
					int f=0;
					count++;
					if(count<3)
					{
						if(rs.next())
						{
							String account_number=rs.getString("accnum");
							String user_name=(rs.getString("username"));
							String user_pin=(rs.getString("userpin"));
							String account_type=(rs.getString("accounttype"));
							String aadhar_number=(rs.getString("aadharnum"));
							String mobile_number=(rs.getString("mobilenum"));
							String gender=(rs.getString("gender"));
							String emailId=(rs.getString("email"));
							String Balance=(rs.getString("balance"));
							
							JOptionPane.showMessageDialog(getParent(), "Welcome, Login Successful :- "+user_name);
							atmoptions am=new atmoptions(account_number,user_name);
							am.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(getParent(), "Pin Incorrect. Try Again! "+count);
						}
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "you have exceded maximum attempts: "+count);
						password.setEnabled(false);
						dispose();
					}
				
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				finally {
					try {
						con.close();
						st.close();
						rs.close();
					} catch (SQLException ea) {
						// TODO Auto-generated catch block
						ea.printStackTrace();
					}
				}
			}
		});
		login.setFont(new Font("Times New Roman", Font.BOLD, 18));
		login.setBounds(149, 259, 120, 42);
		contentPane.add(login);
		
		JButton Reset = new JButton("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password.setText("");
			}
		});
		Reset.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Reset.setBounds(311, 259, 105, 42);
		contentPane.add(Reset);
		
		JButton btnRegisterNewUser = new JButton("Register New User");
		btnRegisterNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUser ru=new RegisterUser();
				ru.setVisible(true);
				dispose();
			}
		});
		btnRegisterNewUser.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRegisterNewUser.setBounds(391, 381, 186, 42);
		contentPane.add(btnRegisterNewUser);
	}
}