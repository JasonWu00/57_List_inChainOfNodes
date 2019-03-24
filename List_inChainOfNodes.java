/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;
    private int length;

    /**
      Construct an empty list
     */


    /**
      @return the number of elements in this list
     */
    public int size() {
      return length;
    }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
      String output = "";
      if (headReference != null)
        output += length + " elements [" + headReference.toString() + "]";
      else
        output = "0 elements [null]";
      return output;
    }


    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
       Node restOfBody = headReference;
       Node newHead = new Node(val, restOfBody);
       headReference = newHead;
       length++;
        return true;
     }
}
