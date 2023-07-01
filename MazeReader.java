import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MazeReader {
	
	public static int[][] readFile(String txtname) throws IOException {
		
        FileReader searchreader = new FileReader(txtname);
		BufferedReader bf = new BufferedReader(searchreader);
		String line;
		ArrayList <String> arr = new ArrayList<>();
		int rowlength = 0;
		int columnlength = 0;
		while ((line = bf.readLine()) != null)
		{ 
			arr.add(line);
			columnlength = line.length();
		}
		bf.close();
		rowlength = arr.size();
		
		int[][] maze = new int[rowlength][columnlength];
		
		FileReader searchreader2 = new FileReader(txtname);
		BufferedReader bf2 = new BufferedReader(searchreader2);
		String line2; char ch; int i = 0;
		
		while ((line2 = bf2.readLine()) != null)
		{ 
			for (int j = 0; j < columnlength; j++) 
			{
				ch = line2.charAt(j);
				if (ch == '#') 
				{
					maze[i][j] = 1;
				}
				else 
				{
					maze[i][j] = 0;
				}
			}
			i++;
		}
		bf2.close();
		return maze;
    }

}
