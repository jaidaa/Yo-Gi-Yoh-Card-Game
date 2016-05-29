package eg.edu.guc.yugioh.exceptions;

public class EmptyFieldException extends UnexpectedFormatException {
	private int sourceField = 1;

	public int getSourceField() {
		return sourceField;
	}

	public void setSourceField(int sourceField) {
		this.sourceField = sourceField;
	}

	public EmptyFieldException(String sourceFile, int sourceLine, int sourceField) {
		super(sourceFile, sourceLine);
		this.sourceField = sourceField;
		
	}

	public EmptyFieldException() {
		// TODO Auto-generated constructor stub
	}

	public EmptyFieldException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmptyFieldException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public EmptyFieldException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmptyFieldException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
     @Override
    public String getMessage() {
    	// TODO Auto-generated method stub
    	return "emty field exception";
    }
}
