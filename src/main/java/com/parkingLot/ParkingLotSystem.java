package com.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    private final List vehicles;
    private Object vehicle;
    private int actualCapacity;
    private int currentCapacity;
    private ParkingLotOwner owner;

    public ParkingLotSystem(int capacity) {
        this.vehicles = new ArrayList();
        this.actualCapacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException {
        if (this.vehicles.size() == this.actualCapacity) {
            owner.capacityIsFull();
            throw new ParkingLotException("Parking Lot is Full");
        }
        if (isVehicleParked(vehicle)) {
            throw new ParkingLotException("Vehicle Already Parked");
        }
        this.vehicles.add(vehicle);
    }

    public boolean isVehicleParked(Object vehicle) {
        return this.vehicles.contains(vehicle);
    }

    public boolean unPark(Object vehicle) throws ParkingLotException {
        if (vehicle == null) return false;
        if (this.vehicles.contains(vehicle)) {
            this.vehicles.remove(vehicle);
            return true;
        }
        return false;
    }

    public boolean isUnParked() {
        return this.vehicle == null;
    }

    public boolean isParkingLotFull() {
        return this.vehicles.size() == this.actualCapacity;
    }

    public void registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }
}
