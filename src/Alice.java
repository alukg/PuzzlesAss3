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
            solvePuzzles(new Puzzle(privateKey,riddle),i);

            RandomShuffle(privateKey);
            RandomShuffle(riddle);
            this.puzzlesArray[i] = new Puzzle(privateKey,riddle);
        }
        MergeSort.mergeSort(answers);
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
        Integer num = new Integer(binToInt(sIndex));
        return search(num);
    }

    private void solvePuzzles(Puzzle puz,int index)
    {
        Pair<String, String> solvedPuz = solvePuzzle(puz);
        int num = binToInt(solvedPuz.getValue());
        answers[index] = new Pair(solvedPuz.getKey(),new Integer(num));
    }
    private int binToInt(String bin)
    {
        int sum =0, exponent =1;
        for (int i=bin.length()-1; i>=0;i--)
        {
            sum += Integer.parseInt(""+bin.charAt(i)) * exponent;
            exponent = exponent*2;
        }
        return sum;
    }

    private Pair search(Integer num) throws Exception {
        int low = 0;
        int high = answers.length-1;
        Integer serachCounter = new Integer(0);
        while(low <= high) {
            int middle = (low+high) /2;
            serachCounter += 1;
            if (num > (Integer)(answers[middle].getValue())){
                low = middle +1;
            } else if (num < (Integer)(answers[middle].getValue())){
                high = middle -1;
            } else { // The element has been found
                return new Pair(answers[middle].getKey(),serachCounter);
            }
        }
        throw new Exception("Key didn't found");
    }

}
