package com.epam.railway;

import com.epam.railway.carriage.cargo.CisternCarriage;
import com.epam.railway.carriage.cargo.CoveredCarriage;
import com.epam.railway.carriage.passenger.human.CoupeCarriage;
import com.epam.railway.carriage.passenger.human.EconomClassCarriage;
import com.epam.railway.carriage.passenger.special.MailCarriage;
import com.epam.railway.locomotive.ElectricLocomotive;
import com.epam.railway.train.Train;

public class TrainFormation {

    public void generatePassengerTrain() {
        System.out.println("Process of formation passenger train!");
        Train myPassengerTrain = new Train();
        myPassengerTrain.addLocomotive(new ElectricLocomotive(2.76f, 401f, true));
        for (int i = 0; i < 29; i++) {
            myPassengerTrain.addCarriage(new EconomClassCarriage(6f));
        }
        for (int i = 0; i < 4; i++) {
            myPassengerTrain.addCarriage(new MailCarriage(12f));
        }

        // Tries to add not passenger carriage
        myPassengerTrain.addCarriage(new CoveredCarriage(24f));

        // Tries to add not passenger locomotive
        myPassengerTrain.addLocomotive(new ElectricLocomotive(2.76f, 401f, false));

        System.out.println("Count of carriage in passenger train: " + myPassengerTrain.countCarriages());
    }

    public void generateCargoTrain() {
        System.out.println("Process of formation cargo train!");

        Train myCargoTrain = new Train();
        myCargoTrain.addLocomotive(new ElectricLocomotive(2.76f, 401f, false));
        for (int i = 0; i < 10; i++) {
            myCargoTrain.addCarriage(new CoveredCarriage(24f));
        }
        for (int i = 0; i < 10; i++) {
            myCargoTrain.addCarriage(new CisternCarriage(26f));
        }

        System.out.println("Count of carriage in cargo train: " + myCargoTrain.countCarriages());

        // Tries to add passenger carriage
        myCargoTrain.addCarriage(new CoupeCarriage(4f));
        myCargoTrain.addLocomotive(new ElectricLocomotive(2.76f, 401f, false));
        for (int i = 0; i < 10; i++) {
            myCargoTrain.addCarriage(new CisternCarriage(26f));
        }

        System.out.println("Count of carriage in cargo train: " + myCargoTrain.countCarriages());
    }

    public static void main(String[] args) {
        TrainFormation trainFormation = new TrainFormation();
        trainFormation.generatePassengerTrain();
        trainFormation.generateCargoTrain();
    }
}
