package com.muids;

import twitter4j.*;

import java.util.List;

public class Silver {

    public static void main(String args[]) throws Exception {
        Silver.go();
    }

    public static void go() throws Exception {

        String user = "realDonaldTrump";

        System.out.println("Finding the latest tweet from " + user);
        Status latestTweet = getLatestTweet(user);

        System.out.println("Latest Tweet:");
        System.out.println(latestTweet.getUser().getName() + ":" + latestTweet.getText());

        System.out.println("Retweeting...");
        retweet(latestTweet.getId());

    }

    private static Status getLatestTweet(String user) throws Exception {

        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getUserTimeline(user);

        return statuses.get(0);

    }

    private static void retweet(long statusId) throws Exception {

        Twitter twitter = TwitterFactory.getSingleton();
        twitter.retweetStatus(statusId);

    }

}
