/**
  Represent a node that holds...
  o  cargo of interest to the user
  o  reference to the next node in the list
 */

public class Node {
    private Object cargoReference;
    private Node   referenceToNextNode;


    /**
      Construct an instance
     */
    public Node(){

    }
    public Node( Object cargoReference) {
      this.cargoReference = cargoReference;
    }
    public Node( Object cargoReference, Node referenceToNextNode) {
        /* For incremental development with the skeleton's UserOfNode,
           postpone writing this constructor until after the accessors.
           Then remove this comment, of course.
         */
      this(cargoReference);
      setReferenceToNextNode(referenceToNextNode);
    }

    /**
      @return a string representation of this instance
     */
    public String toString() {
        String result =
            cargoReference.toString()  // polymorphically use appropriately toString!
          ;

        // Show rest of chain of nodes
        if( referenceToNextNode == null)
             result += " [no next]";
        else result += " --> " + referenceToNextNode;
        return result;
    }

    // classic accessor and mutator
    public Node getReferenceToNextNode() {
      return referenceToNextNode;
    }

    public Object getCargoReference() {
      return cargoReference;
    }

    public void setReferenceToNextNode( Node referenceToNextNode) {
      this.referenceToNextNode = referenceToNextNode;
    }

    public int sizeUsingLoops(Node node){
      int output = 1;
        if (node.referenceToNextNode == null) {
          //System.out.println("End");
        }
        else {
          output += sizeUsingLoops(node.referenceToNextNode);
          //System.out.println("Not end");
        }
      return output;
    }

    public Node get(Node node, int index){
      Node currentNode = new Node();
        if (index == 0) //base case
          currentNode = node;
        else if (node.referenceToNextNode == null || index == 1) { //binary decision
          currentNode = node.referenceToNextNode; //also base case
        }
        else { //recursive case
          currentNode.cargoReference = get(node.referenceToNextNode, index - 1);
        }
      return currentNode;
    }

    public void set(Node node, int index, Object value){
        if (index == 0) //base case
          node.cargoReference = value;
        else if (node.referenceToNextNode == null || index == 1) { //binary decision
          node.referenceToNextNode.cargoReference = value; //also base case
        }
        else { //recursive case
          set(node.referenceToNextNode, index - 1, value);
        }
    }

    public void cutOffList(Node node, int index){ //helper function for addAtIndex
        if (index == 0) //base case
          node.cargoReference = null;
        else if (node.referenceToNextNode == null || index == 1) { //binary decision
          node.referenceToNextNode = null; //also base case
        }
        else { //recursive case
          cutOffList(node.referenceToNextNode, index - 1);
        }
    }

    public void connectLists(Node parentNode, Node tailNode) {
      if (parentNode.referenceToNextNode == null) { //binary decision
        parentNode.referenceToNextNode = tailNode; //also base case
      }
      else { //recursive case
        connectLists(parentNode.referenceToNextNode, tailNode);
      }
  }
}
