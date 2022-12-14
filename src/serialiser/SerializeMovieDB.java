package serialiser;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a serializer for our movie DB
 */
public class SerializeMovieDB {
	/**
	 * Reads the information from our movie DB given a specific byte file
	 * @param filename byte file
	 * @return the arrayList of objects read from the byte file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List readSerializedObject(String filename) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(fis);
		List pDetails = (ArrayList) in.readObject();
		in.close();
		return pDetails;
	}

	/**
	 * Writes the information from an arrayList and stores it in a byte file
	 * @param filename a byte file
	 * @param list containing object list to be stored
	 * @throws IOException
	 */
	public static void writeSerializedObject(String filename, List list) throws IOException{
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(list);
		out.close();
    }
}
