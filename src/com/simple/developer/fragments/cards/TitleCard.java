package com.simple.developer.fragments.cards;

import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.RecyclableCard;
import com.simple.developer.fragments.R;

public class TitleCard extends RecyclableCard {

    public TitleCard(String title)
    {
        super(title);
    }
    @Override
    protected void applyTo(View convertView)
    {
        ((TextView) convertView.findViewById(R.id.title)).setText(title);
    }

    @Override
    protected int getCardLayoutId() {
    return R.layout.title_layout;
    }
}
