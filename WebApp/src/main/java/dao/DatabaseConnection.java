package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class DatabaseConnection {
	private String strClassName;
    private String dbName;
    private String login;
    private String motdepasse;
    private String strUrl;
    private Connection conn;
    private Statement statement;

    public DatabaseConnection() throws SQLException, ClassNotFoundException{
        this.strClassName = "com.mysql.cj.jdbc.Driver";
        this.dbName= "gestion_educative";
        this.login= "admin";
        this.motdepasse= "admin123";
        this.strUrl = "jdbc:mysql://localhost:3306/gestion_educative" + this.dbName; 
        Class.forName(strClassName);
        this.conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/gestion_educative?autoReconnect=true&useSSL=false&serverTimezone=UTC", 
        	    "app_gestion", 
        	    "MotDePasseSecure123!");
        this.statement = (Statement) conn.createStatement();
    }

    public void fermerConnexion() throws SQLException {
        this.conn.close();
    }
}