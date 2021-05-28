package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();

    String getUpdateValues(GenericEntity param);

    List<GenericEntity> createListFromResultSet(ResultSet rs) throws Exception;

    GenericEntity createEntityFromResultSet(ResultSet rs) throws Exception;

    String getIdCondition();

    String getDeleteCondition();

}
