package cn.formovie.fdp.std.area;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.HorizontalScrollView;

import static android.view.KeyEvent.KEYCODE_DPAD_LEFT;
import static android.view.KeyEvent.KEYCODE_DPAD_RIGHT;

public class XHorizontalScrollView extends HorizontalScrollView {
    public XHorizontalScrollView(Context context) {
        super(context);
    }

    public XHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean executeKeyEvent(KeyEvent event) {
        boolean rtn = super.executeKeyEvent(event);
        if (event.getAction() == KeyEvent.ACTION_DOWN && (event.getKeyCode() == KEYCODE_DPAD_RIGHT || event.getKeyCode() == KEYCODE_DPAD_LEFT) && canScroll()) {
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
