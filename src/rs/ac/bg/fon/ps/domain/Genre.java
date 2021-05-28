package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Genre implements GenericEntity {

    private long genreID;
    private String name;

    public Genre() {
    }

    public Genre(long genreID, String name) {
        this.genreID = genreID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGenreID() {
        return genreID;
    }

    public void setGenreID(long genreID) {
        this.genreID = genreID;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Genre other = (Genre) obj;
        if (this.genreID != other.genreID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "genre";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, name";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(genreID).append(", ")
                .append("'").append(name).append("'");

        return sb.toString();
    }

    @Override
    public List<GenericEntity> createListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {

            Genre genre = new Genre();
            genre.setGenreID(rs.getLong("id"));
            genre.setName(rs.getString("name"));
            list.add(genre);
        }
        return list;
    }

    @Override
    public GenericEntity createEntityFromResultSet(ResultSet rs) throws Exception {
        Genre genre = new Genre();

        while (rs.next()) {
            genre.setGenreID(rs.getLong("id"));
            genre.setName(rs.getString("name"));
        }
        
        return genre;
    }

    @Override
    public String getIdCondition() {
        return "id = " + genreID;
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
