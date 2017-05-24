package experiments;

/**
 * Created by 36249 on 2017/5/24.
 */

/**
 * 回溯法实现图的m着色问题
 */
public class MColoringProblemOfGraphs {


    private int vertexNum;
    private int colorNum;
    private int[][] graph;
    private int[] resultVector;
    private int resultNum;

    private int func(int vertexNum,int colorNum,int[][] graph){

        this.vertexNum = vertexNum;
        this.colorNum = colorNum;
        this.graph = graph;
        this.resultVector = new int[vertexNum];
        resultNum = 0;

        for(int i = 0; i < vertexNum; ++i){

            resultVector[i] = -1;
        }

        func(0);

        return resultNum;
    }

    private void func(int index){

        if(index >= vertexNum){

            ++resultNum;

            for(int i = 0; i < vertexNum; ++i){

                System.out.print(resultVector[i] + " ");
            }
            System.out.println();
        }
        else{

            for(int i = 0; i < colorNum ;++i){

                resultVector[index] = i;
                if(isOK(index)){

                    func(index+1);
                }
                resultVector[index] = -1;
            }

        }


    }
    private boolean isOK(int index){

        for(int i = 0; i < vertexNum ; ++i){

            if(i != index && graph[index][i] == 1 && resultVector[index] == resultVector[i]){

                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {


        int vertexNum = 3;
        int colorNum = 3;
        int[][] graph = new int[3][];
        for(int i = 0; i < graph.length ;++i){

            graph[i] = new int[3];
        }

        graph[0][1] = 1;
        graph[0][2] = 1;

        graph[1][0] = 1;
        graph[1][2] = 1;

        graph[2][0] = 1;
        graph[2][1] = 1;

        MColoringProblemOfGraphs test = new MColoringProblemOfGraphs();
        System.out.println(test.func(vertexNum,colorNum,graph));

    }

}
