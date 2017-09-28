import java.util.*;

public class Grid
{
   private static final int SIZE = 10;
   int[][] pixels = new int[SIZE][SIZE];
   Queue<Integer> numList = new LinkedList<>();  /// queue numList for array
   int flag = 0;
   

   /**
      Flood fill, starting with the given row and column.
   */
   public void floodfill(int row, int column)
   {
      for (int i = 1; i <= (SIZE * SIZE); i++)
       { numList.add(i); }  // populate numList queue
       
      while (numList.size() > 0){
          if(pixels[row][column] == 0)  // test for empty starting point
            pixels[row][column] = numList.remove(); // put first number in starting point of array
          else{
            if (row+1 < SIZE && pixels[row+1][column] == 0){
                
                row++;   
            }         
            else if (column + 1 < SIZE && pixels[row][column+1] == 0 ){
                
                column++;   
            }          
            else if (column - 1 >= 0 && pixels[row][column-1] == 0){
                
                column--;   
            }
            else if (row - 1 >= 0 && pixels[row-1][column] == 0 ){
                
                row--;     
            }
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
