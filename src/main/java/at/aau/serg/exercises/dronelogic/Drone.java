package at.aau.serg.exercises.dronelogic;

public class Drone {

    public String serialNumber;

    public Integer firmwareVersion;

    /**
     * Allowed types: Surveyor, Guardian, Courier
     */
    public String droneType;

    public double payload;

    /**
     * Used for scan and high-altitude modes, low-altitude ignores this value
     */
    public int operationRange;

    /**
     * 1 := lowAltitude (guardian always has this disabled)
     * 2 := highAltitude
     * 3 := scan (only surveyor has this, always)
     */
    public short operationMode;

    /**
     * None (null), thermal, camera, jammer, medical
     */
    public String payloadEffect;

    /**
     * Indicates if a guardian currently has their shield mode enabled
     */
    public boolean shieldModeEnabled;

    /**
     * Available battery of surveyor
     */
    public int battery;

    public String getDescription() {
        switch (droneType) {
            case "Surveyor":
                return "Surveyor: A drone specialized in scanning and mapping areas.";
            case "Guardian":
                return "Guardian: A drone designed to patrol and protect zones.";
            case "Courier":
                return "Courier: A drone optimized for fast package delivery.";
            default:
                throw new IllegalStateException("Unexpected drone type: " + droneType);
        }
    }

    public boolean isCertified() {
        return firmwareVersion.equals(12);
    }
}
