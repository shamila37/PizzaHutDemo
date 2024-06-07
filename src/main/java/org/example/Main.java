package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Scanner input = new Scanner(System.in);
//    static double price1, price2, price3, price4;
//    static String item1, item2, item3, item4;
//    static String description1, description2, description3, description4;
    static int itemCount = 0;
    static double total;
    static String currencyCode = "LKR";
    static String[] items = {"", "", "", ""};
    static String[] prices = {"", "", "", ""};

    static String item1 = "BBQ Chicken Pizza";
    static String item2 = "Devil Chicken Pizza";
    static String item3 = "Vegi Pizza";
    static String item4 = "Pork Pizza";

    static double price1 = 1299.00;
    static double price2 = 1499.00;
    static double price3 = 999.00;
    static double price4 = 1999.00;

    static String description1 = "BBQ Chicken brest, Mozzarella Cheese, Bell Pepper";
    static String description2 = "Devil Chicken brest, Mozzarella Cheese, Bell Pepper";
    static String description3 = "Carrot & onions, Mozzarella Cheese, Bell Pepper";
    static String description4 = "BBQ Pork, Mozzarella Cheese, Bell Pepper";

    //    -------------   Main method start   -------------
    public static void main(String[] args) {
        HomeView();
    }
    //    -------------   Main method end   -------------

    //    -------------   HomeView method start   -------------
    public static void HomeView(){
        System.out.println("\nWelcome to PizzaHut!");
        System.out.println("To View our menu, press [1]");
        System.out.println("To place an Order, press [2]");
        System.out.println("Press [x] to exit the store\n");

        while(true) {
            String customerOption = input.nextLine();
            if (customerOption.equals("1")) {
                MainMenuView();
            } else if (customerOption.equals("2")) {
                MakeOrderScreen();
            } else if (customerOption.equals("x")) {
                System.out.println("\nThank you for visiting Pizza Hut, See you next time.\n");
                System.exit(0);
            } else {
                InvalidPart();
            }
        }
    }
    //    -------------   HomeView method end   -------------

    private static void InvalidPart() {
        System.out.println("\nPlease enter valid option from bellow");
        System.out.println("To View our menu, press [1]");
        System.out.println("To place an Order, press [2]\n");
    }

    //    -------------   MainMenu method start   -------------
    public static void MainMenuView() {
        while (true) {
            System.out.println("\nPizzaHut Menu\n");
            System.out.println("#1 " + item1 +" - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 +" - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 +" - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 +" - " + price4 + " " + currencyCode);
            System.out.println("\n\nPress item number to view description\nOR\nPress [0] to go back\n");

            String customerOption1 = input.nextLine();
            if (customerOption1.equals("1")) {
                AddItem1();
            } else if (customerOption1.equals("2")) {
                AddItem2();
            } else if (customerOption1.equals("3")) {
                AddItem3();
            } else if (customerOption1.equals("4")) {
                AddItem4();
            } else if (customerOption1.equals("0")) {
                HomeView();
            } else {
                System.out.print("\nPlease enter a valid input");
            }
        }
    }
    //    -------------   MainMenu method end   -------------

    private static void AddItem1() {
        System.out.println("\nName        : " + item1);
        System.out.println("Description : " + description1);
        System.out.println("Price       : " + price1 + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem2() {
        System.out.println("\nName        : " + item2);
        System.out.println("Description : " + description2);
        System.out.println("Price       : " + price2 + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem3() {
        System.out.println("\nName        : " + item3);
        System.out.println("Description : " + description3);
        System.out.println("Price       : " + price3 + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem4() {
        System.out.println("\nName        : " + item4);
        System.out.println("Description : " + description4);
        System.out.println("Price       : " + price4 + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    //    -------------   MakeOrderScreen method start   -------------
    public static void MakeOrderScreen(){
        while (true){
            System.out.println("\nYou can buy 3 items.");
            System.out.println("Please select first item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\n\nPress item number to select first item\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")){
                items[0] = item1;
                prices[0] = String.valueOf(price1);
                Choice1();
            } else if (customerOption2.equals("2")) {
                items[0] = item2;
                prices[0] = String.valueOf(price2);
                Choice2();
            } else if (customerOption2.equals("3")) {
                items[0] = item3;
                prices[0] = String.valueOf(price3);
                Choice3();
            } else if (customerOption2.equals("4")) {
                items[0] = item4;
                prices[0] = String.valueOf(price4);
                Choice4();
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }
    //    -------------   MakeOrderScreen method end   -------------

    //    --------------------------   Choice - 1  start --------------------------
    private static void Choice1() {
        itemCount += 1;
        total += price1;
        while (true){
            System.out.println("\nPlease select second item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as second item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("2")) {
                items[1] = item2;
                prices[1] = String.valueOf(price2);
                Choice1_2();
            } else if (customerOption2.equals("3")) {
                items[1] = item3;
                prices[1] = String.valueOf(price3);
                Choice1_3();
            } else if (customerOption2.equals("4")) {
                items[1] = item4;
                prices[1] = String.valueOf(price4);
                Choice1_4();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice1_2() {
        itemCount += 1;
        total+= price2;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("3")) {
                items[2] = item3;
                prices[2] = String.valueOf(price3);
                Choice1_2_3();
            } else if (customerOption2.equals("4")) {
                items[2] = item4;
                prices[2] = String.valueOf(price4);
                Choice1_2_4();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice1_2_3() {
        itemCount += 1;
        total += price3;
        items[3] = item3;
        prices[3] = String.valueOf(price3);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice1_2_4() {
        itemCount += 1;
        total += price4;
        items[3] = item4;
        prices[3] = String.valueOf(price4);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice1_3() {
        itemCount += 1;
        total+= price3;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("2")) {
                items[2] = item2;
                prices[2] = String.valueOf(price2);
                Choice1_3_2();
            } else if (customerOption2.equals("4")) {
                items[2] = item4;
                prices[2] = String.valueOf(price4);
                Choice1_3_4();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice1_3_2() {
        itemCount += 1;
        total += price2;
        items[3] = item2;
        prices[3] = String.valueOf(price2);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice1_3_4() {
        itemCount += 1;
        total += price4;
        items[3] = item4;
        prices[3] = String.valueOf(price4);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice1_4() {
        itemCount += 1;
        total+= price4;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("2")) {
                items[2] = item2;
                prices[2] = String.valueOf(price2);
                Choice1_4_2();
            } else if (customerOption2.equals("3")) {
                items[2] = item3;
                prices[2] = String.valueOf(price3);
                Choice1_4_3();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice1_4_2() {
        itemCount += 1;
        total += price2;
        items[3] = item2;
        prices[3] = String.valueOf(price2);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice1_4_3() {
        itemCount += 1;
        total += price3;
        items[3] = item3;
        prices[3] = String.valueOf(price3);
        ReceiptView();
        System.exit(0);
    }
    //    --------------------------   Choice - 1  end --------------------------

    //    --------------------------   Choice - 2  start --------------------------
    private static void Choice2() {
        itemCount += 1;
        total += price2;
        while (true){
            System.out.println("\nPlease select second item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as second item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                items[1] = item1;
                prices[1] = String.valueOf(price1);
                Choice2_1();
            } else if (customerOption2.equals("3")) {
                items[1] = item3;
                prices[1] = String.valueOf(price3);
                Choice2_3();
            } else if (customerOption2.equals("4")) {
                items[1] = item4;
                prices[1] = String.valueOf(price4);
                Choice2_4();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice2_1() {
        itemCount += 1;
        total+= price1;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("3")) {
                items[2] = item3;
                prices[2] = String.valueOf(price3);
                Choice2_1_3();
            } else if (customerOption2.equals("4")) {
                items[2] = item4;
                prices[2] = String.valueOf(price4);
                Choice2_1_4();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice2_1_3() {
        itemCount += 1;
        total += price3;
        items[3] = item3;
        prices[3] = String.valueOf(price3);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice2_1_4() {
        itemCount += 1;
        total += price4;
        items[3] = item4;
        prices[3] = String.valueOf(price4);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice2_3() {
        itemCount += 1;
        total+= price3;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                items[2] = item1;
                prices[2] = String.valueOf(price1);
                Choice2_3_1();
            } else if (customerOption2.equals("4")) {
                items[2] = item4;
                prices[2] = String.valueOf(price4);
                Choice2_3_4();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice2_3_1() {
        itemCount += 1;
        total += price1;
        items[3] = item1;
        prices[3] = String.valueOf(price1);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice2_3_4() {
        itemCount += 1;
        total += price4;
        items[3] = item4;
        prices[3] = String.valueOf(price4);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice2_4() {
        itemCount += 1;
        total+= price4;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                items[2] = item1;
                prices[2] = String.valueOf(price1);
                Choice2_4_1();
            } else if (customerOption2.equals("3")) {
                items[2] = item3;
                prices[2] = String.valueOf(price3);
                Choice2_4_3();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice2_4_1() {
        itemCount += 1;
        total += price1;
        items[3] = item1;
        prices[3] = String.valueOf(price1);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice2_4_3() {
        itemCount += 1;
        total += price3;
        items[3] = item3;
        prices[3] = String.valueOf(price1);
        ReceiptView();
        System.exit(0);
    }
    //    --------------------------   Choice - 2  end --------------------------

    //    --------------------------   Choice - 3  start --------------------------
    private static void Choice3() {
        itemCount += 1;
        total += price3;
        while (true){
            System.out.println("\nPlease select second item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as second item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                items[1] = item1;
                prices[1] = String.valueOf(price1);
                Choice3_1();
            } else if (customerOption2.equals("2")) {
                items[1] = item2;
                prices[1] = String.valueOf(price2);
                Choice3_2();
            } else if (customerOption2.equals("4")) {
                items[1] = item4;
                prices[1] = String.valueOf(price4);
                Choice3_4();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice3_1() {
        itemCount += 1;
        total+= price1;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("2")) {
                items[2] = item2;
                prices[2] = String.valueOf(price2);
                Choice3_1_2();
            } else if (customerOption2.equals("4")) {
                items[2] = item4;
                prices[2] = String.valueOf(price4);
                Choice3_1_4();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice3_1_2() {
        itemCount += 1;
        total += price2;
        items[3] = item2;
        prices[3] = String.valueOf(price2);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice3_1_4() {
        itemCount += 1;
        total += price4;
        items[3] = item4;
        prices[3] = String.valueOf(price4);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice3_2() {
        itemCount += 1;
        total+= price2;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                items[2] = item1;
                prices[2] = String.valueOf(price1);
                Choice3_2_1();
            } else if (customerOption2.equals("4")) {
                items[2] = item4;
                prices[2] = String.valueOf(price4);
                Choice3_2_4();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice3_2_1() {
        itemCount += 1;
        total += price1;
        items[3] = item1;
        prices[3] = String.valueOf(price1);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice3_2_4() {
        itemCount += 1;
        total += price4;
        items[3] = item4;
        prices[3] = String.valueOf(price4);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice3_4() {
        itemCount += 1;
        total+= price4;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                items[2] = item1;
                prices[2] = String.valueOf(price1);
                Choice3_4_1();
            } else if (customerOption2.equals("2")) {
                items[2] = item2;
                prices[2] = String.valueOf(price2);
                Choice3_4_2();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice3_4_1() {
        itemCount += 1;
        total += price1;
        items[3] = item1;
        prices[3] = String.valueOf(price1);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice3_4_2() {
        itemCount += 1;
        total += price2;
        items[3] = item2;
        prices[3] = String.valueOf(price2);
        ReceiptView();
        System.exit(0);
    }
    //    --------------------------   Choice - 3  end --------------------------

    //    --------------------------   Choice - 4  start --------------------------
    private static void Choice4() {
        itemCount += 1;
        total += price4;
        while (true){
            System.out.println("\nPlease select second item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as second item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                items[1] = item1;
                prices[1] = String.valueOf(price1);
                Choice4_1();
            } else if (customerOption2.equals("2")) {
                items[1] = item2;
                prices[1] = String.valueOf(price2);
                Choice4_2();
            } else if (customerOption2.equals("3")) {
                items[1] = item3;
                prices[1] = String.valueOf(price3);
                Choice4_3();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice4_1() {
        itemCount += 1;
        total+= price1;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("2")) {
                items[2] = item2;
                prices[2] = String.valueOf(price2);
                Choice4_1_2();
            } else if (customerOption2.equals("3")) {
                items[2] = item3;
                prices[2] = String.valueOf(price3);
                Choice4_1_3();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice4_1_2() {
        itemCount += 1;
        total += price2;
        items[3] = item2;
        prices[3] = String.valueOf(price2);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice4_1_3() {
        itemCount += 1;
        total += price3;
        items[3] = item3;
        prices[3] = String.valueOf(price3);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice4_2() {
        itemCount += 1;
        total+= price2;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                items[2] = item1;
                prices[2] = String.valueOf(price1);
                Choice4_2_1();
            } else if (customerOption2.equals("3")) {
                items[2] = item3;
                prices[2] = String.valueOf(price3);
                Choice4_2_3();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice4_2_1() {
        itemCount += 1;
        total += price1;
        items[3] = item1;
        prices[3] = String.valueOf(price1);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice4_2_3() {
        itemCount += 1;
        total += price3;
        items[3] = item3;
        prices[3] = String.valueOf(price3);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice4_3() {
        itemCount += 1;
        total+= price3;
        while (true){
            System.out.println("\nPlease select final item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as final item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                items[2] = item1;
                prices[2] = String.valueOf(price1);
                Choice4_3_1();
            } else if (customerOption2.equals("2")) {
                items[2] = item2;
                prices[2] = String.valueOf(price2);
                Choice4_3_2();
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
    }

    private static void Choice4_3_1() {
        itemCount += 1;
        total += price1;
        items[3] = item1;
        prices[3] = String.valueOf(price1);
        ReceiptView();
        System.exit(0);
    }

    private static void Choice4_3_2() {
        itemCount += 1;
        total += price2;
        items[3] = item2;
        prices[3] = String.valueOf(price2);
        ReceiptView();
        System.exit(0);
    }
    //    --------------------------   Choice - 4  end --------------------------

    //    -------------   ReceiptView method start   -------------
    static void ReceiptView() {
        System.out.println("\nYou have ordered #" + itemCount + " number of items");
        System.out.println("            Pizza Hut");
        System.out.println("-------------------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("#" + (i+1) + " " + items[i] + " - " + prices[i] + " " + currencyCode);
        }
        System.out.println("\n        Total : " + total + " " + currencyCode);
        System.out.println("-------------------------------------");
        System.out.println("     Thank You For Ordering");
        System.out.println("-------------------------------------");
        System.out.println("Thank you for visiting Pizza Hut, See you next time.\n");
    }
    //    -------------   ReceiptView method end   -------------
}