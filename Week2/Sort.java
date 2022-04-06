package Week2;


import Week1.QueueManager;

public class Sort {

    public static void main(String[] args)
    {
        // Create iterable Queue of Words
        Object[] number1 = new String[] { "1", "4", "5", "8"};
        Object[] number2 = new String[] { "2", "3", "6", "7"};
        QueueManager q1 = new QueueManager(number1);
        q1.getQueue();
        QueueManager q2 = new QueueManager(number2);
        q2.getQueue();
        q1.sort(q2);


    }
}