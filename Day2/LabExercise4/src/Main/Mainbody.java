package Main;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import PyramidExplore.Pyramid;
import PyramidExplore.PyramidCSVDAO;

public class Mainbody {
	public static void main(String[] args)
	{
		PyramidCSVDAO pDAO= new PyramidCSVDAO();
		List<Pyramid> pyramids=pDAO.readPyramidsFromCSV("pyramids.csv");
		int len_pyramids=pyramids.size();
		int median=len_pyramids/2;
		int first_quartile=median/2;
		int second_quartile=median+first_quartile;
		//System.out.println(second_quartile);
		//pyramids.stream().forEach(System.out::print);
		// getting the median of the pyramids
		Function<Pyramid,Double> f=(p)-> {return p.getHeight();} ; // map function to select heights only
		Double median_value=pyramids.stream().sorted((o1,o2) ->{return (int) (o1.getHeight()-o2.getHeight());}).map(f).collect(Collectors.toList()).get(median);// ascending to make it desc flip the -ve
		System.out.println("The value of the median is "+median_value);
		Double first_quart=pyramids.stream().sorted((o1,o2) ->{return (int) (o1.getHeight()-o2.getHeight());}).map(f).collect(Collectors.toList()).get(first_quartile);//first quartile
		System.out.println("The value of the first Quartile is "+first_quart);
		Double second_quart=pyramids.stream().sorted((o1,o2) ->{return (int) (o1.getHeight()-o2.getHeight());}).map(f).collect(Collectors.toList()).get(second_quartile);// Second Quartile
		System.out.println("The value of the Second Quartile is "+second_quart);
		//mean
		Function<Pyramid,Double> f2=(p)-> {return p.getHeight();} ;
		Double mean=pyramids.stream().sorted((o1,o2) ->{return (int) (o1.getHeight()-o2.getHeight());}).mapToDouble((p)-> {return p.getHeight();}).sum();//Mean
		System.out.println("The value of the Mean is "+mean/len_pyramids);
	}

}
