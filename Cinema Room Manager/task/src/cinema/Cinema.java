package cinema;

import java.util.Scanner;

public class Cinema {

    static Scanner sc = new Scanner(System.in);
    static int numberOfRows;
    static int numberOfColumns;
    final static int smallRoomSeatPrice = 10;
    final static int largeRoomFrontSeatPrice = 10;
    final static int largeRoomBackSeatPrice = 8;
    final static int smallUpperLimit = 60;
    final static int hundred = 100;

    public static void main(String[] args) {

        int option;


        System.out.print("Enter the number of rows:\n ");
        numberOfRows = sc.nextInt();
        System.out.print("Enter the number of seats in each row:\n ");
        numberOfColumns = sc.nextInt();
        String[][] theatre = new String[numberOfRows][numberOfColumns];
        fillTheatre(theatre);
        do {
            option = menu();
            switch (option) {
                case 1 : printTheatre(theatre); break;
                case 2 : buyTicket(theatre); break;
                case 3 : calcStatistics(theatre); break;
                case 0 : break;
                default: System.out.println("choose 0/1/2");
            }
        } while (!(option == 0));

        /*
        System.out.println("\nCinema:");
        printTheatre(theatre);

        System.out.print("\nEnter a row number:\n ");
        seatRow = sc.nextInt();
        System.out.print("Enter a seat number in that row:\n ");
        seatColumn = sc.nextInt();
        theatre[seatRow - 1][seatColumn - 1] = "B";
        System.out.println("\nTicket price: $" + calSeatPrice(seatRow, seatColumn));
        System.out.println();
        System.out.println("Cinema:");
        printTheatre(theatre);

         */

        //System.out.println("$" + calcRevenue());
    }

    static void calcStatistics(String[][] theatre) {
        int[] soldTicketAndIncome = countSoldTicket(theatre);
        int soldTicket = soldTicketAndIncome[0];
        int soldIncome = soldTicketAndIncome[1];
        double soldPercent = (double) soldTicket / (double) (numberOfRows * numberOfColumns) * hundred;
        int fullHouseIncome = calcRevenue();

        //current income, total income, the number of available seats, and the percentage of occupancy.
        System.out.print("Number of purchased tickets: ");
        System.out.println(soldTicket);
        System.out.print("Percentage: ");
        System.out.printf("%.2f%%\n", soldPercent);
        System.out.print("Current income: $");
        System.out.println(soldIncome);
        System.out.print("Total income: $");
        System.out.println(fullHouseIncome);
    }

    static int[] countSoldTicket(String[][] theatre) {
        int sold = 0;
        int soldIncome = 0;
        int[] soldTicketAndIncome = new int[2];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                sold += theatre[i][j].equals("B") ? 1 : 0;
                soldIncome += theatre[i][j].equals("B") ? calSeatPrice(i + 1) : 0;
            }
        }
        soldTicketAndIncome[0] = sold;
        soldTicketAndIncome[1] = soldIncome;
        return soldTicketAndIncome;
    }

/*
    static void buyTicket(String[][]  theatre) {

        int seatRow;
        int seatColumn;

        System.out.print("\nEnter a row number:\n ");
        seatRow = sc.nextInt();
        System.out.print("Enter a seat number in that row:\n ");
        seatColumn = sc.nextInt();
        if (!theatre[seatRow - 1][seatColumn - 1].equals("B")) {
            theatre[seatRow - 1][seatColumn - 1] = "B";
            System.out.println("Ticket price: $" + calSeatPrice(seatRow));
        } else {
            System.out.println("That ticket has already been purchased!");
        }
        //printTheatre(theatre);

    }

 */

    static void buyTicket(String[][]  theatre) {

        int seatRow;
        int seatColumn;

        do {
            System.out.print("\nEnter a row number:\n ");
            seatRow = sc.nextInt();
            System.out.print("Enter a seat number in that row:\n ");
            seatColumn = sc.nextInt();
                if (seatRow <= numberOfRows) {
                    if (seatColumn <= numberOfColumns) {
                        if (!theatre[seatRow - 1][seatColumn - 1].equals("B")) {
                            break;
                        } else {
                            System.out.println("\nThat ticket has already been purchased!");
                        }
                    } else {
                        System.out.println("\nWrong input!");
                    }
                } else {
                    System.out.println("\nWrong input!");
                }
        } while (true);

        theatre[seatRow - 1][seatColumn - 1] = "B";
        System.out.println("\nTicket price: $" + calSeatPrice(seatRow));
        //printTheatre(theatre);

    }


    static int menu() {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("enter 0/1/2");
                sc.nextLine();
            }
            return -1;
    }

    static int calSeatPrice(int row) {
        int numberOfSeats = numberOfRows * numberOfColumns;
        if (numberOfSeats <= smallUpperLimit) {
            return smallRoomSeatPrice;
        } else {
            if (row <= numberOfRows / 2) {
                return largeRoomFrontSeatPrice;
            } else {
                return largeRoomBackSeatPrice;
            }
        }
    }

    static int calcRevenue() {
        int numberOfSeats = numberOfRows * numberOfColumns;
        if (numberOfSeats <= smallUpperLimit) {
            return numberOfSeats * smallRoomSeatPrice;
        } else {
            return numberOfRows / 2 * numberOfColumns * largeRoomFrontSeatPrice +
                    (numberOfRows - numberOfRows / 2) * numberOfColumns * largeRoomBackSeatPrice;
        }
    }

    static void fillTheatre(String[][] theatre) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                theatre[i][j] = "S";
            }
        }
    }

    static void printTheatre(String[][] theatre) {

        System.out.println("\nCinema:");

        //seat numbers
        System.out.print("  ");
        for (int i = 1; i <= numberOfColumns; i++) {
            if (i == numberOfColumns) {
                System.out.println(i);
            } else {
                System.out.print(i + " ");
            }
        }

        //row numbers
        for (int i = 0; i < numberOfRows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < numberOfColumns; j++) {
                if (j == numberOfColumns - 1) {
                    System.out.print( theatre[i][j]) ;
                } else {
                    System.out.print(theatre[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

}

