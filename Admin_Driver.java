import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class Admin_Driver {

	private JFrame frame;
	private JTextField Dname;
	private JTextField VRegNo;
	private JTextField DID;
	private JTextField gender;
	private JTextField phone;
	private JTextField DOB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Driver window = new Admin_Driver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connection= null;
	private JTable table;

	public Admin_Driver() {
		initialize();
		connection = ConnectMySQL.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void refreshTable1()
	{
		try{
			String query = "select * from driver ";
			PreparedStatement pst = connection.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDname = new JLabel("Dname");
		lblDname.setForeground(new Color(204, 204, 102));
		lblDname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDname.setBounds(10, 11, 66, 23);
		frame.getContentPane().add(lblDname);
		
		JLabel lblVid = new JLabel("VRegNo");
		lblVid.setForeground(new Color(204, 204, 51));
		lblVid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVid.setBounds(10, 33, 66, 25);
		frame.getContentPane().add(lblVid);
		
		JLabel lblDid = new JLabel("DID");
		lblDid.setForeground(new Color(204, 204, 51));
		lblDid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDid.setBounds(10, 56, 46, 23);
		frame.getContentPane().add(lblDid);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(204, 204, 51));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(10, 78, 66, 24);
		frame.getContentPane().add(lblGender);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(204, 204, 51));
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhone.setBounds(10, 101, 66, 22);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setForeground(new Color(204, 204, 51));
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDob.setBounds(10, 120, 46, 28);
		frame.getContentPane().add(lblDob);
		
		Dname = new JTextField();
		Dname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Dname.setBounds(86, 11, 111, 20);
		frame.getContentPane().add(Dname);
		Dname.setColumns(10);
		
		VRegNo = new JTextField();
		VRegNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		VRegNo.setBounds(86, 33, 111, 20);
		frame.getContentPane().add(VRegNo);
		VRegNo.setColumns(10);
		
		DID = new JTextField();
		DID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DID.setBounds(86, 56, 111, 20);
		frame.getContentPane().add(DID);
		DID.setColumns(10);
		
		gender = new JTextField();
		gender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gender.setBounds(86, 78, 111, 20);
		frame.getContentPane().add(gender);
		gender.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		phone.setBounds(86, 101, 111, 20);
		frame.getContentPane().add(phone);
		phone.setColumns(10);
		
		DOB = new JTextField();
		DOB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DOB.setBounds(86, 126, 111, 20);
		frame.getContentPane().add(DOB);
		DOB.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(255, 255, 51));
		btnAdd.setBackground(new Color(51, 153, 102));
		btnAdd.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "insert into Driver (Dname ,Gender ,phone, DOB,VRegNo) values('"+Dname.getText()+"','"+gender.getText()+"','"+phone.getText()+"','"+DOB.getText()+"','"+VRegNo.getText()+"'); ";
					PreparedStatement pst = connection.prepareStatement(query);
										
					pst.execute();
				
				JOptionPane.showMessageDialog(null, "Successfully inserted New Value");
				
				pst.close();
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				refreshTable1();
			}
		});
		btnAdd.setBounds(342, 11, 102, 34);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnDelete.setForeground(new Color(204, 255, 153));
		btnDelete.setBackground(new Color(255, 51, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "delete from driver where DID = '"+DID.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
				
				JOptionPane.showMessageDialog(null, "Data Deleted");
				
				pst.close();
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				refreshTable1();
			}
		});
		btnDelete.setBounds(494, 11, 102, 34);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 102, 51));
		btnUpdate.setBackground(new Color(102, 153, 102));
		btnUpdate.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "update driver set phone = '"+phone.getText()+"',VRegNo='"+VRegNo.getText()+"' where DID = '"+DID.getText()+"'; "; 
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
				
				JOptionPane.showMessageDialog(null, "Successfully Updated Value");
				
				pst.close();
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				refreshTable1();
			}
			
		});
		btnUpdate.setBounds(342, 73, 102, 34);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(51, 51, 0));
		btnSearch.setBackground(new Color(255, 102, 51));
		btnSearch.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from driver where DID = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, DID.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ResultSet rs1 = pst.executeQuery();
					if(rs1.next())
						System.out.println();
					else
						JOptionPane.showMessageDialog(null, "Invalid BID");
										
					pst.close();
					rs1.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(494, 73, 102, 34);
		frame.getContentPane().add(btnSearch);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_page ap=new Admin_page();
				ap.setVisible(true);
			}
		});
		btnNewButton.setBounds(685, 425, 89, 25);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(24, 174, 687, 225);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					int row = table.getSelectedRow();
					String DID_ = (table.getModel().getValueAt(row, 1)).toString();
					String query = "select * from driver where DID = '"+DID_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
				
					ResultSet rs = pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
					while(rs.next())
					{
						Dname.setText(rs.getString("Dname"));
						VRegNo.setText(rs.getString("VRegNo"));
						DID.setText(rs.getString("DID"));
						gender.setText(rs.getString("Gender"));
						phone.setText(rs.getString("phone"));
						DOB.setText(rs.getString("DOB"));
					}
					
					
					pst.close();
					rs.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnView = new JButton("View");
		btnView.setForeground(new Color(51, 0, 0));
		btnView.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnView.setBackground(new Color(204, 153, 153));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from driver ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnView.setBounds(646, 11, 102, 34);
		frame.getContentPane().add(btnView);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DID.setText("");
					Dname.setText("");
					VRegNo.setText("");
					gender.setText("");
					phone.setText("");
					DOB.setText("");
					
					String query = "select * from driver where DID= '"+DID+"' ";
					PreparedStatement ps;				
					ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					ps.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnClear.setBackground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnClear.setBounds(646, 73, 102, 34);
		frame.getContentPane().add(btnClear);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\b17.png"));
		label.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(label);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
