package Tools;

import java.io.*;

/**
 * this is used to get configurations from document by vehicle's type
 * 
 * @author qutong
 * 
 */
public class Configurations {
	/**
	 * 
	 * @param type
	 *            vehicle's type
	 * @return integrate array with length,width,speed,accelerate
	 * @throws IOException
	 */
	public static int[] readConfiguration(String type) throws IOException {
		int[] configurations = new int[4];
		String content = null, read;
		BufferedReader reader;
		String[] lineData = new String[5];
		int[] details = new int[4];
		File f = new File("configuration.txt");

		reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(f)));
		while ((read = reader.readLine()) != null) {
			content = content + read;
		}

		lineData = content.split(";");
		if (type == "car") {
			configurations[0] = Integer.parseInt(((lineData[1].split(",")[1])));
			configurations[1] = Integer.parseInt(((lineData[1].split(",")[2])));
			configurations[2] = Integer.parseInt(((lineData[1].split(",")[3])));
			configurations[3] = Integer.parseInt(((lineData[1].split(",")[4])));
		} else if (type == "coach") {
			configurations[0] = Integer.parseInt(((lineData[2].split(",")[1])));
			configurations[1] = Integer.parseInt(((lineData[2].split(",")[2])));
			configurations[2] = Integer.parseInt(((lineData[2].split(",")[3])));
			configurations[3] = Integer.parseInt(((lineData[2].split(",")[4])));
		} else if (type == "bus") {
			configurations[0] = Integer.parseInt(((lineData[3].split(",")[1])));
			configurations[1] = Integer.parseInt(((lineData[3].split(",")[2])));
			configurations[2] = Integer.parseInt(((lineData[3].split(",")[3])));
			configurations[3] = Integer.parseInt(((lineData[3].split(",")[4])));
		} else if (type == "priority") {
			configurations[0] = Integer.parseInt(((lineData[4].split(",")[1])));
			configurations[1] = Integer.parseInt(((lineData[4].split(",")[2])));
			configurations[2] = Integer.parseInt(((lineData[4].split(",")[3])));
			configurations[3] = Integer.parseInt(((lineData[4].split(",")[4])));
		}
		else if (type == "ConjuctionSpeed") {
			configurations[0] = Integer.parseInt(((lineData[6].split(",")[1])));
			configurations[1] = Integer.parseInt(((lineData[6].split(",")[2])));
			configurations[2] = Integer.parseInt(((lineData[6].split(",")[3])));
			configurations[3] = Integer.parseInt(((lineData[6].split(",")[4])));
		}else {
			System.out.println("No configuration information about : " + type
					+ "!!");
		}
//		System.out.println("Lenght: " + configurations[0] + "\nWidth: "
//				+ configurations[1] + "\nSpeed: " + configurations[2]
//				+ "\nAccelerate: " + configurations[3]);
		return configurations;

	}

	public static double PerformPossibility() throws IOException {
		double p;
		String content = null, read;
		BufferedReader reader;
		String[] lineData = new String[6];
		int[] details = new int[4];
		File f = new File("configuration.txt");
		reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(f)));
		while ((read = reader.readLine()) != null) {
			content = content + read;
		}

		lineData = content.split(";");

		p = Double.parseDouble(lineData[5].split(",")[1]);
		return p;
	}

	public static void main(String[] args) throws IOException {
		Configurations c = new Configurations();
		// c.readConfiguration("car");
		System.out
				.println("perform possibility is : " + c.PerformPossibility());
	}
}