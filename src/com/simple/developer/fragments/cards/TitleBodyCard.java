package com.simple.developer.fragments.cards;

import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.RecyclableCard;
import com.simple.developer.fragments.R;

public class TitleBodyCard extends RecyclableCard {

    public TitleBodyCard(String title, String desc){
        super(title, desc);
    }

    @Override
    protected int getCardLayoutId() {
        return R.layout.title_body_card;
    }

    @Override
    protected void applyTo(View convertView) {
        ((TextView) convertView.findViewById(R.id.title)).setText(title);
        ((TextView) convertView.findViewById(R.id.description)).setText(desc);
    }
}
