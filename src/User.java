/**
 * represents the all shared user functions.
 */
public abstract class User {
    /**
     * sort requested puzzle.
     * @param puz puzzle to sort.
     * @return sorted puzzle.
     */
    protected Puzzle sort(Puzzle puz)
    {
        int[] privateKey = puz.getPrivateKey();
        int[] riddle = puz.getRiddle();

        int [] sortedPrivateKey = new int [privateKey.length];
        int [] sortedRiddle = new int [riddle.length];

        //copy the arrays values to the right indexes.
        for (int i=0;i<privateKey.length;i++)
        {
            sortedPrivateKey[(int)(privateKey[i]/(Math.pow(privateKey.length,3)))] = privateKey[i];
            sortedRiddle[(int)(riddle[i]/(Math.pow(riddle.length,3)))] = riddle[i];
        }
        return new Puzzle(sortedPrivateKey, sortedRiddle);
    }

    /**
     * solve puzzle.
     * @param puz puzzle to solve.
     * @return pair of the solved riddle and key.
     */
    public Pair<String, String> solvePuzzle(Puzzle puz)
    {
        if (!(this instanceof Alice)) //alice don't need to sort, because she solve them before they shuffled.
            puz = sort(puz);
        int [] PrivateKey = puz.getPrivateKey();
        int [] riddle = puz.getRiddle();
        String solvedPrivateKey ="", solvedRiddle = "";
        for (int i=0; i< PrivateKey.length; i++)
        {
            solvedPrivateKey += solveXor(PrivateKey[i]);
            solvedRiddle += solveXor(riddle[i]);
        }
        return new Pair(solvedPrivateKey, solvedRiddle);
    }

    /**
     * XOR function.
     * @param num input num for XOR.
     * @return String
     */
    private String solveXor(int num)
    {
        int countOnes =0;
        while (num !=0) //count the number of ones in the binary display.
        {
            countOnes += num %2;
            num = num/2;
        }
        if (countOnes%2 == 1) //if number of ones is odd.
            return "1";
        else
            return "0";
    }
}
