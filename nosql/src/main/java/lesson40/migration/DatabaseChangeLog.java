package lesson40.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lesson40.model.Genre;
import lesson40.repository.GenreRepository;
import org.bson.Document;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "dropDb", author = "Vitalii Ivanov", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertNewGenre", author = "Vitalii Ivanov")
    public void insertNewGenre(MongoDatabase db) {
        MongoCollection<Document> myCollection = db.getCollection("genre");
        var doc = new Document()
                .append("_id", "New")
                .append("name", "Новый");
        myCollection.insertOne(doc);
    }

    @ChangeSet(order = "003", id = "insertNewGenreAnotherWay", author = "Vitalii Ivanov")
    public void insertPushkin(GenreRepository repository) {
        repository.save(new Genre("new2", "Новый2"));
    }
}
