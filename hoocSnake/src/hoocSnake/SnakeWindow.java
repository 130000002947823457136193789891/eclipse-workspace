package hoocSnake;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/*
���ļ�����̰���ߴ���ҳ�棬�����˵��������ں���������
 */
public class SnakeWindow extends JDialog{
		//int LevelNumber;
	//̰����ҳ��
	public SnakeWindow(String UserName1,String UserName2) {
			//this.LevelNumber= LevelNumeber;
		 JFrame frame = new JFrame();
	        frame.setBounds(10,10,840,690);
	        frame.setResizable(false);

	        JMenuBar jMenuBar = new JMenuBar();
	        JMenu level = new JMenu("����");
	        JMenu rank = new JMenu("����");
	        JMenu about = new JMenu("����");

			JMenuItem rankItem = new JMenuItem("��ʾ����");
			JMenuItem aboutItem = new JMenuItem("������Ϣ");
			JMenuItem introduction= new JMenuItem("��Ϸ����");
			JMenuItem exitLogin = new JMenuItem("ע����½");
	        JMenuItem quit = new JMenuItem("�˳�");

	        jMenuBar.add(level);
	        jMenuBar.add(rank);
	        jMenuBar.add(about);
	        rank.add(rankItem);
	        about.add(introduction);
	        about.add(aboutItem);
			level.add(exitLogin);
	        level.addSeparator();
			Tools tools = new Tools();


	        //ʵ�ֹ��ڵ������ڵļ���
			exitLogin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					new showSnakeLogin.loginSnake();
				}
			});
			aboutItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new aboutWindow();
				}
			});
			introduction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new introductionWindow();
			}
			});


			rankItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new rankWindow();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});

	        //ʵ�ֲ˵����˳�����
	        level.add(quit);
	        quit.addActionListener(new ActionListener() {

			  @Override
			  public void actionPerformed(ActionEvent e) {
			  System.exit(0);

					}

	         	});

	        frame.setJMenuBar(jMenuBar);
//	      sheet = new JMenuItem("");

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        String u1 = UserName1;
	        String u2 = UserName2;

	        Snake panel = new Snake(u1,u2);
	        frame.add(panel);
	        frame.setVisible(true);

	}
	//����ҳ��
	public class aboutWindow extends JFrame{
		 public aboutWindow() {
			 this.setSize(400,180);
			 this.setLocation(230,200);
			 this.setTitle("����");
			 this.setResizable(false);
			 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			 
			 JPanel jPanel = new JPanel();
			 JLabel jLabel1 = new JLabel("                                   ");
			 JLabel jLabel4 = new JLabel("                                   ");
			 JLabel jLabel = new JLabel("hooc��Դ��Ŀ���ɹ�ѧϰ����ֹ������ҵ��;");
			 JLabel jLabel2 = new JLabel("�ٷ���վ��www.hooc.top");
			 JLabel jLabel3 = new JLabel("����΢�ţ�Air_mars)");
			 jPanel.add(jLabel1);
			 jPanel.add(jLabel4);
			 jPanel.add(jLabel);
			 jPanel.add(jLabel2);
			 jPanel.add(jLabel3);
			 
			 this.add(jPanel);
			 this.setVisible(true);
		 }
		 
		

	}
	//��Ϸ����ҳ��

	public class introductionWindow extends JFrame{
		public introductionWindow() {
			this.setSize(400,200);
			this.setLocation(230,200);
			this.setTitle("hooc˫��̰������Ϸ����");
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JPanel jPanel = new JPanel();
			JLabel jLabel1 = new JLabel("                                              ");
			JLabel jLabel2 = new JLabel("          ���߿��ư�ť A�� S�� D�� W��           ");
			jLabel2.setForeground(Color.pink);
			JLabel jLabel3 = new JLabel("          ���߿��ư�ť С������������             ");
			jLabel3.setForeground(Color.BLUE);
			JLabel jLabel4 = new JLabel("          �ж�����������������ײ                  ");
			JLabel jLabel5 = new JLabel("          ���²���Ϊ��������                      ");
			JLabel jLabel6 = new JLabel("          1.�����߽� 2.ײ���������� 3.��������      ");
			jLabel6.setForeground(Color.orange);
			jPanel.add(jLabel1);
			jPanel.add(jLabel2);
			jPanel.add(jLabel3);
			jPanel.add(jLabel4);
			jPanel.add(jLabel5);
			jPanel.add(jLabel6);

			this.add(jPanel);
			this.setVisible(true);
		}



	}
	//����ҳ��
	public class rankWindow extends JFrame{
		private int id;
		private String name;
		private int score;
		 public rankWindow() throws SQLException, ClassNotFoundException {
			//���ݿ����Ӳ�ѯ����
			 Class.forName("com.mysql.cj.jdbc.Driver");

			 //��ȡ���ݿ������
			 String url = "jdbc:mysql://localhost:3306/snakegame";
			 Connection connection = DriverManager.getConnection(url,"root","root");

			 //3.��ȡ�������ݿ�Ķ���
			 Statement statement = connection.createStatement();

			 String sql = "select * from player order by score desc;";
			 ResultSet resultSet = statement.executeQuery(sql);
			 Tools tools = new Tools();
			 //���������
			 DefaultTableModel model = new DefaultTableModel(){
			 	public boolean isCellEditable(int row,int column){
			 		return false;
				}
			 };//����һ�����ģ��

			 model.setColumnIdentifiers(new Object[]{"�ǳ�","����","ʱ���"});
			 while (resultSet.next()){

				 String name =  resultSet.getString("name");
				 int score = resultSet.getInt("score");
				 String time = resultSet.getString("time");
				 System.out.println("���"+"id"+":"+name+"����"+score);
				 //������������ӵ����ģ�͵�ÿһ����
				 model.addRow(new Object[]{name,score,time});
			 }





//			 this.setSize(200,500);
			 this.setLocation(50,100);
			 this.setTitle("����");
			 this.setResizable(false);
			 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			 JPanel jPanel = new JPanel();

			 JTable table = new JTable(model);
			 table.setRowHeight(30);
			 table.setPreferredScrollableViewportSize(new Dimension(350,350));//�������̫���Զ���ӹ�����
			 table.setBackground(new Color(54,66,74));
			 table.setForeground(Color.white);

			 //���ñ�����ݾ�����ʾ
			 DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			 r.setHorizontalAlignment(JLabel.CENTER);
			 table.setDefaultRenderer(Object.class,r);

			 JScrollPane scrollPane = new JScrollPane(table);
			 this.getContentPane().add(scrollPane,BorderLayout.CENTER);
			 this.pack();//����Ӧ��С����Ȼ���С
			 connection.close();
			 this.setVisible(true);
		 }
	}

	}
