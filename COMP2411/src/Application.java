//import java.util.Objects;
//import java.util.Scanner;
//
//public class Application {
//
//    public static void main(String[] args) {
//
//    }
//
//
//
//    public static void homepage() {
//        String n;
//        /**
//         * You should input account before your registration
//         */
//        System.out.println("Welcome use Grade Book system! ");
//        System.out.println("Register an account      >>> Enter(1)");
//        System.out.println("Login your account       >>> Enter(2)");
//        System.out.println("Quit the program         >>> Enter(3)");
//        boolean flag = true;
//        String scan;
//        while (flag) {
//            Scanner scanner = new Scanner(System.in);
//            if (scanner.hasNext()) {
//                scan = scanner.next();
//                scanner.close();
//                if (scan.equals("1")||scan.equals("2")||scan.equals("3")) {
//                    scan
//                    flag = false;
//                }
//                else
//                    System.out.println("Wrong input, please try again!");
//            }
//        }
//        switch (scan) {
//
//            case "1" -> {
//            }
//            case "2" -> {
//            }
//            case "3" -> {
//            }
//        }
//
//
//        if (n.equals("R") || n.equals("r")) registerAccount();
//        else if (n.equals("L") || n.equals("l")) login();
//        else if (n.equals("I") || n.equals("i")) input();
//        else if (n.equals("~")) cout << "Bye!" << endl;
//        else {
//            System.out.println("Your instruction is wrong, please re-enter");
//            homepage();
//        }
//    }
//}
