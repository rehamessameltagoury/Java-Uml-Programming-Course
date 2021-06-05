package PyramidExplore;

import java.util.List;


public interface PyramidDAO {
	//public void PyramidCSVDAO();
	//public Pyramid createPyramid(String[] metadata);
	List<Pyramid> readPyramidsFromCSV(String fileName);

}
