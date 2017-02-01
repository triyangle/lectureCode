/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    /** Creates an empty list. */

    private int[] list;
    private int size;

    public AList() {
        list = new int[100];
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size >= list.length) {
            int[] temp = new int[list.length * 100];
            System.arraycopy(list, 0, temp, 0, list.length);
            list = temp;
        }
        list[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return list[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return list[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int last = getLast();
        size--;
        return last;
    }
}
