import java.nio.file.*;
import java.util.*;

/*
 * Reader Interface is currently implemented by:
 * FileReader
 * ConsoleReader
 */
public interface Reader {
	
	public Map<String,String> read();
}

class FileReader implements Reader
{
	String filePath = "";
	FileReader(String filePath)
	{
		this.filePath = filePath;
	}
	public Map<String,String> read() 
	{
		Map<String, String> inputMap = new HashMap<String, String>();
	    Path path = Paths.get(filePath);
	    
	    try {
	    List<String> lines = Files.readAllLines(path);
	    for(String line:lines)
	    {
	    	String[] keyVal = line.split("=");
	    	String key = keyVal[0].trim();
	    	String val = keyVal[1].trim();
	    	inputMap.put(key,val);
	    }
	    return inputMap;
	    }
	    catch(Exception e)
	    {
	    	System.out.println("[Reader Error]");
	    	System.out.println(e.getMessage());
	    }
	    	
	   return null;
	}
	
}
	class ConsoleReader implements Reader
	{

		public Map<String,String> read()
		{
			Map<String, String> inputMap = new HashMap<String, String>();
			Scanner ob = null;
			try
			{
			ob = new Scanner(System.in);			
			System.out.println("Name:");
			inputMap.put("personName",ob.nextLine());

			System.out.println("WorksFor:");
			inputMap.put("worksFor",ob.nextLine());
			
			System.out.println("NeedsAccessTo:");
			inputMap.put("needsAccessTo",ob.nextLine());
			
			System.out.println("RequestedTime:");
			inputMap.put("requestedTime",ob.nextLine());
			return inputMap;
			}
		    catch(Exception e)
		    {
		    	System.out.println("[Reader Error]");
		    	System.out.println(e.getMessage());
		    }
			finally {
		    ob.close();	
			}
		   return null;
		}
	}
