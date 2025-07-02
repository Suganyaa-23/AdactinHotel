package com.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVDataReader {
	public static Iterator<Object[]> readData(String filePath) throws IOException {
        List<Object[]> data = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath);
             @SuppressWarnings("deprecation")
			CSVParser parser = CSVFormat.Builder.create(CSVFormat.DEFAULT)
                     .setHeader()
                     .setSkipHeaderRecord(true)
                     .build()  
                     .parse(reader)) {

            for (CSVRecord record : parser) {
                data.add(new Object[]{
                    record.get("username"),
                    record.get("password")
                });
            }
        }

        return data.iterator();
    }

}
