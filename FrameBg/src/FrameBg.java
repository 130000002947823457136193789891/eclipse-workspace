import  java.awt.*;
import  javax.swing.*;
import java.awt.Container;

public class FrameBg  {

    public FrameBg() {
    }
    public static void main (String[] args) {
    JFrame frame=new JFrame("����ͼ����");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon img = new ImageIcon("image//body.png ");//���Ǳ���ͼƬ
JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�

frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ���ӵ�jfram��LayeredPane����
imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//���ñ�����ǩ��λ��
Container cp=frame.getContentPane();
cp.setLayout(new BorderLayout());
JButton but=new JButton("anniu");//������ť
cp.add(but,"North");//����ť�����봰�ڵ��������

((JPanel)cp).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������

frame.setSize(500,300);
frame.setVisible(true);  
            
}
}