import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectMySQL {
	Connection con=null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiclebookingmanagemetsystem", "root", "sunidhisql2024");
			
			//JOptionPane.showMessageDialog(null, "connection successfull");
			return con;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
