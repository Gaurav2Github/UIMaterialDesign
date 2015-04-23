package com.gauravtproject.android.uimaterialdesign.app.ui;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;

import com.gauravtproject.android.uimaterialdesign.app.R;


/**
 * Created by Gaurav Tandon on 27/03/2015.
 */
public class CardFrameLayout extends FrameLayout {
    public CardFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }
    public CardFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * {@inheritDoc}
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        final float radius = getResources().getDimensionPixelSize(R.dimen.card_corner_radius);
        final int vw  = w;
        final int vh = h;

        final ViewOutlineProvider vop = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, vw, vh, radius);
            }
        };

        setOutlineProvider(vop);
        setClipToOutline(true);
    }
}
