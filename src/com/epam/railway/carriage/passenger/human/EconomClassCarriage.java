package com.epam.railway.carriage.passenger.human;

public class EconomClassCarriage extends HumanCarriage {
    public EconomClassCarriage(float weight) {
        super(weight);
        this.setNumbersOfSeats(54);
    }

    public EconomClassCarriage(float weight, int numbersOfSeats) {
        super(weight, numbersOfSeats);
    }
}
