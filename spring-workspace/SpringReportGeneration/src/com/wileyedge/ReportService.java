package com.wileyedge;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReportService {
	private String filename;
	private PrintWriter writer;
	
	public ReportService() {
		System.out.println("Inside Default Constructore of ReportService");
	}

	public void setFilename(String filename) {
		System.out.println("Inside setFilename() of ReportService");
		this.filename = filename;
	}
	
	public void generateReport() {
		System.out.println("Generating Report");
		this.writer.write("Generating Report");
	}

	public void close() {
		System.out.println("Inside destroy method");
		this.writer.close();
	}
	public void setWriter(PrintWriter writer) {
		System.out.println("Inside setWriter() of ReportService");
		this.writer = writer;
	}
	
	public void doInit() {
		System.out.println("Inside doInit() of ReportService");
		try {
			this.writer=new PrintWriter(filename);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}