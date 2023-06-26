package cs3560_Assignment2;

import java.util.*;


public class User extends Observable implements Tree, Observer {
    private String ID;
    private List<String> following;
    private List<String> tweets;
    private List<String> newsFeed;
    private List<User> followers;
    private boolean target;

    private int totalUsers = 0;
    private int positiveCount = 0;
    private int messageCount = 0;
    private String[] positiveWords = {"good", "great", "excellent", "outstanding", "congratulations"};
    
    //constructor
    public User(String ID) {
        this(ID, false);
        followers = new ArrayList();
        following = new ArrayList();
        tweets = new ArrayList();
        newsFeed = new ArrayList();
        totalUsers++;
    }
    //constructor
    public User(String ID, boolean property) {
        this.ID = ID;
        this.target = property;
        followers = new ArrayList();
        following = new ArrayList();
        tweets = new ArrayList();
        newsFeed = new ArrayList();
        totalUsers++;
    }
    
    public void follow(String user) {
        following.add(user);
    }

    public void tweet(String message) {
        tweets.add(message);
        setChanged();
        notifyObservers(message);
        newsFeed.add(0, "- " + ID + ": " + message);
        setChanged();
        notifyObservers(newsFeed);
        for (String word : positiveWords) {
            if (message.toLowerCase().contains(word)) {
                positiveCount++;
            }
        }
        messageCount++;
    }

    public int getMessageCount() {
        return messageCount;
    }
    
    public List<User> getObserver() {
        return followers;
    }

    public List<String> gettweets() {
        return tweets;
    }

    public List<String> getFollowing() {
        return following;
    }
    
    public int getuserCount() {
        return totalUsers;
    }

    public int getPositiveCount() {
        return positiveCount;
    }

    public void attach(User user) {
        followers.add(user);
    }

    public List<String> getNewsFeed() {
        return newsFeed;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public boolean isResult() {
        return target;
    }

    @Override
    public String toString() {
        return ID;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            newsFeed.add("[" + ((User) o).getID() + "] - " + (String) arg);
        }
    }
    
    public void  updateNewsFeed(String msg) {
		newsFeed.add(msg);
	}

}
