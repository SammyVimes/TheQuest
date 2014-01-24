package com.danilov.thequest.database;

import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.danilov.thequest.core.quest.Quest;
import com.danilov.thequest.core.quest.QuestStage;
import com.danilov.thequest.core.quest.QuestType;
import com.danilov.thequest.util.Utils;

public class QuestDatabaseHelper extends SQLiteOpenHelper {
	
	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "QUEST_DATABASE";
	
	private static final String QUEST_TABLE_NAME = "QUEST_TABLE";
	private static final String QUEST_STAGE_TABLE_NAME = "QUEST_STAGE_TABLE";

	private static final String QUEST_COLNAME_RECORD_ID = "RECORD_ID";
	private static final String QUEST_COLNAME_QUEST_ID = "QUEST_ID";
	private static final String QUEST_COLNAME_INITIATOR_ID = "INITIATOR_ID";
	private static final String QUEST_COLNAME_EXECUTOR_ID = "EXECUTOR_ID";
	private static final String QUEST_COLNAME_BOUNTY = "BOUNTY";
	private static final String QUEST_COLNAME_STAGES_QUANTITY = "STAGES_QUANTITY";
	private static final String QUEST_COLNAME_DESCIPTION = "DESCIPTION";
	private static final String QUEST_COLNAME_TYPE = "TYPE";
	private static final String QUEST_COLNAME_CREATION_DATE = "CREATION_DATE";
	private static final String QUEST_COLNAME_EXPIRATION_DATE = "EXPIRATION_DATE";
	
	private static final String[] QUEST_TABLE_COLNAMES = {
		QUEST_COLNAME_RECORD_ID,
		QUEST_COLNAME_QUEST_ID,
		QUEST_COLNAME_INITIATOR_ID,
		QUEST_COLNAME_EXECUTOR_ID,
		QUEST_COLNAME_BOUNTY,
		QUEST_COLNAME_STAGES_QUANTITY,
		QUEST_COLNAME_DESCIPTION,
		QUEST_COLNAME_TYPE,
		QUEST_COLNAME_CREATION_DATE,
		QUEST_COLNAME_EXPIRATION_DATE
	};
	

	private static final String STAGE_COLNAME_RECORD_ID = "RECORD_ID";
	private static final String STAGE_COLNAME_QUEST_ID = "QUEST_ID";
	private static final String STAGE_COLNAME_STAGE_NUMBER = "STAGE_NUMBER";
	private static final String STAGE_COLNAME_TYPE = "TYPE";
	private static final String STAGE_COLNAME_DESCRIPTION = "DESCRIPTION";
	private static final String STAGE_COLNAME_START_DATE = "START_DATE";
	private static final String STAGE_COLNAME_EXPIRATION_DATE = "EXPIRATION_DATE";
	
	private static final String[] STAGE_TABLE_COLNAMES = {
		STAGE_COLNAME_RECORD_ID,
		STAGE_COLNAME_QUEST_ID,
		STAGE_COLNAME_STAGE_NUMBER,
		STAGE_COLNAME_TYPE,
		STAGE_COLNAME_DESCRIPTION,
		STAGE_COLNAME_START_DATE,
		STAGE_COLNAME_EXPIRATION_DATE
	};

	public QuestDatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		SQLiteDatabase dataBase = getReadableDatabase();
		if (!Utils.isTableExistInDB(dataBase, QUEST_TABLE_NAME)) {
			createQuestTable(dataBase);
		}
		if (!Utils.isTableExistInDB(dataBase, QUEST_STAGE_TABLE_NAME)) {
			createQuestStageTable(dataBase);
		}
		dataBase.close();
	}
	
	private void createQuestTable(final SQLiteDatabase dataBase) {
		Utils.Log("on createQuestTable");
		String[] colTypes = {
				"integer primary key autoincrement",
				"integer",
				"integer",
				"integer",
				"integer",
				"integer",
				"text",
				"text",
				"integer",
				"integer"
		};
		createTable(dataBase, QUEST_TABLE_NAME, QUEST_TABLE_COLNAMES, colTypes);
	}
	
	private void createQuestStageTable(final SQLiteDatabase dataBase) {
		Utils.Log("on createQuestStageTable");
		String[] colTypes = {
				"integer primary key autoincrement",
				"integer",
				"integer",
				"text",
				"text",
				"integer",
				"integer"
		};
		createTable(dataBase, QUEST_STAGE_TABLE_NAME, STAGE_TABLE_COLNAMES, colTypes);
	}
	
	private void createTable(final SQLiteDatabase dataBase, 
							 final String tableName,
							 final String[] colNames, 
							 final String[] colTypes) {
		String sqlExpression = "create table" + tableName + " (";
		for (int i = 0; i < colNames.length; i++) {
			String colName = colNames[i];
			String colType = colTypes[i];
			sqlExpression += colName + colType;
			if (i < colNames.length - 1) {
				sqlExpression += ",";
			}
		}
		sqlExpression += ");";
		dataBase.execSQL(sqlExpression);
	}
	
	private void dropTable(final SQLiteDatabase dataBase, final String dataBaseName) {
		dataBase.execSQL("DROP TABLE IF EXISTS " + dataBaseName);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		SQLiteDatabase dataBase = getReadableDatabase();
		if (!Utils.isTableExistInDB(dataBase, QUEST_TABLE_NAME)) {
			createQuestTable(dataBase);
		}
		if (!Utils.isTableExistInDB(dataBase, QUEST_STAGE_TABLE_NAME)) {
			createQuestStageTable(dataBase);
		}
		dataBase.close();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void addQuest(final Quest quest) {
		List<QuestStage> questStages = quest.getQuestStages();
		ContentValues contentValues = new ContentValues();
		contentValues.put(QUEST_COLNAME_QUEST_ID, quest.getQuestId());
		contentValues.put(QUEST_COLNAME_INITIATOR_ID, quest.getQuestInitiatorId());
		contentValues.put(QUEST_COLNAME_EXECUTOR_ID, quest.getQuestExecutorId());
		contentValues.put(QUEST_COLNAME_BOUNTY, quest.getBounty());
		contentValues.put(QUEST_COLNAME_STAGES_QUANTITY, quest.getQuestStagesQuantity());
		contentValues.put(QUEST_COLNAME_DESCIPTION, quest.getDescription());
		contentValues.put(QUEST_COLNAME_TYPE, quest.getQuestType().toString());
		contentValues.put(QUEST_COLNAME_CREATION_DATE, quest.getCreationDate().getTime());
		contentValues.put(QUEST_COLNAME_EXPIRATION_DATE, quest.getExpirationDate().getTime());
		SQLiteDatabase dataBase = getWritableDatabase();
		dataBase.insert(QUEST_TABLE_NAME, null, contentValues);
		insertStages(dataBase, questStages);
		dataBase.close();
	}
	
	private void insertStages(final SQLiteDatabase dataBase, final List<QuestStage> questStages) {
		
	}

}
