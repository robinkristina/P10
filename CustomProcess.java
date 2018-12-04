/**
 * TODO File Header
 */


/**
 * 
 * @author Declan and Robin
 *
 */
public class CustomProcess implements Comparable<CustomProcess> {


  private static int nextProcessId = 1; // stores the id to be assigned to the next process
                                        // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * TODO
   * 
   * @param burstTime
   */
  public CustomProcess(int burstTime) {
    this.burstTime = burstTime; // set instance field burstTime to provided burstTime
    this.PROCESS_ID = nextProcessId; // set the object identifier
    nextProcessId++; // increment nextProcessId;
  }

  /**
   * TODO
   * 
   * @param other
   */
  @Override
  public int compareTo(CustomProcess other) {
    if (this.burstTime < other.burstTime)
      return -1;
    else if (this.burstTime > other.burstTime)
      return 1;
    else if (this.burstTime == other.burstTime) {
      if (this.PROCESS_ID < other.PROCESS_ID)
        return -1;
      else
        return 1;
    } else
      return 0;
  }

  /**
   * Returns the processId of the CustomProcess.
   * @return processId of the CustomProcess.
   */
  public int getProcessId() {
    return this.PROCESS_ID;
  }

  /**
   * Returns the burstTime of the customProcess.
   * @return burstTime of the CustomProcess.
   */
  public int getBurstTime() {
    return this.burstTime;
  }

}
