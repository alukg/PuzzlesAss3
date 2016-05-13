/**
 * class that represents each Puzzle
 */
public class Puzzle {


    private int[] privateKey; // Array that saves the privateKey cypher
    private int[] riddle; //Array that saves the riddle serial number cypher


    /**
     * Constructor
     * @param privateKey - number Array
     * @param riddle - number Array
     */
    public Puzzle(int[] privateKey, int[] riddle){
        this.privateKey = privateKey;
        this.riddle = riddle;
    }

    /**
     * copy constructor
     * @param o - puzzle
     */
    public Puzzle(Puzzle o){
        int [] oRiddle = o.getRiddle();
        int [] oPrivateKey = o.getPrivateKey();
        privateKey = new int[oPrivateKey.length];
        riddle = new int[oRiddle.length];
        for (int i = 0; i < oPrivateKey.length; i++){
            privateKey[i] = oPrivateKey[i];
        }
        for (int i = 0; i < oRiddle.length; i++){
            riddle[i] = oRiddle[i];
        }
    }

    /**
     * @return puzzle privateKey cypher
     */
    public int[] getPrivateKey(){
        return privateKey;
    }

    /**
     * @return puzzle serial number cypher
     */
    public int[] getRiddle() {
        return riddle;
    }
}
