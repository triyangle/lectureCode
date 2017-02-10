public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

        public void addFirst(int x) {
            next = new IntNode(item, next);
            item = x;
        }

        public void printList() {
            IntNode p = this;
            while (p.next != null) {
                System.out.print(p.item + " ");
                p = p.next;
            }
            System.out.println(p.item);
        }

        public void printFirst() {
            System.out.println(test);
        }

    }

    public static String test = "test";
    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        IntNode temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new IntNode(x, null);
    }

    public void recursiveAddLast(int x) {
        recursiveAddLast(x, first);
    }

    private static void recursiveAddLast(int x, IntNode current) {
        if (current.next == null) {
            current.next = new IntNode(x, null);
        } else {
            recursiveAddLast(x, current.next);
        }
    }

    /** Returns the number of items in the list using recursion. */
    public int size() {
        IntNode temp = first;
        int size = 1;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public int recursiveSize() {
        return recursiveSize(first);
    }

    private static int recursiveSize(IntNode current) {
        return (current.next == null) ? 1 : 1 + recursiveSize(current.next);
    }

    public void printList() {
        first.printList();
    }

    public static void test() {
        System.out.println("testing");
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        L.recursiveAddLast(40);
        System.out.println(L.size());
        System.out.println(L.recursiveSize());
        L.printList();
        /* SLList.IntNode test = new SLList.IntNode(5, null);
         * test.printFirst(); */
        /* test.addFirst(4);
         * test.addFirst(3);
         * test.addFirst(2);
         * test.addFirst(1);
         * test.addFirst(0);
         * test.printList(); */
    }
}
