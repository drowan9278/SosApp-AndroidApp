package davidrowantechnologies.sosapp;

/**
 * Created by inspi on 2/10/2017.
 */

public class messageObject {
    private String name =null;
    private String date = null;
    private String clothes = null;
    private String landmarks = null;
    private String timeSent = null;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(String landmarks) {
        this.landmarks = landmarks;
    }

    public String getEmerInfo() {
        return emerInfo;
    }

    public void setEmerInfo(String emerInfo) {
        this.emerInfo = emerInfo;
    }

    private String emerInfo = null;
}
