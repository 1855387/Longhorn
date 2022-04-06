{% include navigation.html %}

## Analysis on the Sorts

| Sort Type | Average runtime with highs and lows | Average runtime with highs and lows omitted | Big O complexity |
| :---   | :---    | :---    | :---    |
| Bubble | 0.002327683 | 0.00219408 | O(n²) in worst case; O(n) in the best case | 
| Insertion | 0.031171416 | 0.03052125 | O(N^2) in worst case;  O(N) in the best case |
| Selection | 0.033331483 | 0.0323154 | O(n²) regardless|
| Merge (Best) | 0.00590485 | 0.00578954 | O(n log n) regardless (most efficient) |

![animation](https://miro.medium.com/max/1400/1*bPpvELo9_QqQsDz7CSbwXQ.gif)