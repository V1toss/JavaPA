package vkaretko;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import vkaretko.interfaces.Storage;
import vkaretko.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class JdbcStorage.
 * Implementation of storage with jdbc datasource.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.05.17 12:57.
 */
public class JdbcStorage implements Storage {

    private final JdbcTemplate template;

    public JdbcStorage(final JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void add(User user) {
        template.update("INSERT INTO users (name) VALUES (?)", user.getName());
    }

    @Override
    public User get(int id) {
        return template.queryForObject("select * from users where id=?", new Object[]{id}, new UserMapper());
    }

    public class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            return user;
        }
    }

}
