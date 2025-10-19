package facade;
import adapter.BluetoothMusicSystem;
import adapter.WifiThermostat;
import devices.SecurityCamera;
import devices.Light;
import devices.MusicSystem;
import devices.Thermostat;


public class HomeAutomationFacade {
    private final Light light;
    private final BluetoothMusicSystem bluetoothSystem;
    private final MusicSystem musicSystem;
    private final WifiThermostat wifiThermostat;
    private final Thermostat thermostat;
    private final SecurityCamera securityCamera;

    public HomeAutomationFacade(Light light, BluetoothMusicSystem bluetoothSystem, MusicSystem musicSystem, WifiThermostat wifiThermostat, Thermostat thermostat, SecurityCamera securityCamera){
        this.light = light;
        this.bluetoothSystem = bluetoothSystem;
        this.musicSystem = musicSystem;
        this.wifiThermostat = wifiThermostat;
        this.thermostat = thermostat;
        this.securityCamera = securityCamera;
    }

    public void activateNightMode(){
        System.out.println("Night mode is activated: ");
        light.off();
        wifiThermostat.on();
        thermostat.ecoMode();
        securityCamera.motionMode();
    }
    public void startPartyMode(int level, int volume){
        System.out.println("Party mode is activated: ");
        light.on();
        light.dimEffect(level);
        bluetoothSystem.on();
        musicSystem.playMusic();
        musicSystem.setVolume(volume);
    }
    public void leaveHomeMode(){
        System.out.println("Leaving home mode is activated: ");
        light.off();
        musicSystem.stopMusic();
        wifiThermostat.on();
        thermostat.autoMode();
        securityCamera.recordMode();
    }
    public void gettingReadyMode(int volume, double temperature){
        System.out.println("Getting ready mode is activated: ");
        light.on();
        light.syncEffect();
        bluetoothSystem.on();
        musicSystem.playMusic();
        musicSystem.setVolume(volume);
        wifiThermostat.on();
        thermostat.regulateTemperature(temperature);
    }
}
