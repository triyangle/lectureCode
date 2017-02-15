/**
 * Created by hug on 2/6/2017.
 * Demonstrates higher order functions in Java.
 */
public class HoFDemo<T> {
    public T do_twice(IntUnaryFunction<T> f, T x) {
        return (T) f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        IntUnaryFunction tenX = new TenX();
        //System.out.println(do_twice(tenX, 2));
    }
}
