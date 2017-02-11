package davidrowantechnologies.sosapp;

import android.app.Application;
import java.util.Stack;
/**
 * Created by inspi on 2/10/2017.
 */

public class myProperties extends Application {
    private double xCord=0;
    private double yCord=0;
    Stack<Messages> messageList = new Stack<Messages>();
    public double getyCord() {
        return yCord;
    }

    public void setyCord(double yCord) {
        this.yCord = yCord;
    }

    public double getxCord() {
        return xCord;
    }

    public void setxCord(double xCord) {
        this.xCord = xCord;
    }






}
