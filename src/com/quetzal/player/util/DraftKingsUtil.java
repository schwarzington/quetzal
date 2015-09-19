package com.quetzal.player.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class DraftKingsUtil {

		public static HashMap<String, ArrayList<String>> getDraftKings() throws IOException{
			HashMap<String, ArrayList<String>>dkMap = new HashMap<String, ArrayList<String>>();
			FileInputStream fis = null;
				File csvData = new File("C:/quetzal/data/DKSalaries.csv");
				CSVParser csv= CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.RFC4180);
				 for (CSVRecord csvRecord : csv) {
					 ArrayList<String> info = new ArrayList<String>();
					 info.add(csvRecord.get(2));
					 info.add(csvRecord.get(4));
					 dkMap.put(csvRecord.get(1), info);
				 }
			return dkMap;
		}
}
