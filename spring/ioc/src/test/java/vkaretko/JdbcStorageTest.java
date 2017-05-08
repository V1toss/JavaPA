package vkaretko;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vkaretko.models.User;

import static org.junit.Assert.assertEquals;

/**
 * Class JdbcStorageTest.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 08.05.17 16:28.
 */
public class JdbcStorageTest {

    @Test
    public void whenAddUserThenGetSameUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        JdbcStorage jdbcStorage = context.getBean(JdbcStorage.class);
        UserStorage storage = new UserStorage(jdbcStorage);
        User user = new User();
        user.setName("test");
        storage.add(user);
        assertEquals(storage.get(1), user);
    }
}