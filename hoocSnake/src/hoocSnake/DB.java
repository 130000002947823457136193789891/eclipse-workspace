package hoocSnake;


import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
        public static void main(String[] args){

            Connection conn= getConnection("root", "root"); //��ȡ���ݿ�����
            /*,,,,�˴�Ϊ����������ȡ����,���� query(conn),,,,,*/
            releaseConnection(conn); // �ͷ����ݿ�����
        }

        /*,,,,,,,,,,�˴�����һ������Ҫ�Ĺ��ܵķ���,,,,,,,,,,,,*/


        //���ݿ�����
        public static Connection getConnection(String user, String pass) {

            Connection conn = null;//�������Ӷ���
            String driver = "com.mysql.jdbc.Driver";// ������������
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
        // �ͷ����ݿ�����
        public static void releaseConnection(Connection conn) {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



}