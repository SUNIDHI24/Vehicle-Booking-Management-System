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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Admin_Bill {

	private JFrame frame;
	private JTextField Bno;
	private JTextField BID;
	private JTextField amt;
	private JTextField status;
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Bill window = new Admin_Bill();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refreshTable1()
	{
		try{
			String query = "select * from billing ";
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
	/**
	 * Create the application.
	 */
	Connection connection= null;
	private JTable table;
	
	public Admin_Bill() {
		initialize();
		connection = ConnectMySQL.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBno = new JLabel("Bno");
		lblBno.setForeground(new Color(255, 222, 173));
		lblBno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBno.setBounds(10, 11, 60, 26);
		frame.getContentPane().add(lblBno);
		
		JLabel lblBid = new JLabel("BID");
		lblBid.setForeground(new Color(255, 228, 181));
		lblBid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBid.setBounds(10, 36, 46, 26);
		frame.getContentPane().add(lblBid);
		
		JLabel lblAmt = new JLabel("Amt");
		lblAmt.setForeground(new Color(255, 228, 181));
		lblAmt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmt.setBounds(10, 61, 46, 30);
		frame.getContentPane().add(lblAmt);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(255, 222, 173));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus.setBounds(10, 91, 60, 30);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(255, 222, 173));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(10, 119, 60, 26);
		frame.getContentPane().add(lblDate);
		
		Bno = new JTextField();
		Bno.setBounds(66, 11, 86, 20);
		frame.getContentPane().add(Bno);
		Bno.setColumns(10);
		
		BID = new JTextField();
		BID.setBounds(66, 41, 86, 20);
		frame.getContentPane().add(BID);
		BID.setColumns(10);
		
		amt = new JTextField();
		amt.setBounds(66, 68, 86, 20);
		frame.getContentPane().add(amt);
		amt.setColumns(10);
		
		status = new JTextField();
		status.setBounds(66, 98, 86, 20);
		frame.getContentPane().add(status);
		status.setColumns(10);
		
		date = new JTextField();
		date.setBounds(66, 124, 86, 20);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(128, 128, 0));
		btnUpdate.setBackground(new Color(152, 251, 152));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "update billing set status='"+status.getText()+"',date='"+date.getText()+"' where Bno = '"+Bno.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
				
				JOptionPane.showMessageDialog(null, "Successfully Updated Value");
				
				pst.close();
				
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				refreshTable1();
			}
		});
		btnUpdate.setBounds(444, 13, 122, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(165, 42, 42));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select * from billing where Bno = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, Bno.getText());
					ResultSet rs = pst.executeQuery();					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ResultSet rs1 = pst.executeQuery();
					if(rs1.next())
						System.out.println();
					else
						JOptionPane.showMessageDialog(null, "Invalid Bno");
					pst.close();
					rs1.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(631, 13, 122, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_page ap=new Admin_page();
				ap.setVisible(true);
			}
		});
		btnBack.setBounds(676, 424, 98, 26);
		frame.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 161, 679, 123);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					int row=table.getSelectedRow();
					String Bno_ = (table.getModel().getValueAt(row, 0)).toString();
					String query = "select * from billing where Bno= '"+Bno_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
				
					ResultSet rs = pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
					while(rs.next())
					{
						Bno.setText(rs.getString("Bno"));
						BID.setText(rs.getString("BID"));
						amt.setText(rs.getString("amt"));
						status.setText(rs.getString("status"));
						date.setText(rs.getString("Date"));
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
		btnView.setForeground(new Color(0, 0, 128));
		btnView.setBackground(new Color(222, 184, 135));
		btnView.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from billing ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ResultSet rs1 = pst.executeQuery();
					if(rs1.next())
						System.out.println();
					else
						JOptionPane.showMessageDialog(null, "Table is Empty");				
					
					pst.close();
					rs1.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnView.setBounds(444, 84, 122, 37);
		frame.getContentPane().add(btnView);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(224, 255, 255));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setForeground(new Color(139, 0, 139));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Bno.setText("");
					BID.setText("");
					amt.setText("");
					status.setText("");
					date.setText("");
					
					String query = "select * from billing where Bno= '"+Bno+"' ";
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
		btnClear.setBounds(631, 84, 122, 37);
		frame.getContentPane().add(btnClear);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\taxi4.jpg"));
		label.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(label);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
