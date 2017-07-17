package app;

public class LibraryApp {
	final static String appVersion = "v0.8";
	final static String appName = "Biblioteka " + appVersion;
	public static void main(String[] args) {
		System.out.println(appName);
		LibraryControl libControl = new LibraryControl();
		libControl.controlLoop();
	}
}
