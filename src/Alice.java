import javafx.util.Pair;


public class Alice extends User {

    private Puzzle [] puzzlesArray;
    AVLTree tree = new AVLTree();

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

        this.puzzlesArray = new Puzzle[k];
        for( int i=0; i<k; i++)
        {
            int [] privateKey = new int [n];
            int [] riddle = new int [n];
            for (int j=0; j<n; j++)
            {
                privateKey[j] = (int)(Math.random()* (j+1) *(Math.pow(n,3)));
                riddle[j] = (int)((Math.pow(n,3) * Math.random()* (j+1) ));
            }
            solvePuzzles(new Puzzle(privateKey,riddle));

            RandomShuffle(privateKey);
            RandomShuffle(riddle);
            this.puzzlesArray[i] = new Puzzle(privateKey,riddle);
        }
    }
    public void RandomShuffle( int [] arr)
    {
        for (int i=arr.length-1; i>=0; i--)
        {
            swap(arr,i,(int)(Math.random()*i));
        }
    }

    public void swap( int [] arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public Pair<String, Integer> findKey(String sIndex){
            int num = binToInt(sIndex);
        return new Pair<String, Integer>(tree.search(num),0);

    }

    private void solvePuzzles(Puzzle puz)
    {
        Pair<String, String> solvedPuz = solvePuzzle(puz);
        int num = binToInt(solvedPuz.getValue());
        System.out.println(solvedPuz.getValue() + " " + num);
        tree.insert(new Integer(num),solvedPuz.getKey());
    }
    private int binToInt(String bin)
    {
        int sum =0, exponent =1;
        for (int i=bin.length()-1; i>=0;i--)
        {
            sum += bin.charAt(i) * exponent;
            exponent = exponent*2;
        }
        return sum;
    }


}
