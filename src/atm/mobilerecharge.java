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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class mobilerecharge extends JFrame {

	private JPanel contentPane;
	private JTextField Mnumber;
	private JTextField price;
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
					mobilerecharge frame = new mobilerecharge();
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
	public mobilerecharge(String useracc) {
		this.useracc=useracc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Your Mobile Number You Want To Recharge");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 27, 567, 42);
		contentPane.add(lblNewLabel);
		
		Mnumber = new JTextField();
		Mnumber.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Mnumber.setBackground(new Color(255, 255, 255));
		Mnumber.setBounds(133, 80, 387, 42);
		contentPane.add(Mnumber);
		Mnumber.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Country Code is Mendatory");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(57, 126, 310, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Operator");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(57, 170, 132, 42);
		contentPane.add(lblNewLabel_2);
		
		JComboBox operator = new JComboBox();
		operator.setModel(new DefaultComboBoxModel(new String[] {"--select--", "VODA", "IDEA", "AIRTEL", "JIO"}));
		operator.setToolTipText("");
		operator.setBounds(57, 211, 132, 30);
		contentPane.add(operator);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"+91", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9", "+10"}));
		comboBox_1.setBounds(56, 80, 67, 42);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Select State");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(221, 170, 132, 42);
		contentPane.add(lblNewLabel_2_1);
		
		JComboBox state = new JComboBox();
		state.setModel(new DefaultComboBoxModel(new String[] {"--select--", "Andhra Pradesh\t", "Arunachal Pradesh\t", "Assam\t", "Bihar\t", "Chhattisgarh\t", "Goa\t", "Gujarat\t", "Haryana\t", "Himachal Pradesh\t", "Jharkhand\t", "Karnataka\t", "Kerala\t", "Madhya Pradesh\t", "Maharashtra\t", "Manipur\t", "Meghalaya", "Mizoram\t", "Nagaland\t", "Odisha\t", "Punjab\t", "Rajasthan\t", "Sikkim\t", "Tamil Nadu", "Telangana\t", "Tripura\t", "Uttar Pradesh\t", "Uttarakhand\t", "West Bengal"}));
		state.setToolTipText("");
		state.setBounds(221, 211, 132, 30);
		contentPane.add(state);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Select Zone");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(388, 170, 132, 42);
		contentPane.add(lblNewLabel_2_1_1);
		
		JComboBox zone = new JComboBox();
		zone.setModel(new DefaultComboBoxModel(new String[] {"--select--", "EAST", "WEST", "NORTH", "SOUTH"}));
		zone.setToolTipText("");
		zone.setBounds(388, 211, 132, 30);
		contentPane.add(zone);
		
		JLabel lblNewLabel_2_2 = new JLabel("View Plans");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(57, 252, 93, 42);
		contentPane.add(lblNewLabel_2_2);
		
		JComboBox plan = new JComboBox();
		plan.setModel(new DefaultComboBoxModel(new String[] {"--select--", "JIO FREEDOM PLANS -296 RS. (VALIDITY 30 DAYS , 25GB)", "3 GB/DAY - 4199 RS. (VALIDITY 365 DAYS)", "3 GB/DAY -1199 RS. (VALIDITY 84 DAYS)", "3 GB/DAY -419 RS. (VALIDITY 28 DAYS)", "1 GB/DAY -209 RS. (VAIDITY 28 DAYS)", "1 GB/DAY -179 RS. (VAIDITY 24 DAYS)", "1 GB/DAY -149 RS. (VAIDITY 20 DAYS)", "2 GB/DAY -2879 RS. (VAIDITY 365 DAYS)", "2 GB/DAY -719 RS. (VAIDITY 84 DAYS)", "2 GB/DAY -533 RS. (VAIDITY 56 DAYS)", "2 GB/DAY -299 RS. (VAIDITY 28 DAYS)", "2 GB/DAY -249 RS. (VAIDITY 23 DAYS)", "1.5 GB/DAY -2545 RS. (VAIDITY 336 DAYS)", "1.5 GB/DAY -666 RS. (VAIDITY 84 DAYS)", "1.5 GB/DAY -479 RS. (VAIDITY 56 DAYS)", "1.5 GB/DAY -259 RS. (VAIDITY 1 MONTH)", "1.5 GB/DAY -239 RS. (VAIDITY 28 DAYS)", "1.5 GB/DAY -199 RS. (VAIDITY 23 DAYS)", "1.5 GB/DAY -199 RS. (VAIDITY 14 DAYS)"}));
		plan.setToolTipText("");
		plan.setBounds(57, 285, 209, 30);
		contentPane.add(plan);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Enter Price");
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_2_1.setBounds(57, 320, 93, 42);
		contentPane.add(lblNewLabel_2_2_1);
		
		price = new JTextField();
		price.setFont(new Font("Times New Roman", Font.BOLD, 18));
		price.setBounds(57, 354, 132, 42);
		contentPane.add(price);
		price.setColumns(10);
		
		JButton candp = new JButton("CONFIRM AND PAY");
		candp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mobilenumber=Mnumber.getText();
				float pr=Float.parseFloat(price.getText());
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","12345678");
					st=con.createStatement();
					rs=st.executeQuery("select * from registeruser where accnum='"+useracc+"'");
					while(rs.next())
					{
						String accountNumber=rs.getString(1);
						String username=rs.getString(2);
						String userpin=rs.getString(3);
						String accountType=rs.getString(4);
						String aadharNumber=rs.getString(5);
						String mobileNumber=rs.getString(6);
						String gender=rs.getString(7);
						String emailid=rs.getString(8);
						Float Balance=Float.parseFloat(rs.getString(9));
						String mbalance=rs.getString(10);
						int mobileRecharge=Integer.parseInt(mbalance);
						int f=0;
						if(mobileNumber.equals(mobilenumber)) 
						{
							float reminaingbalance=Balance-pr;
							float updateRecharge=mobileRecharge+pr;
							String updateBalance=Float.toString(reminaingbalance);
							p=con.prepareStatement("update registeruser set balance=?, mobileRecharge=? where accnum=?");
							p.setString(1, updateBalance);
							p.setFloat(2, updateRecharge);
							p.setString(3, accountNumber);
							p.executeUpdate();
							
							
							
							JOptionPane.showMessageDialog(getParent(),"Recharge sucessfully on Number: "+mobilenumber+" of "+pr+" Rupees."+"\n Remaining Balance In Your Account is : "+reminaingbalance);
							Mnumber.setText("");
							price.setText("");
							state.setSelectedItem("--select--");
							zone.setSelectedItem("--select--");
							operator.setSelectedItem("--select--");
							plan.setSelectedItem("--select--");
							dispose();
							f=1;
							break;
						}
						if(f==0){
							JOptionPane.showMessageDialog(getParent(), "Invalid Mobile Number , Try Again.");
							Mnumber.setText("");
							price.setText("");
							state.setSelectedItem("--select--");
							zone.setSelectedItem("--select--");
							operator.setSelectedItem("--select--");
							plan.setSelectedItem("--select--");
						}
						
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		candp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		candp.setBounds(350, 285, 170, 39);
		contentPane.add(candp);
		
		JButton Cancle = new JButton("CANCLE");
		Cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Cancle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Cancle.setBounds(350, 354, 170, 39);
		contentPane.add(Cancle);
	}
}
