import java.util.LinkedList;
import java.util.List;

public class RR implements Algorithm {

    private LinkedList<Task> queue;
    int quantum = 10; //slice time in ms

    public RR(List<Task> queue) {
        this.queue = new LinkedList<Task>();
        this.queue.addAll(queue);
    }

    @Override
    public void schedule() {
        while (!queue.isEmpty()) {

            /*
             * If: task was acquired in given time slice, pass it on to CPU.run
             * else: let the schedule run again
             */

            Task task = pickNextTask();

            if (task != null) {
                /*
                * The schedule() method obtains the next task to be run on the CPU 
                * by invok- ing the pickNextTask() method and then executes this 
                * Task by calling the static run() method in the CPU.java class.
                */
                CPU.run(task, 0);
                //Printing the task just to see if it worked well
                System.out.println(task.toString());
            }
        }
    }

    /*
     * Remove the very first task, if if its burst is less than quantum, then return processs
     * else: update the burst Time by subtracting it from the quantum and add the task back to queue
     */
    @Override
    public Task pickNextTask() {

        Task process = queue.remove(0);
        int b = quantum - process.getBurst();   //quantum - burstTime

        if (b <= 0) {
            return process;
        } else {
            process.setBurst(b);
            queue.add(process);
            return null;
        }
    }
}
