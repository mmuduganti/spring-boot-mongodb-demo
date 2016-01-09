/**
 * 
 */
package org.gradle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gradle.dto.Property;
import org.gradle.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * @author mmuduganti
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories
public class Application implements CommandLineRunner {
	
	@Autowired
	MongoDbFactory mongo;
	
	@Autowired
	PropertyRepo propertyRepo;
	
	ObjectMapper objectMapper;
	
	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		objectMapper = new ObjectMapper();
		// TODO Auto-generated method stub
		DB tnr = mongo.getDb("test");
		DBCollection propertiesColl = tnr.getCollection("Property");
		DBCursor cursor = propertiesColl.find();
		while(cursor.hasNext()) {
			DBObject object = cursor.next();
			System.out.println(object);
		}
		
		Property property = propertyRepo.findByName("file.archive.foldersAndCriteria");
		System.out.println(property.getName() + "=" + property.getValue());
		if((property.getValue() instanceof ArrayList)) {
			List<Map<String, String>> objects = (ArrayList) property.getValue();
			System.out.println(objects.get(0).get("archiveFolderName") + "/" + objects.get(0).get("numberOfDaysToArchive"));
		}
		
		
		property = propertyRepo.findByName("file.archive.purge.criteria.days");
		System.out.println(property.getName() + "=" + property.getValue());
			
	}

}
