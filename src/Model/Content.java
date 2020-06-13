package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import DAO.DatabaseManager;
import Model.Enums.contentType;

public class Content
{
	protected final String contentid;
	protected final String userid;
	protected final String creationTime;
	protected final contentType type;
	protected int upvotes;
	protected boolean isFlagged;
	protected boolean isClosed;
	protected boolean isDeleted;

	public static class ContentBuilder
	{
		protected final String contentid;
		protected final String userid;
		protected String creationTime;
		protected final contentType type;
		protected int upvotes;
		protected boolean isFlagged;
		protected boolean isClosed;
		protected boolean isDeleted;

		public ContentBuilder(String userid, contentType type)
		{
			this.contentid = DatabaseManager.getInstance().getNewContentId();
			this.userid = userid;
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			Date dateobj = new Date();
			this.creationTime = df.format(dateobj);
			this.type = type;
			this.upvotes = 0;
			this.isFlagged = false;
			this.isClosed = false;
			this.isDeleted = false;
		}

		public Content build()
		{
			return new Content(this);
		}
	}

	protected Content(ContentBuilder builder)
	{
		this.contentid = builder.contentid;
		this.userid = builder.userid;
		this.creationTime = builder.creationTime;
		this.type = builder.type;
		this.upvotes = builder.upvotes;
		this.isFlagged = builder.isFlagged;
		this.isClosed = builder.isClosed;
		this.isDeleted = builder.isDeleted;
	}

	public void setUpvote(int upvotes)
	{
		this.upvotes = upvotes;
	}

	public void setFlag(boolean isFlagged)
	{
		this.isFlagged = isFlagged;
	}

	public void setStatus(boolean isClosed)
	{
		this.isClosed = isClosed;
	}

	public void setDelete(boolean isDeleted)
	{
		this.isDeleted = isDeleted;
	}

	public String getContentid()
	{
		return this.contentid;
	}

	public String getUserid()
	{
		return this.userid;
	}

	public String getCreationTime()
	{
		return this.creationTime;
	}

	public contentType getType()
	{
		return this.type;
	}

	public boolean getFlag()
	{
		return this.isFlagged;
	}

	public boolean getStatus()
	{
		return this.isClosed;
	}

	public boolean getDeleted()
	{
		return this.isDeleted;
	}

	public int getUpvotes()
	{
		return this.upvotes;
	}
}