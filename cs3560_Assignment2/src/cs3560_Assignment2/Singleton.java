package cs3560_Assignment2;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

public class Singleton extends javax.swing.JFrame {

    protected static Singleton instance;
    private List<User> users;
    private Map<String, UserView> userViews = new HashMap<String, UserView>();
    private List<Group> groups;
    public List<String> SSID;
    public List<String> SSGID;
    private String targetUser;
    Group group = new Group();
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode(group.getRoot());
    private DefaultTreeModel model = new DefaultTreeModel(root);
    private javax.swing.JButton addGroupButton;
    private javax.swing.JButton addUserButton;
    private javax.swing.JTextArea groupIDTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTreeView;
    private javax.swing.JButton openUserViewButton;
    private javax.swing.JButton showGroupTotalButton;
    private javax.swing.JButton showMessagesTotalButton;
    private javax.swing.JButton showPositivePercentageButton;
    private javax.swing.JButton showUserTotalButton;
    private javax.swing.JTextArea userIDTextArea;

    public Singleton() {
        SSID = new ArrayList();
        SSGID = new ArrayList();
        users = new ArrayList();
        groups = new ArrayList();
        SSGID.add("Mini Twitter Assignment #3");
        groups.add(new Group("Twitter"));
        initComponents();
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

  private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeView = new javax.swing.JTree();
        final Font currentFont = jTreeView.getFont();
        final Font bigFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() + 10);
        jTreeView.setFont(bigFont);
        jScrollPane2 = new javax.swing.JScrollPane(groupIDTextArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        groupIDTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane(userIDTextArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        userIDTextArea = new javax.swing.JTextArea();
        addUserButton = new javax.swing.JButton();
        addGroupButton = new javax.swing.JButton();
        openUserViewButton = new javax.swing.JButton();
        showUserTotalButton = new javax.swing.JButton();
        showMessagesTotalButton = new javax.swing.JButton();
        showGroupTotalButton = new javax.swing.JButton();
        showPositivePercentageButton = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jTreeView.setModel(model);
        jTreeView.setCellRenderer(new TreeView());
        jScrollPane1.setViewportView(jTreeView);
        groupIDTextArea.setColumns(20);
        groupIDTextArea.setLineWrap(true);
        groupIDTextArea.setRows(5);
        groupIDTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(groupIDTextArea);
        userIDTextArea.setColumns(20);
        userIDTextArea.setLineWrap(true);
        userIDTextArea.setRows(5);
        jScrollPane3.setViewportView(userIDTextArea);

        addUserButton.setText("User");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                addUserButtonActionPerformed(Event);
            }
        });

        addGroupButton.setText("Group");
        addGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                addGroupButtonActionPerformed(Event);
            }
        });

        openUserViewButton.setText("Open User View");
        openUserViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                openUserViewButtonActionPerformed(Event);
            }
        });

        showUserTotalButton.setText("Show User Total");
        showUserTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                showUserTotalButtonActionPerformed(Event);
            }
        });

        showMessagesTotalButton.setText("Show Messages Total");
        showMessagesTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                showMessagesTotalButtonActionPerformed(Event);
            }
        });

        showGroupTotalButton.setText("Show Group Total");
        showGroupTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                showGroupTotalButtonActionPerformed(Event);
            }
        });

        showPositivePercentageButton.setText("Show Positive Percentage");
        showPositivePercentageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                showPositivePercentageButtonActionPerformed(Event);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openUserViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showUserTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showMessagesTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(showGroupTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(showPositivePercentageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openUserViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showUserTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showGroupTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showMessagesTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showPositivePercentageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent Event) {
        if (userIDTextArea.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the user to add.", "Add User Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (!SSID.contains(userIDTextArea.getText())) {
                if (jTreeView.getSelectionPath() == null) {
                    User user = new User(userIDTextArea.getText());
                    DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user, false);
                    users.add(user);
                    SSID.add(userIDTextArea.getText());
                    userViews.put(user.getID(), new UserView(user, SSID, users, userViews));
                    root.add(userNode);
                } else {
                    DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) jTreeView.getSelectionPath().getLastPathComponent();
                    if (selectedElement == root) {
                        User user = new User(userIDTextArea.getText());
                        DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user, false);
                        users.add(user);
                        SSID.add(userIDTextArea.getText());
                        userViews.put(user.getID(), new UserView(user, SSID, users, userViews));
                        root.add(userNode);
                    } else if (selectedElement.getUserObject() instanceof Group) {
                        User user = new User(userIDTextArea.getText());
                        DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user, false);
                        users.add(user);
                        SSID.add(userIDTextArea.getText());
                        userViews.put(user.getID(), new UserView(user, SSID, users, userViews));
                        selectedElement.add(userNode);
                    } else if (selectedElement.getUserObject() instanceof User) {
                        User user = new User(userIDTextArea.getText());
                        DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user, false);
                        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedElement.getParent();
                        users.add(user);
                        SSID.add(userIDTextArea.getText());
                        userViews.put(user.getID(), new UserView(user, SSID, users, userViews));
                        parentNode.add(userNode);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "This exists ", "Add User Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        model.reload(root);
        expandAllNodes(jTreeView, 0, jTreeView.getRowCount());
        userIDTextArea.setText("");
    }

    private void addGroupButtonActionPerformed(java.awt.event.ActionEvent Event) {
        if (groupIDTextArea.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Add a group", "Add Group Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (!SSGID.contains(groupIDTextArea.getText())) {
                if (jTreeView.getSelectionPath() == null) {
                    group = new Group(groupIDTextArea.getText());
                    DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group);
                    groups.add(group);
                    SSGID.add(groupIDTextArea.getText());
                    root.add(groupNode);
                } else {
                    DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) jTreeView.getSelectionPath().getLastPathComponent();
                    if (selectedElement == root) {
                        group = new Group(groupIDTextArea.getText());
                        DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group);
                        groups.add(group);
                        SSGID.add(groupIDTextArea.getText());
                        root.add(groupNode);
                    } else if (SSGID.contains(selectedElement.getUserObject().toString())) {
                        group = new Group(groupIDTextArea.getText());
                        DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group);
                        groups.add(group);
                        SSGID.add(groupIDTextArea.getText());
                        selectedElement.add(groupNode);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "This exists bruh.", "Add Group Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        model.reload(root);
        expandAllNodes(jTreeView, 0, jTreeView.getRowCount());
        groupIDTextArea.setText("");
    }

    private void openUserViewButtonActionPerformed(java.awt.event.ActionEvent Event) {
        if (jTreeView.getSelectionPath() == null) {
            JOptionPane.showMessageDialog(null, "Select a user", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) jTreeView.getSelectionPath().getLastPathComponent();
            if (selectedElement.getUserObject() instanceof Group || selectedElement.getUserObject().toString().equals("Root")) {
                JOptionPane.showMessageDialog(null, "Select a user", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else if (selectedElement.getUserObject() instanceof User) {
                targetUser = selectedElement.getUserObject().toString();
                User user = new User(targetUser);
                UserView userView = userViews.get(targetUser);
                userView.setVisible(true);
                userView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        }
    }

    private void showUserTotalButtonActionPerformed(java.awt.event.ActionEvent Event) {
        JOptionPane.showMessageDialog(null, "There are " + users.size() + " users.", "Show User Total", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showGroupTotalButtonActionPerformed(java.awt.event.ActionEvent Event) {
        int numGroups = groups.size() - 1;
        JOptionPane.showMessageDialog(null, "There are " + numGroups + " groups.", "Show Group Total", JOptionPane.INFORMATION_MESSAGE);    }
    private void showMessagesTotalButtonActionPerformed(java.awt.event.ActionEvent Event) {
        JOptionPane.showMessageDialog(null, "There are " + (int)getTotalMessageCount() + " messages.", "Total", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showPositivePercentageButtonActionPerformed(java.awt.event.ActionEvent Event) {
        if (getTotalMessageCount() == 0) {
            JOptionPane.showMessageDialog(null, "There are nothing to get percentage.", "Positive % Err", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "This " + getPositivePercentage() + "% of message(s) are good.", "Positive", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public List<String> getUniqueIDs() {
        return SSID;
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }

        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());

        }
    }

    public double getTotalMessageCount() {
        double totalMessageCount = 0.0;
        for (User u : users) {
            totalMessageCount += u.getMessageCount();
        }
        return totalMessageCount;
    }
    private static class TreeView extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            if (value instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                if (node.getUserObject().toString() == "Root") {
                    setIcon(UIManager.getIcon("FileView.computerIcon"));
                } else if (node.getUserObject() instanceof Group) {
                    Group groupObject = (Group) node.getUserObject();
                    if (groupObject.isResult()) {
                        setIcon(UIManager.getIcon("FileChooser.homeFolderIcon"));
                    } else {
                        setIcon(UIManager.getIcon("FileChooser.viewMenuIcon"));
                    }
                }
            }
            return this;
        }

    }
    public double getPositivePercentage() {
        double positiveCount = 0.0;
        for (User u : users) {
            positiveCount += u.getPositiveCount();
        }
        return ((positiveCount / getTotalMessageCount()) * 100.0);
    }

  
}
