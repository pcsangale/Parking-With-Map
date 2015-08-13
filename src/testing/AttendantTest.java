package testing;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import vehicleSystem.Car;
import vehicleSystem.ParkingLot;
import vehicleSystem.ParkingLotAttendant;
import vehicleSystem.ParkingLotOwner;
import vehicleSystemExceptions.ParkingLotsFullException;

public class AttendantTest {


	@Test
	public void attendantShouldDirectsCar() throws ParkingLotsFullException{
		ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
		Car car_1 = new Car("MH-12","Prashant");
		List<ParkingLot> parkingLots= new LinkedList<ParkingLot>();
		ParkingLot parkingLot1= new ParkingLot(2, parkingLotOwner);
		
		parkingLots.add(parkingLot1);
		
		ParkingLotAttendant attendant= new ParkingLotAttendant(parkingLots);
		
		
		Assert.assertEquals(true, attendant.getParkingLot() instanceof ParkingLot);
		
	}
	
	@Test
	public void attendantShouldNotDirectsCar() throws ParkingLotsFullException{
		ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
		Car car_1 = new Car("MH-12","Prashant");
		List<ParkingLot> parkingLots= new LinkedList<ParkingLot>();
		ParkingLot parkingLot1= new ParkingLot(1, parkingLotOwner);
		
		parkingLots.add(parkingLot1);
		
		ParkingLotAttendant attendant= new ParkingLotAttendant(parkingLots);
		parkingLot1.park(car_1);
		
		Assert.assertEquals(false, attendant.getParkingLot() instanceof ParkingLot);
		
	}
	
	
}
