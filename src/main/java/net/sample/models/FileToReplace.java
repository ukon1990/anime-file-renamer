package net.sample.models;

import java.io.File;

public class FileToReplace {
    private int number;
    private String currentName;
    private String newName;
    private String seasonFolder;
    private File file;

    public FileToReplace(int number, String currentName, String newName, String seasonFolder, File file) {
        this.number = number;
        this.currentName = currentName;
        this.newName = newName;
        this.seasonFolder = seasonFolder;
        this.file = file;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getSeasonFolder() {
        return seasonFolder;
    }

    public void setSeasonFolder(String seasonFolder) {
        this.seasonFolder = seasonFolder;
    }
}
