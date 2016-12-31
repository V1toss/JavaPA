package vkaretko;

/**
 * Class TreeNodeBinary.
 * Search binary tree version.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 30.12.2016.
 * @param <E> parametrized type.
 */
public class TreeNodeBinary<E extends Comparable<E>> {
    /**
     * Value of node.
     */
    private E value;

    /**
     * Left child.
     */
    private TreeNodeBinary<E> left;

    /**
     * Right child.
     */
    private TreeNodeBinary<E> right;

    /**
     * Constructor of node.
     * @param value value of node.
     */
    public TreeNodeBinary(E value) {
        this.value = value;
    }

    /**
     * Method automatically add elements to the tree.
     * @param value value to add.
     */
    public void insert(E value) {
        TreeNodeBinary<E> parent;
        TreeNodeBinary<E> current = this;
        while (true) {
            parent = current;
            if (current.value.compareTo(value) > 0) {
                current = current.left;
                if (current == null) {
                    parent.left = new TreeNodeBinary<E>(value);
                    break;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = new TreeNodeBinary<E>(value);
                    break;
                }
            }
        }
    }

    /**
     * Search through binary tree.
     * Update fot search binary tree.
     * @param value value to search.
     * @return message about found element or not.
     */
    public String searchByValue(E value) {
        TreeNodeBinary<E> current = this;
        String result = "Element is not found";
        while (current != null) {
            if (current.value == value) {
                result = "Element is found";
                break;
            } else if (current.value.compareTo(value) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return result;
    }
}
