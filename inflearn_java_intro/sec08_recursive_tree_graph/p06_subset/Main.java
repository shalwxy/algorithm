package inflearn_java_intro.sec08_recursive_tree_graph.p06_subset;

public class Main {

    public static int n;
    public static int[] check;

    public static void main(String[] args) {
        n = 3;
        check = new int[n];

        dfs1(1);
    }

    public static void dfs1(int l) {
        if (l == n+1) {
            for (int i=0; i<check.length; i++) {
                if (check[i] == 1) {
                    System.out.printf("%d ", i+1);
                }
            }
            System.out.println();
            return;
        }
        check[l-1] = 1;
        dfs1(l+1);

        check[l-1] = 0;
        dfs1(l+1);
    }
}