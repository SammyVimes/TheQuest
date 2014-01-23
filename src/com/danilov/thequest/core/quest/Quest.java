package com.danilov.thequest.core.quest;

import java.sql.Date;
import java.util.List;

public class Quest {

	private long questId;
	private long questInitiatorId;
	private long questExecutorId;
	
	private int bounty; //some kind of experience maybe
	private QuestType questType;
	
	private List<QuestStage> questStages;
	private int questStagesQuantity;
	private String description;
	private Date creationDate;
	private Date expirationDate; //may not be set
	
}
