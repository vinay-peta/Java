package per.util.db.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class OracleConnector extends DBConnector{

	private String host;
	private int port;
	private String dbName;
	
	public OracleConnector(String host,int port,String username,String password,String dbName){
		super(username,password);
		this.host=host;
		this.port=port;
		this.dbName=dbName;
	}
	
	public Connection createConnection() throws ClassNotFoundException, SQLException{
		return createConnection(Constants.DB_ORACLE_DRIVER_CLASS,generateURL());
	}

	public String generateURL(){
		return "jdbc:oracle:thin:@"+this.host+":"+this.port+"/XE";
	}
	
	public static void main(String[] a) throws ClassNotFoundException, SQLException{
		OracleConnector con = new OracleConnector("localhost",1521,"system","password","");
		con.createConnection();
		System.out.println(con.getQueryDataAsString("select * from RS_INVOICE_LINE_ADDRESSES"));
		con.closeConnection();
	}
}
