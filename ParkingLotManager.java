package parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP2 on 12/02/2015.
 */
public class ParkingLotManager implements ParkingObservers{

    List<Park> parkingLotList = new ArrayList<>();
    ParkingAttendant parkingAttendant;

    boolean isParkingFull = false;

    ParkingLotManager(Park park){
        parkingLotList.add(park);
        park.addChangeListener(this);
    }

    public Park directParkingToAttendant(){
        parkingAttendant = new ParkingAttendant(parkingLotList);
        return parkingAttendant.selectParkingLotAndPark();
    }

    public Park directParkingToAttendantToNearest(){
        parkingAttendant = new ParkingAttendant(parkingLotList);
        return parkingAttendant.selectNearestParkingLotAndPark();
    }

    public void addParkingLot(Park park){
        parkingLotList.add(park);
    }

    public void parkingIsFull() {
        isParkingFull = true;
    }

    public void spaceIsAvailable() {
        isParkingFull = false;
    }


}
