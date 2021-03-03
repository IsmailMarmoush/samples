package com.marmoush.javaexamples.servletspecs3.chp03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(description = "For uploading files", urlPatterns = { "/servletspecs3/chp03/UploadServlet" })
@MultipartConfig(location = "c:\\servletuploads", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 4252186345829960977L;

    private static String getFilename(Part part) {
	for (String cd : part.getHeader("content-disposition").split(";")) {
	    if (cd.trim().startsWith("filename")) {
		String filename = cd.substring(cd.indexOf('=') + 1).trim()
			.replace("\"", "");
		return filename.substring(filename.lastIndexOf('/') + 1)
			.substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	    }
	}
	return null;
    }

    @Override
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// Retrieves <input type="text" name="description">
	// String description = getValue(request.getPart("description"));

	// Retrieves <input type="file" name="file">
	Part filePart = request.getPart("file");

	String filename = getFilename(filePart);
	filePart.write(filename);
	// InputStream filecontent = filePart.getInputStream();
	// write the inputStream to a FileOutputStream
	// OutputStream out = new FileOutputStream(new File("c:\\" + filename));
	// int read = 0;
	// byte[] bytes = new byte[1024];
	//
	// while ((read = filecontent.read(bytes)) != -1) {
	// out.write(bytes, 0, read);
	// }
	//
	// filecontent.close();
	// out.flush();
	// out.close();
	// ... (do your job here)

    }

    // private static String getValue(Part part) throws IOException {
    // BufferedReader reader = new BufferedReader(new InputStreamReader(
    // part.getInputStream(), "UTF-8"));
    // StringBuilder value = new StringBuilder();
    // char[] buffer = new char[1024];
    // for (int length = 0; (length = reader.read(buffer)) > 0;) {
    // value.append(buffer, 0, length);
    // }
    // return value.toString();
    // }
}