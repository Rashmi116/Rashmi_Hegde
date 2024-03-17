package com.edge.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileDemo {

	public static void main(String[] args) {
		
		System.out.println("file starting starts");
		long startTime=System.currentTimeMillis();

		InputStream rd = null;
		OutputStream wt = null;
		
		//Buffer i/o
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		File fl=new File("D:\\C376\\background.jpg");
		System.out.println("is folder"+fl.isDirectory());
		System.out.println("is file"+fl.isFile());
		System.out.println("is readable"+fl.canRead());
		System.out.println("is writable"+fl.canWrite());
		File file2=new File("D:\\C376\\myfolder");
		System.out.println("is folder"+file2.isDirectory());
		file2.mkdir();
		file2.delete();
		try {
			rd = new FileInputStream(fl);
			wt = new FileOutputStream("D:\\C376\\newImg.jpg");
			bis=new BufferedInputStream(rd);
			bos=new BufferedOutputStream(wt);
			try {
				int a = 0;
				while (a != -1) {
					a = bis.read();
					bos.write(a);

				}
				System.out.println();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		long endTime=System.currentTimeMillis();
		long timeDuration=endTime-startTime;
		System.out.println(timeDuration);


		System.out.println("file copied successfully");

	}
}
