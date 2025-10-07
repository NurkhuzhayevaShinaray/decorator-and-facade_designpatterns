public class VoiceControl extends DeviceDecorator {
    public VoiceControl(Device device){
        super(device);
    }

    @Override
    public void operate(String text) {
        super.operate("Voice control allowed, " + text);
    }
}
