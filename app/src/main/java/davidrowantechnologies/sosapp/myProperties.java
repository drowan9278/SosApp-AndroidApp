package davidrowantechnologies.sosapp;

import android.app.Application;
import java.util.Stack;
/**
 * Created by inspi on 2/10/2017.
 */

public class myProperties extends Application {
    private double xCord=0;
    private double yCord=0;
    public Stack<messageObject> messageList = new Stack<messageObject>();
    private double interval=20000;
    private double FastestInterval=5000;

    public double getyCord() {
        return yCord;
    }

    public void setyCord(double yCord) { this.yCord = yCord; }

    public double getxCord() {
        return xCord;
    }

    public void setxCord(double xCord) {
        this.xCord = xCord;
    }

    public double getInterval() { return interval; }

    public void setInterval(double interval) { this.interval = interval;}

    public double getFastestInterval() { return FastestInterval; }

    public void setFastestInterval(double FastestInterval) { this.FastestInterval = FastestInterval; }

}
