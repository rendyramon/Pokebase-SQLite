package com.app.main.pokebase.gui.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.main.pokebase.R;
import com.app.main.pokebase.gui.adapters.ItemListAdapter;
import com.app.main.pokebase.gui.views.AnimatedRecyclerView;
import com.app.main.pokebase.model.components.Item;
import com.app.main.pokebase.model.database.DatabaseOpenHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Tyler Wong
 */
public class ItemsFragment extends Fragment {
   @BindView(R.id.items_list)
   AnimatedRecyclerView mItemsList;

   private DatabaseOpenHelper mDatabaseHelper;
   private Unbinder mUnbinder;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      getActivity().setTheme(R.style.PokemonEditorTheme);
      mDatabaseHelper = DatabaseOpenHelper.getInstance(getContext());
      setHasOptionsMenu(true);
   }

   @Override
   public void onResume() {
      super.onResume();
      getActivity().setTheme(R.style.PokemonEditorTheme);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.items_fragment, container, false);
      mUnbinder = ButterKnife.bind(this, view);

      ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
      if (actionBar != null) {
         actionBar.setTitle(R.string.items);
      }

      mItemsList.setLayoutManager(new LinearLayoutManager(getContext()));
      mItemsList.setHasFixedSize(true);

      new LoadItems().execute();

      return view;
   }

   @Override
   public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
      super.onCreateOptionsMenu(menu, inflater);
      menu.findItem(R.id.clear_all_teams_action).setVisible(false);
      menu.findItem(R.id.number_action).setVisible(false);
      menu.findItem(R.id.name_action).setVisible(false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
         default:
            break;
      }
      return super.onOptionsItemSelected(item);
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      mUnbinder.unbind();
   }

   private class LoadItems extends AsyncTask<Void, Void, Item[]> {
      @Override
      protected Item[] doInBackground(Void... params) {
         return mDatabaseHelper.queryAllItems();
      }

      @Override
      protected void onPostExecute(Item[] loaded) {
         mItemsList.setAdapter(new ItemListAdapter(getContext(), loaded));
      }
   }
}
