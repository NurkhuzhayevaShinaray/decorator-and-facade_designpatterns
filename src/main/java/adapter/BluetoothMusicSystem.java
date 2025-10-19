package adapter;

public class BluetoothMusicSystem {
    private boolean connected = false;

    public boolean isConnected() {
        connected = !connected;
        return connected;
    }

    public void on(){
        if (isConnected()){
        System.out.println("Music system turned on via Bluetooth");}
        else {
            System.out.println("Failed to operate music system!");
        }
    }
}
