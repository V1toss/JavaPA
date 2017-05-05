package vkaretko.dao;

import org.junit.Test;
import vkaretko.models.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vitoss on 05.05.17.
 */
public class EngineDAOTest {

    @Test
    public void testAdd() {
        Engine engine = new Engine();
        engine.setName("test");
        EngineDAO.getInstance().save(engine);
        List<Engine> list = EngineDAO.getInstance().getAll();
        assertEquals(list.get(0).getName(),"test");
    }

    @Test
    public void testUpdate() {
        Engine engine = new Engine();
        engine.setName("test");
        EngineDAO.getInstance().save(engine);

        engine.setName("testUpdate");
        EngineDAO.getInstance().update(engine);
        List<Engine> list = EngineDAO.getInstance().getAll();

        assertEquals(list.get(0).getName(),"testUpdate");
    }

}