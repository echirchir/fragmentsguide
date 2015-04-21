package com.simple.developer.fragments.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.simple.developer.fragments.R;
import com.simple.developer.fragments.activities.CoreAppActivity;
import com.simple.developer.fragments.async.FeedbackAsync;

public class FeedbackFragment extends Fragment implements View.OnClickListener{

    protected Activity mActivity;
    private EditText feedbackSubject;
    private EditText feedbackMessage;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        View view = inflater.inflate(R.layout.feed_back, container, false);

        Button send = (Button)view.findViewById(R.id.send);

        Button cancel = (Button)view.findViewById(R.id.cancel);

        cancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, CoreAppActivity.class));
            }
        });

        feedbackSubject = (EditText)view.findViewById(R.id.subject);

        feedbackMessage = (EditText)view.findViewById(R.id.message);

        send.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v)
    {
        String subject = feedbackSubject.getText().toString();

        String body = feedbackMessage.getText().toString();

        if(!subject.trim().equals(" ") && subject.length() < 4)
        {
            feedbackSubject.setError("Subject should be at least 4 characters long");
        }else if (body.length() < 5)
        {
            feedbackMessage.setError("Message should be at least 5 characters long");
        }else {

            new FeedbackAsync(mActivity).execute(subject, body);
        }

    }


}
