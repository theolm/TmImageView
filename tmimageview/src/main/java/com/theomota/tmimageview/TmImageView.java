package com.theomota.tmimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


/**
 * Created by theolm on 25/05/16.
 */
public class TmImageView extends ImageView implements View.OnClickListener {

    private OnClickListener clickListener;
    private Context context;
    private int animation_ref = R.anim.scale_up;

    public TmImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOnClickListener(this);
        this.context = context;
    }

    public TmImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
        this.context = context;

        for (int i = 0; i < attrs.getAttributeCount(); i++){
            if (attrs.getAttributeName(i).equals("animation")){
                try {
                    String anim = attrs.getAttributeValue(i);
                    animation_ref = Integer.valueOf(anim.replace("@", ""));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    public TmImageView(Context context) {
        super(context);
        setOnClickListener(this);
        this.context = context;
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        if (l == this) {
            super.setOnClickListener(l);
        } else {
            clickListener = l;
        }
    }

    @Override
    public void onClick(View view) {
        if (clickListener != null) {
            clickListener.onClick(this);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Animation anim = AnimationUtils.loadAnimation(context, animation_ref);
        anim.setFillAfter(true);

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            this.startAnimation(anim);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            anim.setInterpolator(new ReverseInterpolator());
            this.startAnimation(anim);
        }

        return super.onTouchEvent(event);
    }
}
