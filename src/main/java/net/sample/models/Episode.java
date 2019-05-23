package net.sample.models;

import java.util.Date;

public class Episode {
    private String id;
    private int season;
    private int episode;
    private String episodeName;
    private int episodeNumber;
    private Date firstAired;
    private String matchingFileName;

    public Episode(String id, int season, int episode, String episodeName, int episodeNumber, Date firstAired) {
        super();
        this.id = id;
        this.season = season;
        this.episode = episode;
        this.episodeName = episodeName;
        this.episodeNumber = episodeNumber;
        this.firstAired = firstAired;
    }
    @Override
    public String toString() {
        return "Episode{" +
                "id='" + id + '\'' +
                ", season=" + season +
                ", episode=" + episode +
                ", episodeName='" + episodeName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Date getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(Date firstAired) {
        this.firstAired = firstAired;
    }

    public String getMatchingFileName() {
        return matchingFileName;
    }

    public void setMatchingFileName(String matchingFileName) {
        this.matchingFileName = matchingFileName;
    }
}
