package com.jiyeon;

import java.util.*;

/**
 * Created by jiyeon on 2017. 7. 21..
 * https://www.careercup.com/question?id=5682055978418176
 * Given a group of movies and their start time, assuming that are 1 hour long,
   Returns a movie schedule (no time conflict).
 *
 */
public class MovieSchedule {

    public static Map<String, Integer> getSchedule(HashMap<String, int[]> movieSchedules) {
        Map<String, Integer> movieSchedule = new HashMap<String, Integer>();

        Map<String, Integer> movieOccurrence = new HashMap<String, Integer>();
        Map<Integer, List<String>> movieTimings = new TreeMap<Integer, List<String>>();

        for (Map.Entry<String, int[]> entry : movieSchedules.entrySet()) {
            int[] schedule = entry.getValue();
            for (Integer timing : schedule) {
                if (!movieTimings.containsKey(timing)) {
                    movieTimings.put(timing, new ArrayList<String>());
                }
                movieTimings.get(timing).add(entry.getKey());
            }
            movieOccurrence.put(entry.getKey(), entry.getValue().length);
        }

        for (Map.Entry<Integer, List<String>> entry : movieTimings.entrySet()) {
            List<String> movies = entry.getValue();

            String leastOccurrenceMovie = null;
            Integer occurrence = Integer.MAX_VALUE;

            for (String movie : movies) {
                if (movieOccurrence.get(movie) != null && movieOccurrence.get(movie) <= occurrence) {
                    leastOccurrenceMovie = movie;
                    occurrence = movieOccurrence.get(movie);
                }
                if (movieOccurrence.get(movie) != null) {
                    movieOccurrence.put(movie, movieOccurrence.get(movie) - 1);
                }
            }

            movieSchedule.put(leastOccurrenceMovie, entry.getKey());
            movieOccurrence.remove(leastOccurrenceMovie);

        }

        return movieSchedule;
    }

    private static boolean schedule(Map<String, List<Integer>> movies, List<String> movieNames, int index, Map<Integer, String> schedule) {
        if (index == movieNames.size())
            return true;

        String movie = movieNames.get(index);
        List<Integer> timings = movies.get(movie);
        for(int timing : timings) {
            if (!schedule.containsKey(timing)) {
                Map<Integer, String> scheduleCopy = new HashMap<Integer, String>(schedule);
                scheduleCopy.put(timing, movie);
                if (schedule(movies, movieNames, index+1, scheduleCopy)) {
                    schedule.clear();
                    schedule.putAll(scheduleCopy);
                    return true;
                }
            }
        }
        return false;
    }

    public static void setUpschedule(Map<String, List<Integer>> map) {
        List<String> result = new ArrayList<String>();
        result.add("");

        for (int i =0; i< map.size(); i++) {
            Map<String, List<Integer>> current = new HashMap<String, List<Integer>>();
            for (String l : result) {
//                current.put()

            }
        }


    }

    public static void main(String[] args) {
        Map<String, List<Integer >> movies = new HashMap<String, List<Integer>>();
        movies.put("Shining", Arrays.asList(14, 15, 16));
        movies.put("Kill Bill", Arrays.asList(14, 15));
        movies.put("Pulp Fiction", Arrays.asList(14, 15));

//        List<String> movieNames = new ArrayList<String>(movies.keySet());
//        Map<Integer, String> schedule = new HashMap<Integer, String>();
//        if (schedule(movies, movieNames, 0, schedule)) {
//            System.out.println("Schedule is " + schedule);
//        } else {
//            System.out.println("Unable to schedule!!");
//        }


        HashMap<String, int[]> movieSchedules = new HashMap<String, int[]>();

        movieSchedules.put("Shining", new int[]{14, 15, 16});
        movieSchedules.put("Kill Bill", new int[]{14, 15});
        movieSchedules.put("Pulp Fiction", new int[]{14, 15});


        System.out.println(getSchedule(movieSchedules));


    }
}
