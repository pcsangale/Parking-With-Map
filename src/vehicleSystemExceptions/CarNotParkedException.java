package vehicleSystemExceptions;

public class CarNotParkedException extends RuntimeException{
	public CarNotParkedException(String message) {
		super(message);
	}
}
