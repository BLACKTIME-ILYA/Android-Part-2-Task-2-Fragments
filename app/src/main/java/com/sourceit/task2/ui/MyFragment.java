package com.sourceit.task2.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sourceit.task2.R;
import com.sourceit.task2.utils.L;

public class MyFragment extends Fragment{

    public static MyFragment newInstance() {
        MyFragment myFragment = new MyFragment();
        return myFragment;
    }

    private String currentTagOfFragment;

    public MyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment, container, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.d("click...");
                currentTagOfFragment = MyFragment.this.getTag();
                ((MainActivity)getActivity()).changeColors(currentTagOfFragment);
            }
        });

        return view;
    }
}
