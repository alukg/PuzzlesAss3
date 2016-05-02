import javafx.util.Pair;

import java.io.*;

/**
 * Created by tomercoh on 16/04/2016.
 */
public class Eve extends User {
	
	//Add Fields if needed

    public Eve(){}

    public Pair<String, Integer> findKey(String index, Puzzle[] puzzles) throws Exception {
		for (int i=0; i< puzzles.length; i++)
        {
            Pair<String, String> solvedStrings = solvePuzzle(puzzles[i]);
            if (solvedStrings.getKey() == index)
                return new Pair<String, Integer>(solvedStrings.getValue(), i+1);
        }
        throw new Exception("key not Found");
    }
/*
    public Pair<String, String> solvePuzzle(Puzzle puz){
        //Complete Your Code Here
    }
*/
}
