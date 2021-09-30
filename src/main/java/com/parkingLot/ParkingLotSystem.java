package com.parkingLot;

public class ParkingLotSystem {

    private Object vehicle;

    public void park(Object vehicle) throws ParkingLotException {
        if (this.vehicle == null) {
            this.vehicle = vehicle;
            throw new ParkingLotException("Parking Lot is full");
        }
    }

    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public boolean unPark(Object vehicle) {
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }


}
