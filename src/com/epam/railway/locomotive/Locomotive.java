package com.epam.railway.locomotive;

import com.epam.railway.RailwayTransport;

public class Locomotive extends RailwayTransport {
    private TypeOfLocomotive typeOfLocomotive;
    private float loadCapacity;

    public Locomotive(float weight, float loadCapacity, boolean isPassenger) {
        super(weight, isPassenger);
        this.loadCapacity = loadCapacity;
    }

    public Locomotive(TypeOfLocomotive typeOfLocomotive, float weight, float loadCapacity, boolean isPassenger) {
        super(weight, isPassenger);
        this.typeOfLocomotive = typeOfLocomotive;
        this.loadCapacity = loadCapacity;
    }

    public float getLoadCapacity() {
        return loadCapacity;
    }

    public TypeOfLocomotive getTypeOfLocomotive() {
        return typeOfLocomotive;
    }

    public void setTypeOfLocomotive(TypeOfLocomotive typeOfLocomotive) {
        this.typeOfLocomotive = typeOfLocomotive;
    }
}
