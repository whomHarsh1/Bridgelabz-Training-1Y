package com.gla;

class RestCheckpoint extends Checkpoint {

    public RestCheckpoint(String id, String loc, double dist, int exp, int act) {
        super(id, loc, dist, exp, act);
    }

    boolean isCritical() { return false; }

    String getType() { return "RestCheckpoint"; }

    double calculatePenalty() {
        if (!isDelayed()) return 0;
        int delay = actualDuration - expectedDuration;
        return delay > 30 ? delay * 0.5 : 0;
    }
}
