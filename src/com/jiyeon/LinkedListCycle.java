package com.jiyeon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiyeon on 2017. 7. 15..
 * https://www.hackerrank.com/challenges/ctci-linked-list-cycle
 */

public class LinkedListCycle {

    static class MyLinkedList{
        Node head;

        public void append(int data) { // 뒤로 이어가기
            if(head  == null) {
                head = new Node(data);
                return;
            }
            Node current = head;
            while(current.next != null) {
                current = current.next; // 링크드 node 맨 마지막 까지 도착할때까지 current를 옮긴다
            }

            current.next  = new Node(data);
        }

        public void prepend(int data) { // 앞에 붙히기
            Node newHead = new Node(data);
            newHead.next = head; // 새로운 head 끝에 원래 head를 붙히고
            head = newHead; // 새로운 head를 head로 포인터를 옮겨준다
        }

        public void deletWithValue(int data) {
            if(head == null) return;
            // 2.  만약 내가 지우고자 하는 노드가 헤드에 있을 경우
            if(head.data == data) {
                head = head.next;
                return;
            }

            // 1. 중간 노드를 지울 때
            Node current = head;
            while(current.next != null) {
                if(current.next.data == data) { // 내가 지우고자 하는 node의 바로 전에 멈춰서
                     current.next = current.next.next; // 지우고자 하는 node 다음 노드를 현재(current)의 next로 바꿔준다
                     return;
                }

                current = current.next; // 그리고 쭉 넘어간다
            }
        }

    }
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
        Node(int x, Node y) {
            data = x;
            next = y;
        }
    }


    boolean hasCycle1(Node head) {
//      HackerRank  video : https://www.youtube.com/watch?v=MFOAbpfrJ8g

        if (head == null) return false;

        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    boolean hasCycle(Node head) {
        if (head == null) return false;

        Node cur = head;

        Map<Node, Boolean> hm = new HashMap<Node, Boolean>();
        hm.put(cur, false);

        while(cur.next != null) {
            if(hm.containsKey(cur.next)){
                return true;
            }else {
                hm.put(cur.next, false);
            }
            cur = cur.next;
        }

        return false;
    }

    public static void main(String[] args) {
    }
}
