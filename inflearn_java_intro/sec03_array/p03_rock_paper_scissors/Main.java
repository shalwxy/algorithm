package inflearn_java_intro.sec03_array.p03_rock_paper_scissors;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = kb.nextInt();
        }
        for (int i=0; i<n; i++) {
            b[i] = kb.nextInt();
        }
        for (char x : T.solution(n, a, b).toCharArray()) {
            System.out.println(x);
        }
    }

    public String solution(int n, int[] a, int[] b) {
        String answer = "";
        for (int i=0; i<n; i++) {
            int result = Math.floorMod(a[i]-b[i], 3);
            if (result == 1) answer += "A";
            else if (result == 2) answer += "B";
            else { // result == 3
                answer += "D";
            }
        }

        return answer;
    }
}
