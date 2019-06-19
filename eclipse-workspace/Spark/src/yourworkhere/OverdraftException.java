package yourworkhere;

public class OverdraftException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	@Override
    public String getMessage() {
        return "Amount withdrawn is greater than the amount present in the account.";
    }
	

}
