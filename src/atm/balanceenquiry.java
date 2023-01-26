package atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class balanceenquiry extends JFrame {

	private JPanel contentPane;
	String useracc;
	Connection con;
	Statement st;
	ResultSet rs;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					balanceenquiry frame = new balanceenquiry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}		*/

	/**
	 * Create the frame.
	 */
	public balanceenquiry(String useracc) {
		this.useracc=useracc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You want to know your current balance");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(60, 81, 461, 68);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Click for Know Your Balance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
					st=con.createStatement();
					rs=st.executeQuery("select * from registeruser where accnum='"+useracc+"'");
					while(rs.next())
					{
						JOptionPane.showMessageDialog(getParent(), "account number : "+rs.getString(1)+"\n"+"user name : "+rs.getString(2)+"\n"+"user pin : "+rs.getString(3)+"\n"+"account type : "+rs.getString(4)+"\n"+"aadhar number : "+rs.getString(5)+"\n"+"mobile number : "+rs.getString(6)+"\n"+"gender : "+rs.getString(7)+"\n"+"email id : "+rs.getString(8)+"\n"+"Balance : "+rs.getString(9));
						dispose();
//						System.out.println("account number : "+rs.getString(1));
//						System.out.println("user name : "+rs.getString(2));
//						System.out.println("user pin : "+rs.getString(3));
//						System.out.println("account type : "+rs.getString(4));
//						System.out.println("aadhar number : "+rs.getString(5));
//						System.out.println("mobile number : "+rs.getString(6));
//						System.out.println("gender : "+rs.getString(7));
//						System.out.println("email id : "+rs.getString(8));
//						System.out.println("Balance : "+rs.getString(9));
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(138, 201, 283, 56);
		contentPane.add(btnNewButton);
		
		JButton btnBackToHome = new JButton("Back To Home");
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBackToHome.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBackToHome.setBounds(138, 278, 283, 56);
		contentPane.add(btnBackToHome);
	}

}
