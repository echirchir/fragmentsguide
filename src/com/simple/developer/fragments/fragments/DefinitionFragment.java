package com.simple.developer.fragments.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.simple.developer.fragments.cards.DescriptionCard;
import com.simple.developer.fragments.R;
import com.simple.developer.fragments.cards.TitleCard;

public class DefinitionFragment extends Fragment {

    private Activity mActivity;
    private CardUI mCardView;

    public DefinitionFragment(){}

    public void onAttach(Activity act)
    {
        super.onAttach(act);

        mActivity = act;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view  = inflater.inflate(R.layout.definition_card_fragment, container, false);

        mCardView = (CardUI)view.findViewById(R.id.definition);
        mCardView.setSwipeable(true);

        CardStack stack = new CardStack();
        mCardView.addStack(stack);
        mCardView.setClickable(false);

        mCardView.addCardToLastStack(new TitleCard("What Is a Fragment?"));
        mCardView.addCard(new DescriptionCard("", mActivity.getString(R.string.frag_definition_top)));
        mCardView.addCard(new DescriptionCard("", mActivity.getString(R.string.frag_definition_center)));
        mCardView.addCard(new DescriptionCard("", mActivity.getString(R.string.frag_definition_bottom)));
        mCardView.addCard(new DescriptionCard("", mActivity.getString(R.string.frag_definition_last)));
        mCardView.refresh();

        return view;
    }
}
