package teachingjava.trees;

import java.util.Comparator;

class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

  private BinarySearchTree<T> left;
  private BinarySearchTree<T> right;
  private BinarySearchTree<T> parent;
  private T data;

  private Comparator<T> comparator;

  BinarySearchTree(T data) {
    this(data, Comparator.naturalOrder());
  }

  BinarySearchTree(T data, Comparator<T> comparator) {
    this.data = data;
    this.comparator = comparator;
    this.left = this.right = this.parent = null;
  }

  T getData() {
    return this.data;
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

  @Override
  public void insert(T data) {
    if (this.comparator.compare(data, this.data) < 0) {
      if (this.left == null) {
        this.left = new BinarySearchTree<>(data, this.comparator);
        this.left.parent = this;
      } else {
        this.left.insert(data);
      }
    } else {
      if (this.right == null) {
        this.right = new BinarySearchTree<>(data, this.comparator);
        this.right.parent = this;
      } else {
        this.right.insert(data);
      }
    }
  }

  @Override
  public Tree<T> contains(T data) {
    if (this.comparator.compare(data, this.data) == 0) {
      return this;
    } else if (this.comparator.compare(data, this.data) < 0) {
      return this.left == null ? null : this.left.contains(data);
    } else {
      return this.right == null ? null : this.right.contains(data);
    }
  }

  @Override
  public String toString() {
    // Return an in-order traversal of the tree.
    return (this.left == null ? "" : this.left.toString() + ", ") + this.data + (this.right == null ? "" : ", " + this.right.toString());
  }
}
