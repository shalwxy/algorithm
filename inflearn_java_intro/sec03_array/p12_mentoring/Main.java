package inflearn_java_intro.sec03_array.p12_mentoring;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 4, 1, 2},
                {4, 3, 2, 1},
                {3, 1, 4, 2},
        };

        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
       int cnt = 0;

       for (int j=0; j<arr[0].length; j++) {
           int mentor = arr[0][j];
           for (int k=j+1; k<arr[0].length; k++) {
               int mentee = arr[0][k];
               boolean flag = true;
               for (int i=1; i<arr.length; i++) {
                   int o = 0, e = 0;
                   for (int l=0; l<arr[0].length; l++) {
                       if (arr[i][l] == mentor) {
                            o = l;
                       }
                       if (arr[i][l] == mentee) {
                           e = l;
                       }
                   }
                   if (o >= e) {
                       flag = false;
                       break;
                   }
               }
               if (flag) cnt++;
           }
       }

       return cnt;
    }
}
