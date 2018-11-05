package com.epam.railway.carriage.passenger.human;

public class CoupeCarriage extends HumanCarriage {
    public CoupeCarriage(float weight) {
        super(weight);
        this.setNumbersOfSeats(36);
    }

    public CoupeCarriage(float weight, int numbersOfSeats) {
        super(weight, numbersOfSeats);
    }
}
