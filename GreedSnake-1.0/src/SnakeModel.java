import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;

import javax.swing.JOptionPane;

import java.util.Arrays;
class Node{
	int x,y;
	Node(int x,int y)
	{
		this.x=x;
		this.y=y;
	}     
}

public class SnakeModel extends Observable implements Runnable{
	int maxX,maxY;
	boolean [] [] matrix;   //指示位置上有没有蛇体或食物
	LinkedList nodeArray=new LinkedList();  //蛇体
	Node food;
	boolean running=false;  //运行状态
	int timeInterval=200;
	double speedChangeRate=0.75;
	int direction=2;
	int score=0;
	int countMove=0;
	boolean pause=false;
	//基数左右与偶数上下
	public static final int UP=2;
	public static final int LEFT=1;
	public static final int RIGHT=3;
	public static final int DOWN=4;
	public void speedUp()
	{
		timeInterval *= speedChangeRate;
	}
	public void speedDown()
	{
		timeInterval /= speedChangeRate;
	}
	public void changePauseState()
	{
		pause=!pause;
	}
	public SnakeModel(int maxX,int maxY)
	{
		this.maxX=maxX;
		this.maxY=maxY;
		
		reset();
	}
	public void reset()
	{
		direction=SnakeModel.UP;    //默认向上
		timeInterval=200;           //时间间隔
		speedChangeRate=0.75;        //速度改变率
		running=true;                //运行状态：运行
		pause=false;                 //停止：假
		score=0;                     //分数0分
		countMove=0;                 //吃到食物前移动的次数
		
		//initial matrix ,全部清零
		matrix =new boolean [maxX][];
		for(int i=0;i<maxX;++i)
		{
			matrix[i]=new boolean [maxY];
			Arrays.fill(matrix[i], false);
		}
		
		//initial the snake
		//初始化蛇体，如果横向位置超过20个，长度为10，否则为横向位置的一半
		int initArrayLength=maxX>20 ? 10 : maxX/2;
		nodeArray.clear();
		for(int i=0;i<initArrayLength;++i)
		{
			int x=maxX/2+1;  //maxX被初始化为20
			int y=maxY/2;    //maxY被初始化为30
			//nodeArray[x,y]:[10,15]-[11,15]-[12,15]...[20,15]
			//默认的运行方向向上，所以游戏一开始nodeArray就变为：
			//     [10,14]-[10,15]-[11,15]-[12,15]...[19,15]
			nodeArray.addLast(new Node(x, y));
			matrix[x][y]=true;
		}
		
		//创建食物
		food=createFood();
		matrix[food.x][food.y]=true;
	}
	public boolean moveOn()
	{
		int x,y;
		Node n=(Node) nodeArray.getFirst();  //Returns the first element in this list
		x=n.x;
		y=n.y;
		
		//根据方向增减坐标值
		switch(this.direction)
		{
		case UP:
			y--;
			break;
		case DOWN:
			y++;
			break;
		case RIGHT:
			x++;
			break;
		case LEFT:
			x--;
			break;
			default:
		}
		
		//如果新坐标坐落在有效范围内则进行处理
		if((0<=x && x<maxX) && (0 <= y && y<maxY)) {
			if(matrix[x][y]) {      //如果新坐标的点上有蛇体或食物
				if(x==food.x && y==food.y) {     //吃到食物，成功
					nodeArray.addFirst(food);
					
					//分数规则，与移动改变方向的次数和速度相关
					int scoreGet=(10000-200*countMove)/timeInterval;
					score+=scoreGet>0?scoreGet:10;
					countMove=0;
					
					food=createFood();                  //创建新的食物
					matrix[food.x][food.y]=true;        //设置食物所在的位置
					return true;
				}else          //吃到蛇体自身，失败
					return false;
			}else {       //如果新坐标的点上没有东西（蛇体），移动蛇体
				nodeArray.addFirst(new Node(x,y));
				matrix[x][y]=true;
				n=(Node) nodeArray.removeLast();
				matrix[n.x][n.y]=false;
				countMove++;
				return true;
			}
		}
		return false;        //触到边界，失败
	}
	private Node createFood() {
		// TODO Auto-generated method stub
		int x=0;
		int y=0;
		//随机获取一个有效区域内的与蛇体和食物不重叠的位置
		do {
			Random r=new Random();
			x=r.nextInt(maxX);
			y=r.nextInt(maxY);
		}while(matrix[x][y]);
		return new Node(x, y);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		running=true;
		while(running) {
			try {
				Thread.sleep(timeInterval);
			}
			catch(Exception e)
			{
				break;
			}
			
			if(!pause)
			{
				if(moveOn())
				{
					setChanged();      //Model通知View数据已经更新
					notifyObservers();
				}
				else
				{
					if(JOptionPane.showConfirmDialog(null, "是否重新开始","?",JOptionPane.OK_CANCEL_OPTION)==0) 
					{
						reset();
					}
					else
					{
						JOptionPane.showMessageDialog(null,  "You failed","Game over",JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
			}
		}
		running=false;
	}
	public void changeDirection(int newDirection)
	{
		//方向不能同向
		if(newDirection%2 != direction%2)
			direction=newDirection;
	}
	
	public  String toString() {
		String result="";
		for(int i=0;i<nodeArray.size();++i) {
			Node n=(Node) nodeArray.get(i);
			result +="["+n.x+","+n.y+"]";
		}
		return result;
		
	}
}
