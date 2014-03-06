import java.util.Random;

public class SkipListOfStrings
    implements
      SetOfStrings
{
  // All the nodes are arranged in ascending order base on the ASCII table.

  public SkipListNode head; // First element of the top level
  public SkipListNode tail; // Last element of the top level

  public int numberOfEntries; // number of entries in the Skip list

  public int height; // Height
  public Random coinToss; // Coin toss

  public SkipListOfStrings () // Default constructor...
  {
    SkipListNode LeftMostNode, RightMostNode;

    LeftMostNode = new SkipListNode (SkipListNode.negInf);
    RightMostNode = new SkipListNode (SkipListNode.posInf);

    head = LeftMostNode;
    tail = RightMostNode;

    LeftMostNode.right = RightMostNode;
    RightMostNode.left = LeftMostNode;

    numberOfEntries = 0;
    height = 0;

    coinToss = new Random ();
  }// SkipListOfStrings ()

  /**
   * Determine if the set contains a particular string.
   */
  public boolean
    contains (String str)
  {
    // Find the position of the node that its key field is <=str. If there's a
    // node in the skip list that has str as its key field, then the key field
    // of the node at the founded position is str.
    SkipListNode desiredString = findNode (str);
    if (desiredString.toString () == str)
      return true;
    else
      return false;
  }// contains (String str)

  /*
   * findEntry(k): find the largest key x <= k on the LOWEST level of the Skip
   * List
   */
  public SkipListNode
    findNode (String str)
  {
    SkipListNode p;
    p = head;

    while (true)
      {
        while (p.right.key != SkipListNode.posInf
               && p.right.key.compareTo (str) <= 0)
          {
            p = p.right;
          }//while

        /*
         * --------------------------------- Go down one level if you can...
         * ---------------------------------
         */
        if (p.down != null)
          {
            p = p.down;
          }//if
        else
          break; // We reached the LOWEST level... Exit...
      }//while

    return (p); // p.key <= k
  }

  /**
   * Add an element to the set.
   * 
   * @post contains(str)
   */
  public void
    add (String str)
  {
    SkipListNode insertPosition, newNode;
    int level;

    // Create a new node and fix all the pointers accordingly.
    // We insert newNode to the right of insertPosition.
    insertPosition = findNode (str);
    newNode = new SkipListNode (str);
    newNode.left = insertPosition;
    newNode.right = insertPosition.right;
    insertPosition.right.left = newNode;
    insertPosition.right = newNode;

    level = 0;

    // Creates randomized heights for the nodes
    while (coinToss.nextDouble () < 0.5)
      {
        // Check if we need to increase the height of the RightMostNode and
        // LeftMostNode
        if (level >= height) // We reached the top level
          {
            SkipListNode p1, p2;
            height = height + 1;

            // Make a new SkipListNode on top of the RightMostNode and
            // LeftMostNode
            p1 = new SkipListNode (SkipListNode.negInf);
            p2 = new SkipListNode (SkipListNode.posInf);

            // Link the 2 nodes we've just created
            p1.right = p2;
            p1.down = head;

            p2.left = p1;
            p2.down = tail;

            head.up = p1;
            tail.up = p2;

            // Update head and tail
            head = p1;
            tail = p2;
          }//if

        // Go to the left until we find a node with that has a node right on top
        // of it
        while (insertPosition.up == null)
          {
            insertPosition = insertPosition.left;
          }//while

        // Otherwise, take us to the next level
        insertPosition = insertPosition.up;

        // add the node to the current level
        SkipListNode newNodeAtCurrentLevel;
        newNodeAtCurrentLevel = new SkipListNode (str); // Don't need the
                                                        // value...

        // Fix all the pointers
        newNodeAtCurrentLevel.left = insertPosition;
        newNodeAtCurrentLevel.right = insertPosition.right;
        newNodeAtCurrentLevel.down = newNode;
        insertPosition.right.left = newNodeAtCurrentLevel;
        insertPosition.right = newNodeAtCurrentLevel;
        newNode.up = newNodeAtCurrentLevel;

        newNode = newNodeAtCurrentLevel; // Set newNode up for the next
                                         // iteration
        level = level + 1; // Current level increased by 1
      }//while
    numberOfEntries = numberOfEntries + 1;
  }//add (String str)

  /**
   * Remove an element from the set.
   * 
   * @post !contains(str)
   */
  public void
    remove (String str)
  {
    SkipListNode deletedNode, leftNode, rightNode;

    // if the str is in the skip list, remove the node that contains it.
    if (contains (str) == true)
      {
        deletedNode = findNode (str);

        // If we aren't at the top level of deletedNode, keep deleting and
        // moving up
        while (deletedNode != null)
          {
            leftNode = deletedNode.left;
            rightNode = deletedNode.right;
            leftNode.right = rightNode;
            deletedNode = deletedNode.up;
          }//while
      }//if
  }//remove

  public void
    printHorizontal ()
  {
    String s = "";
    int i;

    SkipListNode currentNode;

    /*
     * ---------------------------------- Record the position of each entry
     * ----------------------------------
     */
    currentNode = head;

    while (currentNode.down != null)
      {
        currentNode = currentNode.down;
      }//while

    i = 0;
    while (currentNode != null)
      {
        currentNode.pos = i++;
        currentNode = currentNode.right;
      }//while

    /*
     * ------------------- Print... -------------------
     */
    currentNode = head;

    while (currentNode != null)
      {
        s = getOneRow (currentNode);
        System.out.println (s);

        currentNode = currentNode.down;
      }//while
  }//printHorizontal ()

  public String
    getOneRow (SkipListNode currentNode)
  {
    String printedString;
    int row, column, i;

    row = 0;

    printedString = "" + currentNode.key;
    currentNode = currentNode.right;

    while (currentNode != null)
      {
        SkipListNode q;

        q = currentNode;
        while (q.down != null)
          q = q.down;
        column = q.pos;

        printedString = printedString + " <-";

        for (i = row + 1; i < column; i++)
          printedString = printedString + "--------";

        printedString = printedString + "> " + currentNode.key;

        row = column;

        currentNode = currentNode.right;
      }//while

    return (printedString);
  }// getOneRow (SkipListNode currentNode)

}//SkipListOfStrings
