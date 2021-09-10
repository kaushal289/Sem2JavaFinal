package TechPrali;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 

public class JDBCoperation {
    Connection con;
    Statement st;
    int val;
    ResultSet rows;
    int valuess;
    int values;
    public JDBCoperation() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1235");
			if (con!=null) {
				System.out.println("connected");
				 st=con.createStatement();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		public int insert(String query) {
		    try {
		        
		    val=st.executeUpdate(query); 
		    con.commit();
		    con.close();
		    }catch(SQLException throwables){
		        throwables.printStackTrace();
		        
		    }
		

		return val;
}
		public ResultSet select(String query) {
			try {
				 rows =st.executeQuery(query);
		}
			catch(SQLException throwables) {
				throwables.printStackTrace();
				
			}
			return rows;
			
    }
		public  int Update(String query) {
			try {
				values=st.executeUpdate(query);
			}
			catch(SQLException throwables) {
				throwables.printStackTrace();
			}
			return values;
		
	}
	


	public int executeDelete(String sql) {
		try {
			values=st.executeUpdate(sql);
			
		}
		catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		// TODO Auto-generated method stub
		return values;
	}
	public static void main(String[]args) {
    	new JDBCoperation();
    
	}
}