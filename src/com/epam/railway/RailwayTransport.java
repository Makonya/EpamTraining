package com.epam.railway;

public abstract class RailwayTransport extends Transport {
    private boolean isPassenger;

    public RailwayTransport() {
    }

    public RailwayTransport(float weight, boolean isPassenger) {
        this.setWeight(weight);
        this.setPassenger(isPassenger);
    }

    public boolean isPassenger() {
        return isPassenger;
    }

    public void setPassenger(boolean passenger) {
        isPassenger = passenger;
    }
}
