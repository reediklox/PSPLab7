/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class MyDBConnector {
    private Connection myConnection;
    
    public MyDBConnector() {}

    public void init()
    {
     try
     {
      Class.forName("com.mysql.cj.jdbc.Driver");
      myConnection=DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "1234");
     }
     catch(ClassNotFoundException | SQLException e)
     {
      System.out.println(e);
     }
    }

    public Connection getMyConnection()
    {
     return myConnection;
    }

    public void close(ResultSet rs)
    {
     if(rs !=null)
     {
      try
      {
       rs.close();
      }
      catch(SQLException e){}
     }
    }

    public void close(java.sql.Statement stmt)
    {
     if(stmt !=null)
     {
      try
      {
       stmt.close();
      }
      catch(SQLException e){}
     }
    }

    public void destroy()
    {
     if(myConnection !=null)
     {
      try
      {
       myConnection.close();
      }
      catch(SQLException e){}
     }
    }  

}
