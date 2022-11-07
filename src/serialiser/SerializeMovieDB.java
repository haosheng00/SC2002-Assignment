package serialiser;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class SerializeMovieDB {

	public static List readSerializedObject(String filename) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(fis);
		List pDetails = (ArrayList) in.readObject();
		in.close();
		return pDetails;
	}
	public static void writeSerializedObject(String filename, List list) throws IOException{
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(list);
		out.close();
    }
}
