package adapter;
import devices.Device;

public class WifiAdapter implements Device {
    private WifiThermostat wifiThermostat;

    public WifiAdapter(WifiThermostat wifiThermostat){
        this.wifiThermostat=wifiThermostat;
    }

    @Override
    public void operate(String text) {
        wifiThermostat.on();
    }
}

