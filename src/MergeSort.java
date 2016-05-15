/**
 * class to merge the arrays (static methods)
 */
public class MergeSort
{
    /**
     * External mergeSort method
     * @param a - pair of two strings (privateKey, serialNumber)
     */
    public static void mergeSort(Pair[] a)
    {
        Pair[] tmp = new Pair[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    /**
     * internal function top level to split and merge
     * @param a Array to sort
     * @param tmp temp array
     * @param left left index
     * @param right right index
     */
    private static void mergeSort(Pair [ ] a, Pair [ ] tmp, int left, int right)
    {
        //if array length > 1 then split and merge
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    /**
     * merge two arrays
     * @param a Array to sort
     * @param tmp temp array
     * @param left left index
     * @param right middle index
     * @param rightEnd right index
     */
    private static void merge(Pair[ ] a, Pair[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        // loop until one of the arrays ends
        while(left <= leftEnd && right <= rightEnd)
            //compare values and insert to temp array
            if(((String)(a[left].getValue())).compareTo((String)(a[right].getValue()))==-1)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
}