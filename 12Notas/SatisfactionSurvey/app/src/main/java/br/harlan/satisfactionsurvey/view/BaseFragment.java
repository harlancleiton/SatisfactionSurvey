package br.harlan.satisfactionsurvey.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.harlan.satisfactionsurvey.singleton.MessageServicesSingleton;
import br.harlan.satisfactionsurvey.singleton.NavigationServicesSingleton;
import br.harlan.satisfactionsurvey.view.services.MessageServices;
import br.harlan.satisfactionsurvey.view.services.NavigationServices;

public abstract class BaseFragment extends Fragment {

    //region Variables
    protected View viewRoot;
    protected MessageServices messageServices;
    protected NavigationServices navigationServices;
    @LayoutRes
    protected int layout;
    //endregion Variables

    public BaseFragment(@LayoutRes int layout) {
        this.layout = layout;
    }

    //region Methods
    //region OnCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewRoot = inflater.inflate(layout, container, false);
        messageServices = MessageServicesSingleton.getInstance(getActivity());
        navigationServices = NavigationServicesSingleton.getInstance(getActivity());
        initializeComponents(viewRoot);
        addEvents();
        return viewRoot;
    }
    //endregion OnCreateView
    protected abstract void initializeComponents(View viewRoot);

    protected abstract void addEvents();
    //endregion Methods
}