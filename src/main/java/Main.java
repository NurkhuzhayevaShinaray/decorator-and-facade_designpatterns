import decorators.EnergySaving;
import decorators.RemoteAccess;
import decorators.VoiceControl;
import devices.*;
import facade.HomeAutomationFacade;

public class Main {
    public static void main(String[] args){
        Light light = new Light();
        Device decoratedLight = new RemoteAccess(new EnergySaving(light));
        MusicSystem musicSystem = new MusicSystem();
        Device decoratedMusicSystem = new VoiceControl(new RemoteAccess(musicSystem));
        Thermostat thermostat = new Thermostat();
        Device decoratedThermostat = new EnergySaving(new RemoteAccess(thermostat));
        SecurityCamera securityCamera = new SecurityCamera();
        Device decoratedSecurityCamera = new RemoteAccess(new EnergySaving(securityCamera));

        HomeAutomationFacade facade = new HomeAutomationFacade(light,musicSystem,thermostat,securityCamera);
        facade.gettingReadyMode();
        decoratedLight.operate(light.syncEffect());
        decoratedMusicSystem.operate(musicSystem.playMusic());
        decoratedThermostat.operate(thermostat.regulateTemperature());
       }
    }