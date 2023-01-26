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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class transferfund extends JFrame {

	private JPanel contentPane;
	String userid;
	private JTextField benificieryaccount;
	private JTextField benificieryamount;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transferfund frame = new transferfund();
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
	public transferfund(String userid) {
		this.userid=userid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You Want To Transfer Fund in Benificiery Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(33, 11, 511, 39);
		contentPane.add(lblNewLabel);
		
		benificieryaccount = new JTextField();
		benificieryaccount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		benificieryaccount.setBounds(67, 133, 446, 39);
		contentPane.add(benificieryaccount);
		benificieryaccount.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Benificiery Account Number");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(67, 87, 446, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Amount You Want To Transfer");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(72, 206, 372, 45);
		contentPane.add(lblNewLabel_2);
		
		benificieryamount = new JTextField();
		benificieryamount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		benificieryamount.setBounds(66, 251, 447, 39);
		contentPane.add(benificieryamount);
		benificieryamount.setColumns(10);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String benificieryaccountnumber=benificieryaccount.getText();
				float benificieryamt=Float.parseFloat(benificieryamount.getText());
				data dt=new data();
				int f=0;
				
				for(int i=0;i<dt.id.length;i++)
				{
					if(userid.equals(dt.id[i]))
					{
						if(benificieryamt<=dt.amount[i]) 
						{
							float remaining=dt.amount[i]-benificieryamt;
							JOptionPane.showMessageDialog(getParent(),"Congratulations,successfully Transfer Fund in benificiery account number is : "+benificieryaccountnumber+"\n Transfer amount is : "+benificieryamt +"\nYour remaining balance in your account : "+remaining);
							benificieryaccount.setText("");
							benificieryamount.setText("");
							dispose();
							f=1;
							break;
						}
						if(f==0)
						{
							JOptionPane.showMessageDialog(getParent(), "Insufficient balance in your account!");
							benificieryaccount.setText("");
							benificieryamount.setText("");
							dispose();
						}
					}
				}
			}
		});
		confirm.setFont(new Font("Times New Roman", Font.BOLD, 30));
		confirm.setBounds(73, 320, 151, 58);
		contentPane.add(confirm);
		
		JButton Cancle = new JButton("Cancle");
		Cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				benificieryaccount.setText("");
				benificieryamount.setText("");
				dispose();
			}
		});
		Cancle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Cancle.setBounds(362, 320, 151, 58);
		contentPane.add(Cancle);
	}
}
