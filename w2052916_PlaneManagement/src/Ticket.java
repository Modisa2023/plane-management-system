import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    // Attributes for the ticket's row, seat number, price, and associated person.
    private String row;
    private int seat;
    private int price;
    private Person person;

    // Getter and setter methods for the ticket's row, seat number, price, and associated person.
    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Method to print ticket information.
    public void printTicket() {
        System.out.println("Row: " + row);
        System.out.println("Seat number: " + seat);
        System.out.println("Price: £" + price);
        person.printDetails();
    }

    // Method to save ticket information to a file
    public void save() {
        // Create a directory named 'tickets' if it doesn't exist.
        File directory = new File("tickets");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            // Create a file for this ticket using the row and seat number in the 'tickets' directory.
            File file = new File("tickets/" + row + seat + ".txt");
            if (!file.exists()) {
                boolean fileCreated = file.createNewFile();
                if (!fileCreated) {
                    System.err.println("Failed to create file.");
                    return;
                }
            }

            // Use FileWriter to write ticket and personal details to the file.
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write("***** Ticket information ***** \n");
            fileWriter.write("Row: " + row + "\n");
            fileWriter.write("Seat number: " + seat + "\n");
            fileWriter.write("Price: £" + price + "\n");
            fileWriter.write("****** Personal details ****** \n");
            fileWriter.write("Name: " + person.getName() + "\n");
            fileWriter.write("Surname: " + person.getSurname() + "\n");
            fileWriter.write("Email: " + person.getEmail() + "\n");
            fileWriter.write("Height: " + person.getHeight() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error occurred while writing to file: " + e.getMessage());
        }
    }
}
