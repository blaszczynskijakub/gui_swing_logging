
import java.util.ArrayList;

public class CheckIfBefore {
    private ArrayList<User> users;
    private String userName;
    private boolean wasBefore;

    public boolean isWasBefore() {
        return wasBefore;
    }




    public CheckIfBefore(ArrayList<User> users, String userName) {
        this.users = users;
        this.userName = userName;


    }
    public  void ifBefore()
    {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                wasBefore = true;
                break;
            } else {
                wasBefore=false;
            }
        }

    }

}
