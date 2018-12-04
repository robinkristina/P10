/**
 * TODO File Header
 */

/**
 * TODO Class Description
 * 
 * @author Robin and Declan
 *
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
  
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue

  /**
   * No argument constructor creates an empty CustomProcessQueue
   */
  public CustomProcessQueue() {
    size = 0;
    heap = new CustomProcess[INITIAL_CAPACITY];
  }
  
  @Override
  public void enqueue(CustomProcess newObject) {
    
    // check if heap array is full
    if (heap[heap.length -1] != null) { // array is full
      // new array with twice the length of the current heap array
      CustomProcess[] biggerHeap = new CustomProcess[heap.length * 2]; 
      for (int i = 0; i < heap.length; ++i) { // copy contents of heap into biggerHeap
        biggerHeap[i] = heap[i];
      }
      heap = biggerHeap; // set heap reference to the bigger array (biggerHeap)
    }
    
    heap[0] = newObject;
//    if (heap[0].compareTo(heap))
    
    
  }

  @Override
  public CustomProcess dequeue() {
    CustomProcess top;
    
    if (size == 0)
      return null;
    
    top = heap[1];
    heap[1] = heap[size];
    
    int currNodeIndex = 1;
    int smallestLeafIndex;
    
    while (true) { // leftNode = currNode * 2 // rightNode = currNode*2 + 1
      
      if ((heap[currNodeIndex * 2] == null) && (heap[currNodeIndex * 2 + 1] == null))
        break;
      else if (heap[currNodeIndex * 2 + 1] == null)
        smallestLeafIndex = currNodeIndex * 2 + 1;
      else {
        if ((heap[currNodeIndex * 2].compareTo(heap[currNodeIndex * 2 + 1]) < 0))
          smallestLeafIndex = currNodeIndex * 2;
        else
          smallestLeafIndex = currNodeIndex * 2 + 1;
      }
      
      if (heap[currNodeIndex].compareTo(heap[smallestLeafIndex]) > 0)
        minHeapPercolateUp(smallestLeafIndex);
      else 
        break;
      currNodeIndex = smallestLeafIndex;
    }
    
    return top;
  }

  @Override
  public CustomProcess peek() {
    if (size == 0)
      return null;
    return heap[1];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return (size == 0);
  }
  
  private void minHeapPercolateUp(int index) {
    CustomProcess temp = heap[index / 2];
    heap[index / 2] = heap[index];
    heap[index] = temp;
  }
  private void minHeapPercolateDown(int index) {
    CustomProcess temp = heap[index - 1];
    heap[index + 1] = heap[index];
    heap[index] = temp;
  }
  
  
  
}
