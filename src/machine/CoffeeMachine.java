package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Machine machine = new Machine();
        machine.turnOn();

        while (machine.isOn()) {
            machine.start(scanner.nextLine());
        }
    }
}
