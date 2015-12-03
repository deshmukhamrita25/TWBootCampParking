package parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HP2 on 12/02/2015.
 */
public class Park {

    int capacity;
    private List<ParkingObservers> observersList = new ArrayList<ParkingObservers>();
    private List vehicleList = new ArrayList<>();
    private HashMap<Vehicle, Object> vehicleTokenList = new HashMap<>();

    Park(int capacity) {
        this.capacity = capacity;
    }

    public boolean park(Vehicle car) {
        if (isSlotAvailable() && !vehicleList.contains(car)) {
            vehicleTokenList.put(car, new Object());
            vehicleList.add(car);
            if (isParkingFull())
                notifyObserversParkingIsFull();
            return true;
        }
        return false;
    }

    public boolean isSlotAvailable() {
        return vehicleTokenList.size() < capacity;
    }


    public boolean unPark(Vehicle car) throws CarNotFoundException {
        if (vehicleTokenList.get(car) != null) {
            if(isParkingFull())
                notifyObserversSpaceIsAvailable();

            vehicleTokenList.remove(car);

            return true;
        } else
            throw new CarNotFoundException();

    }

    private void notifyObserversSpaceIsAvailable() {
        for(ParkingObservers observer: observersList)
            observer.spaceIsAvailable();
    }

    public boolean isParkingFull() {
        return vehicleTokenList.size() == capacity;
    }

    public int availableSpaceCount(){
        return capacity - vehicleTokenList.size();
    }

    public void notifyObserversParkingIsFull() {
        for(ParkingObservers observer: observersList)
            observer.parkingIsFull();
    }

    public void addChangeListener(ParkingObservers parkingObserver){
        observersList.add(parkingObserver);
    }

    public int getDistance() {
        return 0;
    }
}
