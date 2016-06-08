package com.pan.viewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView xmlAlpha = (TextView) findViewById(R.id.tv_xml_alpha);
        TextView javaAlpha = (TextView) findViewById(R.id.tv_java_alpha);
        TextView xmlScale = (TextView) findViewById(R.id.tv_xml_scale);
        TextView javaScale = (TextView) findViewById(R.id.tv_java_scale);
        TextView xmlRotate = (TextView) findViewById(R.id.tv_xml_rotate);
        TextView javaRotate = (TextView) findViewById(R.id.tv_java_rotate);
        TextView xmlTranslate = (TextView) findViewById(R.id.tv_xml_translate);
        TextView javaTranslate = (TextView) findViewById(R.id.tv_java_translate);
        TextView setAnim = (TextView) findViewById(R.id.tv_set_animation);

        /*
         * 补间动画（View动画）
         */

        //Alpha动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        if (xmlAlpha != null) {
            xmlAlpha.startAnimation(animation);
        }

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);//定义动画
        alphaAnimation.setDuration(3000);//动画周期
        alphaAnimation.setFillAfter(true);//执行完毕后，保留状态
        alphaAnimation.setRepeatMode(Animation.REVERSE);//循环模式
        alphaAnimation.setRepeatCount(Animation.INFINITE);//循环次数
        if (javaAlpha != null) {
            javaAlpha.setAnimation(alphaAnimation);//为控件设置动画
        }
        alphaAnimation.start();//启动动画

        //ScaleAnimation
        Animation scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        if (xmlScale != null) {
            xmlScale.startAnimation(scaleAnim);
        }

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1f, 0.1f, 1f);
        scaleAnimation.setDuration(500);
        javaScale.setAnimation(scaleAnimation);

        //RotateAnimation
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360);
        rotateAnimation.setDuration(5000);
        javaRotate.setAnimation(rotateAnimation);

        Animation rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        xmlRotate.setAnimation(rotateAnim);

        //TranslateAnimation
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 0);
        translateAnimation.setDuration(5000);
        javaTranslate.setAnimation(translateAnimation);

        Animation translateAnim = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        xmlTranslate.setAnimation(translateAnim);


        //动画集合，移动的同时，字体渐变透明
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(animation);
        set.addAnimation(translateAnim);
        set.setDuration(5000);
        setAnim.startAnimation(set);

    }


}
