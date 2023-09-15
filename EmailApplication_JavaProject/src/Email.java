import java.util.*;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String companySuffix;
    private int mailboxCap = 500;
    private int defaultpwLength=10;
    private String alternateEmail;

    public Email(String firstName, String lastName){
        //Construct to receive the first name and last name;
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
        //asking for the department
        this.department = Request_Department();
        //returning password

        this.password = passwordCreator(defaultpwLength);
        System.out.println("Your Password is: " + this.password);

        //Start generating email
        this.companySuffix = Suffix();
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix + ".com";
    }

    //Ask for the department
    private String Request_Department(){
        while(true) {
            System.out.print("\n" +
                    "1 for Sales\n" +
                    "2 for Development\n" +
                    "3 for Accounting\n" +
                    "0 for none of them\n" +
                    "Enter The Department Code: ");
            Scanner console = new Scanner(System.in);
            int num = console.nextInt();
            if(num == 1){
                return "SALES";
            }
            else if(num == 2){
                return "DEV";
            }
            else if(num == 3){
                return "ACC";
            }
            else if(num == 0){
                return "UNKNOWN";
            }
        }
    }
    //Choosing your own password
    private String passwordCreator(int length){
            System.out.println("\nClick Y if you want to create your own password(default is 10 digit),\n" +
                    "Click N if you want generating a password");
            Scanner console = new Scanner(System.in);
            String num = console.next();
            if(num.equalsIgnoreCase("Y") || num.equalsIgnoreCase("Yes") ){
                return passwordCreating(length);
            }

            else if(num.equalsIgnoreCase("N") || num.equalsIgnoreCase("No")){
                return passwordGenerator(length);
            }

            else{
                System.out.println("Since you are neither choosing Y or N, we automatically generated a password for you.");
                return passwordGenerator(length);
            }

    }
    //Creating your own password
    private String passwordCreating(int length){
        Scanner console = new Scanner(System.in);
        while(true) {
            System.out.println("Please type in your " + length + "digit number\n" +
                    "(ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?/): ");
            String pw = console.next();
            if (pw.length() == length) {
                return pw;
            }
        }
    }

    //Generate a random password
    private String passwordGenerator(int length){
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }

        Random rand = new Random();
        StringBuilder pw = new StringBuilder();

        String pwSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?/";
        for (int i = 0; i < length; i++) {
            pw.append(pwSet.charAt(rand.nextInt(pwSet.length())));
        }

        return pw.toString();
    }

    //Suffix
    private String Suffix(){
        Scanner console = new Scanner(System.in);
        System.out.println("Please type in your company Suffix: ");
        String suffix = console.next();
        return suffix;
    }
    //Set the mailbox capacity
    public void setMailboxCap(int capacity){
        this.mailboxCap = capacity;
    }
    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //Change the password
    public void ChangePassWord(int length){
        Scanner console = new Scanner(System.in);
        String Choose = console.next();
        System.out.println("Do you want to change password?(type y or n): ");
        if(Choose.equalsIgnoreCase("Y") || Choose.equalsIgnoreCase("Yes") ){
            this.password = passwordCreator(length);
        }

        else{
            System.out.println("Changing Password Denied");
        }
    }
    //Set PW length
    public void SetPasswordLength(int length){
        this.defaultpwLength = length;
    }

    //get method following:
    public int getMailboxCap(){
        return mailboxCap;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }
    //conclude all the information:
    public String InfoCheck(){
        return "\nDisplay Name: " + firstName + lastName + "\n" +
                "Company Email: " + email + "\n" +
                "Mailbox Capacity: " + mailboxCap + "\n" +
                "Password: " + password;
    }
}
