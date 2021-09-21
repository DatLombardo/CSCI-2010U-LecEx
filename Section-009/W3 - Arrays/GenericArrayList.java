public class GenericArrayList<T> {
    private Object[] elements;
    private int numElements;

    /***
     * This is the constructor which takes a capacity, and defines the array and it's length parameter.
     * This is an example of using javadoc.
     * @param initialSize - capacity integer, setting the initial array size
     */
    public GenericArrayList(int initialSize){
        this.elements = new Object[initialSize];
        this.numElements = 0;
    }

    private void resizeIfRequired(){
        if ((this.numElements + 1) >= this.elements.length) {
            Object[] newArray = new Object[this.elements.length * 2];


            for (int i = 0; i < this.elements.length; i++) {
                newArray[i] = this.elements[i];
            }
            //Replace elements with the new larger array.
            this.elements = newArray;
        }
    }

    public void insertAtEnd(T newElement){
        resizeIfRequired();

        this.elements[this.numElements] = newElement;
        this.numElements++;
    }

    public String toString(){
        //We want output to look like [ A B C ]
        String result = "[";

        for (int i = 0; i < this.numElements; i++){
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
        myList.insertAtEnd("Bob");
        myList.insertAtEnd("Rick");
        myList.insertAtEnd("Morty");
        myList.insertAtBeginning("Michael");
        myList.insertAtBeginning("Jeniffer");
        myList.insertAtIndex(3, "Kylie");

        System.out.println(myList);
    }
}
