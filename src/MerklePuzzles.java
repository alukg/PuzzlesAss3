import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MerklePuzzles {

    private Alice alice;
    private Bob bob;
    private Eve eve;
    String key;
    String privateKey;

    public MerklePuzzles(){
        alice = new Alice();
        bob = new Bob();
        eve = new Eve();
        key = null;
        privateKey = null;
    }

    private void Alice_createPuzzles(int n, int k){
        long startTime = System.nanoTime();
        alice.createPuzzles(n, k);
        long endTime = System.nanoTime();
        System.out.println("The time it took Alice to create the puzzles: " + (endTime - startTime));
    }

    private void Bob_choosePuzzles(){
        Puzzle[] puz = alice.getPuzzlesCopy();
        long startTime = System.nanoTime();
        Pair<String, String> bobAns = bob.choosePuzzle(puz);
        long endTime = System.nanoTime();
        key = bobAns.getKey();
        privateKey = bobAns.getValue();
        System.out.println("The time it took Bob to choose the puzzle: " + (endTime - startTime));
        System.out.println("The puzzle index Bob chose: " + key);
        System.out.println("The private key of the puzzle Bob chose: " + privateKey);
    }

    private void Alice_findKey() throws Exception {
        FileWriter writer = new FileWriter("C:\\Temp\\AliceFindKey.txt", true);
        FileWriter writer2 = new FileWriter("C:\\Temp\\AliceComparisons.txt", true);
        long startTime = System.nanoTime();
        Pair<String,Integer> aliceAns = alice.findKey(key);
        long endTime = System.nanoTime();
        System.out.println("The private key of the puzzle Alice found: " + aliceAns.getKey());
        System.out.println("The number of comparisons Alice had done: " + aliceAns.getValue());
        System.out.println("The time it took Alice to find the puzzle: " + (endTime - startTime));
        writer2.write(""+(aliceAns.getValue())+"\t");
        writer2.close();
        writer.write(""+(endTime - startTime)+"\t");
        writer.close();
    }

    private void Eve_findKey() throws Exception {
        FileWriter writer = new FileWriter("C:\\Temp\\EveFindKey.txt", true);
        FileWriter writer2 = new FileWriter("C:\\Temp\\EveComparisons.txt", true);
        Puzzle[] puz = alice.getPuzzlesCopy();
        long startTime = System.nanoTime();
        Pair<String,Integer> eveAns = eve.findKey(key,puz);
        long endTime = System.nanoTime();
        System.out.println("The private key of the puzzle Eve found: " + eveAns.getKey());
        System.out.println("The number of comparisons Eve had done: " + eveAns.getValue());
        System.out.println("The time it took Eve to find the puzzle: " + (endTime - startTime));
        writer.write(""+(endTime - startTime)+"\t");
        writer.close();
        writer2.write(""+(eveAns.getValue())+"\t");
        writer2.close();
    }

    public void fullTest(int n, int k) throws Exception {
        Alice_createPuzzles(n,k);
        Bob_choosePuzzles();
        Alice_findKey();
        Eve_findKey();
    }
    public static void main(String[] args) {
        MerklePuzzles m = new MerklePuzzles();
        try{

            for(int i=0;i<10;i++){
                m.fullTest(50,2500);
                System.out.println("--------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------");

            }
        }
        catch(Exception e)
        {
            System.out.println("shtok");
        }

    }



}
