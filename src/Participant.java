public class Participant {
    private int participantHealth = 3;
    private int stance = 1;
    private String[] participantInventory = {"NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL"};
    private boolean isHandCuffed = false;

    public int getParticipantHealth() {
        return participantHealth;
    }

    public void setParticipantHealth(int health) {
        this.participantHealth = health;
    }

    public int getStance() {
        return stance;
    }

    public void setStance(int newStance) {
        stance = newStance;
    }

    public boolean isHandCuffed() {
        return isHandCuffed;
    }

    public void setHandCuffed(boolean handCuffed) {
        isHandCuffed = handCuffed;
    }

    public String[] getParticipantInventory() {
        return participantInventory;
    }

    public void yourTurn() {

    }

    public void opponentTurn() {

    }

    public void shootYourself() {

    }
    public void shootOpponent() {
    }
}
