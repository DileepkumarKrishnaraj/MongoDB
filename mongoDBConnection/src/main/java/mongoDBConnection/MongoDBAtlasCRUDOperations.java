package mongoDBConnection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBAtlasCRUDOperations {
	
	public static void main(String args[]) {
	MongoClientURI uri = new MongoClientURI("mongodb+srv://Dileepkumar:MongoDB%40DK76@cluster0.hchuo6v.mongodb.net/?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");       
		
	try(MongoClient mongoClient = new MongoClient(uri))
		{
		MongoDatabase database = mongoClient.getDatabase("samco");

		database.createCollection("employee");

		Document document = new Document();
		document.append("name", "Dileepkumar");
		document.append("age", 21);
		document.append("department", "ECE");

		database.getCollection("employee").insertOne(document);
		System.out.println("Document inserted successfully");

		// Retrieving all documents

		/*
		 * MongoDatabase database = mongoClient.getDatabase("samco");
		 * 
		 * MongoCollection<Document> collection = database.getCollection("employee");
		 * 
		 * FindIterable<Document> findIterable = collection.find(); Iterator iterator =
		 * findIter.iterator(); while (iterator.hasNext()) { System.out.println(iterator.next()); }
		 */
		}
	}
}

