package facade;
import devices.SecurityCamera;
import devices.Light;
import devices.MusicSystem;
import devices.Thermostat;

public class HomeAutomationFacade {
    private final Light light;
    private final MusicSystem musicSystem;
    private final Thermostat thermostat;
    private final SecurityCamera securityCamera;

    public HomeAutomationFacade(Light light, MusicSystem musicSystem, Thermostat thermostat, SecurityCamera securityCamera){
        this.light = light;
        this.musicSystem = musicSystem;
        this.thermostat = thermostat;
        this.securityCamera = securityCamera;
    }

    public void activateNightMode(){
        System.out.println("Night mode is activated: ");
        light.off();
        thermostat.ecoMode();
        securityCamera.motionMode();
    }
    public void startPartyMode(){
        System.out.println("Party mode is activated:");
        light.dimEffect();
        musicSystem.playMusic();
        musicSystem.setVolume(100);
    }
    public void leaveHomeMode(){
        System.out.println("Leaving home mode is activated: ");
        light.off();
        musicSystem.stopMusic();
        thermostat.autoMode();
        securityCamera.recordMode();
    }
    public void gettingReadyMode(){
        System.out.println("Getting ready mode is activated: ");
        light.syncEffect();
        musicSystem.playMusic();
        thermostat.regulateTemperature();
    }
}
