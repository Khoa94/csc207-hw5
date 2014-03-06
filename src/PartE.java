public class PartE
{
  /**
   * Find the average of 2 integers
   */
  public static int
    average (int a, int b)
  {
    return ((a + b) / 2);
  }// average

  /**
   * Find the index of val in values.
   */
  public static int
    binarySearch (int val, int[] values)
      throws Exception
  {
    int lb = 0;
    int ub = values.length;

    // Loop invariants:
    // for all i, 0 <= i < lb, values[i] < val
    // for all i, ub <= i < length, values[i] > val
    // lb >= ub
    while ((ub - lb) > 0)
      {
        int mid = average (lb, ub);
        if (values[mid] < val)
          lb = mid + 1;
        else if (values[mid] > val)
          ub = mid;
        else
          return mid;
      } // while
    throw new IllegalArgumentException ("There's no val in values");

  } // binarySearch(int[], int)

  public static void
    main (String[] args)
      throws Exception
  {
    int[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 10 };
    int result = binarySearch (10, values);
    System.out.println (result);
  }// main
}// PartE
