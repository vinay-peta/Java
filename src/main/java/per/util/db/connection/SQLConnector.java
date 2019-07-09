package per.util.db.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLConnector extends DBConnector{

	private String host;
	private int port;
	private String dbName;
	
	public SQLConnector(String host,int port,String username,String password,String dbName){
		super(username,password);
		this.host=host;
		this.port=port;
		this.dbName=dbName;
	}
	
	public Connection createConnection() throws ClassNotFoundException, SQLException{
		return createConnection(Constants.DB_SQL_DRIVER_CLASS,generateURL());
	}

	public String generateURL(){
		return "jdbc:sqlserver://"+this.host+":"+this.port+";DatabaseName="+this.dbName;
	}
	
	public static void main(String[] a) throws ClassNotFoundException, SQLException{
		SQLConnector con = new SQLConnector("10.55.129.82",1433,"dbadmin","trans*@123#4","legalCRM");
		con.createConnection();
		System.out.println(con.getQueryDataAsString("select * from legalCRM.dbo.States"));
		con.closeConnection();
	}
}