package com.epam.railway.carriage.passenger;

import com.epam.railway.carriage.Carriage;

public abstract class PassengerPark extends Carriage {
    public PassengerPark(float weight) {
        this.setWeight(weight);
        this.setPassenger(true);
    }
}
