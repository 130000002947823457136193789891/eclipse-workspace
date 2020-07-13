
/**
 * @���ߣ�
 * @ʱ�䣺20.11.01
 * @���ܣ��򵥵ļ��±�����
 * @�漰��Ҫ֪ʶ�㣺Java��ͼ�λ����桢ActiveListener�������ļ���io��
 * 	 
 **/

 
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
 
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
//����̳д�����
public class NotePal extends JFrame implements ActionListener {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����һ���ı���
	JTextArea jTextArea = null;
	//����һ���˵���
	JMenuBar jMenuBar = null;
	//����һ���˵�
	JMenu jMenu1 = null;
	//����һ�����򿪡���ѡ��
	JMenuItem jMenuItem1 = null;
	//����һ�������桱��ѡ��
	JMenuItem jMenuItem2 = null;
	//����һ���ļ�ѡ��
	JFileChooser jFileChooser = null;
	//����һ��FileReader�ļ�������
	FileReader fileReader = null;
	//����һ��FileWriter�����
	FileWriter fileWriter = null;
	//����һ�������ַ�������
	BufferedReader bufferedReader = null;
	//����һ�������ַ������
	BufferedWriter bufferedWriter = null;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //ʵ����
		NotePal notePal = new NotePal();
	}
	//���캯��
	public NotePal()
	{
		//ʵ����jTextArea
		jTextArea = new JTextArea();
		//ʵ����jMenuBar
		jMenuBar = new JMenuBar();
		//ʵ������jMenu1��������������Ϊ���ļ���
		jMenu1 = new JMenu("�ļ�");
		//ʵ������MenuItem1������������Ϊ���򿪡�
		jMenuItem1 = new JMenuItem("��");
		//ʵ�ֶ�jMenuItem1�ļ���
		jMenuItem1.addActionListener(this);
		jMenuItem1.setActionCommand("��");
		//ʵ������MenuItem2������������Ϊ�����桱
		jMenuItem2 = new JMenuItem("����");
		//ʵ�ֶ�jMenuItem2�ļ���
		jMenuItem2.addActionListener(this);
		jMenuItem2.setActionCommand("����");
		
		//����jTextArea�ı�����ɫΪ
		jTextArea.setBackground(Color.LIGHT_GRAY);
		
	
		
		//���������ϸ��Ե�λ��
		//��jMenuBar��ӵ�JFrame��
		this.setJMenuBar(jMenuBar);
		//��jMenu��ӵ�jMenuBar��
		jMenuBar.add(jMenu1);
		//��jMenuTItem1��ӵ�Jmenu1��
		jMenu1.add(jMenuItem1);
		//��jMenuTItem2��ӵ�Jmenu1��
		jMenu1.add(jMenuItem2);
		//��jTextArea��ӵ�JFrame��
		this.add(jTextArea);
		
		
		
		//���ô���ı���
		this.setTitle("record history'notes.");
		//���ô���Ĵ�С
		this.setSize(800,600);
		//���رմ��ڵ�ʱ�򣬹رս���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ʾ����
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��"))
		{
			//ʵ����һ��JFileChoose
			jFileChooser = new JFileChooser();
			//�����ļ�ѡ�񴰿ڵ�����
			jFileChooser.setDialogTitle("��������ѡ���Լ����ļ�... ...");
			//�����ļ����ڵ�Ĭ��·��
			jFileChooser.showOpenDialog(null);
			//��ʾ�ļ�����
			jFileChooser.setVisible(true);
			//��address�����û��༭�ļ��ľ���·��
			
				String address = jFileChooser.getSelectedFile().getAbsolutePath();
			
			try {
				//ΪfileReader����ռ�
				fileReader = new FileReader(address);
				//ΪbufferedReader����ռ�
				bufferedReader = new BufferedReader(fileReader);
				//����һ��str�ж�������ַ��Ƿ��Ѿ�Ϊ��
				String str = "";
				//����һ��strAll�����ļ���ȫ����Ϣ
				String strAll = "";
				//��ȡ�ļ���Ϣ�������䱣�浽strAll��
				while((str = bufferedReader.readLine()) != null)
				{
					strAll += str + "\r\n";
				}
				//��strAll�е�ȫ����Ϣ��ʾ��JTextArea��
				jTextArea.setText(strAll);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}finally{
				try {
					//�ر��ļ�
					bufferedReader.close();
					fileReader.close();
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
				
			}
			
			
			
		}
		//����û�����Ǳ��水ť
		if(e.getActionCommand().equals("����"))
		{
			//����һ�����洰��
			JFileChooser jFileChooser1 = new JFileChooser();
			//���ô�������
			jFileChooser1.setDialogTitle("���Ϊ... ...");
			//����Ĭ������
			jFileChooser1.showSaveDialog(null);
			//��ʾ����
			jFileChooser1.setVisible(true);
			try {
				//ΪfileWrite����ռ�
				fileWriter = new FileWriter(jFileChooser1.getSelectedFile().getAbsolutePath());
				//ΪbufferedWrite����ռ�
				bufferedWriter = new BufferedWriter(fileWriter);
				//�����ȥ
				bufferedWriter.write(this.jTextArea.getText());
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}finally{
				//�ر��ļ�
				try {
					bufferedWriter.close();
					fileWriter.close();
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
			}
			
		}
	}
 
}
