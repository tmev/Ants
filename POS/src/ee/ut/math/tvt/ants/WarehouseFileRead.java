package ee.ut.math.tvt.ants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WarehouseFileRead {
	
	public static ArrayList getWarehouseLine(String linenumber) throws IOException{
		FileInputStream fis = new FileInputStream("Warehouse.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		String line = null;
		
		while ((line = br.readLine()) != null){
			ArrayList linevalue = new ArrayList();
			linevalue.add(line.split(", "));
			if(linevalue.get(0).equals(linenumber)){
				br.close();
				return linevalue;
					
			}
		}
		br.close();
		System.out.println("No such product");
		return null;
	}
	
	
}

