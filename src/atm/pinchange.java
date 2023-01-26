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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class pinchange extends JFrame {

	private JPanel panel;
	private JPasswordField newpin;
	private JPasswordField cnewpin;
	String useracc;
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement p;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					pinchange frame = new pinchange();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public pinchange(String useracc) {
		this.useracc=useracc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You Want To Change the Pin");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 25, 387, 46);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter new Pin");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(79, 95, 268, 37);
		panel.add(lblNewLabel_1);
		
		newpin = new JPasswordField();
		newpin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		newpin.setBounds(79, 137, 422, 46);
		panel.add(newpin);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirm Pin");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(79, 200, 268, 37);
		panel.add(lblNewLabel_1_1);
		
		cnewpin = new JPasswordField();
		cnewpin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		cnewpin.setBounds(83, 248, 422, 46);
		panel.add(cnewpin);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newp=new String(newpin.getPassword());
				String cnewp=new String(cnewpin.getPassword());
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
					st=con.createStatement();
					rs=st.executeQuery("select * from registeruser where accnum='"+useracc+"'");
					while(rs.next())
					{
						String accountnumber=rs.getString(1);
						String username=rs.getString(2);
						String userpin=rs.getString(3);
						String accounttype=rs.getString(4);
						String aadharNumber=rs.getString(5);
						String mobileNumber=rs.getString(6);
						String gender=rs.getString(7);
						String emailid=rs.getString(8);
						float Balance=Float.parseFloat(rs.getString(9));
						
						System.out.println("Account Number:"+accountnumber);
						System.out.println("User NAme:"+username);
						System.out.println("User pin:"+userpin);
						System.out.println("Account Tyoe:"+accountnumber);
						System.out.println("AAdhar Number:"+aadharNumber);
						System.out.println("Mobile Number:"+mobileNumber);
						System.out.println("Gender:"+gender);
						System.out.println("Account EmailId:"+emailid);
						System.out.println("Account Balance:"+Balance);
						
						
						if(newp.equals(cnewp)) {
							p=con.prepareStatement("update registeruser set userpin=? where accnum=?");
							p.setString(1, newp);
							p.setString(2, accountnumber);
							p.executeUpdate();
							JOptionPane.showMessageDialog(getParent(), "Congratulations, your pin has been changed Successfully. ! New Pin "+newp);
							dispose();
							
						}else {
							JOptionPane.showMessageDialog(getParent(), "Pin Not Changed, Try Again!");
							newpin.setText("");
							cnewpin.setText("");
						}
						
						
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		submit.setFont(new Font("Times New Roman", Font.BOLD, 25));
		submit.setBounds(83, 324, 167, 46);
		panel.add(submit);
		
		JButton cancle = new JButton("Cancle");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newpin.setText("");
				cnewpin.setText("");
				dispose();
			}
		});
		cancle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		cancle.setBounds(334, 324, 167, 46);
		panel.add(cancle);
	}
}
