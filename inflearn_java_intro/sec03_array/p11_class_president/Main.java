package inflearn_java_intro.sec03_array.p11_class_president;

public class Main {
    static void main(String[] args) {
        int[][] arr = {
                {2, 3, 1, 7, 3},
                {4, 1, 9, 6, 8},
                {5, 5, 2, 4, 4},
                {6, 5, 2, 6, 7},
                {8, 4, 2, 2, 2}
        };

        System.out.println(solution(5, arr));
    }

    public static int solution(int n, int[][] arr) {
       int answer = 0;
       int max = 0;

       for (int i=0; i<arr.length; i++) {
           int cnt = 0;
           for (int j=0; j<arr.length; j++) {
               for (int k=0; k<arr[0].length; k++) {
                   if (i!=j && arr[i][k] == arr[j][k]) {
                       cnt++;
                       break;
                   }
               }
           }
           if (cnt > max) {
               max = cnt;
               answer = i+1;
           }
       }

       return answer;
    }
}
