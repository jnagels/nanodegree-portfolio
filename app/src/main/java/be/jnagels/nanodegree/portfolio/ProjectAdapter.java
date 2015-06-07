package be.jnagels.nanodegree.portfolio;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import be.jnagels.nanodegree.portfolio.model.Project;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>
{
	public interface OnProjectClickListener
	{
		void onProjectClick(Project project);
	}

	private final static int VIEW_TYPE_NORMAL = 0;
	private final static int VIEW_TYPE_FINAL = 1;

	private OnProjectClickListener onProjectClickListener;
	private ArrayList<Project> projects;

	public ProjectAdapter()
	{
		super();
		this.projects = new ArrayList<>();
	}

	public void setProjects(ArrayList<Project> projects)
	{
		this.projects = projects == null ? new ArrayList<Project>() : projects;
		this.notifyDataSetChanged();
	}

	public void setOnProjectClickListener(OnProjectClickListener onProjectClickListener)
	{
		this.onProjectClickListener = onProjectClickListener;
	}

	@Override
	public int getItemViewType(int position)
	{
		if (position == this.getItemCount()-1)
		{
			return VIEW_TYPE_FINAL;
		}
		return VIEW_TYPE_NORMAL;
	}

	@Override
	public ProjectAdapter.ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		switch(viewType)
		{
			case VIEW_TYPE_NORMAL:
				return new ProjectViewHolder(layoutInflater.inflate(R.layout.item_project, parent, false));

			case VIEW_TYPE_FINAL:
				return new ProjectViewHolder(layoutInflater.inflate(R.layout.item_project_final, parent, false));

			default:
				return null;
		}

	}

	@Override
	public void onBindViewHolder(ProjectAdapter.ProjectViewHolder holder, int position)
	{
		final Project item = this.projects.get(position);
		holder.button.setText(item.getName());
	}

	@Override
	public int getItemCount()
	{
		return this.projects.size();
	}


	public class ProjectViewHolder extends RecyclerView.ViewHolder
	{
		TextView button;

		public ProjectViewHolder(View itemView)
		{
			super(itemView);
			this.button = (TextView) itemView.findViewById(R.id.text);

			this.button.setOnClickListener(new View.OnClickListener()
										 {
											 @Override
											 public void onClick(View v)
											 {
												 if (onProjectClickListener != null)
												 {
													 final Project project = projects.get(getAdapterPosition());
													 onProjectClickListener.onProjectClick(project);
												 }
											 }
										 }
			);
		}
	}
}