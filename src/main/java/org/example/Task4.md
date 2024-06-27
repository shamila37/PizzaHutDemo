# Task 4

## Pizza Hut Expands!

Pizza hut is now planning to expand there business. For this, they are planning to add new items to menu. The new Pizza hut menu will include following items.

- Pizza (Available **[L]** Large **[M]** Medium **[S]** Small sizes)
- Soft Drinks (Available **[L]** Large **[R]** Regular **[S]** Small sizes)
- Hot Beverages (Available **[L]** Large **[R]** Regular **[S]** Small sizes)
- Cakes (Available **[F]** Full **[H]** Half **[S]** Slice sizes)


### Requirements

- Use the Task 3 project as base code for this task

Your task is to update the existing simple command line app to make able to order different items from pizza hut with there new menu.

---

### Home View

When the app is run, first it should print following text.

```
Welcome to PizzaHut!

Check out our new items!

To View our Pizza menu, press [1]
To View our Soft Drinks menu, press [2]
To View our Hot Beverages menu, press [3]
To View our Cakes menu, press [4]
To place an Order, press [6]
Press [x] to exit the store

```

---

### Main Menu View

When user press a number to view menu item, the menu item should be similar as in the previous task, but the data should be changed.
```
<Type of Food> Menu

#1 <Food Name> - L <largePrice> LKR | M <mediumPrice> LKR | S <smallPrice> LKR
.
.
.

Press item number to view description
OR
Press [0] to go back
```

Following are few example outputs for the menu views for each food types.
```
Pizza Menu

#1 BBQ Chicken Pizza - L 1899.0 LKR | M 1399.0 LKR | S 999.0 LKR 
#2 Devil Chicken Pizza - L 1899.0 LKR | M 1399.0 LKR | S 999.0 LKR 
#3 Vegi Pizza - L 1899.0 LKR | M 1399.0 LKR | S 999.0 LKR 
#4 Pork Pizza - L 1899.0 LKR | M 1399.0 LKR | S 999.0 LKR 
Press item number to view description
OR
Press [0] to go back
```

```
Hot Beverages Menu

#1 Cappuccino - L 350.0 LKR | R 250.0 LKR | S 75.0 LKR 
#2 Latte - L 250.0 LKR | S 100.0 LKR 
#3 Nescafe - L 200.0 LKR 
#4 Lipton Tea - L 100.0 LKR | R 75.0 LKR | S 50.0 LKR 
Press item number to view description
OR
Press [0] to go back
```

```
Cake Menu

#1 Cheese Cake - F 1899.0 LKR | H 950.0 LKR | S 250.0 LKR 
#2 Strawberry Cake - F 1500.0 LKR | S 1000.0 LKR 
#3 Chocolate Cake - F 2000.0 LKR | S 1000.0 LKR 
#4 Butter Cake - F 100.0 LKR | H 75.0 LKR | S 50.0 LKR 
Press item number to view description
OR
Press [0] to go back
```

When user press a number to view food item description, it should display as following like in the previous task.

```
Name : <Name of the item>
Description : <Description of the item>
Available Sizes : <Size1> | <Size2> | <Size3>
<Size1> price : <Price of the size1> <currency code>
<Size2> price : <Price of the size2> <currency code>
<Size3> price : <Price of the size3> <currency code>

Press any to go back
```

Following are examples for few Food items.

```
Name : Cheese Cake
Description : Cheesecake is a dessert made with a soft fresh cheese, eggs, and sugar..
Full price : 1899.0 LKR
Half price : 950.0 LKR
Slice price : 250.0 LKR

Press any to go back
```

```
Name : Strawberry Cake
Description : Fresh strawberry cake made with real strawberries.
Full price : 1500.0 LKR
Slice price : 1000.0 LKR

Press any to go back
```

```
Name : Pork Pizza
Description : BBQ Pork, Mozzarella Cheese, Bell Pepper
Large price : 1899.0 LKR
Medium price : 1399.0 LKR
Small price : 999.0 LKR

Press any to go back
```

### Note

Note that if a menu item available size price is null, that means the item is not available in the store. In this case, you should not need to show it in the menu.

For example, think Cheese Cake Half Size price is null.

The **Incorrect** way of showing it in the menu is,

```
Cake Menu

#1 Cheese Cake - F 2100.00 LKR | H null LKR | S 250.00 LKR
.
.
.

Press item number to view description
OR
Press [0] to go back
```

The expected way of showing in the menu is,

```
Cake Menu

#1 Cheese Cake - F 2100.00 LKR | S 250.00 LKR
.
.
.

Press item number to view description
OR
Press [0] to go back
```
---

### Order Menu

As similar to previous task 3, user can order maximum 3 items. Once user pressed number 6 to make order, then user need to select a Sub menu first, and then need to select a food item, and then select the size and add addons as in the previous task 3.

Following is the menu that can be seen when user goes to order menu.

```
You can buy 3 items.
Please select first item you want to buy

Select Sub Menu

#1 - Cake Menu
#2 - Hot Beverages Menu
#3 - Pizza Menu
#4 - Soft Drinks Menu

Press item number to select Sub Menu
```

User needs to select one of the sub menu item. Once user select one from the above, the menu items should print as following.

```
Please select an Item from our Pizza Menu
#1 BBQ Chicken Pizza - L 1899.0 LKR | M 1399.0 LKR | S 999.0 LKR 
#2 Devil Chicken Pizza - L 1899.0 LKR | M 1399.0 LKR | S 999.0 LKR 
#3 Vegi Pizza - L 1899.0 LKR | M 1399.0 LKR | S 999.0 LKR 
#4 Pork Pizza - L 1899.0 LKR | M 1399.0 LKR | S 999.0 LKR 
Press item number to select first item
OR
Press [0] to go back to Main menu
```

Once user select an item, it should show following view as in the previous Task 3.

```
You have selected #4 Pork Pizza
Available options - L 1899.0 LKR | M 1399.0 LKR | S 999.0 LKR 

Please select a size you wish to buy.

Press [L] to select Large
Press [M] to select Medium
Press [S] to select Small
```

Once user select the size, it should show following view.

```
Please select an addon you want to add.

#1 Add Cheese - 100.0 LKR
#2 Add Vegetable - 750.0 LKR
#3 Add BBQ Chicken - 125.0 LKR
#4 Add Prawns - 125.0 LKR
Press relevant number to add the addon
OR
Press [0] to finish customization
```

User can select any number of addons. And need to press 0 to complete customization.

Once user press 0, user will move to next screen.

```
Please select second item you want to buy

Select Sub Menu

#1 - Cake Menu
#2 - Hot Beverages Menu
#3 - Pizza Menu
#4 - Soft Drinks Menu

Press item number to select Sub Menu
```

Then user can select another sub menu again.

```
Please select an Item from our Hot Beverages Menu
#1 Cappuccino - L 350.0 LKR | R 250.0 LKR | S 75.0 LKR 
#2 Latte - L 250.0 LKR | S 100.0 LKR 
#3 Nescafe - L 200.0 LKR 
#4 Lipton Tea - L 100.0 LKR | R 75.0 LKR | S 50.0 LKR 
Press item number to select second item
OR
Press [E] to complete
OR
Press [0] to go back to Main menu
```

User can now complete order by pressing E or exit by pressing 0.

If user select 4 for above example, it will show as following.

```
You have selected #4 Lipton Tea
Available options - L 100.0 LKR | R 75.0 LKR | S 50.0 LKR 

Please select a size you wish to buy.

Press [L] to select Large
Press [R] to select Regular
Press [S] to select Small
```

-------------------------

### Recipe View

The Recipe view need to show as following.

First print the food type in bracket. And print the food item with addons and size as following example output.

```
You have ordered #3 number of items
            Pizza Hut
---------------------------------------------
[ Pizza ]
#1 Pork Pizza
          - Small Size - 999.0 LKR
   Addons
          - Cheese - 100.0 LKR
          - Vegetable - 750.0 LKR
          - BBQ Chicken - 125.0 LKR
          - Prawns - 125.0 LKR
[ Hot Beverages ]
#2 Lipton Tea
          - Regular Size - 75.0 LKR
   Addons
          - Sugar - 10.0 LKR
          - Honey - 75.0 LKR
          - Jaggery - 50.0 LKR
[ Soft Drinks ]
#3 Coca Cola
          - Medium Size - 150.0 LKR
   Addons
          - Ice Cube - 10.0 LKR

        Total : 2469.0 LKR
---------------------------------------------
        Thank You For Ordering
---------------------------------------------
Thank you for visiting Pizza Hut, See you next time
```



Sample output : [https://pastebin.com/DpPXKQ5n](https://pastebin.com/DpPXKQ5n)

Password : XU0zA5yt19