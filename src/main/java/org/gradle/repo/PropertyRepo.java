
package org.gradle.repo;

import org.gradle.dto.Property;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropertyRepo extends MongoRepository<Property, String> {
	public Property findByName(String name);
}
