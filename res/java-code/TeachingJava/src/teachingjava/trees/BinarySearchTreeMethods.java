package teachingjava.trees;

import java.util.HashSet;
import java.util.Set;

public class BinarySearchTreeMethods {

  static <T extends Comparable<T>> T findMax(BinarySearchTree<T> t) {
    if (t.getRight() == null) {
      return t.getRight().getData();
    } else {
      return findMax(t.getRight());
    }
  }

  static <T extends Comparable<T>> Set<T> findElementsBetween(BinarySearchTree<T> t,
                                                              T min,
                                                              T max) {
    Set<T> vals = new HashSet<>();
    findElementsBetweenHelper(t, min, max, vals);
    return vals;
  }

  static <T extends Comparable<T>> void findElementsBetweenHelper(BinarySearchTree<T> t,
                                                                  T min,
                                                                  T max,
                                                                  Set<T> vals) {
    if (t != null) {
      T curr = t.getData();
      // If curr < min, then we cannot proceed left. Search right instead.
      if (curr.compareTo(min) < 0) {
        findElementsBetweenHelper(t.getRight(), min, max, vals);
      }

      // If curr > max, then we cannot proceed right. Search left instead.
      if (curr.compareTo(max) > 0) {
        findElementsBetweenHelper(t.getLeft(), min, max, vals);
      }

      // If curr >= min && curr <= max, add and recurse on both subtrees.
      if (curr.compareTo(min) >= 0 && curr.compareTo(max) <= 0) {
        vals.add(curr);
        findElementsBetweenHelper(t.getLeft(), min, max, vals);
        findElementsBetweenHelper(t.getRight(), min, max, vals);
      }
    }
  }

  static <T extends Comparable<T>> BinarySearchTree<T> inorderSuccessor(BinarySearchTree<T> t) {
    // If the node has a right child, the left-most child of that right child is next.
    if (t.getRight() != null) {
      BinarySearchTree<T> next = t.getRight();
      while (next.getLeft() != null) {
        next = next.getLeft();
      }
      return next;
    } else {
      // If the node doesn't have a right child, then its next is an ancestor.
      // It is the ancestor such that THIS is a left child of it.
      BinarySearchTree<T> next = t;
      while (true) {
        // If we find a right parent, then we're done.
        BinarySearchTree<T> parent = next.getParent();
        if (parent == null || parent.getLeft() == next) {
          return parent;
        } else {
          next = parent;
        }
      }
    }
  }

  static <T extends Comparable<T>> Set<T> findElementsBetweenFast(BinarySearchTree<T> t,
                                                              T min,
                                                              T max) {
    Set<T> vals = new HashSet<>();
    BinarySearchTree<T> next = findNextSmallest(t, min);
    while (next != null && next.getData().compareTo(max) <= 0) {
      if (next.getData().compareTo(min) >= 0 && next.getData().compareTo(max) <= 0) {
        vals.add(next.getData());
      }
      next = inorderSuccessor(next);
    }
    return vals;
  }

  static <T extends Comparable<T>> BinarySearchTree<T> findNextSmallest(BinarySearchTree<T> t, T data) {
    if (t.getData().compareTo(data) == 0) {
      return t;
    } else if (t.getData().compareTo(data) < 0 && t.getRight() != null) {
      return findNextSmallest(t.getRight(), data);
    } else if (t.getData().compareTo(data) > 0 && t.getLeft() != null) {
      return findNextSmallest(t.getLeft(), data);
    } else {
      return t;
    }
  }
}
