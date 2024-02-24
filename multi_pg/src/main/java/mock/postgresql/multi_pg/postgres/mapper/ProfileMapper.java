package mock.postgresql.multi_pg.postgres.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import mock.postgresql.multi_pg.postgres.model.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProfileMapper implements RowMapper<Profile> {

    @Override
    public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Profile(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("age")
        );
    }
}
