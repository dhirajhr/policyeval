import java.io.*;

/*
 * Writer Interface is currently is implemented by: 
 * FileWriter
 * ConsoleWriter
 */
public interface Writer {
	
	void write(String result) throws IOException;

}

class FileWriter implements Writer
{
	String outputPath = "";
	FileWriter(String outputPath)
	{
		this.outputPath = outputPath;
	}
	public void write(String result) throws IOException
	{
		PrintWriter printWriter = null;
		try {
	    printWriter = new PrintWriter (outputPath);
	    printWriter.println (result);
		}
		catch(Exception e)
		{
			System.out.println("[Writer Error]");
			System.out.println(e.getMessage());
		}
		finally {
	    printWriter.close ();
		}
	}
}



class ConsoleWriter implements Writer
{
	String outputPath = "";

	public void write(String result) throws IOException
	{
		System.out.println(result);
	}
}
