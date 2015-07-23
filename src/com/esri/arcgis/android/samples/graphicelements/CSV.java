package com.esri.arcgis.android.samples.graphicelements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CSV {
	public ArrayList<String[]>  readeCsv(String filepath) throws IOException{  
			CsvReader reader ;
	        ArrayList<String[]> csvList = new ArrayList<String[]>(); //������������  
	        String csvFilePath = filepath;  
	        reader = new CsvReader(csvFilePath,',',Charset.forName("GBK"));    //һ�����������Ϳ�����      
	        reader.readHeaders(); // ������ͷ   �����Ҫ��ͷ�Ļ�����Ҫд��䡣  
	         while(reader.readRecord()){ //���ж������ͷ������      
	             csvList.add(reader.getValues());  
	         }
	         reader.close();  
	           
	        /* for(int row=0;row<csvList.size();row++){  
	               
	             String  cell = csvList.get(row)[0]; //ȡ�õ�row�е�0�е�����  
	             System.out.println(cell);  	               
	         }*/
	         return csvList;
	}
	public int GetCount(String path) throws IOException {
		 CsvReader reader;
		 int i=0;
			reader = new CsvReader(path,',',Charset.forName("GBK"));			
				while(reader.skipRecord()){
				     i++;  
				 }
	         reader.close();
         return i;
           
	} 
	public String[] getPointValue(String path,int id) throws IOException {
		 CsvReader reader;
		 id++;
			reader = new CsvReader(path,',',Charset.forName("GBK"));			
				while(id>0){
				     reader.skipRecord();
				     id--;
				 }
        String[] valueStrings=reader.getValues();
        reader.close();
        return valueStrings;
          
	} 
	public boolean AddCsv(String path,String[] value) throws IOException{
			FileOutputStream stream;// provides file access 
			OutputStreamWriter writer;// writes to the file
			stream = new FileOutputStream(path,true);
			writer = new OutputStreamWriter(stream,"GBK");
			String string = "";
			for (int i = 0; i < value.length; i++) {
				if (i==0) {
					string=value[i];
				}
				else {
					string=string+","+value[i];
				}				
			}
			writer.append(string); 
			writer.append("\n"); 
			writer.close(); 
			return true;
	}
	
	/** 
	 * д��CSV�ļ� 
	 * @throws IOException 
	 */  
	public void writeCsv(String path,String[] value) throws IOException{  
	         CsvWriter wr =new CsvWriter(path,',',Charset.forName("GBK"));                      
	         wr.writeRecord(value);	         
	         wr.close();  
	}
}
