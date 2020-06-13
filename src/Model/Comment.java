package Model;

import Model.Enums.contentType;

public class Comment extends Content
{
	private final String parentid;
	private final String text;

	public static class CommentBuilder extends ContentBuilder
	{
		private final String text;
		private final String parentid;

		public CommentBuilder(String userid, String parentid, String text)
		{
			super(userid, contentType.COMMENT);
			this.parentid = parentid;
			this.text = text;
		}

		@Override
		public Comment build()
		{
			return new Comment(this);
		}
	}

	private Comment(CommentBuilder builder)
	{
		super(builder);
		this.parentid = builder.parentid;
		this.text = builder.text;
	}

	public String getParentId()
	{
		return parentid;
	}

	public String getText()
	{
		return text;
	}
}