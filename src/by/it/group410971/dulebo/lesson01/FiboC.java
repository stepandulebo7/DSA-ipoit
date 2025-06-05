package by.it.group410971.dulebo.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m
 * время расчета должно быть не более 2 секунд
 */

public class FiboC {

    private long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 55555;
        int m = 1000;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    long fasterC(long n, int m) {
        int pisanoPeriod = getPisanoPeriod(m);

        long k = n % pisanoPeriod;

        return fibonacciMod(k, m);
    }

    private int getPisanoPeriod(int m) {
        long prev = 0;
        long curr = 1;
        int period = 0;

        while (true) {
            long next = (prev + curr) % m;
            prev = curr;
            curr = next;
            period++;

            if (prev == 0 && curr == 1) {
                return period;
            }
        }
    }

    private long fibonacciMod(long k, int m) {
        if (k <= 1) {
            return k % m;
        }

        long prev = 0;
        long curr = 1;

        for (long i = 2; i <= k; i++) {
            long next = (prev + curr) % m;
            prev = curr;
            curr = next;
        }

        return curr;
    }
}