package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Country implements GenericEntity {

    private long countryID;
    private String name;

    public Country() {
    }

    public Country(long countryID, String name) {
        this.countryID = countryID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCountryID() {
        return countryID;
    }

    public void setCountryID(long countryID) {
        this.countryID = countryID;
    }

    @Override
    public String toString() {
        return name;
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
        final Country other = (Country) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "country";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, name";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(countryID).append(", ")
                .append("'").append(name).append("'");
        return sb.toString();
    }

    @Override
    public List<GenericEntity> createListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {
            Country country = new Country();
            country.setCountryID(rs.getLong("id"));
            country.setName(rs.getString("name"));
            list.add(country);
        }
        return list;
    }

    @Override
    public GenericEntity createEntityFromResultSet(ResultSet rs) throws Exception {
        Country country = new Country();
        while (rs.next()) {
            country.setCountryID(rs.getLong("id"));
            country.setName(rs.getString("name"));
        }
        return country;
    }

    @Override
    public String getIdCondition() {
        return "id = " + this.countryID;
    }

    @Override
    public String getUpdateValues(GenericEntity param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
