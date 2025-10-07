public class Light implements Device{
    public String on(){
        return "lights on";
    }
    public String off(){
        return "lights off";
    }
    @Override
    public void operate(String text) {
        System.out.println("Operating the light: " + text);
    }
}
