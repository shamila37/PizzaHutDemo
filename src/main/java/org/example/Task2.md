# Task 2

## Pizza Hut updated their menu!

Pizza hut is planning to introduce different sizes of pizzas for there customers. For this, they have updated there menuList.json file with new prices for different types of pizzas.
In this task, you are required to update the pizza hut demo app to be compatible with menuList.json file and add following features while keeping previous features.

At the same time, pizza hut announced that there prices & pizzas will be change time to time, and they will update the latest menuList.json files time to time.

### Requirements

- Use the Task 1 project as base code for this task
- Read & update menuList.json data into your app programmatically

Your task is to update the existing simple command line app to make able to order pizzas in different sizes. At the same time, read & update menuList.json data into your app programmatically, so when pizza hut update there menu, you don't need to update the app. You can just update the menuList.json file only.

-----------------------------------------------------------
### Home View

When the app is run, first it should print following text.

```
Welcome to PizzaHut!

Now you can order pizzas in different sizes!

To View our menu, press [1]
To place an Order, press [2]
Press [x] to exit the store

```

-----------------------------------------------------------
### Main Menu View

When user enter 1, your program should print following.

```
PizzaHut Menu

#1 BBQ Chicken Pizza - L 1899.00 LKR | M 1399.00 LKR | S 999.00 LKR
#2 Devil Chicken Pizza - L 1999.00 LKR | M 1499.00 LKR | S 1099.00 LKR
#3 Vegi Pizza - L 1099.00 LKR | M 799.00 LKR | S 499.00 LKR
#4 Pork Pizza - L 2199.00 LKR | M 1599.00 LKR | S 1199.00 LKR


Press item number to view description
OR
Press [0] to go back
```

If user enter an invalid input, your program should print following.

```
Please enter a valid input
PizzaHut Menu

#1 BBQ Chicken Pizza - L 1899.00 LKR | M 1399.00 LKR | S 999.00 LKR
#2 Devil Chicken Pizza - L 1999.00 LKR | M 1499.00 LKR | S 1099.00 LKR
#3 Vegi Pizza - L 1099.00 LKR | M 799.00 LKR | S 499.00 LKR
#4 Pork Pizza - L 2199.00 LKR | M 1599.00 LKR | S 1199.00 LKR


Press item number to view description
OR
Press [0] to go back
```

When user enter any number in the given menu list, it should display the details of the relevant menu item as following. For example, think user has entered 1.

```
Name : <Name of the item>
Description : <Description of the item>
Available Sizes : <Size1> | <Size2> | <Size3>
<Size1> price : <Price of the size1> <currency code>
<Size2> price : <Price of the size2> <currency code>
<Size3> price : <Price of the size3> <currency code>

Press any to go back
```

for example, if user enter [1] then it should show as following.

```
Name : BBQ Chicken Pizza
Description : BBQ Chicken brest, Mozzarella Cheese, Bell Pepper
Available Sizes : Large | Medium | Small
Large Price : 1899.00 LKR
Medium Price : 1399.00 LKR
Small Price : 999.00 LKR

Press any to go back
```

-------------------------------------------------------
### Make Order Screen

When user press [2] from the main menu view, it will go to order screen.

The order screen will be as following.

```
You can buy 3 items.
Please select first item you want to buy.

#1 BBQ Chicken Pizza - L 1899.00 LKR | M 1399.00 LKR | S 999.00 LKR
#2 Devil Chicken Pizza - L 1999.00 LKR | M 1499.00 LKR | S 1099.00 LKR
#3 Vegi Pizza - L 1099.00 LKR | M 799.00 LKR | S 499.00 LKR
#4 Pork Pizza - L 2199.00 LKR | M 1599.00 LKR | S 1199.00 LKR


Press item number to select first item
OR
Press [0] to go back to Main menu
```

When user select a pizza, then it should ask the size of the pizza. For example, if user select [1], it should print as following.

```
You have selected #1 BBQ Chicken Pizza
Available options - L 1899.00 LKR | M 1399.00 LKR | S 999.00 LKR

Please select a size you wish to buy.

Press [L] to select Large
Press [M] to select Medium
Press [S] to select small
```

If user enter any other character, it should show as following.

```
Please enter a valid input.

You have selected #1 BBQ Chicken Pizza
Available options - L 1899.00 LKR | M 1399.00 LKR | S 999.00 LKR

Please select a size you wish to buy.

Press [L] to select Large
Press [M] to select Medium
Press [S] to select small
```

Once user select L or M or S, it should take the 2nd & 3d item order as in previous task.

The 2nd order will be like,

```
Please select second item you want to buy.

#1 BBQ Chicken Pizza - L 1899.00 LKR | M 1399.00 LKR | S 999.00 LKR
#2 Devil Chicken Pizza - L 1999.00 LKR | M 1499.00 LKR | S 1099.00 LKR
#3 Vegi Pizza - L 1099.00 LKR | M 799.00 LKR | S 499.00 LKR
#4 Pork Pizza - L 2199.00 LKR | M 1599.00 LKR | S 1199.00 LKR

Press item number to select as second item
OR
Press [E] to complete
OR
Press [0] to go back to Main menu
```

After selecting order 2 & 3, it should ask for the size of the pizza similar to order 1.

Finally, when the order is complete, it should print the recept as following.

Think user had select only 2/3 items.

```
You have ordered #2 number of items
            Pizza Hut
-------------------------------------
#1 BBQ Chicken Pizza
          - Medium - 1399.00 LKR
#2 Devil Chicken Pizza
          - Large - 1999.00 LKR
        Total : 3398.00 LKR
-------------------------------------
     Thank You For Ordering
-------------------------------------
Thank you for visiting Pizza Hut, See you next time
```

And your program will end from here.

-------------------------------------------------------------

Here is a sample output of the program. -> [link](https://pastebin.com/PNMGf48Y)

Use this password to open the link. password: ```HvtyBRAeCr```

Hope you will enjoy this task.
Happy Coding!