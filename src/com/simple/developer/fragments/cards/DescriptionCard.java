package com.simple.developer.fragments.cards;

import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.RecyclableCard;
import com.simple.developer.fragments.R;

public class DescriptionCard extends RecyclableCard {

    public DescriptionCard(String title, String desc)
    {
        super(title, desc);
    }

    @Override
    protected void applyTo(View convertView) {
        ((TextView) convertView.findViewById(R.id.description)).setText(desc);
    }

    @Override
    protected int getCardLayoutId() {
        return R.layout.description_layout;
    }
}
