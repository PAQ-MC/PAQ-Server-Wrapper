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
	private List<version> currentInstalledVersions;

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
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				Main.print(e.getMessage());
				Main.exit(1);
			} catch (Exception e) {
				Main.print(e.getMessage());
				Main.exit(1);
			}
		}

	}

	/**
	 * used for starting Check Thread
	 */
	public static void start() {
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
		if (obj.version().toString() == currentInstalledVersions.toString()) {
			return false;
		} else {
			currentInstalledVersions = obj.version();
			return true;
		}

	}
}
