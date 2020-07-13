package cn.edu.csuft.function;

public class FileLogFactory implements LogFactory {

	@Override
	public Log createLog() {
		return new FileLog();
	}

}
