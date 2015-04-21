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
import com.simple.developer.fragments.cards.DescriptionCard;
import com.simple.developer.fragments.R;
import com.simple.developer.fragments.cards.TitleBodyCard;

public class InterfaceFragment extends Fragment {

    protected Activity mActivity;
    protected CardUI mCardViewBottom;
    protected WebView fragment_code;

    public InterfaceFragment(){}

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

        fragment_code.loadUrl("file:///android_asset/interfaces.html");

        mCardViewBottom = (CardUI)view.findViewById(R.id.fragment_one_bottom);
        mCardViewBottom.setSwipeable(false);

        CardStack stack = new CardStack();
        mCardViewBottom.addStack(stack);
        mCardViewBottom.setClickable(false);

        mCardViewBottom.addCard(new TitleBodyCard("Interface Explanation", mActivity.getString(R.string.interface_explanation)));
        mCardViewBottom.addCard(new DescriptionCard("",mActivity.getString(R.string.interface_bottom)));

        mCardViewBottom.refresh();

        return view;
    }
}

