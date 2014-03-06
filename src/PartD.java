public class PartD
{
  public double
    expt (double x, int n)
  {
    double result = 1;

    int power = Math.abs (n); // make sure numberOfEntries >= 0

    // Loop invariant: x^numberOfEntries=(result)(x^power)
    while (power != 0)
      {
        // when numberOfEntries is even
        if (power % 2 == 0)
          {
            power = power / 2;
            x = x * x;
          }// if

        // when numberOfEntries is odd
        else
          {
            result = result * x;
            power = power - 1;
            x = x * x;
            power = power / 2;
          }// else
      }// while

    if (n >= 0)
      return result;
    else
      return (1 / result);
  }// double expt(double x, int numberOfEntries)

  /**
   * @param args
   */
  public static void
    main (String[] args)
  {
    PartD partD = new PartD ();
    System.out.println ("The final result is " + partD.expt (5, -4));
  }// main

}// PartD
