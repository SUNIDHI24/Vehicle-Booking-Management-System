import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
//import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Admin_Vehicle {

	private JFrame frame;
	private JTextField VRegNo;
	private JTextField VID;
	private JTextField rate;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Vehicle window = new Admin_Vehicle();
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
	private JTextField engine_type;
	private JTextField status;

	public Admin_Vehicle() {
		initialize();
		connection = ConnectMySQL.dbConnector();
	}
	public void refreshTable1()
	{
		try{
			String query = "select * from v_details ";
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVregno = new JLabel("VRegNo");
		lblVregno.setForeground(new Color(204, 255, 153));
		lblVregno.setBackground(Color.WHITE);
		lblVregno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVregno.setBounds(10, 11, 101, 26);
		frame.getContentPane().add(lblVregno);
		
		JLabel lblVid = new JLabel("VID");
		lblVid.setForeground(new Color(204, 255, 153));
		lblVid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVid.setBounds(20, 48, 46, 14);
		frame.getContentPane().add(lblVid);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setForeground(new Color(204, 255, 153));
		lblRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRate.setBounds(20, 73, 46, 14);
		frame.getContentPane().add(lblRate);
		
		VRegNo = new JTextField();
		VRegNo.setBounds(92, 16, 106, 20);
		frame.getContentPane().add(VRegNo);
		VRegNo.setColumns(10);
		
		VID = new JTextField();
		VID.setBounds(112, 47, 86, 20);
		frame.getContentPane().add(VID);
		VID.setColumns(10);
		
		rate = new JTextField();
		rate.setBounds(112, 72, 86, 20);
		frame.getContentPane().add(rate);
		rate.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setBackground(new Color(240, 230, 140));
		btnNewButton_2.setFont(new Font("Forte", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "insert into v_details values (?,?,?,?,?) ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,VRegNo.getText());
					pst.setString(2,VID.getText());
					pst.setString(3,rate.getText());
					pst.setString(4,engine_type.getText());
					pst.setString(5,status.getText());
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
		btnNewButton_2.setBounds(350, 15, 103, 33);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setBackground(new Color(233, 150, 122));
		btnNewButton_3.setFont(new Font("Forte", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "delete from v_details where VRegNo = '"+VRegNo.getText()+"' ";
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
		btnNewButton_3.setBounds(507, 15, 103, 33);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.setBackground(new Color(220, 220, 220));
		btnNewButton_4.setFont(new Font("Forte", Font.PLAIN, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "update v_details set VID = '"+VID.getText()+"',rateperkm = '"+rate.getText()+"',engine_type='"+engine_type.getText()+"',status = '"+status.getText()+"' where VRegNo = '"+VRegNo.getText()+"' ";
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
		btnNewButton_4.setBounds(350, 71, 103, 33);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Back");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_page ap=new Admin_page();
				ap.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(671, 417, 103, 33);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(240, 255, 240));
		btnNewButton.setFont(new Font("Forte", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select * from v_details where VRegNo = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, VRegNo.getText());
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ResultSet rs1 = pst.executeQuery();
					if(rs1.next())
						System.out.println();
					else
						JOptionPane.showMessageDialog(null, "Invalid VRegNo");
					
					pst.close();
					rs.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(507, 71, 103, 33);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 165, 679, 208);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int row=table.getSelectedRow();
					String VRegNo_ = (table.getModel().getValueAt(row, 0)).toString();
					String query = "select * from v_details where VRegNo= '"+VRegNo_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
				
					ResultSet rs = pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
					while(rs.next())
					{
						VRegNo.setText(rs.getString("VRegNo"));
						VID.setText(rs.getString("VID"));
						rate.setText(rs.getString("rateperkm"));
						engine_type.setText(rs.getString("engine_type"));
						status.setText(rs.getString("status"));
					}
					
					
					pst.close();
					rs.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnView = new JButton("View ");
		btnView.setBackground(new Color(230, 230, 250));
		btnView.setFont(new Font("Forte", Font.PLAIN, 15));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select * from v_details ";
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
		});
		btnView.setBounds(671, 15, 103, 33);
		frame.getContentPane().add(btnView);
		
		JLabel lblEnginetype = new JLabel("Engine_Type");
		lblEnginetype.setForeground(new Color(204, 255, 153));
		lblEnginetype.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnginetype.setBounds(0, 98, 101, 17);
		frame.getContentPane().add(lblEnginetype);
		
		engine_type = new JTextField();
		engine_type.setBounds(112, 98, 86, 20);
		frame.getContentPane().add(engine_type);
		engine_type.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(204, 255, 153));
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(10, 120, 71, 20);
		frame.getContentPane().add(lblStatus);
		
		status = new JTextField();
		status.setBounds(112, 122, 86, 20);
		frame.getContentPane().add(status);
		status.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Forte", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				try {
				VRegNo.setText("");
				VID.setText("");
				rate.setText("");
				engine_type.setText("");
				status.setText("");
				
				String query = "select * from v_details where VRegNo= '"+VRegNo+"' ";
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
		btnNewButton_1.setBounds(671, 71, 103, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\taxi4.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
