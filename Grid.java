import java.util.*;

public class Grid
{
   private static final int SIZE = 10;
   int[][] pixels = new int[SIZE][SIZE];
   Stack<coOrdPair> PairList = new Stack<>();  /// queue numList for array
   int num = 1;
   int x, y;
   

   /**
      Flood fill, starting with the given row and column.
   */
   public void floodfill(int row, int column)
   {     
     // thank you Michael and Mr Hayes for helping explain everything!!!
     // I actually get it now!!! (don't hate recursion anymore!!)
     
     while (num <= 100){
          
         if(pixels[row][column] == 0){  // test for empty starting point            
            PairList.push(new coOrdPair(row, column)); // enter onto stack
            pixels[row][column] = num; // assing non-0 number, false for recursion
            num++;  // increase num       
            
           }          
           
           while (!PairList.empty()){
           
            if (row + 1 <= 9 && pixels[row+1][column] == 0) // tests to make sure there is still room in row, and
            {                                               // that the space has not been assigned in a previous call
               PairList.push(new coOrdPair(row+1, column));  // push next pair onto stack
               pixels[row+1][column] = num;  // assigns space to non-0 number, will come up false in recursion
               num++;                // increase num
            }
            
            if (row - 1 >= 0 && pixels[row-1][column] == 0) // tests to make sure there is still room in row, and
            {                                               // that the space has not been assigned previously
               PairList.push(new coOrdPair(row-1, column));  // push next pair onto stack
               pixels[row-1][column] = num;  // assigns space to non-0 number, will come up false in recursion
               num++;                // increase num
            }
            
            if (column - 1 >= 0 && pixels[row][column-1] == 0) // tests to make sure there is still room in col, and
            {                                               // that the space has not been assigned previously
               PairList.push(new coOrdPair(row, column-1));  // push next pair onto stack
               pixels[row][column-1] = num;  // assigns space to non-0 number, will come up false in recursion
               num++;                // increase num
            }
            
            if (column + 1 <= 9 && pixels[row][column+1] == 0) // tests to make sure there is still room in col, and
            {                                               // that the space has not been assigned previously
               PairList.push(new coOrdPair(row, column+1));  // push next pair onto stack
               pixels[row][column+1] = num;  // assigns space to non-0 number, will come up false in recursion
               num++;                // increase num
            }
               
            
               
         coOrdPair coord = PairList.pop(); //pop off next coOrd ti test east, west, north, south
         x = coord.getX();
         y = coord.getY();
         floodfill(x, y); // remember Mr Hayes example - when it runs out of
                         // spaces, it goes back to LAST ONE on stack, and runs it again
                         // until there is nothing left to pop off (because nothing else
                         // was empty) and the entire loop will end                   
            
        } // end of while loop - ends when PairList is empty
      }
      
    }
   
   
   @Override
   public String toString()
   {
      String r = "";
      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
            r = r + String.format("%4d", pixels[i][j]);
         r = r + "\n";
      }
      return r;
   }
}// end of class

/*
 * Output:
  43  40  37  34  31  29  27  25  23  21
  41  38  35  32  30  28  26  24  22  20
  42  39  36  33   3   7  10  13  16  19
  44  46  48   4   1   5   8  11  14  17
  45  47  49  51   2   6   9  12  15  18
  89  90  50  52  54  56  58  60  62  64
  88  85  82  53  55  57  59  61  63  65
  86  83  80  78  76  74  72  70  68  66
  87  84  81  79  77  75  73  71  69  67
  91  92  93  94  95  96  97  98  99 100
 * 
 */


