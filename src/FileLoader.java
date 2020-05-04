import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
	
	private ArrayList<Metadata> metadata = new ArrayList<Metadata>();
	private String path;
	public FileLoader(String path)
	{
		this.path = path;
	}
	
	public ArrayList<Move> loadFile()
	{
		ArrayList<Move> loadedMoves = new ArrayList<Move>();
		Scanner loadedFile = genScanner();
        String data;
        int lineCount = 0;
        
		 while (loadedFile.hasNextLine()) {
		        data = loadedFile.nextLine();
		        if (lineCount < 11 && data.charAt(0) == '#')
		        	readMetadata(data);
		        else
		        	loadedMoves.add(translateLine(data, lineCount));
		      }
			 
		return loadedMoves;
	}
	
	public ArrayList<Metadata> getMetadata()
	{
		return metadata;
	}
	
	private Scanner genScanner()
	{
		Scanner fileReader = null;
		try {
		      File fileToLoad = new File(path);
		      fileReader = new Scanner(fileToLoad);
		    } catch (FileNotFoundException e) {
		      System.out.println("File was not Found!");
		      e.printStackTrace();
		    }
		return fileReader;
	}
	
	private Move translateLine(String line, int lineNr)
	{
		
		return null;
		
	}

	private void readMetadata(String line)
	{
		//puts Metadata in Metadata Objects
		metadata.add(new Metadata(line.split(":")[0].replace("#", ""), line.split(":")[1]));
	}
	
	

}
