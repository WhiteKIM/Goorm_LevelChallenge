package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day4 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dx = {-1, 1, 0, 0, 0};
    private static int[] dy = {0, 0, -1, 1, 0};
    private static int[][] result;
    public static int N, M;

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        char[][] map;
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new char[N][N];
        result = new int[N][N];
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = input[j].charAt(0);
            }
        };
        for(int i = 0; i < M; i++) {
            int x, y;
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            bomb(map, x-1, y-1);
//            System.out.println("======================");
//            printMap();
//            System.out.println("======================");
        }

        int maxValue = findMaxValue();
        System.out.println(maxValue);
    }

    private static void printMap() {
        for(int[] x : result) {
            for(int y : x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }

    private static int findMaxValue() {
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                max = Math.max(max, result[i][j]);
            }
        }
        return max;
    }

    private static void bomb(char[][] map, int x, int y) {
        for(int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                if(map[nx][ny]=='0') {
                    result[nx][ny] += 1;
                } else if(map[nx][ny]=='@') {
                    result[nx][ny] +=2;
                } else {
                    continue;
                }
            }
        }
    }
}
