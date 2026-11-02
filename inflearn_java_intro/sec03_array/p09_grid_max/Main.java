package inflearn_java_intro.sec03_array.p09_grid_max;

public class Main {
    static void main(String[] args) {
        int[][] arr = {
                {10, 13, 10, 12, 15},
                {12, 39, 30, 23, 11},
                {11, 25, 50, 53, 15},
                {19, 27, 29, 37, 27},
                {19, 13, 30, 13, 19}
        };

        System.out.println(solution(5, arr));
    }

    public static int solution(int n, int[][] arr) {
       int max = Integer.MIN_VALUE;

        int sum3 = 0;
        int sum4 = 0;
       for (int i=0; i<arr.length; i++) {
           int sum1 = 0;
           int sum2 = 0;
           for (int j=0; j<arr[i].length; j++) {
               sum1 += arr[i][j];
               sum2 += arr[j][i];
               if (i == j) sum3 += arr[i][j];
               if (i+j == 4) sum4 += arr[i][j];
           }
           if (sum1 > max) max = sum1;
           if (sum2 > max) max = sum2;
           if (sum3 > max) max = sum3;
           if (sum4 > max) max = sum4;
       }

        return max;
    }
}
