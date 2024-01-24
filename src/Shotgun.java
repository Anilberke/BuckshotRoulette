import java.util.LinkedList;
import java.util.Queue;

public class Shotgun {
    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
    static boolean shotgunSawedOff = false;
    public static boolean isShotgunSawedOff() {

        return shotgunSawedOff;
    }

    static boolean shell1 = getRandomBoolean();
    static boolean shell2 = getRandomBoolean();
    static boolean shell3 = getRandomBoolean();
    static boolean shell4 = getRandomBoolean();
    static boolean shell5 = getRandomBoolean();
    static boolean shell6 = getRandomBoolean();
    private static Queue<Boolean> magazine = new LinkedList<>();

    static {
        magazine.add(shell1);
        magazine.add(shell2);
        magazine.add(shell3);
        magazine.add(shell4);
        magazine.add(shell5);
        magazine.add(shell6);
    }




    public static Queue<Boolean> getMagazine() {
        return magazine;
    }
    static int numOfLoadedShells = (shell1 ? 1 : 0) +
            (shell2 ? 1 : 0) +
            (shell3 ? 1 : 0) +
            (shell4 ? 1 : 0) +
            (shell5 ? 1 : 0) +
            (shell6 ? 1 : 0);
    static int numOfShells = 6;

    static int numOfEmptyShells = numOfShells - numOfLoadedShells;

    public static int getNumOfLoadedShells() {
        return numOfLoadedShells;
    }
    public static int getNumOfEmptyShells() {
        return numOfEmptyShells;
    }
}
