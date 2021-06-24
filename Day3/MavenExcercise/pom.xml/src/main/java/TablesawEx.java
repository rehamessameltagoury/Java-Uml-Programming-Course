import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.joining.DataFrameJoiner;

public class TablesawEx {
	
	public static Table loadDataFromCVS(String path) throws IOException {
		Table titanicData=Table.read().csv("src/main/resources/data/titanic.csv");
		return titanicData;
	    }
	

	   public static void main(String[] args ) {
	       Table hrAnalytics  = null;
	       try {
	           hrAnalytics = loadDataFromCVS("src/main/resources/data/titanic.csv");
	           System.out.println("Printing the Summary of Dataframe");
	           System.out.println(hrAnalytics.summary());
	           System.out.println("=======================================================================");
	          // hrAnalytics=hrAnalytics.removeColumnsWithMissingValues();
	           NumberColumn age_min = hrAnalytics.numberColumn("age");
	           double min = age_min.min();
	           
	           System.out.println("Min Age value: "+min);
	           System.out.println("=======================================================================");
	           NumberColumn age_max = hrAnalytics.numberColumn("age");
	           double max = age_max.max();
	           
	           System.out.println("Max Age value: "+max);
	           System.out.println("=======================================================================");
	           NumberColumn age_std = hrAnalytics.numberColumn("age");
	           double std = age_max.standardDeviation();
	           
	           System.out.println("Std of Age: "+std);
	           System.out.println("=======================================================================");
	           
	           ////Adding a cloumn
	           List<Number> Money_they_have=new ArrayList<Number>();
	           NumberColumn age= (NumberColumn) hrAnalytics.column ("age");
	           for(double v:age) {
	            if (v > 20){
	            	Money_they_have.add(1000);
	            	
	            }
	            else {Money_they_have.add(500);}
	           }
	           DoubleColumn col = DoubleColumn.create("Money They have", Money_they_have);
	           hrAnalytics.addColumns(col);
	        System.out.println("Adding a column: ");
	        System.out.println(hrAnalytics.toString());
	        System.out.println("=======================================================================");
	        
	        System.out.println("Merging two dataframes: ");
	        Table hrAnalytics2 = loadDataFromCVS("src/main/resources/data/titanic.csv");
	        Table hrAnalytics3 = loadDataFromCVS("src/main/resources/data/titanic.csv");
	        //Table merge= hrAnalytics.concat(hrAnalytics2);
	        Table merge = hrAnalytics2.append(hrAnalytics3);
	        System.out.println(merge.toString());
	        System.out.println("=======================================================================");
	 
	       } catch (IOException e) {
	           e.printStackTrace ();
	       }


}
	   }
