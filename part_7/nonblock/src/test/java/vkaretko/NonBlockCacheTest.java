package vkaretko;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Class NonBlockCacheTest.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class NonBlockCacheTest {
    /**
     * Test model.
     */
    private Model testModel;

    /**
     * Non block cache for tests.
     */
    private NonBlockCache nbc;

    /**
     * Prepare cache and model.
     */
    @Before
    public void prepareCacheAndModel() {
        this.testModel = new Model("test");
        this.nbc = new NonBlockCache();
    }

    /**
     * whenAddModelThenModelInCach.
     */
    @Test
    public void whenAddModelThenModelInCache() {
        nbc.add(1, testModel);
        assertThat(nbc.get(1), is(testModel));
    }

    /**
     * whenDeleteModelThenGetNull.
     */
    @Test
    public void whenDeleteModelThenGetNull() {
        nbc.add(1, testModel);
        nbc.delete(1);
        assertNull(nbc.get(1));
    }

    /**
     * whenUpdateModelThenGetUpdatedModel.
     */
    @Test
    public void whenUpdateModelThenGetUpdatedModel() {
        nbc.add(1, testModel);
        Model updateModel = new Model("test2");
        try {
            nbc.update(1, updateModel);
        } catch (OptimisticException e) {
            e.printStackTrace();
        }
        assertThat(nbc.get(1), is(updateModel));
    }

    /**
     * whenUpdateModelThenVersionOne.
     */
    @Test
    public void whenUpdateModelThenVersionOne() {
        nbc.add(1, testModel);
        Model updateModel = new Model("test2");
        try {
            nbc.update(1, updateModel);
        } catch (OptimisticException e) {
            e.printStackTrace();
        }
        assertThat(nbc.get(1).getVersion(), is(1));
    }

}