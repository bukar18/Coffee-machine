package machine;

public class MyMachine {
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int money = 550;
    private int cups = 9;

    public void makingCup(){
        cups--;
    }

    public int getCups() {
        return cups;
    }

    public void fillCups(int cups) {
        this.cups += cups;
    }

    public void  makingWater(int number){
        this.water -=number;
    }
    public void makingMilk(int number){
        this.milk -=number;
    }
    public void makingBeans(int number){
        this.coffeeBeans -=number;

    }

    public void withDrawingMoney(){
        System.out.println("I gave you "+getMoney());
        this.money = 0;

    }



    public int getWater() {
        return water;
    }

    public void fillWater(int water) {
        this.water += water;
    }

    public int getMilk() {
        return milk;
    }

    public void fillMilk(int milk) {
        this.milk += milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void fillCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }

    public int getMoney() {
        return money;
    }

    public void coffeePurchase(int money) {
        this.money += money;
    }
}
