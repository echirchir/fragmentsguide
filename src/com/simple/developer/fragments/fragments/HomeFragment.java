package com.simple.developer.fragments.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.simple.developer.fragments.cards.ListItemCard;
import com.simple.developer.fragments.R;
import com.simple.developer.fragments.cards.TitleBodyCard;
import com.simple.developer.fragments.cards.TitleCard;


public class HomeFragment extends Fragment {

    private Activity mActivity;
    private CardUI mCardView;

    public HomeFragment(){}

    public void onAttach(Activity act)
    {
        super.onAttach(act);

        mActivity = act;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view  = inflater.inflate(R.layout.home_card_fragment, container, false);

        mCardView = (CardUI)view.findViewById(R.id.cardsview);
        mCardView.setSwipeable(false);

        CardStack stack = new CardStack();
        mCardView.addStack(stack);

        mCardView.setClickable(false);

        mCardView.addCardToLastStack(new TitleBodyCard("Fragments Ultimate Guide", mActivity.getString(R.string.intro)));

        mCardView.addCard(new TitleCard("Table of Contents"));
        mCardView.addCard(new ListItemCard("The definition of a fragment"));
        mCardView.addCard(new ListItemCard("The activity that hosts our fragments"));
        mCardView.addCard(new ListItemCard("The first fragment containing a list"));
        mCardView.addCard(new ListItemCard("The interface for communication"));
        mCardView.addCard(new ListItemCard("The second fragment containing the details"));

        mCardView.refresh();

        return view;
    }
}