package devices;

public class SecurityCamera implements Device {
    public String recordMode() {
        return "checks the camera";
    }
    public String privacyMode() {
        return "turns the camera off";
    }
    public String motionMode() {
        return "detects movements";
    }

    @Override
    public void operate(String text) {
        System.out.println("Operating the security cameras: " + text);
    }
}
