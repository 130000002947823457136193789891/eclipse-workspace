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
	
	private JLabel label =new JLabel("当前长度：");
	private JLabel label2=new JLabel("所花时间：");
	private JLabel label3 =new JLabel("说            明：");
	private JTextArea explain=new JTextArea("此游戏是一个贪吃蛇Demo版本，实现简单地移动，得分，判断撞墙和撞自己的功能，"
			+ "初始长度为6，头部为红色，身体的颜色渐变。游戏本身代码只有300行，加上一些显示，计时和音效后多了几百行。\n"
+ "游戏界面按上下左右键实现移动，按ESC重新开始，按空格键可以实现暂停和开始");
	private JLabel Score = new JLabel("1");
	private JLabel Time =new JLabel("");
	private Font f = new Font ("微软雅黑",Font.PLAIN,15);
	private Font f2 = new Font("微软雅黑",Font.PLAIN,13);
	private JPanel p = new JPanel();
	
	private final int MAX_SIZE =400;//蛇身体最长为400节
	private Tile temp = new Tile(0,0);
	private Tile temp2=new Tile(0,0);
	private Tile head;
	private Tile[] body = new Tile[MAX_SIZE];
	
	private String direction = "R";//默认向右走
	private String current_direction = "R";//当前方向
	private boolean first_launch = false;
	private boolean iseaten = false;
	private boolean isrun = true;
	private int randomx,randomy;
	private int body_length = 0;//身体长度初始化为0
	private Thread run;
	
	private int hour =0;
	private int min =0;
	private int sec =0;
	
	private boolean pause =false;
	
	private long millis = 500;//每隔500毫秒刷新一次
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
		
		//布局
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
