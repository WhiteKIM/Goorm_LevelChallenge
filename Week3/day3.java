package Week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class day3 {
    public static int N;
    public static int K;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visited;
    public static int BFS(int x, int y, int num) {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            x = data[0];
            y = data[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if(!visited[nx][ny] && map[nx][ny]==num) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count+=1;
                    }
                }
            }
        }

        if(count >= K) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            input = sc.nextLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        int[] result = new int[31];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    int bfsCount = BFS(i, j, map[i][j]);
                    result[map[i][j]] +=bfsCount;
                }
            }
        }
        int max = 0;
        int index = -1;
        for(int i = 1; i <= 30; i++) {
            if(max < result[i]) {
                max = result[i];
                index = i;
            } else if(max == result[i]) {
                if(index < i) {
                    index = i;
                }
            }
        }
        System.out.println(index);
    }
}