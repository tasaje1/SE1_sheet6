package at.aau.serg.exercises.dronelogic;

public abstract class Drone {
    private String serialNumber;
    private Integer firmwareVersion;
    private double payload;




    public boolean isCertified() {
        return firmwareVersion != null & firmwareVersion.equals(12);
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


    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    public abstract String getDescription();







}
