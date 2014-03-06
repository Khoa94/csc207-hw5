import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Rule;

import org.junit.rules.ExpectedException;

//Our implementation of binarySearch passes all the test below.
public class PartETest
{
  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void testBinarySearch()
    throws Exception
  {
    int[] newInts = new int[32];
    int newIntsSize = newInts.length;

    // assign values to newInts
    for (int i = 0; i < newIntsSize; i++)
      {
        newInts[i] = 2 * i;
      }// for

    // Make sure that value 2*i is in position i
    for (int i = 0; i < newIntsSize; i++)
      {
        assert (PartE.binarySearch(2 * i, newInts) == i);
      }// for

    // -1 should not be in the array
    PartE obj1 = new PartE();
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("There's no val in values");
    obj1.binarySearch(-1, newInts);

  }// testBinarySearch

  // We have to create this separate test because when we group this test with
  // the above test together into 1 method, that method doesn't work as we
  // expected.
  @Test
  public void testBinarySearchForOddValues()
    throws Exception
  {
    int[] newInts = new int[32];
    int newIntsSize = newInts.length;
    // assign values to newInts
    for (int i = 0; i < newIntsSize; i++)
      {
        newInts[i] = 2 * i;
      }// for

    // Make sure that odd values are not in the array
    for (int i = 0; i < newIntsSize; i++)
      {
        PartE obj = new PartE();
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("There's no val in values");
        obj.binarySearch(2 * i + 1, newInts);
      }// for
  }
}// PartETest


