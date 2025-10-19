package devices;


public class Thermostat implements Device {
    private double temperature;

    public void regulateTemperature(double temperature){
        if (temperature >= 18 && temperature <= 30){
            this.temperature=temperature;
            System.out.println("regulating the temperature " + temperature);}
        else {
            System.out.println("You need to choose between 18 and 30!");
        }
    }
    public void ecoMode() {
        System.out.println("eco mode:adjusting temperature range");
    }
    public void autoMode(){
        System.out.println("auto mode:automatically maintain perfect temperature");
    }


    @Override
    public void operate(String text) {
        System.out.println("Operating the thermostat: " + text);
    }
}
