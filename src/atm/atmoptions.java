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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.TextField;

public class atmoptions extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String useracc,name;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atmoptions frame = new atmoptions();
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
	public atmoptions(String useracc,String name) {
		this.useracc=useracc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose options to continue");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(33, 11, 479, 32);
		contentPane.add(lblNewLabel);
		
		JRadioButton transferfund = new JRadioButton("Transfer funds");
		transferfund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transferfund tf=new transferfund(useracc);
				tf.setVisible(true);
			}
		});
		buttonGroup.add(transferfund);
		transferfund.setBackground(new Color(106, 90, 205));
		transferfund.setFont(new Font("Times New Roman", Font.BOLD, 18));
		transferfund.setForeground(new Color(230, 230, 250));
		transferfund.setBounds(0, 139, 201, 64);
		contentPane.add(transferfund);
		
		JRadioButton balanceenquiry = new JRadioButton("Balance Enquiry");
		balanceenquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balanceenquiry be=new balanceenquiry(useracc);
				be.setVisible(true);
			}
		});
		buttonGroup.add(balanceenquiry);
		balanceenquiry.setForeground(new Color(230, 230, 250));
		balanceenquiry.setFont(new Font("Times New Roman", Font.BOLD, 18));
		balanceenquiry.setBackground(new Color(106, 90, 205));
		balanceenquiry.setBounds(0, 218, 201, 64);
		contentPane.add(balanceenquiry);
		
		JRadioButton ministatement = new JRadioButton("Mini Statement");
		ministatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ministatement ms=new ministatement(useracc);
				ms.setVisible(true);
			}
		});
		buttonGroup.add(ministatement);
		ministatement.setForeground(new Color(230, 230, 250));
		ministatement.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ministatement.setBackground(new Color(106, 90, 205));
		ministatement.setBounds(0, 295, 201, 64);
		contentPane.add(ministatement);
		
		JRadioButton mobilerecharge = new JRadioButton("Mobile Recharge");
		mobilerecharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mobilerecharge mr=new mobilerecharge(useracc);
				mr.setVisible(true);
			}
		});
		buttonGroup.add(mobilerecharge);
		mobilerecharge.setForeground(new Color(230, 230, 250));
		mobilerecharge.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mobilerecharge.setBackground(new Color(106, 90, 205));
		mobilerecharge.setBounds(0, 370, 201, 64);
		contentPane.add(mobilerecharge);
		
		JRadioButton fastcash = new JRadioButton("Fast Cash");
		fastcash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fastcash fc=new fastcash(useracc);
				fc.setVisible(true);
			}
		});
		buttonGroup.add(fastcash);
		fastcash.setForeground(new Color(230, 230, 250));
		fastcash.setFont(new Font("Times New Roman", Font.BOLD, 18));
		fastcash.setBackground(new Color(106, 90, 205));
		fastcash.setBounds(386, 139, 201, 64);
		contentPane.add(fastcash);
		
		JRadioButton Withdraw = new JRadioButton("Withdraw");
		Withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawl wd=new withdrawl(useracc);
				wd.setVisible(true);
			}
		});
		buttonGroup.add(Withdraw);
		Withdraw.setForeground(new Color(230, 230, 250));
		Withdraw.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Withdraw.setBackground(new Color(106, 90, 205));
		Withdraw.setBounds(386, 218, 201, 64);
		contentPane.add(Withdraw);
		
		JRadioButton Deposite = new JRadioButton("Deposite");
		Deposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposite dp=new deposite(useracc);
				dp.setVisible(true);
			}
		});
		buttonGroup.add(Deposite);
		Deposite.setForeground(new Color(230, 230, 250));
		Deposite.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Deposite.setBackground(new Color(106, 90, 205));
		Deposite.setBounds(386, 295, 201, 64);
		contentPane.add(Deposite);
		
		JRadioButton PinChange = new JRadioButton("Pin Change");
		PinChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinchange pc=new pinchange(useracc);
				pc.setVisible(true);
			}
		});
		buttonGroup.add(PinChange);
		PinChange.setForeground(new Color(230, 230, 250));
		PinChange.setFont(new Font("Times New Roman", Font.BOLD, 18));
		PinChange.setBackground(new Color(106, 90, 205));
		PinChange.setBounds(386, 370, 201, 64);
		contentPane.add(PinChange);
		
		JLabel user = new JLabel("Welcome, "+name);
		user.setFont(new Font("Times New Roman", Font.BOLD, 20));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setBounds(76, 64, 390, 32);
		contentPane.add(user);
	}
}
