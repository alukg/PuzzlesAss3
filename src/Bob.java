import javafx.util.Pair;

import java.io.*;

public class Bob extends User {


    public Bob(){

    }

    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){
        int puzzleNum = (int)(Math.random() * puzzles.length);
        return solvePuzzle(puzzles[puzzleNum]);

    }


    /*public Pair<String, String> solvePuzzle(Puzzle puz){

    }*/


}
