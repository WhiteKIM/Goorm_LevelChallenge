import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static char[][] dir_board;
    static boolean[][] goorm_vis, player_vis;
    static Pos goorm, player;

    // U R D L
    static int []dx = {-1, 0, 1, 0}, dy= {0, 1, 0, -1};

    static class Pos{
        int x; int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        dir_board = new char[N][N];
        goorm_vis = new boolean[N][N];
        player_vis = new boolean[N][N];

        st = new StringTokenizer(br.readLine());
        goorm = new Pos(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        st = new StringTokenizer(br.readLine());
        player = new Pos(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                String temp = st.nextToken();
                dir_board[i][j] = temp.charAt(temp.length()-1);
                board[i][j] = Integer.parseInt(temp.substring(0, temp.length()-1));
            }
        }

        // 구름
        int x = goorm.x;
        int y = goorm.y;
        goorm_vis[x][y] = true;
        int goorm_score = 1;

        end : while(true){
            char dir_char = dir_board[x][y];
            int dir = 0; // U
            if(dir_char=='R') dir = 1;
            else if(dir_char=='D') dir = 2;
            else if(dir_char=='L') dir = 3;

            // 이동거리
            int dist = board[x][y];

            while(dist-->0){
                int nx = dx[dir] + x;
                int ny = dy[dir] + y;

                if(nx < 0) nx = N-1;
                if(nx >= N) nx = 0;
                if(ny < 0) ny = N-1;
                if(ny >= N) ny = 0;

                // 방문했으면 바로 종료
                if(goorm_vis[nx][ny]) break end;
                goorm_vis[nx][ny] = true;
                goorm_score++;
                x = nx;
                y = ny;
            }
        }

        // 플레이어
        x = player.x;
        y = player.y;
        player_vis[x][y] = true;
        int player_score = 1;

        end : while(true){
            char dir_char = dir_board[x][y];
            int dir = 0; // U
            if(dir_char=='R') dir = 1;
            else if(dir_char=='D') dir = 2;
            else if(dir_char=='L') dir = 3;

            // 이동거리
            int dist = board[x][y];

            while(dist-->0){
                int nx = dx[dir] + x;
                int ny = dy[dir] + y;

                if(nx < 0) nx = N-1;
                if(nx >= N) nx = 0;
                if(ny < 0) ny = N-1;
                if(ny >= N) ny = 0;

                // 방문했으면 바로 종료
                if(player_vis[nx][ny]) break end;
                player_vis[nx][ny] = true;
                player_score++;
                x = nx;
                y = ny;
            }
        }

        if(goorm_score > player_score){
            System.out.print("goorm "+goorm_score);
        }
        else if(goorm_score < player_score){
            System.out.print("player "+player_score);
        }

        br.close();
    }
}