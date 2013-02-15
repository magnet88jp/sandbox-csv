package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import java.io.*;

import models.*;
import au.com.bytecode.opencsv.*;
import au.com.bytecode.opencsv.bean.*;

import models.*;

public class CsvFile extends Controller {

  public static void uploadFile(File uploadFile) throws Exception{

  	Logger.info("filename=" + uploadFile.getName());

    InputStream is = new FileInputStream(uploadFile);
    InputStreamReader isr = new InputStreamReader(is, "Shift_JIS");
    CSVReader csvr = new CSVReader(isr);

    String [] columns;

    columns = csvr.readNext();

//    for(String column : columns) {
//      Logger.info("column=" + column);
//    }

    if(columns != null) {
//      columnNames = csvr.readNext();

  //    while ((nextLine = csvr.readNext()) != null) {
  //      // nextLine[] is an array of values from the line
  //      Logger.info(nextLine[0] + nextLine[1] + "etc...");
  //    }

      ColumnPositionMappingStrategy cpms = new ColumnPositionMappingStrategy();
      cpms.setType(TransportFile.class);

      cpms.setColumnMapping(columns);
//      String[] columns2 = new String[] {"transportFileId", "transaction_applicationAdmin_areaName", "transaction_applicationAdmin_address"};
//      cpms.setColumnMapping(columns2);

      CsvToBean<TransportFile> csvToBean = new CsvToBean<TransportFile>();
      List<TransportFile> transportFiles = csvToBean.parse(cpms, csvr);
      for(TransportFile transportFile : transportFiles) {
//        Logger.info("test=" + transportFile.transportFileId + ",2=" + transportFile.transaction_applicationAdmin_areaName + ",3=" + transportFile.transaction_applicationAdmin_address);
        Logger.info("transportFile.column1=" + transportFile.column1);
//        application(transportFile);
      }

    }


    selectFile();
  }

  public static void selectFile() {
    render();
  }

}