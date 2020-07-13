package Other;
import hoocSnake.Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class insertDB {

    public static void main(String[] args) {
        Connection conn = getConnection("root", "root");    // ��ȡ���ݿ�����
        insert(conn);    //�������������ݿ�����
        releaseConnection(conn);// �ͷ����ݿ�����
    }
    //��������
    public static void insert(Connection conn) {
        try {
            Tools tools = new Tools();
            String name1 = tools.getUser1();
            String name2 = tools.getUser2();
            int score1 = tools.getScore1();
            int score2 = tools.getScore2();
            System.out.println("insert name1 name2 score1 score2"+ name1 + score1 + name2 + score2);

            String sql = "insert into player values (NULL, name1, score1)"; // �������ݵ�sql���
            String sql2 = "insert into player values (NULL, name2, score2)";
            Statement stmt1 =conn.createStatement();    // ��������ִ�о�̬sql����Statement����
            int count = stmt1.executeUpdate(sql);  // ִ�в��������sql��䣬�����ز������ݵĸ���
            int count2 = stmt1.executeUpdate(sql2);
            int addcount = count + count2;
            System.out.println("��player�в����� " + addcount + " ������"); //�����������Ĵ�����
            conn.close();   //�ر����ݿ�����
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //���ݿ�����
    public static Connection getConnection(String user, String pass) {
        Connection conn = null;//�������Ӷ���
        String driver = "com.mysql.cj.jdbc.Driver";// ������������
        String url = "jdbc:mysql://localhost:3306/snakegame?" // ���ݿ�URL
                + "useUnicode=true&characterEncoding=UTF8";// ��ֹ����
        try {
            Class.forName(driver);// ע��(����)��������
            conn = DriverManager.getConnection(url, user, pass);// ��ȡ���ݿ�����
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    //�ͷ����ݿ�����
    public static void releaseConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}