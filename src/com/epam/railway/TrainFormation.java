package com.epam.railway;

import com.epam.railway.carriage.CargoCarriage;
import com.epam.railway.carriage.PassengerCarriage;
import com.epam.railway.carriage.TypeOfCargoCarriage;
import com.epam.railway.carriage.TypeOfPassengerCarriage;
import com.epam.railway.locomotive.Locomotive;
import com.epam.railway.locomotive.TypeOfLocomotive;
import com.epam.railway.train.Train;

import java.util.Scanner;

public class TrainFormation {

    private void generatePassengerTrain() {
        System.out.println("Process of formation passenger train!");
        Train myPassengerTrain = new Train();
        boolean isPassenger = true;
        myPassengerTrain.setLocomotive(new Locomotive( 2.76f, 401f, isPassenger));
        myPassengerTrain.getLocomotive().setTypeOfLocomotive(TypeOfLocomotive.ELECTRIC_LOCOMOTIVE);
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many passenger carriages do you want to add?");
        int countOfPassCarriages = scanner.nextInt();
        for (int i = 0; i < countOfPassCarriages; i++) {
            myPassengerTrain.addCarriage(new PassengerCarriage(6f));
        }
        System.out.println("How many mail carriages do you want to add?");
        int countOfMailCarriages = scanner.nextInt();
        for (int i = 0; i < countOfMailCarriages; i++) {
            myPassengerTrain.addCarriage(new PassengerCarriage(TypeOfPassengerCarriage.MAIL_CARRIAGE, 12f));
        }

        // Tries to add not passenger carriage
        System.out.println("Process of adding cargo carriage to passenger train:");
        myPassengerTrain.addCarriage(new CargoCarriage(TypeOfCargoCarriage.OPEN_CARRIAGE,24f));

        System.out.println("Count of carriage in passenger train: " + myPassengerTrain.countCarriages());
    }

    private void generateCargoTrain() {
        System.out.println("Process of formation cargo train!");
        boolean isPassenger = false;
        Train myCargoTrain = new Train(new Locomotive(2.76f, 401f, isPassenger));
        myCargoTrain.getLocomotive().setTypeOfLocomotive(TypeOfLocomotive.ELECTRIC_LOCOMOTIVE);
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many cargo carriages do you want to add?");
        int countOfCargoCarriages = scanner.nextInt();
        for (int i = 0; i < countOfCargoCarriages; i++) {
            myCargoTrain.addCarriage(new CargoCarriage(24f));
        }

        // Tries to add passenger carriage
        System.out.println("Process of adding passenger carriage to cargo train:");
        myCargoTrain.addCarriage(new PassengerCarriage(4f));

        System.out.println("Count of carriage in cargo train: " + myCargoTrain.countCarriages());
    }

    public static void main(String[] args) {
        TrainFormation trainFormation = new TrainFormation();
        trainFormation.generatePassengerTrain();
        System.out.println();
        trainFormation.generateCargoTrain();
    }
}
