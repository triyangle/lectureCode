public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith value in this list.*/
    public int get(int i) {
        return (i == 0) ? first : rest.get(i - 1);
    }

    public int whileIterativeGet(int i) {
        IntList p = this;
        while (i > 0) {
            p = p.rest;
            i--;
        }
        return p.first;
    }

    public int forIterativeGet(int i) {
        IntList p = this;
        for (int index = i; index > 0; index--) {
            p = p.rest;
        }
        return p.first;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.iterativeSize());
        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));

        System.out.println();

        System.out.println("whileIterativeGet: " + L.whileIterativeGet(0));
        System.out.println("whileIterativeGet: " + L.whileIterativeGet(1));
        System.out.println("whileIterativeGet: " + L.whileIterativeGet(2));

        System.out.println();

        System.out.println("forIterativeGet: " + L.forIterativeGet(0));
        System.out.println("forIterativeGet: " + L.forIterativeGet(1));
        System.out.println("forIterativeGet: " + L.forIterativeGet(2));
    }
}
