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
            String tmp = "";
            for (int i=0; i<check.length; i++) {
                if (check[i] == 1) {
                    tmp += (i+1) + " ";
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
            return;
        }
        check[l-1] = 1;
        dfs1(l+1);

        check[l-1] = 0;
        dfs1(l+1);
    }
}