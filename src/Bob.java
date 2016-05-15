/**
 * Class that represents Bob functions.
 */
public class Bob extends User {

    public Bob(){}

    /**
     * choose random puzzle and solve it.
     * @param puzzles array of puzzles to choose from.
     * @return pair of solved riddle and key.
     */
    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){
        int puzzleNum = (int)(Math.random() * puzzles.length); //choose index of the puzzles array random.
        Pair ans =  solvePuzzle(puzzles[puzzleNum]); //solve the puzzle.
        return new Pair(ans.getValue(),ans.getKey());
    }

}
