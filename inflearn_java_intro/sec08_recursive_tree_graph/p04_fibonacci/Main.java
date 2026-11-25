package inflearn_java_intro.sec08_recursive_tree_graph.p04_fibonacci;

public class Main {
    // 메모이제이션
    static int[] fibonacci;

    public static void main(String[] args) {
        int n = 10;
        fibonacci = new int[n];

        dfs3(n);

        for (int i=0; i<n; i++) {
            System.out.printf("%d ", fibonacci[i]);
        }
    }

    public static int dfs3(int n) {
        if (n == 1|| n == 2) return fibonacci[n-1] = 1;
        if (fibonacci[n-1] > 0) { // 메모이제이션 활용해서 시간복잡도 감소
            return fibonacci[n-1];
        }
        return fibonacci[n-1] = dfs3(n-2) + dfs3(n-1);
    }

    public static int dfs2(int n) {
        if (n == 1|| n == 2) return fibonacci[n-1] = 1;
        return fibonacci[n-1] = dfs2(n-2) + dfs2(n-1);
    }

    public static int dfs1(int n) {
        if (n == 1 || n == 2) return 1;
        return dfs1(n-2) + dfs1(n-1);
    }
} 