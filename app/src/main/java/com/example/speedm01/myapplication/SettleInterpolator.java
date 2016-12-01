package com.example.speedm01.myapplication;

import android.animation.TimeInterpolator;

/**
 * Created by speedm01 on 01/12/2016.
 */
public class SettleInterpolator implements TimeInterpolator {

    private float initialSpeed = 0.2f;
    private float bounciness = 0.7f;
    private float dampening = 5.0f;

    public SettleInterpolator() {
    }

    public SettleInterpolator(float bounciness) {
        this.bounciness = bounciness;
    }

    public SettleInterpolator(float initialSpeed, float bounciness) {
        this.initialSpeed = initialSpeed;
        this.bounciness = bounciness;
    }

    //defaults 5.0f, 0.2f, 0.7f
    public SettleInterpolator(float dampening, float initialSpeed, float bounciness) {
        this.dampening = dampening;
        this.initialSpeed = initialSpeed;
        this.bounciness = bounciness;
    }

    @Override
    public float getInterpolation(float ratio) {
        if (ratio == 0.0f || ratio == 1.0f) return ratio;
        else {
            float twoPi = (float) (Math.PI * 1.7f);
            return (float) Math.pow(2.0f, -dampening * ratio) * (float) Math.sin((ratio - (bounciness / initialSpeed)) * twoPi / bounciness) + 1.0f;
        }
    }
}