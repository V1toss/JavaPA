package vkaretko;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class TreeNodeBinaryTest for testing class TreeNodeBinary.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 31.12.2016.
 */
public class TreeNodeBinaryTest {
    /**
     * Tree for tests.
     */
    private TreeNodeBinary tree;

    /**
     * Prepare tree.
     */
    @Before
    public void prepareTree() {
        tree = new TreeNodeBinary(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
    }
    /**
     * Method test search through binary tree with positive result.
     */
    @Test
    public void whenThen() {
        assertThat(tree.searchByValue(3), is("Element is found"));
    }

    /**
     * Method test search through binary tree with negative result.
     */
    @Test
    public void whenThenElementNotFounded() {
        assertThat(tree.searchByValue(5), is("Element is not found"));
    }


}