package devices;

public class Thermostat implements Device {
    public String regulateTemperature(){
        return "regulating the temperature ";
    }
    public String ecoMode() {
        return "adjusting temperature range";
    }
    public String autoMode(){
        return "automatically maintain perfect temperature";
    }


    @Override
    public void operate(String text) {
        System.out.println("Operating the thermostat: " + text);
    }
}
