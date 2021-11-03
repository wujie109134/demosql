import org.junit.Test;

import java.sql.*;

public class Table {
    private  static  final  String SQL_CREATE ="CREATE TABLE student" +
                "(" +
                "id int not null primary key," +
                "username varchar(50) not NULL," +
                "age varchar(50) not NULL" +
                ")" ;
    private  static  final  String DB_URL ="jdbc:sqlite:/Users/sht/Desktop/sqlite";
    private  static  final  String DB_NAME = "org.sqlite.JDBC";

    @Test
    public void createTable() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
        //创建JDBC驱动
        Class.forName(DB_NAME);
        conn = DriverManager.getConnection(DB_URL);
        statement = conn.prepareStatement(SQL_CREATE);
        statement.execute();
        statement.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    }
}
