package inflearn_java_intro.sec03_array.p04_fibonacci;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }

    public String solution(int n) {
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i=2; i<n; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return Arrays.stream(fibonacci)
                        .mapToObj(String::valueOf)
                                .collect(Collectors.joining(" "));
    }
}
