public class MergeSort {

    public void merge(int[] myList, int left, int mid, int right){
        int sub1 = mid - left + 1;
        int sub2 = right - mid;
        int[] L = new int[sub1]; // S1
        int[] R = new int[sub2]; // S2

        for (int i = 0; i < sub1; i++) {
            L[i] = myList[left + i];
        }
        for (int i = 0; i < sub2; i++) {
            R[i] = myList[mid + i + 1];
        }

        //Index references of S1, S2 as we fill in S.
        int i = 0;
        int j = 0;
        //i + j
        int k = left;

        while (i < sub1 && j < sub2){
            if (L[i] <= R[j]){
                myList[k] = L[i];
                i++;
            }
            else{
                myList[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < sub1){
            myList[k] = L[i];
            i++;
            k++;
        }
        while (j < sub2){
            myList[k] = R[j];
            j++;
            k++;
        }
    }


    //Left and right referring to the index
    public void sort(int[] myList, int left, int right){
        if (left < right){
            int mid = (left + right)/2;
            this.sort(myList, left, mid);
            this.sort(myList, mid+1, right);

            this.merge(myList, left, mid, right);
        }
    }

    public void printArray(int[] myList){
        for (int i = 0; i < myList.length; i++) {
            System.out.print(myList[i] + " ");
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        int[] currentList = {2,7,23,11,1,43,44,33,55,22,12,2325,436546,19};

        MergeSort mS = new MergeSort();

        mS.printArray(currentList);

        mS.sort(currentList, 0, currentList.length - 1);

        mS.printArray(currentList);
    }
}



