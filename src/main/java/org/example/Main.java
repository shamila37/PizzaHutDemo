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
    static double addonsTotal1, addonsTotal2, addonsTotal3;
    static String addon1, addon2, addon3;
    static String currencyCode = "LKR";
    static String[] orderStep = {"first", "second", "third"};
    static ArrayList<String> itemsName = new ArrayList<String>();
    static ArrayList<String> itemsSizes = new ArrayList<String>();
    static ArrayList<String> prices = new ArrayList<String>();
    static ArrayList<String> itemChooseOrder = new ArrayList<String>();
    static String[] itemTypes = {" Cake ", " Hot Beverages ", " Pizza ", " Soft Drinks "};

    static ArrayList<String> PizzaItems = new ArrayList<String>();
    static ArrayList<String> pizzaName = new ArrayList<String>();
    static ArrayList<Double> pizzaPrice = new ArrayList<Double>();
    static ArrayList<Double> largePrices = new ArrayList<Double>();
    static ArrayList<Double> mediumPrices = new ArrayList<Double>();
    static ArrayList<Double> smallPrices = new ArrayList<Double>();
    static ArrayList<String> descriptions = new ArrayList<String>();
    static ArrayList<String> addonsName1 = new ArrayList<String>();
    static ArrayList<String> addonsName2 = new ArrayList<String>();
    static ArrayList<String> addonsName3 = new ArrayList<String>();
    static ArrayList<String> addonsPrice1 = new ArrayList<String>();
    static ArrayList<String> addonsPrice2 = new ArrayList<String>();
    static ArrayList<String> addonsPrice3 = new ArrayList<String>();

    static ArrayList<String> drinkName = new ArrayList<String>();
    static ArrayList<Double> drinkPrice = new ArrayList<Double>();
    static ArrayList<String> DrinkItems = new ArrayList<String>();
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

    static String size1 = "Large";
    static String size2 = "Medium";
    static String size3 = "Small";

    //    -------------   Main method start   -------------
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("menuList.json"));
            JSONObject pizzaItems = (JSONObject) obj;
            JSONArray pizzaItemsDetails = (JSONArray) pizzaItems.get("pizzaItems");

            for (int i = 0; i < pizzaItemsDetails.size(); i++) {
                JSONObject pizza = (JSONObject) pizzaItemsDetails.get(i);

                PizzaItems.add((String) pizza.get("name"));
                largePrices.add((double) pizza.get("largePrice"));
                mediumPrices.add((double) pizza.get("mediumPrice"));
                smallPrices.add((double) pizza.get("smallPrice"));
                descriptions.add((String) pizza.get("description"));
            }

            Object obj1 = parser.parse(new FileReader("addons.json"));
            JSONObject addonsItems = (JSONObject) obj1;
            JSONArray addonsItemsDetails = (JSONArray) addonsItems.get("addons");

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
                case "2" -> SoftDrinkMenuView();
//                case "3" -> HotBeveragesMenuView();
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
            System.out.println("#" + (i+1) + " " + PizzaItems.get(i) + " - L " + largePrices.get(i) + " " + currencyCode + " | M " + mediumPrices.get(i) + " " + currencyCode + " | S " + smallPrices.get(i) + " " + currencyCode);
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

    private static void SoftDrinkItems() {
        for (int i = 0; i < DrinkItems.size(); i++) {
            System.out.println("#" + (i+1) + " " + DrinkItems.get(i) + " - L " + drinkLargePrice.get(i) + " " + currencyCode + " | M " + drinkMediumPrice.get(i) + " " + currencyCode + " | S " + drinkSmallPrice.get(i) + " " + currencyCode);
        }
    }

    //    -------------   SoftDrinkMenu method start   -------------
    private static void SoftDrinkMenuView() {
        while (true) {
            System.out.println("\nSoft Drinks Menu\n");
            SoftDrinkItems();
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

    private static void PizzaAddItem(int i) {
        System.out.println("\nName : " + PizzaItems.get(i));
        System.out.println("Description : " + descriptions.get(i));
        System.out.println("Available Sizes : Large | Medium | Small");
        System.out.println("Large Price : " + largePrices.get(i) + " " + currencyCode);
        System.out.println("Medium Price : " + mediumPrices.get(i) + " " + currencyCode);
        System.out.println("Small Price : " + smallPrices.get(i) + " " + currencyCode);
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
            SoftDrinkMenuView();
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
//                HotBeverageMakeOrderScreen1();
            } else if (customerOption3.equals("3")){
                PizzaMakeOrderScreen1();
            } else if (customerOption3.equals("4")){
                SoftDrinkMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        MainMakeOrderScreen();
    }
    //    -------------   MainMakeOrderScreen method end   -------------

    //    -------------   PizzaMakeOrderScreen method start   -------------
    public static void PizzaMakeOrderScreen1() {
        System.out.println("Please select " + orderStep[0] + " item you want to buy.\n");
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
    //    -------------   PizzaMakeOrderScreen method end   -------------

    //    -------------   DrinkMakeOrderScreen method start   -------------
    public static void SoftDrinkMakeOrderScreen1() {
        System.out.println("Please select " + orderStep[0] + " item you want to buy.\n");
        SoftDrinkItems();
        System.out.println("\n\nPress item number to select " + orderStep[0] + " item\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < DrinkItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                itemChooseOrder.add(itemTypes[3]);
                DrinkFirstChoice(i);
            } else if (customerOption3.equals("0")){
                SoftDrinkMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        SoftDrinkMakeOrderScreen1();
    }
    //    -------------   DrinkMakeOrderScreen method end   -------------

    private static void PizzaFirstChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + PizzaItems.get(i));
            System.out.println("Available options - L " + largePrices.get(i) + " " + currencyCode + " | M " + mediumPrices.get(i) + " " + currencyCode + " | S " + smallPrices.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += largePrices.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices.get(i)));
                CustomizePizzaScreen();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices.get(i)));
                CustomizePizzaScreen();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices.get(i)));
                CustomizePizzaScreen();
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
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += drinkLargePrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(drinkLargePrice.get(i)));
//                CustomizeDrinkScreen();
                DrinkMakeOrderScreen2();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += drinkMediumPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(drinkMediumPrice.get(i)));
//                CustomizeDrinkScreen();
                DrinkMakeOrderScreen2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += drinkSmallPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(drinkSmallPrice.get(i)));
//                CustomizeDrinkScreen();
                DrinkMakeOrderScreen2();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void CustomizePizzaScreen() {
        System.out.println("\nDo you want to customize your pizza?\n");
        System.out.println("[y] Yes\n[n] No\n");

        String customerOption3 = input.nextLine();
        if (customerOption3.equals("y")) {
            addon1 = "one";
            CustomizationList();
        } else if (customerOption3.equals("n")) {
            addon1 = "oneNo";
            PizzaMakeOrderScreen2();
        }
    }

    private static void Addons() {
        for (int j = 0; j < pizzaName.size(); j++) {
            System.out.println("#" + (j + 1) + " Add " + pizzaName.get(j) + " - " + pizzaPrice.get(j) + " " + currencyCode);
        }
    }

    private static void CustomizationList() {
        System.out.println("\nPlease select an addon you want to add.\n");
        Addons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                addonsTotal1 += pizzaPrice.get(j);
                addonsName1.add(pizzaName.get(j));
                addonsPrice1.add(String.valueOf(pizzaPrice.get(j)));
                CustomizationList1();
            } else if (customerOption3.equals("0")){
                PizzaMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CustomizationList();
    }

    private static void CustomizationList1() {
        System.out.println("\nDo you want to add another addon.\n");
        Addons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                addonsTotal1 += pizzaPrice.get(j);
                addonsName1.add(pizzaName.get(j));
                addonsPrice1.add(String.valueOf(pizzaPrice.get(j)));
                CustomizationList1();
            } else if (customerOption3.equals("0")){
                PizzaMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CustomizationList1();
    }

    public static void PizzaMakeOrderScreen2() {
        System.out.println("\nPlease select " + orderStep[1] + " item you want to buy.\n");
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
        System.out.println("\nPlease select " + orderStep[1] + " item you want to buy.\n");
        SoftDrinkItems();
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
                SoftDrinkMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkMakeOrderScreen2();
    }

    private static void PizzaSecondChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + PizzaItems.get(i));
            System.out.println("Available options - L " + largePrices.get(i) + " " + currencyCode + " | M " + mediumPrices.get(i) + " " + currencyCode + " | S " + smallPrices.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += largePrices.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices.get(i)));
                CustomizePizzaScreen1();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices.get(i)));
                CustomizePizzaScreen1();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices.get(i)));
                CustomizePizzaScreen1();
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
//                CustomizePizzaScreen1();
                DrinkMakeOrderScreen3();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += drinkMediumPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(drinkMediumPrice.get(i)));
//                CustomizePizzaScreen1();
                DrinkMakeOrderScreen3();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += drinkSmallPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(drinkSmallPrice.get(i)));
//                CustomizePizzaScreen1();
                DrinkMakeOrderScreen3();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void CustomizePizzaScreen1() {
        System.out.println("\nDo you want to customize your pizza?\n");
        System.out.println("[y] Yes\n[n] No\n");

        String customerOption3 = input.nextLine();
        if (customerOption3.equals("y")) {
            addon2 = "two";
            CustomizationList2();
        } else if (customerOption3.equals("n")) {
            addon2 = "twoNo";
            PizzaMakeOrderScreen3();
        }
    }

    private static void CustomizationList2() {
        System.out.println("\nPlease select an addon you want to add.\n");
        Addons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                addonsTotal2 += pizzaPrice.get(j);
                addonsName2.add(pizzaName.get(j));
                addonsPrice2.add(String.valueOf(pizzaPrice.get(j)));
                CustomizationList3();
            } else if (customerOption3.equals("0")){
                PizzaMakeOrderScreen3();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CustomizationList2();
    }

    private static void CustomizationList3() {
        System.out.println("\nDo you want to add another addon.\n");
        Addons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                addonsTotal2 += pizzaPrice.get(j);
                addonsName2.add(pizzaName.get(j));
                addonsPrice2.add(String.valueOf(pizzaPrice.get(j)));
                CustomizationList3();
            } else if (customerOption3.equals("0")){
                PizzaMakeOrderScreen3();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CustomizationList3();
    }

    public static void PizzaMakeOrderScreen3() {
        System.out.println("\nPlease select " + orderStep[2] + " item you want to buy.\n");
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
        System.out.println("\nPlease select " + orderStep[2] + " item you want to buy.\n");
        SoftDrinkItems();
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
                SoftDrinkMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        DrinkMakeOrderScreen3();
    }

    private static void PizzaThirdChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + PizzaItems.get(i));
            System.out.println("Available options - L " + largePrices.get(i) + " " + currencyCode + " | M " + mediumPrices.get(i) + " " + currencyCode + " | S " + smallPrices.get(i));
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [L] to select Large\nPress [M] to select Medium\nPress [S] to select small\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += largePrices.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size1);
                prices.add(String.valueOf(largePrices.get(i)));
                CustomizePizzaScreen2();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += mediumPrices.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(mediumPrices.get(i)));
                CustomizePizzaScreen2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += smallPrices.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(smallPrices.get(i)));
                CustomizePizzaScreen2();
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
//                CustomizePizzaScreen2();
                ReceiptView();
                System.exit(0);
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += drinkMediumPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size2);
                prices.add(String.valueOf(drinkMediumPrice.get(i)));
//                CustomizePizzaScreen2();
                ReceiptView();
                System.exit(0);
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += drinkSmallPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(size3);
                prices.add(String.valueOf(drinkSmallPrice.get(i)));
//                CustomizePizzaScreen2();
                ReceiptView();
                System.exit(0);
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void CustomizePizzaScreen2() {
        System.out.println("\nDo you want to customize your pizza?\n");
        System.out.println("[y] Yes\n[n] No\n");

        String customerOption3 = input.nextLine();
        if (customerOption3.equals("y")) {
            addon3 = "three";
            CustomizationList4();
        } else if (customerOption3.equals("n")) {
            addon3 = "threeNo";
            ReceiptView();
            System.exit(0);
        }
    }

    private static void CustomizationList4() {
        System.out.println("\nPlease select an addon you want to add.\n");
        Addons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                addonsTotal3 += pizzaPrice.get(j);
                addonsName3.add(pizzaName.get(j));
                addonsPrice3.add(String.valueOf(pizzaPrice.get(j)));
                CustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        CustomizationList4();
    }

    private static void CustomizationList5() {
        System.out.println("\nDo you want to add another addon.\n");
        Addons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < pizzaName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                addonsTotal3 += pizzaPrice.get(j);
                addonsName3.add(pizzaName.get(j));
                addonsPrice3.add(String.valueOf(pizzaPrice.get(j)));
                CustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        CustomizationList5();
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
            if (addon1 == "one" & i == 0){
                System.out.println("    Addons");
                for (int j = 0; j < addonsName1.size(); j++) {
                    System.out.println("          - " + addonsName1.get(j) + " - " + addonsPrice1.get(j) + " " + currencyCode);
                }
            } else if (addon2 == "two" & i == 1) {
                System.out.println("    Addons");
                for (int j = 0; j < addonsName2.size(); j++) {
                    System.out.println("          - " + addonsName2.get(j) + " - " + addonsPrice2.get(j) + " " + currencyCode);
                }
            } else if (addon3 == "three" & i == 2) {
                System.out.println("    Addons");
                for (int j = 0; j < addonsName3.size(); j++) {
                    System.out.println("          - " + addonsName3.get(j) + " - " + addonsPrice3.get(j) + " " + currencyCode);
                }
            }
        }
        System.out.println("\n        Total : " + ( total + addonsTotal1 + addonsTotal2 + addonsTotal3 )+ " " + currencyCode);
        System.out.println("-------------------------------------");
        System.out.println("     Thank You For Ordering");
        System.out.println("-------------------------------------");
        System.out.println("Thank you for visiting Pizza Hut, See you next time.\n");
    }
    //    -------------   ReceiptView method end   -------------
}