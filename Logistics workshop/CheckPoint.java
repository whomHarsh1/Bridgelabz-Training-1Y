package LogisticProblem;

abstract class Checkpoint {
    private String checkpointId;
    private String locationName;
    private double distanceFromLast;
    private int expectedDuration;
    private int actualDuration;

    public Checkpoint(String id, String location, double distance, int expected, int actual) {
        this.checkpointId = id;
        this.locationName = location;
        this.distanceFromLast = distance;
        this.expectedDuration = expected;
        this.actualDuration = actual;
    }

    public String getCheckpointId() {
        return checkpointId;
    }

    public String getLocationName() {
        return locationName;
    }

    public double getDistanceFromLast() {
        return distanceFromLast;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public int getActualDuration() {
        return actualDuration;
    }

    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }

    abstract boolean isCritical();
    abstract String getType();
    abstract double calculatePenalty();
}