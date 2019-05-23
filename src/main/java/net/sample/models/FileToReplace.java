package net.sample.models;

public class FileToReplace {
    private String currentName;
    private String newName;
    private String seasonFolder;

    public FileToReplace(String currentName, String newName, String seasonFolder) {
        this.currentName = currentName;
        this.newName = newName;
        this.seasonFolder = seasonFolder;
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
