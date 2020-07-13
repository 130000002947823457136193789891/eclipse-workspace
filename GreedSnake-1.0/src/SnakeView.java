import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.applet.AudioClip;
import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import javax.swing.JFrame;

public class SnakeView implements Observer{
	SnakeModel model;
	SnakeControl control;
	
	//music
	File f;
	URI uri;
	URL url;
	
	JFrame mainFrame;
	Canvas paintCanvas;
	JLabel labelScore;
	
	public static final int canvasWidth=200;
	public static final int canvasHeight=300;
	
	public static final int nodeWidth=10;
	public static final int nodeHeight=10;
	
	public SnakeView(SnakeModel model,SnakeControl control)
	{
		this.model=model;
		this.control=control;
		
		//music
		try {
			f=new File("C:\\Users\\16770\\Music\\"
					+ "泠鸢yousa - for you.写给你的歌.wav");
			uri = f.toURI();
			url = uri.toURL();
			AudioClip aau;
			aau= Applet.newAudioClip(url);
			aau.loop();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mainFrame=new JFrame("GreedSnake");
		
		Container cp=mainFrame.getContentPane();
		
		//创建顶部的分数显示
		labelScore=new JLabel("Score:");
		cp.add(labelScore,BorderLayout.NORTH);
		
		//创建中间的游戏显示区域
		paintCanvas=new Canvas();
		paintCanvas.setSize(canvasWidth+1,canvasHeight+1);
		paintCanvas.addKeyListener(control);
		cp.add(paintCanvas,BorderLayout.CENTER);
		
		//创建底下的帮助栏
		JPanel panelButtom = new JPanel();
		panelButtom.setLayout(new BorderLayout());
		JLabel labelHelp;
		labelHelp=new JLabel("PgUp,PgDown for speed;",JLabel.CENTER);
		panelButtom.add(labelHelp,BorderLayout.NORTH);
		labelHelp=new JLabel("Enter or R or S for start;",JLabel.CENTER);
		panelButtom.add(labelHelp,BorderLayout.CENTER);
		labelHelp=new JLabel("SPACE or P for pause;",JLabel.CENTER);
		panelButtom.add(labelHelp,BorderLayout.SOUTH);
		cp.add(panelButtom,BorderLayout.SOUTH);
		
		mainFrame.addKeyListener(control);
		mainFrame.pack();
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	
	public void repaint() {
		Graphics g=paintCanvas.getGraphics();
		
		//draw background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, canvasWidth, canvasHeight);
		
		//draw the snake
		g.setColor(Color.black);
		LinkedList na=model.nodeArray;
		Iterator it = na.iterator();
		while(it.hasNext()) {
			Node n = (Node)it.next();
			drawNode(g,n);
		}
		
		//draw the food
		g.setColor(Color.RED);
		Node n =model.food;
		drawNode(g, n);
		
		updateScore();
	}
	
	public void drawNode(Graphics g,Node n) {
		g.fillRect(n.x*nodeWidth, n.y*nodeHeight, nodeWidth-1, nodeHeight-1);
	}
	
	public void updateScore() {
		String s = "Score:"+model.score;
		labelScore.setText(s);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}
}
