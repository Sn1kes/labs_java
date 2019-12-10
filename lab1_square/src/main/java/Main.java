import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class TestSquare {
    @Test
    void testroot1() {
        SquareRoot sq_root = new SquareRoot(0, 5, 3);
        sq_root.solve();
        double x1 = sq_root.get_x1();
        double x2 = sq_root.get_x2();
        int roots = sq_root.get_roots();
        assertEquals(roots, 1);
        assertEquals(x1, -0.6);
    }

    @Test
    void testroot2() {
        SquareRoot sq_root = new SquareRoot(1, 3, 4);
        sq_root.solve();
        int roots = sq_root.get_roots();
        assertEquals(roots, 0);
    }

    @Test
    void testroot3() {
        SquareRoot sq_root = new SquareRoot(1, 3, -4);
        sq_root.solve();
        double x1 = sq_root.get_x1();
        double x2 = sq_root.get_x2();
        int roots = sq_root.get_roots();
        assertEquals(roots, 2);
        assertEquals(x1, 1);
        assertEquals(x2, -4);
    }
}

class SquareRoot {
    private double a;
    private double b;
    private double c;
    private int roots;
    private double x1;
    private double x2;

    SquareRoot(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void solve() {
        double descriminant = b * b - 4 * a * c;
        if(a == 0) {
            x1 = -c / b;
            roots = 1;
        } else {
            if(descriminant < 0)
                roots = 0;
            else if(descriminant == 0) {
                x1 = (-b + Math.sqrt(descriminant)) / 2 * a;
                roots = 1;
            } else {
                roots = 2;
                x1 = (-b + Math.sqrt(descriminant)) / 2 * a;
                x2 = (-b - Math.sqrt(descriminant)) / 2 * a;
            }
        }
    }

    double get_x1() {
        return x1;
    }

    double get_x2() {
        return x2;
    }

    int get_roots() {
        return roots;
    }
}

public class Main {

    public static void main(String[] args) {
        double a, b, c;
        Scanner scan = new Scanner(System.in);
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();
        SquareRoot sq_root = new SquareRoot(a, b, c);
        sq_root.solve();
        int num_roots = sq_root.get_roots();
        System.out.printf("Number of roots: %d\n", num_roots);
        if(num_roots == 1) {
            System.out.println(sq_root.get_x1());
        } else if(num_roots == 2) {
            System.out.println(sq_root.get_x1());
            System.out.println(sq_root.get_x2());
        }
    }
}
