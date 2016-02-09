package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GzipManager {
	
	public static boolean isGzipSupported (HttpServletRequest request) {
		String encodings = request.getHeader("Accept-Encoding");
	    boolean gzipSupported = ((encodings != null) && (encodings.indexOf("gzip") != -1));
		if (gzipSupported) {
			System.out.println("[GzipManager] - Encoding 'gzip' supported.");
		} else {
			System.out.println("[GzipManager] - Encoding 'gzip' unsupported.");
		}
		return gzipSupported;
	}
	
	public static boolean isGzipDisabled(HttpServletRequest request) {
		String flag = request.getParameter("disableGzip");
		boolean gzipDisabled = ((flag != null) && (!flag.equalsIgnoreCase("false")));
		if (gzipDisabled) {
			System.out.println("[GzipManager] - Encoding 'gzip' disabled.");
		} else {
			System.out.println("[GzipManager] - Encoding 'gzip' enabled.");
		}
		return gzipDisabled;
	}
	
	public static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException {
		System.out.println("[GzipManager] - GZIPOutputStream Initialized.");
		return(new PrintWriter(new GZIPOutputStream(response.getOutputStream())));
	}
}
