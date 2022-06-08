import java.io.*;
public class Generator  {
	FileReader file;
	BufferedReader buffer;
	String input;
	String rand_word;
	private String[] lst;
	int random_idx;

	Generator(String filename, String[] lst) throws IOException{
		try {
			this.lst = lst;
			file = new FileReader(filename);
			buffer = new BufferedReader(file);
			for (int i = 0; i < lst.length; i++) {
				lst[i] = buffer.readLine();
			}
			this.random_idx = (int)(Math.random() * lst.length);
			String random_word = lst[random_idx];
			this.rand_word = random_word;
		}	
		catch (FileNotFoundException e) {
			System.out.println("file reading");
		}
		catch (IOException er) {
			System.out.println("error");
		}
	}
	public String getRandom() {
		return rand_word;
	}
	
	// put these blocks of code inside the easy mode and hard mode files
//	public static void main(String[] args) {
//		try {
//			// 5 letter word
//			String[] words5 = new String[586];
//			Generator five = new Generator("src/5LetterKeyWords.txt", words5);
//			System.out.println(five.getRandom());
//			
//			// 7 letter word
//			String[] words7 = new String[500];
//			Generator seven = new Generator("src/7LetterKeyWords.txt", words7);
//			System.out.println(seven.getRandom());
//		}
//		catch (FileNotFoundException e) {
//			System.out.println("file reading");
//		}
//		catch (IOException er) {
//			System.out.println("error");
//		}
//	}
}
