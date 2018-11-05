package com.epam.railway.train;

import com.epam.railway.RailwayTransport;
import com.epam.railway.Transport;
import com.epam.railway.carriage.Carriage;
import com.epam.railway.locomotive.Locomotive;

import java.util.ArrayList;
import java.util.List;

public class Train extends RailwayTransport {
    private List<Locomotive> locomotives = new ArrayList<>();
    private List<Carriage> carriages = new ArrayList<>();
    private float maxWeightCapacity;
    private int maxCarriageCount;

    public Train() {
    }

    public Train(Locomotive locomotive) {
        addLocomotive(locomotive);
    }

    public void addLocomotive(Locomotive locomotive) {
        if (locomotives.isEmpty()) {
            this.setPassenger(locomotive.isPassenger());
            locomotives.add(locomotive);
            maxWeightCapacity = locomotive.getLoadCapacity();
            decreaseMaxWeightCapacity(locomotive);
        } else if (this.isPassenger() == locomotive.isPassenger()) {
            locomotives.add(locomotive);
            maxWeightCapacity += locomotive.getLoadCapacity();
            decreaseMaxWeightCapacity(locomotive);
        } else {
            System.out.println("You can not add this type of locomotive!");
        }
    }

    public void addCarriage(Carriage carriage) {
        if (maxWeightCapacity - carriage.getWeight() >= 0 && this.isPassenger() == carriage.isPassenger()) {
            if (carriages.isEmpty()) {
                if (carriage.isPassenger()) {
                    maxCarriageCount = 31;
                    addCarriageToArray(carriage);
                } else {
                    addCarriageToArray(carriage);
                }
            } else {
                if (carriage.isPassenger() && maxCarriageCount > 0) {
                    addCarriageToArray(carriage);
                    maxCarriageCount--;
                } else if (!carriage.isPassenger()) {
                    addCarriageToArray(carriage);
                } else {
                    System.out.println("Limit of passenger carriages is reached!");
                }
            }
        } else if (this.isPassenger() != carriage.isPassenger()) {
            System.out.println("You can not add carriage. Type of carriage is invalid");
        } else {
            System.out.println("You can not add carriage. Limit is reached");
        }

    }

    private void addCarriageToArray(Carriage carriage) {
        carriages.add(carriage);
        decreaseMaxWeightCapacity(carriage);
    }

    private void decreaseMaxWeightCapacity(Transport transport) {
        maxWeightCapacity -= transport.getWeight();
    }

    public int countCarriages(){
        return carriages.size();
    }
}
