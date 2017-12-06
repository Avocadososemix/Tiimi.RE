package ohtu.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ohtu.database.Database;
import ohtu.domain.Video;

public class VideoDao implements Dao<Video, Integer> {

    private Database database;

    public VideoDao(Database database) {
        this.database = database;
    }

    @Override
    public Video findOne(Integer key) throws SQLException {
        try (Connection conn = database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Video WHERE id = ?");
            stmt.setInt(1, key);

            ResultSet result = stmt.executeQuery();
            if (!result.next()) {
                return null;
            }
            Video b = new Video(result.getString("title"), result.getString("url"), result.getString("tags"), result.getString("comments"), result.getInt("id"), result.getDate("dateAdded"), result.getBoolean("seen"));
            return b;

        }
    }

    @Override
    public List<Video> findAll() throws SQLException {
        List<Video> users = new ArrayList<>();

        try (Connection conn = database.getConnection();
                ResultSet result = conn.prepareStatement("SELECT * FROM Video").executeQuery()) {

            while (result.next()) {
                users.add(new Video(result.getString("title"), result.getString("url"), result.getString("tags"), result.getString("comments"), result.getInt("id"), result.getDate("dateAdded"), result.getBoolean("seen")));
            }
        }

        return users;
    }

    @Override
    public Video save(Video video) throws SQLException {
        Video byName = findByName(video.getTitle());

        if (byName != null) {
            return findByName(byName.getTitle());
        } //ei haluta kahta saman nimistä

        //Tallennetaan video
        try (Connection conn = database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO video (title, url, tags, comments, seen, dateAdded) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, video.getTitle());
            stmt.setString(2, video.getUrl());
            stmt.setString(3, video.getTags());
            stmt.setString(4, video.getComment());
            stmt.setBoolean(5, video.getSeen());
            stmt.setDate(6, video.getTime());
            stmt.executeUpdate();
//            saveOrUpdateTags(video.getTags(), video.getTitle());
        }

        return findByName(video.getTitle());

    }

    @Override
    public Video update(Video video) throws SQLException {
//        video video = findOne(id);
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE Video"
                + " SET title = ?, url = ?, tags = ?, comments = ?"
                + " WHERE id = ?");
        statement.setString(1, video.getTitle());
        statement.setString(2, video.getUrl());
        statement.setString(3, video.getTags());
        statement.setString(4, video.getComment());
        statement.setInt(5, video.getId());
        statement.executeUpdate();
//        saveOrUpdateTags(video.getTags(), video.getTitle());
        return findByName(video.getTitle());
    }

//    public void saveOrUpdateTags(String tags, String title) throws SQLException {
//        if (tags == null || title == null) {
//            return;
//        }
//        int bookId = findByName(title).getId();
//        try (Connection conn = database.getConnection()) {
//            String tagParts[] = tags.split(","); //tänne täytyy vielä lisätä osa joka poistaa vanhoja tageja
//            for (String tagPart : tagParts) {
//                System.out.println("Lisätään tagi " + tagPart.trim() + " databaseen");
//                PreparedStatement tagCheck = conn.prepareStatement("INSERT OR IGNORE INTO Tags (tagName) VALUES (?)");
//                tagCheck.setString(1, tagPart.trim());
//                tagCheck.executeUpdate();
//                //Lisätään liitostaulu kirjan ja tagin välille
//                PreparedStatement tagit = conn.prepareStatement("INSERT INTO BookTags "
//                        + "(book_id, tag_id) VALUES (?, (SELECT tag_id FROM Tags WHERE tagName = ?))");
//                tagit.setInt(1, bookId);
//                tagit.setString(2, tagPart.trim()); // tässä käytetty trim! huom! kannattaa siis tagien haussa myös.
//                tagit.executeUpdate();
//                //Liitostaulu lisätty
//            }
//        }
//
//    }

    public Video findByName(String title) throws SQLException {
        try (Connection conn = database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Video WHERE title = ?");
            stmt.setString(1, title);

            ResultSet result = stmt.executeQuery();
            if (!result.next()) {
                return null;
            }

            return new Video(result.getString("title"), result.getString("url"), result.getString("tags"), result.getString("comments"), result.getInt("id"), result.getDate("dateAdded"));
        }
    }

    @Override
    public void delete(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Video WHERE id = ?");
        statement.setInt(1, key);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

}
