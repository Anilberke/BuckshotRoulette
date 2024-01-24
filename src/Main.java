import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


     Scanner scanner = new Scanner(System.in);

        System.out.println("You are in a dark room, you can't see anything.");
        System.out.println("You hear a voice, it says: 'Welcome to the game of Buckshot Roulette!'");
        System.out.println("You hear a voice, it says: 'You have been kidnapped and brought here to play a game.'");
        Demon demon = new Demon("Demon");
        System.out.println("What is your name: ");
        String name = scanner.nextLine();
        System.out.println("Lets start " + name + "!");
        Player player = new Player(name);
        Shotgun shotgun = new Shotgun();
        System.out.println("You have a shotgun with 6 shells in it.");
        player.yourTurn();



    }
}