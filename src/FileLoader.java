import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
	
	private ArrayList<Metadata> metadata = new ArrayList<Metadata>();
	private ArrayList<Move> loadedMoves = new ArrayList<Move>();
	private String path;
	public FileLoader(String path)
	{
		this.path = path;
		loadFile();
	}
	
	
	
	public ArrayList<Metadata> getMetadata()
	{
		return metadata;
	}
	
	public ArrayList<Move> getMoves()
	{
		return loadedMoves;
	}
	
	private void loadFile()
	{
		ArrayList<String> moveInstructions;
		Scanner loadedFile = genScanner();
        String data;
        boolean hasBegun = false;
		moveInstructions = new ArrayList<String>();
        
		 while (loadedFile.hasNextLine()) {

		        data = loadedFile.nextLine();
		        if (!data.isEmpty())
		        {
		        	if (data.charAt(0) == '#')
			        	readMetadata(data);
			        else
			        {
			        	if (data.contains("$"))
			        	{
			        		moveInstructions = new ArrayList<String>();
			        		moveInstructions.add(data);
			        	}			        	
			        	
			        	if (data.charAt(0) == '%')
			        	{
			        		loadedMoves.add(translateLine(moveInstructions));	

			        	}
			        	else
			        	{
			        		moveInstructions.add(data);
			        	}
			        	
			        }
		        }
		        
		      }
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
	
	private Move translateLine(ArrayList<String> instructions)
	{
		String info = "";
		for(String item: instructions)
		{
			if(item.charAt(0) != '$' && item.charAt(0) != '%')
			{
				info = info + item;
			}
		}
		Move out = new Move(Integer.parseInt(instructions.get(0).replace("$", "")), info);
		
		return out;
		
	}

	private void readMetadata(String line)
	{
		//puts Metadata in Metadata Objects
		metadata.add(new Metadata(line.split(":")[0].replace("#", ""), line.split(":")[1]));
	}
	
	
	

}
