package at.aau.serg.exercises.dronelogic;

public class CourierDone extends Drone{

    public enum OperationMode {
        LOW_ALTITUDE,
        HIGH_ALTITUDE,
        SCAN
    }

    private int operationRange;
    private OperationMode operationMode;


    public int getOperationRange() {
        return operationRange;
    }

    public void setOperationRange(int operationRange) {
        this.operationRange = operationRange;
    }

    public OperationMode getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(OperationMode operationMode) {
        this.operationMode = operationMode;
    }

    @Override
    public String getDescription() {
        return "Courier: A drone optimized for fast package delivery.";
    }

}
