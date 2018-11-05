package com.epam.railway.carriage.passenger.human;

public class SittingCarriage extends HumanCarriage {
    public SittingCarriage(float weight) {
        super(weight);
        this.setNumbersOfSeats(81);
    }

    public SittingCarriage(float weight, int numbersOfSeats) {
        super(weight, numbersOfSeats);
    }
}
