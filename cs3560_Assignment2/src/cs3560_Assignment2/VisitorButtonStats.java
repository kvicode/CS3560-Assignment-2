package cs3560_Assignment2;

import java.util.ArrayList;
import java.util.List;


public class VisitorButtonStats implements VisitorButton {

    private double stats = 0.0;
    private int statNum = 0;
	private int userCount = 0;
    private int messageCount = 0;
    private int groupCount = 0;

    public double getPositivePercentage() {
        return ((statNum / messageCount) * 100.0);
    }
    
    public void setPositivePercentage(double percentage) {
        this.stats = 0.0;
    }
    
    public void setuserCount(int userCount) {
        this.userCount = userCount;
    }
    
    public void setMessagesTotal(User user) {
        this.messageCount = user.gettweets().size();
    }
    
    public void setgroupCount(Group group) {
        this.groupCount = group.getgroupCount();
    }
    
    @Override
    public void visitUserTotal(User user) {
        setuserCount(user.getuserCount());
    }

    @Override
    public void visitMessagesTotal(User user) {
        setMessagesTotal(user);
    }

    @Override
    public void visitGroupTotal(Group group) {
        setgroupCount(group);
    }

    @Override
    public void visitPositivePercentage(User user) {
        List<User> users = new ArrayList();
        List<String> tweets = user.gettweets();
    }

   
 
}
