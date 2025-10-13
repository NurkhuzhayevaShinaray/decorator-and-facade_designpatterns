package devices;

public class MusicSystem implements Device {
    private int volume = 50;
    public String playMusic(){
        return "turning music on";
    }
    public String setVolume(int volume){
        this.volume = volume;
        return "sets volume to " + volume;
    }
    public String stopMusic(){
        return "turning music off";
    }

    @Override
    public void operate(String text) {
        System.out.println("Operating music system: " + text);
    }
}
