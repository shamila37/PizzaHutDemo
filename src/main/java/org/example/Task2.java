package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
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
    static String[] items = {"", "", "", ""};
    static double[] largePrices = new double[4];
    static double[] mediumPrices =  new double[4];
    static double[] smallPrices =  new double[4];
    static String[] descriptions = {"", "", "", ""};
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

            for (int i = 0; i < 4; i++) {
                JSONObject pizza = (JSONObject) pizzaItemsDetails.get(i);

                items[i] = (String) pizza.get("name");
                largePrices[i] = (double) pizza.get("largePrice");
                mediumPrices[i] = (double) pizza.get("mediumPrice");
                smallPrices[i] = (double) pizza.get("smallPrice");
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
        System.out.println("#1 " + items[0] + " - L " + largePrices[0] + " " + currencyCode + " | M " + mediumPrices[0] + " " + currencyCode + " | S " + smallPrices[0] + " " + currencyCode);
        System.out.println("#2 " + items[1] + " - L " + largePrices[1] + " " + currencyCode + " | M " + mediumPrices[1] + " " + currencyCode + " | S " + smallPrices[1] + " " + currencyCode);
        System.out.println("#3 " + items[2] + " - L " + largePrices[2] + " " + currencyCode + " | M " + mediumPrices[2] + " " + currencyCode + " | S " + smallPrices[2] + " " + currencyCode);
        System.out.println("#4 " + items[3] + " - L " + largePrices[3] + " " + currencyCode + " | M " + mediumPrices[3] + " " + currencyCode + " | S " + smallPrices[3] + " " + currencyCode);
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
        System.out.println("\nName : " + items[0]);
        System.out.println("Description : " + descriptions[0]);
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + largePrices[0] + " " + currencyCode);
        System.out.println("Medium Price : " + mediumPrices[0] + " " + currencyCode);
        System.out.println("Small Price : " + smallPrices[0] + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem2() {
        System.out.println("\nName : " + items[1]);
        System.out.println("Description : " + descriptions[1]);
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + largePrices[1] + " " + currencyCode);
        System.out.println("Medium Price : " + mediumPrices[1] + " " + currencyCode);
        System.out.println("Small Price : " + smallPrices[1] + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem3() {
        System.out.println("\nName : " + items[2]);
        System.out.println("Description : " + descriptions[2]);
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + largePrices[2] + " " + currencyCode);
        System.out.println("Medium Price : " + mediumPrices[2] + " " + currencyCode);
        System.out.println("Small Price : " + smallPrices[2] + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")){
            MainMenuView();
        }
    }

    private static void AddItem4() {
        System.out.println("\nName : " + items[3]);
        System.out.println("Description : " + descriptions[3]);
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + largePrices[3] + " " + currencyCode);
        System.out.println("Medium Price : " + mediumPrices[3] + " " + currencyCode);
        System.out.println("Small Price : " + smallPrices[3] + " " + currencyCode);
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
            System.out.println("\nYou have selected #1 " + items[0]);
            System.out.println("Available options - L " + largePrices[0] + " " + currencyCode + " | M " + mediumPrices[0] + " " + currencyCode + " | S " + smallPrices[0]);
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();

            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += largePrices[0];
                itemsName.add(items[0]);
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices[0]));
                MakeOrderScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices[0];
                itemsName.add(items[0]);
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices[0]));
                MakeOrderScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices[0];
                itemsName.add(items[0]);
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices[0]));
                MakeOrderScreen1();
            } else {
                System.out.println("\nPlease enter a valid input.");
            }
        }
    }

    private static void Choice2() {
        while (true) {
        System.out.println("\nYou have selected #2 " + items[1]);
        System.out.println("Available options - L " + largePrices[1] + " " + currencyCode + " | M " + mediumPrices[1] + " " + currencyCode + " | S " + smallPrices[1]);
        System.out.println("\nPlease select a size you wish to buy.\n");
        System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

        String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")){
                itemCount += 1;
                total += largePrices[1];
                itemsName.add(items[1]);
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices[1]));
                MakeOrderScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices[1];
                itemsName.add(items[1]);
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices[1]));
                MakeOrderScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices[1];
                itemsName.add(items[1]);
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices[1]));
                MakeOrderScreen1();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void Choice3() {
        while (true) {
            System.out.println("\nYou have selected #3 " + items[2]);
            System.out.println("Available options - L " + largePrices[2] + " " + currencyCode + " | M " + mediumPrices[2] + " " + currencyCode + " | S " + smallPrices[2]);
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += largePrices[2];
                itemsName.add(items[2]);
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices[2]));
                MakeOrderScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices[2];
                itemsName.add(items[2]);
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices[2]));
                MakeOrderScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices[2];
                itemsName.add(items[2]);
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices[2]));
                MakeOrderScreen1();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void Choice4() {
        while (true) {
            System.out.println("\nYou have selected #4 " + items[3]);
            System.out.println("Available options - L " + largePrices[3] + " " + currencyCode + " | M " + mediumPrices[3] + " " + currencyCode + " | S " + smallPrices[3]);
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += largePrices[3];
                itemsName.add(items[3]);
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices[3]));
                MakeOrderScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices[3];
                itemsName.add(items[3]);
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices[3]));
                MakeOrderScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices[3];
                itemsName.add(items[3]);
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices[3]));
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
                item = items[0];
                itemNumber = "1";
                price_1 = largePrices[0];
                price_2 = mediumPrices[0];
                price_3 = smallPrices[0];
                Choice();
            } else if (customerOption3.equals("2")) {
                item = items[1];
                itemNumber = "2";
                price_1 = largePrices[1];
                price_2 = mediumPrices[1];
                price_3 = smallPrices[1];
                Choice();
            } else if (customerOption3.equals("3")) {
                item = items[2];
                itemNumber = "3";
                price_1 = largePrices[2];
                price_2 = mediumPrices[2];
                price_3 = smallPrices[2];
                Choice();
            } else if (customerOption3.equals("4")) {
                item = items[3];
                itemNumber = "4";
                price_1 = largePrices[3];
                price_2 = mediumPrices[3];
                price_3 = smallPrices[3];
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