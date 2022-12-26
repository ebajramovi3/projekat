package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrival;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrivalDaoImplementation extends SQLConnection implements ArrivalDao{
    /**
     * @param cityOfDeparture
     * @return
     */
    @Override
    public List<Arrival> getByCity(String cityOfDeparture) {
        String query = "SELECT * FROM Arrival WHERE city = ?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, cityOfDeparture);
            ResultSet rs = statement.executeQuery();

            List<Arrival> arrivals = new ArrayList<>();
            while(rs.next()){
                Arrival arrival = new Arrival();
                arrival.setArrivalId(rs.getInt("id"));
                arrival.setCountry(rs.getString("country"));
                arrival.setCity(rs.getString("city"));
                arrival.setDateOfArrival(rs.getDate("date"));

                arrivals.add(arrival);
            }
            rs.close();
            return arrivals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param countryOfDeparture
     * @return
     */
    @Override
    public List<Arrival> getByCountry(String countryOfDeparture) {
        String query = "SELECT * FROM Arrival WHERE country = ?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, countryOfDeparture);
            ResultSet rs = statement.executeQuery();

            List<Arrival> arrivals = new ArrayList<>();
            while(rs.next()){
                Arrival arrival = new Arrival();
                arrival.setArrivalId(rs.getInt("id"));
                arrival.setCountry(rs.getString("country"));
                arrival.setCity(rs.getString("city"));
                arrival.setDateOfArrival(rs.getDate("date"));

                arrivals.add(arrival);
            }
            rs.close();
            return arrivals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param dateOfDeparture
     * @return
     */
    @Override
    public List<Arrival> getByDate(Date dateOfDeparture) {
        String query = "SELECT * FROM Arrival WHERE date = ?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setDate(1, (java.sql.Date) dateOfDeparture);
            ResultSet rs = statement.executeQuery();

            List<Arrival> arrivals = new ArrayList<>();
            while(rs.next()){
                Arrival arrival = new Arrival();
                arrival.setArrivalId(rs.getInt("id"));
                arrival.setCountry(rs.getString("country"));
                arrival.setCity(rs.getString("city"));
                arrival.setDateOfArrival(rs.getDate("date"));

                arrivals.add(arrival);
            }
            rs.close();
            return arrivals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param item
     * @return
     */
    @Override
    public Arrival update(Arrival item) {
        String insert = "UPDATE Arrival SET country = ?, city = ?, date = ? WHERE id = ?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, item.getCountry());
            statement.setString(2, item.getCity());
            statement.setDate(3, (java.sql.Date) item.getDateOfArrival());
            statement.setInt(4, item.getArrivalId());

            statement.executeUpdate();
            return item;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Arrival getById(Integer id) {
        String query = "SELECT * FROM Arrival WHERE id = ?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                Arrival arrival = new Arrival();
                arrival.setArrivalId(rs.getInt("id"));
                arrival.setCountry(rs.getString("country"));
                arrival.setCity(rs.getString("city"));
                arrival.setDateOfArrival(rs.getDate("date"));

                rs.close();
                return arrival;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * @param item
     * @return
     */
    @Override
    public Arrival add(Arrival item) {
        String insert = "INSERT INTO Arrival(country, city, date) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, item.getCountry());
            statement.setString(2, item.getCity());
            statement.setDate(3, (java.sql.Date) item.getDateOfArrival());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();

            item.setArrivalId(rs.getInt(1));
            return item;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param id
     */
    @Override
    public void delete(Integer id) {

    }

    /**
     * @return
     */
    @Override
    public List<Arrival> getAll() {
        String query = "SELECT * FROM Arrival";
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            List<Arrival> arrivals = new ArrayList<>();
            while(rs.next()){
                Arrival arrival = new Arrival();
                arrival.setArrivalId(rs.getInt("id"));
                arrival.setCountry(rs.getString("country"));
                arrival.setCity(rs.getString("city"));
                arrival.setDateOfArrival(rs.getDate("date"));

                arrivals.add(arrival);
            }
            rs.close();
            return arrivals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
