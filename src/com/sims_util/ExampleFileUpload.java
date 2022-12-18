package com.sims_util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sims_models.Timetables;
import com.sims_service.TimetableDao;

public class ExampleFileUpload {

	static Timetables timetable = null;

	public static Timetables getFilePathName(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		int teacherID = TimetableDao.getLoggedInTeacherID(username);

		File file;
		final String filePath;
		final int maxFileSize = 100 * 1024;
		final int maxMemSize = 4 * 1024;
		String filePathName = null;
		String fileName = null;
		String year = null, grade = null, className = null;

		filePath = "C:\\Users\\layan\\Documents\\Coding\\OOP\\online-school-sys\\WebContent\\uploads\\timetables\\";

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List<FileItem> fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator<FileItem> i = fileItems.iterator();

			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();

				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();

					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						filePathName = filePath + fileName.substring(fileName.lastIndexOf("\\"));
						file = new File(filePathName);
					} else {
						filePathName = filePath + fileName.substring(fileName.lastIndexOf("\\") + 1);
						file = new File(filePathName);
					}
					fi.write(file);

				} else {
					if (fi.getFieldName().equals("year")) {
						year = fi.getString();
					} else if (fi.getFieldName().equals("grade")) {
						grade = fi.getString();
					} else if (fi.getFieldName().equals("class")) {
						className = fi.getString();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		int finalYear, finalGrade;
		finalGrade = Integer.parseInt(grade);
		finalYear = Integer.parseInt(year);
	
		timetable = new Timetables(teacherID, finalYear, finalGrade, className, fileName);

		return timetable;
	}
}
