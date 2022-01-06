package parll;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public void withStream(){

        IntStream
                .of(1,7,4,3,6,8)
                .parallel()
//                .filter(el -> el>10)
                .map(el -> el*el)
                .forEach(el -> System.out.println(el));

    }
    public void withoutStream() {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(7);
        nums.add(4);
        nums.add(3);
        nums.add(6);
        nums.add(8);

        for (int num : nums ) {
            System.out.println(num * num);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("without stream");
        main.withoutStream();
        System.out.println("with stream");
        main.withStream();
    }
}
