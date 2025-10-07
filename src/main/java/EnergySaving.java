public class EnergySaving extends DeviceDecorator {
    public EnergySaving(Device device){
        super(device);
    }



    @Override
    public void operate(String text) {
        super.operate("Energy saving allowed, " +text);
    }
}
