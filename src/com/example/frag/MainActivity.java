package com.example.frag;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		createTab( savedInstanceState );
	}

	private void createTab( Bundle inState ) {
		ActionBar bar = getActionBar();
		bar.setNavigationMode( ActionBar.NAVIGATION_MODE_TABS );
		bar.addTab( bar.newTab().setText( R.string.tab_title_map )
				.setTabListener( new TabControl<MapFragment>( this, "tag of MAP", MapFragment.class ) ) );
		bar.addTab( bar.newTab().setText( R.string.tab_title_ar )
				.setTabListener( new TabControl<ARFragment>( this, "tag of AR", ARFragment.class ) ) );
	}


	private static final class TabControl<T extends Fragment> implements ActionBar.TabListener {

		private Fragment _frag;
		private final Activity _act;
		private final String _tag;
		private final Class<T> _clazz;

		public TabControl( Activity act, String tag, Class<T> clazz ) {
			_act = act;
			_tag = tag;
			_clazz = clazz;
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTabSelected( Tab tab, FragmentTransaction ft ) {
			if( _frag != null ) {
				ft.attach( _frag );
			} else {
				_frag = Fragment.instantiate( _act, _clazz.getName() );
				ft.add( android.R.id.content, _frag, _tag );
			}
		}

		@Override
		public void onTabUnselected( Tab tab, FragmentTransaction ft ) {
			if( _frag != null ) {
				ft.detach( _frag );
			}
		}

	}

}

