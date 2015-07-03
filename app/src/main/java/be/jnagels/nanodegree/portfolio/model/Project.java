package be.jnagels.nanodegree.portfolio.model;

/**
 * Created by jelle on 07/06/15.
 */
public class Project
{
	public final static int TYPE_NORMAL = 0;
	public final static int TYPE_FINAL = 1;

	private final int id;
	private final String name;
	private final int type;
	private final String action;

	public Project(int id, String name, int type, String action)
	{
		this.id = id;
		this.name = name;
		this.type = type;
		this.action = action;
	}

	public Project(int id, String name, String action)
	{
		this(id, name, TYPE_NORMAL, action);
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public int getType()
	{
		return type;
	}

	public String getAction()
	{
		return action;
	}

	public boolean isTypeFinal()
	{
		return this.type == TYPE_FINAL;
	}
}
