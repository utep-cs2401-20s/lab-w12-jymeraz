import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class myBinarySearchTreeTester {
  @Test
  public void testOne(){
    int[] a = {5, 2, 8, 9, 4, 3};
    myBinarySearchTreeNode tree = new myBinarySearchTreeNode(5);
    tree.insert(2);
    tree.insert(12);
    tree.insert(1);
    tree.insert(-3);
    tree.insert(8);
    tree.insert(9);
    tree.insert(4);
    tree.insert(3);
    tree.insert(7);
    tree.print();
    System.out.println("size: " + tree.size());
    System.out.println("depth of 20: " + tree.depth(-20));
    System.out.println("height: " + tree.height());
  }

  @Test
  public void testTwo(){
    int[] a = {5, 2, 8, 9, 4, 3};
    myBinarySearchTreeNode tree = new myBinarySearchTreeNode(a);
    tree.print();
  }

  @Test
  public void testThree(){
    int[] a = {5, 2, 8, 9, 4, 3};
    myBinarySearchTreeNode tree = new myBinarySearchTreeNode(5);
    tree.insert(2);
    tree.insert(12);
    tree.insert(1);
    tree.insert(-3);
    tree.insert(8);
    tree.insert(9);
    tree.insert(4);
    tree.insert(3);
    tree.insert(7);
    tree.print();
    System.out.println("height: " + tree.height());
  }
}
