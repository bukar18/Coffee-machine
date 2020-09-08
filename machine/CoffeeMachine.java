package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final static Scanner input = new Scanner(System.in);

    private static MyMachine coffeeMachine = new MyMachine();

    public static void main(String[] args) {

        menu();


    }


    public static void buy() {


        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");

    }

    public static void menu() {

        boolean flag = true;
        while (flag) {

            System.out.println("Write action (buy, fill, take,remaining,exit): ");
            String action = input.nextLine().toLowerCase();

            switch (action) {

                case "buy":
                    coffeeType();
                    break;
                case "fill":
                    fillCoffeeMachine();
                    break;
                case "take":
                    takeCoffeeMoney();
                    break;
                case "remaining":
                    coffeeMachineHas();
                    break;
                case "exit":
                    flag = false;
                    break;
                default:
                    System.out.println("Please choose correct action");

            }

        }

    }

    private static void takeCoffeeMoney() {

        coffeeMachine.withDrawingMoney();

    }

    private static void coffeeType() {


            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            String coffeeType = input.nextLine();

            switch (coffeeType) {
                case "1":
                    if(enough(250,0,16)){
                        coffeeMachine.makingBeans(16);
                        coffeeMachine.makingWater(250);
                        coffeeMachine.coffeePurchase(4);
                        coffeeMachine.makingCup();
                    }
                    break;
                case "2":
                    if(enough(350,75,20)){
                        coffeeMachine.makingBeans(20);
                        coffeeMachine.makingMilk(75);
                        coffeeMachine.makingWater(350);

                        coffeeMachine.coffeePurchase(7);
                        coffeeMachine.makingCup();
                    }
                    break;
                case "3":
                    if(enough(200,100,12)){
                        coffeeMachine.makingBeans(12);
                        coffeeMachine.makingMilk(100);
                        coffeeMachine.makingWater(200);
                        coffeeMachine.coffeePurchase(6);
                        coffeeMachine.makingCup();
                    }
                    break;

                case "back":
                    break;


                default:
                    System.out.println("please pick correct choice");
                    break;


            }



    }

    private static void fillCoffeeMachine() {

        System.out.println("Write how many ml of water do you want to add: ");
        int water = input.nextInt();

        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = input.nextInt();

        System.out.println("Write how many grams  of coffee beans do you want to add: ");
        int beans = input.nextInt();

        System.out.println("Write how many disposable cups do you want to add: ");
        int cups = input.nextInt();
        input.nextLine();


        coffeeMachine.fillCoffeeBeans(beans);
        coffeeMachine.fillCups(cups);
        coffeeMachine.fillMilk(milk);
        coffeeMachine.fillWater(water);


    }

    public static void coffeeMachineHas() {
        System.out.println("The coffee machine has: ");
        int water = coffeeMachine.getWater();
        int milk = coffeeMachine.getMilk();
        int beans = coffeeMachine.getCoffeeBeans();
        int money = coffeeMachine.getMoney();
        int cups = coffeeMachine.getCups();

        System.out.printf("%d ml of water %n%d ml of milk %n%d g of coffer beans%n%d of disposable cups %n%d of money", water, milk, beans, cups, money);
        System.out.println("");


    }

    public static boolean enough(int water,int milk,int beans) {

        int needWater = coffeeMachine.getWater() - water;
        if(needWater<0){

            System.out.println("Sorry, not enough water!");
            return false;

        }

        int needMilk = coffeeMachine.getMilk() -milk;
         if(needMilk<0){
             System.out.println("Sorry, not enough milk!");
             return false;

        }
        int needBeans =  coffeeMachine.getCoffeeBeans() - beans;
        if(needBeans<0){
            System.out.println("Sorry, not enough coffee beans!");
            return false;

        }

        int needCups =  coffeeMachine.getCups();
        if(needCups<=0){
            System.out.println("Sorry, not enough disposable cups!");
            return false;

        }


        System.out.println("I have enough resources, making you a coffee!");
        return true;



    }
}
