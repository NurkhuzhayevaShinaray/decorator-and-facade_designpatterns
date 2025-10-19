import devices.*;
import adapter.BluetoothMusicSystem;
import adapter.WifiThermostat;
import facade.HomeAutomationFacade;
import decorators.RemoteAccess;
import decorators.VoiceControl;
import vosk.VoskLibrary;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        MusicSystem musicSystem = new MusicSystem();
        Thermostat thermostat = new Thermostat();
        SecurityCamera securityCamera = new SecurityCamera();
        BluetoothMusicSystem bluetoothSystem = new BluetoothMusicSystem();
        WifiThermostat wifiThermostat = new WifiThermostat();

        HomeAutomationFacade homeFacade = new HomeAutomationFacade(light, bluetoothSystem, musicSystem, wifiThermostat, thermostat, securityCamera);

        VoskLibrary vosk = new VoskLibrary("src/main/resources/vosk-model-small-en-us-0.15");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome home!");
        System.out.println("Would you like to control the system by:");
        System.out.println("1. By voice control");
        System.out.println("2. Remotely");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            VoiceControl voice = new VoiceControl(light, vosk, homeFacade);
            voice.operate("Activating by voice...");
            String command = voice.voiceCommand();
        } else if (choice == 2) {
            RemoteAccess remote = new RemoteAccess(light, homeFacade);
            remote.operate("Activating by remote...");
        } else {
            System.out.println("Incorrect, exiting...");
        }
    }
}
