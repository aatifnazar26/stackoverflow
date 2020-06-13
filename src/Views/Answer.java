package Views;

public class Answer
{
	public static Answer answer;

	private Answer()
	{

	}

	public Answer getInstance()
	{
		if (answer == null)
			answer = new Answer();
		return answer;
	}

	public void viewAnswer(String answerid)
	{
		// fetch question from database
		// populate all comments, upvotes and display

	}
}
