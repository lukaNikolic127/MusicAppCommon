package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Song implements GenericEntity {

    private long songID;
    private String name;
    private double duration;
    private Genre genre;
    private User user;
    private Album album;
    private List<PerformerSong> performerSongs;

    public Song() {
    }

    public Song(long songID, String name, double duration, Genre genre, User user, Album album, List<PerformerSong> performerSongs) {
        this.songID = songID;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.user = user;
        this.album = album;
        this.performerSongs = performerSongs;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public long getSongID() {
        return songID;
    }

    public void setSongID(long songID) {
        this.songID = songID;
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

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PerformerSong> getPerformerSongs() {
        return performerSongs;
    }

    public void setPerformerSongs(List<PerformerSong> performerSongs) {
        this.performerSongs = performerSongs;
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
        final Song other = (Song) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "song";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, name, duration, genreId, userId, albumId";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(songID).append(", ")
                .append("'").append(name).append("'").append(", ")
                .append(duration).append(", ")
                .append(genre.getGenreID()).append(", ")
                .append(user.getUserID()).append(", ")
                .append(album.getAlbumID());

        return sb.toString();
    }

    @Override
    public String getUpdateValues(GenericEntity param) {
        Song song = (Song) param;
        return "name = '" + song.getName() + "', duration = " + song.getDuration() + ", genreId = " + song.getGenre().getGenreID()
                + ", userId = " + song.getUser().getUserID() + ", albumId = " + song.getAlbum().getAlbumID();
    }

    @Override
    public List<GenericEntity> createListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {

            Song song = new Song();
            song.setSongID(rs.getLong("id"));
            song.setName(rs.getString("name"));
            song.setDuration(rs.getDouble("duration"));

            Genre genre = new Genre();
            genre.setGenreID(rs.getLong("genreId"));
            song.setGenre(genre);

            User user = new User();
            user.setUserID(rs.getLong("userId"));
            song.setUser(user);

            Album album = new Album();
            album.setAlbumID(rs.getLong("albumId"));
            song.setAlbum(album);

            list.add(song);
        }
        return list;
    }

    @Override
    public GenericEntity createEntityFromResultSet(ResultSet rs) throws Exception {
        Song song = new Song();

        while (rs.next()) {

            song.setSongID(rs.getLong("id"));
            song.setName(rs.getString("name"));
            song.setDuration(rs.getDouble("duration"));

            Genre genre = new Genre();
            genre.setGenreID(rs.getLong("genreId"));
            song.setGenre(genre);

            User user = new User();
            user.setUserID(rs.getLong("userId"));
            song.setUser(user);

            Album album = new Album();
            album.setAlbumID(rs.getLong("albumId"));
            song.setAlbum(album);

        }
        
        return song;
    }

    @Override
    public String getIdCondition() {
        return "id = " + this.songID;
    }

    @Override
    public String getDeleteCondition() {
        return getIdCondition();
    }
    
    public static String generateAlbumCondition(Album album){
        return "albumId = " + album.getAlbumID();
    }

}
