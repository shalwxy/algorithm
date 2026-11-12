package inflearn_java_intro.sec04_two_pointers_sliding.p06_max_length_subseq;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int[] arr = new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};

        System.out.println(solution2(n, arr));
    }

    public static int solution2(int n, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;
        for (int rt=0; rt<arr.length; rt++) {
            if (arr[rt] == 0) cnt++;
            while (cnt>n) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        return answer;
    }

    public static int solution1(int n, int[] arr) {
        int answer = 0;

        int lt = 0;
        int cntChange = 0;

        for (int rt=0; rt<arr.length; rt++) {
            cntChange += change(arr[rt]);
            while (cntChange > n) {
                cntChange -= change(arr[lt++]);
            }
            if (rt-lt+1 > answer) answer = rt-lt+1;

        }

        return answer;
    }

    public static int change(int a) {
        if (a == 0) return 1;
        else return 0;
    }
}
