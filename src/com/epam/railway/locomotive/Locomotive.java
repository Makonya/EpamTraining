package com.epam.railway.locomotive;

import com.epam.railway.RailwayTransport;

public abstract class Locomotive extends RailwayTransport {
    private float loadCapacity;

    public Locomotive(float weight, float loadCapacity, boolean isPassenger) {
        super(weight, isPassenger);
        this.loadCapacity = loadCapacity;
    }

    public float getLoadCapacity() {
        return loadCapacity;
    }
}
