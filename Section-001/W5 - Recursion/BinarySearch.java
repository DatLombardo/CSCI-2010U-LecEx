public class BinarySearch {

    //overloaded function, used for convenience of the user.
    public static boolean binarySearch(int[] data, int toFind){
        return binarySearch(data, toFind, 0, data.length-1);
    }

    // [1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39]    (n = 20)
    // [1,3,5,7,9,11,13,15,17,19] toFind=14  (n = 10)
    // [11,13,15,17,19]                      (n = 5)
    // [11,13]                               (n = 2)
    // [13]                                  (n = 1)
    // []                                    (n = 0)
    //
    // T(n) = O(log n)  (but how do I know this?)
    // T(n) = T(n/2) + O(1)  (recurrence - T is defined in terms of T)

    // linear recursion, also tail recursion
    public static boolean binarySearch(int[] data, int toFind, int startIndex, int endIndex){
        //There are no elements left in the list
        if (endIndex < startIndex){
            return false;
        }

        int middleIndex = (startIndex + endIndex) / 2;

        if (toFind == data[middleIndex]){
            return true;
        }
        else if (toFind < data[middleIndex]){
            //Look to the left, toFind is smaller than middleIndex
            return binarySearch(data, toFind, startIndex, middleIndex - 1);
        }
        else {
            // Look to the right, toFind is bigger than middleIndex
            return binarySearch(data, toFind, middleIndex + 1, endIndex);
        }
    }

    public static void main(String[] args) {
        int[] myList = {2,6,8,20,21,52, 66, 68, 73, 83};
        System.out.println("Is 20 in the list? " + binarySearch(myList, 20));
        System.out.println("Is 19 in the list? " + binarySearch(myList, 19));
        System.out.println("Is 55 in the list? " + binarySearch(myList, 55));
        System.out.println("Is 73 in the list? " + binarySearch(myList, 73));
    }
}
