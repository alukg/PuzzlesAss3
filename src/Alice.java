import javafx.util.Pair;


public class Alice {

    private Puzzle [] puzzlesArray;
    //Add Fields if needed

    public Alice(){
    }

    public Puzzle[] getPuzzlesCopy(){
        Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
        for(int i = 0; i < puzzlesArray.length; i++){
            puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
        }
        return puzzlesCopy;
    }

    public void createPuzzles(int n, int k){
        //Complete Your Code Here
    }

    public Pair<String, Integer> findKey(String sIndex){
        //Complete Your Code Here
    }




}
