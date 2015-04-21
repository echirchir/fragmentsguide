package com.simple.developer.fragments.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.simple.developer.fragments.R;
import com.simple.developer.fragments.cards.TitleBodyCard;

public class ActivityFragment extends Fragment {

    protected Activity mActivity;
    protected CardUI mCardViewBottom;
    protected WebView fragment_code;

    public ActivityFragment(){}

    public void onAttach(Activity act)
    {
        super.onAttach(act);

        mActivity = act;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view  = inflater.inflate(R.layout.fragment_one_card, container, false);

        fragment_code = (WebView)view.findViewById(R.id.fragment_one_code);
        fragment_code.getSettings().setBuiltInZoomControls(true);

        fragment_code.loadUrl("file:///android_asset/activity.html");

        mCardViewBottom = (CardUI)view.findViewById(R.id.fragment_one_bottom);
        mCardViewBottom.setSwipeable(true);

        CardStack stack = new CardStack();
        mCardViewBottom.addStack(stack);

        mCardViewBottom.addCard(new TitleBodyCard("Activity Explanation", mActivity.getString(R.string.activity_explanation)));
        mCardViewBottom.refresh();

        return view;
    }
}
