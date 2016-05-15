/**
 * Class that represents Eve functions.
 */
public class Eve extends User {

    /**
     * Constructor.
     */
    public Eve(){}

    /**
     * solve the puzzles and look for the wanted riddle.
     * @param riddle solved riddle to search for.
     * @param puzzles array of puzzles to solve.
     * @return pair of the matching key and the number of comparisons.
     */
    public Pair<String, Integer> findKey(String riddle, Puzzle[] puzzles) {
		for (int i=0; i< puzzles.length; i++)
        {
            Pair<String, String> solvedStrings = solvePuzzle(puzzles[i]);
            if (solvedStrings.getValue().equals(riddle)) //if is the wanted riddle.
                return new Pair(solvedStrings.getKey(), i+1);
        }
        return new Pair("Key didn't found",0);
    }
}
