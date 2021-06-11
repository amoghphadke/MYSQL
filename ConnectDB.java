import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDB {

	
	static Connection connection = null;
	static String databaseName = "StudentDatabase";
	static String url = "jdbc:mysql://localhost:3306/" + databaseName;
	static String username = "root";
	static String password = "";
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		connection = DriverManager.getConnection(url, username, password);
		
		
		PreparedStatement ps = connection.prepareStatement("CREATE TABLE grades (grade    INTEGER);");
		PreparedStatement ps1 = connection.prepareStatement("CREATE TABLE courses (courseID    VARCHAR(50));");
		PreparedStatement ps2 = connection.prepareStatement("CREATE TABLE gradDate (time    DATETIME);");
		PreparedStatement ps3 = connection.prepareStatement("INSERT INTO grades VALUES (81); ");
		PreparedStatement ps4 = connection.prepareStatement("INSERT INTO grades VALUES (95); ");
		PreparedStatement ps5 = connection.prepareStatement("INSERT INTO courses VALUES ('Software Engineering'); ");
		//PreparedStatement ps1 = connection.prepareStatement("INSERT INTO 'studentdatabase'.'pictures'('id') VALUES ('5');");
		
		ps.executeUpdate();
		ps1.executeUpdate();
		ps2.executeUpdate();
		ps3.executeUpdate();
		ps4.executeUpdate();
		ps5.executeUpdate();
		//System.out.println(status);
		//if(status != 0) {
			//System.out.println("Success");
		//}
		//else;
		//{
		//System.out.println("Did not work");	
		//}
		
		
		}
		
	}


