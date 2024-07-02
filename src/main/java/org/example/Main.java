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
    static ArrayList<String> itemsName = new ArrayList<>();
    static ArrayList<String> itemsSizes = new ArrayList<>();
    static ArrayList<String> prices = new ArrayList<>();
    static ArrayList<String> itemChooseOrder = new ArrayList<>();
    static String[] itemTypes = {" Cake ", " Hot Beverages ", " Pizza ", " Soft Drinks "};

    //    -------------   Required for pizza code   -------------
    static double pizzaAddonsTotal1, pizzaAddonsTotal2, pizzaAddonsTotal3;
    static String PizzaAddon1, PizzaAddon2, PizzaAddon3;
    static ArrayList<String> PizzaItems = new ArrayList<>();
    static ArrayList<String> pizzaName = new ArrayList<>();
    static ArrayList<Double> pizzaPrice = new ArrayList<>();
    static ArrayList<String> pizzaLargeName = new ArrayList<>();
    static ArrayList<String> pizzaLargeCode = new ArrayList<>();
    static ArrayList<Double> pizzaLargePrice = new ArrayList<>();
    static ArrayList<String> pizzaMediumName = new ArrayList<>();
    static ArrayList<String> pizzaMediumCode = new ArrayList<>();
    static ArrayList<Double> pizzaMediumPrice = new ArrayList<>();
    static ArrayList<String> pizzaSmallName = new ArrayList<>();
    static ArrayList<String> pizzaSmallCode = new ArrayList<>();
    static ArrayList<Double> pizzaSmallPrice = new ArrayList<>();
    static ArrayList<String> pizzaDescriptions = new ArrayList<>();
    static ArrayList<String> pizzaAddonsName1 = new ArrayList<>();
    static ArrayList<String> pizzaAddonsName2 = new ArrayList<>();
    static ArrayList<String> pizzaAddonsName3 = new ArrayList<>();
    static ArrayList<String> pizzaAddonsPrice1 = new ArrayList<>();
    static ArrayList<String> pizzaAddonsPrice2 = new ArrayList<>();
    static ArrayList<String> pizzaAddonsPrice3 = new ArrayList<>();

    //    -------------   Required for drink code   -------------
    static double drinkAddonsTotal1, drinkAddonsTotal2, drinkAddonsTotal3;
    static String DrinkAddon1, DrinkAddon2, DrinkAddon3;
    static ArrayList<String> DrinkItems = new ArrayList<>();
    static ArrayList<Double> drinkPrice = new ArrayList<>();
    static ArrayList<String> drinkName = new ArrayList<>();
    static ArrayList<String> drinkLargeName = new ArrayList<>();
    static ArrayList<String> drinkLargeCode = new ArrayList<>();
    static ArrayList<Double> drinkLargePrice = new ArrayList<>();
    static ArrayList<String> drinkRegularName = new ArrayList<>();
    static ArrayList<String> drinkRegularCode = new ArrayList<>();
    static ArrayList<Double> drinkRegularPrice = new ArrayList<>();
    static ArrayList<String> drinkSmallName = new ArrayList<>();
    static ArrayList<String> drinkSmallCode = new ArrayList<>();
    static ArrayList<Double> drinkSmallPrice = new ArrayList<>();
    static ArrayList<String> drinkDescriptions = new ArrayList<>();
    static ArrayList<String> drinkAddonsName1 = new ArrayList<>();
    static ArrayList<String> drinkAddonsName2 = new ArrayList<>();
    static ArrayList<String> drinkAddonsName3 = new ArrayList<>();
    static ArrayList<String> drinkAddonsPrice1 = new ArrayList<>();
    static ArrayList<String> drinkAddonsPrice2 = new ArrayList<>();
    static ArrayList<String> drinkAddonsPrice3 = new ArrayList<>();

    //    -------------   Required for beverage code   -------------
    static double beverageAddonsTotal1, beverageAddonsTotal2, beverageAddonsTotal3;
    static String BeverageAddon1, BeverageAddon2, BeverageAddon3;
    static ArrayList<String> BeverageItems = new ArrayList<>();
    static ArrayList<Double> beveragePrice = new ArrayList<>();
    static ArrayList<String> beverageName = new ArrayList<>();
    static ArrayList<String> beverageLargeName = new ArrayList<>();
    static ArrayList<String> beverageLargeCode = new ArrayList<>();
    static ArrayList<Double> beverageLargePrice = new ArrayList<>();
    static ArrayList<String> beverageRegularName = new ArrayList<>();
    static ArrayList<String> beverageRegularCode = new ArrayList<>();
    static ArrayList<Double> beverageRegularPrice = new ArrayList<>();
    static ArrayList<String> beverageSmallName = new ArrayList<>();
    static ArrayList<String> beverageSmallCode = new ArrayList<>();
    static ArrayList<Double> beverageSmallPrice = new ArrayList<>();
    static ArrayList<String> beverageDescriptions = new ArrayList<>();
    static ArrayList<String> beverageAddonsName1 = new ArrayList<>();
    static ArrayList<String> beverageAddonsName2 = new ArrayList<>();
    static ArrayList<String> beverageAddonsName3 = new ArrayList<>();
    static ArrayList<String> beverageAddonsPrice1 = new ArrayList<>();
    static ArrayList<String> beverageAddonsPrice2 = new ArrayList<>();
    static ArrayList<String> beverageAddonsPrice3 = new ArrayList<>();

    //    -------------   Required for cake code   -------------
    static double cakeAddonsTotal1, cakeAddonsTotal2, cakeAddonsTotal3;
    static String CakeAddon1, CakeAddon2, CakeAddon3;
    static ArrayList<String> CakeItems = new ArrayList<>();
    static ArrayList<Double> cakePrice = new ArrayList<>();
    static ArrayList<String> cakeName = new ArrayList<>();
    static ArrayList<String> cakeFullName = new ArrayList<>();
    static ArrayList<String> cakeFullCode = new ArrayList<>();
    static ArrayList<Double> cakeFullPrice = new ArrayList<>();
    static ArrayList<String> cakeHalfName = new ArrayList<>();
    static ArrayList<String> cakeHalfCode = new ArrayList<>();
    static ArrayList<Double> cakeHalfPrice = new ArrayList<>();
    static ArrayList<String> cakeSliceName = new ArrayList<>();
    static ArrayList<String> cakeSliceCode = new ArrayList<>();
    static ArrayList<Double> cakeSlicePrice = new ArrayList<>();
    static ArrayList<String> cakeDescriptions = new ArrayList<>();
    static ArrayList<String> cakeAddonsName1 = new ArrayList<>();
    static ArrayList<String> cakeAddonsName2 = new ArrayList<>();
    static ArrayList<String> cakeAddonsName3 = new ArrayList<>();
    static ArrayList<String> cakeAddonsPrice1 = new ArrayList<>();
    static ArrayList<String> cakeAddonsPrice2 = new ArrayList<>();
    static ArrayList<String> cakeAddonsPrice3 = new ArrayList<>();

    //    -------------   Main method start   -------------
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
//            -------------   Read data from Pizza json file   -------------
            Object obj = parser.parse(new FileReader("pizzaMenuList.json"));
            JSONObject pizzaItems = (JSONObject) obj;
            JSONArray pizzaItemsDetails = (JSONArray) pizzaItems.get("pizzaItems");

            for (int i = 0; i < pizzaItemsDetails.size(); i++) {
                JSONObject pizza = (JSONObject) pizzaItemsDetails.get(i);

                PizzaItems.add((String) pizza.get("name"));

                JSONObject large = (JSONObject) pizza.get("large");
                if (large == null) {
                    pizzaLargeName.add("");
                    pizzaLargeCode.add("");
                    pizzaLargePrice.add(0.0);
                } else {
                    pizzaLargeName.add((String) large.get("name"));
                    pizzaLargeCode.add((String) large.get("code"));
                    pizzaLargePrice.add((double) large.get("price"));
                }

                JSONObject medium = (JSONObject) pizza.get("medium");
                if (medium == null) {
                    pizzaMediumName.add("");
                    pizzaMediumCode.add("");
                    pizzaMediumPrice.add(0.0);
                } else {
                    pizzaMediumName.add((String) medium.get("name"));
                    pizzaMediumCode.add((String) medium.get("code"));
                    pizzaMediumPrice.add((double) medium.get("price"));
                }

                JSONObject small = (JSONObject) pizza.get("small");
                if (small == null) {
                    pizzaSmallName.add("");
                    pizzaSmallCode.add("");
                    pizzaSmallPrice.add(0.0);
                } else {
                    pizzaSmallName.add((String) small.get("name"));
                    pizzaSmallCode.add((String) small.get("code"));
                    pizzaSmallPrice.add((double) small.get("price"));
                }

                pizzaDescriptions.add((String) pizza.get("description"));
            }
//            -------------   Read data from Pizza Addon json file   -------------
            Object obj1 = parser.parse(new FileReader("pizzaAddons.json"));
            JSONObject pizzaAddonsItems = (JSONObject) obj1;
            JSONArray pizzaAddonsItemsDetails = (JSONArray) pizzaAddonsItems.get("pizzaAddons");

            for (int i = 0; i < pizzaAddonsItemsDetails.size(); i++) {
                JSONObject pizzaAddons = (JSONObject) pizzaAddonsItemsDetails.get(i);

                if (pizzaAddons == null){
                    pizzaName.add("");
                    pizzaPrice.add(0.0);
                } else {
                    pizzaName.add((String) pizzaAddons.get("name"));
                    pizzaPrice.add((double) pizzaAddons.get("price"));
                }
            }
//            -------------   Read data from Drinks json file   -------------
            Object obj2 = parser.parse(new FileReader("softDrinksMenuList.json"));
            JSONObject drinkItems = (JSONObject) obj2;
            JSONArray drinkItemsDetails = (JSONArray) drinkItems.get("softDrinksItems");

            for (int i = 0; i < drinkItemsDetails.size(); i++) {
                JSONObject drinks = (JSONObject) drinkItemsDetails.get(i);

                DrinkItems.add((String) drinks.get("name"));

                JSONObject large = (JSONObject) drinks.get("large");
                if (large == null) {
                    drinkLargeName.add("");
                    drinkLargeCode.add("");
                    drinkLargePrice.add(0.0);
                } else {
                    drinkLargeName.add((String) large.get("name"));
                    drinkLargeCode.add((String) large.get("code"));
                    drinkLargePrice.add((double) large.get("price"));
                }

                JSONObject regular = (JSONObject) drinks.get("regular");
                if (regular == null) {
                    drinkRegularName.add("");
                    drinkRegularCode.add("");
                    drinkRegularPrice.add(0.0);
                } else {
                    drinkRegularName.add((String) regular.get("name"));
                    drinkRegularCode.add((String) regular.get("code"));
                    drinkRegularPrice.add((double) regular.get("price"));
                }

                JSONObject small = (JSONObject) drinks.get("small");
                if (small == null) {
                    drinkSmallName.add("");
                    drinkSmallCode.add("");
                    drinkSmallPrice.add(0.0);
                } else {
                    drinkSmallName.add((String) small.get("name"));
                    drinkSmallCode.add((String) small.get("code"));
                    drinkSmallPrice.add((double) small.get("price"));
                }

                drinkDescriptions.add((String) drinks.get("description"));
            }
//            -------------   Read data from Drinks Addon json file   -------------
            Object obj3 = parser.parse(new FileReader("softDrinksAddons.json"));
            JSONObject drinkAddonsItems = (JSONObject) obj3;
            JSONArray drinkAddonsItemsDetails = (JSONArray) drinkAddonsItems.get("softDrinksAddons");

            for (int i = 0; i < drinkAddonsItemsDetails.size(); i++) {
                JSONObject drinkAddons = (JSONObject) drinkAddonsItemsDetails.get(i);

                if (drinkAddons == null){
                    drinkName.add("");
                    drinkPrice.add(0.0);
                } else {
                    drinkName.add((String) drinkAddons.get("name"));
                    drinkPrice.add((double) drinkAddons.get("price"));
                }
            }
//            -------------   Read data from Beverage json file   -------------
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
//            -------------   Read data from Beverage Addon json file   -------------
            Object obj5 = parser.parse(new FileReader("hotBeveragesAddons.json"));
            JSONObject beverageAddonsItems = (JSONObject) obj5;
            JSONArray beverageAddonsItemsDetails = (JSONArray) beverageAddonsItems.get("hotBeveragesAddons");

            for (int i = 0; i < beverageAddonsItemsDetails.size(); i++) {
                JSONObject beverageAddons = (JSONObject) beverageAddonsItemsDetails.get(i);

                if (beverageAddons == null){
                    beverageName.add("");
                    beveragePrice.add(0.0);
                } else {
                    beverageName.add((String) beverageAddons.get("name"));
                    beveragePrice.add((double) beverageAddons.get("price"));
                }
            }
//            -------------   Read data from Cake json file   -------------
            Object obj6 = parser.parse(new FileReader("cakeMenuList.json"));
            JSONObject cakeItems = (JSONObject) obj6;
            JSONArray cakeItemsDetails = (JSONArray) cakeItems.get("cakeItems");

            for (int i = 0; i < cakeItemsDetails.size(); i++) {
                JSONObject cakes = (JSONObject) cakeItemsDetails.get(i);

                CakeItems.add((String) cakes.get("name"));

                JSONObject full = (JSONObject) cakes.get("full");
                if (full == null){
                    cakeFullName.add("");
                    cakeFullCode.add("");
                    cakeFullPrice.add(0.0);
                } else {
                    cakeFullName.add((String) full.get("name"));
                    cakeFullCode.add((String) full.get("code"));
                    cakeFullPrice.add((double) full.get("price"));
                }

                JSONObject half = (JSONObject) cakes.get("half");
                if (half== null) {
                    cakeHalfName.add("");
                    cakeHalfCode.add("");
                    cakeHalfPrice.add(0.0);
                } else {
                    cakeHalfName.add((String) half.get("name"));
                    cakeHalfCode.add((String) half.get("code"));
                    cakeHalfPrice.add((double) half.get("price"));
                }

                JSONObject slice = (JSONObject) cakes.get("slice");
                if (slice == null) {
                    cakeSliceName.add("");
                    cakeSliceCode.add("");
                    cakeSlicePrice.add(0.0);
                } else {
                    cakeSliceName.add((String) slice.get("name"));
                    cakeSliceCode.add((String) slice.get("code"));
                    cakeSlicePrice.add((double) slice.get("price"));
                }

                cakeDescriptions.add((String) cakes.get("description"));
            }
//            -------------   Read data from Cake Addon json file   -------------
            Object obj7 = parser.parse(new FileReader("cakeAddons.json"));
            JSONObject cakeAddonsItems = (JSONObject) obj7;
            JSONArray cakeAddonsItemsDetails = (JSONArray) cakeAddonsItems.get("cakeAddons");

            for (int i = 0; i < cakeAddonsItemsDetails.size(); i++) {
                JSONObject cakeAddons = (JSONObject) cakeAddonsItemsDetails.get(i);

                if (cakeAddons == null){
                    cakeName.add("");
                    cakePrice.add(0.0);
                } else {
                    cakeName.add((String) cakeAddons.get("name"));
                    cakePrice.add((double) cakeAddons.get("price"));
                }
            }
//
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
                case "4" -> CakesMenuView();
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
            System.out.println("#" + (i+1) + " " + PizzaItems.get(i) + " - " + pizzaLargeItem(i) + pizzaMediumItem(i) + pizzaSmallItem(i));
        }
    }

    private static String pizzaLargeItem(int i) {
        if (pizzaLargeCode.get(i) == ""){
            return "";
        } else {
            return pizzaLargeCode.get(i) + " " + pizzaLargePrice.get(i) + " " + currencyCode;
        }
    }

    private static String pizzaMediumItem(int i) {
        if (pizzaMediumCode.get(i) == ""){
            return "";
        } else {
            return " | " + pizzaMediumCode.get(i) + " " + pizzaMediumPrice.get(i) + " " + currencyCode;
        }
    }

    private static String pizzaSmallItem(int i) {
        if (pizzaSmallCode.get(i) == ""){
            return "";
        } else {
            return " | " + pizzaSmallCode.get(i) + " " + pizzaSmallPrice.get(i) + " " + currencyCode;
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
            System.out.println("#" + (i+1) + " " + DrinkItems.get(i) + " - " + drinkLargeItem(i) + drinkRegularItem(i) + drinkSmallItem(i));
        }
    }

    private static String drinkLargeItem(int i) {
        if (drinkLargeCode.get(i) == ""){
            return "";
        } else {
            return drinkLargeCode.get(i) + " " + drinkLargePrice.get(i) + " " + currencyCode;
        }
    }

    private static String drinkRegularItem(int i) {
        if (drinkRegularCode.get(i) == ""){
            return "";
        } else {
            return " | " + drinkRegularCode.get(i) + " " + drinkRegularPrice.get(i) + " " + currencyCode;
        }
    }

    private static String drinkSmallItem(int i) {
        if (drinkSmallCode.get(i) == ""){
            return "";
        } else {
            return " | " + drinkSmallCode.get(i) + " " + drinkSmallPrice.get(i) + " " + currencyCode;
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
            System.out.println("#" + (i+1) + " " + BeverageItems.get(i) + " - " + beverageLargeItem(i) + beverageRegularItem(i) + beverageSmallItem(i));
        }
    }

    private static String beverageLargeItem(int i) {
        if (beverageLargeCode.get(i) == ""){
            return "";
        } else {
            return beverageLargeCode.get(i) + " " + beverageLargePrice.get(i) + " " + currencyCode;
        }
    }

    private static String beverageRegularItem(int i) {
        if (beverageRegularCode.get(i) == ""){
            return "";
        } else {
            return " | " + beverageRegularCode.get(i) + " " + beverageRegularPrice.get(i) + " " + currencyCode;
        }
    }

    private static String beverageSmallItem(int i) {
        if (beverageSmallCode.get(i) == ""){
            return "";
        } else {
            return " | " + beverageSmallCode.get(i) + " " + beverageSmallPrice.get(i) + " " + currencyCode;
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

    private static void CakeItems() {
        for (int i = 0; i < CakeItems.size(); i++) {
            System.out.println("#" + (i+1) + " " + CakeItems.get(i) + " - " + cakeFullItem(i) + cakeHalfItem(i) + cakeSliceItem(i));
        }
    }

    private static String cakeFullItem(int i) {
        if (cakeFullCode.get(i) == ""){
            return "";
        } else {
            return cakeFullCode.get(i) + " " + cakeFullPrice.get(i) + " " + currencyCode;
        }
    }

    private static String cakeHalfItem(int i) {
        if (cakeHalfCode.get(i) == ""){
            return "";
        } else {
            return " | " + cakeHalfCode.get(i) + " " + cakeHalfPrice.get(i) + " " + currencyCode;
        }
    }

    private static String cakeSliceItem(int i) {
        if (cakeSliceCode.get(i) == ""){
            return "";
        } else {
            return " | " + cakeSliceCode.get(i) + " " + cakeSlicePrice.get(i) + " " + currencyCode;
        }
    }

    //    -------------   CakeMenu method start   -------------
    private static void CakesMenuView() {
        while (true) {
            System.out.println("\nCake Menu\n");
            CakeItems();
            System.out.println("\n\nPress item number to view description\nOR\nPress [0] to go back\n");

            String customerOption1 = input.nextLine();
            for (int i = 0; i < CakeItems.size(); i++) {
                if (customerOption1.equals("" + (i+1))) {
                    CakeAddItem(i);
                } else if (customerOption1.equals("0")) {
                    HomeView();
                }
            }
            System.out.print("\nPlease enter a valid input");
        }
    }
    //    -------------   CakeMenu method end   -------------

    private static void PizzaAddItem(int i) {
        System.out.println("\nName : " + PizzaItems.get(i));
        System.out.println("Description : " + pizzaDescriptions.get(i));

        if (pizzaLargeCode.get(i) == "" & pizzaMediumCode.get(i) != "" & pizzaSmallCode.get(i) != ""){
            System.out.println("Available Sizes : " + pizzaMediumName.get(i) + " | " + pizzaSmallName.get(i));
            System.out.println(pizzaMediumName.get(i) + " Price : " + pizzaMediumPrice.get(i) + " " + currencyCode);
            System.out.println(pizzaSmallName.get(i) + " Price : " + pizzaSmallPrice.get(i) + " " + currencyCode);
        } else if (pizzaLargeCode.get(i) != "" & pizzaMediumCode.get(i) == "" & pizzaSmallCode.get(i) != "") {
            System.out.println("Available Sizes : " + pizzaLargeName.get(i) + " | " + pizzaSmallName.get(i));
            System.out.println(pizzaLargeName.get(i) + " Price : " + pizzaLargePrice.get(i) + " " + currencyCode);
            System.out.println(pizzaSmallName.get(i) + " Price : " + pizzaSmallPrice.get(i) + " " + currencyCode);
        } else if (pizzaLargeCode.get(i) != "" & pizzaMediumCode.get(i) != "" & pizzaSmallCode.get(i) == "") {
            System.out.println("Available Sizes : " + pizzaLargeName.get(i) + " | " + pizzaMediumName.get(i));
            System.out.println(pizzaLargeName.get(i) + " Price : " + pizzaLargePrice.get(i) + " " + currencyCode);
            System.out.println(pizzaMediumName.get(i) + " Price : " + pizzaMediumPrice.get(i) + " " + currencyCode);
        } else if (pizzaLargeCode.get(i) == "" & pizzaMediumCode.get(i) == "" & pizzaSmallCode.get(i) != "") {
            System.out.println("Available Sizes : " + pizzaSmallName.get(i));
            System.out.println(pizzaSmallName.get(i) + " Price : " + pizzaSmallPrice.get(i) + " " + currencyCode);
        } else if (pizzaLargeCode.get(i) == "" & pizzaMediumCode.get(i) != "" & pizzaSmallCode.get(i) == "") {
            System.out.println("Available Sizes : " + pizzaMediumName.get(i));
            System.out.println(pizzaMediumName.get(i) + " Price : " + pizzaMediumPrice.get(i) + " " + currencyCode);
        } else if (pizzaLargeCode.get(i) != "" & pizzaMediumCode.get(i) == "" & pizzaSmallCode.get(i) == "") {
            System.out.println("Available Sizes : " + pizzaLargeName.get(i));
            System.out.println(pizzaLargeName.get(i) + " Price : " + pizzaLargePrice.get(i) + " " + currencyCode);
        } else {
            System.out.println("Available Sizes : " + pizzaLargeName.get(i) + " | " + pizzaMediumName.get(i) + " | " + pizzaSmallName.get(i));
            System.out.println(pizzaLargeName.get(i) + " Price : " + pizzaLargePrice.get(i) + " " + currencyCode);
            System.out.println(pizzaMediumName.get(i) + " Price : " + pizzaMediumPrice.get(i) + " " + currencyCode);
            System.out.println(pizzaSmallName.get(i) + " Price : " + pizzaSmallPrice.get(i) + " " + currencyCode);
        }
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")) {
            PizzaMenuView();
        } else {
            PizzaMenuView();
        }
    }

    private static void DrinksAddItem(int i) {
        System.out.println("\nName : " + DrinkItems.get(i));
        System.out.println("Description : " + drinkDescriptions.get(i));

        if (drinkLargeCode.get(i) == "" & drinkRegularCode.get(i) != "" & drinkSmallCode.get(i) != ""){
            System.out.println("Available Sizes : " + drinkRegularName.get(i) + " | " + drinkSmallName.get(i));
            System.out.println(drinkRegularName.get(i) + " Price : " + drinkRegularPrice.get(i) + " " + currencyCode);
            System.out.println(drinkSmallName.get(i) + " Price : " + drinkSmallPrice.get(i) + " " + currencyCode);
        } else if (drinkLargeCode.get(i) != "" & drinkRegularCode.get(i) == "" & drinkSmallCode.get(i) != "") {
            System.out.println("Available Sizes : " + drinkLargeName.get(i) + " | " + drinkSmallName.get(i));
            System.out.println(drinkLargeName.get(i) + " Price : " + drinkLargePrice.get(i) + " " + currencyCode);
            System.out.println(drinkSmallName.get(i) + " Price : " + drinkSmallPrice.get(i) + " " + currencyCode);
        } else if (drinkLargeCode.get(i) != "" & drinkRegularCode.get(i) != "" & drinkSmallCode.get(i) == "") {
            System.out.println("Available Sizes : " + drinkLargeName.get(i) + " | " + drinkRegularName.get(i));
            System.out.println(drinkLargeName.get(i) + " Price : " + drinkLargePrice.get(i) + " " + currencyCode);
            System.out.println(drinkRegularName.get(i) + " Price : " + drinkRegularPrice.get(i) + " " + currencyCode);
        } else if (drinkLargeCode.get(i) == "" & drinkRegularCode.get(i) == "" & drinkSmallCode.get(i) != "") {
            System.out.println("Available Sizes : " + drinkSmallName.get(i));
            System.out.println(drinkSmallName.get(i) + " Price : " + drinkSmallPrice.get(i) + " " + currencyCode);
        } else if (drinkLargeCode.get(i) == "" & drinkRegularCode.get(i) != "" & drinkSmallCode.get(i) == "") {
            System.out.println("Available Sizes : " + drinkRegularName.get(i));
            System.out.println(drinkRegularName.get(i) + " Price : " + drinkRegularPrice.get(i) + " " + currencyCode);
        } else if (drinkLargeCode.get(i) != "" & drinkRegularCode.get(i) == "" & drinkSmallCode.get(i) == "") {
            System.out.println("Available Sizes : " + drinkLargeName.get(i));
            System.out.println(drinkLargeName.get(i) + " Price : " + drinkLargePrice.get(i) + " " + currencyCode);
        } else {
            System.out.println("Available Sizes : " + drinkLargeName.get(i) + " | " + drinkRegularName.get(i) + " | " + drinkSmallName.get(i));
            System.out.println(drinkLargeName.get(i) + " Price : " + drinkLargePrice.get(i) + " " + currencyCode);
            System.out.println(drinkRegularName.get(i) + " Price : " + drinkRegularPrice.get(i) + " " + currencyCode);
            System.out.println(drinkSmallName.get(i) + " Price : " + drinkSmallPrice.get(i) + " " + currencyCode);
        }
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")) {
            DrinkMenuView();
        } else {
            DrinkMenuView();
        }
    }

    private static void BeveragesAddItem(int i) {
        System.out.println("\nName : " + BeverageItems.get(i));
        System.out.println("Description : " + beverageDescriptions.get(i));
        if (beverageLargeCode.get(i) == "" & beverageRegularCode.get(i) != "" & beverageSmallCode.get(i) != ""){
            System.out.println("Available Sizes : " + beverageRegularName.get(i) + " | " + beverageSmallName.get(i));
            System.out.println(beverageRegularName.get(i) + " Price : " + beverageRegularPrice.get(i) + " " + currencyCode);
            System.out.println(beverageSmallName.get(i) + " Price : " + beverageSmallPrice.get(i) + " " + currencyCode);
        } else if (beverageLargeCode.get(i) != "" & beverageRegularCode.get(i) == "" & beverageSmallCode.get(i) != "") {
            System.out.println("Available Sizes : " + beverageLargeName.get(i) + " | " + beverageSmallName.get(i));
            System.out.println(beverageLargeName.get(i) + " Price : " + beverageLargePrice.get(i) + " " + currencyCode);
            System.out.println(beverageSmallName.get(i) + " Price : " + beverageSmallPrice.get(i) + " " + currencyCode);
        } else if (beverageLargeCode.get(i) != "" & beverageRegularCode.get(i) != "" & beverageSmallCode.get(i) == "") {
            System.out.println("Available Sizes : " + beverageLargeName.get(i) + " | " + beverageRegularName.get(i));
            System.out.println(beverageLargeName.get(i) + " Price : " + beverageLargePrice.get(i) + " " + currencyCode);
            System.out.println(beverageRegularName.get(i) + " Price : " + beverageRegularPrice.get(i) + " " + currencyCode);
        } else if (beverageLargeCode.get(i) == "" & beverageRegularCode.get(i) == "" & beverageSmallCode.get(i) != "") {
            System.out.println("Available Sizes : " + beverageSmallName.get(i));
            System.out.println(beverageSmallName.get(i) + " Price : " + beverageSmallPrice.get(i) + " " + currencyCode);
        } else if (beverageLargeCode.get(i) == "" & beverageRegularCode.get(i) != "" & beverageSmallCode.get(i) == "") {
            System.out.println("Available Sizes : " + beverageRegularName.get(i));
            System.out.println(beverageRegularName.get(i) + " Price : " + beverageRegularPrice.get(i) + " " + currencyCode);
        } else if (beverageLargeCode.get(i) != "" & beverageRegularCode.get(i) == "" & beverageSmallCode.get(i) == "") {
            System.out.println("Available Sizes : " + beverageLargeName.get(i));
            System.out.println(beverageLargeName.get(i) + " Price : " + beverageLargePrice.get(i) + " " + currencyCode);
        } else {
            System.out.println("Available Sizes : " + beverageLargeName.get(i) + " | " + beverageRegularName.get(i) + " | " + beverageSmallName.get(i));
            System.out.println(beverageLargeName.get(i) + " Price : " + beverageLargePrice.get(i) + " " + currencyCode);
            System.out.println(beverageRegularName.get(i) + " Price : " + beverageRegularPrice.get(i) + " " + currencyCode);
            System.out.println(beverageSmallName.get(i) + " Price : " + beverageSmallPrice.get(i) + " " + currencyCode);
        }
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")) {
            HotBeveragesMenuView();
        } else {
            HotBeveragesMenuView();
        }
    }

    private static void CakeAddItem(int i) {
        System.out.println("\nName : " + CakeItems.get(i));
        System.out.println("Description : " + cakeDescriptions.get(i));
        if (cakeFullCode.get(i) == "" & cakeHalfCode.get(i) != "" & cakeSliceCode.get(i) != ""){
            System.out.println("Available Sizes : " + cakeHalfName.get(i) + " | " + cakeSliceName.get(i));
            System.out.println(cakeHalfName.get(i) + " Price : " + cakeHalfPrice.get(i) + " " + currencyCode);
            System.out.println(cakeSliceName.get(i) + " Price : " + cakeSlicePrice.get(i) + " " + currencyCode);
        } else if (cakeFullCode.get(i) != "" & cakeHalfCode.get(i) == "" & cakeSliceCode.get(i) != "") {
            System.out.println("Available Sizes : " + cakeFullName.get(i) + " | " + cakeSliceName.get(i));
            System.out.println(cakeFullName.get(i) + " Price : " + cakeFullPrice.get(i) + " " + currencyCode);
            System.out.println(cakeSliceName.get(i) + " Price : " + cakeSlicePrice.get(i) + " " + currencyCode);
        } else if (cakeFullCode.get(i) != "" & cakeHalfCode.get(i) != "" & cakeSliceCode.get(i) == "") {
            System.out.println("Available Sizes : " + cakeFullName.get(i) + " | " + cakeHalfName.get(i));
            System.out.println(cakeFullName.get(i) + " Price : " + cakeFullPrice.get(i) + " " + currencyCode);
            System.out.println(cakeHalfName.get(i) + " Price : " + cakeHalfPrice.get(i) + " " + currencyCode);
        } else if (cakeFullCode.get(i) == "" & cakeHalfCode.get(i) == "" & cakeSliceCode.get(i) != "") {
            System.out.println("Available Sizes : " + cakeSliceName.get(i));
            System.out.println(cakeSliceName.get(i) + " Price : " + cakeSlicePrice.get(i) + " " + currencyCode);
        } else if (cakeFullCode.get(i) == "" & cakeHalfCode.get(i) != "" & cakeSliceCode.get(i) == "") {
            System.out.println("Available Sizes : " + cakeHalfName.get(i));
            System.out.println(cakeHalfName.get(i) + " Price : " + cakeHalfPrice.get(i) + " " + currencyCode);
        }  else if (cakeFullCode.get(i) != "" & cakeHalfCode.get(i) == "" & cakeSliceCode.get(i) == "") {
            System.out.println("Available Sizes : " + cakeFullName.get(i));
            System.out.println(cakeFullName.get(i) + " Price : " + cakeFullPrice.get(i) + " " + currencyCode);
        } else {
            System.out.println("Available Sizes : " + cakeFullName.get(i) + " | " + cakeHalfName.get(i) + " | " + cakeSliceName.get(i));
            System.out.println(cakeFullName.get(i) + " Price : " + cakeFullPrice.get(i) + " " + currencyCode);
            System.out.println(cakeHalfName.get(i) + " Price : " + cakeHalfPrice.get(i) + " " + currencyCode);
            System.out.println(cakeSliceName.get(i) + " Price : " + cakeSlicePrice.get(i) + " " + currencyCode);
        }
        System.out.println("\nPress any to go back\n");

        String customerOption2 = input.nextLine();
        if (customerOption2.equalsIgnoreCase("")) {
            CakesMenuView();
        } else {
            CakesMenuView();
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
                CakeMakeOrderScreen1();
            } else if (customerOption3.equals("2")){
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
        System.out.println("\nPlease select an Item from our Soft Drink Menu\n");
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
                itemChooseOrder.add(itemTypes[1]);
                BeverageFirstChoice(i);
            } else if (customerOption3.equals("0")){
                HotBeveragesMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        HotBeverageMakeOrderScreen1();
    }
    //    -------------   HotBeverageMakeOrderScreen1 method end   -------------

    //    -------------   CakeMakeOrderScreen1 method start   -------------
    public static void CakeMakeOrderScreen1() {
        System.out.println("\nPlease select an Item from our Cake Menu\n");
        CakeItems();
        System.out.println("\n\nPress item number to select " + orderStep[0] + " item\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < CakeItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                itemChooseOrder.add(itemTypes[0]);
                CakeFirstChoice(i);
            } else if (customerOption3.equals("0")){
                CakesMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CakeMakeOrderScreen1();
    }
    //    -------------   CakeMakeOrderScreen1 method end   -------------

    private static void PizzaFirstChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + PizzaItems.get(i));
            System.out.println("Available options - " + pizzaLargeCode.get(i) + " " + pizzaLargePrice.get(i) + " " + currencyCode + " | " + pizzaMediumCode.get(i) + " " + pizzaMediumPrice.get(i) + " " + currencyCode + " | " + pizzaSmallCode.get(i) + " " + pizzaSmallPrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + pizzaLargeCode.get(i) + "] to select " + pizzaLargeName.get(i) + "\nPress [" + pizzaMediumCode.get(i) + "] to select " + pizzaMediumName.get(i) + "\nPress [" + pizzaSmallCode.get(i) + "] to select " + pizzaSmallName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += pizzaLargePrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(pizzaLargeName.get(i));
                prices.add(String.valueOf(pizzaLargePrice.get(i)));
                PizzaCustomizationList();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += pizzaMediumPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(pizzaMediumName.get(i));
                prices.add(String.valueOf(pizzaMediumPrice.get(i)));
                PizzaCustomizationList();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += pizzaSmallPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(pizzaSmallName.get(i));
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
            System.out.println("Available options - " + drinkLargeCode.get(i) + " " + drinkLargePrice.get(i) + " " + currencyCode + " | " + drinkRegularCode.get(i) + " " + drinkRegularPrice.get(i) + " " + currencyCode + " | " + drinkSmallCode.get(i) + " " + drinkSmallPrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + drinkLargeCode.get(i) + "] to select " + drinkLargeName.get(i) + "\nPress [" + drinkRegularCode.get(i) + "] to select " + drinkRegularName.get(i) + "\nPress [" + drinkSmallCode.get(i) + "] to select " + drinkSmallName + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += drinkLargePrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(drinkLargeName.get(i));
                prices.add(String.valueOf(drinkLargePrice.get(i)));
                DrinkCustomizationList();
            } else if (customerOption4.equals("R")) {
                itemCount += 1;
                total += drinkRegularPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(drinkRegularName.get(i));
                prices.add(String.valueOf(drinkRegularPrice.get(i)));
                DrinkCustomizationList();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += drinkSmallPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(drinkSmallName.get(i));
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
            if (beverageLargeCode.get(i) == "" & beverageRegularCode.get(i) != "" & beverageSmallCode.get(i) != ""){
                System.out.println("Available options - " + beverageRegularCode.get(i) + " " + beverageRegularPrice.get(i) + " " + currencyCode + " | " + beverageSmallCode.get(i) + " " + beverageSmallPrice.get(i) + " " + currencyCode );
            } else if (beverageLargeCode.get(i) != "" & beverageRegularCode.get(i) == "" & beverageSmallCode.get(i) != "") {
                System.out.println("Available options - " + beverageLargeCode.get(i) + " " + beverageLargePrice.get(i) + " " + currencyCode + " | " + beverageSmallCode.get(i) + " " + beverageSmallPrice.get(i) + " " + currencyCode );
            } else if (beverageLargeCode.get(i) != "" & beverageRegularCode.get(i) != "" & beverageSmallCode.get(i) == "") {
                System.out.println("Available options - " + beverageLargeCode.get(i) + " " + beverageLargePrice.get(i) + " " + currencyCode + " | " + beverageRegularCode.get(i) + " " + beverageRegularPrice.get(i) + " " + currencyCode );
            } else if (beverageLargeCode.get(i) == "" & beverageRegularCode.get(i) == "" & beverageSmallCode.get(i) != "") {
                System.out.println("Available options - " + beverageSmallCode.get(i) + " " + beverageSmallPrice.get(i) + " " + currencyCode );
            } else if (beverageLargeCode.get(i) == "" & beverageRegularCode.get(i) != "" & beverageSmallCode.get(i) == "") {
                System.out.println("Available options - " + beverageRegularCode.get(i) + " " + beverageRegularPrice.get(i) + " " + currencyCode );
            } else if (beverageLargeCode.get(i) != "" & beverageRegularCode.get(i) == "" & beverageSmallCode.get(i) == "") {
                System.out.println("Available options - " + beverageLargeCode.get(i) + " " + beverageLargePrice.get(i) + " " + currencyCode);
            } else {
                System.out.println("Available options - " + beverageLargeCode.get(i) + " " + beverageLargePrice.get(i) + " " + currencyCode + " | " + beverageRegularCode.get(i) + " " + beverageRegularPrice.get(i) + " " + currencyCode + " | " + beverageSmallCode.get(i) + " " + beverageSmallPrice.get(i) + " " + currencyCode );
            }
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + beverageLargeCode.get(i) + "] to select " + beverageLargeName.get(i) + "\nPress [" + beverageRegularCode.get(i) + "] to select " + beverageRegularName.get(i) + "\nPress [" + beverageSmallCode.get(i) + "] to select " + beverageSmallName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += beverageLargePrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(beverageLargeName.get(i));
                prices.add(String.valueOf(beverageLargePrice.get(i)));
                BeverageCustomizationList();
            } else if (customerOption4.equals("R")) {
                itemCount += 1;
                total += beverageRegularPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(beverageRegularName.get(i));
                prices.add(String.valueOf(beverageRegularPrice.get(i)));
                BeverageCustomizationList();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += beverageSmallPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(beverageSmallName.get(i));
                prices.add(String.valueOf(beverageSmallPrice.get(i)));
                BeverageCustomizationList();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void CakeFirstChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + CakeItems.get(i));
            System.out.println("Available options - " + cakeFullCode.get(i) + " " + cakeFullPrice.get(i) + " " + currencyCode + " | " + cakeHalfCode.get(i) + " " + cakeHalfPrice.get(i) + " " + currencyCode + " | " + cakeSliceCode.get(i) + " " + cakeSlicePrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + cakeFullCode.get(i) + "] to select " + cakeFullName.get(i) + "\nPress [" + cakeHalfCode.get(i) + "] to select " + cakeHalfName.get(i) + "\nPress [" + cakeSliceCode.get(i) + "] to select " + cakeSliceName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("F")) {
                itemCount += 1;
                total += cakeFullPrice.get(i);
                itemsName.add(CakeItems.get(i));
                itemsSizes.add(cakeFullName.get(i));
                prices.add(String.valueOf(cakeFullPrice.get(i)));
                CakeCustomizationList();
            } else if (customerOption4.equals("H")) {
                itemCount += 1;
                total += cakeHalfPrice.get(i);
                itemsName.add(CakeItems.get(i));
                itemsSizes.add(cakeHalfName.get(i));
                prices.add(String.valueOf(cakeHalfPrice.get(i)));
                CakeCustomizationList();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += cakeSlicePrice.get(i);
                itemsName.add(CakeItems.get(i));
                itemsSizes.add(cakeSliceName.get(i));
                prices.add(String.valueOf(cakeSlicePrice.get(i)));
                CakeCustomizationList();
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

    private static void CakeAddons() {
        for (int j = 0; j < cakeName.size(); j++) {
            System.out.println("#" + (j + 1) + " Add " + cakeName.get(j) + " - " + cakePrice.get(j) + " " + currencyCode);
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

    private static void CakeCustomizationList() {
        System.out.println("\nPlease select an addon you want to add.\n");
        CakeAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < cakeName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                cakeAddonsTotal1 += cakePrice.get(j);
                cakeAddonsName1.add(cakeName.get(j));
                cakeAddonsPrice1.add(String.valueOf(cakePrice.get(j)));
                CakeAddon1 = "one";
                CakeCustomizationList1();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CakeCustomizationList();
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

    private static void CakeCustomizationList1() {
        System.out.println("\nDo you want to add another addon.\n");
        CakeAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < cakeName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                cakeAddonsTotal1 += cakePrice.get(j);
                cakeAddonsName1.add(cakeName.get(j));
                cakeAddonsPrice1.add(String.valueOf(cakePrice.get(j)));
                CakeCustomizationList1();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen1();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CakeCustomizationList1();
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
                CakeMakeOrderScreen2();
            } else if (customerOption3.equals("2")){
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
                itemChooseOrder.add(itemTypes[1]);
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

    public static void CakeMakeOrderScreen2() {
        System.out.println("\nPlease select an Item from our Cake Menu\n");
        CakeItems();
        System.out.println("\nPress item number to select as " + orderStep[1] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < CakeItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))) {
                itemChooseOrder.add(itemTypes[0]);
                CakeSecondChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                CakesMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CakeMakeOrderScreen2();
    }

    private static void PizzaSecondChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + PizzaItems.get(i));
            System.out.println("Available options - " + pizzaLargeCode.get(i) + " " + pizzaLargePrice.get(i) + " " + currencyCode + " | " + pizzaMediumCode.get(i) + " " + pizzaMediumPrice.get(i) + " " + currencyCode + " | " + pizzaSmallCode.get(i) + " " + pizzaSmallPrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + pizzaLargeCode.get(i) + "] to select " + pizzaLargeName.get(i) + "\nPress [" + pizzaMediumCode.get(i) + "] to select " + pizzaMediumName.get(i) + "\nPress [" + pizzaSmallCode.get(i) + "] to select " + pizzaSmallName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += pizzaLargePrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(pizzaLargeName.get(i));
                prices.add(String.valueOf(pizzaLargePrice.get(i)));
                PizzaCustomizationList2();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += pizzaMediumPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(pizzaMediumName.get(i));
                prices.add(String.valueOf(pizzaMediumPrice.get(i)));
                PizzaCustomizationList2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += pizzaSmallPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(pizzaSmallName.get(i));
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
            System.out.println("Available options - " + drinkLargeCode.get(i) + " " + drinkLargePrice.get(i) + " " + currencyCode + " | " + drinkRegularCode.get(i) + " " + drinkRegularPrice.get(i) + " " + currencyCode + " | " + drinkSmallCode.get(i) + " " + drinkSmallPrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + drinkLargeCode.get(i) + "] to select " + drinkLargeName.get(i) + "\nPress [" + drinkRegularCode.get(i) + "] to select " + drinkRegularName.get(i) + "\nPress [" + drinkSmallCode.get(i) + "] to select " + drinkSmallName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += drinkLargePrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(drinkLargeName.get(i));
                prices.add(String.valueOf(drinkLargePrice.get(i)));
                DrinkCustomizationList2();
            } else if (customerOption4.equals("R")) {
                itemCount += 1;
                total += drinkRegularPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(drinkRegularName.get(i));
                prices.add(String.valueOf(drinkRegularPrice.get(i)));
                DrinkCustomizationList2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += drinkSmallPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(drinkSmallName.get(i));
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
            System.out.println("Available options - " + beverageLargeCode.get(i) + " " + beverageLargePrice.get(i) + " " + currencyCode + " | " + beverageRegularCode.get(i) + " " + beverageRegularPrice.get(i) + " " + currencyCode + " | " + beverageSmallCode.get(i) + " " + beverageSmallPrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + beverageLargeCode.get(i) + "] to select " + beverageLargeName.get(i) + "\nPress [" + beverageRegularCode.get(i) + "] to select " + beverageRegularName.get(i) + "\nPress [" + beverageSmallCode.get(i) + "] to select " + beverageSmallName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += beverageLargePrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(beverageLargeName.get(i));
                prices.add(String.valueOf(beverageLargePrice.get(i)));
                BeverageCustomizationList2();
            } else if (customerOption4.equals("R")) {
                itemCount += 1;
                total += beverageRegularPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(beverageRegularName.get(i));
                prices.add(String.valueOf(beverageRegularPrice.get(i)));
                BeverageCustomizationList2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += beverageSmallPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(beverageSmallName.get(i));
                prices.add(String.valueOf(beverageSmallPrice.get(i)));
                BeverageCustomizationList2();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void CakeSecondChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + CakeItems.get(i));
            System.out.println("Available options - " + cakeFullCode.get(i) + " " + cakeFullPrice.get(i) + " " + currencyCode + " | " + cakeHalfCode.get(i) + " " + cakeHalfPrice.get(i) + " " + currencyCode + " | " + cakeSliceCode.get(i) + " " + cakeSlicePrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + cakeFullCode.get(i) + "] to select " + cakeFullName.get(i) + "\nPress [" + cakeHalfCode.get(i) + "] to select " + cakeHalfName.get(i) + "\nPress [" + cakeSliceCode.get(i) + "] to select " + cakeSliceName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("F")) {
                itemCount += 1;
                total += cakeFullPrice.get(i);
                itemsName.add(CakeItems.get(i));
                itemsSizes.add(cakeFullName.get(i));
                prices.add(String.valueOf(cakeFullPrice.get(i)));
                CakeCustomizationList2();
            } else if (customerOption4.equals("H")) {
                itemCount += 1;
                total += cakeHalfPrice.get(i);
                itemsName.add(CakeItems.get(i));
                itemsSizes.add(cakeHalfName.get(i));
                prices.add(String.valueOf(cakeHalfPrice.get(i)));
                CakeCustomizationList2();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += cakeSlicePrice.get(i);
                itemsName.add(CakeItems.get(i));
                itemsSizes.add(cakeSliceName.get(i));
                prices.add(String.valueOf(cakeSlicePrice.get(i)));
                CakeCustomizationList2();
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

    private static void CakeCustomizationList2() {
        System.out.println("\nPlease select an addon you want to add.\n");
        CakeAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < cakeName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                cakeAddonsTotal2 += cakePrice.get(j);
                cakeAddonsName2.add(cakeName.get(j));
                cakeAddonsPrice2.add(String.valueOf(cakeAddonsPrice2.get(j)));
                CakeAddon2 = "two";
                CakeCustomizationList3();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CakeCustomizationList2();
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

    private static void CakeCustomizationList3() {
        System.out.println("\nDo you want to add another addon.\n");
        CakeAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < cakeName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                cakeAddonsTotal2 += cakePrice.get(j);
                cakeAddonsName2.add(cakeName.get(j));
                cakeAddonsPrice2.add(String.valueOf(cakePrice.get(j)));
                CakeCustomizationList3();
            } else if (customerOption3.equals("0")){
                MainMakeOrderScreen2();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CakeCustomizationList3();
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
                CakeMakeOrderScreen3();
            } else if (customerOption3.equals("2")){
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
                itemChooseOrder.add(itemTypes[1]);
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

    public static void CakeMakeOrderScreen3() {
        System.out.println("\nPlease select an Item from our Cake Menu\n");
        CakeItems();
        System.out.println("\nPress item number to select as " + orderStep[2] + " item\nOR");
        System.out.println("Press [E] to complete\nOR\nPress [0] to go back to Main menu\n");

        String customerOption3 = input.nextLine();
        for (int i = 0; i < CakeItems.size(); i++) {
            if (customerOption3.equals("" + (i+1))){
                itemChooseOrder.add(itemTypes[0]);
                CakeThirdChoice(i);
            } else if (customerOption3.equals("E")) {
                ReceiptView();
                System.exit(0);
            } else if (customerOption3.equals("0")){
                CakesMenuView();
            }
        }
        System.out.print("\nPlease enter a valid input");
        CakeMakeOrderScreen3();
    }

    private static void PizzaThirdChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + PizzaItems.get(i));
            System.out.println("Available options - " + pizzaLargeCode.get(i) + " " + pizzaLargePrice.get(i) + " " + currencyCode + " | " + pizzaMediumCode.get(i) + " " + pizzaMediumPrice.get(i) + " " + currencyCode + " | " + pizzaSmallCode.get(i) + " " + pizzaSmallPrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + pizzaLargeCode.get(i) + "] to select " + pizzaLargeName.get(i) + "\nPress [" + pizzaMediumCode.get(i) + "] to select " + pizzaMediumName.get(i) + "\nPress [" + pizzaSmallCode.get(i) + "] to select " + pizzaSmallName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += pizzaLargePrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(pizzaLargeName.get(i));
                prices.add(String.valueOf(pizzaLargePrice.get(i)));
                PizzaCustomizationList4();
            } else if (customerOption4.equals("M")) {
                itemCount += 1;
                total += pizzaMediumPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(pizzaMediumName.get(i));
                prices.add(String.valueOf(pizzaMediumPrice.get(i)));
                PizzaCustomizationList4();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += pizzaSmallPrice.get(i);
                itemsName.add(PizzaItems.get(i));
                itemsSizes.add(pizzaSmallName.get(i));
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
            System.out.println("Available options - " + drinkLargeCode.get(i) + " " + drinkLargePrice.get(i) + " " + currencyCode + " | " + drinkRegularCode.get(i) + " " + drinkRegularPrice.get(i) + " " + currencyCode + " | " + drinkSmallCode.get(i) + " " + drinkSmallPrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + drinkLargeCode.get(i) + "] to select " + drinkLargeName.get(i) + "\nPress [" + drinkRegularCode.get(i) + "] to select " + drinkRegularName.get(i) + "\nPress [" + drinkSmallCode.get(i) + "] to select " + drinkSmallName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += drinkLargePrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(pizzaLargeName.get(i));
                prices.add(String.valueOf(drinkLargePrice.get(i)));
                DrinkCustomizationList4();
            } else if (customerOption4.equals("R")) {
                itemCount += 1;
                total += drinkRegularPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(pizzaMediumName.get(i));
                prices.add(String.valueOf(drinkRegularPrice.get(i)));
                DrinkCustomizationList4();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += drinkSmallPrice.get(i);
                itemsName.add(DrinkItems.get(i));
                itemsSizes.add(pizzaSmallName.get(i));
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
            System.out.println("Available options - " + beverageLargeCode.get(i) + " " + beverageLargePrice.get(i) + " " + currencyCode + " | " + beverageRegularCode.get(i) + " " + beverageRegularPrice.get(i) + " " + currencyCode + " | " + beverageSmallCode.get(i) + " " + beverageSmallPrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + beverageLargeCode.get(i) + "] to select " + beverageLargeName.get(i) + "\nPress [" + beverageRegularCode.get(i) + "] to select " + beverageLargeName.get(i) + "\nPress [" + beverageSmallCode.get(i) + "] to select " + beverageSmallName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("L")) {
                itemCount += 1;
                total += beverageLargePrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(beverageLargeName.get(i));
                prices.add(String.valueOf(beverageLargePrice.get(i)));
                BeverageCustomizationList4();
            } else if (customerOption4.equals("R")) {
                itemCount += 1;
                total += beverageRegularPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(beverageRegularName.get(i));
                prices.add(String.valueOf(beverageRegularPrice.get(i)));
                BeverageCustomizationList4();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += beverageSmallPrice.get(i);
                itemsName.add(BeverageItems.get(i));
                itemsSizes.add(beverageSmallName.get(i));
                prices.add(String.valueOf(beverageSmallPrice.get(i)));
                BeverageCustomizationList4();
            } else {
                System.out.println("Please enter a valid input.");
            }
        }
    }

    private static void CakeThirdChoice(int i) {
        while (true) {
            System.out.println("\nYou have selected #" + (i + 1) + " " + CakeItems.get(i));
            System.out.println("Available options - " + cakeFullCode.get(i) + " " + cakeFullPrice.get(i) + " " + currencyCode + " | " + cakeHalfCode.get(i) + " " + cakeHalfPrice.get(i) + " " + currencyCode + " | " + cakeSliceCode.get(i) + " " + cakeSlicePrice.get(i) + " " + currencyCode );
            System.out.println("\nPlease select a size you wish to buy.\n");
            System.out.println("Press [" + cakeFullCode.get(i) + "] to select " + cakeFullName.get(i) + "\nPress [" + cakeHalfCode.get(i) + "] to select " + cakeHalfName.get(i) + "\nPress [" + cakeSliceCode.get(i) + "] to select " + cakeSliceName.get(i) + "\n");

            String customerOption4 = input.nextLine();
            if (customerOption4.equals("F")) {
                itemCount += 1;
                total += cakeFullPrice.get(i);
                itemsName.add(CakeItems.get(i));
                itemsSizes.add(cakeFullName.get(i));
                prices.add(String.valueOf(cakeFullPrice.get(i)));
                CakeCustomizationList4();
            } else if (customerOption4.equals("H")) {
                itemCount += 1;
                total += cakeHalfPrice.get(i);
                itemsName.add(CakeItems.get(i));
                itemsSizes.add(cakeHalfName.get(i));
                prices.add(String.valueOf(cakeHalfPrice.get(i)));
                CakeCustomizationList4();
            } else if (customerOption4.equals("S")) {
                itemCount += 1;
                total += cakeSlicePrice.get(i);
                itemsName.add(CakeItems.get(i));
                itemsSizes.add(cakeSliceName.get(i));
                prices.add(String.valueOf(cakeSlicePrice.get(i)));
                CakeCustomizationList4();
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

    private static void CakeCustomizationList4() {
        System.out.println("\nPlease select an addon you want to add.\n");
        CakeAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < cakeName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                cakeAddonsTotal3 += cakePrice.get(j);
                cakeAddonsName3.add(cakeName.get(j));
                cakeAddonsPrice3.add(String.valueOf(cakePrice.get(j)));
                CakeAddon3 = "three";
                CakeCustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        CakeCustomizationList4();
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

    private static void CakeCustomizationList5() {
        System.out.println("\nDo you want to add another addon.\n");
        CakeAddons();
        System.out.println("\nPress relevant number to add the addon\nOR\nPress [0] to finish customization\n");

        String customerOption3 = input.nextLine();
        for (int j = 0; j < cakeName.size(); j++) {
            if (customerOption3.equals("" + (j+1))){
                cakeAddonsTotal3 += cakePrice.get(j);
                cakeAddonsName3.add(cakeName.get(j));
                cakeAddonsPrice3.add(String.valueOf(cakePrice.get(j)));
                CakeCustomizationList5();
            } else if (customerOption3.equals("0")){
                ReceiptView();
                System.exit(0);
            }
        }
        System.out.print("\nPlease enter a valid input");
        CakeCustomizationList5();
    }

    //    -------------   ReceiptView method start   -------------
    private static void ReceiptView() {
        System.out.println("\nYou have ordered #" + itemCount + " number of items");
        System.out.println("            Pizza Hut");
        System.out.println("-------------------------------------");
        for (int i = 0; i < itemsName.size(); i++) {
            System.out.println("[ " + itemChooseOrder.get(i) + " ]");
            System.out.println("#" + (i+1) + " " + itemsName.get(i));
            System.out.println("          - " + itemsSizes.get(i) + " Size - " + prices.get(i) + " " + currencyCode);
//            -------------   PizzaAddon start   -------------
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
//            -------------   PizzaAddon end   -------------
//            -------------   DrinkAddon start   -------------
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
//            -------------   DrinkAddon end   -------------
//            -------------   BeverageAddon start   -------------
            } else if (BeverageAddon1 == "one" & i == 0){
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
//            -------------   BeverageAddon end   -------------
//            -------------   CakeAddon start   -------------
            } else if (CakeAddon1 == "one" & i == 0){
                System.out.println("    Addons");
                for (int j = 0; j < cakeAddonsName1.size(); j++) {
                    System.out.println("          - " + cakeAddonsName1.get(j) + " - " + cakeAddonsPrice1.get(j) + " " + currencyCode);
                }
            } else if (CakeAddon2 == "two" & i == 1) {
                System.out.println("    Addons");
                for (int j = 0; j < cakeAddonsName2.size(); j++) {
                    System.out.println("          - " + cakeAddonsName2.get(j) + " - " + cakeAddonsPrice2.get(j) + " " + currencyCode);
                }
            } else if (CakeAddon3 == "three" & i == 2) {
                System.out.println("    Addons");
                for (int j = 0; j < cakeAddonsName3.size(); j++) {
                    System.out.println("          - " + cakeAddonsName3.get(j) + " - " + cakeAddonsPrice3.get(j) + " " + currencyCode);
                }
            }
//            -------------   CakeAddon end   -------------
        }
        System.out.println("\n        Total : " + ( total + pizzaAddonsTotal1 + pizzaAddonsTotal2 + pizzaAddonsTotal3 +
                                                            drinkAddonsTotal1 + drinkAddonsTotal2 + drinkAddonsTotal3 +
                                                            beverageAddonsTotal1 + beverageAddonsTotal2 + beverageAddonsTotal3 +
                                                            cakeAddonsTotal1 + cakeAddonsTotal2 + cakeAddonsTotal3 )+ " " + currencyCode);
        System.out.println("-------------------------------------");
        System.out.println("     Thank You For Ordering");
        System.out.println("-------------------------------------");
        System.out.println("Thank you for visiting Pizza Hut, See you next time.\n");
    }
    //    -------------   ReceiptView method end   -------------
}