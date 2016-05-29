package eg.edu.guc.yugioh.exceptions;

public class MissingFieldException extends UnexpectedFormatException {

	public MissingFieldException(String sourceFile, int sourceLine) {
		super(sourceFile, sourceLine);
		
	}
	

	public MissingFieldException() {
		// TODO Auto-generated constructor stub
	}

	public MissingFieldException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MissingFieldException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MissingFieldException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MissingFieldException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
  @Override
public String getMessage() {
	// TODO Auto-generated method stub
	return "missing field";
}
}
