package mongoDBLocal;

import java.util.Iterator;
import java.util.Set;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class LocalMongoDBCRUDOperations {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		DB database = mongoClient.getDB("employee_details");

		Set<String> collections = database.getCollectionNames();
		System.out.println(collections);

		MongoDatabase mongoDatabase = mongoClient.getDatabase("employee_details");
		MongoCollection collection = mongoDatabase.getCollection("employee");

		
		  Document document = new Document(); 
		  document.append("id", 1523);
		  document.append("name", "Dileepkumar"); 
		  document.append("email", "dileepkrishna7676@gmail.com"); 
		  document.append("id", 1524);
		  document.append("name", "Nitheeshkumar"); 
		  document.append("email", "emathukaran@gmail.com"); 
		  document.append("id", 1525);
		  document.append("name", "Omini"); 
		  document.append("email", "ominisevaigal@gmail.com"); 
		  collection.insertOne(document);
		 

		
		  FindIterable<Document> findIterable = collection.find(); 
		  Iterator iterator = findIterable.iterator(); while (iterator.hasNext()) {
		  System.out.println(iterator.next()); }
		 

	}

}
