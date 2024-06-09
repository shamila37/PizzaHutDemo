package org.example;

// ------------------    Upgraded version of Main2.java    ------------------

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    static Scanner input = new Scanner(System.in);
    static int itemCount = 0;
    static double total;
    static String currencyCode = "LKR";
    static String[] orderStep = {"first", "second", "third"};
    static ArrayList<String> itemsName = new ArrayList<String>();
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
            switch (customerOption) {
                case "1" -> MainMenuView();
                case "2" -> MakeOrderScreen();
                case "x" -> {
                    System.out.println("\nThank you for visiting Pizza Hut, See you next time.\n");
                    System.exit(0);
                }
                default -> {
                    System.out.println("\nPlease enter valid option from bellow");
                    System.out.println("To View our menu, press [1]");
                    System.out.println("To place an Order, press [2]\n");
                }
            }
        }
    }
    //    -------------   HomeView method end   -------------

    private static void Items() {
        System.out.println("#1 " + item1 + " - " + price1 + " " + currencyCode);
        System.out.println("#2 " + item2 + " - " + price2 + " " + currencyCode);
        System.out.println("#3 " + item3 + " - " + price3 + " " + currencyCode);
        System.out.println("#4 " + item4 + " - " + price4 + " " + currencyCode);
    }

    //    -------------   MainMenu method start   -------------
    public static void MainMenuView() {
        while (true) {
            System.out.println("\nPizzaHut Menu\n");
            Items();
            System.out.println("\n\nPress item number to view description\nOR\nPress [0] to go back\n");

            String customerOption1 = input.nextLine();
            switch (customerOption1) {
                case "1" -> AddItem1();
                case "2" -> AddItem2();
                case "3" -> AddItem3();
                case "4" -> AddItem4();
                case "0" -> HomeView();
                default -> System.out.print("\nPlease enter a valid input");
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
    public static void MakeOrderScreen() {
        System.out.println("\nYou can buy 3 items.");
        System.out.println("Please select " + orderStep[0] + " item you want to buy.\n");
        Items();
        System.out.println("\n\nPress item number to select " + orderStep[0] + " item\nOR\nPress [0] to go back to Main menu\n");

        String customerOption2 = input.nextLine();
        switch (customerOption2) {
            case "1" -> {
                itemCount += 1;
                total += price1;
                itemsName.add(item1);
                prices[0] = String.valueOf(price1);
                Choice();
            }
            case "2" -> {
                itemCount += 1;
                total += price2;
                itemsName.add(item2);
                prices[0] = String.valueOf(price2);
                Choice();
            }
            case "3" -> {
                itemCount += 1;
                total += price3;
                itemsName.add(item3);
                prices[0] = String.valueOf(price3);
                Choice();
            }
            case "4" -> {
                itemCount += 1;
                total += price4;
                itemsName.add(item4);
                prices[0] = String.valueOf(price4);
                Choice();
            }
            case "0" -> MainMenuView();
        }
    }
    //    -------------   MakeOrderScreen method end   -------------

    private static void Choice() {
        for (int i = 1; i < 3; i++) {
            System.out.println("\nPlease select " + orderStep[i] + " item you want to buy.\n");
            Items();
            System.out.println("\nPress item number to select as " + orderStep[i] + " item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption2 = input.nextLine();
            switch (customerOption2) {
                case "1" -> {
                    itemCount += 1;
                    total += price1;
                    itemsName.add(item1);
                    prices[i] = String.valueOf(price1);
                }
                case "2" -> {
                    itemCount += 1;
                    total += price2;
                    itemsName.add(item2);
                    prices[i] = String.valueOf(price2);
                }
                case "3" -> {
                    itemCount += 1;
                    total += price3;
                    itemsName.add(item3);
                    prices[i] = String.valueOf(price3);
                }
                case "4" -> {
                    itemCount += 1;
                    total += price4;
                    itemsName.add(item4);
                    prices[i] = String.valueOf(price4);
                }
                case "E" -> {
                    ReceiptView();
                    System.exit(0);
                }
                case "0" -> MainMenuView();
            }
        }
        ReceiptView();
        System.exit(0);
    }

    //    -------------   ReceiptView method start   -------------
    private static void ReceiptView() {
        System.out.println("\nYou have ordered #" + itemCount + " number of items");
        System.out.println("            Pizza Hut");
        System.out.println("-------------------------------------");
        for (int i = 0; i < itemsName.size(); i++) {
            System.out.println("#" + (i+1) + " " + itemsName.get(i) + " - " + prices[i] + " " + currencyCode);
        }
        System.out.println("\n        Total : " + total + " " + currencyCode);
        System.out.println("-------------------------------------");
        System.out.println("     Thank You For Ordering");
        System.out.println("-------------------------------------");
        System.out.println("Thank you for visiting Pizza Hut, See you next time.\n");
    }
    //    -------------   ReceiptView method end   -------------
}