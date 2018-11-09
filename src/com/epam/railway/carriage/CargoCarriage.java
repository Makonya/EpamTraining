package com.epam.railway.carriage;

import com.epam.railway.carriage.Carriage;

public class CargoCarriage extends Carriage {
    private TypeOfCargoCarriage typeOfCargoCarriage;

    public CargoCarriage(float weight) {
        this.setWeight(weight);
        this.setPassenger(false);
    }

    public CargoCarriage(TypeOfCargoCarriage typeOfCargoCarriage, float weight) {
        this.typeOfCargoCarriage = typeOfCargoCarriage;
        this.setWeight(weight);
        this.setPassenger(false);
    }

    public TypeOfCargoCarriage getTypeOfCargoCarriage() {
        return typeOfCargoCarriage;
    }

    public void setTypeOfCargoCarriage(TypeOfCargoCarriage typeOfCargoCarriage) {
        this.typeOfCargoCarriage = typeOfCargoCarriage;
    }
}
