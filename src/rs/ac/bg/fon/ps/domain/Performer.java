package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.communication.PerformerType;

public class Performer implements GenericEntity {

    protected long performerID;
    protected Country country;
    protected User user;
    protected PerformerType type;

    public Performer() {
    }

    public Performer(long performerID, Country country, User user, PerformerType type) {
        this.performerID = performerID;
        this.country = country;
        this.user = user;
        this.type = type;
    }

    public PerformerType getType() {
        return type;
    }

    public void setType(PerformerType type) {
        this.type = type;
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Performer other = (Performer) obj;
        if (this.performerID != other.performerID) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "performer";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, countryId, userId, type";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(performerID).append(", ")
                .append(country.getCountryID()).append(", ")
                .append(user.getUserID()).append(", ")
                .append("'").append(type).append("'");
        return sb.toString();
    }

    @Override
    public List<GenericEntity> createListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Performer performer = new Performer();

            performer.setPerformerID(rs.getLong("id"));

            Country c = new Country();
            c.setCountryID(rs.getLong("countryId"));
            performer.setCountry(c);

            User u = new User();
            u.setUserID(rs.getLong("userId"));
            performer.setUser(u);

            performer.setType(PerformerType.valueOf(rs.getString("type")));

            list.add(performer);
        }
        return list;
    }

    @Override
    public GenericEntity createEntityFromResultSet(ResultSet rs) throws Exception {
        
        Performer performer = new Performer();
        while (rs.next()) {
            performer.setPerformerID(rs.getLong("id"));

            Country c = new Country();
            c.setCountryID(rs.getLong("countryId"));
            performer.setCountry(c);

            User u = new User();
            u.setUserID(rs.getLong("userId"));
            performer.setUser(u);

            performer.setType(PerformerType.valueOf(rs.getString("type")));
            return performer;

        }
        return null;
    }

    @Override
    public String getIdCondition() {
        return "id = " + this.performerID;
    }

    @Override
    public String getUpdateValues(GenericEntity param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteCondition() {
        return getIdCondition();
    }

    public String getTypeCondition() {
        return "type = '" + this.getType() + "'";
    }

}
