import javafx.util.Pair;


public class Alice extends User {

    private Puzzle [] puzzlesArray;
    private Pair[] answers;
    //AVLTree tree = new AVLTree();

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
        this.answers = new Pair[k];

        for( int i=0; i<k; i++)
        {
            int [] privateKey = new int [n];
            int [] riddle = new int [n];
            for (int j=0; j<n; j++)
            {
                privateKey[j] = (int)((Math.random()+j) * Math.pow(n,3));
                riddle[j] = (int)((Math.random()+j) * Math.pow(n,3));
            }
            //answers[i] = solvePuzzle(new Puzzle(privateKey,riddle));
            Pair<String,String> temp = solvePuzzle(new Puzzle(privateKey,riddle));
            if(isAlreadyExists(temp.getValue(),i))
            {
                i = i-1;
            }
            else
            {
                answers[i] = temp;
                RandomShuffle(privateKey);
                RandomShuffle(riddle);
                this.puzzlesArray[i] = new Puzzle(privateKey,riddle);
            }
        }
        MergeSort.mergeSort(answers);
    }

    private boolean isAlreadyExists(String riddle, int index)
    {
        for (int i=0; i<index;i++)
        {
            if(this.answers[i].getValue().equals(riddle)) {
                return true;
            }
        }
        return false;
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

    public Pair<String, Integer> findKey(String sIndex) throws Exception {
        int low = 0;
        int high = answers.length-1;
        Integer searchCounter = new Integer(0);
        while(low <= high) {
            int middle = (low+high) /2;
            searchCounter += 1;
            if (sIndex.compareTo((String)(answers[middle].getValue()))==1){
                low = middle +1;
            } else if (sIndex.compareTo((String)(answers[middle].getValue()))==-1){
                high = middle -1;
            } else { // The element has been found
                return new Pair(answers[middle].getKey(),searchCounter);
            }
        }
        throw new Exception("Key didn't found");
    }

}
