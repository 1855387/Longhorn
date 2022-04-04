{% include navigation.html %}

# Tech Talk Notes
# Tech Talk 3

## Bubble Sort
- Swaps adajcent elements into the correct order
- Whole pass is then performed to ensure that the array is fully sorted, and the algorithm knows to stop
- **Time Complexity/ Big O Notation:** Bubble sort can vary in its Big O Notation, with a worst case scenario of O(n^2) and a best case scenario of O(n)
- Code which we built off of in the implementation process
``` java
public class Bubble {
    public static void bubbleSort(ArrayList<Integer> arr) {

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i).compareTo(arr.get(i + 1)) > 0) {
                int temp = arr.get(i);
                arr.set(i, arr.get(i + 1));
                arr.set(i + 1, temp);
            }
        }
    }
}
```

### Implementation
- Created individual file to contain the sorting algorithm developed
- Utilized each sort as a method, which we use to sort the 5,000 element array when we use analyze()
- Time is recorded each time we sort and added to an arraylist
>- Using this list we can find total time, as well as the largest and smallest values and remove them if nessecary
- Data is then displayed

![image](https://user-images.githubusercontent.com/72889453/161475420-4d0f546c-910c-4f36-b3bf-4b7450154609.png)

## Selection Sort
- Finds the minimun value element repeadly in an ascending pattern
- Essentially has 2 arrays, in which the minimun value is then added to a sorted array, while algorithm finds the next minimun value in the unsorted array
- **Time Complexity Formula/ Big O Notation:** O(n^2) is the notation because selection sort utilizes 2 arrays

![Flowchart](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20220203094305/Selection-Sort-Flowhchart.png)
- Example algorithm of a selection sort which we built off of and implemented:

``` java
class Selection {
    public static void sort(ArrayList<Integer> arr) {
        int n = arr.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        }
    }
}
```
### Implementation
- Implementation is similar to other sorts
- Created individual file to contain the sorting algorithm developed
- Utilized each sort as a method, which we use to sort the 5,000 element array when we use analyze()
- Time is recorded each time we sort and added to an arraylist
>- Using this list we can find total time, as well as the largest and smallest values and remove them if nessecary
- Data is then displayed

![image](https://user-images.githubusercontent.com/72889453/161475494-2b730f9d-a7b9-45bb-8457-a09c31d2a946.png)

## Merge Sort
- Merge Sort is a divide and conquer type of algorithm
- Input array is divided into 2 halves, calls each half, and then merges the halves back together
>- Merge is the key process and is executed after the halves are sorted
- **Time Complexity/Big O Notation:** O(n * Log (n)) Because this is a logarithmic function, it means that the time taken based on the amount of elements isn't as affected, and is a rather efficent program. Even in a worst case scenario, the notation still reamins the same

![Flowchart](https://media.geeksforgeeks.org/wp-content/cdn-uploads/Merge-Sort-Tutorial.png)
- Sample algorithm which we built off to try and implement

``` java
   public class Merge {
    private final ArrayList<Integer> arrayToSort;

    public Merge(ArrayList<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public ArrayList<Integer> getArrayAfterSorting() {
        return arrayToSort;
    }

    public void divideArrayElements(int indexStart, int indexEnd) {

        if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) {
            int middleElement = (indexEnd + indexStart) / 2;

            divideArrayElements(indexStart, middleElement);
            divideArrayElements(middleElement + 1, indexEnd);

            mergeArrayElements(indexStart, middleElement, indexEnd);
        }
    }

    public void mergeArrayElements(int indexStart, int indexMiddle, int indexEnd) {

        ArrayList<Integer> tempArray = new ArrayList<>();

        int getLeftIndex = indexStart;
        int getRightIndex = indexMiddle + 1;

        while (getLeftIndex <= indexMiddle && getRightIndex <= indexEnd) {

            if (arrayToSort.get(getLeftIndex) <= arrayToSort.get(getRightIndex)) {

                tempArray.add(arrayToSort.get(getLeftIndex));
                getLeftIndex++;

            } else {

                tempArray.add(arrayToSort.get(getRightIndex));
                getRightIndex++;

            }
        }

        while (getLeftIndex <= indexMiddle) {
            tempArray.add(arrayToSort.get(getLeftIndex));
            getLeftIndex++;
        }

        while (getRightIndex <= indexEnd) {
            tempArray.add(arrayToSort.get(getRightIndex));
            getRightIndex++;
        }


        for (int i = 0; i < tempArray.size(); indexStart++) {
            arrayToSort.set(indexStart, tempArray.get(i++));

        }

    }

    public static void sort(ArrayList<Integer> arr) {
        Merge merge = new Merge(arr);

//        System.out.println("Array Before Merge Sort: ");
//        for (Integer integer : merge.getArrayAfterSorting()) {
//            System.out.println(integer);
//        }

//        System.out.println();

        merge.divideArrayElements(0, arr.size() - 1);

//        System.out.println("Array After Merge Sort: ");
//        for (Integer integer : merge.getArrayAfterSorting()) {
//            System.out.println(integer);
//        }


    }
}
```

### Implementation
- Implementation is similar to other sorts
- Created individual file to contain the sorting algorithm developed
- Utilized each sort as a method, which we use to sort the 5,000 element array when we use analyze()
- Time is recorded each time we sort and added to an arraylist
>- Using this list we can find total time, as well as the largest and smallest values and remove them if nessecary
- Data is then displayed

![image](https://user-images.githubusercontent.com/72889453/161475583-2c842fdf-49e5-42ae-98ee-9acc8426747b.png)
## Insertion Sort
- Uses 2 arrays, sorted and unsorted, and sorts the elements within the unsorted array and addes them to the sorted array
- **Time Complexity/Big O Notation:** O(n). This means that the time taken to sort is directly proportional to the amount of elemenets sorted. However, this is only the best case scenario. On average, and in the worst case, the Big O Notation is O(n^2) which notates a longer time taken
- Algorithm Breakdown:
>- Iterate from arr[1] to arr[n] over the array.
>- Compare the current element (key) to its predecessor.
>- If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped
   element.

![Flowchart](https://media.geeksforgeeks.org/wp-content/uploads/insertionsort.png)

-  Algorithm we worked on implementing into the challenge
``` java
public class Insertion {
    /*Function to sort array using insertion sort*/
    public static void sort(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            int key = arr.get(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j+1, arr.get(j));
                j = j - 1;
            }
            arr.set(j+1, key);
        }
        }
    }
```
### Implementation
- Implementation is similar to other sorts
- Created individual file to contain the sorting algorithm developed
- Utilized each sort as a method, which we use to sort the 5,000 element array when we use analyze()
- Time is recorded each time we sort and added to an arraylist
>- Using this list we can find total time, as well as the largest and smallest values and remove them if nessecary
- Data is then displayed

![image](https://user-images.githubusercontent.com/72889453/161475721-1e62d335-891a-4bfd-b01e-cb5c0f2eef8e.png)

# Tech Talk 2

## Team Notes

![Landing](https://user-images.githubusercontent.com/54718041/159974329-dceb59ac-0888-406e-881f-1c6ea6a27f7d.png)
- The goal of our project is to authenticate users through Spring
- The large vision is being able to teach everyone how to utilize it, as well as having a large centralized login system that everyone can utilize.

## Calculator

- Build a calculator to process expressions and ultimately change RPN to a calculation.
``` java
    public String toString() {
        return ("Original expression: " + this.expression + "\n" +
                "Tokenized expression: " + this.tokens.toString() + "\n" +
                "Reverse Polish Notation: " +this.reverse_polish.toString() + "\n" +
                "Final result: " + String.format("%.2f", this.result));
    }
```
- Code used above is to print the numbers into different formats and truly lets you see what RPN notation is supposed to look like etc.
``` java
                            calc.push(num1 + num2);
                            break;
                        case "-":
                            calc.push(num1 - num2);
                            break;
                        case "*":
                            calc.push(num1 * num2);
                            break;
                        case "/":
                            calc.push(num1 / num2);
                            break;
                        case "%":
                            calc.push(num1 % num2);
                            break;
                        case "^" :
                            calc.push(Math.pow(num1, num2));
```
- The following code was implemented to account for each of the cases that the user would ask for in terms of calculation and do the following calculation based on what they asked for.
- The following use the Stack object calc and pushes the calculation between numbers given to give an accurate output.
 
# Tech Talk 1

## Linked Lists

- As stated, most "Data Structures" conversations usually begin with Arrays
>- Is built into most Computer Programming Languages
- College Board has Units 6-8 which discuss Arrays, ArrayLists, and 2-Dimensional Arrays
- Most Data Structures conversations continue with the discussions of Linked Lists which are the foundation for Stacks and Queues

# Tech Talk 0

## Data Structures

- A data structure is a method of organizing data
- Think of a variable holding a single integer value(ex: int n=4;) or sequences of numbers(ex: int[] numbers=new int[]{ 1,2,3 };) or tables of data, or databases: these are all well-defined data structures.
- Data Structures and organizing data will require students to become more algorithmic in coding.

## Data Structure Algorithms
- There are many algorithms for different purposes and they interact with different data structures.
- Think of algorithms as dynamic underlying pieces that interact with data structures.
- EX:
``` java
public void swapToLowHighOrder(IntByReference i) {
        if (this.value > i.value) {
            int temp = this.value;
            this.value = i.value;
            i.value = temp;
        }
    }
```
- Together, data structures and algorithms combine and allow programmers to build whatever computer programs they’d like.
- Good managed data structures and algorithms ensures well-optimized and efficient code.
## Paradigms
#### Imperative Paradigms
- An imperative program consists of commands for the computer to perform to achieve a result. Imperative programming focuses on describing "how" a program code works.
#### OO Paradigm
- OOP models complex things as reproducible, simple structures.
- Reusable, OOP classes can be used across programs by simply making an object.
- We have learned about many key aspects of OOP.
- OO based matrix alteration
``` java
public String reverse() {
        // outer loop starting at end row
        StringBuilder output = new StringBuilder();
        for (int i = matrix.length;  0 < i; i--) {
            // inner loop for column
            for (int j =  matrix[i-1].length; 0 < j; j--) {
                output.append((matrix[i-1][j-1]==-1) ? " " : String.format("%x",matrix[i-1][j-1])).append(" ");
            }
            output.append("\n"); // new line
        }
        return output.toString();
    }
```
