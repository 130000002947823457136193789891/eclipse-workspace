import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeControl implements KeyListener{
	SnakeModel model;
	public SnakeControl(SnakeModel model)
	{
		this.model=model;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode=e.getKeyCode();
		if(model.running)  //当运行时，则处理按键
		{
			switch(keyCode)
			{
			case KeyEvent.VK_LEFT:
				model.changeDirection(model.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				model.changeDirection(SnakeModel.RIGHT);
				break;
			case KeyEvent.VK_UP:
				model.changeDirection(SnakeModel.UP);
				break;
			case KeyEvent.VK_DOWN:
				model.changeDirection(SnakeModel.DOWN);
				break;
			case KeyEvent.VK_ADD:
			case KeyEvent.VK_PAGE_UP:
				model.speedUp();
				break;
			case KeyEvent.VK_SUBTRACT:
			case KeyEvent.VK_PAGE_DOWN:
				model.speedDown();
				break;
			case KeyEvent.VK_P:
			case KeyEvent.VK_SPACE:
				model.changePauseState();
				break;
			default:
				
			}
		}
		
		//任何情况下处理的按键将导致游戏重启
		if(keyCode==KeyEvent.VK_R ||
				keyCode==KeyEvent.VK_S ||
				keyCode==KeyEvent.VK_ENTER)
		{
			model.reset();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
