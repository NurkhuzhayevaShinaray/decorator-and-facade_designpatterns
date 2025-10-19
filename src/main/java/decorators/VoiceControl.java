package decorators;

import devices.Device;
import facade.HomeAutomationFacade;
import vosk.VoskLibrary;
import java.util.Scanner;

public class VoiceControl extends DeviceDecorator {
    private final HomeAutomationFacade homeFacade;
    private final VoskLibrary vosk;

    public VoiceControl(Device device, VoskLibrary vosk, HomeAutomationFacade homeFacade) {
        super(device);
        this.vosk = vosk;
        this.homeFacade = homeFacade;
    }

    @Override
    public void operate(String text) {
        super.operate("Voice control is activated, " + text);}

    public String voiceCommand(){
        System.out.println("Listening your command: ");
        String command = vosk.recognize();


        if (command.contains("party")) {
            System.out.println("Voice recognized: Party mode");
            Scanner sc = new Scanner(System.in);
            System.out.print("Please set brightness level (10-100): ");
            int level = sc.nextInt();
            System.out.print("Please set volume (0-100): ");
            int volume = sc.nextInt();
            homeFacade.startPartyMode(level, volume);

        } else if (command.contains("night")) {
            System.out.println("Voice recognized: Night mode");
            homeFacade.activateNightMode();

        } else if (command.contains("leave")) {
            System.out.println("Voice recognized: Leaving Home mode");
            homeFacade.leaveHomeMode();

        } else if (command.contains("ready")) {
            System.out.println("Voice recognized: Getting Ready mode");
            Scanner sc = new Scanner(System.in);
            System.out.print("Please set volume (0-100): ");
            int volume = sc.nextInt();
            System.out.print("Please set temperature (18-30): ");
            double temp = sc.nextDouble();
            homeFacade.gettingReadyMode(volume, temp);

        } else {
            System.out.println("Unfortunaly,couldn't recognize your command, so switching to remote access");
            RemoteAccess remote = new RemoteAccess(device, homeFacade);
            remote.operate("remote control");
        }

        return command.toLowerCase();
    }

}