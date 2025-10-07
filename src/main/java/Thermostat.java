public class Thermostat implements Device{
    public String regulateTemperature(){
        return "regulating the temperature";
    }
    public String showTemperature(){
        return "21°C";
    }

    @Override
    public void operate(String text) {
        System.out.println("Operating the thermostat: " + text);
    }
}
