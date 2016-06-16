package com.pan.viewsample;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
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
        ImageButton frameAnimButton = (ImageButton) findViewById(R.id.ib_frame_anim);
        Button layoutAnimButton = (Button) findViewById(R.id.btn_layout_anim);
        Button offsetButton = (Button) findViewById(R.id.btn_offset_button);
        Button valueButton = (Button) findViewById(R.id.btn_value_button);

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
        if (javaScale != null) {
            javaScale.setAnimation(scaleAnimation);
        }

        //RotateAnimation
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360);
        rotateAnimation.setDuration(5000);
        if (javaRotate != null) {
            javaRotate.setAnimation(rotateAnimation);
        }

        Animation rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        if (xmlRotate != null) {
            xmlRotate.setAnimation(rotateAnim);
        }

        //TranslateAnimation
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 0);
        translateAnimation.setDuration(5000);
        if (javaTranslate != null) {
            javaTranslate.setAnimation(translateAnimation);
        }

        Animation translateAnim = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        if (xmlTranslate != null) {
            xmlTranslate.setAnimation(translateAnim);
        }

        //多种动画组合
        //动画集合，移动的同时，字体渐变透明
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(animation);
        set.addAnimation(translateAnim);
        set.setDuration(5000);
        if (setAnim != null) {
            setAnim.startAnimation(set);
        }

        //帧动画
        if (frameAnimButton != null) {
            AnimationDrawable background = (AnimationDrawable) frameAnimButton.getBackground();
            background.start();
        }

        //LayoutAnimation  为ViewGroup中的子元素设置动画
        layoutAnimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LayoutAnimActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
            }
        });

        //属性动画
        ObjectAnimator.ofFloat(offsetButton, "translationX", 100)
                .setDuration(500)
                .start();

        ObjectAnimator backAnim = ObjectAnimator.ofInt(valueButton, "backgroundColor", 0xffffff, 0x000000);
        backAnim.setDuration(5000);
        backAnim.setEvaluator(new ArgbEvaluator());
        backAnim.setRepeatCount(ValueAnimator.INFINITE);
        backAnim.setRepeatMode(ValueAnimator.REVERSE);
        backAnim.start();

    }


}
