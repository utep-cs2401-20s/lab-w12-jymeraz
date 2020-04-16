class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;

  /**
   * This constructor is used to create a single tree node.
   * The left and right nodes are left null.
   * @param inValue
   */
  myBinarySearchTreeNode(int inValue){
    // Create a new node with null left and right pointers.
    myValue = inValue;
  }

  /**
   * This constructor is used to create a binary search tree from an array.
   * The first element in the array is saved to the root.
   * The following elements of the array are inserted to the root to create the tree.
   * @param A
   */
  myBinarySearchTreeNode(int[] A){
    // Create the root of the tree using the first element of the array.
    myValue = A[0];

    // Insert the rest of the values in the array to the tree.
    for(int i = 1; i < A.length; i++){
      insert(A[i]);
    }
  }

  /**
   * This method inserts a node in its correct place in the tree.
   * A new node is created in the right if it is greater and in the left if it is less than the current node when there is no node there.
   * If a node already exists with that value, a new node is not created.
   * @param inValue
   */
  public void insert(int inValue){
    // Check if the value is greater than, less than, or equal to the current integer in myValue.
    if(inValue > myValue){
      // Create a new node if the right node is null.
      if(right == null){
        right = new myBinarySearchTreeNode(inValue);
      } else {
        // Recursively traverse the array if the right node was not null.
        right.insert(inValue);
      }
    } else if (inValue < myValue){
      // Create a new node if the left node is null.
      if(left == null){
        left = new myBinarySearchTreeNode(inValue);
      } else {
        // Recursively traverse the array if the left node was not null.
        left.insert(inValue);
      }
    } else {
      // Print out an error statement if there was a duplicate.
      System.out.println("Error. Duplicates not allowed");
    }
  }

  /**
   * This method returns the longest path from the root to a leaf.
   * @return
   */
  public int height(){
    // Initialize the left and right heights to zero.
    int leftHeight = 0;
    int rightHeight = 0;

    if(left != null){
      // Sum up the number of edges in the left subtree.
      leftHeight = left.height() + 1;
    }
    if(right != null){
      // Sum up the number of edges in the right subtree.
      rightHeight = right.height() + 1;
    }

    // Return the height of the largest subtree.
    return Math.max(leftHeight, rightHeight);
  }

  /**
   * This method returns the number of edges between the root to a specific value.
   * A value of -1 is returned if the value is not found.
   * @param search
   * @return
   */
  public int depth(int search){
    // Check if the value is greater than, less than, or equal to the current integer in myValue.
    if(search > myValue){
      // Recursively traverse the binary search tree if the right node is not null.
      if(right != null){
        // If the value is not in the tree, return -1.
        if(right.depth(search) == -1){
          return -1;
        } else {
          // Sum up the number of edges it takes to get to the value.
          return right.depth(search) + 1;
        }
      } else {
        // If the value is not in the tree, return -1.
        return -1;
      }
    } else if(search < myValue){
      // Recursively traverse the binary search tree if the left node is not null.
      if(left != null){
        // If the value is not in the tree, return -1.
        if(left.depth(search) == -1){
          return -1;
        } else {
          // Sum up the number of edges it takes to get to the value.
          return left.depth(search) + 1;
        }
      } else {
        // If the value is not in the tree, return -1.
        return -1;
      }
    } else {
      // If the value was found, return 0.
      return 0;
    }
  }

  /**
   * This method returns the number of nodes in the tree through a full tree traversal.
   * @return
   */
  public int size(){
    // Initialize sum to 1 to include the root.
    int sum = 1;
    // Sum up the number of nodes on the left subtree.
    if(left != null){
      sum += left.size();
    }
    // Sum up the number of nodes on the right subtree.
    if(right != null){
      sum += right.size();
    }
    // Return the total number of nodes.
    return sum;
  }
  
  // Utility function included to debug the solution.
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
} 
