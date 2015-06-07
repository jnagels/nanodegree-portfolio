package be.jnagels.nanodegree.portfolio;

import android.content.res.Resources;
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
	public ProjectAdapter.ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);
		return new ProjectViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ProjectAdapter.ProjectViewHolder holder, int position)
	{
		final Project item = this.projects.get(position);
		holder.button.setText(item.getName());

		final Resources res = holder.button.getResources();
		holder.button.setBackgroundColor(item.isTypeFinal() ? res.getColor(R.color.project_button_background_final) : res.getColor(R.color.project_button_background_normal));
	}

	@Override
	public int getItemCount()
	{
		return this.projects.size();
	}


	public final class ProjectViewHolder extends RecyclerView.ViewHolder
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