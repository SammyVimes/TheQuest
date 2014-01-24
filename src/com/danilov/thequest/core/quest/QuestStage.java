package com.danilov.thequest.core.quest;

import java.util.Date;

public class QuestStage {

	private long questId;
	private short stageNumber;
	
	private QuestStageType questStageType;
	private String description;
	
	private Date startDate;
	private Date expirationDate;
	
	public QuestStage() {
		
	}
	
	public long getQuestId() {
		return questId;
	}
	
	public void setQuestId(long questId) {
		this.questId = questId;
	}
	
	public short getStageNumber() {
		return stageNumber;
	}
	
	public void setStageNumber(short stageNumber) {
		this.stageNumber = stageNumber;
	}
	
	public QuestStageType getQuestStageType() {
		return questStageType;
	}
	
	public void setQuestStageType(QuestStageType questStageType) {
		this.questStageType = questStageType;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
