package Other;

import hoocSnake.Tools;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class quary {
    private int id;
    private String name;
    private int score;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        //��ȡ���ݿ������
        String url = "jdbc:mysql://localhost:3306/snakegame";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        //3.��ȡ�������ݿ�Ķ���
        Statement statement = connection.createStatement();

        String sql = "select * from player;";
        ResultSet resultSet = statement.executeQuery(sql);
        Tools tools = new Tools();
        //���������
        DefaultTableModel model = new DefaultTableModel();//����һ�����ģ��
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int score = resultSet.getInt("score");
            System.out.println("���" + "id" + ":" + name + "����" + score);
            //������������ӵ����ģ�͵�ÿһ����



        }

        connection.close();

    }
}