package cs3560_Assignment2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;


public class Group implements Tree {
	private boolean target;
    private String SSID;
    private List<User> GroupGroupUsers = new ArrayList();
    private static DefaultMutableTreeNode root;

    private int GroupCount = 0;

     public Group() {
    	root = new DefaultMutableTreeNode("Root");
        GroupCount++;
    }
     public Group(String SSID) {
        this(SSID, true);
        GroupCount++;
    }
     public Group(String SSID, boolean property) {
        this.target = property;
        this.SSID = SSID;
        GroupCount++;
    }

    public int getgroupCount() {
        return GroupCount;
    }

    public DefaultMutableTreeNode getRoot() {
        return root;
    }

    @Override
    public String getID() {
        return SSID;
    }

    @Override
    public boolean isResult() {
        return target;
    }
    
    @Override
    public String toString() {
        return SSID;
    }
    
}
