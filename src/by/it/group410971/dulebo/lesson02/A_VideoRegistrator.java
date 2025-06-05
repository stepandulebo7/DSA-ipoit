package by.it.group410971.dulebo.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Даны события events
 реализуйте метод calcStartTimes, так, чтобы число включений регистратора на
 заданный период времени (1) было минимальным, а все события events
 были зарегистрированы.
 Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class A_VideoRegistrator {

    public static void main(String[] args) {
        A_VideoRegistrator instance = new A_VideoRegistrator();
        double[] events = new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts = instance.calcStartTimes(events, 1); // рассчитываем моменты старта с длительностью сеанса 1
        System.out.println(starts); // показываем моменты старта
    }

    List<Double> calcStartTimes(double[] events, double workDuration) {
        List<Double> result = new ArrayList<>();
        Arrays.sort(events); // сортируем события по времени
        int i = 0;

        while (i < events.length) {
            double startTime = events[i]; // фиксируем момент включения регистратора
            result.add(startTime);
            double endTime = startTime + workDuration; // рассчитываем момент выключения

            // пропускаем все события, которые попадают в интервал работы регистратора
            while (i < events.length && events[i] <= endTime) {
                i++;
            }
        }
        return result;
    }
}