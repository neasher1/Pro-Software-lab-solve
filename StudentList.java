import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		if (args == null || args[0].length() != 1) {
			System.out.println("Please provide a, r, ?, +, or c");
			return;
		}

		Constants obj = new Constants();

		// Every operation requires us to load the student list.
		String fileContents = LoadData(Constants.StudentList);

		// Check arguments
		if (args[0].equals(obj.ShowAll)) {

			System.out.println("Loading data ...");

			try {
				String words[] = fileContents.split(",");
				for (String word : words) {
					System.out.println(word);
				}
			} catch (Exception e) {

			}

			System.out.println("Data Loaded.");

		}

		else if (args[0].equals(obj.ShowRandom)) {

			System.out.println("Loading data ...");

			try {
				String words[] = fileContents.split(",");
				Random random = new Random();
				int randomIndex = random.nextInt(0, words.length);
				System.out.println(words[randomIndex]);
			} catch (Exception e) {

			}
			System.out.println("Data Loaded.");

		}

		else if (args[0].contains(obj.AddEntry)) {

			System.out.println("Loading data ...");

			try {
				BufferedWriter filestream = new BufferedWriter(
						new FileWriter("students.txt", true));
				String argValue = args[0].substring(1);
				Date date = new Date();
				String dateFormateObj = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateFormateObj);
				String formateDate = dateFormat.format(date);
				filestream.write(", " + argValue + "\nList last updated on " + formateDate);
				filestream.close();
			} catch (Exception e) {

			}

			System.out.println("Data Loaded.");

		}

		else if (args[0].contains(obj.FindEntry)) {

			System.out.println("Loading data ...");

			try {
				String words[] = fileContents.split(",");
				// boolean done = false;
				String argValue = args[0].substring(1);

				int indexLocation = -1;
				for (int idx = 0; idx < words.length; idx++) {
					if (words[idx].trim().equals(argValue)) {
						indexLocation = idx;
						break;
					}
				}

			} catch (Exception e) {

			}

			System.out.println("Data Loaded.");

		}

		else if (args[0].contains(obj.ShowCount)) {

			System.out.println("Loading data ...");

			try {
				char characters[] = fileContents.toCharArray();
				boolean in_word = false;
				int count = 0;

				for (char character : characters) {
					if (character == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}

				System.out.println(count + " word(s) found " + characters.length);

			} catch (Exception e) {

			}

			System.out.println("Data Loaded.");

		}
	}

	public static String LoadData(String fileName) {
		BufferedReader fileStream = null;
		try {
			fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		String reader = null;
		try {
			reader = fileStream.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return reader;
	}

}
