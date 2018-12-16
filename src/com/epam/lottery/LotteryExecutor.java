package com.epam.lottery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class LotteryExecutor {
    private static List<Ticket> winnerTickets = new ArrayList<>();

    public static void takeNumber(){
        int index = new Random().nextInt(TicketNumber.getAllNumbers().size());

        if(!TicketNumber.getAllNumbers().get(index).isUsed()){
            TicketNumber.getAllNumbers().get(index).setUsed(true);
            System.out.println(TicketNumber.getAllNumbers().get(index));
        }
    }

    public static boolean checkWinner(){
        for (Ticket ticket : Ticket.getAllTickets()) {
            boolean hasWinner = true;
            for (TicketNumber ticketNumber : ticket.getNumbers()) {
                if(!ticketNumber.isUsed()){
                    hasWinner = false;
                }
            }
            if(hasWinner){
                winnerTickets.add(ticket);
            }
        }
        return winnerTickets.isEmpty();
    }

    public static List<Ticket> getWinnerTickets() {
        return winnerTickets;
    }
    public static void printWinnerTickets() {
        System.out.println("Winner tickets:");
        for (Ticket winnerTicket : getWinnerTickets()) {
            System.out.println(winnerTicket);
        }
    }
}
