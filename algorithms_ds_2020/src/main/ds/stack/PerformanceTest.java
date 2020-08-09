package main.ds.stack;

import java.util.Random;

import main.ds.array.Array;
import main.ds.list.LinkedList;

public class PerformanceTest {
    public static double testStack(Stack<Integer> stack, int optCount) {
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < optCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int optCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, optCount);
        System.out.println("ArrayStack, time: " + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, optCount);
        System.out.println("LinkedListStack, time: " + time2 + "s");
    }
}
