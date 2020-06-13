package Model;

import Model.Enums.personType;

public class Person
{
	protected final String personid;
	protected final personType type;
	protected String name;
	protected String password;
	protected String email;
	protected String phone;
	protected boolean isRemoved;

	public static class PersonBuilder
	{
		protected final String personid;
		protected final personType type;
		protected String name;
		protected String password;
		protected String email;
		protected String phone;
		protected boolean isRemoved;

		public PersonBuilder(String personid, Enums.personType type)
		{
			this.personid = personid;
			this.type = type;
			isRemoved = false;
		}

		public PersonBuilder name(String name)
		{
			this.name = name;
			return this;
		}

		public PersonBuilder password(String password)
		{
			this.password = password;
			return this;
		}

		public PersonBuilder email(String email)
		{
			this.email = email;
			return this;
		}

		public PersonBuilder phone(String phone)
		{
			this.phone = phone;
			return this;
		}

		public Person build()
		{
			return new Person(this);
		}
	}

	protected Person(PersonBuilder builder)
	{
		this.personid = builder.personid;
		this.type = builder.type;
		this.name = builder.name;
		this.phone = builder.phone;
		this.email = builder.email;
		this.password = builder.password;
		this.isRemoved = builder.isRemoved;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public personType getType()
	{
		return this.type;
	}

	public String getId()
	{
		return this.personid;
	}

	public String getName()
	{
		return this.name;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public String getEmail()
	{
		return this.email;
	}

	public String getPassword()
	{
		return this.password;
	}

	public boolean getIsRemoved()
	{
		return this.isRemoved;
	}
}