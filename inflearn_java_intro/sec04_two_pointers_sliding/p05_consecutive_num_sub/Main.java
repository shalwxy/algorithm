package inflearn_java_intro.sec04_two_pointers_sliding.p05_consecutive_num_sub;

public class Main {
    public static void main(String[] args) {
        int n = 15;

        System.out.println(solution2_optimized(n));
    }

    public static int solution2_optimized(int n) {
        int answer = 0, sum = 0, lt = 1; // 1부터 시작
        int m = n / 2 + 1;

        // rt 자체를 더할 숫자로 사용
        for (int rt=1; rt<=m; rt++) {
            sum += rt;
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) answer++;
            }
        }
        return answer;
    }

    public static int solution2(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m= n/2 + 1;
        int[] arr = new int[m];
        for (int i=0; i<m; i++) arr[i] = i+1;
        for (int rt=0; rt<m; rt++) {
            sum += arr[rt];
            if (sum == n) answer++;
            while (sum >=n) {
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }
        return answer;
    }

    public static int solution1_optimized(int n) {
        int answer = 0;
        int k = 2; // 연속된 숫자의 갯수 (2개 이상부터)
        n--; // 1을 빼고 시작

        while (n > 0) {
            n -= k; // 2, 3, 4 ... 씩 순차적으로 뺌
            if (n >= 0 && n % k == 0) { // 남은 값이 k로 나누어 떨어지면 자연수 배분 가능
                answer++;
            }
            k++;
        }
        return answer;
    }

    public static int solution1(int n){
        // 예시에서
        // 7+8 = 15
        // 4+5+6 = 15
        // 1+2+3+4+5 = 15
        // =>
        // 15를 2로 나누면 7.5 : 7, 8의 평균
        // 15를 3으로 나누면 5 : 4, 5, 6의 평균
        // 15를 4로 나누면 3.75 : 두 수의 정확히 중간에 3.75가 있지 않음 - X.5가 되어야 함
        // 15를 5로 나누면 3 : 1, 2, 3, 4, 5의 평균
        // 15를 6으로 나누면 2.5 : 2, 3을 중심으로 해서 6개의 숫자를 가지고 15를 만들 수 있음 (0, 1, 2, 3, 4, 5) 근데 조건이 자연수이므로 기각
        // ...
        // 어디까지 해보면 될까?
        // 가장자리 예시로 자연수 3을 생각
        // 3/2 = 1.5의 올림인 2까지 위의 내용을 반복하면 됨을 알 수 있음
        // 이제 코드를 짜보자
        int cnt = 0;
        for (int i=2; i<=n/2+1; i++) {
            double tmp = (double) n / i;
            // i가 짝수인 경우
            // tmp=X.5 형태여야 함
            // X - i/2 + 1 > 0
            if (i % 2 == 0 && tmp % 1 != 0 && tmp * 2 % 1 == 0 && (int)tmp - (float)i/2 + 1 > 0) {
                cnt++;
                // i가 홀수인 경우
                // tmp=X 형태로 정수여야 함
                // X - i/2 > 0
            } else if (i % 2 == 1 && tmp % 1 == 0 && (int)tmp - (float)i/2 > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
