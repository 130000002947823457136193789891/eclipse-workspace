package cn.edu.csuft.function;

public class DatabaseLogFactory implements LogFactory {

	@Override
	public Log createLog() {
		return new DatabaseLog();
	}

}
