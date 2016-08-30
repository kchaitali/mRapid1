package com.capgemini.mf2hadoop;

import java.io.File;
import java.util.List;

import com.capgemini.mf2hadoop.domain.Field;
import com.capgemini.mf2hadoop.mfreader.MFDataReader;
import com.capgemini.mf2hadoop.parser.MFCopyBookParser;
import com.capgemini.mf2hadoop.reader.MFCopyBookReader;
import com.capgemini.mf2hadoop.reader.MFDataFileReaderWriter;

public class Mf2HadoopHDFS {
	public static void main(String[] args) throws Exception {
//		String layoutFileName = "gpdcgim.incl.txt";
//		String mfDataFileName="GPFCGIM_POC_PARTIAL.DAT";
//		String outputFileName="mf.txt";

		
		String layoutFileName = args[0];
		String mfDataFileName=args[1];
		String outputFileName=args[2];
		
		
		//Read the MF layout (copybook file)
		System.out.println(layoutFileName + " :: " + mfDataFileName + " :: " + outputFileName);
		MFCopyBookReader reader = new MFCopyBookReader();
		System.out.println(" here 1");
		StringBuffer layoutFileBuffer = reader.readLayoutFile(layoutFileName);
		System.out.println(" here 2");
		//Parse the read layout file to retrieve the field list
		MFCopyBookParser parser = new MFCopyBookParser();
		System.out.println(" here 3");
		List<Field> fieldList = parser.parseLayoutFile(layoutFileBuffer);
		System.out.println(" here 4");
		System.out.println("mfDataFileName"+mfDataFileName);
		System.out.println("outputFileName"+outputFileName);
		File file = new File("mfDataFileName");
		file.setExecutable(false);
        file.setReadable(false);
        file.setWritable(true);
        file.setExecutable(true, false);
        file.setReadable(true, false);
        file.setWritable(true, false);
		MFDataFileReaderWriter mfDataFileReaderWriter = new MFDataFileReaderWriter(mfDataFileName, outputFileName);
		System.out.println(" here 5");
		//Read the data from the mainframe ebcdic file
		MFDataReader mfReader = new MFDataReader();
		System.out.println(" here 6");
		mfReader.readData(fieldList, mfDataFileReaderWriter);
		System.out.println(" here 7");
		System.out.println("here 8");
		mfDataFileReaderWriter.closeFileStreams();
		
		
	}
}
