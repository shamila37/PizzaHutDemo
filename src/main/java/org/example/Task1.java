package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

    static Scanner input = new Scanner(System.in);
    static int itemCount = 0;
    static double total;
    static String currencyCode = "LKR";
    static String[] orderStep = {"first", "second", "third"};
    static ArrayList<String> itemsName = new ArrayList<String>();
    static String[] prices = {"", "", "", ""};
    static String[] items = {"", "", "", ""};
    static double[] price = new double[4];
    static String[] descriptions = {"", "", "", ""};

    //    -------------   Main method start   -------------
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("menuList.json"));
            JSONObject pizzaItems = (JSONObject) obj;
            JSONArray pizzaItemsDetails = (JSONArray) pizzaItems.get("pizzaItems");

            for (int i = 0; i < 4; i++) {
                JSONObject pizza = (JSONObject) pizzaItemsDetails.get(i);
                items[i] = (String) pizza.get("name");
                price[i] = (double) pizza.get("price");
                descriptions[i] = (String) pizza.get("description");
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
        System.out.println("#1 " + items[0] + " - " + price[0] + " " + currencyCode);
        System.out.println("#2 " + items[1] + " - " + price[1] + " " + currencyCode);
        System.out.println("#3 " + items[2] + " - " + price[2] + " " + currencyCode);
        System.out.println("#4 " + items[3] + " - " + price[3] + " " + currencyCode);
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
        System.out.println("\nName        : " + items[0]);
        System.out.println("Description : " + descriptions[0]);
        System.out.println("Price       : " + price[0] + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem2() {
        System.out.println("\nName        : " + items[1]);
        System.out.println("Description : " + descriptions[1]);
        System.out.println("Price       : " + price[1] + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem3() {
        System.out.println("\nName        : " + items[2]);
        System.out.println("Description : " + descriptions[2]);
        System.out.println("Price       : " + price[2] + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem4() {
        System.out.println("\nName        : " + items[3]);
        System.out.println("Description : " + descriptions[3]);
        System.out.println("Price       : " + price[3] + " " + currencyCode);
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
                total += price[0];
                itemsName.add(items[0]);
                prices[0] = String.valueOf(price[0]);
                Choice();
            }
            case "2" -> {
                itemCount += 1;
                total += price[1];
                itemsName.add(items[1]);
                prices[0] = String.valueOf(price[1]);
                Choice();
            }
            case "3" -> {
                itemCount += 1;
                total += price[2];
                itemsName.add(items[2]);
                prices[0] = String.valueOf(price[2]);
                Choice();
            }
            case "4" -> {
                itemCount += 1;
                total += price[3];
                itemsName.add(items[3]);
                prices[0] = String.valueOf(price[3]);
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
                    total += price[0];
                    itemsName.add(items[0]);
                    prices[i] = String.valueOf(price[0]);
                }
                case "2" -> {
                    itemCount += 1;
                    total += price[1];
                    itemsName.add(items[1]);
                    prices[i] = String.valueOf(price[1]);
                }
                case "3" -> {
                    itemCount += 1;
                    total += price[2];
                    itemsName.add(items[2]);
                    prices[i] = String.valueOf(price[2]);
                }
                case "4" -> {
                    itemCount += 1;
                    total += price[3];
                    itemsName.add(items[3]);
                    prices[i] = String.valueOf(price[3]);
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