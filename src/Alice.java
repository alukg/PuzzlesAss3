/**
 * Class that represents Alice functions.
 */
public class Alice extends User {

    private Puzzle[] puzzlesArray; //keeps the random puzzles.
    private Pair[] answers; //keeps the answers to the puzzles.

    /**
     * Constructor
     */
    public Alice(){
    }

    /**
     * Copy and return deep copy of the puzzles array.
     * @return array of Puzzles.
     */
    public Puzzle[] getPuzzlesCopy(){
        Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
        for(int i = 0; i < puzzlesArray.length; i++){
            puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
        }
        return puzzlesCopy;
    }

    /**
     * Function that creates the puzzles and answers arrays.
     * @param n length of each key and riddle.
     * @param k number of puzzles.
     */
    public void createPuzzles(int n, int k){
        this.puzzlesArray = new Puzzle[k];
        this.answers = new Pair[k];

        for( int i=0; i<k; i++)
        {
            int [] privateKey = new int [n]; //creates empty array for the puzzle key.
            int [] riddle = new int [n]; //creates empty array for the puzzle riddle.

            //fill the puzzle arrays in random and sorted numbers.
            for (int j=0; j<n; j++)
            {
                privateKey[j] = (int)((Math.random()+j) * Math.pow(n,3));
                riddle[j] = (int)((Math.random()+j) * Math.pow(n,3));
            }
            Pair<String,String> temp = solvePuzzle(new Puzzle(privateKey,riddle)); //solve the puzzle.
            if(isAlreadyExists(temp.getValue(),i)) //if the riddle is already exists, throw the puzzle and try agian.
            {
                i = i-1;
            }
            else //if the riddle isn't exists.
            {
                answers[i] = temp; //insert the answer to the answers array.
                RandomShuffle(privateKey); //shuffle the key array.
                RandomShuffle(riddle); //shuffle the riddle array.
                this.puzzlesArray[i] = new Puzzle(privateKey,riddle); //insert the puzzle to the puzzles array.
            }
        }
        MergeSort.mergeSort(answers); //sort the answers array for fast search.
    }

    /**
     * search if the riddle is already exists.
     * @param riddle the riddle to search for.
     * @param index the index to end the search.
     * @return either the riddle is already exists or not.
     */
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

    /**
     * shuffle array values random.
     * @param arr array to shuffle
     */
    public void RandomShuffle( int [] arr)
    {
        for (int i=arr.length-1; i>=0; i--)
        {
            swap(arr,i,(int)(Math.random()*i));
        }
    }

    /**
     *
     * @param arr swap between two array values.
     * @param index1 first index.
     * @param index2 second index.
     */
    public void swap( int [] arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * find the matching key for the riddle.
     * @param riddle riddle for looking.
     * @return pair of the matching key and the number of comparisons.
     */
    public Pair<String, Integer> findKey(String riddle) {
        int low = 0;
        int high = answers.length-1;
        Integer searchCounter = 0;
        while(low <= high) { //binary search.
            int middle = (low+high) /2;
            searchCounter += 1;
            if (riddle.compareTo((String)(answers[middle].getValue()))==1){
                low = middle +1;
            } else if (riddle.compareTo((String)(answers[middle].getValue()))==-1){
                high = middle -1;
            } else { // The element has been found
                return new Pair(answers[middle].getKey(),searchCounter);
            }
        }
        return new Pair("Key didn't found",searchCounter);
    }

}
