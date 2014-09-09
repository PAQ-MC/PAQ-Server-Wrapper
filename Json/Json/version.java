/*
This work is licensed under the Creative Commons
Attribution-NonCommercial 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/3.0/.
*/

/***
	Created By Isaac Wheeler
*/

package Json;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class version{

	private int major;
	private int minor;
	private int build;

	public version(){
		major = 0;
		minor = 0;
		build = 0;
	}
	
	@Override
	public String toString() {
		return major + "." + minor + "."
				+ build;
	}

	public int major() {
		return major;
	}
	
	public int minor() {
		return minor;
	}
	
	public int build() {
		return build;
	}
	
	public void setMajor(int newMajor){
		major = newMajor;
	}
	
	public void setMinor(int newMinor){
		minor = newMinor;
	}
	
	public void setBuild(int newBuild){
		build = newBuild;
	}

}
