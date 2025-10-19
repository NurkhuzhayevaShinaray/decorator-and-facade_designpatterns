package devices;

public class MusicSystem implements Device {
    private int volume;

    public void playMusic(){
        System.out.println("turning music on");
    }
    public void setVolume(int volume){
        if(volume >=0 && volume <=100){
        this.volume = volume;
        System.out.println("Sets volume to " + volume + "%");}
        else {
            System.out.println("Please choose between 0 and 100!");
        }
    }
    public void stopMusic(){
        System.out.println("turning music off");
    }

    @Override
    public void operate(String text) {
        System.out.println("Operating music system: " + text);
    }
}
