
package com.huanghua.colorselecter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private SansumColorSelecter mColorSelecter;
    private ColorPickerView mColorPicker;
    private TextView mLogo;
    private RadioButton mSetTextColor;
    private RadioButton mSetTextBGColor;
    private RadioGroup mSetGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogo = (TextView) findViewById(R.id.logo);
        mSetTextColor = (RadioButton) findViewById(R.id.set_text_color);
        mSetTextBGColor = (RadioButton) findViewById(R.id.set_text_bg_color);
        mColorSelecter = (SansumColorSelecter) findViewById(R.id.color_seleter);
        mColorPicker = (ColorPickerView) mColorSelecter.findViewById(R.id.color_picker);
        mColorPicker.setOnColorChangeListenrer(new ColorPickerView.OnColorChangedListener() {
            @Override
            public void colorChanged(int color) {
                if (mSetTextColor.isChecked()) {
                    mLogo.setTextColor(color);
                } else if (mSetTextBGColor.isChecked()) {
                    mLogo.setBackgroundColor(color);
                }
            }
        });
        mColorSelecter.setColorSelecterLinstener(new SansumColorSelecter.ColorSelecterLinstener() {
            @Override
            public void onColorSeleter(int color) {
                if (mSetTextColor.isChecked()) {
                    mLogo.setTextColor(color);
                } else if (mSetTextBGColor.isChecked()) {
                    mLogo.setBackgroundColor(color);
                }
            }
        });
        mSetGroup = (RadioGroup) findViewById(R.id.set_group);
        mSetGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                changeLastColorByRadio(arg0.getCheckedRadioButtonId());
            }
        });
        changeLastColorByRadio(mSetGroup.getCheckedRadioButtonId());
    }

    private void changeLastColorByRadio(int id) {
        switch (id) {
            case R.id.set_text_color:
                mColorSelecter.setDIYColor(true, mColorPicker.getSelectColor());
                break;
            case R.id.set_text_bg_color:
                mColorSelecter.setDIYColor(false, 0);
                break;
        }
    }
}
