package Views;

public class Comment
{
	public static Comment comment;

	private Comment()
	{

	}

	public Comment getInstance()
	{
		if (comment == null)
			comment = new Comment();
		return comment;
	}

	public void viewComment(String commentid)
	{
		// fetch question from database
		// populate all comments, upvotes and display

	}
}
