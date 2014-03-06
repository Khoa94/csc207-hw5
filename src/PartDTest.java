import static org.junit.Assert.*;

import org.junit.Test;

public class PartDTest
{

  @Test
  public void
    testExpt ()
  {
    PartD partD = new PartD ();

    // base goes from -20 to 20. power goes from -10 to 10. The below test is
    // passed
    for (int i = -21; i < 21; i++)
      {
        for (int j = -11; j < 11; j++)
          {
            assertEquals (Math.pow (i, j), partD.expt (i, j), 0.01);
          }// for
      }// for
  }// testExpt()

}// PartDTest
