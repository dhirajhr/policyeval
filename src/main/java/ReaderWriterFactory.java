//Factory Pattern

/*
 * If the user specifies a single argument, input and output are to be displayed on the console.
 * If the user specifies three arguments, args[0]- policy file, args[1]- Input File Path, args[2]- Output file path
 * 
 */
public class ReaderWriterFactory {
	
	Reader getReader(String[] args)
	{
		return args.length == 1? new ConsoleReader() : new FileReader(args[1]);
	}
	
	Writer getWriter(String[] args)
	{
		return args.length == 1? new ConsoleWriter() : new FileWriter(args[2]);
	}

}
