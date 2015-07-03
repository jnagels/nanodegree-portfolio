package be.jnagels.nanodegree.portfolio;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import be.jnagels.nanodegree.portfolio.model.Portfolio;
import be.jnagels.nanodegree.portfolio.model.Project;


public class PortfolioActivity extends AppCompatActivity implements ProjectAdapter.OnProjectClickListener
{

	private Portfolio portfolio;
	private ProjectAdapter adapter;

	private Toast toast;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_portfolio);

		this.portfolio = new Portfolio();

		this.adapter = new ProjectAdapter();
		this.adapter.setProjects(this.portfolio.getProjects());
		this.adapter.setOnProjectClickListener(this);


		final int spanCount = getResources().getInteger(R.integer.projectitems_per_row);
		final GridLayoutManager layoutManager = new GridLayoutManager(this, spanCount);

		final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(this.adapter);
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();

		//clear up
		this.adapter.setOnProjectClickListener(null);
		this.portfolio = null;

		this.closeToast();
	}

	private void closeToast()
	{
		if (this.toast != null)
		{
			this.toast.cancel();
			this.toast = null;
		}
	}

	@Override
	public void onProjectClick(Project project)
	{
		this.closeToast();

		if (TextUtils.isEmpty(project.getAction()))
		{
			String message = getString(R.string.open_project, project.getName());

			this.toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
			this.toast.show();
		}
		else
		{
			try
			{
				final Intent intent = new Intent(project.getAction());
				startActivity(intent);
			}
			catch(ActivityNotFoundException ex)
			{
				String message = getString(R.string.open_project_failed, project.getName());
				this.toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
				this.toast.show();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_portfolio, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
