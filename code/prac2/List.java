// This implementation is closer to the CS1101S implementation
public class List {
  private int data;
  private List tail;

  // Constructor
  public List(int data) {
    this.data = data;
    this.tail = null;
  }

  // Add an element with value x to the end
  public void append(int x) {
    List curr = this;
    while (curr.tail != null) {
      curr = curr.tail;
    }
    curr.tail = new List(x);
  }

  // Pop the last node and return the value
  public int pop() {
    if (this.tail == null) {
      return this.data;
    }

    List curr = this;
    while (curr.tail != null && curr.tail.tail != null) {
      curr = curr.tail; 
    }
    int res = curr.tail.data;
    curr.tail = null;
    return res;
  }

  // Get the List at index i
  public List get(int i) {
    List curr = this;
    int j = 0;

    while (j < i && curr.tail != null) {
        curr = curr.tail;
        j++;
    }

    if (j == i) {
        return curr;
    }
    return null;
  }

  // Remove the List at index i
  public List remove(int i) {
    List prev = null;
    List curr = this;
    int j = 0;

    while (j < i && curr.tail != null) {
      prev = curr;
      curr = curr.tail;
      j++;
    }

    if (j == i) {
      // for non-head, we stitch the prev to the next tail
      // for head removal edge case (undefined by qn),
      // i choose to cut off the remaining list and let GC clean it up
      if (prev != null) {
        prev.tail = curr.tail;
      }
      curr.tail = null;
      return curr;
    }
    return null;
  }

  // Get the length of the list
  public int length() {
    int i = 1;
    // you can use for loops like this too, but rest of the code
    // uses while loops for clarity
    for (List curr = this.tail; curr != null; curr = curr.tail, i++);
    return i;
  }

  // Helper function
  public void print() {
    List curr = this;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.tail;
    }
    System.out.print("\n");
  }
}
