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
    static ArrayList<String> itemChooseOrder = new ArrayList<String>();
    static String[] itemTypes = {" Cake ", " Hot Beverages ", " Pizza ", " Soft Drinks "};

    static double pizzaAddonsTotal1, pizzaAddonsTotal2, pizzaAddonsTotal3;
    static String PizzaAddon1, PizzaAddon2, PizzaAddon3;
    static ArrayList<String> PizzaItems = new ArrayList<String>();
    static ArrayList<String> pizzaName = new ArrayList<String>();
    static ArrayList<Double> pizzaPrice = new ArrayList<Double>();
    static ArrayList<String> pizzaLargeName = new ArrayList<String>();
    static ArrayList<String> pizzaLargeCode = new ArrayList<String>();
    static ArrayList<Double> pizzaLargePrice = new ArrayList<Double>();
    static ArrayList<String> pizzaMediumName = new ArrayList<String>();
    static ArrayList<String> pizzaMediumCode = new ArrayList<String>();
    static ArrayList<Double> pizzaMediumPrice = new ArrayList<Double>();
    static ArrayList<String> pizzaSmallName = new ArrayList<String>();
    static ArrayList<String> pizzaSmallCode = new ArrayList<String>();
    static ArrayList<Double> pizzaSmallPrice = new ArrayList<Double>();
    static ArrayList<String> pizzaDescriptions = new ArrayList<String>();
    static ArrayList<String> pizzaAddonsName1 = new ArrayList<String>();
    static ArrayList<String> pizzaAddonsName2 = new ArrayList<String>();
    static ArrayList<String> pizzaAddonsName3 = new ArrayList<String>();
    static ArrayList<String> pizzaAddonsPrice1 = new ArrayList<String>();
    static ArrayList<String> pizzaAddonsPrice2 = new ArrayList<String>();
    static ArrayList<String> pizzaAddonsPrice3 = new ArrayList<String>();

    static double drinkAddonsTotal1, drinkAddonsTotal2, drinkAddonsTotal3;
    static String DrinkAddon1, DrinkAddon2, DrinkAddon3;
    static ArrayList<String> DrinkItems = new ArrayList<String>();
    static ArrayList<Double> drinkPrice = new ArrayList<Double>();
    static ArrayList<String> drinkName = new ArrayList<String>();
    static ArrayList<String> drinkLargeName = new ArrayList<String>();
    static ArrayList<String> drinkLargeCode = new ArrayList<String>();
    static ArrayList<Double> drinkLargePrice = new ArrayList<Double>();
    static ArrayList<String> drinkMediumName = new ArrayList<String>();
    static ArrayList<String> drinkMediumCode = new ArrayList<String>();
    static ArrayList<Double> drinkMediumPrice = new ArrayList<Double>();
    static ArrayList<String> drinkSmallName = new ArrayList<String>();
    static ArrayList<String> drinkSmallCode = new ArrayList<String>();
    static ArrayList<Double> drinkSmallPrice = new ArrayList<Double>();
    static ArrayList<String> drinkDescriptions = new ArrayList<String>();
    static ArrayList<String> drinkAddonsName1 = new ArrayList<String>();
    static ArrayList<String> drinkAddonsName2 = new ArrayList<String>();
    static ArrayList<String> drinkAddonsName3 = new ArrayList<String>();
    static ArrayList<String> drinkAddonsPrice1 = new ArrayList<String>();
    static ArrayList<String> drinkAddonsPrice2 = new ArrayList<String>();
    static ArrayList<String> drinkAddonsPrice3 = new ArrayList<String>();

    static double beverageAddonsTotal1, beverageAddonsTotal2, beverageAddonsTotal3;
    static String BeverageAddon1, BeverageAddon2, BeverageAddon3;
    static ArrayList<String> BeverageItems = new ArrayList<String>();
    static ArrayList<Double> beveragePrice = new ArrayList<Double>();
    static ArrayList<String> beverageName = new ArrayList<String>();
    static ArrayList<String> beverageLargeName = new ArrayList<String>();
    static ArrayList<String> beverageLargeCode = new ArrayList<String>();
    static ArrayList<Double> beverageLargePrice = new ArrayList<Double>();
    static ArrayList<String> beverageRegularName = new ArrayList<String>();
    static ArrayList<String> beverageRegularCode = new ArrayList<String>();
    static ArrayList<Double> beverageRegularPrice = new ArrayList<Double>();
    static ArrayList<String> beverageSmallName = new ArrayList<String>();
    static ArrayList<String> beverageSmallCode = new ArrayList<String>();
    static ArrayList<Double> beverageSmallPrice = new ArrayList<Double>();
    static ArrayList<String> beverageDescriptions = new ArrayList<String>();
    static ArrayList<String> beverageAddonsName1 = new ArrayList<String>();
    static ArrayList<String> beverageAddonsName2 = new ArrayList<String>();
    static ArrayList<String> beverageAddonsName3 = new ArrayList<String>();
    static ArrayList<String> beverageAddonsPrice1 = new ArrayList<String>();
    static ArrayList<String> beverageAddonsPrice2 = new ArrayList<String>();
    static ArrayList<String> beverageAddonsPrice3 = new ArrayList<String>();

    static String size1 = "Large";
    static String size2 = "Medium";
    static String size3 = "Small";
    static String size4 = "Regular";

    //    -------------   Main method start   -------------
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("pizzaMenuList.json"));
            JSONObject pizzaItems = (JSONObject) obj;
            JSONArray pizzaItemsDetails = (JSONArray) pizzaItems.get("pizzaItems");

            for (int i = 0; i < pizzaItemsDetails.size(); i++) {
                JSONObject pizza = (JSONObject) pizzaItemsDetails.get(i);

                PizzaItems.add((String) pizza.get("name"));

                JSONObject large = (JSONObject) pizza.get("large");
                pizzaLargeName.add((String) large.get("name"));
                pizzaLargeCode.add((String) large.get("code"));
                pizzaLargePrice.add((double) large.get("price"));

                JSONObject medium = (JSONObject) pizza.get("medium");
                pizzaMediumName.add((String) medium.get("name"));
                pizzaMediumCode.add((String) medium.get("code"));
                pizzaMediumPrice.add((double) medium.get("price"));

                JSONObject small = (JSONObject) pizza.get("small");
                pizzaSmallName.add((String) small.get("name"));
                pizzaSmallCode.add((String) small.get("code"));
                pizzaSmallPrice.add((double) small.get("price"));

                pizzaDescriptions.add((String) pizza.get("description"));
            }

            Object obj1 = parser.parse(new FileReader("pizzaAddons.json"));
            JSONObject addonsItems = (JSONObject) obj1;
            JSONArray addonsItemsDetails = (JSONArray) addonsItems.get("pizzaAddons");

            for (int i = 0; i < addonsItemsDetails.size(); i++) {
                JSONObject addons = (JSONObject) addonsItemsDetails.get(i);

                pizzaName.add((String) addons.get("name"));
                pizzaPrice.add((double) addons.get("price"));
            }

            Object obj2 = parser.parse(new FileReader("softDrinksMenuList.json"));
            JSONObject drinkItems = (JSONObject) obj2;
            JSONArray drinkItemsDetails = (JSONArray) drinkItems.get("softDrinksItems");

            for (int i = 0; i < drinkItemsDetails.size(); i++) {
                JSONObject drinks = (JSONObject) drinkItemsDetails.get(i);

                DrinkItems.add((String) drinks.get("name"));

                JSONObject large = (JSONObject) drinks.get("large");
                drinkLargeName.add((String) large.get("name"));
                drinkLargeCode.add((String) large.get("code"));
                drinkLargePrice.add((double) large.get("price"));

                JSONObject medium = (JSONObject) drinks.get("medium");
                drinkMediumName.add((String) medium.get("name"));
                drinkMediumCode.add((String) medium.get("code"));
                drinkMediumPrice.add((double) medium.get("price"));

                JSONObject small = (JSONObject) drinks.get("small");
                drinkSmallName.add((String) small.get("name"));
                drinkSmallCode.add((String) small.get("code"));
                drinkSmallPrice.add((double) small.get("price"));

                drinkDescriptions.add((String) drinks.get("description"));
            }

            Object obj3 = parser.parse(new FileReader("softDrinksAddons.json"));
            JSONObject drinkAddonsItems = (JSONObject) obj3;
            JSONArray drinkAddonsItemsDetails = (JSONArray) drinkAddonsItems.get("softDrinksAddons");

            for (int i = 0; i < drinkAddonsItemsDetails.size(); i++) {
                JSONObject drinkAddons = (JSONObject) drinkAddonsItemsDetails.get(i);

                drinkName.add((String) drinkAddons.get("name"));
                drinkPrice.add((double) drinkAddons.get("price"));
            }

            Object obj4 = parser.parse(new FileReader("hotBeveragesMenuList.json"));
            JSONObject beverageItems = (JSONObject) obj4;
            JSONArray beverageItemsDetails = (JSONArray) beverageItems.get("hotBeveragesItems");

            for (int i = 0; i < beverageItemsDetails.size(); i++) {
                JSONObject beverages = (JSONObject) beverageItemsDetails.get(i);

                BeverageItems.add((String) beverages.get("name"));

                JSONObject large = (JSONObject) beverages.get("large");
                if (large == null){
                    beverageLargeName.add("");
                    beverageLargeCode.add("");
                    beverageLargePrice.add(0.0);
                } else {
                    beverageLargeName.add((String) large.get("name"));
                    beverageLargeCode.add((String) large.get("code"));
                    beverageLargePrice.add((double) large.get("price"));
                }

                JSONObject regular = (JSONObject) beverages.get("regular");
                if (regular== null) {
                    beverageRegularName.add("");
                    beverageRegularCode.add("");
                    beverageRegularPrice.add(0.0);
                } else {
                    beverageRegularName.add((String) regular.get("name"));
                    beverageRegularCode.add((String) regular.get("code"));
                    beverageRegularPrice.add((double) regular.get("price"));
                }

                JSONObject small = (JSONObject) beverages.get("small");
                if (small == null) {
                    beverageSmallName.add("");
                    beverageSmallCode.add("");
                    beverageSmallPrice.add(0.0);
                } else {
                    beverageSmallName.add((String) small.get("name"));
                    beverageSmallCode.add((String) small.get("code"));
                    beverageSmallPrice.add((double) small.get("price"));
                }

                beverageDescriptions.add((String) beverages.get("description"));
            }

            Object obj5 = parser.parse(new FileReader("hotBeveragesAddons.json"));
            JSONObject beverageAddonsItems = (JSONObject) obj5;
            JSONArray beverageAddonsItemsDetails = (JSONArray) beverageAddonsItems.get("hotBeveragesAddons");

            for (int i = 0; i < beverageAddonsItemsDetails.size(); i++) {
                JSONObject beverageAddons = (JSONObject) beverageAddonsItemsDetails.get(i);

                beverageName.add((String) beverageAddons.get("name"));
                beveragePrice.add((double) beverageAddons.get("price"));
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
        System.out.println("\nCheck out our new items!\n");
        System.out.println("To View our Pizza menu, press [1]");
        System.out.println("To View our Soft Drinks menu, press [2]");
        System.out.println("To View our Hot Beverages menu, press [3]");
        System.out.println("To View our Cakes menu, press [4]");
        System.out.println("To place an Order, press [6]");
        System.out.println("Press [x] to exit the store\n");

        while(true) {
            String customerOption = input.nextLine();
            switch (customerOption) {
                case "1" -> PizzaMenuView();
                case "2" -> DrinkMenuView();
                case "3" -> HotBeveragesMenuView();
//                case "4" -> CakesMenuView();
                case "6" -> MainMakeOrderScreen();
                case "x" -> {
                    System.out.println("\nThank you for visiting Pizza Hut, See you next time.\n");
                    System.exit(0);
                }
                default -> {
                    System.out.println("\nPlease enter valid option from bellow");
                    System.out.println("To View our Pizza menu, press [1]");
                    System.out.println("To View our Soft Drinks menu, press [2]");
                    System.out.println("To View our Hot Beverages menu, press [3]");
                    System.out.println("To View our Cakes menu, press [4]");
                    System.out.println("To place an Order, press [6]\n");
                }
            }
        }
    }
    //    -------------   HomeView method end   -------------

    private static void PizzasItems() {
        for (int i = 0; i < PizzaItems.size(); i++) {
            System.out.println("#" + (i+1) + " " + PizzaItems.get(i) + " - L " + pizzaLargePrice.get(i) + " " + currencyCode + " | M " + pizzaMediumPrice.get(i) + " " + currencyCode + " | S " + pizzaSmallPrice.get(i) + " " + currencyCode);
        }
    }

    //    -------------   PizzaMenu method start   -------------
    public static void PizzaMenuView() {
        while (true) {
            System.out.println("\nPizzaHut Menu\n");
            PizzasItems();
            System.out.println("\n\nPress item number to view description\nOR\nPress [0] to go back\n");

            String customerOption1 = input.nextLine();
            for (int i = 0; i < PizzaItems.size(); i++) {
                if (customerOption1.equals("" + (i+1))) {
                    PizzaAddItem(i);
                } else if (customerOption1.equals("0")) {
                    HomeView();
                }
            }
            System.out.print("\nPlease enter a valid input");
        }
    }
    //    -------------   PizzaMenu method end   -------------

    private static void DrinkItems() {
        for (int i = 0; i < DrinkItems.size(); i++) {
            System.out.println("#" + (i+1) + " " + DrinkItems.get(i) + " - L " + drinkLargePrice.get(i) + " " + currencyCode + " | M " + drinkMediumPrice.get(i) + " " + currencyCode + " | S " + drinkSmallPrice.get(i) + " " + currencyCode);
        }
    }

    //    -------------   SoftDrinkMenu method start   -------------
    private static void DrinkMenuView() {
        while (true) {
            System.out.println("\nSoft Drinks Menu\n");
            DrinkItems();
            System.out.println("\n\nPress item number to view description\nOR\nPress [0] to go back\n");

            String customerOption1 = input.nextLine();
            for (int i = 0; i < DrinkItems.size(); i++) {
                if (customerOption1.equals("" + (i+1))) {
                    DrinksAddItem(i);
                } else if (customerOption1.equals("0")) {
                    HomeView();
                }
            }
            System.out.print("\nPlease enter a valid input");
        }
    }
    //    -------------   SoftDrinkMenu method end   -------------

    private static void BeverageItems() {
        for (int i = 0; i < BeverageItems.size(); i++) {
            System.out.println("#" + (i+1) + " " + BeverageItems.get(i) + " - L " + beverageLargePrice.get(i) + " " + currencyCode + " | R " + beverageRegularPrice.get(i) + " " + currencyCode + " | S " + beverageSmallPrice.get(i) + " " + currencyCode);
        }
    }

    //    -------------   BeveragesMenu method start   -------------
    private static void HotBeveragesMenuView() {
        while (true) {
            System.out.println("\nHot Beverages Menu\n");
            BeverageItems();
            System.out.println("\n\nPress item number to view description\nOR\nPress [0] to go back\n");

            String customerOption1 = input.nextLine();
            for (int i = 0; i < BeverageItems.size(); i++) {
                if (customerOption1.equals("" + (i+1))) {
                    BeveragesAddItem(i);
                } else if (customerOption1.equals("0")) {
                    HomeView();
                }
            }
            System.out.print("\nPlease enter a valid input");
        }
    }
    //    -------------   BeveragesMenu method end   -------------

    private static void PizzaAddItem(int i) {
        System.out.println("\nName : " + PizzaItems.get(i));
        System.out.println("Description : " + pizzaDescriptions.get(i));
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + pizzaLargePrice.get(i) + " " + currencyCode);
        System.out.println("Medium Price : " + pizzaMediumPrice.get(i) + " " + currencyCode);
        System.out.println("Small Price : " + pizzaSmallPrice.get(i) + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")) {
            PizzaMenuView();
        }
    }

    private static void DrinksAddItem(int i) {
        System.out.println("\nName : " + DrinkItems.get(i));
        System.out.println("Description : " + drinkDescriptions.get(i));
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + drinkLargePrice.get(i) + " " + currencyCode);
        System.out.println("Medium Price : " + drinkMediumPrice.get(i) + " " + currencyCode);
        System.out.println("Small Price : " + drinkSmallPrice.get(i) + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")) {
            DrinkMenuView();
        }
    }

    private static void BeveragesAddItem(int i) {
        System.out.println("\nName : " + BeverageItems.get(i));
        System.out.println("Description : " + beverageDescriptions.get(i));
        System.out.println("Available Sizes : Large | Regular | Small");
        System.out.println("Large Price : " + beverageLargePrice.get(i) + " " + currencyCode);
        System.out.println("Regular Price : " + beverageRegularPrice.get(i) + " " + currencyCode);
        System.out.println("Small Price : " + beverageSmallPrice.get(i) + " " + currencyCode);
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")) {
            HotBeveragesMenuView();
        }
    }

    //    -------------   MainMakeOrderScreen method start   -------------
    public static void MainMakeOrderScreen() {
        System.out.println("\nYou can buy 3 items.");
        System.out.println("Please select " + orderStep[0] + " item you want to buy.\n");
        System.out.println("Select Sub Menu\n");
        System.out.println("#1 - Cake Menu");
        System.out.println("#2 - Hot Beverages Menu");
        System.out.println("#3 - Pizza Menu");
        System.out.println("#4 - Soft Drinks Menu");
        System.out.println("\nPress item number to select Sub Menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < 4; i++) {
            if (customerOption3.equals("1")){
                itemChooseOrder.add(itemTypes[0]);
//                CakeMakeOrderScreen1();
            } else if (customerOption3.equals("2")){
                itemChooseOrder.add(itemTypes[1]);
                HotBeverageMakeOrderScreen1();
            } else if (customerOption3.equals("3")){
                PizzaMakeOrderScreen1();
            } else if (customerOption3.equals("4")){
                DrinkMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        MainMakeOrderScreen();
    }
    //    -------------   MainMakeOrderScreen method end   -------------

    //    -------------   PizzaMakeOrderScreen1 method start   -------------
    public static void PizzaMakeOrderScreen1() {
        System.out.println("\nPlease select an Item from our Pizza Menu\n");
        PizzasItems();
        System.out.println("\n\nPress item number to select " + orderStep[0] + " item\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < PizzaItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                itemChooseOrder.add(itemTypes[2]);
                PizzaFirstChoice(i);
            } else if (customerOption3.equals("0")){
                PizzaMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        PizzaMakeOrderScreen1();
    }
    //    -------------   PizzaMakeOrderScreen1 method end   -------------

    //    -------------   DrinkMakeOrderScreen1 method start   -------------
    public static void DrinkMakeOrderScreen1() {
        System.out.println("\nPlease select an Item from our Drink Menu\n");
        DrinkItems();
        System.out.println("\n\nPress item number to select " + orderStep[0] + " item\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < DrinkItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                itemChooseOrder.add(itemTypes[3]);
                DrinkFirstChoice(i);
            } else if (customerOption3.equals("0")){
                DrinkMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkMakeOrderScreen1();
    }
    //    -------------   DrinkMakeOrderScreen1 method end   -------------

    //    -------------   HotBeverageMakeOrderScreen1 method start   -------------
    public static void HotBeverageMakeOrderScreen1() {
        System.out.println("\nPlease select an Item from our Hot Beverages Menu\n");
        BeverageItems();
        System.out.println("\n\nPress item number to select " + orderStep[0] + " item\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < BeverageItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                itemChooseOrder.add(itemTypes[3]);
                BeverageFirstChoice(i);
            } else if (customerOption3.equals("0")){
                HotBeveragesMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        HotBeverageMakeOrderScreen1();
    }
    //    -------------   HotBeverageMakeOrderScreen1 method end   -------------

    private static void PizzaFirstChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + PizzaItems.get(i));
            System.out.println("Available options - L " + pizzaLargePrice.get(i) + " " + currencyCode + " | M " + pizzaMediumPrice.get(i) + " " + currencyCode + " | S " + pizzaSmallPrice.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select Small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += pizzaLargePrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(pizzaLargePrice.get(i)));
                PizzaCustomizationList();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += pizzaMediumPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(pizzaMediumPrice.get(i)));
                PizzaCustomizationList();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += pizzaSmallPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(pizzaSmallPrice.get(i)));
                PizzaCustomizationList();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void DrinkFirstChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + DrinkItems.get(i));
            System.out.println("Available options - L " + drinkLargePrice.get(i) + " " + currencyCode + " | M " + drinkMediumPrice.get(i) + " " + currencyCode + " | S " + drinkSmallPrice.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select Small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += drinkLargePrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(drinkLargePrice.get(i)));
                DrinkCustomizationList();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += drinkMediumPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(drinkMediumPrice.get(i)));
                DrinkCustomizationList();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += drinkSmallPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(drinkSmallPrice.get(i)));
                DrinkCustomizationList();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void BeverageFirstChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + BeverageItems.get(i));
            System.out.println("Available options - L " + beverageLargePrice.get(i) + " " + currencyCode + " | R " + beverageRegularPrice.get(i) + " " + currencyCode + " | S " + beverageSmallPrice.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [R] to select Regular\nPress [S] to select Small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += beverageLargePrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(beverageLargePrice.get(i)));
                BeverageCustomizationList();
            } else if (customerOption4.equals("R")) {
                itemCount += 1;
                total += beverageRegularPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(size4);
                prices.add(String.valueOf(beverageRegularPrice.get(i)));
                BeverageCustomizationList();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += beverageSmallPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(beverageSmallPrice.get(i)));
                BeverageCustomizationList();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void PizzaAddons() {
        for (int j = 0; j < pizzaName.size(); j++) {
            System.out.println("#" + (j + 1) + " Add " + pizzaName.get(j) + " - " + pizzaPrice.get(j) + " " + currencyCode);
        }
    }

    private static void DrinkAddons() {
        for (int j = 0; j < drinkName.size(); j++) {
            System.out.println("#" + (j + 1) + " Add " + drinkName.get(j) + " - " + drinkPrice.get(j) + " " + currencyCode);
        }
    }

    private static void BeverageAddons() {
        for (int j = 0; j < beverageName.size(); j++) {
            System.out.println("#" + (j + 1) + " Add " + beverageName.get(j) + " - " + beveragePrice.get(j) + " " + currencyCode);
        }
    }

    private static void PizzaCustomizationList() {
        System.out.println("\nPlease select an addon you want to add.\n");
        PizzaAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                pizzaAddonsTotal1 += pizzaPrice.get(j);
                pizzaAddonsName1.add(pizzaName.get(j));
                pizzaAddonsPrice1.add(String.valueOf(pizzaPrice.get(j)));
                PizzaAddon1 = "one";
                PizzaCustomizationList1();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        PizzaCustomizationList();
    }

    private static void DrinkCustomizationList() {
        System.out.println("\nPlease select an addon you want to add.\n");
        DrinkAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < drinkName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                drinkAddonsTotal1 += drinkPrice.get(j);
                drinkAddonsName1.add(drinkName.get(j));
                drinkAddonsPrice1.add(String.valueOf(drinkPrice.get(j)));
                DrinkAddon1 = "one";
                DrinkCustomizationList1();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkCustomizationList();
    }

    private static void BeverageCustomizationList() {
        System.out.println("\nPlease select an addon you want to add.\n");
        BeverageAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < beverageName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                beverageAddonsTotal1 += beveragePrice.get(j);
                beverageAddonsName1.add(beverageName.get(j));
                beverageAddonsPrice1.add(String.valueOf(beveragePrice.get(j)));
                BeverageAddon1 = "one";
                BeverageCustomizationList1();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        BeverageCustomizationList();
    }

    private static void PizzaCustomizationList1() {
        System.out.println("\nDo you want to add another addon.\n");
        PizzaAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                pizzaAddonsTotal1 += pizzaPrice.get(j);
                pizzaAddonsName1.add(pizzaName.get(j));
                pizzaAddonsPrice1.add(String.valueOf(pizzaPrice.get(j)));
                PizzaCustomizationList1();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        PizzaCustomizationList1();
    }

    private static void DrinkCustomizationList1() {
        System.out.println("\nDo you want to add another addon.\n");
        DrinkAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < drinkName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                drinkAddonsTotal1 += drinkPrice.get(j);
                drinkAddonsName1.add(drinkName.get(j));
                drinkAddonsPrice1.add(String.valueOf(drinkPrice.get(j)));
                DrinkCustomizationList1();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkCustomizationList1();
    }

    private static void BeverageCustomizationList1() {
        System.out.println("\nDo you want to add another addon.\n");
        BeverageAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < beverageName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                beverageAddonsTotal1 += beveragePrice.get(j);
                beverageAddonsName1.add(beverageName.get(j));
                beverageAddonsPrice1.add(String.valueOf(beveragePrice.get(j)));
                BeverageCustomizationList1();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        BeverageCustomizationList1();
    }

    //    -------------   MainMakeOrderScreen1 method start   -------------
    public static void MainMakeOrderScreen1() {
        System.out.println("\nPlease select " + orderStep[1] + " item you want to buy.\n");
        System.out.println("Select Sub Menu\n");
        System.out.println("#1 - Cake Menu");
        System.out.println("#2 - Hot Beverages Menu");
        System.out.println("#3 - Pizza Menu");
        System.out.println("#4 - Soft Drinks Menu");
        System.out.println("\nPress item number to select Sub Menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < 4; i++) {
            if (customerOption3.equals("1")){
                itemChooseOrder.add(itemTypes[0]);
//                CakeMakeOrderScreen2();
            } else if (customerOption3.equals("2")){
                itemChooseOrder.add(itemTypes[1]);
                HotBeverageMakeOrderScreen2();
            } else if (customerOption3.equals("3")){
                PizzaMakeOrderScreen2();
            } else if (customerOption3.equals("4")){
                DrinkMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        MainMakeOrderScreen1();
    }
    //    -------------   MainMakeOrderScreen1 method end   -------------

    public static void PizzaMakeOrderScreen2() {
        System.out.println("\nPlease select an Item from our Pizza Menu\n");
        PizzasItems();
        System.out.println("\nPress item number to select as " + orderStep[1] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < PizzaItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))) {
                itemChooseOrder.add(itemTypes[2]);
                PizzaSecondChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                PizzaMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        PizzaMakeOrderScreen2();
    }

    public static void DrinkMakeOrderScreen2() {
        System.out.println("\nPlease select an Item from our Drink Menu\n");
        DrinkItems();
        System.out.println("\nPress item number to select as " + orderStep[1] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < DrinkItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))) {
                itemChooseOrder.add(itemTypes[3]);
                DrinkSecondChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                DrinkMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkMakeOrderScreen2();
    }

    public static void HotBeverageMakeOrderScreen2() {
        System.out.println("\nPlease select an Item from our Hot Beverages Menu\n");
        BeverageItems();
        System.out.println("\nPress item number to select as " + orderStep[1] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < BeverageItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))) {
                itemChooseOrder.add(itemTypes[3]);
                BeverageSecondChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                HotBeveragesMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        HotBeverageMakeOrderScreen2();
    }

    private static void PizzaSecondChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + PizzaItems.get(i));
            System.out.println("Available options - L " + pizzaLargePrice.get(i) + " " + currencyCode + " | M " + pizzaMediumPrice.get(i) + " " + currencyCode + " | S " + pizzaSmallPrice.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += pizzaLargePrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(pizzaLargePrice.get(i)));
                PizzaCustomizationList2();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += pizzaMediumPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(pizzaMediumPrice.get(i)));
                PizzaCustomizationList2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += pizzaSmallPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(pizzaSmallPrice.get(i)));
                PizzaCustomizationList2();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void DrinkSecondChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + DrinkItems.get(i));
            System.out.println("Available options - L " + drinkLargePrice.get(i) + " " + currencyCode + " | M " + drinkMediumPrice.get(i) + " " + currencyCode + " | S " + drinkSmallPrice.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += drinkLargePrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(drinkLargePrice.get(i)));
                DrinkCustomizationList2();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += drinkMediumPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(drinkMediumPrice.get(i)));
                DrinkCustomizationList2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += drinkSmallPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(drinkSmallPrice.get(i)));
                DrinkCustomizationList2();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void BeverageSecondChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + BeverageItems.get(i));
            System.out.println("Available options - L " + beverageLargePrice.get(i) + " " + currencyCode + " | R " + beverageRegularPrice.get(i) + " " + currencyCode + " | S " + beverageSmallPrice.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [R] to select Regular\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += beverageLargePrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(beverageLargePrice.get(i)));
                BeverageCustomizationList2();
            } else if (customerOption4.equals("R")) {
                itemCount += 1;
                total += beverageRegularPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(size4);
                prices.add(String.valueOf(beverageRegularPrice.get(i)));
                BeverageCustomizationList2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += beverageSmallPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(beverageSmallPrice.get(i)));
                BeverageCustomizationList2();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void PizzaCustomizationList2() {
        System.out.println("\nPlease select an addon you want to add.\n");
        PizzaAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                pizzaAddonsTotal2 += pizzaPrice.get(j);
                pizzaAddonsName2.add(pizzaName.get(j));
                pizzaAddonsPrice2.add(String.valueOf(pizzaPrice.get(j)));
                PizzaAddon2 = "two";
                PizzaCustomizationList3();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        PizzaCustomizationList2();
    }

    private static void DrinkCustomizationList2() {
        System.out.println("\nPlease select an addon you want to add.\n");
        DrinkAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < drinkName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                drinkAddonsTotal2 += drinkPrice.get(j);
                drinkAddonsName2.add(drinkName.get(j));
                drinkAddonsPrice2.add(String.valueOf(drinkPrice.get(j)));
                DrinkAddon2 = "two";
                DrinkCustomizationList3();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkCustomizationList2();
    }

    private static void BeverageCustomizationList2() {
        System.out.println("\nPlease select an addon you want to add.\n");
        BeverageAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < beverageName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                beverageAddonsTotal2 += beveragePrice.get(j);
                beverageAddonsName2.add(beverageName.get(j));
                beverageAddonsPrice2.add(String.valueOf(beveragePrice.get(j)));
                BeverageAddon2 = "two";
                BeverageCustomizationList3();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        BeverageCustomizationList2();
    }

    private static void PizzaCustomizationList3() {
        System.out.println("\nDo you want to add another addon.\n");
        PizzaAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                pizzaAddonsTotal2 += pizzaPrice.get(j);
                pizzaAddonsName2.add(pizzaName.get(j));
                pizzaAddonsPrice2.add(String.valueOf(pizzaPrice.get(j)));
                PizzaCustomizationList3();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        PizzaCustomizationList3();
    }

    private static void DrinkCustomizationList3() {
        System.out.println("\nDo you want to add another addon.\n");
        DrinkAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < drinkName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                drinkAddonsTotal2 += drinkPrice.get(j);
                drinkAddonsName2.add(drinkName.get(j));
                drinkAddonsPrice2.add(String.valueOf(drinkPrice.get(j)));
                DrinkCustomizationList3();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkCustomizationList3();
    }

    private static void BeverageCustomizationList3() {
        System.out.println("\nDo you want to add another addon.\n");
        BeverageAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < beverageName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                beverageAddonsTotal2 += beveragePrice.get(j);
                beverageAddonsName2.add(beverageName.get(j));
                beverageAddonsPrice2.add(String.valueOf(beveragePrice.get(j)));
                BeverageCustomizationList3();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        BeverageCustomizationList3();
    }

    //    -------------   MainMakeOrderScreen2 method start   -------------
    public static void MainMakeOrderScreen2() {
        System.out.println("\nPlease select " + orderStep[2] + " item you want to buy.\n");
        System.out.println("Select Sub Menu\n");
        System.out.println("#1 - Cake Menu");
        System.out.println("#2 - Hot Beverages Menu");
        System.out.println("#3 - Pizza Menu");
        System.out.println("#4 - Soft Drinks Menu");
        System.out.println("\nPress item number to select Sub Menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < 4; i++) {
            if (customerOption3.equals("1")){
                itemChooseOrder.add(itemTypes[0]);
//                CakeMakeOrderScreen3();
            } else if (customerOption3.equals("2")){
                itemChooseOrder.add(itemTypes[1]);
                HotBeverageMakeOrderScreen3();
            } else if (customerOption3.equals("3")){
                PizzaMakeOrderScreen3();
            } else if (customerOption3.equals("4")){
                DrinkMakeOrderScreen3();
            }
        }
        System.out.print("\nPlease enter a valid input");
        MainMakeOrderScreen2();
    }
    //    -------------   MainMakeOrderScreen2 method end   -------------

    public static void PizzaMakeOrderScreen3() {
        System.out.println("\nPlease select an Item from our Pizza Menu\n");
        PizzasItems();
        System.out.println("\nPress item number to select as " + orderStep[2] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < PizzaItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                itemChooseOrder.add(itemTypes[2]);
                PizzaThirdChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                PizzaMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        PizzaMakeOrderScreen3();
    }

    public static void DrinkMakeOrderScreen3() {
        System.out.println("\nPlease select an Item from our Drink Menu\n");
        DrinkItems();
        System.out.println("\nPress item number to select as " + orderStep[2] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < DrinkItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                itemChooseOrder.add(itemTypes[3]);
                DrinkThirdChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                DrinkMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkMakeOrderScreen3();
    }

    public static void HotBeverageMakeOrderScreen3() {
        System.out.println("\nPlease select an Item from our Hot Beverages Menu\n");
        BeverageItems();
        System.out.println("\nPress item number to select as " + orderStep[2] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < BeverageItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                itemChooseOrder.add(itemTypes[3]);
                BeverageThirdChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                HotBeveragesMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        HotBeverageMakeOrderScreen3();
    }

    private static void PizzaThirdChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + PizzaItems.get(i));
            System.out.println("Available options - L " + pizzaLargePrice.get(i) + " " + currencyCode + " | M " + pizzaMediumPrice.get(i) + " " + currencyCode + " | S " + pizzaSmallPrice.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += pizzaLargePrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(pizzaLargePrice.get(i)));
                PizzaCustomizationList4();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += pizzaMediumPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(pizzaMediumPrice.get(i)));
                PizzaCustomizationList4();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += pizzaSmallPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(pizzaSmallPrice.get(i)));
                PizzaCustomizationList4();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void DrinkThirdChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + DrinkItems.get(i));
            System.out.println("Available options - L " + drinkLargePrice.get(i) + " " + currencyCode + " | M " + drinkMediumPrice.get(i) + " " + currencyCode + " | S " + drinkSmallPrice.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += drinkLargePrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(drinkLargePrice.get(i)));
                DrinkCustomizationList4();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += drinkMediumPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(drinkMediumPrice.get(i)));
                DrinkCustomizationList4();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += drinkSmallPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(drinkSmallPrice.get(i)));
                DrinkCustomizationList4();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void BeverageThirdChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + BeverageItems.get(i));
            System.out.println("Available options - L " + beverageLargePrice.get(i) + " " + currencyCode + " | M " + beverageRegularPrice.get(i) + " " + currencyCode + " | S " + beverageSmallPrice.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [R] to select Regular\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += beverageLargePrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(beverageLargePrice.get(i)));
                BeverageCustomizationList4();
            } else if (customerOption4.equals("R")) {
                itemCount += 1;
                total += beverageRegularPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(size4);
                prices.add(String.valueOf(beverageRegularPrice.get(i)));
                BeverageCustomizationList4();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += beverageSmallPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(beverageSmallPrice.get(i)));
                BeverageCustomizationList4();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void PizzaCustomizationList4() {
        System.out.println("\nPlease select an addon you want to add.\n");
        PizzaAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                pizzaAddonsTotal3 += pizzaPrice.get(j);
                pizzaAddonsName3.add(pizzaName.get(j));
                pizzaAddonsPrice3.add(String.valueOf(pizzaPrice.get(j)));
                PizzaAddon3 = "three";
                PizzaCustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        PizzaCustomizationList4();
    }

    private static void DrinkCustomizationList4() {
        System.out.println("\nPlease select an addon you want to add.\n");
        DrinkAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < drinkName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                drinkAddonsTotal3 += drinkPrice.get(j);
                drinkAddonsName3.add(drinkName.get(j));
                drinkAddonsPrice3.add(String.valueOf(drinkPrice.get(j)));
                DrinkAddon3 = "three";
                DrinkCustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkCustomizationList4();
    }

    private static void BeverageCustomizationList4() {
        System.out.println("\nPlease select an addon you want to add.\n");
        BeverageAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < beverageName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                beverageAddonsTotal3 += beveragePrice.get(j);
                beverageAddonsName3.add(beverageName.get(j));
                beverageAddonsPrice3.add(String.valueOf(beveragePrice.get(j)));
                BeverageAddon3 = "three";
                BeverageCustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        BeverageCustomizationList4();
    }

    private static void PizzaCustomizationList5() {
        System.out.println("\nDo you want to add another addon.\n");
        PizzaAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                pizzaAddonsTotal3 += pizzaPrice.get(j);
                pizzaAddonsName3.add(pizzaName.get(j));
                pizzaAddonsPrice3.add(String.valueOf(pizzaPrice.get(j)));
                PizzaCustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        PizzaCustomizationList5();
    }

    private static void DrinkCustomizationList5() {
        System.out.println("\nDo you want to add another addon.\n");
        DrinkAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < drinkName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                drinkAddonsTotal3 += drinkPrice.get(j);
                drinkAddonsName3.add(drinkName.get(j));
                drinkAddonsPrice3.add(String.valueOf(drinkPrice.get(j)));
                DrinkCustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkCustomizationList5();
    }

    private static void BeverageCustomizationList5() {
        System.out.println("\nDo you want to add another addon.\n");
        BeverageAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < beverageName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                beverageAddonsTotal3 += beveragePrice.get(j);
                beverageAddonsName3.add(beverageName.get(j));
                beverageAddonsPrice3.add(String.valueOf(beveragePrice.get(j)));
                BeverageCustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        BeverageCustomizationList5();
    }

    //    -------------   ReceiptView method start   -------------
    private static void ReceiptView() {
        System.out.println("\nYou have ordered #" + itemCount + " number of items");
        System.out.println("            Pizza Hut");
        System.out.println("-------------------------------------");
        for (int i = 0; i < itemsName.size(); i++) {
            System.out.println("[ " + itemChooseOrder.get(i) + " ]");
            System.out.println("#" + (i+1) + " " + itemsName.get(i));
            System.out.println("          - " + itemsSizes.get(i) + " - " + prices.get(i) + " " + currencyCode);
            if (PizzaAddon1 == "one" & i == 0){
                System.out.println("    Addons");
                for (int j = 0; j < pizzaAddonsName1.size(); j++) {
                    System.out.println("          - " + pizzaAddonsName1.get(j) + " - " + pizzaAddonsPrice1.get(j) + " " + currencyCode);
                }
            } else if (PizzaAddon2 == "two" & i == 1) {
                System.out.println("    Addons");
                for (int j = 0; j < pizzaAddonsName2.size(); j++) {
                    System.out.println("          - " + pizzaAddonsName2.get(j) + " - " + pizzaAddonsPrice2.get(j) + " " + currencyCode);
                }
            } else if (PizzaAddon3 == "three" & i == 2) {
                System.out.println("    Addons");
                for (int j = 0; j < pizzaAddonsName3.size(); j++) {
                    System.out.println("          - " + pizzaAddonsName3.get(j) + " - " + pizzaAddonsPrice3.get(j) + " " + currencyCode);
                }
            } else if (DrinkAddon1 == "one" & i == 0){
                System.out.println("    Addons");
                for (int j = 0; j < drinkAddonsName1.size(); j++) {
                    System.out.println("          - " + drinkAddonsName1.get(j) + " - " + drinkAddonsPrice1.get(j) + " " + currencyCode);
                }
            } else if (DrinkAddon2 == "two" & i == 1) {
                System.out.println("    Addons");
                for (int j = 0; j < drinkAddonsName2.size(); j++) {
                    System.out.println("          - " + drinkAddonsName2.get(j) + " - " + drinkAddonsPrice2.get(j) + " " + currencyCode);
                }
            } else if (DrinkAddon3 == "three" & i == 2) {
                System.out.println("    Addons");
                for (int j = 0; j < drinkAddonsName3.size(); j++) {
                    System.out.println("          - " + drinkAddonsName3.get(j) + " - " + drinkAddonsPrice3.get(j) + " " + currencyCode);
                }
            }else if (BeverageAddon1 == "one" & i == 0){
                System.out.println("    Addons");
                for (int j = 0; j < beverageAddonsName1.size(); j++) {
                    System.out.println("          - " + beverageAddonsName1.get(j) + " - " + beverageAddonsPrice1.get(j) + " " + currencyCode);
                }
            } else if (BeverageAddon2 == "two" & i == 1) {
                System.out.println("    Addons");
                for (int j = 0; j < beverageAddonsName2.size(); j++) {
                    System.out.println("          - " + beverageAddonsName2.get(j) + " - " + beverageAddonsPrice2.get(j) + " " + currencyCode);
                }
            } else if (BeverageAddon3 == "three" & i == 2) {
                System.out.println("    Addons");
                for (int j = 0; j < beverageAddonsName3.size(); j++) {
                    System.out.println("          - " + beverageAddonsName3.get(j) + " - " + beverageAddonsPrice3.get(j) + " " + currencyCode);
                }
            }
        }
        System.out.println("\n        Total : " + ( total + pizzaAddonsTotal1 + pizzaAddonsTotal2 + pizzaAddonsTotal3 +
                                                            drinkAddonsTotal1 + drinkAddonsTotal2 + drinkAddonsTotal3 +
                                                            beverageAddonsTotal1 + beverageAddonsTotal2 + beverageAddonsTotal3 )+ " " + currencyCode);
        System.out.println("-------------------------------------");
        System.out.println("     Thank You For Ordering");
        System.out.println("-------------------------------------");
        System.out.println("Thank you for visiting Pizza Hut, See you next time.\n");
    }
    //    -------------   ReceiptView method end   -------------
}