
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class FCFS implements Algorithm {

    //Using LinkedList over ArrayList as time complexity of removing an 
    //element from linkedlist is only O(1) and for arraylist it is O(n)
    LinkedList<Task> queue = null;
    public FCFS(List<Task> queue){ 

        this.queue = new LinkedList<Task>();
        this.queue.addAll(queue);

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
        //It does make sense that I will have to pick next task
        //and picking next task is very easy in FCFS, as we will just pick the 
        //the very next task in the queue

        return queue.remove(0);
    }

}



// private Queue<Task> queue;

// public FCFS() {
//     queue = new LinkedList<Task>();
// }

// /**
//  * Adds a task to the queue
//  */
// public void addTask(Task task) {
//     queue.add(task);
// }

// /**
//  * Invokes the scheduler
//  */
// public void schedule() {
//     while (!queue.isEmpty()) {
//         Task task = pickNextTask();
//         task.run();
//     }
// }

// /**
//  * Selects the next task using the FCFS scheduling algorithm
//  */
// public Task pickNextTask() {
//     return queue.remove();
// }