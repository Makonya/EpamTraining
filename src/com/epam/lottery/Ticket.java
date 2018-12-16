package com.epam.lottery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ticket {
    private static int counter = 0;
    private int id = ++counter;
    private List<TicketNumber> numbers = new ArrayList<>();
    private static List<Ticket> allTickets = new ArrayList<>();

    public static void init(int totalTicket, int countOfNumber) {
        for (int i = 0; i < totalTicket; i++) {
            Ticket ticket = new Ticket();
            ticket.fillTicket(countOfNumber);
            allTickets.add(ticket);
//            System.out.println(ticket);
        }
    }

    public void fillTicket(int countOfNumber) {
        for (int i = 0; i < countOfNumber; i++) {
            numbers.add(randomNumber());
        }
    }

    private static TicketNumber randomNumber() {
        int index = new Random().nextInt(TicketNumber.getAllNumbers().size());
        Iterator<TicketNumber> iter = TicketNumber.getAllNumbers().iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next();
    }

    public int getId() {
        return id;
    }

    public List<TicketNumber> getNumbers() {
        return numbers;
    }

    public static List<Ticket> getAllTickets() {
        return allTickets;
    }

    public static void printAllTickets() {
        System.out.println("Tickets:");
        getAllTickets().forEach(x -> {
            System.out.println(x);
        });
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", numbers=" + numbers +
                '}';
    }
}
