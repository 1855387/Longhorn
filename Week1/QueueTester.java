package Week1;

/**
 * Driver Class
 * Tests queue with string, integers, and mixes of Classes and types
 */
public class QueueTester {
    public static void main(String[] args) {
        // Create iterable Queue of Words
        Object[] words = new String[]{"seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
        QueueManager qWords = new QueueManager("Words", words);
        qWords.removeList(words);

        // Create iterable Week2.Queue of Integers
        Object[] numbers = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        QueueManager qNums = new QueueManager("Integers");
//        qNums.printQueue();
    }
}
