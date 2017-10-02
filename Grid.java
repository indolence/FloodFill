import java.util.*;

public class Grid
{
   private static final int SIZE = 10;
   int[][] pixels = new int[SIZE][SIZE];
   Stack<coOrdPair> PairList = new Stack<>();  /// queue numList for array
   coOrdPair constant = new coOrdPair(0, 0);
   int num = 1;
   int x, y;
   

   /**
      Flood fill, starting with the given row and column.
   */
   public void floodfill(int row, int column)
   {
     // take this out - double pop. stack PairList.push(new coOrdPair(row, column));
     
     while (num <= 100){
          
         if(pixels[row][column] == 0){  // test for empty starting point            
            PairList.push(new coOrdPair(row, column)); // enter onto stack
            pixels[row][column] = num; // assing non-0 number, false for recursion
            num++;  // increase num       
            
           }          
            while (!PairList.empty()){
           
            if (row + 1 <= 9 && pixels[row+1][column] == 0) // tests to make sure there is still room in row, and
            {                                               // that the space has not been assigned in a previous call
               PairList.push(new coOrdPair(row+1, column);  // push next pair onto stack
               pixels[row+1][column] = num;  // assigns space to non-0 number, will come up false in recursion
               num++;                // increase num
            }
               
            }
               
       CoOrdPair coord = PairList.pop();
               x = coord.getX;
               y = coord.getY;
               floodfill(x, y) // remember Mr Hayes example - when it runs out of
                               // spaces, it goes back to LAST ONE on stack, and runs it again
                       
            
        }
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
}
