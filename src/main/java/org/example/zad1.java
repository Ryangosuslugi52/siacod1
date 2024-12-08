package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

import java.util.Random;
public class zad1 {
    public static void main(String[] args) {
        Progrev(30);

        int start1 = 20000;
        int start2 = 300000;
        XYSeries series1 = new XYSeries("Первый замер");
        for(int i = 0; i < 25;i++){
            series1.add(start1,logic(createRandomArray(start1)));
            start1 += 10000;
        }
        XYSeriesCollection dataset1 = new XYSeriesCollection();
        dataset1.addSeries(series1);

        // Создаем график
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Линейный график",
                "n",
                "t, нс",
                dataset1
        );

        // Создаем панель для отображения графика
        ChartPanel chartPanel1 = new ChartPanel(chart);
        chartPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        // Создаем окно для отображения графика
        JFrame frame = new JFrame("Пример линейного графика");
        frame.setContentPane(chartPanel1);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        XYSeries series2 = new XYSeries( "Второй замер");

        for(int i = 0; i < 25;i++){
            series2.add(start2, logic(createRandomArray(start2)));
            start2 += 150000;}
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(series2);
        // Создаем график
        JFreeChart chart2 = ChartFactory.createXYLineChart(
                " график",
                "n",
                "t, нс",
                dataset2
        );

// Создаем панель для отображения графика
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        chartPanel2.setPreferredSize(new java.awt.Dimension(800, 600));

// Создаем окно для отображения графика
        JFrame frame2 = new JFrame("Пример линейного графика");
        frame2.setContentPane(chartPanel2);
        frame2.pack();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
    }








    public static int[] createRandomArray(int size){
        Random random = new Random();
        int[] result = new int[size];
        for(int i = 0; i < size; i++){
            int s = random.nextInt(100) - 40;
            result[i] = s;
        }
        return result;
    }


    public static void printArray(int [] array){
        for(int i : array){
            System.out.print(i + ", ");
        }
        System.out.println();
    }


    public static long logic(int[]array){
        long startTime = System.nanoTime();
        int j = 0;
        for(int i = 0;i<array.length;i++){
            if (array[i] >= 0) {
                int a = array[j];
                array[j] = array[i];
                array[i] = a;
                j++;


            }
        }
        long endTime = System.nanoTime();
        long durationInNano = endTime - startTime;
        System.out.println("Время выполнения: " + durationInNano + " наносекунд");
        return durationInNano;
    }


    public static void Progrev(int n){
        for(int i = 0; i!= n;i++){
            logic2(createRandomArray(400000));
            logic2(createRandomArray(600000));
            logic2(createRandomArray(800000));
            logic2(createRandomArray(1000000));
            logic2(createRandomArray(1200000));

        }
        System.out.println("Прогрев завершён!");
    }


    public static long logic2(int[]array){
        long startTime = System.nanoTime();
        int j = 0;
        for(int i = 0;i<array.length;i++){
            if (array[i] >= 0) {
                int a = array[j];
                array[j] = array[i];
                array[i] = a;
                j++;


            }
        }
        long endTime = System.nanoTime();
        long durationInNano = endTime - startTime;
        return durationInNano;
    }
}


