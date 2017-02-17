package vkaretko;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class RevertLinkedListTest.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 11.01.2017.
 */
public class RevertLinkedListTest {
    /**
     * Test revertint of linked list.
     */
    @Test
    public void whenRevertListThenLinkedListBackwardDirection() {
        RevertLinkedList list = new RevertLinkedList();
        list.add(0);
        list.add(2);
        list.add(1);

        list.reverse();

        Iterator iter = list.iterator();
        assertThat(String.format("%s,%s,%s", iter.next(), iter.next(), iter.next()), is("1,2,0"));
    }
}