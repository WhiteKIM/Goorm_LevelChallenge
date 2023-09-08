package Week4;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class day5 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int N;
    public static int K;
    public static int Q;
    public static char[][] map;

    public static void bfs(boolean[][] visited, char ch, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> count = new ArrayList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});
        count.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            x = data[0];
            y = data[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0<= nx && nx < N && 0 <= ny && ny < N) {
                    if(!visited[nx][ny] && map[x][y]==map[nx][ny]) {
                        visited[nx][ny] = true;
                        count.add(new int[]{nx, ny});
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if(count.size() >= K) {
            for(int[] data : count) {
                int x1 = data[0];
                int y1 = data[1];

                map[x1][y1] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        Q = Integer.parseInt(input[2]);

        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] data = sc.nextLine().toCharArray();
            map[i] = data;
        }



        for(int i = 0; i < Q; i++) {
            input = sc.nextLine().split(" ");
            int x = Integer.parseInt(input[0])-1;
            int y = Integer.parseInt(input[1])-1;
            char ch = input[2].charAt(0);

            if(map[x][y]=='.') {
                map[x][y] = ch;
                boolean[][] visited = new boolean[N][N];
                bfs(visited, ch, x, y);
            }
        }

        for(char[] x : map) {
            for (char y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }
}
