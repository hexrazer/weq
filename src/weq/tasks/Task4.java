package weq.tasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task4 {
	public static void main(String[] args) {
		String content = "abc";
		boolean res = writeContextToFile(content);
		if (res) {
			System.out.println("String data has been written to the file...");
		} else {
			System.out.println("Something went wrong...");
		}
	}

	public static boolean writeContextToFile(String content) {
		File myFile = new File("abc.txt");// file will be created in current working directory
		try {
			if (myFile.createNewFile()) {
				System.out.println("The file " + myFile.getName() + " has been created successfully");
			} else {
				System.out.println("The file " + myFile.getName() + " is already created/exists");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Absoluted path of the " + myFile.getName() + " is " + myFile.getAbsolutePath());
		FileWriter myFileWriter;
		try {
			myFileWriter = new FileWriter(myFile);
			myFileWriter.write(content);
			myFileWriter.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}
}
