public class SkipListExpt
{

  /**
   * @param args
   */
  public static void
    main (String[] args)
  {
    SkipListOfStrings SkipList1 = new SkipListOfStrings ();
    SkipList1.add ("AKKK");
    SkipList1.add ("Be");
    SkipList1.add ("PR");
    SkipList1.add ("Cy");
    SkipList1.add ("Dq");
    SkipList1.add ("Fr");
    SkipList1.add ("HELLO");
    SkipList1.add ("Vt");
    SkipList1.add ("HELLO");
    SkipList1.printHorizontal ();
    SkipList1.remove ("HELLOfffff");// The node that contains the string "HELLO"
                                    // is not removed after this method call.
    SkipList1.remove ("Fr");
    SkipList1.remove ("Vt");
    System.out.println ("Expect true and false and we got: "
                        + SkipList1.contains ("HELLO") + " and "
                        + SkipList1.contains ("UGLY"));
    System.out.println ("UPDATED SKIPLIST");
    SkipList1.printHorizontal ();
    System.out.println ("The string contains in " + SkipList1.findNode ("Be"));
  }//main

}//SkipListExpt
