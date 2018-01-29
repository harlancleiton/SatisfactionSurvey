package br.harlan.satisfactionsurvey.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import br.harlan.satisfactionsurvey.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TesteFragment extends Fragment {

    WebView webView;
    View rootView;

    public TesteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_teste, container, false);
        return rootView;
    }
}