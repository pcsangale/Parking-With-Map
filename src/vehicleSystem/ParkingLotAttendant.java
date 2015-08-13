package vehicleSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;



import sun.security.x509.AVA;
import vehicleSystemExceptions.ParkingLotsFullException;

public class ParkingLotAttendant {
	
	List<ParkingLot> parkingLots= new ArrayList<ParkingLot>();
	List<ParkingLot> availableParkingLots= new ArrayList<ParkingLot>();
	
	
	public  ParkingLotAttendant(List<ParkingLot> lots ) {
		this.parkingLots=lots;
		this.availableParkingLots=lots;
	}
	
	public ParkingLot maximumSpace(){
		ListIterator<ParkingLot> lots= parkingLots.listIterator();
		while(lots.hasNext()){
			double max;
			
			ParkingLot lot=lots.next();
			if(!lot.isParkingLotFull()){
				
			
			}
		}
		
	return null;	
	}
	public ParkingLot getParkingLot() throws ParkingLotsFullException{
		if(availableParkingLots.size()==0){
			throw new ParkingLotsFullException("All Parking lots are full");	
			}	
		else{
			return null;
		}
		
	}
}
	

