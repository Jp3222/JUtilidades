/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.framework;

import com.jutil.util.JFuncFiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author jp
 */
public class AppProperties {

    private File propertiesFile;
    private boolean autoRead;
    private Properties properties;

    public AppProperties(File propertiesFile, boolean autoRead) throws IOException {
        this.propertiesFile = propertiesFile;
        this.autoRead = autoRead;
        this.properties = new Properties();
        autoRead();
    }

    public AppProperties() {
        this.properties = new Properties();
    }

    public void setPropertiesFile(File properties_file) {
        this.propertiesFile = properties_file;
    }

    public File getPropertiesFile() {
        return propertiesFile;
    }

    public void setAutoRead(boolean autoRead) {
        this.autoRead = autoRead;
    }

    public boolean isAutoRead() {
        return autoRead;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private void autoRead() throws IOException {
        if (!autoRead && propertiesFile == null) {
            return;
        }
        if (!propertiesFile.exists() && !propertiesFile.isFile() && !propertiesFile.canRead()) {
            return;
        }
        read();
    }

    public void read() throws IOException {
        read(propertiesFile);
    }

    public void save(String comment) throws IOException {
        if (!JFuncFiles.fileOK(propertiesFile)) {
            System.err.println("ocurrion un error al guardar");
            return;
        }
        save(propertiesFile, comment);
    }

    public void read(File file) throws FileNotFoundException, IOException {
        properties.loadFromXML(new FileInputStream(file));
    }

    public void save(File file, String comment) throws FileNotFoundException, IOException {
        properties.storeToXML(new FileOutputStream(file), comment);
    }

}
