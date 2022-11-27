import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		if (args == null || args[0].length() != 1) {
			System.out.println("Please provide a, r, ?, +, or c");
			return;
		}

		// Check arguments
		if (args[0].equals("a")) {

			System.out.println("Loading data ...");

			try {
				BufferedReader filestream = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String reader = filestream.readLine();
				String words[] = reader.split(",");
				for (String word : words) {
					System.out.println(word);
				}
			} catch (Exception e) {

			}

			System.out.println("Data Loaded.");

		}

		else if (args[0].equals("r")) {

			System.out.println("Loading data ...");

			try {
				BufferedReader filestream = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String reader = filestream.readLine();
				String words[] = reader.split(",");
				Random random = new Random();
				int randomIndex = random.nextInt(0, words.length);
				System.out.println(words[randomIndex]);
			} catch (Exception e) {

			}
			System.out.println("Data Loaded.");

		}

		else if (args[0].contains("+")) {

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

		else if (args[0].contains("?")) {

			System.out.println("Loading data ...");

			try {

				BufferedReader filestream = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String reader = filestream.readLine();
				String words[] = reader.split(",");
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

		else if (args[0].contains("c")) {

			System.out.println("Loading data ...");

			try {
				BufferedReader filestream = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String reader = filestream.readLine();
				char characters[] = reader.toCharArray();
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
}