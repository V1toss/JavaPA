package vkaretko;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class TreeNode.
 * Tree in this implementation is root node.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 26.12.2016.
 * @param <E> parametrized type.
 */
public class TreeNode<E> implements Iterable<E> {
    /**
     * Value of node.
     */
    private E value;

    /**
     * List of children.
     */
    private List<TreeNode<E>> children;

    /**
     * Parent node.
     */
    private TreeNode<E> parent = this;

    /**
     * Constructor of node.
     */
    public TreeNode() {
        this.children = new ArrayList<>();
    }

    /**
     * Get children.
     * @return list of children.
     */
    public List<E> getChildren() {
        List<E> childrenList = new ArrayList<E>();
        childrenList = recursiveFill(this, childrenList);
        return childrenList;
    }

    /**
     * Method fill in list all children in sub-nodes.
     * @param node node to get children.
     * @param list result list.
     * @return list of children.
     */
    private List<E> recursiveFill(TreeNode<E> node, List<E> list) {
        for (TreeNode elNode : node.children) {
            if (elNode.children.size() > 0) {
                recursiveFill(elNode, list);
            }
            list.add((E) elNode.value);
        }
        return list;
    }

    /**
     * Add child to Node.
     * @param node node.
     * @param value value to add.
     */
    public void addChild(TreeNode<E> node, E value) {
        node.parent = this;
        node.value = value;
        this.children.add(node);
    }

    /**
     * Method finds index of element by value.
     * @param value value to search.
     * @return index of element.
     */
    public String searchByValue(E value) {
        return recSearch(this, value, 0);
    }

    /**
     * Recursive search of element;
     * @return message about element found or not founded.
     */
    private String recSearch(TreeNode<E> node, E value, int height) {
        String result = "";
        if (node.value != null && node.value.equals(value)) {
            result = String.format("Element founded on level %s", height);
        } else if (node.children.size() > 0) {
            height++;
            for (TreeNode elNode : node.children) {
                result = recSearch(elNode, value, height);
            }
        } else {
            result = "Element not found";
        }
        return result;
    }

    /**
     * Method checks if tree is balanced
     * @return true if balanced, false otherwise.
     */
    public boolean isBalancedTree() {
        boolean result = true;
        if (isRecBalance(this) == -1) {
            result = false;
        }
        return result;
    }

    /**
     * Method recursively calculates lengths of all branches.
     * @param node node to search
     * @return list of branches length.
     */
    private int isRecBalance(TreeNode<E> node) {
        int result;
        if (node.children.size() == 2) {
            int left = isRecBalance(node.children.get(0));
            int right = isRecBalance(node.children.get(1));
            if (Math.abs(left - right) == 0 && left != -1) {
                result = left + 1;
            } else {
                result = -1;
            }
        } else if (node.children.size() == 0) {
            result = 1;
        } else {
            result = -1;
        }
        return result;
    }

    /**
     * Setter for value of node.
     * @param value value to set.
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * Overrided method, creates new Iterator for TreeNode.
     * @return iterator.
     */
    @Override
    public Iterator iterator() {
        return new TreeIter();
    }

    /**
     * Private class for tree iterator.
     * @param <E>
     */
    private class TreeIter<E> implements Iterator<E> {
        /**
         * Cursor of element.
         */
        private int cursor = 0;
        /**
         * Method check if list has next element.
         * @return true if has next element, false otherwise.
         */
        @Override
        public boolean hasNext() {
            List list = new ArrayList<>();
            list = recursiveFill(parent, list);
            return cursor < list.size();

        }

        /**
         * Method for selection next element in list.
         * @return next element.
         */
        @Override
        public E next() {
            List list = new ArrayList<>();
            list = recursiveFill(parent, list);
            return (E) list.get(cursor++);
        }
    }
}
