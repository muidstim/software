package com.muids;

import twitter4j.*;
import java.util.List;

public class Copper {

    public static void go() throws Exception {

        String user = "@realDonaldTrump";

        System.out.println("Finding the latest tweet from " + user);
        Status latestTweet = getLatestTweet(user);

        System.out.println("Latest Tweet:");
        System.out.println(latestTweet.getUser().getName() + ": " + latestTweet.getText());

        System.out.println("Retweeting...");
        retweet(latestTweet.getId());
    }



    //Get latest Tweet
    private static Status getLatestTweet(String user) throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getUserTimeline(user);

        return statuses.get(0);
    }



    //Retweet
    private static void retweet(long statusId)throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.retweetStatus(statusId);

        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
}

