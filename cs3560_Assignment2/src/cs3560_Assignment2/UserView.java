package cs3560_Assignment2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.util.Observer;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;


public class UserView extends javax.swing.JFrame implements Observer {

	
    DefaultListModel<String> following;
    DefaultListModel<String> newsfeed;
    private String username;
    private User user;
    private List<User> userList;
    private List<String> userID;
    private Map<String, UserView> userViews;
    
    private javax.swing.JButton followButton;
    private javax.swing.JList<String> followingList;
    private javax.swing.JScrollPane jScroll1;
    private javax.swing.JScrollPane jScroll2;
    private javax.swing.JScrollPane jScroll3;
    private javax.swing.JScrollPane jScroll4;
    private javax.swing.JList<String> newsFeedList;
    private javax.swing.JButton tweetButton;
    private javax.swing.JTextArea tweetTextArea;
    private javax.swing.JTextArea userViewIDTextArea;


    
    public UserView(User user, List<String> SSID, List<User> usercount, Map<String, UserView> userVCount) {
        this.user = user;
        user.addObserver(this);
        this.username = user.getID();
        this.userID = SSID;
        this.userList = usercount;
        this.userViews = userVCount;
        this.setTitle(username + "'s User View");
        following = new DefaultListModel<String>();
        newsfeed = new DefaultListModel<String>();
        initComponents();
    }

    @SuppressWarnings("unchecked")
        private void initComponents() {

        jScroll1 = new javax.swing.JScrollPane(userViewIDTextArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        userViewIDTextArea = new javax.swing.JTextArea();
        followButton = new javax.swing.JButton();
        jScroll2 = new javax.swing.JScrollPane();
        followingList = new JList(user.getFollowing().toArray());
        jScroll3 = new javax.swing.JScrollPane();
        tweetTextArea = new javax.swing.JTextArea();
        tweetButton = new javax.swing.JButton();
        jScroll4 = new javax.swing.JScrollPane();
        newsFeedList = new JList(user.getNewsFeed().toArray());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userViewIDTextArea.setColumns(20);
        userViewIDTextArea.setLineWrap(true);
        userViewIDTextArea.setRows(5);
        jScroll1.setViewportView(userViewIDTextArea);

        followButton.setText("WANNA FOLLOW?");
        followButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                followButtonListener(Event);
            }
        });

        following.addElement("Following Right Now: ");
        jScroll2.setViewportView(followingList);

        tweetTextArea.setColumns(20);
        tweetTextArea.setLineWrap(true);
        tweetTextArea.setRows(5);
        tweetTextArea.setWrapStyleWord(true);
        jScroll3.setViewportView(tweetTextArea);

        tweetButton.setText("Post Tweet");
        tweetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                tweetButtonListener(Event);
            }
        });

        newsfeed.addElement("News Feed");
        jScroll4.setViewportView(newsFeedList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tweetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                    .addComponent(jScroll2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(followButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(followButton, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tweetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScroll4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void followButtonListener(java.awt.event.ActionEvent Event) {
        if (!userID.contains(userViewIDTextArea.getText())) {
            JOptionPane.showMessageDialog(null, "This user does not exist.", "Follow Error", JOptionPane.INFORMATION_MESSAGE);
            userViewIDTextArea.setText("");
            return;
        } else if (user.getFollowing().contains(userViewIDTextArea.getText())) {
            JOptionPane.showMessageDialog(null, "You are already following this user.", "Follow Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (user.getID().equals(userViewIDTextArea.getText())) {
            JOptionPane.showMessageDialog(null, "You cannot follow yourself!", "Follow Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            following.addElement("- " + userViewIDTextArea.getText());
            followingList.setModel(following);
            user.follow(userViewIDTextArea.getText());
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getID().equals(userViewIDTextArea.getText())) {
                    userList.get(i).attach(user);
                }
            }
        }
        userViewIDTextArea.setText("");
        revalidate();
        repaint();
    }

    private void tweetButtonListener(java.awt.event.ActionEvent Event) {
        if (tweetTextArea.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tweets cannot be blank!", "Tweet Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            user.tweet(tweetTextArea.getText());
            newsfeed.insertElementAt(user.getNewsFeed().get(0), 1);
            newsFeedList.setModel(newsfeed);
            tweetTextArea.setText("");

           
            List<User> ifollowers = user.getObserver();
            int isize = ifollowers.size();
            String msg = user.getNewsFeed().get(0);
            for (int j = 0; j < isize; j++) {
                User myuser = ifollowers.get(j);
                UserView myUserView = userViews.get(myuser.getID());
                myuser.updateNewsFeed(msg);
                update(myuser, msg);

                myUserView.newsfeed.insertElementAt(msg, 1);
                myUserView.newsFeedList.setModel(newsfeed);
                myUserView.tweetTextArea.setText("");
                myUserView.revalidate();
                myUserView.repaint();

            }
            revalidate();
            repaint();
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof List) {
        }
    }


}

