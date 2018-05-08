package uberjava;

public class UberJavaSession {

    private int sessionNumber;
    private UberStatistics uberStatistics;
    private boolean active;

    UberJavaSession() {
        active = true;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public UberStatistics getUberStatistics() {
        return uberStatistics;
    }

    public void setUberStatistics (UberStatistics uber) {
        this.uberStatistics = uber;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
