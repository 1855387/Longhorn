{% include navigation.html %}

# Tech Talk Notes

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
