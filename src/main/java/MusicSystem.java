public class MusicSystem implements Device{
    public String playMusic(){
        return "turning music on";
    }
    public double volume(){
        return 65;
    }
    public String stopMusic(){
        return "turning music off";
    }

    @Override
    public void operate(String text) {
        System.out.println("Operating music system: " + text);
    }
}
