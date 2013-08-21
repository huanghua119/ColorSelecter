
package com.huanghua.colorselecter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class SansumColorSelecter extends RelativeLayout {

    public SansumColorSelecter(Context context) {
        this(context, null);
    }

    public SansumColorSelecter(Context context, AttributeSet attrs) {
        super(context, attrs);
        final LayoutInflater inflater = LayoutInflater.from(context);

        inflater.inflate(R.layout.samsung_color_selecter, this, true);
    }

}
