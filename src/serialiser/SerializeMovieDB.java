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
	 * @param filename, byte file
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
	 * Writes the information from an arrayList and
	 * @param filename
	 * @param list
	 * @throws IOException
	 */
	public static void writeSerializedObject(String filename, List list) throws IOException{
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(list);
		out.close();
    }

	public static double [] readSerializedArray(String filename) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(fis);
		double [] pDetails = (double []) in.readObject();
		in.close();
		return pDetails;
	}

	public static void writeSerializedArray(String filename, double [] arr) throws IOException{
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(arr);
		out.close();
    }
}
