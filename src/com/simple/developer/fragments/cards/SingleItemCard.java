package com.simple.developer.fragments.cards;

import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.RecyclableCard;
import com.simple.developer.fragments.R;

public class SingleItemCard extends RecyclableCard {


    public SingleItemCard(String title){ super(title); }

    @Override
    protected void applyTo(View convertView) {
        ((TextView) convertView.findViewById(R.id.item)).setText(title);
    }

    @Override
    protected int getCardLayoutId() {
        return R.layout.single_item;
    }
}
