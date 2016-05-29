package eg.edu.guc.yugioh.exceptions;

public class UnexpectedFormatException extends Exception {
	private String sourceFile;
	private int sourceLine;
	
	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}

	public int getSourceLine() {
		return sourceLine;
	}

	public void setSourceLine(int sourceLine) {
		this.sourceLine = sourceLine;
	}

	
	
	public UnexpectedFormatException(String sourceFile, int sourceLine){
		super("unexpected format");
		this.sourceFile = sourceFile;
		this.sourceLine = sourceLine;
	}

	public UnexpectedFormatException() {
		// TODO Auto-generated constructor stub
	}

	public UnexpectedFormatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnexpectedFormatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UnexpectedFormatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnexpectedFormatException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
