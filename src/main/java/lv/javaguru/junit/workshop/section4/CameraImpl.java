package lv.javaguru.junit.workshop.section4;


public class CameraImpl implements Camera {

    private static enum CameraState { ON, OFF }

    private CameraState state;
    private Sensor sensor;
    private MemoryCard memoryCard;


    public CameraImpl(Sensor sensor, MemoryCard memoryCard) {
        this.state = CameraState.OFF;
        this.sensor = sensor;
        this.memoryCard = memoryCard;
    }

    public void powerOn() {
        state = CameraState.ON;
        sensor.powerUp();
    }

    public void powerOff() {
        state = CameraState.OFF;
        sensor.powerDown();
    }

    public void pressShutter() {
        if(CameraState.ON.equals(state)) {
            byte[] picture = sensor.readData();
            memoryCard.write(picture);
        }
    }

}
