package teachingjava.trees;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;

/**
 * This class represents a binary search tree.
 * The tree is ordered according to the natural order of the elements or a custom comparator.
 * The tree does not allow duplicate elements.
 * @param <T> the type of elements stored in the tree. Whatever type is used must implement Comparable.
 */
class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

  /**
   * Data associated with this node.
   */
  private final T DATA;

  /**
   * Comparator instance used to order the elements.
   * If no comparator is passed, the natural order of the elements is used.
   */
  private final Comparator<T> COMPARATOR;

  /**
   * Left child of this node, or null if it doesn't exist.
   */
  private BinarySearchTree<T> left;

  /**
   * Right child of this node, or null if it doesn't exist.
   */
  private BinarySearchTree<T> right;

  /**
   * Parent of this node.
   */
  private BinarySearchTree<T> parent;

  BinarySearchTree(@NotNull T data) {
    this(data, Comparator.naturalOrder());
  }

  BinarySearchTree(@NotNull T data, @NotNull Comparator<T> comparator) {
    this.DATA = data;
    this.COMPARATOR = comparator;
    this.left = this.right = this.parent = null;
  }


  /**
   * Inserts a new element into this binary search tree.
   * The element cannot be null nor can it be a duplicate of an existing element.
   * - If the element is less than the current node, it is inserted into the left subtree.
   * - If the element is greater than the current node, it is inserted into the right subtree.
   * @param data the element to insert.
   */
  @Override
  public void insert(@NotNull T data) {
    if (this.COMPARATOR.compare(data, this.DATA) < 0) {
      if (this.left == null) {
        this.left = new BinarySearchTree<>(data, this.COMPARATOR);
        this.left.parent = this;
      } else {
        this.left.insert(data);
      }
    } else {
      if (this.right == null) {
        this.right = new BinarySearchTree<>(data, this.COMPARATOR);
        this.right.parent = this;
      } else {
        this.right.insert(data);
      }
    }
  }

  @Override
  public @Nullable Tree<T> contains(@NotNull T data) {
    if (this.COMPARATOR.compare(data, this.DATA) == 0) {
      return this;
    } else if (this.COMPARATOR.compare(data, this.DATA) < 0) {
      return this.left == null ? null : this.left.contains(data);
    } else {
      return this.right == null ? null : this.right.contains(data);
    }
  }

  @Override
  public String toString() {
    // Return an in-order traversal of the tree.
    return (this.left == null ? "" : this.left + ", ")
            + this.DATA
            + (this.right == null ? "" : ", " + this.right);
  }

  T getData() {
    return this.DATA;
  }

  BinarySearchTree<T> getLeft() {
    return this.left;
  }

  BinarySearchTree<T> getRight() {
    return this.right;
  }

  BinarySearchTree<T> getParent() {
    return this.parent;
  }

  boolean isLeaf() {
    return this.left == null && this.right == null;
  }

  boolean isRoot() {
    return this.parent == null;
  }
}
