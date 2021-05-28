package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.communication.PerformerType;

public class Singer extends Performer {

    private String firstName;
    private String lastName;
    private String artistName;

    public Singer() {
        type = PerformerType.TYPE_SINGER;
    }

    public Singer(String firstName, String lastName, String artistName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.artistName = artistName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
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
        return "id, countryId, userId, firstName, lastName, artistName, type";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(performerID).append(", ")
                .append(country.getCountryID()).append(", ")
                .append(user.getUserID()).append(", ")
                .append("'").append(firstName).append("', ")
                .append("'").append(lastName).append("', ")
                .append("'").append(artistName).append("', ")
                .append("'").append(type).append("'");
        return sb.toString();
    }

    @Override
    public List<GenericEntity> createListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Singer singer = new Singer();

            singer.setPerformerID(rs.getLong("id"));

            Country c = new Country();
            c.setCountryID(rs.getLong("countryId"));
            singer.setCountry(c);

            User u = new User();
            u.setUserID(rs.getLong("userId"));
            singer.setUser(u);

            singer.setFirstName(rs.getString("firstName"));
            singer.setLastName(rs.getString("lastName"));
            singer.setArtistName(rs.getString("artistName"));

            singer.setType(PerformerType.valueOf(rs.getString("type")));

            list.add(singer);
        }
        return list;
    }

    @Override
    public GenericEntity createEntityFromResultSet(ResultSet rs) throws Exception {
        
        Singer singer = new Singer();
        while (rs.next()) {

            singer.setPerformerID(rs.getLong("id"));

            Country c = new Country();
            c.setCountryID(rs.getLong("countryId"));
            singer.setCountry(c);

            User u = new User();
            u.setUserID(rs.getLong("userId"));
            singer.setUser(u);

            singer.setFirstName(rs.getString("firstName"));
            singer.setLastName(rs.getString("lastName"));
            singer.setArtistName(rs.getString("artistName"));

        }
        
        return singer;
        
    }
    
    public String getArtistNameCondition(){
        return "artistName = '" + this.artistName + "'";
    }

}
