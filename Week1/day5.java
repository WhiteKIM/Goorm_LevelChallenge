package Week1;

import java.util.*;

public class day5 {
    public static void main(String[] args) {
        int N, K;
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        input = sc.nextLine().split(" ");
        List<Integer> data = new ArrayList<>();
//        Integer[] data = new Integer[N];

//        for(int i = 0; i < N; i++) {
//            data[i] = Integer.parseInt(input[i]);
//        }

        for(int i = 0; i < N; i++) {
            data.add(Integer.parseInt(input[i]));
        }

        Collections.sort(data, new Comparator<Integer>() {
            private int countNumberOne(char[] binary) {
                int count = 0;
                for (char c : binary) {
                    if (c == '1') {
                        count += 1;
                    }
                }
                return count;
            }

            @Override
            public int compare(Integer o1, Integer o2) {
                char[] o1_binary = Integer.toBinaryString(o1).toCharArray();
                char[] o2_binary = Integer.toBinaryString(o2).toCharArray();

                if(countNumberOne(o1_binary) > countNumberOne(o2_binary)) {
                    return -1;
                } else if(countNumberOne(o1_binary) == countNumberOne(o2_binary)) {
                    if(o1 > o2) {
                        return -1;
                    } else if(o1 < o2){
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 1;
                }
            }
        });
        System.out.println(data.get(K-1));
    }
}
