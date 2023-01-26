package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ministatement extends JFrame {

	private JPanel contentPane;
	String useracc;
	private JTable table;
	DefaultButtonModel model;
	Connection con;
	Statement st;
	Resultset rs;
	PreparedStatement p;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ministatement frame = new ministatement();
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
	public ministatement(String useracc) {
		this.useracc=useracc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		
		
		
		String[][] data = {
	            { "Kundan Kumar Jha", "4031", "CSE" },
	            { "Anand Jha", "6014", "IT" }
	        };
		String[] columnNames = { "Name", "Roll Number", "Department" };
		
		
		JLabel lblNewLabel = new JLabel("Your Account Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 31, 431, 49);
		contentPane.add(lblNewLabel);
		
		table = new JTable(data, columnNames);
		table.setBounds(10, 95, 555, 312);
		table.setVisible(true);
		contentPane.add(table);
	}
}
