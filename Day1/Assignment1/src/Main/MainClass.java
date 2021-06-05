package Main;


import java.util.List;
import PyramidExplore.Pyramid;
import PyramidExplore.PyramidCSVDAO;

public class MainClass {
	public static void main(String[] args) 
	{
		PyramidCSVDAO pDAO= new PyramidCSVDAO();
		//File x = new File();
		//System.out.println();
		//System.out.println(x.canRead());
		List<Pyramid> pyramids=pDAO.readPyramidsFromCSV("pyramids.csv");
		
		
		int i =0;
		for(Pyramid p :pyramids) 
		{
			System.out.println("#"+(i++)+ p);
		}
	}

}
