package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PerformerSong implements GenericEntity {

    private Performer performer;
    private Song song;

    public PerformerSong() {
    }

    public PerformerSong(Performer performer, Song song) {
        this.performer = performer;
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    @Override
    public String getTableName() {
        return "performer_song";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "PerformerID, SongID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(performer.getPerformerID()).append(", ")
                .append(song.getSongID());

        return sb.toString();
    }

    @Override
    public List<GenericEntity> createListFromResultSet(ResultSet rs) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        while (rs.next()) {

            PerformerSong performerSong = new PerformerSong();
            Performer p = new Performer();
            Song s = new Song();

            p.setPerformerID(rs.getLong("PerformerID"));
            s.setSongID(rs.getLong("SongID"));

            performerSong.setPerformer(p);
            performerSong.setSong(s);
            list.add(performerSong);
        }
        return list;
    }

    @Override
    public GenericEntity createEntityFromResultSet(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateValues(GenericEntity param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteCondition() {
        return "SongID = " + song.getSongID() + " AND PerformerID = " + performer.getPerformerID();
    }

    public static String generateSongCondition(Song song) {
        return "SongID = " + song.getSongID();
    }

}
