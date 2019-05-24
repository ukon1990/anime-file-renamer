package net.sample.utils;

import net.sample.models.Episode;
import net.sample.models.Show;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TVDBUtil {
    public String result;
    private static String browser = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0";
    Elements elements;

    HashMap<String, Show> showOverview = new HashMap<>();
    HashMap<String, String> showIDList = new HashMap<>();

    public String getShowName(String url) {
        String show = "";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent(browser).get();
        } catch (IOException e) {
        }
        show = doc.select("[itemprop=\"name\"]").text();
        return show;
    }

    public Show getShowData(String name) {
        Show show = getShow(name);

        if (show != null) {
            try {
                show.setEpisodes(
                        getEpisodes(
                                show.getId()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return show;
    }

    private ArrayList<Episode> getEpisodes(String id) throws IOException {
        Document doc;
        ArrayList<Episode> list = new ArrayList<>();
        String url = "http://thetvdb.com/api/E4D3529CB45223F6/series/" +
                id + "/all/en.xml";
        doc = Jsoup.connect(url)
                .userAgent(browser)
                .maxBodySize(0)
                .timeout(1000 * 10)
                .get();
        Elements episodes = doc.getElementsByTag("Episode");
        for (int e = 0; e < episodes.size(); e++) {
            parseEpisodeNode(
                    list,
                    episodes, e);
        }
        return list;
    }

    private Show getShow(String name) {
        try {
            String query = "http://thetvdb.com/api/GetSeries.php?seriesname=" + URLEncoder.encode(name, "UTF-8");
            System.out.println(query);
            Document doc = null;
            try {
                doc = Jsoup.connect(query)
                        .userAgent(browser)
                        .get();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Elements queryResults = doc.getElementsByTag("Series");
            for (int i = 0; i < queryResults.size(); i++) {
                if (isSeriesName(name, queryResults, i)) {
                    return new Show(
                            getElementValue(queryResults, i, "seriesid"),
                            getElementValue(queryResults, i, "SeriesName"));
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getElementValue(Elements queryResults, int i, String elementName) {
        return queryResults.get(i).getElementsByTag(elementName).text();
    }

    private boolean isSeriesName(String show, Elements queryResults, int i) {
        return getElementValue(queryResults, i, "SeriesName").toLowerCase().equals(show.toLowerCase());
    }

    private void parseEpisodeNode(ArrayList<Episode> list, Elements episodes, int e) {
        try {
            String id = getElementValue(episodes, e, "id");
            int season = Integer.parseInt(getElementValue(episodes, e, "SeasonNumber"));
            int episode = Integer.parseInt(getElementValue(episodes, e, "EpisodeNumber"));
            String episodeName = getElementValue(episodes, e, "EpisodeName");
            Date firstAired = new SimpleDateFormat("yyyy-mm-dd").parse(
                    getElementValue(episodes, e, "FirstAired"));

            if (season != 0) {
                list.add(new Episode(
                        id,
                        season,
                        episode,
                        episodeName,
                        list.size() + 1,
                        firstAired
                ));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
