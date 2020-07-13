package xjx;

import java.awt.*;
import javax.swing.*;

public class Help extends JDialog {
    private static final long serialVersionUID = 4693799019369193520L;
    private JPanel contentPane;
    private Font f = new Font("΢���ź�",Font.PLAIN,15);
    private JScrollPane scroll;
	
    public Help() {
        setTitle("��Ϸ����˵��");//���ô������
        Image img=Toolkit.getDefaultToolkit().getImage("title.png");//����ͼ��
        setIconImage(img);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);//����Ϊģ̬����
        setSize(410,380);
        setResizable(false);
        setLocationRelativeTo(null);
        contentPane = new JPanel();// �����������
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        ShadePanel shadePanel = new ShadePanel();// �������䱳�����
        contentPane.add(shadePanel, BorderLayout.CENTER);// �����嵽�����������
        shadePanel.setLayout(null);
        
        JTextArea J1 = new JTextArea("��Ϸ˵�����£�\nͨ�������ϵķ������������"
        		+ "ǰ���ķ��򣬳������Լ��١�����Ϸ���水ESC������ֱ�����¿�ʼ��Ϸ�����ո������ʵ����ͣ�Ϳ�ʼ���˵���"
        		+ "�����ò˵����Ը�����ͷ������ѡ���ٶȣ������������Լ����������Ƿ�ɼ�����Ϸ�����ұ߻���ʾ��ĵ�ǰ���ȣ�"
        		+ "�÷֣���ǰ�����е��ӵ������Լ����뵱ǰʳ����ʧ���ƶ�ʣ���ʱ�䡣��Ϸ���ж���ʳ����Ƕ�Ӧ��"
        		+ "��ֵ��ͬ�����ֵĸ���Ҳ��ͬ������ʳ�������Ӧʱ�����Զ��ƶ�������ʧ�����ԣ�����ʱ���١��˰汾�����һ��"
        		+ "���������ϰ���ϰ������������ÿ��һ��ʱ���Զ�����ƶ����ϰ���ĳ���Ҳ���������Ҳ�����"
        		+ "�������˵���ز��ԣ����ų���Ϸ��ʼʱ�ϰ������������ǰ�������������������Լ���������ϰ���ı�λ��ʱҲ����"
        		+ "����������ǰ�����Լ��ٲ����ϸ��汾�������˰汾�����з��ա�ͬʱ��Ϊ������ϰ���ĳ��֣���Ϸ������������ӵ�����"
        		+ "ǰ����·�ϵ��ϰ���ļ��ܣ�ע�⣬�����ٵ�Ŀ���ϰ������㷢���ӵ�ʱ����ǰ������ǰ�����������ש�顣���û�У��ӵ�"
        		+ "��һֱ�ƶ�����Ļ�⡣���⣬Ŀǰÿ��ֻ�ܷ���һ���ӵ����������������ö�ӵ���ÿ�η����ӵ�ǰ�õȵ�ǰһö�ӵ�"
        		+ "�ѻ����ϰ�������ƶ�����Ļ����ܷ��䡣�ӵ�ͨ�����ض���ʳ���ã�ʳ������Ϊһ��ǹ���Ե�ǹÿ������һ���ӵ���"
        		+ "�����ӵ÷֣����ӳ��ȡ��ӵ������ĸ���������ʳ������ͣ��������Լʹ�á����⣬��Shift�������ӵ���\n                   "
        		+ "     ");
        J1.setFocusable(false);
    	J1.setFont(f);
    	J1.setEditable(false);
    	J1.setOpaque(false);//����͸��
    	J1.setLineWrap(true);
    	
    	scroll = new JScrollPane(J1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBorder(BorderFactory.createTitledBorder("How to play"));
    	scroll.setOpaque(false);
    	scroll.getViewport().setOpaque(false);//JScrollPane���ó�͸���������һ��
    	shadePanel.add(scroll);
    	scroll.setBounds(10, 10, 385, 330);
    	
    	setVisible(true);
    }
    
    public static void main(String[] args) {
		new Help();
	}
}