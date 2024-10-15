public class Person {
    // Attributes for the person's name, surname, and email.
    private String name;
    private String surname;
    private String email;
    private double height;

    // Constructor to initialize a new Person object with name, surname, and email.
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
//        this.height = height;
    }

    // Getter and setter methods for person's name, surname, and email.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    // Method to print details of the person.
    public void printDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Email: " + getEmail());
        System.out.println("Height: " + getHeight());
    }
}
