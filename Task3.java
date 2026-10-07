import java.util.Scanner;

public class Task3 {
    interface Root {
        String calculateRoots();
        void printResult();
    }

    static class Linear implements Root {
        private final double a, b;

        public Linear(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String calculateRoots() {
            if (a == 0) return b == 0 ? "Безліч коренів" : "Коренів немає";
            return "x = " + (-b / a);
        }

        @Override
        public void printResult() {
            System.out.println(calculateRoots());
        }

        @Override
        public String toString() {
            return "Лінійне рівняння: " + a + " * x + (" + b + ") = 0";
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Linear)) return false;
            Linear other = (Linear) obj;
            return Double.compare(a, other.a) == 0 && Double.compare(b, other.b) == 0;
        }
    }

    static class Square implements Root {
        private final double a, b, c;

        public Square(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String calculateRoots() {
            if (a == 0) return new Linear(b, c).calculateRoots();
            double d = b * b - 4 * a * c;
            if (d < 0) return "Дійсних коренів немає";
            if (d == 0) return "x = " + (-b / (2 * a));
            double x1 = (-b + java.lang.Math.sqrt(d)) / (2 * a);
            double x2 = (-b - java.lang.Math.sqrt(d)) / (2 * a);
            return "x1 = " + x1 + ", x2 = " + x2;
        }

        @Override
        public void printResult() {
            System.out.println(calculateRoots());
        }

        @Override
        public String toString() {
            return "Квадратне рівняння: " + a + " * x² + (" + b + ") * x + (" + c + ") = 0";
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Square)) return false;
            Square other = (Square) obj;
            return Double.compare(a, other.a) == 0 && Double.compare(b, other.b) == 0
                && Double.compare(c, other.c) == 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Root[] equations = new Root[2];

        System.out.println("Введіть a і b для лінійного рівняння a * x + b = 0:");
        equations[0] = new Linear(in.nextDouble(), in.nextDouble());

        System.out.println("Введіть a, b і c для квадратного рівняння a * x² + b * x + c = 0:");
        equations[1] = new Square(in.nextDouble(), in.nextDouble(), in.nextDouble());

        System.out.println("\nРезультати:");
        for (Root equation : equations) {
            System.out.println(equation.toString());
            equation.printResult();
            System.out.println();
        }

        in.close();
    }
}
