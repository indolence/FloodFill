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
     
     while (num <= 100){
          
         if(pixels[row][column] == 0){  // test for empty starting point            
            x = column;
            y = row;
            pixels[x][y] = num;
            num++;         
            PairList.push(new coOrdPair(x--, y));
           }          
            else{
           
            if (y - 1 >= 0 && pixels[x][y-1] == 0){
               constant = PairList.pop();
               x = constant.getX();
               y = constant.getY();
               pixels[x--][y] = num; // put first number in starting point of array
               PairList.push(new coOrdPair(x--, y));
               num++; 
   
            }
                            
            if (x - 1 >= 0 && pixels[x-1][y] == 0 ){
                constant = PairList.pop();
                x = constant.getX();
                y = constant.getY();
                pixels[x][y--] = num; // enter next num into double array
                PairList.push(new coOrdPair(x++, y));
                num++;
                
             }
                
            if (y + 1 < SIZE && pixels[x][y+1] == 0 ){
                constant = PairList.pop();
                x = constant.getX();
                y = constant.getY();
                pixels[x++][y] = num; // enter next num into double array
                PairList.push(new coOrdPair(x, y++));
                num++;
                
            }
                
            if (x+1 < SIZE && pixels[x+1][y] == 0){
                constant = PairList.pop();
               x = constant.getX();
               y = constant.getY();
               pixels[x][y++] = num; // put first number in starting point of array
               PairList.push(new coOrdPair(x--, y));
               num++;
     
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
