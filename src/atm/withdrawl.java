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

public class withdrawl extends JFrame {

	private JPanel contentPane;
	private JTextField withdrawamt;
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
					withdrawl frame = new withdrawl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}			*/

	/**
	 * Create the frame.
	 */
	public withdrawl(String useracc) {
		this.useracc=useracc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		withdrawamt = new JTextField();
		withdrawamt.setFont(new Font("Times New Roman", Font.BOLD, 24));
		withdrawamt.setColumns(10);
		withdrawamt.setBounds(148, 112, 322, 50);
		contentPane.add(withdrawamt);
		
		JLabel lblNewLabel = new JLabel("Enter the amount you want to withdraw");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBackground(new Color(135, 206, 250));
		lblNewLabel.setBounds(84, 56, 446, 45);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Do you want to withdraw reciept or not");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBackground(new Color(30, 144, 255));
		chckbxNewCheckBox.setBounds(148, 169, 322, 34);
		contentPane.add(chckbxNewCheckBox);
		
		JButton withdrawbtn = new JButton("Withdraw");
		withdrawbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
					st=con.createStatement();
					float withdrawamount=Float.parseFloat(withdrawamt.getText());
					rs=st.executeQuery("select * from registeruser where accnum='"+useracc+"'");
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
						
//						System.out.println(Balance);
//						System.out.println("account number : "+rs.getString(1));
//						System.out.println("user name : "+rs.getString(2));
//						System.out.println("user pin : "+rs.getString(3));
//						System.out.println("account type : "+rs.getString(4));
//						System.out.println("aadhar number : "+rs.getString(5));
//						System.out.println("mobile number : "+rs.getString(6));
//						System.out.println("gender : "+rs.getString(7));
//						System.out.println("email id : "+rs.getString(8));
//						System.out.println("Balance : "+rs.getString(9));
						int f=0;
						if(withdrawamt.getText()!="")
						{
							if(withdrawamount<=Balance)
							{
								float remaining=Balance-withdrawamount;
								p=con.prepareStatement("update registeruser set balance=? where accnum=?");
								String balance=Float.toString(remaining);
								p.setString(1, balance);
								p.setString(2, useracc);
								p.executeUpdate();
								
								
								JOptionPane.showMessageDialog(getParent(),"Congratulations, Withdraw successfully!" +"\nyour remaining amount is : "+remaining+"\n your withdraw amount is : "+withdrawamount);
								withdrawamt.setText("");
								dispose();
								f=1;
								break;
							}
							if(f==0)
								{
									JOptionPane.showMessageDialog(getParent(), "Insufficient balance in your account!");
									withdrawamt.setText("");
									dispose();
								}
						}
						else {
							JOptionPane.showMessageDialog(getParent(), "Please enter WIthdraw Amount .");
						}
						
						
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(getParent(), "Exception : "+e1.getMessage());
				}
				
				
				
//				data dt=new data();
//				int f=0;
//				
//				for(int i=0;i<dt.id.length;i++)
//				{
//					if(userid.equals(dt.id[i]))
//					{
//						if(withdrawamount<=dt.amount[i]) 
//						{
//							float remaining=dt.amount[i]-withdrawamount;
//							JOptionPane.showMessageDialog(getParent(),"Congratulations, Withdraw successfully!" +"\nyour remaining amount is : "+remaining+"\n your withdraw amount is : "+withdrawamount);
//							withdrawamt.setText("");
//							dispose();
//							f=1;
//							break;
//						}
//						if(f==0)
//						{
//							JOptionPane.showMessageDialog(getParent(), "Insufficient balance in your account!");
//							withdrawamt.setText("");
//							dispose();
//						}
//					}
//				}
			}
		});
		withdrawbtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		withdrawbtn.setBounds(230, 229, 131, 50);
		contentPane.add(withdrawbtn);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawamt.setText("");
				dispose();
			}
		});
		btnCancle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCancle.setBounds(230, 297, 131, 50);
		contentPane.add(btnCancle);
	}
}
