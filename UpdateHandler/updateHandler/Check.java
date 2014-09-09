/**
 * 
 */
package updateHandler;

import java.util.List;

import common.Main;
import Json.GetInstallInfo;
import Json.InstallInfo;
import Json.version;

/**
 * thread to check for update
 * 
 * @author IsaacWheeler
 */
public class Check implements Runnable {

	// String repstation of the installed version number
	private version currentInstalledVersions = new Json.version();
	// time in minutes (60,000 * mins = milliseconds)
	private static int mins;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		while (true) { // TODO: add better condition
			try {
				if (checkForUpdate()) {
					Main.print("Pannic, Pannic, There is a update");
				} else {
					Main.print("all is good no update");
				}
				Thread.sleep((60000 * mins));
			} catch (InterruptedException e) {
				Main.print("Error: " + e.getLocalizedMessage());
				e.printStackTrace();
				Main.exit(1);
			} catch (Exception e) {
				Main.print("Error: " + e.getLocalizedMessage());
				e.printStackTrace();
				Main.exit(1);
			}
		}

	}

	/**
	 * used for starting Check Thread
	 */
	public static void start(int setMins) {
		mins = setMins;
		(new Thread(new Check())).start();
	}

	/**
	 * checks for update
	 * 
	 * @return returns true if update is need false otherwise
	 * @throws Exception
	 */
	public boolean checkForUpdate() throws Exception {

		InstallInfo obj;
		obj = GetInstallInfo.JsonInfo();
		System.out.println(obj.version().get(0).toString());
		System.out.println(currentInstalledVersions.toString());
		if (obj.version().get(0).toString()
				.contentEquals(currentInstalledVersions.toString())) {
			return false;
		} else {
			currentInstalledVersions = obj.version().get(0);
			return true;
		}

	}
}
