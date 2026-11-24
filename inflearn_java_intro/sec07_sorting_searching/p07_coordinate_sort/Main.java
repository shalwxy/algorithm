package inflearn_java_intro.sec07_sorting_searching.p07_coordinate_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 7},
                {1, 3},
                {1, 2},
                {2, 5},
                {3, 6},
        };

        System.out.println(Arrays.deepToString(solution4(arr)));
    }

    public static int[][] solution4(int[][] arr) {
        List<Point> answer = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            answer.add(new Point(arr[i][0], arr[i][1]));
        }
        Collections.sort(answer);
        return answer.stream()
                .map(p -> new int[]{p.x, p.y})
                .toArray(int[][]::new);
    }

    // 삽입 정렬
    public static int[][] solution3(int[][] arr) {
        for (int i=1; i<arr.length; i++) {
            int[] tmp = arr[i];
            int j = i;
            while (j>0 &&
                    (arr[j-1][0] > tmp[0] ||
                            (arr[j-1][0] == tmp[0] && arr[j-1][1] > tmp[1]))) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
        return arr;
    }

    // 버블 정렬
    public static int[][] solution2(int[][] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=arr.length-1; j>i; j--) {
                if (arr[j][0] < arr[j-1][0] ||
                        (arr[j][0] == arr[j-1][0] && arr[j][1] < arr[j-1][1])) {
                    swap(arr, j, j-1);
                }
            }
        }
        return arr;
    }

    // 선택 정렬
    public static int[][] solution1(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            int minIdx = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j][0] < arr[minIdx][0] ||
                        (arr[j][0] == arr[minIdx][0] && arr[j][1] < arr[minIdx][1])) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
        return arr;
    }

    public static void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

class Point implements Comparable<Point> {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
}
