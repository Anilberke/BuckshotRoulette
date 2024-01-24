import java.util.Scanner;

public class Demon extends Participant {
    private String demonName;
    //create a scanner



    public Demon(String demonName) {
        this.demonName = demonName;
    }

    public String getDemonName() {
        return demonName;
    }

    @Override
    public void opponentTurn() {
        super.opponentTurn();
        if (getStance() == 1 && !isHandCuffed()) {
            System.out.println("The demon is thinking...");

            if (Shotgun.getNumOfLoadedShells()>Shotgun.getNumOfEmptyShells()){
                shootOpponent();
            }
            else {
                shootYourself();
            }


        }
        else {
            System.out.println("Demon can't do anything.");
            yourTurn();
        }

    }


    public void shootYourself() {
        if (Boolean.TRUE.equals(Shotgun.getMagazine().peek())) {
            System.out.println(demonName + " shot itself in the head.");
            if (getParticipantHealth() == 1) {
                System.out.println(demonName + " died.");
                System.exit(0);
            } else if (Shotgun.isShotgunSawedOff()) {
                setParticipantHealth(getParticipantHealth() - 2);
                System.out.println(demonName + " has " + getParticipantHealth() + " health left.");
                setStance(1);
                yourTurn();
            } else {
                setParticipantHealth(getParticipantHealth() - 1);
                System.out.println(demonName + " has " + getParticipantHealth() + " health left.");
                setStance(1);
                yourTurn();
            }
            yourTurn();
        } else {
            System.out.println(demonName + " shot a blank round.");

            setStance(0);
            opponentTurn();
        }
        Shotgun.getMagazine().poll();
    }

    public void shootOpponent() {
        if (Boolean.TRUE.equals(Shotgun.getMagazine().peek())) {
            System.out.println(demonName + " shot the you in the head.");
            if (getParticipantHealth() == 1) {
                System.out.println(demonName + " won.");
                System.exit(0);
            } else if (Shotgun.isShotgunSawedOff()) {
                setParticipantHealth(getParticipantHealth() - 2);
                System.out.println("The player has " + getParticipantHealth() + " health left.");
                setStance(0);
                opponentTurn();
            } else {
                setParticipantHealth(getParticipantHealth() - 1);
                System.out.println("The player has " + getParticipantHealth() + " health left.");
                setStance(0);
                opponentTurn();
            }
            opponentTurn();
        } else {
            System.out.println(demonName + " shot a blank round.");

            setStance(1);
            yourTurn();
        }
        Shotgun.getMagazine().poll();
    }
}