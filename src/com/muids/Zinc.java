package com.muids;
import twitter4j.*;

import java.util.List;
/**
 * Created by LILY's on 17/1/2560.
 */
public class Zinc {

    public static void go()throws Exception {
        String user = "@realDonaldTrump";
        System.out.println("Finding the latest tweet from " + user);
        Status latestTweet = getLatestTweet(user);
        System.out.println("Latest Tweet:");
        System.out.println(latestTweet.getUser().getName() + ":" + latestTweet.getText());
        System.out.println("Retweeting...");
        retweet(latestTweet.getId());
        //call retweet here
    }
    private static Status getLatestTweet(String user) throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();

        List<Status> tweets = twitter.getUserTimeline(user);

        return tweets.get(0);
    }

    private static void retweet(long statusId)throws Exception {

        Twitter twitter = TwitterFactory.getSingleton();
        twitter.retweetStatus(statusId);
    }
}
