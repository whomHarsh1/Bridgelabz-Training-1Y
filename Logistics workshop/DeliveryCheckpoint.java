package LogisticProblem;

class DeliveryCheckpoint extends Checkpoint {

    public DeliveryCheckpoint(String id, String loc, double dist, int exp, int act) {
        super(id, loc, dist, exp, act);
    }

    boolean isCritical() {
        return true;
    }

    String getType() {
        return "Delivery";
    }

    double calculatePenalty() {
        if (!isDelayed()) return 0;
        return (getActualDuration() - getExpectedDuration()) * 2;
    }
}