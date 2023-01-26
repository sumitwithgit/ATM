package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class fastcash extends JFrame {

	private JPanel contentPane;
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
					fastcash frame = new fastcash();
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
	public fastcash(String useracc) {
		this.useracc=useracc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You want to Withdraw Rapidly, click desired amount");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 59, 587, 43);
		contentPane.add(lblNewLabel);
		
		JButton five = new JButton("5000");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
				st=con.createStatement();
				rs=st.executeQuery("select * from registeruser where accnum='"+useracc+"'");
				while(rs.next())
				{
					String accountnum=rs.getString(1);
					String username=rs.getString(2);
					String userpin=rs.getString(3);
					String accountype=rs.getString(4);
					String aadharnumber=rs.getString(5);
					String mobilenumber=rs.getString(6);
					String gender=rs.getString(7);
					String emailid=rs.getString(8);
					float Balance=Float.parseFloat(rs.getString(9));
					
					System.out.println(Balance);
					System.out.println("account number : "+rs.getString(1));
					System.out.println("user name : "+rs.getString(2));
					System.out.println("user pin : "+rs.getString(3));
					System.out.println("account type : "+rs.getString(4));
					System.out.println("aadhar number : "+rs.getString(5));
					System.out.println("mobile number : "+rs.getString(6));
					System.out.println("gender : "+rs.getString(7));
					System.out.println("email id : "+rs.getString(8));
					System.out.println("Balance : "+rs.getString(9));
					
					int f=0;
					float fivethousand=Float.parseFloat(five.getText());
					
					
					if(fivethousand<=Balance) 
					{
						float remaining=Balance-fivethousand;
						p=con.prepareStatement("update registeruser set balance=? where accnum=?");
						String balance=Float.toString(remaining);
						p.setString(1, balance);
						p.setString(2, useracc);
						p.executeUpdate();
						JOptionPane.showMessageDialog(getParent(),"Congratulations,5000 Rupees Withdraw successfully!" +"\nyour remaining amount is : "+remaining+"\n your withdraw amount is : "+fivethousand);
						dispose();
						f=1;
						break;
					}
					if(f==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Insufficient balance in your account!");
						dispose();
					}
				}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				
				
			}
		});
		five.setFont(new Font("Times New Roman", Font.BOLD, 25));
		five.setBounds(46, 113, 141, 49);
		contentPane.add(five);
		
		JButton ten = new JButton("10000");
		ten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
				st=con.createStatement();
				rs=st.executeQuery("select * from registeruser where accnum='"+useracc+"'");
				while(rs.next())
				{
					String accountnum=rs.getString(1);
					String username=rs.getString(2);
					String userpin=rs.getString(3);
					String accountype=rs.getString(4);
					String aadharnumber=rs.getString(5);
					String mobilenumber=rs.getString(6);
					String gender=rs.getString(7);
					String emailid=rs.getString(8);
					float Balance=Float.parseFloat(rs.getString(9));
					
					System.out.println(Balance);
					System.out.println("account number : "+rs.getString(1));
					System.out.println("user name : "+rs.getString(2));
					System.out.println("user pin : "+rs.getString(3));
					System.out.println("account type : "+rs.getString(4));
					System.out.println("aadhar number : "+rs.getString(5));
					System.out.println("mobile number : "+rs.getString(6));
					System.out.println("gender : "+rs.getString(7));
					System.out.println("email id : "+rs.getString(8));
					System.out.println("Balance : "+rs.getString(9));
					
					int f=0;
					float tenthousand=Float.parseFloat(ten.getText());
					
					
					if(tenthousand<=Balance) 
					{
						float remaining=Balance-tenthousand;
						p=con.prepareStatement("update registeruser set balance=? where accnum=?");
						String balance=Float.toString(remaining);
						p.setString(1, balance);
						p.setString(2, useracc);
						p.executeUpdate();
						JOptionPane.showMessageDialog(getParent(),"Congratulations,10000 Rupees Withdraw successfully!" +"\nyour remaining amount is : "+remaining+"\n your withdraw amount is : "+tenthousand);
						dispose();
						f=1;
						break;
					}
					if(f==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Insufficient balance in your account!");
						dispose();
					}
				}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		ten.setFont(new Font("Times New Roman", Font.BOLD, 25));
		ten.setBounds(46, 173, 141, 49);
		contentPane.add(ten);
		
		JButton fifteen = new JButton("15000");
		fifteen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
				st=con.createStatement();
				rs=st.executeQuery("select * from registeruser where accnum='"+useracc+"'");
				while(rs.next())
				{
					String accountnum=rs.getString(1);
					String username=rs.getString(2);
					String userpin=rs.getString(3);
					String accountype=rs.getString(4);
					String aadharnumber=rs.getString(5);
					String mobilenumber=rs.getString(6);
					String gender=rs.getString(7);
					String emailid=rs.getString(8);
					float Balance=Float.parseFloat(rs.getString(9));
					
					System.out.println(Balance);
					System.out.println("account number : "+rs.getString(1));
					System.out.println("user name : "+rs.getString(2));
					System.out.println("user pin : "+rs.getString(3));
					System.out.println("account type : "+rs.getString(4));
					System.out.println("aadhar number : "+rs.getString(5));
					System.out.println("mobile number : "+rs.getString(6));
					System.out.println("gender : "+rs.getString(7));
					System.out.println("email id : "+rs.getString(8));
					System.out.println("Balance : "+rs.getString(9));
					
					int f=0;
					float fifteenthousand=Float.parseFloat(fifteen.getText());
					
					
					if(fifteenthousand<=Balance) 
					{
						float remaining=Balance-fifteenthousand;
						p=con.prepareStatement("update registeruser set balance=? where accnum=?");
						String balance=Float.toString(remaining);
						p.setString(1, balance);
						p.setString(2, useracc);
						p.executeUpdate();
						JOptionPane.showMessageDialog(getParent(),"Congratulations,15000 Rupees Withdraw successfully!" +"\nyour remaining amount is : "+remaining+"\n your withdraw amount is : "+fifteenthousand);
						dispose();
						f=1;
						break;
					}
					if(f==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Insufficient balance in your account!");
						dispose();
					}
				}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			
			}
		});
		fifteen.setFont(new Font("Times New Roman", Font.BOLD, 25));
		fifteen.setBounds(46, 233, 141, 49);
		contentPane.add(fifteen);
		
		JButton twenty = new JButton("20000");
		twenty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
				st=con.createStatement();
				rs=st.executeQuery("select * from registeruser where accnum='"+useracc+"'");
				while(rs.next())
				{
					String accountnum=rs.getString(1);
					String username=rs.getString(2);
					String userpin=rs.getString(3);
					String accountype=rs.getString(4);
					String aadharnumber=rs.getString(5);
					String mobilenumber=rs.getString(6);
					String gender=rs.getString(7);
					String emailid=rs.getString(8);
					float Balance=Float.parseFloat(rs.getString(9));
					
					System.out.println(Balance);
					System.out.println("account number : "+rs.getString(1));
					System.out.println("user name : "+rs.getString(2));
					System.out.println("user pin : "+rs.getString(3));
					System.out.println("account type : "+rs.getString(4));
					System.out.println("aadhar number : "+rs.getString(5));
					System.out.println("mobile number : "+rs.getString(6));
					System.out.println("gender : "+rs.getString(7));
					System.out.println("email id : "+rs.getString(8));
					System.out.println("Balance : "+rs.getString(9));
					
					int f=0;
					float twentythousand=Float.parseFloat(twenty.getText());
					
					
					if(twentythousand<=Balance) 
					{
						float remaining=Balance-twentythousand;
						p=con.prepareStatement("update registeruser set balance=? where accnum=?");
						String balance=Float.toString(remaining);
						p.setString(1, balance);
						p.setString(2, useracc);
						p.executeUpdate();
						JOptionPane.showMessageDialog(getParent(),"Congratulations,20000 Rupees Withdraw successfully!" +"\nyour remaining amount is : "+remaining+"\n your withdraw amount is : "+twentythousand);
						dispose();
						f=1;
						break;
					}
					if(f==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Insufficient balance in your account!");
						dispose();
					}
				}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		twenty.setFont(new Font("Times New Roman", Font.BOLD, 25));
		twenty.setBounds(46, 293, 141, 49);
		contentPane.add(twenty);
		
		JButton twentyfive = new JButton("25000");
		twentyfive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
				st=con.createStatement();
				rs=st.executeQuery("select * from registeruser where accnum='"+useracc+"'");
				while(rs.next())
				{
					String accountnum=rs.getString(1);
					String username=rs.getString(2);
					String userpin=rs.getString(3);
					String accountype=rs.getString(4);
					String aadharnumber=rs.getString(5);
					String mobilenumber=rs.getString(6);
					String gender=rs.getString(7);
					String emailid=rs.getString(8);
					float Balance=Float.parseFloat(rs.getString(9));
					
					System.out.println(Balance);
					System.out.println("account number : "+rs.getString(1));
					System.out.println("user name : "+rs.getString(2));
					System.out.println("user pin : "+rs.getString(3));
					System.out.println("account type : "+rs.getString(4));
					System.out.println("aadhar number : "+rs.getString(5));
					System.out.println("mobile number : "+rs.getString(6));
					System.out.println("gender : "+rs.getString(7));
					System.out.println("email id : "+rs.getString(8));
					System.out.println("Balance : "+rs.getString(9));
					
					int f=0;
					float twentyfivethousand=Float.parseFloat(twentyfive.getText());
					
					
					if(twentyfivethousand<=Balance) 
					{
						float remaining=Balance-twentyfivethousand;
						p=con.prepareStatement("update registeruser set balance=? where accnum=?");
						String balance=Float.toString(remaining);
						p.setString(1, balance);
						p.setString(2, useracc);
						p.executeUpdate();
						JOptionPane.showMessageDialog(getParent(),"Congratulations,25000 Rupees Withdraw successfully!" +"\nyour remaining amount is : "+remaining+"\n your withdraw amount is : "+twentyfivethousand);
						dispose();
						f=1;
						break;
					}
					if(f==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Insufficient balance in your account!");
						dispose();
					}
				}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		twentyfive.setFont(new Font("Times New Roman", Font.BOLD, 25));
		twentyfive.setBounds(46, 353, 141, 49);
		contentPane.add(twentyfive);
		
		JLabel lblNewLabel_1 = new JLabel("Fast cash");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(155, 11, 265, 37);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnCancle.setBounds(347, 233, 141, 49);
		contentPane.add(btnCancle);
	}

}
