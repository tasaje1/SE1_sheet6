package at.aau.serg.exercises.dronelogic;

public class SurveyorDrone extends Drone{
    private int battery;
    private int operationRange;

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getOperationRange() {
        return operationRange;
    }

    public void setOperationRange(int operationRange) {
        this.operationRange = operationRange;
    }

    @Override
    public String getDescription() {
        return "Surveyor: A drone specialized in scanning and mapping areas.";
    }
}
