package experiments;

/**
 * 棋盘覆盖问题
 * Created by 36249 on 2017/4/5.
 */
public class ChessOverride {

    private int count;
    public int[][] overrideChessBoard(int[][] arr,int x,int y){

        arr[x][y] = count++;
        int length = arr.length;
        recursive(arr,x,y,0,0,length);
        return arr;
    }

    private void recursive(int[][] arr,int x,int y,int leftX,
                           int leftY,int length){
        if(length < 2){

            return;
        }
        if(length == 2){

            for(int i = leftX; i < leftX + length;++i){

                for(int j = leftY; j < leftY + length; ++j){

                    if(i == x && j ==y) {

                        continue;
                    }
                    arr[i][j] = count;
                }
            }
            ++count;
            return;
        }

        int x1,y1;
        int x2,y2;
        int x3,y3;
        int x4,y4;

        x1 = leftX + length/2-1;
        y1 = leftY + length/2 - 1;
        x2 = x1 + 1;
        y2 = y1;
        x3 = x1;
        y3 = y1 + 1;
        x4 = x3 + 1;
        y4 = y3;
        int d1,d2,d3,d4;


        if(x < leftX + length/2 && y < leftY + length /2){
            //特殊点在左上角
            x1 = x;
            y1 = y;
            arr[x2][y2] = count;
            arr[x3][y3] = count;
            arr[x4][y4] = count;
        }
        else if(x >= leftX + length/2 && y < leftY + length/2){
            //特殊点在右上角

            x2 = x;
            y2 = y;
            arr[x1][y1] = count;
            arr[x3][y3] = count;
            arr[x4][y4] = count;
        }
        else if(x < leftX + length/2 && y >= leftY + length /2){
            //特殊点在左下角

            x3 = x;
            y3 = y;
            arr[x1][y1] = count;
            arr[x2][y2] = count;
            arr[x4][y4] = count;
        }
        else{
            //特殊点在右下角

            x4 = x;
            y4 =y;
            arr[x1][y1] = count;
            arr[x2][y2] = count;
            arr[x3][y3] = count;
        }
        ++count;
        recursive(arr,x1,y1,leftX,leftY,length/2);
        recursive(arr,x2,y2,leftX+length/2,leftY,length/2);
        recursive(arr,x3,y3,leftX,leftY+length/2,length/2);
        recursive(arr,x4,y4,leftX+length/2,leftY+length/2,length/2);
    }

    public static void main(String[] args) {

        final int LEN = 8;
        ChessOverride second = new ChessOverride();
        int[][] arr = new int[LEN][];
        for(int i = 0; i < LEN ;++i){

            arr[i] = new int[LEN];
        }

        second.overrideChessBoard(arr,3,3);
        for(int i = 0; i < LEN;++i){

            for(int j = 0 ; j < LEN ;++j){

                System.out.printf("%2d ",arr[i][j]);
            }

            System.out.println();
        }
    }
}
