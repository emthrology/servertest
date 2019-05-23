package ajax.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AjaxDao {
	private Properties prop = new Properties();
	public AjaxDao(){
		String fileName = AjaxDao.class.getResource("/sql/ajax/ajaxQuery.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("AjaxDao : cannot found properties");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
