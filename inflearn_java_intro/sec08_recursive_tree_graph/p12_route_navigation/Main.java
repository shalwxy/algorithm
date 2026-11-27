package inflearn_java_intro.sec08_recursive_tree_graph.p12_route_navigation;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int answer = 0;

    public static void main(String[] args) {
        int v = 5;
        int[][] graph = {
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 1},
                {2, 3},
                {2, 5},
                {3, 4},
                {4, 2},
                {4, 5},
        };
        System.out.println(solution1(v, graph));
    }

    public static int solution1(int v, int[][] graph) {
        int[][] adjacencyMatrix = new int[v][v];
        int[] check = new int[v];
        for (int i=0; i<graph.length; i++) {
            for (int j=0; j<graph[i].length; j++) {
                adjacencyMatrix[graph[i][0]-1][graph[i][1]-1] = 1;
                adjacencyMatrix[graph[i][1]-1][graph[i][0]-1] = 1;
            }
        }
        dfs1(1, v, adjacencyMatrix, check);
        return answer;
    }

    public static void dfs1(int vSource, int vTarget, int[][] adjacencyMatrix, int[] check) {
        if (vSource == vTarget) { answer++; }
        else {
            for (int i=0; i<vTarget; i++) {
                if (adjacencyMatrix[vSource][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    dfs1(i+1, vTarget, adjacencyMatrix, check);
                    check[i] = 0;
                }
            }
        }
    }
}