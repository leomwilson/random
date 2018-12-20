import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String[] args) throws Exception {
		String s = "Hello, World!"; // The string to search
		String r = "e[a-z][a-z]o"; // The regex to use (see https://regexr.com/)
		boolean useF = true; // set to true if the input should be a file
		String fPath = "src/legit_in.txt"; // the path of the file to read from
		
		if(useF) {
			s = read(fPath);
		}
		boolean found = false;
		Pattern p = Pattern.compile(r);
		Matcher m = p.matcher(s.toLowerCase());
		System.out.println("Searching input for pattern: " + p.pattern());
		while(m.find()) {
			System.out.println("- Found a match at position " + m.start() + ": " + s.substring(m.start(), m.end()));
			found = true;
		}
		System.out.println("No " + ((found)?"more ":"") + "matches found.");
	}
	
	public static String read(String fileName) throws Exception { 
		String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get(fileName))); 
	    return data; 
	}

}
