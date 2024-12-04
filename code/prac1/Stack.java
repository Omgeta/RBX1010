public class Stack {
  private int head;
  private Integer[] array;
  private int size;

  public Stack(int size) {
    this.size = size;
    this.head = 0;
    this.array = new Integer[this.size];
  }

  public void push(int x) {
    if (isFull()) {
      System.out.println("Stack is full. Cannot push any values.");
    } else {
      this.array[this.head++] = x;
    }
  }

  public Integer pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot pop any values.");
      return null;
    } else {
      return this.array[--this.head];
    }
  }

  public Integer peek() {
    // or just pop push if lazy
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot peek any values.");
      return null;
    } else {
      Integer res = this.array[--this.head];
      this.head++;
      return res;
    }
  }

  public boolean isFull() {
    return this.size == this.head;
  }

  public boolean isEmpty() {
    return this.head == 0;
  }
}
