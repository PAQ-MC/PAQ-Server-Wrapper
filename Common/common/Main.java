package common;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * 
 */

/**
 * Main class for starting the program
 * 
 * @author Isaac Wheeler
 * 
 */
public class Main {
	
	// String for location of installer info
	public static String mod;
	// String to decide which version to use
	public static String version;
	// String to decide instance name
	public static String instanceName;
	// log file printer
	static PrintWriter out;

	/**
	 * Program Start location
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Setting up Log File
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		try {
			out = new PrintWriter(new FileWriter("PAQlog "
					+ dateFormat.format(date) + ".txt"), true);
		} catch (IOException e) {
			print(e.getMessage());
			e.printStackTrace();
			exit(1);
		}
		print("Current System os is : "
				+ System.getProperty("os.name").toLowerCase());
		
		// reading argments

				OptionParser parser = new OptionParser("m::v::h::i");
				OptionSet options = parser.parse(args);


				if (options.has("m")) {
					mod = (String) options.valueOf("m");
					print((String) options.valueOf("m"));
				} else{
					mod = "http://mage-tech.org/PAQ/versioninfo.json";
					print(mod);
				}
				if (options.has("v")) {
					version = (String) options.valueOf("v");
					print((String) options.valueOf("v"));
				}
				if (options.has("i")) {
					instanceName = (String) options.valueOf("i");
					print((String) options.valueOf("i"));
				} else {
					instanceName = "PAQ";
				}
				
				
				
	}

	/**
	 * main print class for use with logger
	 * 
	 * @param msg
	 *            the message you want printed
	 */
	public static void print(String msg) {
		System.out.println(msg);
		out.println(msg);
		out.flush();
	}

	/**
	 * main exit class closes log file before exiting
	 * 
	 * @param status
	 *            if program is exiting with error or not
	 */
	public static void exit(int status) {
		out.close();
		System.exit(status);
	}

	/**
	 * message box pop up
	 * 
	 * @param infoMessage
	 *            message that you want shown
	 * @param location
	 *            location that it is called from (not used often)
	 */
	public static void infoBox(String infoMessage, String location) {
		JOptionPane.showMessageDialog(null, infoMessage,
				"InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
	}

}
