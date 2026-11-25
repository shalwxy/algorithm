package inflearn_java_intro.sec08_recursive_tree_graph.p03_factorial;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(dfs1(n));
    }

    public static int dfs1(int n) {
        if (n == 1) return 1;
        return n * dfs1(n-1);
    }
}