import java.io.IOException;

import joinery.DataFrame;

public class joineryEx {
	  public static void main(String args[]){
	        try {
	            DataFrame<Object>  df= DataFrame.readCsv ("src/main/resources/data/titanic.csv")
	                    .retain("pclass","survived","name","sex","age",	"sibsp","parch","ticket","fare","cabin","embarked","boat","body","home.dest")
	                    .groupBy(row ->row.indexOf("age")).max();
	            System.out.println("The data of Maximum age is: ");
	            df.iterrows ().forEachRemaining (System.out::println);

	            System.out.println ("=========================================================================================");
	            DataFrame<Object>  df2= DataFrame.readCsv ("src/main/resources/data/titanic.csv")
	                    .retain("pclass","survived","name","sex","age",	"sibsp","parch","ticket","fare","cabin","embarked","boat","body","home.dest")
	                    .groupBy(row ->row.indexOf("age")).min();
	            System.out.println("The data of Minimum age is: ");
	            df2.iterrows ().forEachRemaining (System.out::println);

	            System.out.println ("=========================================================================================");
	            DataFrame<Object>  df3= DataFrame.readCsv ("src/main/resources/data/titanic.csv")
	                    .retain("pclass","survived","name","sex","age",	"sibsp","parch","ticket","fare","cabin","embarked","boat","body","home.dest")
	                    .stddev();
	            System.out.println("The Standard deviation of each column is: "); ///ask
	            df3.iterrows ().forEachRemaining (System.out::println);

	            System.out.println ("=========================================================================================");
	            DataFrame<Object>  df4=df2.join(df);
	            System.out.println("Joining df:'data of Maximum age' and df1:' data of Minimum age' ");
	            df4.iterrows ().forEachRemaining (System.out::println);
	            System.out.println ("=========================================================================================");
	            DataFrame<Object>  df5=df2.merge(df);
	            System.out.println("Merging df:'data of Maximum age' and df1:' data of Minimum age' ");
	            df5.iterrows ().forEachRemaining (System.out::println);
	            System.out.println ("=========================================================================================");
	            
	            System.out.println("Adding a column named money to the merged dataframes with value null");
	            DataFrame<Object>  df6= df5.add("Money");
	            
	            df6.iterrows ().forEachRemaining (System.out::println);
	            System.out.println ("=========================================================================================");
	            
	        } catch (IOException e) {
	            e.printStackTrace ();
	        }
	    }
}
