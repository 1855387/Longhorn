package Week1;

/**
 * Driver Class
 * Tests queue with string, integers, and mixes of Classes and types
 */
public class QueueTester {
    public static void main(String[] args) {
        // Create iterable Week2.Queue of Words
        Object[] words = new String[]{"seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
        // Week2.QueueManager qWords = new Week2.QueueManager("Words", words);
        // qWords.printQueue();

        QueueManager qWords = new QueueManager("Words");
        for (Object word : words) {
            qWords.add(word);
            qWords.printQueue();
        }
        for (Object word : words) {
            qWords.delete();
            qWords.printQueue();
        }

        // Create iterable Week2.Queue of Integers
        Object[] numbers = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        QueueManager qNums = new QueueManager("Integers", numbers);
        qNums.printQueue();
    }
}
