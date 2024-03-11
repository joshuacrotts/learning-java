package teachingjava.trees;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTester {

  @Test
  void testBst() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>(5);
    bst.insert(3);
    bst.insert(7);
    bst.insert(2);
    bst.insert(4);
    bst.insert(6);
    bst.insert(8);
    System.out.println(bst);
  }

  @Test
  void testBstBetween() {
    BinarySearchTree<Integer> t1 = new BinarySearchTree<>(5);
    t1.insert(1);
    t1.insert(-10);
    t1.insert(4);
    t1.insert(26);
    t1.insert(14);
    t1.insert(34);
    t1.insert(9);
    t1.insert(17);
    t1.insert(7);
    t1.insert(11);
    t1.insert(15);
    t1.insert(25);
    System.out.println(BinarySearchTreeMethods.findElementsBetween(t1, 13, 25));
  }

  @Test
  void testBstInorder() {
    BinarySearchTree<Integer> t1 = new BinarySearchTree<>(5);
    t1.insert(1);
    t1.insert(-10);
    t1.insert(4);
    t1.insert(26);
    t1.insert(14);
    t1.insert(34);
    t1.insert(9);
    t1.insert(17);
    t1.insert(7);
    t1.insert(11);
    t1.insert(15);
    t1.insert(25);
    System.out.println(BinarySearchTreeMethods.findElementsBetweenFast(t1, 13, 25));
  }
}
