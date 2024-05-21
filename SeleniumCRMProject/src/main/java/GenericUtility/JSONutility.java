package GenericUtility;


import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONutility {
	public String getDataFromJsonFile(String key) throws Throwable, ParseException 
	{
		FileReader fr=new FileReader("./configAPPData/commondata.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject map=(JSONObject) obj;
		String data=(String)map.get(key);
		return data;
		
	}

}
