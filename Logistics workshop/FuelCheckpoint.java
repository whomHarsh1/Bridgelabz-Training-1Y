package LogisticProblem;

class FuelCheckpoint extends Checkpoint {

    public FuelCheckpoint(String id, String loc, double dist, int exp, int act) {
        super(id, loc, dist, exp, act);
    }

    boolean isCritical() {
        return true;
    }

    String getType() {
        return "Fuel";
    }

    double calculatePenalty() {
        return isDelayed() ? 10 : 0;
    }
}