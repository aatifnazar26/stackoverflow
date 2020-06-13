package DAO;

import Model.Answer;
import Model.Comment;
import Model.Content;
import Model.Enums.contentType;
import Model.Question;

public class DatabaseManager
{
	private static DatabaseManager dm;

	private DatabaseManager()
	{
	}

	public static DatabaseManager getInstance()
	{
		if (dm == null)
			dm = new DatabaseManager();
		return dm;
	}

	public String getNewContentId()
	{
		// return new id from database
		return "1234";
	}

	public String getNewPersonId()
	{
		// return new id from database
		return "1234";
	}

	public void update(String personid, Content content)
	{
		if (content.getType() == contentType.QUESTION)
			DatabaseManager.getInstance().updateQuestion(personid, (Question) content);
		else if (content.getType() == contentType.ANSWER)
			DatabaseManager.getInstance().updateAnswer(personid, (Answer) content);
		else
			DatabaseManager.getInstance().updateComment(personid, (Comment) content);
	}

	private void updateQuestion(String personid, Question question)
	{
		// update question in database
	}

	private void updateAnswer(String personid, Answer answer)
	{
		// update answer in database
	}

	private void updateComment(String personid, Comment comment)
	{
		// update comment in database
	}

	public void add(String personid, Content content)
	{
		if (content.getType() == contentType.QUESTION)
			DatabaseManager.getInstance().addQuestion(personid, (Question) content);
		else if (content.getType() == contentType.ANSWER)
			DatabaseManager.getInstance().addAnswer(personid, (Answer) content);
		else
			DatabaseManager.getInstance().addComment(personid, (Comment) content);
	}

	public void addQuestion(String personid, Question question)
	{
		// add in question table
	}

	private void addAnswer(String personid, Answer answer)
	{
		// add in answer table
	}

	private void addComment(String personid, Comment comment)
	{
		// add in comments table
	}

	public Content search(String search)
	{
		// search in database
		return null;
	}

	public void upvote(String personid, Content content)
	{
		if (content.getType() == contentType.QUESTION)
			DatabaseManager.getInstance().upvoteQuestion(personid, (Question) content);
		else if (content.getType() == contentType.ANSWER)
			DatabaseManager.getInstance().upvoteAnswer(personid, (Answer) content);
		else
			DatabaseManager.getInstance().upvoteComment(personid, (Comment) content);
	}

	private void upvoteQuestion(String personid, Question question)
	{
		// increment upvotes of this question
	}

	private void upvoteAnswer(String personid, Answer answer)
	{
		// increment upvotes of this answer
	}

	private void upvoteComment(String personid, Comment comment)
	{
		// increment upvotes of this comment
	}
}