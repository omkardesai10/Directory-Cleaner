import java.lang.*; 
// For collection framework 
import java.util.*; 
// Fore directory traversal 
import java.io.*; 
// For file reading 
import java.io.FileInputStream;  

class Demo 
{ 
	public static void main(String arg[]) throws Exception 
	{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Please enter directory name"); 
		String dir = br.readLine(); 
		
		Cleaner cobj = new Cleaner(dir);
		
		// To remove empty files 
		cobj.CleanDirectoryEmptyFile();
	}
} 

class Cleaner 
{ 
	public File fdir = null; 
	
	public Cleaner(String name) 
	{ 
		// Check the existance of directory 
		fdir = new File(name); 
		
		if(!fdir.exists()) 
		{ 
			System.out.println("Invalid Directory name"); 
			System.exit(0); 
		} 
	} 
	
	public void CleanDirectoryEmptyFile() 
	{ 
		File filelist[] = fdir.listFiles(); 
		int EmptyFile = 0; 
		
		for(File file : filelist) 
		{ 
			if(file.length() == 0) 
			{ 
				System.out.println("Empty file name : "+file.getName()); 
				if(file.delete()) 
				{ 
					EmptyFile++;
				} 
				else 
				{ 
					 System.out.println("Unable to delete"); 
				} 
			} 
		} 
		System.out.println("Total empty files deleted : "+ EmptyFile); 
 	} 
 
}