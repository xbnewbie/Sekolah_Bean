/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekolah.database;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

 
 
/**
 *
 * @author sma
 */
public class DatabaseSql {
   private static  Connection connection=null;
   private static  DatabaseSql db=null;
   private static final Logger logger = Logger.getLogger(DatabaseSql.class);
   private DatabaseSql()
   {
       try{
            Class.forName("org.sqlite.JDBC");	
            connection = (Connection) DriverManager.getConnection("jdbc:sqlite:E:/database/Sekolah.sqlite");
            logger.info("Connected to database");
       }catch(ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
           logger.debug(e);
       }
   }
   
   public static Connection getConnection()
   {
       if(connection==null || db ==null)
       {
           db= new DatabaseSql();
       }
       return connection;
   }
   public static DatabaseSql getInstance()
   {
       if(connection == null || db== null)
       {
           db = new DatabaseSql();
       }
       return db;
   }
}
