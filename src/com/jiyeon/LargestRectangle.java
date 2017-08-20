package com.jiyeon;

import java.util.Stack;

/**
 * Created by jiyeon on 2017. 8. 20..
 * https://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
 *
 */
public class LargestRectangle {
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0; }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while (i < height.length) {
            // 만약, 해당 index의 높이가 전 index(stack의 top)의 높이보다 크다면 stack에 넣는다.
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                // 해당 index의 높이가 전 index(stack의 top)의 높이보다 작다면...
                // 현재 구할수 있는 가장 큰 값을 구한다.
                int p = stack.pop();
                int h = height[p]; // 스택의 top 값의 높이
                int w = stack.isEmpty() ? i : i - stack.peek() - 1; // 현재 index - 스택 남아있는 값중 top (위에 pop한뒤) -1
                max = Math.max(h * w, max);
            }

            System.out.println("stack1 : " + stack.toString());
            System.out.println("max1 : " + max);
        }

        // 스택이 아직 비어있지 않다면
        while (!stack.isEmpty()) {
            // 하나씩 꺼내어 앞에서 사용한 방법과 같이 최대 값을 구한다
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);

            System.out.println("stack2 : " + stack.toString());
            System.out.println("max2 : " + max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] histogram = {1,2,3,2};
        int[] histogram2 = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(histogram)); // 6
        System.out.println(largestRectangleArea(histogram2)); // 10
    }
}
