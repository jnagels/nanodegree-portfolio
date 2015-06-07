package be.jnagels.nanodegree.portfolio.model;

/**
 * Created by jelle on 07/06/15.
 */
public class Project
{
	public final static int TYPE_NORMAL = 0;
	public final static int TYPE_FINAL = 1;

	private int id;
	private String name;
	private int type;

	public Project(int id, String name, int type)
	{
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Project(int id, String name)
	{
		this(id, name, TYPE_NORMAL);
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

	public boolean isTypeFinal()
	{
		return this.type == TYPE_FINAL;
	}
}
