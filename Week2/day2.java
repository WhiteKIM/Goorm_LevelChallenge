package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day2 {
    public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[][] map;
    public static int[][] result_map;
    public static int N, M;
    public static void flag(int x, int y) {
        int count = 0;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                if(map[nx][ny] == 1) {
                    count+=1;
                }
            }
        }
        result_map[x][y] = count;
    }

    public static int countFlag() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(result_map[i][j]==M) {
                    count+=1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][N];
        result_map = new int[N][N];
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    flag(i, j);
                }
            }
        }
        System.out.println(countFlag());
    }
}
