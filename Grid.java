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
     PairList.push(new coOrdPair(row, column));
     
     while (!PairList.empty()){
          
         if(pixels[row][column] == 0){  // test for empty starting point            
            constant = PairList.pop();
            x = constant.getX();
            y = constant.getY();
            pixels[row][column] = num; // put first number in starting point of array
            PairList.push(new coOrdPair(x, y--));
            num++;
           }          
            else{
           
            if (row - 1 >= 0 && pixels[row-1][column] == 0 ){
                constant = PairList.pop();
                x = constant.getX();
                y = constant.getY();
                pixels[row][column] = num; // enter next num into double array
                PairList.push(new coOrdPair(x++, y));
                num++;
                
             }
                
            if (column + 1 < SIZE && pixels[row][column+1] == 0 ){
                constant = PairList.pop();
                x = constant.getX();
                y = constant.getY();
                pixels[row][column] = num; // enter next num into double array
                PairList.push(new coOrdPair(x, y++));
                num++;
                
            }
                
            if (row+1 < SIZE && pixels[row+1][column] == 0){
                
     
            }         
            
                      
            
            if (column - 1 >= 0 && pixels[row][column-1] == 0){
                
   
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
