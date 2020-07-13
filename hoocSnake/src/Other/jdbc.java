package Other;

import java.sql.*;
public class jdbc {
    /**
     * @author Lennox
     * @data 18/12/13
     *  */
    //��ѯ�û�����
    public String FindUser(int id){
        String passd = null;
        String sql = "select * from snakegame where id=?";
        Connection con =getConnection();//��ȡ����
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(sql);//Ԥ����
            pstmt.setInt(1, id);//������ֵ
            rs = pstmt.executeQuery();//ִ��SQL���
            if(rs.next()){//�������ҵ���usernameƥ���password
                passd=rs.getString("name");//����ѯ����password��ֵ��passd
            }else{
                passd=null;//δ��ѯ��Ϊ��
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)rs.close();
                if(pstmt!=null)pstmt.close();
                if(con!=null)con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return passd;//����passd
    }
    //--------------------���Ƿָ���----������-------------------------------
    //ע�����û�
    public void addUser(String username,String passd){
        Connection con = getConnection();
        PreparedStatement pstmt =null;
        String sql = "INSERT INTO User_info(username,password) VALUES(?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, passd);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)pstmt.close();
                if(con!=null)con.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //--------------------���Ƿָ���----������---------------------------
    //�������ݿ�
    public static Connection getConnection(){
        String driver ="com.mysql.jdbc.Driver";//���ݿ�����
        String url ="jdbc:mysql://localhost:3306/snakegame";
        String user ="root";
        String password ="root";
        Connection connection =null;
        try {
            Class.forName(driver);//�������ݿ�����
            connection =DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;//��������
    }

    public static void main(String[] args) {
        jdbc.getConnection();
        jdbc j=new jdbc();
        String t=j.FindUser(1);
        System.err.print(t);

    }
}