import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Please type in your first name and last name: ");
        Scanner console = new Scanner(System.in);
        String FirstName = console.next();
        String LastName = console.next();

        Email email = new Email(FirstName, LastName);
        System.out.println(email.InfoCheck());

    }
}