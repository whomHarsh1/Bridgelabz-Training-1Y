package LogisticProblem;

import java.sql.*;

class Driver {
    private String driverId;
    private String name;
    private RouteLinkedList<Checkpoint> routeHistory;

    public Driver(String id, String name) {
        this.driverId = id;
        this.name = name;
        this.routeHistory = new RouteLinkedList<>();
    }

    public RouteLinkedList<Checkpoint> getRouteHistory() {
        return routeHistory;
    }

    public void saveDriver() {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO drivers VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, driverId);
            ps.setString(2, name);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}