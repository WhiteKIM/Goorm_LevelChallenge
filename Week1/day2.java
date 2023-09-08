package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day2 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N;
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);
        Time time = new Time(hour, minute);
        for(int i = 0; i < N; i++) {
            int workTime = Integer.parseInt(br.readLine());
            time.elapsedTime(workTime);
        }

        time.print();
    }

    public static class Time {
        int hour;
        int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public void elapsedTime(int minute) {
            int new_minute = this.minute+minute;

            if(new_minute >= 60) {
                int hour = new_minute / 60;
                new_minute %= 60;
                this.hour += hour;
                this.minute = new_minute;
            } else {
                this.minute = new_minute;
            }

            if(this.hour >= 24) {
                this.hour-= 24;
            }
        }

        public void print() {
            System.out.println(hour+" "+minute);
        }
    }
}
