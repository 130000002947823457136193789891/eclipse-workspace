import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingCanvasFrame extends JFrame {
	private PaintLineCanvas canvas;
	public SwingCanvasFrame() {
		this.setBounds(100, 100, 400, 400);
		canvas = new PaintLineCanvas();
		this.add(canvas);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new SwingCanvasFrame();
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	private class PaintLineCanvas extends JPanel{
		private int startX,startY;
		private int endX,endY;
		public PaintLineCanvas() {
			this.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					endX=e.getX();
					endY=e.getY();
					repaint();
					startX=e.getX();
					startY=e.getY();
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
			g.drawLine(startX, startY, endX, endY);
		}
	}

}
