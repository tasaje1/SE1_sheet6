package at.aau.serg.exercises.dronelogic;

public class Drone {

    private String serialNumber;

    private Integer firmwareVersion;

    private String droneType;

    private double payload;

    private int operationRange;

    private short operationMode;

    private String payloadEffect;

    private boolean shieldModeEnabled;

    private int battery;

    public String getDescription() {
        switch (getDroneType()) {
            case "Surveyor":
                return "Surveyor: A drone specialized in scanning and mapping areas.";
            case "Guardian":
                return "Guardian: A drone designed to patrol and protect zones.";
            case "Courier":
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

    /**
     * Allowed types: Surveyor, Guardian, Courier
     */
    public String getDroneType() {
        return droneType;
    }

    public void setDroneType(String droneType) {
        this.droneType = droneType;
    }

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
