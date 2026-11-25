package inflearn_java_intro.sec08_recursive_tree_graph.p01_func_recursive;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        dfs2(n);
    }

    public static void dfs2(int n) {
        if (n == 0) return;
        dfs2(n-1);
        System.out.printf("%d ", n);
    }

    public static void dfs1(int n) {
        if (n == 0) return;
        System.out.printf("%d ", n);
        dfs1(n-1);
    }
}
