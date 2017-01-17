package com.muids;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import java.util.List;

/**
 * Created by MUIDS on 1/17/2017.
 */
public class Titanium {
    public static void main(String args[]) throws Exception {
        Titanium.go();
    }

    public static void go() throws Exception {

        String user = "@aer_____";
        System.out.println("Finding the latest tweet from " + user);
        Status latestTweet = getLatestTweet(user);
        System.out.println("Latest Tweet:");
        System.out.println(latestTweet.getUser().getName() + ":" + latestTweet.getText());
        System.out.println("Retweeting...");
        retweet(latestTweet.getId());
    }

    public static Status getLatestTweet(String user) throws Exception{
        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getUserTimeline(user);

        return statuses.get(0);

    }

    private static void retweet(long statusID) throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.retweetStatus(statusID);
    }

}
