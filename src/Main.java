import java.util.Scanner;

interface Parrot {
    void flappingWings();
    void fly();
    boolean canFlyHigh();
    void setName(String name);
    String getName();
    void setColor(String color);
    String getColor();
    void setMaxHeight(int maxHeight);
    int estimatedFlight(int boostSpeed, int time);
    String activeBoost();
}

class powerParrot implements Parrot {

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
        return "Bird Name: " + name + ", Color: " + color + ", Max Speed: " + maxSpeed;
    }

    public int estimatedFlight(int boostSpeed, int time) {
        return boostSpeed * time;
    }

    @Override
    public String activeBoost() {
        return "Activated boost!";
    }
}

public class Main {
    public static void main(String[] args) {
        Parrot polly = new powerParrot();
        Parrot chirpy = new powerParrot();
        Parrot SkyBolt = new powerParrot();
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

        while(true){
            System.out.println("You have the following parrots");
            System.out.print("1. Polly\n" +
                    "2. Chirpy\n" +
                    "3. SkyBolt\n \n" +
                    "Choose one of the above: ");
            int choice = input.nextInt();
            String playChoice;
            switch (choice){
                case 1:
                    System.out.println("Bird Details:");
                    System.out.println("Name: " + polly.getName());
                    System.out.println("Color: " + polly.getColor());
                    System.out.println("Estimated Flight: " + polly.estimatedFlight(23, 7) + " meters");
                    if (polly.canFlyHigh()){
                        System.out.println("Polly can fly high!");
                    }
                    else {
                        System.out.println("Polly can not fly high!");
                    }
                    System.out.println("Do you want to continue playing with Polly? (Y/N): ");
                    playChoice = input.nextLine().toLowerCase().trim();
                    if (playChoice == "y"){
                        polly.flappingWings();
                        pause(3000);
                    }
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
