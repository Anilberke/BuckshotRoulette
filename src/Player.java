import java.util.Scanner;

public class Player extends Participant {
    private String playerName;

    Scanner scan = new Scanner(System.in);
    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void yourTurn() {
        super.yourTurn();
        if (getStance() == 1 && !isHandCuffed()) {
            System.out.println("What do you want to do?");
            System.out.println("Press 1 to Shoot yourself");
            System.out.println("Press 2 to Shoot the opponent");
            //scan the input
            int input = scan.nextInt();
            if (input == 1) {
                shootYourself();
            } else if (input == 2) {
                shootOpponent();
            } else {
                System.out.println("Invalid input.");
                yourTurn();
            }
        }
        else {
            System.out.println("You can't do anything.");
            setStance(0);
            opponentTurn();
        }
    }


    public void shootYourself() {
        if (Boolean.TRUE.equals(Shotgun.getMagazine().peek())) {
            System.out.println(playerName + " shot himself in the head.");
            if (getParticipantHealth() == 1) {
                System.out.println(playerName + " died.");
                System.exit(0);
            } else if (Shotgun.isShotgunSawedOff()) {
                setParticipantHealth(getParticipantHealth() - 2);
                System.out.println(playerName + " has " + getParticipantHealth() + " health left.");
                setStance(0);

            } else {
                setParticipantHealth(getParticipantHealth() - 1);
                System.out.println(playerName + " has " + getParticipantHealth() + " health left.");
                setStance(0);

            }
            opponentTurn();
        } else {
            System.out.println(playerName + " shot a blank round.");
            setStance(1);
            yourTurn();
        }
        Shotgun.getMagazine().poll();
    }

    public void shootOpponent() {
        if (Boolean.TRUE.equals(Shotgun.getMagazine().peek())) {
            System.out.println(playerName + " shot the opponent in the head.");
            if (getParticipantHealth() == 1) {
                System.out.println(playerName + " won.");
                System.exit(0);
            } else if (Shotgun.isShotgunSawedOff()) {
                setParticipantHealth(getParticipantHealth() - 2);
                System.out.println("The opponent has " + getParticipantHealth() + " health left.");
                setStance(1);

            } else {
                setParticipantHealth(getParticipantHealth() - 1);
                System.out.println("The opponent has " + getParticipantHealth() + " health left.");
                setStance(1);

            }
            yourTurn();
        } else {
            System.out.println(playerName + " shot a blank round.");

            setStance(0);
            opponentTurn();
        }
        Shotgun.getMagazine().poll();
    }
}
