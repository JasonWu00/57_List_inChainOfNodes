/**
 Test list features.
 */
public class UserOfList {
    public static void main( String[] args ) {
        List_inChainOfNodes list = new List_inChainOfNodes();

        System.out.println( "number of elements: " + list.size("Use a loop") );

        // the spec requests that toString include the size
        System.out.println( "empty list: " + list
                          + System.lineSeparator());

        /* Populate the list with elements.
           Create the test data in an array, for the programming
           convenience of being able to loop through it.
        */
        String[] elements = new String[]{"y","u","t","S",};
            /* convenient syntax      ^^^^^^^^^^^^^^^^^^^^
               for convenient way to init an array of Strings */
        int elemIndex;
        for( String elem : elements ) {
            list.addAsHead( elem);
            System.out.println( "number of elements: " + list.size("Use a loop") );
        }
        System.out.println( "populated list: " + list
                          + System.lineSeparator());

        System.out.println("Testing get method, it should retrieve Node number 2");
        System.out.println(list.getAtIndex(2));
        System.out.println("Again, but with Node 0");
        System.out.println(list.getAtIndex(0) + System.lineSeparator());

        System.out.println("Changing Node 0 to contain the letter B");
        list.setAtIndex(0, "B");
        System.out.println(list.getAtIndex(0));
        System.out.println(list + System.lineSeparator());

        System.out.println("Changing Node 3 to contain a lowercase D");
        list.setAtIndex(3, "d");
        System.out.println(list.getAtIndex(3));
        System.out.println(list + System.lineSeparator());

        System.out.println("Now adding a Node holding the number 3 as Node 2.");
        list.addAtIndex(2, 3);
        System.out.println(list + System.lineSeparator());

        System.out.println("Now to remove the previously added node");
        list.removeAtIndex(2);
        System.out.println(list + System.lineSeparator());
    }
}
