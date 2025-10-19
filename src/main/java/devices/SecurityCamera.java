package devices;

public class SecurityCamera implements Device {
    public void recordMode() {
        System.out.println("record mode:checks the camera");
    }
    public void privacyMode() {
        System.out.println("privacy mode:turns the camera off");
    }
    public void motionMode() {
        System.out.println("motion mode:detects movements");
    }

    @Override
    public void operate(String text) {
        System.out.println("Operating the security cameras: " + text);
    }
}
