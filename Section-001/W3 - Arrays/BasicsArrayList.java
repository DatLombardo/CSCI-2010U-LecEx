public class BasicsArrayList {
    private String[] elements;
    private int numElements;

    /***
     * This is our general constructor to define our elements array.
     * @param initialSize - Initial size capacity of the array.
     */
    public BasicsArrayList(int initialSize){
        this.elements = new String[initialSize];
        this.numElements = 0;
    }

    private void resizeIfRequired(){
        if ((this.numElements + 1) >= this.elements.length){
            String[] newArray = new String[this.elements.length * 2];

            for (int i = 0; i < this.elements.length; i++){
                newArray[i] = this.elements[i];
            }

            this.elements = newArray;
        }
    }

    public void insertAtEnd(String newElement){
        resizeIfRequired();

        this.elements[this.numElements] = newElement;
        this.numElements++;
    }

    public String toString(){
        // We want our output to look like [ A B C ]
        String result = "[";

        //This will print blank spaces, to remove this use an iterator.
        for (String element : this.elements){
            result += element + " ";
        }
        result += "]";
        return result;
    }

    public void insertAtBeginning(String newElement){
        resizeIfRequired();

        for (int i = this.numElements - 1; i >= 0; i--){
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[0] = newElement;
        this.numElements++;
    }

    public void insertAtIndex(int index, String newElement){

        if (index >= this.numElements){
            throw new ArrayIndexOutOfBoundsException("No such index: " + index);
        }

        resizeIfRequired();

        for (int i = this.numElements - 1; i >= index; i--){
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[index] = newElement;
        this.numElements++;
    }

    public static void main(String[] args){
        BasicsArrayList myList = new BasicsArrayList(5);

        myList.insertAtEnd("Michael");
        myList.insertAtEnd("Rick");
        myList.insertAtEnd("Morty");
        myList.insertAtBeginning("Claire");
        myList.insertAtIndex(3, "Joey");
        myList.insertAtEnd("Bobby");

        System.out.println(myList);
    }

}
