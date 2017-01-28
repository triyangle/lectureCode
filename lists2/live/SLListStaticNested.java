 /** An SLListStaticNested is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLListStaticNested {
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    /** Creates an empty SLListStaticNested. */
    public SLListStaticNested() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLListStaticNested(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds x to the end of the list. */
    public void addLast(int x) {
        size = size + 1;

        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /* public static void main(String[] args) {
        [>Creates a list of one integer, namely 10<]
        SLListStaticNested L = new SLListStaticNested();
        L.addLast(20);
        System.out.println(L.size());

    } */
}

class Test {
    public static void main(String[] args) {
        SLListStaticNested.IntNode test = new SLListStaticNested.IntNode(3, null);
        System.out.println(test.item);
    }
}
