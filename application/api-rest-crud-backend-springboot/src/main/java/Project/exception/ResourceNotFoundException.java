package Project.exception;

public class ResourceNotFoundException extends Exception {

	private String message;
	
	public ResourceNotFoundException(String message) {
	
		super(message);
	}
}
