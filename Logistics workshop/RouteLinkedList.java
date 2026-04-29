package LogisticProblem;

import java.sql.*;

class RouteLinkedList<T extends Checkpoint> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;

    public void addCheckpoint(T checkpoint) {
        Node newNode = new Node(checkpoint);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void printRoute() {
        Node temp = head;
        int i = 1;

        while (temp != null) {
            Checkpoint c = temp.data;
            String status = c.isDelayed() ? "Delayed" : "On Time";

            System.out.println(i + ". " + c.getType() + " Checkpoint – "
                    + c.getLocationName() + " – "
                    + status + " – Penalty: "
                    + c.calculatePenalty());

            temp = temp.next;
            i++;
        }
    }

    // SAVE TO DB
    public void saveToDatabase(String driverId) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO checkpoints VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            Node temp = head;

            while (temp != null) {
                Checkpoint c = temp.data;

                ps.setString(1, c.getCheckpointId());
                ps.setString(2, driverId);
                ps.setString(3, c.getType());
                ps.setString(4, c.getLocationName());
                ps.setDouble(5, c.getDistanceFromLast());
                ps.setInt(6, c.getExpectedDuration());
                ps.setInt(7, c.getActualDuration());

                ps.executeUpdate();

                temp = temp.next;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LOAD FROM DB
    public void loadFromDatabase(String driverId) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM checkpoints WHERE driver_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, driverId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String type = rs.getString("type");
                Checkpoint c;

                if (type.equals("Delivery")) {
                    c = new DeliveryCheckpoint(
                            rs.getString("checkpoint_id"),
                            rs.getString("location_name"),
                            rs.getDouble("distance"),
                            rs.getInt("expected_duration"),
                            rs.getInt("actual_duration")
                    );
                } else if (type.equals("Fuel")) {
                    c = new FuelCheckpoint(
                            rs.getString("checkpoint_id"),
                            rs.getString("location_name"),
                            rs.getDouble("distance"),
                            rs.getInt("expected_duration"),
                            rs.getInt("actual_duration")
                    );
                } else {
                    c = new RestCheckpoint(
                            rs.getString("checkpoint_id"),
                            rs.getString("location_name"),
                            rs.getDouble("distance"),
                            rs.getInt("expected_duration"),
                            rs.getInt("actual_duration")
                    );
                }

                addCheckpoint((T) c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}