public class SkipListNode
{
  public String key;

  public int pos; // We added this to print the skiplist "nicely"

  public SkipListNode up, down, left, right;

  public static String negInf = new String ("-oo"); // -inf key value
  public static String posInf = new String ("+oo"); // +inf key value

  public SkipListNode (String str)
  {
    key = str;
    up = down = left = right = null;
  }//SkipListNode (String k)

  public boolean
    equals (Object o)
  {
    SkipListNode ent;

    try
      {
        ent = (SkipListNode) o; // Test if o is a SkipListNode...
      }//try
    catch (ClassCastException ex)
      {
        return false;
      }//catch

    return (ent.toString () == key);
  }//equals (Object o)

  public String
    toString ()
  {
    return key;
  }//toString ()
}//SkipListNode 