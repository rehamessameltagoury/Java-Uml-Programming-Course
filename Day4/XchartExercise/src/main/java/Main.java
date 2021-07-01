
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import smile.data.DataFrame;
import smile.data.vector.BaseVector;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
public static void  main(String[] args) {
    // read the data
    String Path = "D:\\ITI\\java\\XchartExercise\\src\\main\\resources\\titanic.csv";
    PassengerProvider passenger = new PassengerProvider();
    DataFrame Pass = passenger.readCSV(Path);
    List<Passenger> passengerList = passenger.getPassengerList();
    System.out.println(passengerList);
    DataFrame pName = Pass.select("name");
    List<String> pNames = passengerList.stream().map(Passenger::getName).limit(8).collect(toList());
    List<Double> pAges = passengerList.stream().map(Passenger::getAge).limit(8).collect(toList());
    CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Age Histogram").xAxisTitle("Names").yAxisTitle
            ("Age").build();
    //Customize the chart
    chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
    chart.getStyler().setHasAnnotations(true);
    chart.getStyler().setStacked(true);
    // 3.Series
    chart.addSeries("Passenger's Ages", pNames, pAges);
    /* 4.Show it */
    new SwingWrapper(chart).displayChart();
    System.out.println("==============================================");
    Map<Integer, Long> result = passengerList.stream().collect(groupingBy(Passenger::getPclass, counting()));

// Create Chart
    PieChart chart2 = new PieChartBuilder().width(800).height(600).title(Main.class.getSimpleName()).build();
// Customize Chart
    Color[] sliceColors = new Color[]{new Color(180, 68, 50), new Color(130, 105, 120), new Color(80, 143, 160)};
    chart2.getStyler().setSeriesColors(sliceColors);
// Seris

    chart2.addSeries("First Class", result.get(1));
    chart2.addSeries("Second Class", result.get(0));
// Show it
    new SwingWrapper(chart2).displayChart();

    System.out.println("==============================================");
    Map<Integer, Long> result2 = passengerList.stream().collect(groupingBy(Passenger::getSurvived, counting()));

// Create Chart
    PieChart chart3 = new PieChartBuilder().width(800).height(600).title(Main.class.getSimpleName()).build();
// Customize Chart
    Color[] sliceColors2 = new Color[]{new Color(180, 68, 50), new Color(130, 105, 120)};
    chart2.getStyler().setSeriesColors(sliceColors2);
// Series

    chart3.addSeries("First Class", result2.get(1));
    chart3.addSeries("Second Class", result2.get(0));
// Show it
    new SwingWrapper(chart3).displayChart();

    // make a column of survived genders
    Map<String, Map<Integer, Long>> result3 = passengerList.stream().collect(groupingBy(Passenger::getSex, groupingBy(Passenger::getSurvived, counting())));
   // System.out.println(result3.get(1).get("female"));
// Create Chart
    PieChart chart4 = new PieChartBuilder().width(800).height(600).title(Main.class.getSimpleName()).build();
// Customize Chart
    Color[] sliceColors1 = new Color[]{new Color(180, 68, 50), new Color(130, 105, 120)};
    chart2.getStyler().setSeriesColors(sliceColors1);
// Series
    chart4.addSeries("Female Survived", result3.get("female").get(1));
    chart4.addSeries("Male Survived", result3.get("male").get(1));
    new SwingWrapper(chart4).displayChart();
}
}
