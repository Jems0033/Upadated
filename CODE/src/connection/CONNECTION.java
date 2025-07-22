package connection;


import java.sql.*;
public class CONNECTION {
    public static Connection connection()throws Exception{
        String dburl="jdbc:mysql://localhost:3306/easy_go";
        String dbuser="root";
        String dbpass="";
        Connection con=DriverManager.getConnection(dburl,dbuser,dbpass);
        System.out.println((con!=null)?"Succsessful":"Failed");
        return con;
    }

}
