package com.app.main.pokebase.gui.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.app.main.pokebase.R;
import com.app.main.pokebase.gui.fragments.PreferencesFragment;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Tyler Wong
 */
public class PreferencesActivity extends AppCompatActivity {
   @BindView(R.id.toolbar)
   Toolbar mToolbar;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_preferences);
      ButterKnife.bind(this);

      getFragmentManager().beginTransaction()
            .replace(R.id.frame, new PreferencesFragment())
            .commit();

      setSupportActionBar(mToolbar);
      ActionBar actionBar = getSupportActionBar();

      if (actionBar != null) {
         actionBar.setDisplayHomeAsUpEnabled(true);
         actionBar.setTitle(getString(R.string.settings));
      }

      SlidrConfig config = new SlidrConfig.Builder()
            .sensitivity(1f)
            .scrimColor(Color.BLACK)
            .scrimStartAlpha(0.8f)
            .scrimEndAlpha(0f)
            .velocityThreshold(2400)
            .distanceThreshold(0.25f)
            .edge(true)
            .edgeSize(0.18f)
            .build();

      Slidr.attach(this, config);
   }


   @Override
   public boolean onOptionsItemSelected(final MenuItem item) {
      if (item.getItemId() == android.R.id.home) {
         finish();
      }

      return true;
   }
}
