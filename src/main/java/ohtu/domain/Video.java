package ohtu.domain;

import java.sql.Date;
import java.time.LocalDate;

public class Video {
    private String title;
    private String url;
    private String tags;
    private String comment;
    private int id;
    private Date time;

    public Video(String title, String url, String tags, String comment) {
        this.title = title;
        this.url = url;
        this.tags = tags;
        this.comment = comment;
        this.time = Date.valueOf(LocalDate.now());
    }

    public Video(String title, String url, String tags, String comment, int id, Date time) {
        this.title = title;
        this.url = url;
        this.tags = tags;
        this.comment = comment;
        this.id = id;
        this.time = time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
