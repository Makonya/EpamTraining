package com.epam.lottery;

import java.util.Scanner;

public class Main {
    public static final int MIN_NUMBERS_IN_LOTTERY = 25;
    private static int totalCountOfTicket = 10;
    private static int countOfNumberInTicket = 5;
    private static int totalNumberInLottery = 25;

    public static void main(String[] args) {
       setUsersValues();
        TicketNumber.init(totalNumberInLottery);
        Ticket.init(totalCountOfTicket, countOfNumberInTicket);
        Ticket.printAllTickets();
        while (LotteryExecutor.checkWinner()) {
            LotteryExecutor.takeNumber();
        }
        LotteryExecutor.printWinnerTickets();
    }

    public static int getTotalCountOfTicket() {
        return totalCountOfTicket;
    }

    public static void setTotalCountOfTicket(int totalCountOfTicket) {
        Main.totalCountOfTicket = totalCountOfTicket;
    }

    public static int getCountOfNumberInTicket() {
        return countOfNumberInTicket;
    }

    public static void setCountOfNumberInTicket(int countOfNumberInTicket) {
        Main.countOfNumberInTicket = countOfNumberInTicket;
    }

    public static int getTotalNumberInLottery() {
        return totalNumberInLottery;
    }

    public static void setTotalNumberInLottery(int totalNumberInLottery) {
        Main.totalNumberInLottery = totalNumberInLottery;
    }

    public  static  void setUsersValues(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total count of numbers in the lottery:");
        int textIn = Integer.parseInt(scanner.nextLine());
        if (textIn >= MIN_NUMBERS_IN_LOTTERY) {
            setTotalNumberInLottery(textIn);
        } else {
            System.out.println("Your number is not valid (<25)! Default number will be used " + getTotalNumberInLottery());
        }
        System.out.println("Enter total count of tickets:");
        textIn = Integer.parseInt(scanner.nextLine());
        if (textIn > 0) {
            setTotalCountOfTicket(textIn);
        }else {
            System.out.println("Your number is not valid (<0)! Default number will be used " + getTotalCountOfTicket());
        }
        System.out.println("Enter count of numbers in ticket:");
        textIn = Integer.parseInt(scanner.nextLine());
        if (textIn < getTotalNumberInLottery() && textIn > 1) {
            setCountOfNumberInTicket(textIn);
        }else {
            System.out.println("Your number is not valid (<1 and >total count of numbers in the lottery)! Default number will be used " + getCountOfNumberInTicket());
        }
    }
}
