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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Admin_FeedBack {

	private JFrame frame;
	private JTextField Fno;
	private JTextField CID;
	private JTextField DID;
	private JTextField rating;
	private JTextField cmts;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_FeedBack window = new Admin_FeedBack();
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
			String query = "select * from feedback ";
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
	public Admin_FeedBack() {
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
		
		JLabel lblFno = new JLabel("Fno");
		lblFno.setForeground(new Color(255, 255, 153));
		lblFno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFno.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblFno);
		
		JLabel lblCid = new JLabel("CID");
		lblCid.setForeground(new Color(255, 255, 153));
		lblCid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCid.setBounds(10, 38, 46, 14);
		frame.getContentPane().add(lblCid);
		
		JLabel lblDid = new JLabel("DID");
		lblDid.setForeground(new Color(255, 255, 153));
		lblDid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDid.setBounds(10, 63, 46, 14);
		frame.getContentPane().add(lblDid);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setForeground(new Color(255, 255, 153));
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRating.setBounds(10, 88, 56, 27);
		frame.getContentPane().add(lblRating);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setForeground(new Color(255, 255, 153));
		lblComments.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComments.setBounds(0, 112, 77, 27);
		frame.getContentPane().add(lblComments);
		
		Fno = new JTextField();
		Fno.setBounds(90, 10, 148, 20);
		frame.getContentPane().add(Fno);
		Fno.setColumns(10);
		
		CID = new JTextField();
		CID.setBounds(90, 37, 148, 20);
		frame.getContentPane().add(CID);
		CID.setColumns(10);
		
		DID = new JTextField();
		DID.setBounds(90, 62, 148, 20);
		frame.getContentPane().add(DID);
		DID.setColumns(10);
		
		rating = new JTextField();
		rating.setBounds(90, 93, 148, 20);
		frame.getContentPane().add(rating);
		rating.setColumns(10);
		
		cmts = new JTextField();
		cmts.setBounds(90, 117, 148, 20);
		frame.getContentPane().add(cmts);
		cmts.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(102, 153, 255));
		btnSearch.setForeground(new Color(255, 255, 204));
		btnSearch.setFont(new Font("Forte", Font.PLAIN, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from feedback where Fno = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, Fno.getText());
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ResultSet rs1 = pst.executeQuery();
					if(rs1.next())
						System.out.println();
					else
						JOptionPane.showMessageDialog(null, "Invalid Fno");
					
					pst.close();
					rs1.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(381, 11, 123, 41);
		frame.getContentPane().add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Admin_page ap=new Admin_page();
				ap.setVisible(true);
			}
		});
		btnBack.setBounds(668, 423, 106, 27);
		frame.getContentPane().add(btnBack);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Forte", Font.PLAIN, 15));
		btnView.setForeground(new Color(102, 0, 102));
		btnView.setBackground(new Color(255, 153, 204));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from feedback";
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
		btnView.setBounds(586, 11, 123, 41);
		frame.getContentPane().add(btnView);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 176, 566, 180);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int row=table.getSelectedRow();
					String Fno_ = (table.getModel().getValueAt(row, 0)).toString();
					String query = "select * from feedback where Fno= '"+Fno_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
				
					ResultSet rs = pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
					while(rs.next())
					{
						Fno.setText(rs.getString("Fno"));
						CID.setText(rs.getString("CID"));
						DID.setText(rs.getString("DID"));
						rating.setText(rs.getString("rating"));
						cmts.setText(rs.getString("cmts"));
					}
					
					
					pst.close();
					rs.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fno.setText("");
					CID.setText("");
					DID.setText("");
					rating.setText("");
					cmts.setText("");
					
					String query = "select * from feedback where Fno= '"+Fno+"' ;";
					PreparedStatement ps;				
					ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					ps.close();
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnClear.setBackground(new Color(250, 250, 210));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(487, 88, 114, 41);
		frame.getContentPane().add(btnClear);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\harshu\\documents\\engg\\5th sem\\DBMS Project\\pictures\\a3.jpg"));
		label.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(label);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
