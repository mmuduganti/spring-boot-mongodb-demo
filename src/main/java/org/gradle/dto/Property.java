
package org.gradle.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Property")
@Getter
@Setter
@ToString
public class Property {
	String _id;
	String name;
	Object value;
}
