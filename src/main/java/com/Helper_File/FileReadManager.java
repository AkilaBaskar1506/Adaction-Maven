package com.Helper_File;

import java.io.IOException;

public class FileReadManager {
private FileReadManager() {
	
}
public  Configuration_Reader getReader() throws IOException {
Configuration_Reader reader=new Configuration_Reader();
return reader;
}

public static FileReadManager manager() {
FileReadManager manager = new FileReadManager();
return manager;
}




}
