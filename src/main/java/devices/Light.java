package devices;

public class Light implements Device {
    public void on(){
    }
    public void off(){
    }
    public String dimEffect(){
        return "adjusts brightness";
    }
    public String syncEffect(){
        return "mimics by presence";
    }

    @Override
    public void operate(String text) {
        System.out.println("Operating the light: " + text);
    }
}
