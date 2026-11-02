package inflearn_java_intro.sec03_array.p05_prime;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static void main(String[] args) {
        System.out.println(solution(20));
    }

    public static int solution(int n) {
        int cnt = 0;
        int[] arr = new int[n+1];

        for (int i=2; i<=n; i++) {
            if (arr[i] == 0) cnt++;
            for (int j=i; j<=n; j+=i) {
                arr[j] = 1;
            }
        }

        return cnt;
    }
}
