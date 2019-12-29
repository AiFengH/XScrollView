package com.aaron.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.HorizontalScrollView;

public class XHorizontalView extends HorizontalScrollView {
    public XHorizontalView(Context context) {
        super(context);
    }

    public XHorizontalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XHorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean executeKeyEvent(KeyEvent event) {
        boolean rtn = super.executeKeyEvent(event);
        if (event.getAction() == KeyEvent.ACTION_DOWN && canScroll()) {
            findFocus().playSoundEffect(SoundEffectConstants.CLICK);
        }
        return rtn;
    }

    private boolean canScroll() {
        View child = getChildAt(0);
        if (child != null) {
            int childWidth = child.getWidth();
            return getWidth() < childWidth + getPaddingLeft() + getPaddingRight();
        }
        return false;
    }

}
