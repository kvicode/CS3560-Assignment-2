package cs3560_Assignment2;


public interface VisitorButton {
    public void visitGroupTotal(Group group);    
    public void visitPositivePercentage(User user);
	public void visitUserTotal(User user);
	public void visitMessagesTotal(User user);
	}


