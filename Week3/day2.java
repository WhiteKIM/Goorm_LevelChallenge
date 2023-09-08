package Week3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class day2 {
    public static int N;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visited;
    public static int count = 0;
    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        count+=1;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            x = data[0];
            y = data[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if(!visited[nx][ny] && map[nx][ny]==1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j]==1 && !visited[i][j]) {
                    BFS(i, j);
                }
            }
        }

        System.out.println(count);
    }
}