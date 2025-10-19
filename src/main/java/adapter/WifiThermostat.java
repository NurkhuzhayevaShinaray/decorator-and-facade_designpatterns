package adapter;

public class WifiThermostat {
    private boolean connected = false;

    public boolean isConnected() {
        connected = !connected;
        return connected;
    }

    public void on() {
        if (isConnected()) {
            System.out.println("Thermostat is on via WIFI");
        } else {
            System.out.println("Failed to operate thermostat!");
        }
    }
}
