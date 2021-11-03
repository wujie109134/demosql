import org.junit.Test;

import java.sql.*;

public class testsql {

    @Test
    public void sql() {
        try {
            //创建JDBC驱动
            Class.forName("org.sqlite.JDBC");
            //得到驱动地址（数据库文件地址）文件存在桌面就好
            Connection cont = DriverManager.getConnection("jdbc:sqlite:/Users/sht/Desktop/sqlite");
            //链接数据库
            Statement statement = cont.createStatement();
//            // 创建insert  sql语句 向数据库添加数据
//            // 注意：string字段要用单引号
//            String sql1 = "insert into test (mz,age) values ('张三',21) ; ";
//            String sql2 = "insert into test (mz,age) values ('李四',21) ; ";
//            // 执行sql并得到影响的行数
//            int num = statement.executeUpdate(sql1);
//            System.out.println(num+"---");
//            int num2 = statement.executeUpdate(sql2);
//            System.out.println(num2+"---");
//            //向学生表插入数据
//            String sql1 = "insert into student (id,username,age) values (2,'张三',21) ; ";
//            // 执行sql并得到影响的行数
//            int num = statement.executeUpdate(sql1);
//            System.out.println(num+"---");


            // 创建sql查询语句 查询整个表
            String sql = "select * from student;";
            //执行sql并且把数据放入set集合里
            ResultSet set = statement.executeQuery(sql);
            //while循环取出每列的数据并赋值
            while(set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                int age = set.getInt(3);
                System.out.println(id+"  "+name+"   "+age);
            }
            statement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }



}

