# Task 3

## Pizza Hut introduce customized pizzas!

Pizza hut has now introduced to customers to customized there pizza by adding addons. These addons are given in pizzaAddon.json file. With this, customer can now order there pizza with extra cheese, chicken or any other option they like.

### Requirements

- Use the Task 2 project as base code for this task

Your task is to update the existing simple command line app to make able to order pizzas in different sizes and customizations.

---
### Home View

When the app is run, first it should print following text.

```
Welcome to PizzaHut!

Now you can order customized pizzas!

To View our menu, press [1]
To place an Order, press [2]
Press [x] to exit the store

```

---

### Main Menu View

Main Menu View will be exactly same as the previous task

---
### Make Order Screen

In Order screen, previously what we done is, first select a pizza and then select a size.
Now, after selecting the size you need to ask from customer do they need to add an Addon or proceed as following.

After selecting pizza size, you should display as following.

```
Do you want to customize your pizza?

[y] Yes
[n] No
```

If user enter [n], then move on to selecting next pizza or show the recept as usual.

If user enter [y], then you need to show the customization list as bellow.

```
Please select an addon you want to add.

#1 Add Cheese - 100.00 LKR
#2 Add Vegetable - 75.00 LKR
#3 Add Prawns - 125.00 LKR

Press relevant number to add the addon
OR
Press [0] to finish customization
```

After selecting an addon, You need to ask from customer if he want to add another addon to the pizza as show bellow.

```
Do you want to add another addon?

#1 Add Cheese - 100.00 LKR
#2 Add Vegetable - 75.00 LKR
#3 Add Prawns - 125.00 LKR

Press relevant number to add the addon
OR
Press [0] to finish customization
```

There is no limit to add an addon to the pizza. So, this menu will keep ask until hit [0] to end customization.

If user enter an invalid value, then you should print,

```
Please enter a valid input
```

and show the customization menu again.

---

### Recept

Finally, when the order is complete, it should print the recept as following.

Think user had select only 2/3 items.

```
You have ordered #2 number of items
            Pizza Hut
-------------------------------------
#1 BBQ Chicken Pizza
          - Medium - 1399.00 LKR
    Addons
          - Cheese - 100.00 LKR
          - Prawns - 125.00 LKR
          - Cheese - 100.00 LKR
#2 Devil Chicken Pizza
          - Large - 1999.00 LKR
        Total : 3723.00 LKR
-------------------------------------
     Thank You For Ordering
-------------------------------------
Thank you for visiting Pizza Hut, See you next time
```

And your program will end from here.

-------------------------------------------------------------

Hope you will enjoy this task.
Happy Coding!
