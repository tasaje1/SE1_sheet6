package at.aau.serg.exercises.dronelogic;

public class Drone {

    public enum droneType{
        SURVEYOR,
        GUARDIAN,
        COURTIER
    }
    private String serialNumber;

    private Integer firmwareVersion;

    private droneType droneType;

    private double payload;

    private int operationRange;

    private short operationMode;

    private String payloadEffect;

    private boolean shieldModeEnabled;

    private int battery;

    public String getDescription() {
        switch (getDroneType()) {
            case SURVEYOR:
                return "Surveyor: A drone specialized in scanning and mapping areas.";
            case GUARDIAN:
                return "Guardian: A drone designed to patrol and protect zones.";
            case COURTIER:
                return "Courier: A drone optimized for fast package delivery.";
            default:
                throw new IllegalStateException("Unexpected drone type: " + getDroneType());
        }
    }

    public boolean isCertified() {
        return getFirmwareVersion().equals(12);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(Integer firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public Drone.droneType getDroneType() {
        return droneType;
    }

    public void setDroneType(Drone.droneType droneType) {
        this.droneType = droneType;
    }

    /**
     * Allowed types: Surveyor, Guardian, Courier
     */



    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    /**
     * Used for scan and high-altitude modes, low-altitude ignores this value
     */
    public int getOperationRange() {
        return operationRange;
    }

    public void setOperationRange(int operationRange) {
        this.operationRange = operationRange;
    }

    /**
     * 1 := lowAltitude (guardian always has this disabled)
     * 2 := highAltitude
     * 3 := scan (only surveyor has this, always)
     */
    public short getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(short operationMode) {
        this.operationMode = operationMode;
    }

    /**
     * None (null), thermal, camera, jammer, medical
     */
    public String getPayloadEffect() {
        return payloadEffect;
    }

    public void setPayloadEffect(String payloadEffect) {
        this.payloadEffect = payloadEffect;
    }

    /**
     * Indicates if a guardian currently has their shield mode enabled
     */
    public boolean isShieldModeEnabled() {
        return shieldModeEnabled;
    }

    public void setShieldModeEnabled(boolean shieldModeEnabled) {
        this.shieldModeEnabled = shieldModeEnabled;
    }

    /**
     * Available battery of surveyor
     */
    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
}
