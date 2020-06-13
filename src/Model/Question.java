package Model;

import java.util.ArrayList;

import Model.Enums.contentType;

public class Question extends Content
{
	private final String title;
	private final String description;
	private ArrayList<Answer> answers;
	private ArrayList<Comment> comments;

	public static class QuestionBuilder extends ContentBuilder
	{
		private final String title;
		private final String description;
		private ArrayList<Answer> answers;
		private ArrayList<Comment> comments;

		public QuestionBuilder(String userid, String title, String description)
		{
			super(userid, contentType.QUESTION);
			this.title = title;
			this.description = description;
			answers = new ArrayList<>();
			comments = new ArrayList<>();
		}

		@Override
		public Question build()
		{
			return new Question(this);
		}
	}

	private Question(QuestionBuilder builder)
	{
		super(builder);
		this.title = builder.title;
		this.description = builder.description;
		this.answers = builder.answers;
		this.comments = builder.comments;
	}

	public String getTitle()
	{
		return title;
	}

	public String getDescription()
	{
		return description;
	}

	public ArrayList<Answer> getAnswers()
	{
		return answers;
	}

	public ArrayList<Comment> getComments()
	{
		return comments;
	}

}