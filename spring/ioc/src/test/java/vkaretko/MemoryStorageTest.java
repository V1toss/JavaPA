package vkaretko;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vkaretko.models.User;

import static org.junit.Assert.assertEquals;

/**
 * Class MemoryStorageTest.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.05.17 12:58.
 */
public class MemoryStorageTest {

    @Test
    public void whenLoadContextShouldGetBeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        User user = new User();
        user.setId(0);
        user.setName("test");
        storage.add(user);
        assertEquals(storage.get(0), user);
    }
}