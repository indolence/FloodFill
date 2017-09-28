public class FloodFillTester
{
   public static void main(String[] args)
   {
      Grid gr = new Grid();
      gr.floodfill(3, 4);
      String[] rows = gr.toString().split("\n");
      System.out.println(rows[2]);
      System.out.println("Expected: 15  12   9   6   2  81  79  77  75  73");
      System.out.println(rows[3]);
      System.out.println("Expected: 14  11   8   5   1   3  78  76  74  72");
      System.out.println(rows[4]);
      System.out.println("Expected: 16  13  10   7   4  63  65  67  69  71");
      gr = new Grid();
      gr.floodfill(0, 0);
      rows = gr.toString().split("\n");
      System.out.println(rows[0]);
      System.out.println("Expected:   1   2  86  88  90  92  94  96  98 100");
      System.out.println(rows[1]);
      System.out.println("Expected:   3   4  85  87  89  91  93  95  97  99");
      System.out.println(rows[2]);
      System.out.println("Expected:   5   6  84  82  80  78  76  74  72  70");
   }
}
