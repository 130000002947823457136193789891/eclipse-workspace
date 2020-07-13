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
	boolean [] [] matrix;   //ָʾλ������û�������ʳ��
	LinkedList nodeArray=new LinkedList();  //����
	Node food;
	boolean running=false;  //����״̬
	int timeInterval=200;
	double speedChangeRate=0.75;
	int direction=2;
	int score=0;
	int countMove=0;
	boolean pause=false;
	//����������ż������
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
		direction=SnakeModel.UP;    //Ĭ������
		timeInterval=200;           //ʱ����
		speedChangeRate=0.75;        //�ٶȸı���
		running=true;                //����״̬������
		pause=false;                 //ֹͣ����
		score=0;                     //����0��
		countMove=0;                 //�Ե�ʳ��ǰ�ƶ��Ĵ���
		
		//initial matrix ,ȫ������
		matrix =new boolean [maxX][];
		for(int i=0;i<maxX;++i)
		{
			matrix[i]=new boolean [maxY];
			Arrays.fill(matrix[i], false);
		}
		
		//initial the snake
		//��ʼ�����壬�������λ�ó���20��������Ϊ10������Ϊ����λ�õ�һ��
		int initArrayLength=maxX>20 ? 10 : maxX/2;
		nodeArray.clear();
		for(int i=0;i<initArrayLength;++i)
		{
			int x=maxX/2+1;  //maxX����ʼ��Ϊ20
			int y=maxY/2;    //maxY����ʼ��Ϊ30
			//nodeArray[x,y]:[10,15]-[11,15]-[12,15]...[20,15]
			//Ĭ�ϵ����з������ϣ�������Ϸһ��ʼnodeArray�ͱ�Ϊ��
			//     [10,14]-[10,15]-[11,15]-[12,15]...[19,15]
			nodeArray.addLast(new Node(x, y));
			matrix[x][y]=true;
		}
		
		//����ʳ��
		food=createFood();
		matrix[food.x][food.y]=true;
	}
	public boolean moveOn()
	{
		int x,y;
		Node n=(Node) nodeArray.getFirst();  //Returns the first element in this list
		x=n.x;
		y=n.y;
		
		//���ݷ�����������ֵ
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
		
		//�����������������Ч��Χ������д���
		if((0<=x && x<maxX) && (0 <= y && y<maxY)) {
			if(matrix[x][y]) {      //���������ĵ����������ʳ��
				if(x==food.x && y==food.y) {     //�Ե�ʳ��ɹ�
					nodeArray.addFirst(food);
					
					//�����������ƶ��ı䷽��Ĵ������ٶ����
					int scoreGet=(10000-200*countMove)/timeInterval;
					score+=scoreGet>0?scoreGet:10;
					countMove=0;
					
					food=createFood();                  //�����µ�ʳ��
					matrix[food.x][food.y]=true;        //����ʳ�����ڵ�λ��
					return true;
				}else          //�Ե���������ʧ��
					return false;
			}else {       //���������ĵ���û�ж��������壩���ƶ�����
				nodeArray.addFirst(new Node(x,y));
				matrix[x][y]=true;
				n=(Node) nodeArray.removeLast();
				matrix[n.x][n.y]=false;
				countMove++;
				return true;
			}
		}
		return false;        //�����߽磬ʧ��
	}
	private Node createFood() {
		// TODO Auto-generated method stub
		int x=0;
		int y=0;
		//�����ȡһ����Ч�����ڵ��������ʳ�ﲻ�ص���λ��
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
					setChanged();      //Model֪ͨView�����Ѿ�����
					notifyObservers();
				}
				else
				{
					if(JOptionPane.showConfirmDialog(null, "�Ƿ����¿�ʼ","?",JOptionPane.OK_CANCEL_OPTION)==0) 
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
		//������ͬ��
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
