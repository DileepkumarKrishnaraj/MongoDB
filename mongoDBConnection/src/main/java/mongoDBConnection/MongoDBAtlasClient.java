package mongoDBConnection;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBAtlasClient {

	public static void main(String[] args) {
		
		
		//System.setProperty("jdk.tls.trustNameService", "true");
		
				MongoClientURI uri = new MongoClientURI(
					    "mongodb+srv://Dileepkumar:MongoDB%40DK76@cluster0.hchuo6v.mongodb.net/?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");           
					
				try(MongoClient mongoClient = new MongoClient(uri))
					{
						MongoDatabase database = mongoClient.getDatabase("sample_training");			
						MongoCollection<Document> collection = database.getCollection("companies");
						Document query = new Document("_id", new ObjectId("52cdef7c4bab8bd675297d8a"));
				        Document result = collection.find(query).iterator().next();

				        System.out.println("Name: "+result.getString("name"));
					}		
		}

}

