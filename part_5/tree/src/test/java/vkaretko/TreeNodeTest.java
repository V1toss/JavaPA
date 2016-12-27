package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class TreeNodeTest for testing class TreeNode.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 26.12.2016.
 */
public class TreeNodeTest {
    /**
     * Tree node for tests.
     */
    private TreeNode tree;
    /**
     * First node for tests.
     */
    private TreeNode nodeOne;
    /**
     * Second node for tests.
     */
    private TreeNode nodeTwo;
    /**
     * Third node for tests.
     */
    private TreeNode nodeThree;

    /**
     * Prepare tree and nodes.
     */
    @Before
    public void prepareTree() {
        tree = new TreeNode();
        nodeOne = new TreeNode();
        nodeTwo = new TreeNode();
        nodeThree = new TreeNode();
    }

    /**
     * Method checks adding nodes to one level.
     */
    @Test
    public void whenAddNodesOnOneLevelThenResultThreeNodesInLine() {
        tree.addChild(nodeOne, "1");
        tree.addChild(nodeTwo, "2");
        tree.addChild(nodeThree, "3");
        assertThat(tree.getChildren().toString(), is("[1, 2, 3]"));
    }

    /**
     * Method checks adding nodes to different levels.
     */
    @Test
    public void whenAddNodesOnDifferentLevelsThenResultThreeNodeFromBottomToTop() {
        tree.addChild(nodeOne, "1");
        nodeOne.addChild(nodeTwo, "2");
        nodeTwo.addChild(nodeThree, "3");
        assertThat(tree.getChildren().toString(), is("[3, 2, 1]"));
    }

    /**
     * Method checks adding nodes to different levels with more nodes.
     */
    @Test
    public void whenAddNineNodesOnDifferentLevelsThenResultNineNodesFromBottomToTop() {
        tree.addChild(nodeOne, "1");
        tree.addChild(new TreeNode(), "1");
        tree.addChild(new TreeNode(), "1");
        nodeOne.addChild(nodeTwo, "2");
        nodeOne.addChild(new TreeNode(), "2");
        nodeOne.addChild(new TreeNode(), "2");
        nodeTwo.addChild(nodeThree, "3");
        nodeTwo.addChild(new TreeNode(), "3");
        nodeTwo.addChild(new TreeNode(), "3");
        assertThat(tree.getChildren().toString(), is("[3, 3, 3, 2, 2, 2, 1, 1, 1]"));
    }

    /**
     * Test for next method.
     */
    @Test
    public void whenAddTwoNodesOnDifferentLevelsThenNextFromBottomLevel() {
        tree.addChild(nodeOne, "1");
        nodeOne.addChild(nodeTwo, "2");
        Iterator iter = tree.iterator();
        assertThat(iter.next(), is("2"));
    }

    /**
     * Test for hasNext method with true result.
     */
    @Test
    public void whenAddTwoNodesThenHasNextTrue() {
        tree.addChild(nodeOne, "1");
        nodeOne.addChild(nodeTwo, "2");
        Iterator iter = tree.iterator();
        assertThat(iter.hasNext(), is(true));
    }

    /**
     * Test for hasNext method with true result.
     */
    @Test
    public void whenAddTwoNodesAndNextTwiceThenHasNextFalse() {
        tree.addChild(nodeOne, "1");
        nodeOne.addChild(nodeTwo, "2");
        Iterator iter = tree.iterator();
        iter.next();
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }

    /**
     * Method checks if tree is balanced with positive result.
     */
    @Test
    public void whenAddTwoChildAndTwoSubChildToEachChildThenBalancedTree() {
        tree.addChild(nodeOne, "1");
        tree.addChild(nodeTwo, "2");
        nodeOne.addChild(new TreeNode(), "3");
        nodeOne.addChild(new TreeNode(), "4");
        nodeTwo.addChild(new TreeNode(), "5");
        nodeTwo.addChild(new TreeNode(), "6");
        assertThat(tree.isBalancedTree(), is(true));
    }

    /**
     * Method checks if tree is balanced with positive result.
     */
    @Test
    public void whenAddTwoChildAndSecondChildHasOnlyOneSubChildThenNotBalancedTree() {
        tree.addChild(nodeOne, "1");
        tree.addChild(nodeTwo, "2");
        nodeOne.addChild(new TreeNode(), "3");
        nodeOne.addChild(new TreeNode(), "4");
        nodeTwo.addChild(new TreeNode(), "6");
        assertThat(tree.isBalancedTree(), is(false));
    }

    /**
     * Method checks searchByValue method.
     */
    @Test
    public void whenSearchTwoThenResultIndexOne() {
        tree.addChild(nodeOne, "1");
        nodeOne.addChild(nodeTwo, "2");
        nodeTwo.addChild(nodeThree, "3");
        assertThat(tree.searchByValue("2"), is(1));
    }

}