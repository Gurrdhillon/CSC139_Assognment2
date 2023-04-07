import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class FCFS implements Algorithm {

    ArrayList<Task> queue = null;

    public FCFS(List<Task> queue){ 

        this.queue = (ArrayList<Task>) queue;

    }

    @Override
    public void schedule() {

        while (!queue.isEmpty()) {
            Task task = pickNextTask();
            // task.run();
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'schedule'");
    }

    @Override
    public Task pickNextTask() {
        // return queue.remove();

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickNextTask'");
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