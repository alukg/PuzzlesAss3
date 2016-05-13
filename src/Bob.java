
public class Bob extends User {


    public Bob(){

    }

    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){
        int puzzleNum = (int)(Math.random() * puzzles.length);
        Pair ans =  solvePuzzle(puzzles[puzzleNum]);
        return new Pair(ans.getValue(),ans.getKey());
    }


    /*public Pair<String, String> solvePuzzle(Puzzle puz){

    }*/


}
