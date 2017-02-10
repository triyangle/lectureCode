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
    }

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

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.size());

        SLList.IntNode test = new SLList.IntNode(5, null);
        test.addFirst(4);
        test.addFirst(3);
        test.addFirst(2);
        test.addFirst(1);
        test.addFirst(0);
        test.printList();
    }
}
