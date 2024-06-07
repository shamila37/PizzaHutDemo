package org.example;

// ------------------    Upgraded version of Main.java    ------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    static Scanner input = new Scanner(System.in);
    //    static double price1, price2, price3, price4;
    //    static String item1, item2, item3, item4;
    //    static String description1, description2, description3, description4;
    static int itemCount = 0;
    static double total;
    static String currencyCode = "LKR";
    static String[] orderStep = {"first", "second", "third"};
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
//        try {
//            File myFile = new File("menuList.json");
//            Scanner myReader = new Scanner(myFile);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                System.out.println(data);
//            }
//            myReader.close();
//        }catch (FileNotFoundException e){
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
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
        for (int i = 0; i < 3; i++) {
            System.out.println("\nYou can buy 3 items.");
            System.out.println("Please select " + orderStep[i] + " item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\n\nPress item number to select " + orderStep[i] + " item\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                itemCount += 1;
                total += price1;
                items[i] = item1;
                prices[i] = String.valueOf(price1);
                Choice1();
            } else if (customerOption2.equals("2")) {
                itemCount += 1;
                total += price2;
                items[i] = item2;
                prices[i] = String.valueOf(price2);
                Choice2();
            } else if (customerOption2.equals("3")) {
                itemCount += 1;
                total += price3;
                items[i] = item3;
                prices[i] = String.valueOf(price3);
                Choice3();
            } else if (customerOption2.equals("4")) {
                itemCount += 1;
                total += price4;
                items[i] = item4;
                prices[i] = String.valueOf(price4);
                Choice4();
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
        ReceiptView();
        System.exit(0);
    }
    //    -------------   MakeOrderScreen method end   -------------

    private static void Choice1() {
        for (int i = 1; i < 3; i++) {
            System.out.println("\nPlease select " + orderStep[i] + " item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as " + orderStep[i] + " item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("2")) {
                itemCount += 1;
                total += price2;
                items[i] = item2;
                prices[i] = String.valueOf(price2);
            } else if (customerOption2.equals("3")) {
                itemCount += 1;
                total += price3;
                items[i] = item3;
                prices[i] = String.valueOf(price3);
            } else if (customerOption2.equals("4")) {
                itemCount += 1;
                total += price4;
                items[i] = item4;
                prices[i] = String.valueOf(price4);
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
        ReceiptView();
        System.exit(0);
    }

    private static void Choice2() {
        for (int i = 1; i < 3; i++) {
            System.out.println("\nPlease select " + orderStep[i] + " item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as " + orderStep[i] + " item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                itemCount += 1;
                total += price1;
                items[i] = item1;
                prices[i] = String.valueOf(price1);
            } else if (customerOption2.equals("3")) {
                itemCount += 1;
                total += price3;
                items[i] = item3;
                prices[i] = String.valueOf(price3);
            } else if (customerOption2.equals("4")) {
                itemCount += 1;
                total += price4;
                items[i] = item4;
                prices[i] = String.valueOf(price4);
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
        ReceiptView();
        System.exit(0);
    }

    private static void Choice3() {
        for (int i = 1; i < 3; i++) {
            System.out.println("\nPlease select " + orderStep[i] + " item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as " + orderStep[i] + " item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                itemCount += 1;
                total += price1;
                items[i] = item1;
                prices[i] = String.valueOf(price1);
            } else if (customerOption2.equals("2")) {
                itemCount += 1;
                total += price2;
                items[i] = item2;
                prices[i] = String.valueOf(price2);
            } else if (customerOption2.equals("4")) {
                itemCount += 1;
                total += price4;
                items[i] = item4;
                prices[i] = String.valueOf(price4);
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
        ReceiptView();
        System.exit(0);
    }

    private static void Choice4() {
        for (int i = 1; i < 3; i++) {
            System.out.println("\nPlease select " + orderStep[i] + " item you want to buy.\n");
            System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
            System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
            System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
            System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
            System.out.println("\nPress item number to select as " + orderStep[i] + " item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            if (customerOption2.equals("1")) {
                itemCount += 1;
                total += price1;
                items[i] = item1;
                prices[i] = String.valueOf(price1);
            } else if (customerOption2.equals("2")) {
                itemCount += 1;
                total += price2;
                items[i] = item2;
                prices[i] = String.valueOf(price2);
            } else if (customerOption2.equals("3")) {
                itemCount += 1;
                total += price3;
                items[i] = item3;
                prices[i] = String.valueOf(price3);
            } else if (customerOption2.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption2.equals("0")) {
                MainMenuView();
            }
        }
        ReceiptView();
        System.exit(0);
    }

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