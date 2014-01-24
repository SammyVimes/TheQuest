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
	
	public Quest() {
		
	}
	
	public long getQuestId() {
		return questId;
	}
	
	public void setQuestId(long questId) {
		this.questId = questId;
	}
	
	public long getQuestInitiatorId() {
		return questInitiatorId;
	}
	
	public void setQuestInitiatorId(long questInitiatorId) {
		this.questInitiatorId = questInitiatorId;
	}
	
	public long getQuestExecutorId() {
		return questExecutorId;
	}
	
	public void setQuestExecutorId(long questExecutorId) {
		this.questExecutorId = questExecutorId;
	}
	
	public int getBounty() {
		return bounty;
	}
	
	public void setBounty(int bounty) {
		this.bounty = bounty;
	}
	
	public QuestType getQuestType() {
		return questType;
	}
	
	public void setQuestType(QuestType questType) {
		this.questType = questType;
	}
	
	public List<QuestStage> getQuestStages() {
		return questStages;
	}
	
	public void setQuestStages(List<QuestStage> questStages) {
		this.questStages = questStages;
	}
	
	public int getQuestStagesQuantity() {
		return questStagesQuantity;
	}
	
	public void setQuestStagesQuantity(int questStagesQuantity) {
		this.questStagesQuantity = questStagesQuantity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
}
