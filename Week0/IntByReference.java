package Week0;

public class IntByReference {
    private int value;

    public IntByReference(Integer value) {
        this.value = value;
    }

    public String toString() {
        return (String.format("%d", this.value));
    }

    public void swapToLowHighOrder(IntByReference x) {
        if (this.value > x.value) {
            int tmp = this.value;
            this.value = x.value;
            x.value = tmp;
        }
    }

    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: " + a + " " + b);
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a + " " + b);
        System.out.println();
    }

    public static void main(String[] ags) {
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);
    }

}