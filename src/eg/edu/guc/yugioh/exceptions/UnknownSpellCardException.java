package eg.edu.guc.yugioh.exceptions;

public class UnknownSpellCardException extends UnexpectedFormatException {
	private String unknownSpell;

	public String getUnknownSpell() {
		return unknownSpell;
	}

	public void setUnknownSpell(String unknownSpell) {
		this.unknownSpell = unknownSpell;
	}

	public UnknownSpellCardException(String sourceFile, int sourceLine, String unknownSpell) {
		super(sourceFile, sourceLine);
		this.unknownSpell = unknownSpell;
		
	}

	public UnknownSpellCardException() {
		// TODO Auto-generated constructor stub
	}

	public UnknownSpellCardException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnknownSpellCardException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UnknownSpellCardException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnknownSpellCardException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
@Override
public String getMessage() {
	// TODO Auto-generated method stub
	return "unkown spell card";
}
}
