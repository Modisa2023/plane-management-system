import java.util.Scanner;

public class w2052916_PlaneManagement {
    // Define four arrays to represent seats in each row.
    public static int[] A = new int[14];
    public static int[] B = new int[12];
    public static int[] C = new int[12];
    public static int[] D = new int[14];
    // Define an array to store ticket information.
    public static Ticket[] tickets = new Ticket[52];

    public static String[] row = {"A", "B", "C", "D"};
    static int seat;
    static String seat_row;

    // Main method
    public static void main(String[] args) {

        while (true) {

            int option_number;
            boolean is_valid = false;

            System.out.println();
            System.out.println("Welcome to Plane Management application");
            System.out.println();
            // Displaying menu options.
            String menu = """
                    **************************************************
                    *                  Menu Options                  *
                    **************************************************
                                    
                        1) Buy a seat
                        2) Cancel a seat
                        3) Find first available seat
                        4) Show seating plan
                        5) Print ticket information and total sales
                        6) Search ticket
                        0) Quit
                        
                    **************************************************""";

            System.out.println(menu);
            // Validate loop for user input option.
            while (!is_valid) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Please select an option: ");
                    option_number = scanner.nextInt();

                    switch (option_number) {
                        case 0:
                            System.out.println("Thank you. Have a good day!");
                            System.exit(0);
                            is_valid = true;
                        case 1:
                            System.out.println("***** Fill below details to buy a seat *****");
                            buy_seat();
                            is_valid = true;
                            break;
                        case 2:
                            System.out.println("***** Fill below details to cancel a seat *****");
                            cancel_seat();
                            is_valid = true;
                            break;
                        case 3:
                            find_first_available();
                            is_valid = true;
                            break;
                        case 4:
                            System.out.println("\n***** Seating Plan *****");
                            show_seating_plan();
                            is_valid = true;
                            break;
                        case 5:
                            print_tickets_info();
                            is_valid = true;
                            break;
                        case 6:
                            search_ticket();
                            is_valid = true;
                            break;
                        default:
                            System.out.println("Please enter a valid option.");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid option.");
                }
            }
        }
    }

    // Method to buy a seat.
    public static void buy_seat() {
        validateRow();
        validateSeat();
        //  Depending on the selected row, check the seat availability and book if the seat is available.
        switch (seat_row) {
            case "A":
                if (A[seat - 1] == 0) {
                    A[seat - 1] = 1;
                    System.out.println("\n****** Personal details ******");
                    getUserDetails();
                } else {
                    System.out.println("Entered seat is not available.");
                }
                break;
            case "B":
                if (B[seat - 1] == 0) {
                    B[seat - 1] = 1;
                    System.out.println("\n****** Personal details ******");
                    getUserDetails();
                } else {
                    System.out.println("Entered seat is not available.");
                }
                break;
            case "C":
                if (C[seat - 1] == 0) {
                    C[seat - 1] = 1;
                    System.out.println("\n****** Personal details ******");
                    getUserDetails();
                } else {
                    System.out.println("Entered seat is not available.");
                }
                break;
            case "D":
                if (D[seat - 1] == 0) {
                    D[seat - 1] = 1;
                    System.out.println("\n****** Personal details ******");
                    getUserDetails();
                } else {
                    System.out.println("Entered seat is not available.");
                }
                break;
            default:
                System.out.println("Entered seat number is not valid.");
        }

    }

    // Method to cancel seat
    public static void cancel_seat() {
        validateRow();
        validateSeat();
        // Depending on the selected row, check the availability of the seat and cancel if seat is booked.
        switch (seat_row) {
            case "A":
                if (A[seat - 1] == 1) {
                    A[seat - 1] = 0;
                    System.out.println();
                    cancelTicket();
                    System.out.println("Seat " + seat_row + seat + " has been cancelled successfully.");
                } else {
                    System.out.println("Entered seat is available.");
                }
                break;
            case "B":
                if (B[seat - 1] == 1) {
                    B[seat - 1] = 0;
                    System.out.println();
                    System.out.println("Seat " + seat_row + seat + " has been cancelled successfully.");
                    cancelTicket();
                } else {
                    System.out.println("Entered seat is available.");
                }
                break;
            case "C":
                if (C[seat - 1] == 1) {
                    C[seat - 1] = 0;
                    System.out.println();
                    System.out.println("Seat " + seat_row + seat + " has been cancelled successfully.");
                    cancelTicket();
                } else {
                    System.out.println("Entered seat is available.");
                }
                break;
            case "D":
                if (D[seat - 1] == 1) {
                    D[seat - 1] = 0;
                    System.out.println();
                    System.out.println("Seat " + seat_row + seat + " has been cancelled successfully.");
                    cancelTicket();
                } else {
                    System.out.println("Entered seat is available.");
                }
                break;
            default:
                System.out.println("Seat number is not valid.");
        }
    }

    // Method to find first available seat.
    public static void find_first_available() {
        boolean found_first = false;
        // Variables to store the row number and seat number of the first available seat.
        int rowNumber = 0;
        int seatNumber = 0;
        // Iterate through each row and seat to find the first available seat.
        for (int i = 0; i < row.length; i++) {
            switch (row[i]) {
                case "A":
                    for (int j = 0; j < A.length; j++) {
                        if (A[j] == 0) {
                            rowNumber = i;
                            seatNumber = j + 1;
                            found_first = true;
                            break;
                        }
                    }
                    break;
                case "B":
                    for (int j = 0; j < B.length; j++) {
                        if (B[j] == 0) {
                            rowNumber = i;
                            seatNumber = j + 1;
                            found_first = true;
                            break;
                        }
                    }
                    break;
                case "C":
                    for (int j = 0; j < C.length; j++) {
                        if (C[j] == 0) {
                            rowNumber = i;
                            seatNumber = j + 1;
                            found_first = true;
                            break;
                        }
                    }
                    break;
                case "D":
                    for (int j = 0; j < D.length; j++) {
                        if (D[j] == 0) {
                            rowNumber = i;
                            seatNumber = j + 1;
                            found_first = true;
                            break;
                        }
                    }
                    break;
            }
            if (found_first) {
                break;
            }
        }
        if (found_first) {
            System.out.println("First available seat is seat " + seatNumber + " in row " + row[rowNumber] + ".");
        } else {
            System.out.println("Unfortunately, all seats are currently occupied.");
        }
    }

    // Method to display the seating plan.
    public static void show_seating_plan() {
        for (int j : A) {
            if (j == 0) {
                System.out.print("O" + " ");
            } else {
                System.out.print("X" + " ");
            }
        }

        System.out.println();
        for (int j : B) {
            if (j == 0) {
                System.out.print("O" + " ");
            } else {
                System.out.print("X" + " ");
            }
        }

        System.out.println();
        for (int j : C) {
            if (j == 0) {
                System.out.print("O" + " ");
            } else {
                System.out.print("X" + " ");
            }
        }

        System.out.println();
        for (int j : D) {
            if (j == 0) {
                System.out.print("O" + " ");
            } else {
                System.out.print("X" + " ");
            }
        }
        System.out.println();
    }

    // Method to print ticket information and total sales.
    public static void print_tickets_info() {
        // Variable to store the total price of all tickets
        int totalPrice = 0;
        for (Ticket i : tickets) {
            try {
                totalPrice += i.getPrice();
                System.out.println("***** Ticket information of " + i.getPerson().getName() + " *****");
                i.printTicket();
                System.out.println("****************************************");
            } catch (Exception ignored) {
            }
        }
        System.out.println("Total price: £" + totalPrice);
    }

    // Method to search for a ticket.
    public static void search_ticket() {
        validateRow();
        validateSeat();
        // Iterate over the tickets array to find a matching ticket.
        for (int i = 0; i < tickets.length - 1; i++) {
            if (tickets[i] != null) {
                if (tickets[i].getRow().equals(seat_row) && tickets[i].getSeat() == seat) {
                    System.out.println("****** Customer details ******");
                    tickets[i].printTicket();
                    return;
                }
            }
        }
        System.out.println("Entered seat is available.");
    }

    // Method to validate row input.
    public static void validateRow() {
        while (true) {
            Scanner rowInputScan = new Scanner(System.in);

            System.out.print("Enter the row (A, B, C, D): ");
            seat_row = rowInputScan.next().toUpperCase();
            if (seat_row.equals("A") || seat_row.equals("B") || seat_row.equals("C") || seat_row.equals("D")) {
                break;
            } else {
                System.out.println("Please enter a valid row.");
            }
        }
    }

    // Method to validate seat input.
    public static void validateSeat() {
        while (true) {
            Scanner seatInputScan = new Scanner(System.in);

            try {
                System.out.print("Enter the seat number: ");
                seat = seatInputScan.nextInt();
                if (seat_row.equals("A") || seat_row.equals("D")) {
                    if (seat >= 1 && seat <= 14) {
                        break;
                    } else {
                        System.out.println("Please enter a valid seat number.");
                    }
                } else if (seat_row.equals("B") || seat_row.equals("C")) {
                    if (seat >= 1 && seat <= 12) {
                        break;
                    } else {
                        System.out.println("Please enter a valid seat number.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid seat number.");
            }
        }
    }

    // Method to get user details for buying a ticket.
    public static void getUserDetails() {
        Scanner getDetails = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String inputName = getDetails.next();

        System.out.print("Enter your surname: ");
        String inputSurname = getDetails.next();

        System.out.print("Enter your email: ");
        String inputEmail = getDetails.next();

        System.out.println("Enter your height:");
        double inputHeight = getDetails.nextDouble();

        System.out.println();
        // Create a new Person object with the entered details.
        Person p1 = new Person(inputName, inputSurname, inputEmail);
        p1.setHeight(inputHeight);
        // Call the addTicket method to reserve a seat for this person.
        addTicket(p1);
        System.out.println("Seat " + seat_row + seat + " has been successfully reserved by: ");
        p1.printDetails();

    }

    // Method to calculate ticket price based on row and seat.
    public static int calculateTicketPrice(String row, int col) {
        int price = 0;
        if (row.equals("A") || row.equals("D")) {
            if (col >= 1 && col <= 5) {
                price = 200;
            } else if (col >= 6 && col <= 9) {
                price = 150;
            } else if (col >= 10 && col <= 14) {
                price = 180;
            }
        } else if (row.equals("B") || row.equals("C")) {
            if (col >= 1 && col <= 5) {
                price = 200;
            } else if (col >= 6 && col <= 9) {
                price = 150;
            } else if (col >= 10 && col <= 12) {
                price = 180;
            }
        }
        return (price);
    }

    // Method to add a ticket to the tickets array.
    public static void addTicket(Person person) {
        Ticket ticket = new Ticket();
        ticket.setRow(seat_row);
        ticket.setSeat(seat);
        ticket.setPrice(calculateTicketPrice(seat_row, seat));
        ticket.setPerson(person);
        ticket.save();
        // Iterate through the tickets array to find an empty slot.
        for (int i = 0; i <= tickets.length - 1; i++) {
            if (tickets[i] == null) {
                tickets[i] = ticket;
                break;
            }
        }

    }

    // Method to cancel a ticket.
    public static void cancelTicket() {
        for (int i = 0; i <= tickets.length - 1; i++) {
            if (tickets[i] != null) {
                // Check if the current ticket matches the global seat_row and seat variables
                if (tickets[i].getRow().equals(seat_row) && tickets[i].getSeat() == seat) {
                    tickets[i] = null;
                    break;
                }
            }
        }
    }
}