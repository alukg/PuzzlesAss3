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

        this.puzzlesArray = new Puzzle[k];
        for( int i=0; i<k; i++)
        {
            int [] privateKey = new int [n];
            int [] riddle = new int [n];
            for (int j=0; j<n; j++)
            {
                privateKey[i] = (int)(Math.random()* (j+1) *(n^3));
                riddle[i] = (int)(Math.random()* (j+1) *(n^3));
            }
            solvePuzzles();

            RandomShuffle(privateKey);
            RandomShuffle(riddle);
            this.puzzlesArray[i] = new Puzzle(privateKey,riddle);
        }
    }
    public void RandomShuffle( int [] arr)
    {
        for (int i=arr.length; i>0; i--)
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
        //Complete Your Code Here
    }




}
