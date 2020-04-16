import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class myBinarySearchTreeTester {
//  Test your class by creating at least *5 test cases using JUnit.
//  For this you will create a new file called myBinarySearchTreeTester.java.
//  You are expected to describe and justify each test case in a comment right before in the code.

  // Tests insert and the first constructor
  // tests for duplicate
  // multiple numbers to test if they will be placed in the right spot
  // negative number also used
  // check that the tree is null in the leaves as well as places where there is no right/left
  @Test
  public void testOne(){
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(5);

    treeRoot.insert(2);
    treeRoot.insert(12);
    treeRoot.insert(1);
    treeRoot.insert(-3);
    treeRoot.insert(8);
    treeRoot.insert(9);
    treeRoot.insert(8);
    treeRoot.insert(3);
    treeRoot.insert(7);

    assertEquals(5, treeRoot.myValue);
    assertEquals(2, treeRoot.left.myValue);
    assertEquals(12, treeRoot.right.myValue);
    assertEquals(1, treeRoot.left.left.myValue);
    assertEquals(3, treeRoot.left.right.myValue);
    assertEquals(8, treeRoot.right.left.myValue);
    assertEquals(-3, treeRoot.left.left.left.myValue);
    assertEquals(7, treeRoot.right.left.left.myValue);
    assertEquals(9, treeRoot.right.left.right.myValue);

    assertNull(treeRoot.left.left.left.left);
    assertNull(treeRoot.left.left.left.right);
    assertNull(treeRoot.left.left.right);
    assertNull(treeRoot.left.right.left);
    assertNull(treeRoot.left.right.right);
    assertNull(treeRoot.right.left.left.left);
    assertNull(treeRoot.right.left.left.right);
    assertNull(treeRoot.right.left.right.left);
    assertNull(treeRoot.right.left.right.right);
    assertNull(treeRoot.right.right);
  }

  // tests the constructor with array
  // This one did not work at first because i was declaring an instance of the root within the root
  // only have leaved. all have either 0/2 kids
  @Test
  public void testTwo(){
    int[] A = {10, 3, 12, 5, 15, 1, 4, 11, 9};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);

    assertEquals(A[0],treeRoot.myValue);
    assertEquals(A[1],treeRoot.left.myValue);
    assertEquals(A[2],treeRoot.right.myValue);
    assertEquals(A[3],treeRoot.left.right.myValue);
    assertEquals(A[4],treeRoot.right.right.myValue);
    assertEquals(A[5],treeRoot.left.left.myValue);
    assertEquals(A[6],treeRoot.left.right.left.myValue);
    assertEquals(A[7],treeRoot.right.left.myValue);
    assertEquals(A[8],treeRoot.left.right.right.myValue);

    assertNull(treeRoot.left.left.left);
    assertNull(treeRoot.left.left.right);
    assertNull(treeRoot.left.right.left.left);
    assertNull(treeRoot.left.right.left.right);
    assertNull(treeRoot.left.right.right.left);
    assertNull(treeRoot.left.right.right.right);
    assertNull(treeRoot.right.left.left);
    assertNull(treeRoot.right.left.right);
    assertNull(treeRoot.right.right.left);
    assertNull(treeRoot.right.right.right);
  }

  // creates a tree with the array
  // Tests insert on a tree that has already been created
  // also creates a tree that only has one branch to see if values are being placed where they should and not just alternating.
  // the value inserted does not continue this pattern to see if it can insert it properly in the tree.
  @Test
  public void testThree(){
    int[] A = {10, 11, 13, 14, 15, 17};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);
    treeRoot.insert(12);

    int[] expectedArray = {10, 11, 13, 14, 15, 17, 12};
    myBinarySearchTreeNode expectedRoot = new myBinarySearchTreeNode(expectedArray);

    assertEquals(expectedRoot.myValue, treeRoot.myValue);
    assertEquals(expectedRoot.right.myValue, treeRoot.right.myValue);
    assertEquals(expectedRoot.right.right.myValue, treeRoot.right.right.myValue);
    assertEquals(expectedRoot.right.right.left.myValue, treeRoot.right.right.left.myValue);
    assertEquals(expectedRoot.right.right.right.myValue, treeRoot.right.right.right.myValue);
    assertEquals(expectedRoot.right.right.right.right.myValue, treeRoot.right.right.right.right.myValue);
    assertEquals(expectedRoot.right.right.right.right.right.myValue, treeRoot.right.right.right.right.right.myValue);

    assertNull(treeRoot.left);
    assertNull(treeRoot.right.left);
    assertNull(treeRoot.right.right.left.left);
    assertNull(treeRoot.right.right.left.right);
    assertNull(treeRoot.right.right.right.left);
    assertNull(treeRoot.right.right.right.right.left);
    assertNull(treeRoot.right.right.right.right.right.left);
    assertNull(treeRoot.right.right.right.right.right.right);
  }

  // Tests height
  // didn't work at first since I was adding an extra 1 when I returned the sum
  // Since it's recursive nad there are many branches, this 1 keps on adding up each time a comparison of branches was made
  // multiple branches to make sure that they are being compared.
  //
  @Test
  public void testFour(){
    int[] A = {20, 15, 35, 12, 17, 23, 43, 11, 14, 18, 26, 24};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);
    assertEquals(4, treeRoot.height());
  }

  // Tests depth
  // when the value is in the tree
  // chose a value that was in the middle of the tree. not a leaf.
  @Test
  public void testFive(){
    int[] A = {15, 12, 20, 14, 13, 19, 21};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);
    assertEquals(2, treeRoot.depth(14));
  }

  // Tests depth
  // when the value is not in the tree
  // This didnt work at first because the values were adding up and not returning -1.
  @Test
  public void testSix(){
    int[] A = {50, 12, 93, 3, 49, 87, 102, 70, 32, 89};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);
    assertEquals(-1, treeRoot.depth(86));
  }

  // Tests size
  // multiple brancehs all of different lengths to see if the sum is being accumilated cofrectly
  @Test
  public void testSeven(){
    int[] A = {10, 2, 12, 1, 8, -3, 4, 9, -4, -5, -6, 3, 7};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);
    assertEquals(A.length, treeRoot.size());
  }
}
