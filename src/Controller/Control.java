package Controller;

import DAO.DatabaseManager;
import Model.Content;
import Model.Enums.personType;
import Model.Person;

public class Control
{
	static Control so;

	private Control()
	{

	}

	public static Control getInstance()
	{
		if (so == null)
			so = new Control();
		return so;
	}

	public void addContent(Person person, Content content)
	{
		if (person.getType() == personType.GUEST)
			System.out.println("Unauthorized action");
		else
		{
			DatabaseManager dm = DatabaseManager.getInstance();
			dm.add(person.getId(), content);
		}
	}

	public void upvoteContent(Person person, Content content)
	{
		if (person.getType() == personType.GUEST)
			System.out.println("Unauthorized action");
		else
		{
			DatabaseManager dm = DatabaseManager.getInstance();
			dm.upvote(person.getId(), content);
		}

	}

	public void deleteContent(Person person, Content content)
	{
		if (person.getType() == personType.GUEST)
			System.out.println("Unauthorized action");
		else if (person.getType() == personType.USER && content.getUserid() == person.getId())
		{
			DatabaseManager dm = DatabaseManager.getInstance();
			content.setDelete(true);
			dm.update(person.getId(), content);
		} else
		{
			// person is moderator or admin
			DatabaseManager dm = DatabaseManager.getInstance();
			content.setDelete(true);
			dm.update(person.getId(), content);
		}
	}

	public void undeleteContent(Person person, Content content)
	{
		if (person.getType() == personType.GUEST)
			System.out.println("Unauthorized action");
		else if (person.getType() == personType.USER && content.getUserid() == person.getId())
		{
			DatabaseManager dm = DatabaseManager.getInstance();
			content.setDelete(false);
			dm.update(person.getId(), content);
		} else
		{
			// person is moderator or admin
			DatabaseManager dm = DatabaseManager.getInstance();
			content.setDelete(false);
			dm.update(person.getId(), content);
		}
	}

	public Content viewContent(Person person, Content content)
	{
		if (content.getDeleted() == true)
			return content;
		else
			return null;
	}

	public void flagContent(Person person, Content content)
	{
		if (person.getType() == personType.GUEST)
			System.out.println("Unauthorized action");
		else
		{
			DatabaseManager dm = DatabaseManager.getInstance();
			content.setFlag(true);
			dm.update(person.getId(), content);
		}
	}

	public void unflagContent(Person person, Content content)
	{
		if (person.getType() == personType.GUEST || (person.getType() == personType.USER))
			System.out.println("Unauthorized action");
		else
		{
			// person is moderator or admin
			DatabaseManager dm = DatabaseManager.getInstance();
			content.setFlag(false);
			dm.update(person.getId(), content);
		}

	}

	public Content searchContent(String search)
	{
		DatabaseManager dm = DatabaseManager.getInstance();
		Content content = dm.search(search);
		if (content.getDeleted() == true)
			return content;
		else
			return null;
	}
}