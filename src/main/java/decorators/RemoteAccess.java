package decorators;

import devices.Device;
import facade.HomeAutomationFacade;
import java.util.Scanner;

public class RemoteAccess extends DeviceDecorator {
    private HomeAutomationFacade homeFacade;

    public RemoteAccess(Device device, HomeAutomationFacade homeFacade) {
        super(device);
        this.homeFacade = homeFacade;
    }

    @Override
    public void operate(String text) {
        super.operate("Remote control is activated, " + text);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Remote Control — Choose a mode:");
        System.out.println("1. Party Mode");
        System.out.println("2. Night Mode");
        System.out.println("3. Leave Home Mode");
        System.out.println("4. Getting Ready Mode");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:{
                System.out.print("Enter brightness level (10-100): ");
                int level = scanner.nextInt();
                System.out.print("Enter music volume (0-100): ");
                int volume = scanner.nextInt();
                homeFacade.startPartyMode(level, volume);
                break;
            }
            case 2: homeFacade.activateNightMode();
            break;
            case 3: homeFacade.leaveHomeMode();
            break;
            case 4: {
                System.out.print("Enter volume (0-100): ");
                int volume = scanner.nextInt();
                System.out.print("Enter temperature (18-30): ");
                double temperature = scanner.nextDouble();
                homeFacade.gettingReadyMode(volume, temperature);
                break;

            }
            default:  System.out.println("Invalid choice!");
        }
    }
}

