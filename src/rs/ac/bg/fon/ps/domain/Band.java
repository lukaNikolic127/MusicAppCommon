package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.communication.PerformerType;

public class Band extends Performer {

    private String bandName;

    public Band() {
        type = PerformerType.TYPE_BAND;
    }

    public Band(String bandName) {
        this.bandName = bandName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public long getPerformerID() {
        return performerID;
    }

    public void setPerformerID(long performerID) {
        this.performerID = performerID;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PerformerType getType() {
        return type;
    }

    public void setType(PerformerType type) {
        this.type = type;
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, countryId, userId, bandName, type";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(performerID).append(", ")
                .append(country.getCountryID()).append(", ")
                .append(user.getUserID()).append(", ")
                .append("'").append(bandName).append("', ")
                .append("'").append(type).append("'");
        return sb.toString();
    }

    @Override
    public List<GenericEntity> createListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Band band = new Band();

            band.setPerformerID(rs.getLong("id"));

            Country c = new Country();
            c.setCountryID(rs.getLong("countryId"));
            band.setCountry(c);

            User u = new User();
            u.setUserID(rs.getLong("userId"));
            band.setUser(u);

            band.setBandName(rs.getString("bandName"));
            band.setType(PerformerType.valueOf(rs.getString("type")));

            list.add(band);
        }
        return list;
    }

    @Override
    public GenericEntity createEntityFromResultSet(ResultSet rs) throws Exception {
        Band band = new Band();

        while (rs.next()) {
            band.setPerformerID(rs.getLong("id"));

            Country c = new Country();
            c.setCountryID(rs.getLong("countryId"));
            band.setCountry(c);

            User u = new User();
            u.setUserID(rs.getLong("userId"));
            band.setUser(u);

            band.setBandName(rs.getString("bandName"));
            band.setType(PerformerType.valueOf(rs.getString("type")));

        }
        return band;
    }

    public String getBandNameCondition() {
        return "bandName = '" + this.bandName + "'";
    }
}
