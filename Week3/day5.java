package Week3;

import java.util.ArrayList;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) {
        int N, K;
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);//과일 개수
        K = Integer.parseInt(input[1]);//가진 돈

        ArrayList<Fruit> fruits = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            input = sc.nextLine().split(" ");
            fruits.add(new Fruit(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        fruits.sort((fruit1, fruit2) -> {
            if (fruit1.getFullnessPerPrice() > fruit2.getFullnessPerPrice()) {
                return -1;
            } else if (fruit1.getFullnessPerPrice() < fruit2.getFullnessPerPrice()) {
                return 1;
            } else {
                return 0;
            }
        });


        long sum = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(K >= fruits.get(i).getPrice()) {
                sum += fruits.get(i).getFullness();
                K -= fruits.get(i).getPrice();
                visited[i] = true;
            } else {
                int numPieces = Math.min(K, fruits.get(i).getPrice());
                sum += (long) fruits.get(i).getFullnessPerPrice() * numPieces;
                K = 0;
            }
        }

        System.out.println(sum);
    }

    public static class Fruit {
        int price;
        int fullness;

        public Fruit(int price, int fullness) {
            this.price = price;
            this.fullness = fullness;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getFullness() {
            return fullness;
        }

        public void setFullness(int fullness) {
            this.fullness = fullness;
        }

        public double getFullnessPerPrice() {
            return (double) fullness / price;
        }
    }
}