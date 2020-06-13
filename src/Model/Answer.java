package Model;

import java.util.ArrayList;

import Model.Enums.contentType;

public class Answer extends Content
{
	private final String questionid;
	private final String text;
	private ArrayList<Comment> comments;

	public static class AnswerBuilder extends ContentBuilder
	{
		private final String questionid;
		private final String text;
		private ArrayList<Comment> comments;

		public AnswerBuilder(String userid, String questionid, String text)
		{
			super(userid, contentType.ANSWER);
			this.questionid = questionid;
			this.text = text;
			comments = new ArrayList<>();
		}

		@Override
		public Answer build()
		{
			return new Answer(this);
		}
	}

	private Answer(AnswerBuilder builder)
	{
		super(builder);
		this.questionid = builder.questionid;
		this.text = builder.text;
		this.comments = builder.comments;
	}

	public String getQuestionId()
	{
		return this.questionid;
	}

	public String getText()
	{
		return this.text;
	}

	public ArrayList<Comment> getComments()
	{
		return this.comments;
	}
}