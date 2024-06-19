package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {

    static Scanner input = new Scanner(System.in);
    static int itemCount = 0;
    static double total;
    static String currencyCode = "LKR";
    static String[] orderStep = {"first", "second", "third"};
    static ArrayList<String> itemsName = new ArrayList<String>();
    static ArrayList<String> itemsSizes = new ArrayList<String>();
    static ArrayList<String> prices = new ArrayList<String>();
//    static String[] prices = {"", "", "", ""};

    static String item;
    static String itemNumber;
    static String item1 = "BBQ Chicken Pizza";
    static String item2 = "Devil Chicken Pizza";
    static String item3 = "Vegi Pizza";
    static String item4 = "Pork Pizza";

    static String size1 = "Large";
    static String size2 = "Medium";
    static String size3 = "Small";

    static double price_1;
    static double price_2;
    static double price_3;
    static double price1  = 1899.00;
    static double price2  = 1399.00;
    static double price3  =  999.00;
    static double price4  = 1999.00;
    static double price5  = 1499.00;
    static double price6  = 1099.00;
    static double price7  = 1099.00;
    static double price8  =  799.00;
    static double price9  =  499.00;
    static double price10 = 2199.00;
    static double price11 = 1599.00;
    static double price12 = 1199.00;

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
        System.out.println("\nNow can order pizzas in different sizes!\n");
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
        System.out.println("#1 " + item1 + " - L " + price1 + " " + currencyCode + " | M " + price2 + " " + currencyCode + " | S " + price3 + " " + currencyCode);
        System.out.println("#2 " + item2 + " - L " + price4 + " " + currencyCode + " | M " + price5 + " " + currencyCode + " | S " + price6 + " " + currencyCode);
        System.out.println("#3 " + item3 + " - L " + price7 + " " + currencyCode + " | M " + price8 + " " + currencyCode + " | S " + price9 + " " + currencyCode);
        System.out.println("#4 " + item4 + " - L " + price10 + " " + currencyCode + " | M " + price11 + " " + currencyCode + " | S " + price12 + " " + currencyCode);
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
        System.out.println("\nName : " + item1);
        System.out.println("Description : " + description1);
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + price1 + " " + currencyCode);
        System.out.println("Medium Price : " + price2 + " " + currencyCode);
        System.out.println("Small Price : " + price3 + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem2() {
        System.out.println("\nName : " + item2);
        System.out.println("Description : " + description2);
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + price4 + " " + currencyCode);
        System.out.println("Medium Price : " + price5 + " " + currencyCode);
        System.out.println("Small Price : " + price6 + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem3() {
        System.out.println("\nName : " + item3);
        System.out.println("Description : " + description3);
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + price7 + " " + currencyCode);
        System.out.println("Medium Price : " + price8 + " " + currencyCode);
        System.out.println("Small Price : " + price9 + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem4() {
        System.out.println("\nName : " + item4);
        System.out.println("Description : " + description4);
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + price10 + " " + currencyCode);
        System.out.println("Medium Price : " + price11 + " " + currencyCode);
        System.out.println("Small Price : " + price12 + " " + currencyCode);
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

        String customerOption3 = input.nextLine();
        if (customerOption3.equals("1")){
            Choice1();
        } else if (customerOption3.equals("2")) {
            Choice2();
        } else if (customerOption3.equals("3")) {
            Choice3();
        } else if (customerOption3.equals("4")) {
            Choice4();
        } else if (customerOption3.equals("0")){
            MainMenuView();
        }
    }
    //    -------------   MakeOrderScreen method end   -------------

    private static void Choice1() {
        while (true) {
            System.out.println("\nYou have selected #1 " + item1);
            System.out.println("Available options - L " + price1 + " " + currencyCode + " | M " + price2 + " " + currencyCode + " | S " + price3);
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();

            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += price1;
                itemsName.add(item1);
                itemsSizes.add(size1);
                prices.add(String.valueOf(price1));
                MakeOrderScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += price2;
                itemsName.add(item1);
                itemsSizes.add(size2);
                prices.add(String.valueOf(price2));
                MakeOrderScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += price3;
                itemsName.add(item1);
                itemsSizes.add(size3);
                prices.add(String.valueOf(price3));
                MakeOrderScreen1();
            } else {
                System.out.println("\nPlease enter a valid input.");
            }
        }
    }

    private static void Choice2() {
        while (true) {
        System.out.println("\nYou have selected #2 " + item2);
        System.out.println("Available options - L " + price4 + " " + currencyCode + " | M " + price5 + " " + currencyCode + " | S " + price6);
        System.out.println("\nPlease select a size you wish to buy.\n");
        System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

        String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")){
                itemCount += 1;
                total += price4;
                itemsName.add(item2);
                itemsSizes.add(size1);
                prices.add(String.valueOf(price4));
                MakeOrderScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += price5;
                itemsName.add(item2);
                itemsSizes.add(size2);
                prices.add(String.valueOf(price5));
                MakeOrderScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += price6;
                itemsName.add(item2);
                itemsSizes.add(size3);
                prices.add(String.valueOf(price6));
                MakeOrderScreen1();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void Choice3() {
        while (true) {
            System.out.println("\nYou have selected #3 " + item3);
            System.out.println("Available options - L " + price7 + " " + currencyCode + " | M " + price8 + " " + currencyCode + " | S " + price9);
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += price7;
                itemsName.add(item3);
                itemsSizes.add(size1);
                prices.add(String.valueOf(price7));
                MakeOrderScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += price8;
                itemsName.add(item3);
                itemsSizes.add(size2);
                prices.add(String.valueOf(price8));
                MakeOrderScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += price9;
                itemsName.add(item3);
                itemsSizes.add(size3);
                prices.add(String.valueOf(price9));
                MakeOrderScreen1();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void Choice4() {
        while (true) {
            System.out.println("\nYou have selected #4 " + item4);
            System.out.println("Available options - L " + price10 + " " + currencyCode + " | M " + price11 + " " + currencyCode + " | S " + price12);
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += price10;
                itemsName.add(item4);
                itemsSizes.add(size1);
                prices.add(String.valueOf(price10));
                MakeOrderScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += price11;
                itemsName.add(item4);
                itemsSizes.add(size2);
                prices.add(String.valueOf(price11));
                MakeOrderScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += price12;
                itemsName.add(item4);
                itemsSizes.add(size3);
                prices.add(String.valueOf(price12));
                MakeOrderScreen1();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    public static void MakeOrderScreen1() {
        for (int i = 1; i < 3; i++) {
            System.out.println("\nPlease select " + orderStep[i] + " item you want to buy.\n");
            Items();
            System.out.println("\nPress item number to select as " + orderStep[i] + " item\nOR");
            System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

            String customerOption3 = input.nextLine();
            if (customerOption3.equals("1")) {
                item = item1;
                itemNumber = "1";
                price_1 = 1899.00;
                price_2 = 1399.00;
                price_3 = 999.00;
                Choice();
            } else if (customerOption3.equals("2")) {
                item = item2;
                itemNumber = "2";
                price_1 = 1999.00;
                price_2 = 1499.00;
                price_3 = 1099.00;
                Choice();
            } else if (customerOption3.equals("3")) {
                item = item3;
                itemNumber = "3";
                price_1 = 1099.00;
                price_2 = 799.00;
                price_3 = 499.00;
                Choice();
            } else if (customerOption3.equals("4")) {
                item = item4;
                itemNumber = "4";
                price_1 = 2199.00;
                price_2 = 1599.00;
                price_3 = 1199.00;
                Choice();
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")) {
                MainMenuView();
            }
        }
        ReceiptView();
        System.exit(0);
    }

    private static void Choice() {
        while (true) {
            System.out.println("\nYou have selected #" + itemNumber + " " + item);
            System.out.println("Available options - L " + price_1 + " " + currencyCode + " | M " + price_2 + " " + currencyCode + " | S " + price_3);
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += price_1;
                itemsName.add(item);
                itemsSizes.add(size1);
                prices.add(String.valueOf(price_1));
                break;
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += price_2;
                itemsName.add(item);
                itemsSizes.add(size2);
                prices.add(String.valueOf(price_2));
                break;
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += price_3;
                itemsName.add(item);
                itemsSizes.add(size3);
                prices.add(String.valueOf(price_3));
                break;
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    //    -------------   ReceiptView method start   -------------
    private static void ReceiptView() {
        System.out.println("\nYou have ordered #" + itemCount + " number of items");
        System.out.println("            Pizza Hut");
        System.out.println("-------------------------------------");
        for (int i = 0; i < itemsName.size(); i++) {
            System.out.println("#" + (i+1) + " " + itemsName.get(i));
            System.out.println("          - " + itemsSizes.get(i) + " - " + prices.get(i) + " " + currencyCode);
        }
        System.out.println("\n        Total : " + total + " " + currencyCode);
        System.out.println("-------------------------------------");
        System.out.println("     Thank You For Ordering");
        System.out.println("-------------------------------------");
        System.out.println("Thank you for visiting Pizza Hut, See you next time.\n");
    }
    //    -------------   ReceiptView method end   -------------
}