public class SinglyLinkedList {
    class SLLNode{
        public String value;
        public SLLNode next;
    }

    //Initial state of our singly linked list
    private SLLNode head = null;

    public void insertAtBeginning(String newValue){
        SLLNode newNode = new SLLNode();
        newNode.value = newValue;
        newNode.next = head;

        head = newNode;
    }

    public void insertAtEnd(String newValue){
        if (head == null){
            insertAtBeginning(newValue);
            return;
        }

        SLLNode current = head;
        SLLNode prev = null;
        // find end by these conditions
        //1. current == null;
        //2. current.next == null;
        while (current != null){
            prev = current;
            current = current.next;
        }

        //create our new node
        SLLNode newNode = new SLLNode();
        newNode.value = newValue;
        newNode.next = null;

        //point to our new node from the previous end
        prev.next = newNode;
    }

    public String toString(){
        String result = "[";

        //Create a temp node for iteration
        SLLNode current = head;
        while (current != null){
            result += current.value + " ";
            current = current.next;
        }

        return result + "]";
    }

    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();

        myList.insertAtEnd("Michael");
        myList.insertAtEnd("Faisal");
        myList.insertAtBeginning("Randy");
        myList.insertAtBeginning("Ken");
        myList.insertAtEnd("Jarek");
        myList.insertAtBeginning("Jeremy");

        System.out.println(myList);
    }


}
