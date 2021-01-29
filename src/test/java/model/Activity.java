package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder (toBuilder = true)
public class Activity {
	
	private final Integer id;
	private final String title;
	private final String dueDate;
	private final Boolean completed;

}
