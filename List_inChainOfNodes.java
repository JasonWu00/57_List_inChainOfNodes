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

    public int size(String a){
      if (a == "Use a loop")
        if (headReference == null)
          length = 0;
        else
          length = headReference.sizeUsingLoops(headReference);
      return length;
    }

    public Node getAtIndex(int index) {
      return headReference.get(headReference, index);
    }

    public void setAtIndex(int index, Object value){
      headReference.set(headReference, index, value);
    }

    public void addAtIndex(int index, Object value) {
      Node backPortion = headReference.get(headReference, index);
      Node frontPortion = headReference;
      Node middlePortion = new Node(value);
      frontPortion.cutOffList(frontPortion, index);
      //ends frontPortion at where the backPortion got snipped
      frontPortion.connectLists(frontPortion, middlePortion);
      //add a new Node holding the value to the end
      frontPortion.connectLists(frontPortion, backPortion);
      //add backPortion to that
      headReference = frontPortion;
      length++;
    }

    /*public void removeAtIndex(int index) {
      Node backPortion = headReference.get(headReference, index + 1);
      Node frontPortion = headReference.get(headReference, index - 1);
      frontPortion.connectLists(frontPortion, backPortion);
      frontPortion.cutOffList(frontPortion, length);
      //headReference = frontPortion;
    }*/
    //Above commented out method is bugged, will be fixed later

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
