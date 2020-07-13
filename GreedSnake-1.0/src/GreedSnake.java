
public class GreedSnake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeModel model=new SnakeModel(20,30);
		SnakeControl control=new SnakeControl(model);
		SnakeView view=new SnakeView(model,control);
    	model.addObserver(view);
    	(new Thread(model)).start();
    	
	}

}
