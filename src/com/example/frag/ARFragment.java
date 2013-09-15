package com.example.frag;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ARFragment extends Fragment {

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		container.removeAllViews();
		return inflater.inflate( R.layout.ar_fragment, container, false );
	}

}
