package com.epam.railway.carriage.passenger.human;

import com.epam.railway.carriage.passenger.PassengerPark;

public abstract class HumanCarriage extends PassengerPark {
    private int numbersOfSeats;

    public HumanCarriage(float weight) {
        super(weight);
    }

    public HumanCarriage(float weight, int numbersOfSeats) {
        super(weight);
        this.numbersOfSeats = numbersOfSeats;
    }

    public int getNumbersOfSeats() {
        return numbersOfSeats;
    }

    public void setNumbersOfSeats(int numbersOfSeats) {
        this.numbersOfSeats = numbersOfSeats;
    }
}
