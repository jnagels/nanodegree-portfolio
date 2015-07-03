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
	private final String packageName;

	public Project(int id, String name, int type, String packageName)
	{
		this.id = id;
		this.name = name;
		this.type = type;
		this.packageName = packageName;
	}

	public Project(int id, String name, String packageName)
	{
		this(id, name, TYPE_NORMAL, packageName);
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

	public String getPackageName()
	{
		return packageName;
	}

	public boolean isTypeFinal()
	{
		return this.type == TYPE_FINAL;
	}
}
