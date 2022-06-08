package com.bms.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LocaleCSVParser {
	
		
		public String theatrefile = "src//main//java//resources//theatres.csv";
		public String moviesFile = "src//main//java//resources//movies.csv";
		public String cityFile = "src//main//java//resources//city.csv";
		public String actorFile = "src//main//java//resources//actors.csv";
		public String ratingsFile = "src//main//java//resources//ratings.csv";
		
		private static HashMap<String, String[]> map;
		private HashMap<Integer, String> ratingsMap;
		
		public LocaleCSVParser() {
			super();
		}

		public HashMap<String, String[]> readFile(String file) {

			BufferedReader reader = null;
			String line = "";
			map = new HashMap<String, String[]>();
			try{
				reader = new BufferedReader(new FileReader(file));
				while((line = reader.readLine()) != null) {
					String[] row = line.split(",");
					map.put(row[0].trim(), row[1].split(";"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return map;
		}
		
		public HashMap<Integer, String> readRatingsFile(String file) {

			BufferedReader reader = null;
			String line = "";
			ratingsMap = new HashMap<Integer, String>();
			try{
				reader = new BufferedReader(new FileReader(file));
				while((line = reader.readLine()) != null) {
					String[] row = line.split(",");
					ratingsMap.put(Integer.parseInt(row[0].trim()), row[1].trim());
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return ratingsMap;
		}
}
