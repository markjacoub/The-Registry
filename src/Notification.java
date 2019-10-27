import javax.swing.JOptionPane;


public class Notification {

    //Display pop up with new size of passed planner
    public void sendNotification(Planner planner) {
        JOptionPane.showMessageDialog(null, "A new event has been added to the planner \n Current Planner Size:" + planner.getSize(), "Popup Notification", JOptionPane.INFORMATION_MESSAGE);
    }
}
