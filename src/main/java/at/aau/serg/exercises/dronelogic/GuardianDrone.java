package at.aau.serg.exercises.dronelogic;

public class GuardianDrone extends Drone{
    private boolean shieldModeEnabled;

    public boolean isShieldModeEnabled() {
        return shieldModeEnabled;
    }

    public void setShieldModeEnabled(boolean shieldModeEnabled) {
        this.shieldModeEnabled = shieldModeEnabled;
    }

    @Override
    public String getDescription() {
        return "Guardian: A drone designed to patrol and protect zones.";
    }

}
