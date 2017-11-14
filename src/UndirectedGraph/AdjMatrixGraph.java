package UndirectedGraph;



import MyDataStructures.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by catalin.dinu on 11/1/2017.
 */

public class AdjMatrixGraph {

    private int n;
    private int[][] verticesMatrix;
    // will keep track if node was visited
    boolean [] visited;



    public AdjMatrixGraph(int n){
        this.n = n;
        verticesMatrix = new int[n][n];
        visited = new boolean[n];
    }

    public int addEdge(int i, int j){
        return verticesMatrix[i][j] = 1;
    }

    public int removeEdge(int i, int j){
        return verticesMatrix[i][j] = 0;
    }

    public boolean hasEdge(int i, int j){
        return verticesMatrix[i][j] != 0;
    }


    /*
    * breadth first search
    * */
    public List<Integer> bfs (int source){
        //  initialization of visited array
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // retrieves the path from source to dest
        List<Integer> verticesPath = new ArrayList<>();

        // manage the queue as we advance the path
        Queue<Integer> verticesQueue = new Queue<>();

        verticesQueue.offer(source);


        while (!verticesQueue.isEmpty()) {
            int current = verticesQueue.poll();
            visited[current] = true;
            for (int i = 0; i < n; i++){
                if(verticesMatrix[current][i] == 1 && visited[i] == false){
                    verticesQueue.offer(i);
                }
            }

        }
        return verticesPath;
    }



    /*
    * depth first search
    * */
//    public void exploreLongestPathForward(int source){
//        Stack<Integer> verticesStack = new Stack<>();
//
//        for (int i = 0; i < visited.length; i++) {
//            visited[i] = false;
//        }
//        explore(source, verticesStack);
//    }
//
//    private void explore(int source, Stack<Integer> verticesStack) {
//        verticesStack.push(source);
//        int current = verticesStack.peek();
//        visited[current] = true;
//
//        while (visited[current] == true) {
//
//            for (int i = 0; i < n; i++) {
//                if(verticesMatrix[current][i] == 1) {
//                    current = i;
//                    visited[current] = true;
//                    verticesStack.push(i);
//                }else {
//                    verticesStack.pop();
//                    explore(verticesStack.peek(), verticesStack);
//                }
//            }
//        }
//    }


    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "%d vertex AdjMatrixGraph" + n;
    }
}
