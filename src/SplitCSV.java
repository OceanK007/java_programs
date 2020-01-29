import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;

public class SplitCSV 
{
	public static void main(String[] args) 
	{
		String sourcePath = "C:/Users/kanthaku1/Documents/CSV/CSV_MAIN.csv";
		String targetPath = "C:/Users/kanthaku1/Documents/CSV/";
		readAndCreateFile(sourcePath, targetPath, 25);
	}
	
	public static void readAndCreateFile(String sourcePath, String targetPath, Integer recordCount)
	{
		BufferedReader br;
		OutputStream os = null;
		
		try
		{
			int count = 1;
			int lineCount = 1;
			br = new BufferedReader(new FileReader(sourcePath));
			os = new FileOutputStream(targetPath+"CSV_SPLIT"+count+".csv");
			String line = br.readLine();
			String content = "";
			
			while(line != null)
			{
				//content = content + line + "\n";
				if(lineCount <= recordCount && (line != null && line.trim() != null && !line.trim().equals("")))
				{
					content = content + line + "\n";
					line = br.readLine();
				}
				else
				{
					content = "";
					lineCount = 0;
					count++;
					os = new FileOutputStream(targetPath+"CSV_SPLIT"+count+".csv");
				}
				
				if(!content.isEmpty())
				{
					os.write(content.getBytes());
					content = "";
				}
				lineCount++;
			}
			
			br.close();
			os.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
