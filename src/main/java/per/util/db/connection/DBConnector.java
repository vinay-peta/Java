package per.util.db.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnector {
	
	private String username;
	private String password;
	
	public DBConnector(String username, String password){
		this.username=username;
		this.password=password;
	}
	
	protected Connection connection;

	public Connection createConnection(String className,String url) throws ClassNotFoundException, SQLException {
		Class.forName(className);  
		return connection = DriverManager.getConnection(url,username,password);
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	public String getQueryDataAsString(String query) throws SQLException {
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
	    int totalColumns = rsmd.getColumnCount();    
	    
	    StringBuffer buf = new StringBuffer();
		while (rs.next()) {
			for(int columnIndex =1;columnIndex<=totalColumns;columnIndex++){
				buf.append(rs.getString(columnIndex)+Constants.CSV_SEPARATOR);
			}
			buf.replace(buf.length()-1, buf.length(), Constants.EMPTY_STRING).append(Constants.NEW_LINE);
		}
		rs.close();
		stmt.close();
		return buf.toString();
	}
	
	public File saveQueryDataAsCSVFile(String query,String filePath) throws FileNotFoundException, SQLException{
		File file = new File(filePath);
		PrintWriter writer = new PrintWriter(file);
		writer.print(getQueryDataAsString(query));
		writer.flush();
		writer.close();
		return file;
	}
}
