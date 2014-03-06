import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Rule;

import org.junit.rules.ExpectedException;

public class PartETest
{
  @Rule
  public ExpectedException exception = ExpectedException.none ();

  @Test
  public void
    testBinarySearch ()
      throws Exception
  {
    int[] newInts = new int[32];
    int newIntsSize = newInts.length;
    for (int i = 0; i < newIntsSize; i++)
      {
        newInts[i] = 2 * i;
      }// for
    for (int i = 0; i < newIntsSize; i++)
      {
        assert (PartE.binarySearch (2 * i, newInts) == i);
      }// for

    PartE obj1 = new PartE ();
    exception.expect (IllegalArgumentException.class);
    exception.expectMessage ("There's no val in values");
    obj1.binarySearch (-1, newInts);

  }// testBinarySearch

  @Test
  public void
    testBinarySearch2 ()
      throws Exception
  {
    int[] newInts = new int[32];
    int newIntsSize = newInts.length;
    for (int i = 0; i < newIntsSize; i++)
      {
        newInts[i] = 2 * i;
      }// for
    for (int i = 0; i < newIntsSize; i++)
      {
        assert (PartE.binarySearch (2 * i, newInts) == i);
      }// for

    for (int i = 0; i < newIntsSize; i++)
      {
        PartE obj = new PartE ();
        exception.expect (IllegalArgumentException.class);
        exception.expectMessage ("There's no val in values");
        obj.binarySearch (2 * i + 1, newInts);
      }// for
  }//testBinarySearch2 ()
}// PartETest

