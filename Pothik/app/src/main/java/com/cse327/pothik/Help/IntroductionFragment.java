package com.cse327.pothik.Help;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cse327.pothik.R;

import io.smooch.ui.ConversationActivity;

public class IntroductionFragment extends Fragment {

    public IntroductionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.chat_fragment_main, container, false);

        Button mHelpBtn = (Button) rootView.findViewById(R.id.button_help);
        mHelpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Showing Smooch on the button click
                ConversationActivity.show(getActivity(), Intent.FLAG_ACTIVITY_NEW_TASK);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((ChatActivity) context).onSectionAttached(1);
    }

}
