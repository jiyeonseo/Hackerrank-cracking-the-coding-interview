package com.jiyeon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jiyeon on 2017. 7. 21..
 * [Sorting] ComparatorSorting
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting
 * video : https://www.youtube.com/watch?v=SzzSwvQfKyk
 */
public class ComparatorSorting {

    static class Player{
        String name;
        int score;

        Player(String name, int score){
            this.name = name;
            this.score = score;
        }
    }

    static class Checker implements Comparator<Player> {
        public int compare(Player o1, Player o2) {
            if(o1.score == o2.score) {
                return o1.name.compareTo(o2.name);
            }

            return o2.score - o1.score;
        }
    }


    public static void main(String[] args) {

        Player[] player = new Player[5];
        Checker checker = new Checker();

        player[0] = new Player("amy", 100);
        player[1] = new Player("david", 100);
        player[2] = new Player("heraldo", 50);
        player[3] = new Player("aakansha", 75);
        player[4] = new Player("aleksa", 150);

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
