package teachingjava.trees;

/**
 * This interface represents any possible tree data structure that supports insertion and search.
 * @param <T> the type of elements stored in the tree. Whatever type is used must implement Comparable.
 */
interface Tree<T extends Comparable<T>> {

  void insert(T data);

  Tree<T> contains(T data);
}
