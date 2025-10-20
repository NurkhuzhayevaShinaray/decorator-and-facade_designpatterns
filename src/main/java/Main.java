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
        Application application = new Application();
        application.Run();
    }
}
