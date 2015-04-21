package com.simple.developer.fragments.cards;

import android.view.View;
import android.widget.TextView;
import com.fima.cardsui.objects.RecyclableCard;
import com.simple.developer.fragments.R;

public class ListItemCard extends RecyclableCard {

    public ListItemCard(String title)
    {
        super(title);
    }

    @Override
    protected int getCardLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void applyTo(View convertView) {
        ((TextView) convertView.findViewById(R.id.item)).setText(title);
    }
}
