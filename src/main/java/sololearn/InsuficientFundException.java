package sololearn;

public class InsuficientFundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InsuficientFundException() {
		
	}
	
	public InsuficientFundException(String descripition) {
		super(descripition);
	}
}
