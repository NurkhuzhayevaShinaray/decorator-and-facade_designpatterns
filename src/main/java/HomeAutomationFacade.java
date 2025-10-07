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
        thermostat.regulateTemperature();
        securityCamera.checkCamera();
    }
    public void startPartyMode(){
        System.out.println("Party mode is activated:");
        light.on();
        musicSystem.playMusic();
    }
    public void leaveHomeMode(){
        System.out.println("Leaving home mode is activated: ");
        light.off();
        musicSystem.stopMusic();
        thermostat.showTemperature();
        securityCamera.checkCamera();
    }
    public void gettingReadyMode(){
        System.out.println("Getting ready mode is activated: ");
        light.on();
        musicSystem.playMusic();
        thermostat.regulateTemperature();
    }
}
