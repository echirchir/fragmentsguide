package com.simple.developer.fragments.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.simple.developer.fragments.R;
import com.simple.developer.fragments.cards.SingleItemCard;
import com.simple.developer.fragments.cards.TitleBodyCard;
import com.simple.developer.fragments.cards.TitleCard;

public class ConclusionFragment extends Fragment {

    private Activity mActivity;
    private CardUI mCardView;

    public ConclusionFragment(){}

    public void onAttach(Activity act)
    {
        super.onAttach(act);

        mActivity = act;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view  = inflater.inflate(R.layout.conclusion_fragment, container, false);

        mCardView = (CardUI)view.findViewById(R.id.conclusion);
        mCardView.setSwipeable(false);

        CardStack stack = new CardStack();
        mCardView.addStack(stack);
        mCardView.setClickable(false);

        mCardView.addCardToLastStack(new TitleBodyCard("Fragments Ultimate Guide Summary", mActivity.getString(R.string.conclusion_header)));

        mCardView.addCard(new TitleCard("General Steps Required"));
        mCardView.addCard(new SingleItemCard("Create Your Main Activity"));
        mCardView.addCard(new SingleItemCard("Create Your Fragment(s)"));
        mCardView.addCard(new SingleItemCard("Create Your Interface with method(s)"));
        mCardView.addCard(new SingleItemCard("Implement Your Interface in Your Activity"));
        mCardView.addCard(new SingleItemCard("Override Your Interface's method in your Activity"));
        mCardView.addCard(new SingleItemCard("Create an instance of your interface by casting your activity to it; inside your fragment"));
        mCardView.addCard(new SingleItemCard("When ready to notify the activity, call the interface method passing the required arguments."));
        mCardView.addCard(new SingleItemCard("Inside your activity, find your next fragment using the fragment manager."));
        mCardView.addCard(new SingleItemCard("If your second fragment does not have a method, create one."));
        mCardView.addCard(new SingleItemCard("In the interface method you overrode(activity), call the second fragment's method to notify it of changes"));
        mCardView.addCard(new SingleItemCard("In fragment two's method, make the changes that the user expected to see."));

        mCardView.refresh();

        return view;
    }
}
