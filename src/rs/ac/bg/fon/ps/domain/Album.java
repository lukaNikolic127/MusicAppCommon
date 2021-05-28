package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Album implements GenericEntity {

    private long albumID;
    private String name;
    private double duration;
    private int numberOfSongs;
    private User user;
    private List<Song> songs;

    public Album() {
    }

    public Album(long albumID, String name, long duration, int numberOfSongs, User user, List<Song> songs) {
        this.albumID = albumID;
        this.name = name;
        this.duration = duration;
        this.numberOfSongs = numberOfSongs;
        this.user = user;
        this.songs = songs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getAlbumID() {
        return albumID;
    }

    public void setAlbumID(long albumID) {
        this.albumID = albumID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
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
        final Album other = (Album) obj;
        if (this.albumID != other.albumID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "album";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, name, duration, numberOfSongs, userId";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(albumID).append(", ")
                .append("'").append(name).append("'").append(", ")
                .append(duration).append(", ")
                .append(numberOfSongs).append(", ")
                .append(user.getUserID());

        return sb.toString();
    }

    @Override
    public String getUpdateValues(GenericEntity param) {
        Album newAlbum = (Album) param;
        return "name = '" + newAlbum.getName() + "', duration = " + newAlbum.getDuration() + ", numberOfSongs = "
                + newAlbum.getNumberOfSongs() + ", userId = " + newAlbum.getUser().getUserID();
    }

    @Override
    public List<GenericEntity> createListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {

            Album album = new Album();
            album.setAlbumID(rs.getLong("id"));
            album.setName(rs.getString("name"));
            album.setDuration(rs.getDouble("duration"));
            album.setNumberOfSongs(rs.getInt("numberOfSongs"));
            User user = new User();
            user.setUserID(rs.getLong("userId"));
            album.setUser(user);

            list.add(album);
        }
        return list;
    }

    @Override
    public GenericEntity createEntityFromResultSet(ResultSet rs) throws Exception {
        Album album = new Album();

        while (rs.next()) {

            album.setAlbumID(rs.getLong("id"));
            album.setName(rs.getString("name"));
            album.setDuration(rs.getDouble("duration"));
            album.setNumberOfSongs(rs.getInt("numberOfSongs"));
            User user = new User();
            user.setUserID(rs.getLong("userId"));
            album.setUser(user);

        }
        
        return album;
    }

    @Override
    public String getIdCondition() {
        return "id = " + this.albumID;
    }

    @Override
    public String getDeleteCondition() {
        return getIdCondition();
    }
    
    public String getNameCondition() {
        return "name = '" + this.name + "'";
    }

}
