package com.epam.railway.carriage.cargo;

import com.epam.railway.carriage.Carriage;

public abstract class CargoPark extends Carriage {
    private String typeOfCargo;

    public CargoPark(float weight) {
        this.setWeight(weight);
        this.setPassenger(false);
    }

    public String getTypeOfCargo() {
        return typeOfCargo;
    }

    public void setTypeOfCargo(String typeOfCargo) {
        this.typeOfCargo = typeOfCargo;
    }
}
