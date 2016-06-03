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
    private static final String TAG = "TmImageView";

    private OnClickListener clickListener;
    private Context context;

    public TmImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOnClickListener(this);
        this.context = context;
        Log.d(TAG, "TmImageView: 3");
    }

    public TmImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
        this.context = context;

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TmImageViewAttr);
        int teste = array.getResourceId(R.styleable.TmImageViewAttr_animation, -1);

        Log.d(TAG, "TmImageView: 1");


    }

    public TmImageView(Context context) {
        super(context);
        setOnClickListener(this);
        this.context = context;
        Log.d(TAG, "TmImageView: 2");
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

        Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale_up);
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
