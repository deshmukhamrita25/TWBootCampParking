package parking;

import java.util.List;

/**
 * Created by HP2 on 12/03/2015.
 */
public class ParkingAttendant {
    List<Park> parkingLotList;

    public ParkingAttendant(List<Park> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Park selectParkingLotAndPark() {
        Park selectedParkingLot = new Park(0);
        for(Park park:parkingLotList){

            if(!park.isParkingFull() &&
                    selectedParkingLot.availableSpaceCount() < park.availableSpaceCount())
                selectedParkingLot = park;
        }


        return selectedParkingLot;
    }


    public Park selectNearestParkingLotAndPark() {
        Park selectedParkingLot = parkingLotList.get(0);
        for(Park park:parkingLotList){
            if(selectedParkingLot.getDistance() > park.getDistance() && !park.isParkingFull())
                selectedParkingLot = park;
        }


        return selectedParkingLot;
    }
}
