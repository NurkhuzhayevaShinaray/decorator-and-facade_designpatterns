public class RemoteAccess extends DeviceDecorator {
    public RemoteAccess(Device device){
        super(device);
    }

    @Override
    public void operate(String text) {
        super.operate("Remote access allowed, " +text);
    }
}
