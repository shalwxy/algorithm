package inflearn_java_intro.sec04_two_pointers_sliding.p04_contiguous_subarray;

public class Main {
    public static void main(String[] args) {
        int m = 6;
        int[] arr = {1, 2, 1, 3, 1, 1, 1, 2};

        System.out.println(solution2(m, arr));
    }

    public static int solution2(int m, int[] arr) {
        int answer=0, sum=0, lt=0;
        for (int rt=0; rt<arr.length; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }
        return answer;
    }

    public static int solution1(int m, int[] arr) {
        int cnt = 0;
        // i=0~length-1, j=i~m조건부 로 해서 2중 반복문 수행
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=i; j<arr.length&&sum<m; j++) {
                sum += arr[j];
            }
            if (sum == m) {
                cnt++;
            }
        }
        return cnt;
    }
}
