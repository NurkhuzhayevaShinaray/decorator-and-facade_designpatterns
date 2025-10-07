public class SecurityCamera implements Device{
    public String checkCamera(){
        return "checking the camera";
    }

    @Override
    public void operate(String text) {
        System.out.println("Operating the security cameras: " + text);
    }
}
