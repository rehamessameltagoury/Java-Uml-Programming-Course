package PyramidExplore;


import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PyramidCSVDAO implements PyramidDAO {
	
    @Override
	public List<Pyramid> readPyramidsFromCSV(String path) {
		// TODO Auto-generated method stub
		// Read a file
		 List<Pyramid> PyramidData=new  ArrayList<>();
	        try {
	            Scanner scan=new Scanner(new File(path));
	            if(scan.hasNextLine()) scan.nextLine();
	           while( scan.hasNextLine()){ 
	              String line=scan.nextLine();
	              String [] parts=line.split(",");
	              
	              double h=Double.parseDouble(parts[7]);
	              //System.out.println(parts[7]);
	              Pyramid p=new Pyramid(parts[0],parts[2],parts[4],h);
	              PyramidData.add(p);
	           }
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return PyramidData;
	}


}
