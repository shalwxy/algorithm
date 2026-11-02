package inflearn_java_intro.sec03_array.p07_grading_acc;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        System.out.println(solution(10, new int[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 0}));
    }

    public static int solution(int n, int[] arr) {
        int answer=0, cnt=0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                cnt++;
                answer+=cnt;
            }
            else cnt = 0;
        }

        return answer;
    }
}
