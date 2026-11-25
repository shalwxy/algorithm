package inflearn_java_intro.sec08_recursive_tree_graph.p02_binary_recursive;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        dfs2(n);
    }

    public static void dfs2(int n) {
        if (n == 0) return;
        dfs2(n/2);
        System.out.printf("%d", n%2);
    }
}