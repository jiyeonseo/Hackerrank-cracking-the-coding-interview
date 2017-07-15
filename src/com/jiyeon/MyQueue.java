package com.jiyeon;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by jiyeon on 2017. 7. 15..
 */
public class MyQueue {
    // List로 Queue 직접 구현하기
    static class AQueue {
        List<Integer> queue = new ArrayList<Integer>();

        public void enqueue(int i) {
            queue.add(i);
        }

        public int dequeue() {
            if(this.isEmpty()){
               throw new NoSuchElementException();
            }
            return queue.remove(0);
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
    public static void main(String[] args) {

        AQueue queue = new AQueue();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }

    }
}
