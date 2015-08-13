package vehicleSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Notification;

import vehicleSystemExceptions.CarNotParkedException;
import vehicleSystemExceptions.CarNotUnparkedException;

public class ParkingLot {
	private final int parkingLotSize;
	private Map<Token, Car> parkedCars = new HashMap<Token, Car>();
	private ParkingLotOwner owner;
	private Map<NotificationType, List<Subscriber>> notifications = new HashMap<NotificationType, List<Subscriber>>();

	public ParkingLot(int parkingLotSize, ParkingLotOwner owner) {
		super();
		this.parkingLotSize = parkingLotSize;
		this.owner = owner;

		Subscribe(NotificationType.PARKINGLOTFULL, owner);
		Subscribe(NotificationType.PARKINGLOTVACANT, owner);
	}

	public Token park(Car car) {

		boolean isNotParked = !parkedCars.containsValue(car);
		if (!isParkingLotFull() && isNotParked) {
			Token token = new Token();
			parkedCars.put(token, car);

			if (parkedCars.size() == parkingLotSize)
				notifyToSubscribers(NotificationType.PARKINGLOTFULL);

			if (parkedCars.size() == (int) ((parkingLotSize * 8) / 10))
				notifyToSubscribers(NotificationType.PARKINGLOT80PERCENTfull);

			return token;
		} else
			throw new CarNotParkedException("Car Not Parked.");
	}

	public Car unPark(Token token) {
		if (parkedCars.containsKey(token)) {
			Car car = parkedCars.get(token);
			parkedCars.remove(token);

			if (parkedCars.size() == parkingLotSize - 1)
				notifyToSubscribers(NotificationType.PARKINGLOTVACANT);
			return car;
		} else
			throw new CarNotUnparkedException("Car Not In Parking Lot.");
	}

	public boolean isParkingLotFull() {
		return parkedCars.size() >= parkingLotSize;

	}

	public void Subscribe(NotificationType subscriberType, Subscriber subscriber) {
		if (notifications.containsKey(subscriberType))
			notifications.get(subscriberType).add(subscriber);
		else {
			notifications.put(subscriberType, new ArrayList<Subscriber>());
			notifications.get(subscriberType).add(subscriber);
		}
	}

	public void notifyToSubscribers(NotificationType subscriberType) {
		if (notifications.containsKey(subscriberType)) {
			List<Subscriber> subscriberList = notifications.get(subscriberType);
			for (Subscriber subscriber : subscriberList) {
				subscriber.notification(subscriberType);
			}
		}
	}
}