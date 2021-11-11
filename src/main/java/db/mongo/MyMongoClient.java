package db.mongo;

import com.mongodb.Block;
import com.mongodb.client.*;

import org.bson.Document;

public class MyMongoClient {

    public static void main(String[] args) {
        // No authentication
        final String uriString = "mongodb://localhost:27017/admin?authSource=admin";
        // Auth
        // final String authUriString = "mongodb://$[username]:$[password]@localhost:27017/admin?authSource=admin";
        
        MongoClient mongoClient = MongoClients.create(uriString);

        MongoDatabase mongoDB = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDB.getCollection("inventory");

        FindIterable<Document> findIterable = collection.find(new Document());

        findIterable.forEach(printBlock);
    }

    private static Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };
    
}
