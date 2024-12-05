import java.util.Scanner;
import static java.lang.System.exit;

interface Parrot {
    void flappingWings();
    void fly();
    boolean canFlyHigh();
    void setName(String name);
    String getName();
    void setColor(String color);
    String getColor();
    void setMaxHeight(int maxHeight);
    int getMaxHeight();
    int estimatedFlight(int boostSpeed, int time);
    String activeBoost();
    int setPowerUplevel(int powerUplevel);
    int setBoostSpeed(int boostSpeed);
    int setMaxSpeed(int maxSpeed);
    void setTime(int i);
}

class PowerParrot implements Parrot {

    private String name;
    private String color;
    private int maxHeight;
    int powerUplevel;
    int boostSpeed;
    int maxSpeed;
    int time;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    public int setPowerUplevel(int powerUplevel) {
        this.powerUplevel = powerUplevel;
        return powerUplevel;
    }

    public int getPowerUplevel() {
        return powerUplevel;
    }

    public int setBoostSpeed(int boostSpeed) {
        this.boostSpeed = boostSpeed;
        return boostSpeed;
    }

    public int getBoostSpeed() {
        return boostSpeed;
    }

    public int setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    @Override
    public void flappingWings() {
        System.out.println(name + " is flapping wings!");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying!");
    }

    @Override
    public boolean canFlyHigh() {
        return maxHeight > 100;
    }

    @Override
    public String toString() {
        return "Bird Name: " + name + ", Color: " + color + ", Max Height: " + maxHeight;
    }

    public int estimatedFlight(int boostSpeed, int time) {
        return boostSpeed * time * powerUplevel;
    }

    @Override
    public String activeBoost() {
        return "Activated boost!";
    }
}

public class Main {
    public static void main(String[] args) {
        Parrot polly = new PowerParrot();
        Parrot chirpy = new PowerParrot();
        Parrot SkyBolt = new PowerParrot();
        Scanner input = new Scanner(System.in);

        polly.setName("Polly");
        polly.setColor("Green");
        polly.setMaxHeight(80);

        chirpy.setName("Chirpy");
        chirpy.setColor("Blue");
        chirpy.setMaxHeight(120);

        SkyBolt.setName("SkyBolt");
        SkyBolt.setColor("Red");
        SkyBolt.setMaxHeight(150);
        SkyBolt.setPowerUplevel(3); // Setting power level for SkyBolt
        SkyBolt.setBoostSpeed(20); // Setting boost speed
        SkyBolt.setMaxSpeed(50);   // Setting max speed
        SkyBolt.setTime(5);


        while (true) {
            System.out.println("\nYou have the following parrots:");
            System.out.print("1. Polly\n" +
                    "2. Chirpy\n" +
                    "3. SkyBolt\n" +
                    "4. Terminate the game\n" +
                    "Choose one of the above: ");
            int choice = input.nextInt();
            input.nextLine();  // Consume the leftover newline character
            String playChoice;
            switch (choice) {
                case 1:
                    System.out.println("\nBird Details:");
                    System.out.println("Name: " + polly.getName());
                    System.out.println("Color: " + polly.getColor());
                    System.out.println("Max Height: " + polly.getMaxHeight());
                    System.out.println("Estimated Flight: " + polly.estimatedFlight(12, 5) + " meters");
                    if (polly.canFlyHigh()) {
                        System.out.println("Polly can fly high!");
                    }
                    else {
                        System.out.println("Polly can not fly high!");
                    }
                    System.out.print("Do you want to continue playing with Polly? (Y/N): ");
                    playChoice = input.nextLine().toLowerCase().trim();
                    if (playChoice.equals("y")) {
                        polly.flappingWings();
                        pause(3000);
                        polly.fly();
                        pause(2000);
                        System.out.println("Polly is flying at max height of " + polly.getMaxHeight() + " meters");
                        pause(4000);
                        System.out.println("Polly reached the destination!\n" +
                                "Polly covered the distance of " + polly.estimatedFlight(12, 5) + " meters");
                    }
                    else if (playChoice.equals("n")) {
                        break;
                    }
                    else {
                        System.out.println("Invalid Choice!");
                    }
                    break;

                case 2:
                    System.out.println("\nBird Details:");
                    System.out.println("Name: " + chirpy.getName());
                    System.out.println("Color: " + chirpy.getColor());
                    System.out.println("Max Height: " + chirpy.getMaxHeight());
                    System.out.println("Estimated Flight: " + chirpy.estimatedFlight(15, 5) + " meters");
                    if (chirpy.canFlyHigh()) {
                        System.out.println("Chirpy can fly high up to " + chirpy.getMaxHeight() + " meters");
                    }
                    System.out.print("Do you want to continue playing with Chirpy? (Y/N): ");
                    playChoice = input.nextLine().toLowerCase().trim();
                    if (playChoice.equals("y")) {
                        chirpy.flappingWings();
                        pause(3000);
                        chirpy.fly();
                        pause(2000);
                        System.out.println("Chirpy is flying at max height of " + chirpy.getMaxHeight() + " meters");
                        pause(4000);
                        System.out.println("Chirpy reached the destination!\n" +
                                "Chirpy covered the distance of " + chirpy.estimatedFlight(15, 5) + " meters");
                    }
                    else if (playChoice.equals("n")) {
                        break;
                    }
                    else {
                        System.out.println("Invalid Choice!");
                    }
                    break;

                case 3:
                    System.out.println("Bird Details: ");
                    System.out.println("Name: " + SkyBolt.getName());
                    System.out.println("Color: " + SkyBolt.getColor());
                    System.out.println("Max Height: " + SkyBolt.getMaxHeight());
                    System.out.println("Estimated Flight: " + SkyBolt.estimatedFlight(20, 5) + " meters");
                    if (SkyBolt.canFlyHigh()) {
                        System.out.println("SkyBolt can fly high up to " + SkyBolt.getMaxHeight() + " meters");
                    }
                    System.out.println("Do you want to continue playing with SkyBolt? (Y/N): ");
                    input.nextLine(); // Clear the buffer
                    playChoice = input.nextLine().toLowerCase().trim();

                    if (playChoice.equals("y")) {
                        SkyBolt.flappingWings();
                        pause(3000);
                        SkyBolt.fly();
                        pause(1000);
                        System.out.println("SkyBolt can boost speed as its special ability, want to use it? (Y/N): ");
                        input.nextLine();
                        String boostChoice = input.nextLine().toLowerCase().trim();

                        if (boostChoice.equals("y")) {
                            System.out.println(SkyBolt.activeBoost());
                            System.out.println("SkyBolt is flying 2.5x faster");
                        }
                        pause(4000);
                        System.out.println("SkyBolt is flying at max height " + SkyBolt.getMaxHeight() + " meters");
                        pause(4000);
                        System.out.println("SkyBolt reached the destination!\n" +
                                "SkyBolt covered the distance of " + SkyBolt.estimatedFlight(20, 5) + " meters");
                    }
                    else if (playChoice.equals("n")) {
                        break;
                    }
                    else {
                        System.out.println("Invalid Choice!");
                        break;
                    }
                    break;


                case 4:
                    exit(0);  // Exit the program
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }

    private static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Game play interrupted!");
        }
    }
}
