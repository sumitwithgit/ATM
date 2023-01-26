package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class deposite extends JFrame {

	private JPanel contentPane;
	private JTextField depositeamt;
	String useracc;
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement p;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deposite frame = new deposite();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}				*/

	/**
	 * Create the frame.
	 */
	public deposite(String useracc) {
		this.useracc=useracc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the amount you want to deposite in your account");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 43, 567, 41);
		contentPane.add(lblNewLabel);
		
		depositeamt = new JTextField();
		depositeamt.setFont(new Font("Tahoma", Font.BOLD, 24));
		depositeamt.setBounds(103, 114, 373, 56);
		contentPane.add(depositeamt);
		depositeamt.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Do you want to deposite reciept");
		chckbxNewCheckBox.setBackground(new Color(30, 144, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(103, 177, 304, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
					st=con.createStatement();
					String printdata="select * from registeruser where accnum='"+useracc+"'";
					float depoistebalance=Float.parseFloat(depositeamt.getText());
					rs=st.executeQuery(printdata);
					while(rs.next())
					{
						String account_number=rs.getString("accnum");
						String user_name=(rs.getString("username"));
						String user_pin=(rs.getString("userpin"));
						String account_type=(rs.getString("accounttype"));
						String aadhar_number=(rs.getString("aadharnum"));
						String mobile_number=(rs.getString("mobilenum"));
						String gender=(rs.getString("gender"));
						String emailId=(rs.getString("email"));
						float Balance=Float.parseFloat(rs.getString("balance"));
						
						
						
						System.out.println("account number : "+account_number);
						System.out.println("user name : "+user_name);
						System.out.println("user pin : "+user_pin);
						System.out.println("account type : "+account_type);
						System.out.println("aadhar number : "+aadhar_number);
						System.out.println("mobile number : "+mobile_number);
						System.out.println("gender : "+gender);
						System.out.println("email id : "+emailId);
						System.out.println("Balance : "+Balance);
						
						
						
						
						String updatedata="update registeruser set balance=? where accnum = ?";
						if(depositeamt.getText()!="")
						{
								float remaining=Balance+depoistebalance;
//								p=con.prepareStatement("update registeruser set balance='"+remaining+"' where accnum='"+account_number+"'");
								String balance=Float.toString(remaining);
								p=con.prepareStatement(updatedata);
								p.setString(1, balance);
								p.setString(2, account_number);
								p.executeUpdate();
								
								
								
								
								
								JOptionPane.showMessageDialog(getParent(),"Congratulations, deposite successfully!" +"\nyour deposite amount is : "+depoistebalance+"\n your current total balance is : "+remaining);
								depositeamt.setText("");
								dispose();
								
						}
						else {
							JOptionPane.showMessageDialog(getParent(), "Please enter Deposite Amount .");
						}
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		confirm.setFont(new Font("Times New Roman", Font.BOLD, 24));
		confirm.setBounds(103, 249, 154, 50);
		contentPane.add(confirm);
		
		JButton Cancle = new JButton("Cancle");
		Cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depositeamt.setText("");
				dispose();
			}
		});
		Cancle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		Cancle.setBounds(322, 249, 154, 50);
		contentPane.add(Cancle);
	
	}
}
