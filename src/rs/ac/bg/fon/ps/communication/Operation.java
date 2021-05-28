package rs.ac.bg.fon.ps.communication;

public enum Operation {
    LOG_IN,
    RETURN_ALL_USERS,
    RETURN_ALL_PERFORMERS, // Singer / Band
    RETURN_ALL_COUNTRIES,
    RETURN_ALL_GENRES,
    RETURN_ALL_ALBUMS,
    DELETE_PERFORMER,
    DELETE_ALBUM,
    ADD_PERFORMER,
    ADD_ALBUM,
    SEARCH_PERFORMERS,
    SEARCH_ALBUMS, 
    UPDATE_ALBUM,
    RETURN_PERFORMER,
    RETURN_ALBUM
}
