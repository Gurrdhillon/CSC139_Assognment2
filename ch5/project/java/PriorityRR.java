import java.util.List;

public class PriorityRR implements Algorithm {
    

    private List<Task> queue;
    int quantum = 10; //slice time in ms

    public PriorityRR(List<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void schedule() {
        while (!queue.isEmpty()) {
            Task task = pickNextTask();
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

    @Override
    public Task pickNextTask() {
        int priorityIndex = 0;
        /*
         * Search for the index of the Task with shortest burst
         */
        for ( int i = 1; i < queue.size(); i++) {
            if (queue.get(i).getPriority() < queue.get(priorityIndex).getPriority()){
                priorityIndex = i;
            }
        }

        Task process = queue.remove(priorityIndex);
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
