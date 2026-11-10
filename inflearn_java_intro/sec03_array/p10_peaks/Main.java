package inflearn_java_intro.sec03_array.p10_peaks;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 3, 7, 2, 3},
                {3, 7, 1, 6, 1},
                {7, 2, 5, 3, 4},
                {4, 3, 6, 4, 1},
                {8, 7, 3, 5, 2}
        };

        System.out.println(solution(5, arr));
    }

    public static int solution(int n, int[][] arr) {
       int cnt = 0;

       int[][] dxCoordinate = {
               {0, -1},
               {0, 1},
               {-1, 0},
               {1, 0},
       };

       for (int i=0; i<arr.length; i++) {
           for (int j=0; j<arr[i].length; j++) {
               boolean flag = true;
               for (int k=0; k<dxCoordinate.length; k++) {
                   if (i+dxCoordinate[k][0] < 0 || i+dxCoordinate[k][0] >= n) continue;
                   if (j+dxCoordinate[k][1] < 0 || j+dxCoordinate[k][1] >= n) continue;
                   if (arr[i][j] <= arr[i+dxCoordinate[k][0]][j+dxCoordinate[k][1]]) {
                       flag = false;
                   }
               }
               if (flag) cnt++;
           }
       }

        return cnt;
    }
}
