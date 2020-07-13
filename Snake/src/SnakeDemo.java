import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;
import javax.sound.sampled.*;
import javax.swing.*;

class Tile{
	int x;
	int y;
	
	public Tile(int x0,int y0) {
		x = x0;
		y=y0;
	}
}

public class SnakeDemo extends JComponent {

	private static final long serialVersionUID=3794762291171148906L;
	
	private JLabel label =new JLabel("��ǰ���ȣ�");
	private JLabel label2=new JLabel("����ʱ�䣺");
	private JLabel label3 =new JLabel("˵            ����");
	private JTextArea explain=new JTextArea("����Ϸ��һ��̰����Demo�汾��ʵ�ּ򵥵��ƶ����÷֣��ж�ײǽ��ײ�Լ��Ĺ��ܣ�"
			+ "��ʼ����Ϊ6��ͷ��Ϊ��ɫ���������ɫ���䡣��Ϸ�������ֻ��300�У�����һЩ��ʾ����ʱ����Ч����˼����С�\n"
+ "��Ϸ���水�������Ҽ�ʵ���ƶ�����ESC���¿�ʼ�����ո������ʵ����ͣ�Ϳ�ʼ");
	private JLabel Score = new JLabel("1");
	private JLabel Time =new JLabel("");
	private Font f = new Font ("΢���ź�",Font.PLAIN,15);
	private Font f2 = new Font("΢���ź�",Font.PLAIN,13);
	private JPanel p = new JPanel();
	
	private final int MAX_SIZE =400;//�������Ϊ400��
	private Tile temp = new Tile(0,0);
	private Tile temp2=new Tile(0,0);
	private Tile head;
	private Tile[] body = new Tile[MAX_SIZE];
	
	private String direction = "R";//Ĭ��������
	private String current_direction = "R";//��ǰ����
	private boolean first_launch = false;
	private boolean iseaten = false;
	private boolean isrun = true;
	private int randomx,randomy;
	private int body_length = 0;//���峤�ȳ�ʼ��Ϊ0
	private Thread run;
	
	private int hour =0;
	private int min =0;
	private int sec =0;
	
	private boolean pause =false;
	
	private long millis = 500;//ÿ��500����ˢ��һ��
	private boolean speed = true;
	private Calendar Cld;
	private int MI,MI2,MI3;
	private int SS,SS2,SS3;
	
	public SnakeDemo() {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}catch(InstantiationException e1) {
			e1.printStackTrace();
		}catch(IllegalAccessException e1) {
			e1.printStackTrace();
		}catch (UnsupportedLookAndFeelException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		//����
		add(label);
		label.setBounds(500,10,80,20);
		label.setFont(f);
		add(Score);
		Score.setBounds(500,35,80,20);
		Score.setFont(f);
		add(label2);
		label2.setBounds(500, 60, 80, 20);
		label2.setFont(f);
		add(Time);
		Time.setBounds(500, 60, 80, 20);
		Time.setFont(f);
		add(p);
		p.setBounds(498,110,93,1);
		
	}
			
}
