public class PartB
{

  /**
   * @param args
   */

  public void
    dnf (String[] vals, StringClassifier classifier)
  {
    int Lo = 0, Mid = 0, Hi = vals.length - 1;
    int[] classified = new int[vals.length];

    int valsSize = vals.length;
    for (int i = 0; i < valsSize; i++)
      {
        classified[i] = classifier.classify (vals[i]);
      }// for

    // Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi]
    // are unknown.
    while (Mid <= Hi)
      {
        if (classified[Mid] < 0)
          {
            // swap classified[Lo] with classified[Mid] and vals[Lo] with
            // vals[Mid]
            int tempClassifiedLo = classified[Lo];
            String tempValsLo = vals[Lo];

            classified[Lo] = classified[Mid];
            vals[Lo] = vals[Mid];

            classified[Mid] = tempClassifiedLo;
            vals[Mid] = tempValsLo;

            Lo++;
            Mid++;
          }// if

        else if (classified[Mid] == 0)
          {
            Mid++;
          }// else if

        else if (classified[Mid] > 0)
          {
            // swap classified[Mid] with classified[Hi] and vals[Mid] with
            // vals[Hi]
            int tempClassifiedMid = classified[Mid];
            String tempValsMid = vals[Mid];

            classified[Mid] = classified[Hi];
            vals[Mid] = vals[Hi];

            classified[Hi] = tempClassifiedMid;
            vals[Hi] = tempValsMid;

            Hi--;
          }// else if
      }// while
  }// dnf (String[] vals, StringClassifier classifier)

  // The output fit our expectation
  public static void
    main (String[] args)
  {
    String[] string1 = { "cat", "Morning", "a", "dog", "lol", "Hello",
                        "Jioeafjhweo" };
    StringClassifier classify1 = new StringClassifier ();

    PartB partB = new PartB ();

    partB.dnf (string1, classify1);
    for (int i = 0; i < string1.length; i++)
      {
        System.out.println (string1[i]);
      }// for
  }// main

}// PartB
