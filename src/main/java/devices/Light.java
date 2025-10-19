package devices;

public class Light implements Device {
    public void on(){
        System.out.println("lights turned on");
    }
    public void off(){
        System.out.println("lights turned off");
    }

    public void dimEffect(int level) {
        if (level >= 10 && level <= 100) {
            System.out.println("adjusts brightness" + level + "%");
        }
    }
    public void syncEffect(){
        System.out.println("mimics by presence");
    }

    @Override
    public void operate(String text) {
        System.out.println("Operating the: " + text);
    }
}
