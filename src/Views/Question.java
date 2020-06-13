package Views;

public class Question
{
	public static Question question;

	private Question()
	{

	}

	public Question getInstance()
	{
		if (question == null)
			question = new Question();
		return question;
	}

	public void viewQuestion(String questionid)
	{
		// fetch question from database
		// populate all comments, answers, upvotes and display

	}
}
