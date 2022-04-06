package Week1;

import Week1.Queue;

import java.util.ArrayList;

/**
 * Queue Manager
 * 1. "has a" Queue
 * 2. support management of Queue tasks (aka: titling, adding a list, printing)
 */
public class QueueManager<T> {
    // queue data
    private String name; // name of queue
    private int count = 0; // number of objects in queue
    public final Queue<T> queue = new Queue<>(); // queue object
    private int size;
    private static int qCount = 0;

    /**
     * Queue constructor
     * Title with empty queue
     */
    public QueueManager(String name) {
        this.name = name;
    }

    /**
     * Queue constructor
     * Title with series of Arrays of Objects
     */
    public QueueManager(String name, T[]... seriesOfObjects) {
        this.name = name;
        this.addList(seriesOfObjects);

    }


    public QueueManager(T[]... seriesOfObjects) {
        this.addListC(seriesOfObjects);
        qCount++;

        // make custom add lisst without printing
    }

    //getting numbers for the sort
    public int getNumbers() {
        String numbers = "";

        for (T data : queue) {
            numbers += data + " ";


        }
        System.out.println("Before: " + numbers);
        return Integer.valueOf(numbers.replaceAll(" ", ""));
    }

    //get the size of the queue
    public int size() {
        int iter = 0;
        for (T data : queue) {
            iter++;
        }
        return iter;
    }

    //get which queue# the queue is at rn
    public void getQueue() {
        if (qCount == 1) {
            System.out.print("(1st Queue) ");
        } else if (qCount == 2) {
            System.out.print("(2nd Queue) ");
        }

        for (T data : queue) {
            System.out.print(data + " -> ");
        }
        if (qCount <= 2) {
            System.out.print("nil");
        }
        System.out.println("");
    }

    public void sort(QueueManager seriesOfObjects) {
//        Object[] empty = new String[] {};
//        QueueManager emptyQ = new QueueManager(empty);
        T previous = null;
        T current = null;
        ArrayList<Integer> emptyAL = new ArrayList<Integer>();
        for (T data : queue) {
            emptyAL.add(Integer.valueOf((String) data));
        }
        for (Object data : seriesOfObjects.queue) {
            emptyAL.add(Integer.valueOf((String) data));
        }
        int n = emptyAL.size();
        for (int i = 1; i < n; ++i) {
            int key = emptyAL.get(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && emptyAL.get(j) > key) {
                emptyAL.set(j + 1, emptyAL.get(j));
                j = j - 1;
            }
            emptyAL.set(j + 1, key);
        }
        System.out.println();
        for (int data : emptyAL) {
            System.out.print(data + " -> ");
        }
        System.out.print("nil");


    }

    /**
     * Add a list of objects to queue
     */
    public void addListC(T[]... seriesOfObjects) {
        for (T[] objects : seriesOfObjects)
            for (T data : objects) {
                this.queue.add(data);
                this.count++;
            }
    }

    public void addList(T[]... seriesOfObjects) {
        for (T[] objects : seriesOfObjects)
            for (T data : objects) {
                System.out.println("Enqeued data: " + data);
                this.queue.add(data);
                this.count++;
                printQueue();
            }
    }

    //dequeue
    public void removeList(T[]... seriesOfObjects) {
        for (T[] objects : seriesOfObjects)
            for (T data : objects) {
                System.out.println("Deqeued data: " + data);
                this.queue.remove(data);
                this.count--;
                printQueue();
            }
    }

    /**
     * Print any array objects from queue
     */
    public void printQueue() {
        System.out.print(this.name + " count: " + count + ", data: ");
        for (T data : queue) {
            if (count != 0) {
                System.out.print(data + " ");
            } else {
                System.out.print("null");
            }
        }
        System.out.println("");
    }
}
