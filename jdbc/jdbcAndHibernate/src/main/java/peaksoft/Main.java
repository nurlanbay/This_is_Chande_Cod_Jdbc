package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    static UserService database = new UserServiceImpl();
    static Scanner scanner = new Scanner(System.in);
    static Scanner sr = new Scanner(System.in);

    public static void main(String[] args) {
        User user = new User();
        while (true) {

            try {
                printCancol();
                int number = scanner.nextInt();

                if (number < 0 || number > 7) {
                    throw new Exception("you give wrong number");
                }
                switch (number) {
                    case 1 -> database.createUsersTable();

                    case 2 -> database.dropUsersTable();

                    case 3 -> {
                            System.out.println("write name >");
                            String a = sr.nextLine();
                            System.out.println("write last_name >");
                            String b = sr.nextLine();
                            System.out.println("write age >");
                            byte c = sr.nextByte();
                            database.saveUser(a, b, c);
                        }

                    case 4 -> {
                        long removeById = scanner.nextInt();
                        database.removeUserById(removeById);
                    }

                    case 5 ->{
                        long findById = scanner.nextInt();
                        System.out.println(database.findById(findById));
                    }
                    case 6 -> {

                        for (User user1: database.getAllUsers()) {
                            System.out.println(user1);
                        }

                    }

                    case 7 -> database.cleanUsersTable();


                    default -> System.out.println("You give wrong ");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void printCancol() {
        System.out.println("print to 1 -> create Table");
        System.out.println("print to 2 -> Drop  Table");
        System.out.println("print to 3 -> CaveUser");
        System.out.println("print to 4 -> Remove User By Id");
        System.out.println("print to 5 -> find by id users");
        System.out.println("print to 6 -> Get All Users");
        System.out.println("print to 7 -> Clean Users Table");
        System.out.println();
        System.out.println("Print you want to number...");
    }

}
