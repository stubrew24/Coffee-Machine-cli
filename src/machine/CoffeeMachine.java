package machine;
import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);

    public enum States {
        MENU, BUY, FILL, TAKE, REMAINING;
    }

    static States state = States.MENU;

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        switch (state) {
            case MENU:
                menu();
            default:
                menu();
        }
    }

    public static void menu() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit)");

        String action = scanner.next();

        switch (action) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeCash();
                break;
            case "remaining":
                printStats();
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Action not recognized.");
        }
    }

    public static void printStats() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println((money > 0 ? "$" : "") + money + " of money");
        menu();
    }

    public static void buyEspress() {
        int waterReq = 250;
        int beansReq = 16;

        boolean enoughWater = water >= waterReq;
        boolean enoughBeans = beans >= beansReq;
        boolean enoughCups = cups >= 1;

        if (enoughWater && enoughBeans && enoughCups) {
            beans -= beansReq;
            water -= waterReq;
            money += 4;
            cups--;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough water!");
        }
        menu();
    }

    public static void buyLatte() {
        int waterReq = 350;
        int beansReq = 20;
        int milkReq = 75;

        boolean enoughWater = water >= waterReq;
        boolean enoughBeans = beans >= beansReq;
        boolean enoughMilk = milk >= milkReq;
        boolean enoughCups = cups >= 1;

        if (enoughWater && enoughBeans && enoughMilk && enoughCups) {
            beans -= beansReq;
            water -= waterReq;
            milk -= milkReq;
            money += 7;
            cups--;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough water!");
        }
        menu();
    }

    public static void buyCappucino() {
        int waterReq = 200;
        int beansReq = 12;
        int milkReq = 100;

        boolean enoughWater = water >= waterReq;
        boolean enoughBeans = beans >= beansReq;
        boolean enoughMilk = milk >= milkReq;
        boolean enoughCups = cups >= 1;

        if (enoughWater && enoughBeans && enoughMilk && enoughCups) {
            beans -= beansReq;
            water -= waterReq;
            milk -= milkReq;
            money += 6;
            cups--;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough water!");
        }
        menu();
    }

    public static void buyCoffee() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back:");
        String selection = scanner.next();

        switch (selection) {
            case "1":
                buyEspress();
                break;
            case "2":
                buyLatte();
                break;
            case "3":
                buyCappucino();
                break;
            default:
                menu();
        }
        menu();
    }

    public static void fillMachine() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups do you want to add:");
        cups += scanner.nextInt();
        menu();
    }

    public static void takeCash() {
        System.out.println("\nI gave you $" + money);
        money = 0;
        menu();
    }
}
