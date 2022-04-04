package Week3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Week3.Merge;

public class Sorts {
    private final ArrayList<Integer> data = new ArrayList<>();
    private final Duration timeElapsed;

    public Sorts(int size, String algo) {
        Instant start = Instant.now();  // time capture -- start
        // build an array
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }

        // use Inheritance and Polymorphism to replace data.sort with your own algorithm
        switch(algo) {
            case "Merge":
                Merge.sort(data);
                System.out.println();
                break;
            case "Bubble":
                Bubble.bubbleSort(data);
                System.out.println();
                break;
            case "Selection":
                Selection.sort(data);
                System.out.println();
                break;
            case "Insertion":
                Insertion.sort(data);
                System.out.println();
                break;
            default:
                System.out.println("invalid sort method");
        }

        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }


    public static void statistics(String algo) {
        int sum=0, time=0, TIMES=12, SIZE=5000;
        ArrayList<Integer> lowandhigh = new ArrayList<Integer>();
        for(int i=0; i< TIMES; i++) {
            Sorts s = new Sorts(SIZE, algo);
            for(int j = 0; j<s.getData().size(); j++) {
                // To see data, uncomment next line
                // System.out.println(s.getData());
                sum += s.getData().get(j);
            }
            System.out.println("Average random: " + sum / ((i+1)*SIZE));
            System.out.println("Nanoseconds: " + s.getTimeElapsed());
            time += s.getTimeElapsed();
            lowandhigh.add(s.getTimeElapsed());
        }
        Collections.sort(lowandhigh);
        System.out.println(" ");
        System.out.println(algo +" Sort Analysis");
        System.out.println("Total Nanoseconds: " + time );
        System.out.println("Total Seconds: " + time /1000000000.0);
        System.out.println("ALL times in Nanoseconds: " + lowandhigh);
        System.out.println("Average time in seconds with low and high: "+ time/12/1000000000.0);

        Integer nolowandhigh = 0;
        System.out.println("Low (nano): "+lowandhigh.remove(0)); // remove smallest
        System.out.println("High (nano): "+lowandhigh.remove(lowandhigh.size()-1)); //remove largest
        for(Integer d : lowandhigh) {
            nolowandhigh += d;
        }
        System.out.println("Average time in seconds without high and low: "+ nolowandhigh/10/1000000000.0);
    }

    public static void main(String[] args){
        System.out.println("           Bubble Data           ");
        statistics("Bubble");
        System.out.println(" ");
        System.out.println("           Selection Data           ");
        statistics("Selection");
        System.out.println(" ");
        System.out.println("           Insertion Data           ");
        statistics("Insertion");
        System.out.println(" ");
        System.out.println("           Merge Data           ");
        statistics("Merge");
        System.out.println(" ");
    }

}