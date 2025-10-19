package adapter;
import devices.Device;

public class BluetoothAdapter implements Device {
    private final BluetoothMusicSystem bluetoothSystem;
    public BluetoothAdapter(BluetoothMusicSystem bluetoothSystem){
        this.bluetoothSystem=bluetoothSystem;
    }
    @Override
    public void operate(String text) {
      bluetoothSystem.on();
    }
}
