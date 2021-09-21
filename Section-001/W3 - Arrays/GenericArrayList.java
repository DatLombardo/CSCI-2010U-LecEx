public class GenericArrayList<T> {
    private Object[] elements;
    private int numElements;

    /***
     * This is our general constructor to define our elements array.
     * @param initialSize - Initial size capacity of the array.
     */
    public GenericArrayList(int initialSize){
        this.elements = new Object[initialSize];
        this.numElements = 0;
    }

    private void resizeIfRequired(){
        if ((this.numElements + 1) >= this.elements.length){
            Object[] newArray = new Object[this.elements.length * 2];

            for (int i = 0; i < this.elements.length; i++){
                newArray[i] = this.elements[i];
            }

            this.elements = newArray;
        }
    }

    public void insertAtEnd(T newElement){
        resizeIfRequired();

        this.elements[this.numElements] = newElement;
        this.numElements++;
    }

    public String toString(){
        // We want our output to look like [ A B C ]
        String result = "[";

        //This will print blank spaces, to remove this use an iterator.
        //for (String element : this.elements){
        //    result += element + " ";
        //}
        for (int i = 0; i >= this.numElements; i++){
            result += this.elements[i] + " ";
        }

        result += "]";
        return result;
    }

    public void insertAtBeginning(T newElement){
        resizeIfRequired();

        for (int i = this.numElements - 1; i >= 0; i--){
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[0] = newElement;
        this.numElements++;
    }

    public void insertAtIndex(int index, T newElement){

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
        GenericArrayList<String> myList = new GenericArrayList<String>(5);

        myList.insertAtEnd("Michael");
        myList.insertAtEnd("Rick");
        myList.insertAtEnd("Morty");
        myList.insertAtBeginning("Claire");
        myList.insertAtIndex(3, "Joey");
        myList.insertAtEnd("Bobby");

        System.out.println(myList);
    }
}
