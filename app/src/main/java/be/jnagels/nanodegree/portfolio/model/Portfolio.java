package be.jnagels.nanodegree.portfolio.model;

import java.util.ArrayList;

/**
 * Created by jelle on 07/06/15.
 */
public class Portfolio
{
	private ArrayList<Project> projects;

	public Portfolio()
	{
		this.projects = new ArrayList<>();
		this.createProjects();
	}

	private void createProjects()
	{
		this.projects.add(new Project(0, "Spotify Streamer", "be.jnagels.nanodegree.spotify"));
		this.projects.add(new Project(1, "Scores App", null));
		this.projects.add(new Project(2, "Library App", null));
		this.projects.add(new Project(3, "Build it bigger", null));
		this.projects.add(new Project(4, "XYZ Reader", null));
		this.projects.add(new Project(5, "Capstone: My own app", Project.TYPE_FINAL, null));
	}

	public ArrayList<Project> getProjects()
	{
		return projects;
	}
}
