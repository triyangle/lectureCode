public class ExtraIntListPractice {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {

        IntList incremented = new IntList(L.first + x, null);
        IntList current = incremented;
        L = L.rest;

        while (L != null) {
            current.rest = new IntList(L.first + x, null);
            current = current.rest;
            L = L.rest;
        }

        return incremented;
    }

    public static IntList incrListRecursive(IntList L, int x) {
        if (L == null) {
            return L;
        }
        return new IntList(L.first + x, incrListRecursive(L.rest, x));
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        IntList p = L;
        while (p.rest != null) {
            p.first += x;
            p = p.rest;
        }
        return L;
    }

    public static IntList dincrListRecursive(IntList L, int x) {
        if (L == null) {
            return L;
        }
        L.first += x;
        dincrListRecursive(L.rest, x);
        return L;
    }

    public static IntList dRecursiveReverse(IntList L) {
        if (L == null || L.rest == null) {
            return L;
        }
        IntList newHead = dRecursiveReverse(L.rest);
        L.rest.rest = L;
        L.rest = null;
        return newHead;
    }

    public static IntList recursiveReverse(IntList L) {
        return helperRecursiveReverse(L, null);
    }

    public static IntList helperRecursiveReverse(IntList L, IntList reversed) {
        if (L == null) {
            return reversed;
        }
        return helperRecursiveReverse(L.rest, new IntList(L.first, reversed));
    }

    public static IntList dIterativeReverse(IntList L) {
        IntList reversed = null;
        IntList current = L;
        while (current != null) {
            L = current;
            current = current.rest;
            L.rest = reversed;
            reversed = L;
        }
        return reversed;
    }

    public static IntList iterativeReverse(IntList L) {
        IntList reversed = new IntList(L.first, null);
        L = L.rest;
        while (L != null) {
            reversed = new IntList(L.first, reversed);
            L = L.rest;
        }
        return reversed;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        System.out.println("incrList: " + incrList(L, 3).get(1));
        System.out.println("L: " + L.get(1));
        System.out.println("dincrList: " + dincrList(L, 3).get(1));
        System.out.println("L: " + L.get(1));
        System.out.println();
        System.out.println("incrListRecursive: " + incrListRecursive(L, 3).get(1));
        System.out.println("L: " + L.get(1));
        System.out.println("dincrListRecursive: " + dincrListRecursive(L, 3).get(1));
        System.out.println("L: " + L.get(1));

        System.out.println();
        L.printList();
        System.out.println();

        IntList recursiveReversed = recursiveReverse(L);
        recursiveReversed.printList();

        IntList iterativeReversed = iterativeReverse(L);
        iterativeReversed.printList();

        IntList recursiveUnreversed = dRecursiveReverse(recursiveReversed);
        recursiveUnreversed.printList();

        IntList iterativeUnreversed = dIterativeReverse(iterativeReversed);
        iterativeUnreversed.printList();
    }
}
