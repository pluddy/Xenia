package managers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class GzipManager {
	
	final static Logger log = Logger.getLogger(GzipManager.class.getName());
	
	public static boolean isGzipSupported (HttpServletRequest request) {
		String encodings = request.getHeader("Accept-Encoding");
	    boolean gzipSupported = ((encodings != null) && (encodings.indexOf("gzip") != -1));
		if (gzipSupported) {
			log.info("Encoding 'gzip' supported.");
		} else {
			log.info("Encoding 'gzip' unsupported.");
		}
		return gzipSupported;
	}
	
	public static boolean isGzipDisabled(HttpServletRequest request) {
		String flag = request.getParameter("disableGzip");
		boolean gzipDisabled = ((flag != null) && (!flag.equalsIgnoreCase("false")));
		if (gzipDisabled) {
			log.info("Encoding 'gzip' disabled.");
		} else {
			log.info("Encoding 'gzip' enabled.");
		}
		return gzipDisabled;
	}
	
	public static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException {
		log.info("GZIPOutputStream Initialized.");
		return(new PrintWriter(new GZIPOutputStream(response.getOutputStream())));
	}
}
