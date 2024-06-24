package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static int itemCount = 0;
    static double total;
    static String currencyCode = "LKR";
    static String[] orderStep = {"first", "second", "third"};
    static ArrayList<String> itemsName = new ArrayList<String>();
    static ArrayList<String> itemsSizes = new ArrayList<String>();
    static ArrayList<String> prices = new ArrayList<String>();
    static ArrayList<String> items = new ArrayList<String>();
    static ArrayList<Double> largePrices = new ArrayList<Double>();
    static ArrayList<Double> mediumPrices = new ArrayList<Double>();
    static ArrayList<Double> smallPrices = new ArrayList<Double>();
    static ArrayList<String> descriptions = new ArrayList<String>();
    static String item;
    static String itemNumber;
    static String size1 = "Large";
    static String size2 = "Medium";
    static String size3 = "Small";
    static double price_1;
    static double price_2;
    static double price_3;

    //    -------------   Main method start   -------------
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("menuList1.json"));
            JSONObject pizzaItems = (JSONObject) obj;
            JSONArray pizzaItemsDetails = (JSONArray) pizzaItems.get("pizzaItems");

            for (int i = 0; i < pizzaItemsDetails.size(); i++) {
                JSONObject pizza = (JSONObject) pizzaItemsDetails.get(i);

                items.add((String) pizza.get("name"));
                largePrices.add((double) pizza.get("largePrice"));
                mediumPrices.add((double) pizza.get("mediumPrice"));
                smallPrices.add((double) pizza.get("smallPrice"));
                descriptions.add((String) pizza.get("description"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
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
        for (int i = 0; i < items.size(); i++) {
            System.out.println("#" + (i+1) + " " + items.get(i) + " - L " + largePrices.get(i) + " " + currencyCode + " | M " + mediumPrices.get(i) + " " + currencyCode + " | S " + smallPrices.get(i) + " " + currencyCode);
        }
    }

    //    -------------   MainMenu method start   -------------
    public static void MainMenuView() {
        while (true) {
            System.out.println("\nPizzaHut Menu\n");
            Items();
            System.out.println("\n\nPress item number to view description\nOR\nPress [0] to go back\n");

            String customerOption1 = input.nextLine();
            for (int i = 0; i < items.size(); i++) {
                if (customerOption1.equals("" + (i+1))) {
                    AddItem(i);
                } else if (customerOption1.equals("0")) {
                    HomeView();
                }
            }
            System.out.print("\nPlease enter a valid input");
        }
    }
    //    -------------   MainMenu method end   -------------

    private static void AddItem(int i) {
        System.out.println("\nName : " + items.get(i));
        System.out.println("Description : " + descriptions.get(i));
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + largePrices.get(i) + " " + currencyCode);
        System.out.println("Medium Price : " + mediumPrices.get(i) + " " + currencyCode);
        System.out.println("Small Price : " + smallPrices.get(i) + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")) {
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
        for (int i = 0; i < items.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                FirstChoice(i);
            } else if (customerOption3.equals("0")){
                MainMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        MakeOrderScreen();
    }
    //    -------------   MakeOrderScreen method end   -------------

    private static void FirstChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + items.get(i));
            System.out.println("Available options - L " + largePrices.get(i) + " " + currencyCode + " | M " + mediumPrices.get(i) + " " + currencyCode + " | S " + smallPrices.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += largePrices.get(i);
                itemsName.add(items.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices.get(i)));
                MakeOrderScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices.get(i);
                itemsName.add(items.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices.get(i)));
                MakeOrderScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices.get(i);
                itemsName.add(items.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices.get(i)));
                MakeOrderScreen1();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    public static void MakeOrderScreen1() {
        System.out.println("\nPlease select " + orderStep[1] + " item you want to buy.\n");
        Items();
        System.out.println("\nPress item number to select as " + orderStep[1] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if (customerOption3.equals("" + (i+1))) {
                SecondChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                MainMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        MakeOrderScreen1();
    }

    private static void SecondChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + items.get(i));
            System.out.println("Available options - L " + largePrices.get(i) + " " + currencyCode + " | M " + mediumPrices.get(i) + " " + currencyCode + " | S " + smallPrices.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += largePrices.get(i);
                itemsName.add(items.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices.get(i)));
                MakeOrderScreen2();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices.get(i);
                itemsName.add(items.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices.get(i)));
                MakeOrderScreen2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices.get(i);
                itemsName.add(items.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices.get(i)));
                MakeOrderScreen2();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }
    public static void MakeOrderScreen2() {
        System.out.println("\nPlease select " + orderStep[2] + " item you want to buy.\n");
        Items();
        System.out.println("\nPress item number to select as " + orderStep[2] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                ThirdChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                MainMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        MakeOrderScreen2();
    }

    private static void ThirdChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + items.get(i));
            System.out.println("Available options - L " + largePrices.get(i) + " " + currencyCode + " | M " + mediumPrices.get(i) + " " + currencyCode + " | S " + smallPrices.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += largePrices.get(i);
                itemsName.add(items.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices.get(i)));
                ReceiptView();
                System.exit(0);
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices.get(i);
                itemsName.add(items.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices.get(i)));
                ReceiptView();
                System.exit(0);
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices.get(i);
                itemsName.add(items.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices.get(i)));
                ReceiptView();
                System.exit(0);
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