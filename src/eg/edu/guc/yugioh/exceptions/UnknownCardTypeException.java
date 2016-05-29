package eg.edu.guc.yugioh.exceptions;

public class UnknownCardTypeException extends UnexpectedFormatException {
	private String unknownType;

	public String getUnknownType() {
		return unknownType;
	}

	public void setUnknownType(String unknownType) {
		this.unknownType = unknownType;
	}

	public UnknownCardTypeException(String sourceFile, int sourceLine,String unknownType) {
		super(sourceFile, sourceLine);
	    this.unknownType = unknownType;
	}

	public UnknownCardTypeException() {
		// TODO Auto-generated constructor stub
	}

	public UnknownCardTypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnknownCardTypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UnknownCardTypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnknownCardTypeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
@Override
public String getMessage() {
	// TODO Auto-generated method stub
	return "unkown card type exception";
}
}
