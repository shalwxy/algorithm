package inflearn_java_intro.sec03_array.p06_prime_reverse;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        System.out.println(solution(9, new int[]{32, 55, 62, 20, 250, 370, 200, 30, 100}));
    }

    public static ArrayList<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int j : arr) {
            int res = 0;
            int tmp = j;
            while (tmp > 0) {
                int decimal1 = tmp % 10;
                res = res * 10 + decimal1;
                tmp /= 10;
            }

            if (isPrime(res)) answer.add(res);
        }

        return new ArrayList<>(answer);
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i=2; i*i<=n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }
}
