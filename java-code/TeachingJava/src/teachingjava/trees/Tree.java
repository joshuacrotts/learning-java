package teachingjava.trees;

public interface Tree<T extends Comparable<T>> {

  void insert(T data);

  Tree<T> contains(T data);
}
