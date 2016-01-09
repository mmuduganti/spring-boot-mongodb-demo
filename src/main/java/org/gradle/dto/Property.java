
package org.gradle.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Property")
@Getter
@Setter
@ToString
@Builder
public class Property {
	String _id;
	String name;
	Object value;
}
