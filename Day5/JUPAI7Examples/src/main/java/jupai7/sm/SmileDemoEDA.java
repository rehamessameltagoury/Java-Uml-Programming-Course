package jupai7.sm;

import smile.classification.RandomForest;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.data.measure.NominalScale;
import smile.data.vector.BaseVector;
import smile.data.vector.IntVector;
import smile.data.vector.StringVector;
import smile.plot.swing.Histogram;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class SmileDemoEDA {
    String trainPath = "src/main/resources/data/titanic_train.csv";
    String testPath = "src/main/resources/data/titanic_test.csv";

    public static void main(String[] args) throws IOException {
        SmileDemoEDA sd = new SmileDemoEDA ();
        PassengerProvider pProvider = new PassengerProvider ();
        DataFrame trainData = pProvider.readCSV (sd.trainPath);
        //System.out.println("Train: "+trainData.select("Pclass"));
        trainData = trainData.merge (IntVector.of ("Gender",
                encodeCategory (trainData, "Sex")));
        trainData = trainData.merge (IntVector.of ("PClassValues",
                encodeCategory (trainData, "Pclass")));
        //System.out.println("Train2: "+trainData.select("PClassValues"));


        trainData = trainData.drop ("Name");
        trainData=trainData.drop("Pclass");
        trainData=trainData.drop("Sex");

        trainData = trainData.omitNullRows ();

        RandomForest model = RandomForest.fit(Formula.lhs("Survived"), trainData);
        System.out.println("feature importance:");
        System.out.println(Arrays.toString(model.importance()));
        System.out.println(model.metrics ());
        //TODO load test data to validate model
        SmileDemoEDA sd2 = new SmileDemoEDA ();
        PassengerProvider pProvider2 = new PassengerProvider ();
        DataFrame testData = pProvider2.readTestCSV (sd2.testPath);
        testData = testData.merge (IntVector.of ("Gender",
                encodeCategory (testData, "Sex")));
        // Pclass conversion into string to be encoded by the encoding function

        //System.out.println("Test: "+ testData.select("Pclass"));
        DataFrame i = testData.select("Pclass");
        String [] Pclass_str = new String[testData.size()];

        for(int x=0;x<testData.size();x++) {
            Pclass_str[x] = testData.column("Pclass").get(x).toString();
        }
        testData=testData.merge(StringVector.of("Str_PCLASS",Pclass_str));
        testData = testData.merge (IntVector.of ("PClassValues",
                encodeCategory (testData, "Str_PCLASS")));
        testData = testData.drop ("Name");
        testData=testData.drop("Pclass");
        testData=testData.drop("Sex");
        testData=testData.drop("Str_PCLASS");

        testData = testData.omitNullRows ();
        //System.out.println(trainData.structure());
        System.out.println(testData.summary());
        // Evaluate the model with test data
        int[][] evaluationresult = model.test(testData);
        System.out.println(Arrays.deepToString(evaluationresult));






    }

    public static int[] encodeCategory(DataFrame df, String columnName) {
        String[] values = df.stringVector (columnName).distinct ().toArray (new String[]{});
        int[] pclassValues = df.stringVector (columnName).factorize (new NominalScale (values)).toIntArray ();
        return pclassValues;
    }

    private static void eda(DataFrame titanic) throws InterruptedException, InvocationTargetException {
        titanic.summary ();
        DataFrame titanicSurvived = DataFrame.of (titanic.stream ().filter (t -> t.get ("Survived").equals (1)));
        DataFrame titanicNotSurvived = DataFrame.of (titanic.stream ().filter (t -> t.get ("Survived").equals (0)));
        titanicNotSurvived.omitNullRows ().summary ();
        titanicSurvived = titanicSurvived.omitNullRows ();
        titanicSurvived.summary ();
        int size = titanicSurvived.size ();

        System.out.println ("the size of data is : "+size);
        Double averageAge = titanicSurvived.stream ()
                .mapToDouble (t -> t.isNullAt ("Age") ? 0.0 : t.getDouble ("Age"))
                .average ()
                .orElse (0);

        System.out.println ("Average age: "+averageAge.intValue ());
        Map map = titanicSurvived.stream ()
                .collect (Collectors.groupingBy (t -> Double.valueOf (t.getDouble ("Age")).intValue (), Collectors.counting ()));

        double[] breaks = ((Collection<Integer>) map.keySet ())
                .stream ()
                .mapToDouble (l -> Double.valueOf (l))
                .toArray ();

        int[] valuesInt = ((Collection<Long>) map.values ())
                .stream ().mapToInt (i -> i.intValue ())
                .toArray ();
  // DARAWING
        Histogram.of (titanicSurvived.doubleVector ("Age").toDoubleArray (), 15, false)
                .canvas ().setAxisLabels ("Age", "Count")
                .setTitle ("Age frequencies among surviving passengers")
                .window ();
        Histogram.of (titanicSurvived.intVector ("PClassValues").toIntArray (), 4, true)
                .canvas ().setAxisLabels ("Classes", "Count")
                .setTitle ("Pclass values frequencies among surviving passengers")
                .window ();
        //Histogram.of(values, map.size(), false).canvas().window();
        System.out.println (titanicSurvived.schema ());
        //////////////////////////////////////////////////////////////////////////

    }
}
