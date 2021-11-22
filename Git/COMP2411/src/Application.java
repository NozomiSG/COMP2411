import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        homepage();
    }

    public static void registerAccount() {
        String username, password, phoneNumber;
        Scanner scanner = new Scanner(System.in);

    }
    public static void loginAccount() {

    }
    public static void loginAdmin() {

    }
    public static void checkDelivery() {

    }

    public static void homepage() {
        System.out.println("Welcome use deliverApp!");
        System.out.println("\n=====================================");
        System.out.println("Register an account      >>> Enter(1)");
        System.out.println("Login your account       >>> Enter(2)");
        System.out.println("Check delivery status    >>> Enter(3)");
        System.out.println("Login admin account      >>> Enter(4)");
        System.out.println("Exit the program         >>> Enter(5)");
        System.out.println("=====================================\n\n\n");
        int scan;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter your command: ");
            try {
                scan = scanner.nextInt();
                if (scan > 0 && scan < 6)
                    break;
                else
                    System.out.println("Your enter is wrong, please enter again!");
            }catch(Exception e) {
                System.out.println("Your enter is wrong, please enter again!");
                scanner.next();
            }
        }
        switch (scan) {
            case 1 ->
                registerAccount();
            case 2 ->
                loginAccount();
            case 3 ->
                checkDelivery();
            case 4 ->
                loginAdmin();
            case 5 ->
                System.out.println("Bye");
            default -> {
                System.out.println("Unknown command, please enter again!\n\n\n\n");
                homepage();
            }
        }
    }
}

