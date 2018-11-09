package com.epam.railway.carriage;

public class PassengerCarriage extends Carriage {
    private TypeOfPassengerCarriage typeOfPassengerCarriage;
    private int maxCountOfPassengers;

    public PassengerCarriage(float weight) {
        this.setWeight(weight);
        this.setPassenger(true);
    }

    public PassengerCarriage(TypeOfPassengerCarriage typeOfPassengerCarriage, float weight) {
        this.typeOfPassengerCarriage = typeOfPassengerCarriage;
        this.setWeight(weight);
        this.setPassenger(true);
        setMaxCountOfPassengers();
    }

    public TypeOfPassengerCarriage getTypeOfPassengerCarriage() {
        return typeOfPassengerCarriage;
    }

    public void setTypeOfPassengerCarriage(TypeOfPassengerCarriage typeOfPassengerCarriage) {
        this.typeOfPassengerCarriage = typeOfPassengerCarriage;
        setMaxCountOfPassengers();
    }

    public void setMaxCountOfPassengers(int maxCountOfPassengers) {
        this.maxCountOfPassengers = maxCountOfPassengers;
    }

    public int getMaxCountOfPassengers() {
        return maxCountOfPassengers;
    }

    private void setMaxCountOfPassengers() {
        switch (this.typeOfPassengerCarriage) {
            case SITTING_CARRIAGE:
                this.maxCountOfPassengers = 81;
                break;
            case ECONOM_CLASS_CARRIAGE:
                this.maxCountOfPassengers = 54;
                break;
            case COUPE_CARRIAGE:
                this.maxCountOfPassengers = 36;
                break;
            default:
                this.maxCountOfPassengers = 0;
                break;
        }
    }
}
