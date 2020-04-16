import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class myBinarySearchTreeTester {
  // This test case tests the insert method and the constructor that takes in an integer value.
  // This test is important because both this method and the constructor are necessary for the rest of the methods to work.
  // The test case consists of a root, 5, which was chosen randomly.
  // The values being inserted were chosen in order to create multiple branches, each of different length.
  // In order to create this, multiple values greater than 5 and lower than 5 were chosen to be inserted.
  // They are not inserted in order from largest to smallest or vice versa in order to make sure that multiple branches are being created.
  // This makes sure that the values are being placed in the tree as expected.
  // In addition, a repeating value, 8, and a negative value, -3, were included.
  // These values were included in order to test if the method can handle negative values and if it will avoid adding a node for 8.
  // This test passed, so the insertion method and the constructor both function as expected.
  // Apart from making sure the method added the specified values, there are also additional assertions that make sure there are nodes apart from the ones expected in the tree.
  // This was handles through multiple assert null checks, which all passed.
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

  // This test case tests the constructor that takes in an array.
  // This test is important because the constructor provides the easiest way to create a tree in the class, so it is essential to make sure that it behaves as expected.
  // The array sent as an argument to the method was chosen to create a tree with multiple branches.
  // The order of the integers was chosen so that the values greater and less than the root are mixed up.
  // This was to make sure that each value is being compared correctly.
  // This test did not pass the first time it was run.
  // The test did not pass due to an error in the constructor.
  // The constructor was creating another instance of the class with just the root value and using that to create a new tree.
  // In order to fix this error, I initialized myValue to the root since that is the current node.
  // This fixed the error and this test was able to pass.
  // Additional null assertions are included at the end in order to make sure that no additional nodes were created.
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

  // This test case tests that the insert method is successful when it is used with an already created tree.
  // The array used to create this tree consists of increasing values in order to make sure that only one branch is created.
  // The chosen value to insert falls in the middle of these increasing values in order to make sure that it is being placed in the correct spot.
  // An expected instance was created in order to compare it to the array with the insertion.
  // The array used to create this second tree contains the inserted value at the end in order to avoid it being placed along the same branch.
  // When comparing the values from both of the trees, they were always equal, so the insertion was successful.
  // Additional null assertions are included at the end in order to make sure that no additional nodes were created.
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

  // This test case tests the height method.
  // The array being used to create the tree was chosen in order to create a tree with multiple branches.
  // This was essential in order to make sure that the length of each subtree was being compared correctly.
  // With the array being used, there are cases in the tree where the lengths are equal and unequal, which helps check both of them in one test case.
  // The expected height should be 4, which at the end should be compared with the height of the left branch, which should be 3.
  // This test case did not pass the first time since it was returning a greater integer value than expected.
  // This was because before returning the length of the greatest subtree, there was an additional 1 being added.
  // Since the method is recursive, this 1 was adding each time after a comparison was made, which resulted in a greater integer value being returned than expected.
  // In order to fix this, I removed the added 1 from the comparison.
  // This change allowed for the height to be computed correctly and for the test to pass.
  @Test
  public void testFour(){
    int[] A = {20, 15, 35, 12, 17, 23, 43, 11, 14, 18, 26, 24};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);
    assertEquals(4, treeRoot.height());
  }

  // This test case tests the depth method.
  // The chosen array makes sure that the tree created has multiple branches.
  // This was done by creating a root with the value 5 and including values less than and greater than 5 afterwards.
  // The order of the numbers was chosen to make sure that the left and right branches have more branches as well and are not a singular branch.
  // This was done in order to make sure that a value less than and greater than could be used in comparison on each level if necessary.
  // The chosen value to search is found in the middle of the tree between a previous node and a leaf.
  // This makes sure that the depth is checking for equality of the value and not just returning the height of the tree.
  // This test was successful, so the depth method is able to find the depth of a specific node.
  @Test
  public void testFive(){
    int[] A = {15, 12, 20, 14, 13, 19, 21};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);
    assertEquals(2, treeRoot.depth(14));
  }

  // This test case tests the depth method.
  // The chosen array contains a first value of 50 to use as the root and additional values greater and less than 50.
  // This was done in order to create multiple branches for the method to search through.
  // The chosen value to search is not found in the tree.
  // This was done in order to make sure that a value of -1 will be returned if it is not present.
  // The value of -1 does a good job because the smallest possible depth is 0, so if a negative value is returned, then it is a clear indicator that it was not found.
  // This test did not pass at first because values greater than 1 were being returned.
  // This was because due to the recursive nature of the method, the negative value was being added to a 1 when it was being returned.
  // In order to fix this, I added an additional condition before the value was added to a 1 that checks whether or not the next call returns a -1.
  // This fixed the error and the test case was able to pass.
  @Test
  public void testSix(){
    int[] A = {50, 12, 93, 3, 49, 87, 102, 70, 32, 89};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);
    assertEquals(-1, treeRoot.depth(86));
  }

  // This test case tests the method size.
  // The array used to create the tree was chosen to have multiple branches.
  // Each branch was made sure to be a different length in order to make sure that each node is being counted.
  // This makes sure that the sum is being accumulated correctly in the left and right branches.
  // The assertion made uses the length of the array as the expected value since the size should be equal to the amount of nodes present.
  // This test case was successful and passed on its first try, so the method size is able to correctly count the number of nodes in a binary search tree.
  @Test
  public void testSeven(){
    int[] A = {10, 2, 12, 1, 8, -3, 4, 9, -4, -5, -6, 3, 7};
    myBinarySearchTreeNode treeRoot = new myBinarySearchTreeNode(A);
    assertEquals(A.length, treeRoot.size());
  }
}
