package hoocSnake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Random;

/*
��ҳ����ҪΪ����̰���ߺ���Ϸ����ҳ��
 */


public class Snake extends JPanel implements KeyListener,ActionListener{

    // �����߸�ͼƬ��������������ͼƬ
    ImageIcon up = new ImageIcon("./pic/up.png"); // ���ϵ���ͷ
    ImageIcon down = new ImageIcon("./pic/down.png"); // ���µ���ͷ
    ImageIcon left = new ImageIcon("./pic/left.png"); // �������ͷ
    ImageIcon right = new ImageIcon("./pic/right.png"); // ���ҵ���ͷ
    ImageIcon food = new ImageIcon("./pic/food.png");  // ʳ��
    ImageIcon body = new ImageIcon("./pic/body.png");  // �ߵ�����
    ImageIcon title = new ImageIcon("./pic/title.jpg"); // ��Ϸ���������
    ImageIcon Snakebg = new ImageIcon("./pic/Snakebg.png");

    ImageIcon up2 = new ImageIcon("./pic/up2.png"); // ���ϵ���ͷ
    ImageIcon down2 = new ImageIcon("./pic/down2.png"); // ���µ���ͷ
    ImageIcon left2 = new ImageIcon("./pic/left2.png"); // �������ͷ
    ImageIcon right2 = new ImageIcon("./pic/right2.png"); // ���ҵ���ͷ
//    ImageIcon food = new ImageIcon("./pic/food.png");  // ʳ��
    ImageIcon body2 = new ImageIcon("./pic/body2.png");  // �ߵ�����
    private String Name1;
    private String Name2;
    //private static int LevelNumber;

    // �ߵ�ÿһ����
    int[] firstSnakex = new int [750];//�����һ����
    int[] firstSnakey = new int [750];
    int[] secondSnakex = new int [750];//����ڶ�����
    int[] secondSnakey = new int [750];

    // �������ʳ��
    Random rand = new Random();
    int foodx = rand.nextInt(32)*25; //�˴�����ֵ�����Լ���Ƶ���Ϸ����Ĵ�С��ȷ��
    int foody = rand.nextInt(22)*25+55;
    int foodx2 = rand.nextInt(32)*25; //�˴�����ֵ�����Լ���Ƶ���Ϸ����Ĵ�С��ȷ��
    int foody2 = rand.nextInt(22)*25+55;

    // ������Ϸ��Ĭ������
    // ������Ϸ��Ĭ������
    int len = 3;
    int len2 = 3;
    int score = 0;
    int score2 = 0;
  //  int level = 100;
    String direction = "D"; // U�� D�� L�� R��
    String direction2 = "L";

    boolean isStarted = false; // �ж���Ϸ�Ƿ�ʼ
    boolean isFailed = false; // �ж���Ϸ�Ƿ����

 //   int ChooseLevel = SnakeWindow().ChooseLevel;
        Tools tools = new Tools();//�½�һ��������
//       // tools.setLevel(2);
//
//        int Level = tools.getLevel();

        int getLevelNumber = tools.getLevel();
        Timer timer = new Timer(getLevelNumber,this); // ÿ100�������һ��ActionPerforme

//        String User1 = tools.getUser1();
//        String User2 = tools.getUser2();





    //��ȡ����ǳ�


    public Snake(String Name1,String Name2) { // ���컭���Ĺ��캯��  1
        this.setFocusable(true);  // ��ȡ����
        this.addKeyListener(this); // ���������¼�
        this.Name1 = Name1;
        this.Name2 = Name2;

        setup();
        timer.start();
    }
    
    public void paint(Graphics g) { // Graphics ����
        this.setBackground(Color.CYAN); // ���û���������ɫ
        title.paintIcon(this, g, 0, 0);// ��������ͼƬ
        Snakebg.paintIcon(this, g, 0, 54);// ������Ϸ����
       // g.fillRect(0, 64, 850, 647); // �û���������Ϸ����
        // ��1��ͷ��ע���ж���ͷ�ķ���
        if (direction.equals("R"))
            right.paintIcon(this, g, firstSnakex[0], firstSnakey[0]);
        else if (direction.equals("L"))
            left.paintIcon(this, g, firstSnakex[0], firstSnakey[0]);
        else if (direction.equals("U"))
            up.paintIcon(this, g, firstSnakex[0], firstSnakey[0]);
        else if (direction.equals("D"))
            down.paintIcon(this, g, firstSnakex[0], firstSnakey[0]);

        if (direction2.equals("R"))
            right2.paintIcon(this, g, secondSnakex[0], secondSnakey[0]);
        else if (direction2.equals("L"))
            left2.paintIcon(this, g, secondSnakex[0], secondSnakey[0]);
        else if (direction2.equals("U"))
            up2.paintIcon(this, g, secondSnakex[0], secondSnakey[0]);
        else if (direction2.equals("D"))
            down2.paintIcon(this, g, secondSnakex[0],secondSnakey[0]);
        // ���ߵ�����
        for(int i = 1; i < len; i ++)
            body.paintIcon(this, g, firstSnakex[i],  firstSnakey[i]);
        for(int i = 1; i < len2; i ++)
            body2.paintIcon(this, g, secondSnakex[i], secondSnakey[i]);

        // �ж������Ϸû��ʼ��ʾ������
        if (!isStarted){
            g.setColor(Color.WHITE);
            g.setFont(new Font("΢���ź�",Font.BOLD, 30));
            g.drawString("���¿ո��  ��ʼ / ��ͣ", 230, 300);
        }

        // �ж������Ϸ������ʾ������
        if (isFailed){
            g.setColor(Color.WHITE);
            g.setFont(new Font("΢���ź�",Font.BOLD, 30));
            g.drawString("��Ϸ������ ���¿ո������", 230, 300);
        }

        // ��ʾʳ��
        food.paintIcon(this, g, foodx, foody);
        food.paintIcon(this,g,foodx2,foody2);
        //��λ
//        food.paintIcon(this, g, 0, 0);
//        food.paintIcon(this, g, 0, 600);
//        food.paintIcon(this, g, 800, 55);
//        food.paintIcon(this, g, 800, 0);
//        food.paintIcon(this, g, 800, 600);
//        food.paintIcon(this, g, 0, 55);
//        food.paintIcon(this, g, 800, 600);


      //  JTextField jTextField1 = new Trans().getjTextField();
       // JTextField jTextField2 = new Trans().getjTextField2();
       // System.out.println(jTextField1.getText() + ":" + jTextField2.getText());
        // ���÷������ߵĳ���
        g.setColor(Color.WHITE);
        g.setFont(new Font("΢���ź�",Font.PLAIN,15));
        g.drawString( Name1+"���� : "+score, 550, 40);
        g.drawString( Name2+"���� : "+score2, 445, 40);
        String LevelString = null;
        if(getLevelNumber == 50){
            LevelString = "����";
        }else if(getLevelNumber == 100){
            LevelString = "һ��";
        }else if(getLevelNumber == 150) {
            LevelString = "��";
        }else{
            LevelString ="Ĭ��";
        }
        g.drawString( "�Ѷ� : "+LevelString, 680, 40);
      
    }

    public void setup() { // ��Ϸ��ʼ��
        System.out.println("Snake Score1="+score+"  Snake Score2="+score2);
        System.out.println("Snake this.Name1 this.Name2"+this.Name1 + this.Name2);

        System.out.println("setup== true���һ��" +tools.getUser1()+"�÷�:"+tools.getScore1());
        System.out.println("setup== true��Ҷ���" +tools.getUser2()+"�÷�:"+tools.getScore2());

        isStarted = false;
        isFailed = false;
        len = 3;
        len2 = 3;
        score = 0;
        score2 = 0;
       // int Level = tools.getLevel();

        firstSnakex[0] = 600;firstSnakex[1] = 625; firstSnakex[2] = 650;
        firstSnakey[0] = 105;firstSnakey[1] = 105; firstSnakey[2] = 105;
        secondSnakex[0] =100;secondSnakex[1]=125;secondSnakex[2]=150;
        secondSnakey[0] =555;secondSnakey[1]=555;secondSnakey[2]=555;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        //ʵ�ּ�����Ӧ
        int KeyCode = e.getKeyCode();
        if (KeyCode == KeyEvent.VK_SPACE){ // �û��ո���ʵ/������ʾ��Ϣ
            if (isFailed){
               System.out.println("Keypressed Score1 "+score +"Score2 "+score2+"Name1 "+this.Name1+"Name2 "+this.Name2);
                try {
                    new update(this.Name1,this.Name2,this.score,this.score2);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                System.out.println("isFailed == true���һ��isFailed" +tools.getUser1()+"�÷�:"+tools.getScore1());
                System.out.println("isFailed == true��Ҷ���isFailed" +tools.getUser2()+"�÷�:"+tools.getScore2());


//                isStarted = false;  // ���Խ������з���setup��
//                isFailed = false;
                setup();
            }else
                isStarted = !isStarted;
        }
        else if (KeyCode ==  KeyEvent.VK_W)
            direction2 = "U";
        else if (KeyCode ==  KeyEvent.VK_S)
            direction2 = "D";
        else if (KeyCode ==  KeyEvent.VK_D )
            direction2 = "R";
        else if (KeyCode ==  KeyEvent.VK_A)
            direction2 = "L";
        //����direction���ڷ�������
        else if (KeyCode ==  KeyEvent.VK_UP )
            direction = "U";
        else if (KeyCode ==  KeyEvent.VK_DOWN )
            direction = "D";
        else if (KeyCode ==  KeyEvent.VK_RIGHT)
            direction = "R";
        else if (KeyCode ==  KeyEvent.VK_LEFT)
            direction = "L";


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 1. �ٶ���һ������
        timer.start();
     //   System.out.println("ActionPerformed LevelNumber"+LevelNumber);
      //  System.out.println("ActionPerformed a"+getLevelNumber);
        // 2. �ƶ�����
        if (isStarted && !isFailed){
            // �ƶ�����
            for (int i = len; i>0; i--){
                firstSnakex[i] = firstSnakex[i-1];
                firstSnakey[i] =  firstSnakey[i-1];
            }
            for (int i = len2; i>0; i--){
               secondSnakex[i] = secondSnakex[i-1];
                secondSnakey[i] =  secondSnakey[i-1];
            }
            // �ƶ�ͷ
            if (direction.equals("R")){
                firstSnakex[0] =  firstSnakex[0] + 25;
                if( firstSnakex[0] > 800)  firstSnakex[0] = 0;
            }else if (direction.equals("L")){
                firstSnakex[0] =  firstSnakex[0] - 25;
                if( firstSnakex[0] < 0)  firstSnakex[0] = 800;
            }else if (direction.equals("U")){
                firstSnakey[0] =  firstSnakey[0] - 25;
                if ( firstSnakey[0] < 55)  firstSnakey[0] = 605;
            }else if (direction.equals("D")){
                firstSnakey[0] =  firstSnakey[0] + 25;
                if ( firstSnakey[0] > 605)  firstSnakey[0] = 55;
            }
            if (direction2.equals("R")){
                secondSnakex[0] =  secondSnakex[0] + 25;
                if(secondSnakex[0] > 800)  secondSnakex[0] = 0;
            }else if (direction2.equals("L")){
               secondSnakex[0] =  secondSnakex[0] - 25;
                if( secondSnakex[0] < 0)  secondSnakex[0] = 800;
            }else if (direction2.equals("U")){
                secondSnakey[0] =  secondSnakey[0] - 25;
                if ( secondSnakey[0] < 55)  secondSnakey[0] = 605;
            }else if (direction2.equals("D")){
               secondSnakey[0] =  secondSnakey[0] + 25;
                if ( secondSnakey[0] > 605)  secondSnakey[0] = 55;
            }

            if ( firstSnakex[0] == foodx &&  firstSnakey[0] == foody ){  // ��ʳ��
                len ++;
                score ++;
                foodx = rand.nextInt(32)*25;
                foody = rand.nextInt(22)*25+55;

            }
            if ( firstSnakex[0] == foodx2 &&  firstSnakey[0] == foody2 ){  // ��ʳ��
                len ++;
                score ++;

                foodx2 = rand.nextInt(32)*25;
                foody2 = rand.nextInt(22)*25+55;
            }

            if ( secondSnakex[0] == foodx &&  secondSnakey[0] == foody){  // ��ʳ��
                len2 ++;
                score2 ++;
                foodx = rand.nextInt(32)*25;
                foody = rand.nextInt(22)*25+55;

            }
            if ( secondSnakex[0] == foodx2 &&  secondSnakey[0] == foody2){  // ��ʳ��
                len2 ++;
                score2 ++;
                foodx2 = rand.nextInt(32)*25;
                foody2 = rand.nextInt(22)*25+55;
            }

            for (int i = 1; i < len; i ++){  // �����ͷ�����Լ���������Ϸ����
//                if ( firstSnakex[0] ==  firstSnakex[i] &&  firstSnakey[0] ==  firstSnakey[i]){
//                    isFailed = true;
//                }
//                if ( secondSnakex[0] ==  secondSnakex[i] &&  secondSnakey[0] ==  secondSnakey[i]){
//                    isFailed = true;
//                }
                if ( secondSnakex[0] ==  firstSnakex[i] &&  secondSnakey[0] ==  firstSnakey[i]){
                    isFailed = true;
                }
                if(secondSnakex[0] == firstSnakex[0] && secondSnakey[0] ==firstSnakey[0]){
                    isFailed = true;
                }
                if ( firstSnakex[0] ==  secondSnakex[i] &&  firstSnakey[0] ==  secondSnakey[i]){
                    isFailed = true;
                }
            }

            for (int i = 1; i < len2; i ++){  // �����ͷ�����Լ���������Ϸ����
//                if ( firstSnakex[0] ==  firstSnakex[i] &&  firstSnakey[0] ==  firstSnakey[i]){
//                    isFailed = true;
//                }
//                if ( secondSnakex[0] ==  secondSnakex[i] &&  secondSnakey[0] ==  secondSnakey[i]){
//                    isFailed = true;
//                }
                if ( secondSnakex[0] ==  firstSnakex[i] &&  secondSnakey[0] ==  firstSnakey[i]){
                    isFailed = true;
                }
                if(secondSnakex[0] == firstSnakex[0] && secondSnakey[0] ==firstSnakey[0]){
                    isFailed = true;
                }
                if ( firstSnakex[0] ==  secondSnakex[i] &&  firstSnakey[0] ==  secondSnakey[i]){
                    isFailed = true;
                }
            }

        }


        // 3. repaint����
        repaint();

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}