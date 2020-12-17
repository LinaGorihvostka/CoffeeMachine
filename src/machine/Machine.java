package machine;

public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private State state;
    private boolean isOn;

    public Machine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
        this.state = State.MAIN_MENU;
        this.isOn = false;
    }

    public void turnOn() {
    this.isOn = true;
    System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

    private void turnOff() {
        this.isOn = false;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void start(String action) {
        switch (this.state) {
            case MAIN_MENU:
                writeOption(action);
                break;
            case BUY:
                buyCoffee(action);
                break;
            case FILL_WATER:
                fillWater(action);
                break;
            case FILL_MILK:
                fillMilk(action);
                break;
            case FILL_BEANS:
                fillBeans(action);
                break;
            case FILL_CUPS:
                fillCups(action);
                break;
        }
    }

    private void writeOption(String action) {
        switch (action) {
            case "buy":
                this.state = State.BUY;
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                        "back - to main menu: ");
                break;
            case "fill":
                this.state = State.FILL_WATER;
                System.out.println("Write how many ml of water do you want to add:");
                break;
            case "remaining":
                this.remainingSupplies();
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                break;
            case "take":
                takeMoney();
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                break;
            case "exit":
                this.state = State.OFF;
                turnOff();
                return;
            default:
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                break;
        }
    }

    private void buyCoffee(String action) {
        switch (action) {
            case "1":
                coffeeTypeEspresso();
                this.state = State.MAIN_MENU;
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "2":
                coffeeTypeLatte();
                this.state = State.MAIN_MENU;
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "3":
                coffeeTypeCappuccino();
                this.state = State.MAIN_MENU;
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "back":
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                this.state = State.MAIN_MENU;
                break;
            default:
                break;
        }
    }

    private void coffeeTypeEspresso() {
        if (water < 250) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        else if (beans < 16) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        water -= 250;
        beans -= 16;
        cups -= 1;
        money += 4;
    }

    private void coffeeTypeLatte() {
        if (water < 350) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        else if (beans < 20) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        water -= 350;
        milk -= 75;
        beans -= 20;
        cups -= 1;
        money += 7;
    }

    private void coffeeTypeCappuccino() {
        if (water < 200) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        else if (beans < 12) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        water -= 200;
        milk -= 100;
        beans -= 12;
        cups -= 1;
        money += 6;
    }

    private void remainingSupplies() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println(this.money + " of money");
    }

    private void fillWater(String action) {
            this.state = State.FILL_WATER;
            water += Integer.parseInt(action);
            this.state = State.FILL_MILK;
            System.out.println("Write how many ml of milk do you want to add:");

        }

    private void fillMilk(String action) {
            milk += Integer.parseInt(action);
            this.state = State.FILL_BEANS;
            System.out.println("Write how many grams of coffee beans do you want to add:");
        }

    private void fillBeans(String action) {
            beans += Integer.parseInt(action);
            this.state = State.FILL_CUPS;
            System.out.println("Write how many disposable cups of coffee do you want to add:");

        }

    private void fillCups(String action) {
            cups += Integer.parseInt(action);
            this.state = State.MAIN_MENU;
            System.out.println("Write action (buy, fill, take, remaining, exit):");
        }

    private void takeMoney() {
        System.out.println("I gave you $" + this.money);
        this.money -= this.money;
    }

}


