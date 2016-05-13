/**
 * Created by shahar on 02/05/2016.
 */
public abstract class User {
    protected Puzzle sort(Puzzle puz)
    {
        int[] privateKey = puz.getPrivateKey();
        int[] riddle = puz.getRiddle();

        int [] sortedPrivateKey = new int [privateKey.length];
        int [] sortedRiddle = new int [riddle.length];

        for (int i=0;i<privateKey.length;i++)
        {
            sortedPrivateKey[(int)(privateKey[i]/(Math.pow(privateKey.length,3)))] = privateKey[i];
            sortedRiddle[(int)(riddle[i]/(Math.pow(riddle.length,3)))] = riddle[i];
        }
        return new Puzzle(sortedPrivateKey, sortedRiddle);
    }

    public Pair<String, String> solvePuzzle(Puzzle puz)
    {
        if (!(this instanceof Alice))
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

    private String solveXor(int num)
    {
        int countOnes =0;
        while (num !=0)
        {
            countOnes += num %2;
            num = num/2;
        }
        if (countOnes%2 == 1)
            return "1";
        else
            return "0";
    }
}
