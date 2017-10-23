package com.bibby.checkclickimageviewtransparent;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ImageButton layer1;
    private ImageButton layer2;
    private ImageButton layer3;
    private ImageButton layer4;
    private ImageButton layer5;

    private Bitmap bitmaplayer1, bitmaplayer2, bitmaplayer3, bitmaplayer4, bitmaplayer5;

    private boolean layer1Transparent = false;
    private boolean layer2Transparent = false;
    private boolean layer3Transparent = false;
    private boolean layer4Transparent = false;
    private boolean layer5Transparent = false;

    private float bitmapscale;

    private FrameLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("1015", "density:" + getResources().getDisplayMetrics().density);
        Log.d("1015", "densityDpi:" + getResources().getDisplayMetrics().densityDpi);
        Log.d("1015", "scaledDensity:" + getResources().getDisplayMetrics().scaledDensity);
        Log.d("1015", "heightPixels:" + getResources().getDisplayMetrics().heightPixels);
        Log.d("1015", "widthPixels:" + getResources().getDisplayMetrics().widthPixels);
        Log.d("1015", "xdpi:" + getResources().getDisplayMetrics().xdpi);
        Log.d("1015", "ydpi:" + getResources().getDisplayMetrics().ydpi);

        /*
            /Samsung note4/

            density:4.0
            densityDpi:640
            scaledDensity:4.0
            heightPixels:2560
            widthPixels:1440
            xdpi:515.154
            ydpi:520.192
        */

        bitmapscale = getResources().getDisplayMetrics().scaledDensity/((float) getResources().getDisplayMetrics().widthPixels/540f);

        init();

    }

    private void init(){
        main = this.findViewById(R.id.mainLayout);

        //BitmapDrawable ob = new BitmapDrawable(getResources(), decodeSampledBitmapFromResource(getResources(), R.drawable.home_bg, 640, 360));
        //main.setBackground(ob);

        layer1 = this.findViewById(R.id.more);
        layer2 = this.findViewById(R.id.talk);
        layer3 = this.findViewById(R.id.shopping);
        layer4 = this.findViewById(R.id.coupon);
        layer5 = this.findViewById(R.id.video);

        bitmaplayer1 = ((BitmapDrawable) (layer1.getDrawable())).getBitmap();
        bitmaplayer2 = ((BitmapDrawable) (layer2.getDrawable())).getBitmap();
        bitmaplayer3 = ((BitmapDrawable) (layer3.getDrawable())).getBitmap();
        bitmaplayer4 = ((BitmapDrawable) (layer4.getDrawable())).getBitmap();
        bitmaplayer5 = ((BitmapDrawable) (layer5.getDrawable())).getBitmap();

//        layer1.setOnClickListener(layerClickListener);
        layer1.setOnTouchListener(layerTouchListener);
//        layer2.setOnClickListener(layerClickListener);
        layer2.setOnTouchListener(layerTouchListener);
//        layer3.setOnClickListener(layerClickListener);
        layer3.setOnTouchListener(layerTouchListener);
//        layer4.setOnClickListener(layerClickListener);
        layer4.setOnTouchListener(layerTouchListener);
//        layer5.setOnClickListener(layerClickListener);
        layer5.setOnTouchListener(layerTouchListener);
    }

    private View.OnClickListener layerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i("test", "click");
            switch (view.getId()){
                case R.id.more:
                    Log.i("1015", "click more");
                    if(!layer1Transparent)
                    {
                        Log.i("test", "more 點擊");
                        clickanimation(view);
                        Toast.makeText(MainActivity.this, "more 點擊", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.talk:
                    Log.i("1015", "click talk");
                    if(!layer2Transparent)
                    {
                        Log.i("test", "talk 點擊");
                        clickanimation(view);
                        Toast.makeText(MainActivity.this, "talk 點擊", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.shopping:
                    Log.i("1015", "click shopping");
                    if(!layer3Transparent)
                    {
                        Log.i("test", "shopping 點擊");
                        clickanimation(view);
                        Toast.makeText(MainActivity.this, "shopping 點擊", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.coupon:
                    Log.i("1015", "click coupon");
                    if(!layer4Transparent)
                    {
                        Log.i("test", "coupon 點擊");
                        clickanimation(view);
                        Toast.makeText(MainActivity.this, "coupon 點擊", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.video:
                    Log.i("1015", "click video");
                    if(!layer5Transparent)
                    {
                        Log.i("test", "video 點擊");
                        clickanimation(view);
                        Toast.makeText(MainActivity.this, "video 點擊", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

    private View.OnTouchListener layerTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            Log.d("1015", "touch");

            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                Log.i("log", "action_down");

                Log.d("1015", "event.getX():"+event.getX());
                Log.d("1015", "event.getY():"+event.getY());

                Log.d("1015", "event.getRawX():"+event.getRawX());
                Log.d("1015", "event.getRawY():"+event.getRawY());

                Log.d("1015", "parent event.getX():" + (view.getLeft() + (int)event.getX()));
                Log.d("1015", "parent event.getY():" + (view.getTop() + (int)event.getY()));

                Log.d("1015", "view getRelativeTop:" + getRelativeTop(view));
                int relativetop = getRelativeTop(view);

                int pixel_x = (int)((event.getX()*bitmapscale));
                int pixel_y = ((int)(((int)event.getRawY()-relativetop)*bitmapscale));
                Log.d("1015", "pixel_x:" + pixel_x);
                Log.d("1015", "pixel_y:" + pixel_y);

                switch (view.getId()){
                    case R.id.more:

                        Log.d("1015", "bitmaplayer1.getDensity():"+bitmaplayer1.getDensity());
                        Log.d("1015", "bitmaplayer1.getWidth():"+bitmaplayer1.getWidth());
                        Log.d("1015", "bitmaplayer1.getHeight():"+bitmaplayer1.getHeight());

                        Log.d("1015", "((ImageButton)view).getWidth():"+view.getWidth());
                        Log.d("1015", "((ImageButton)view).getHeight():"+view.getHeight());

                        if(bitmaplayer1.getPixel(pixel_x,pixel_y)==0)
                        {
                            Log.i("test", "more 透明區域");
                            layer1Transparent = true;
                        }
                        else
                        {
                            Log.i("test", "more實體區域");
                            layer1Transparent = false;
                            clickanimation(view);
                            Toast.makeText(MainActivity.this, "more 點擊", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        break;
                    case R.id.talk:

                        Log.d("1015", "bitmaplayer2.getDensity():"+bitmaplayer2.getDensity());
                        Log.d("1015", "bitmaplayer2.getWidth():"+bitmaplayer2.getWidth());
                        Log.d("1015", "bitmaplayer2.getHeight():"+bitmaplayer2.getHeight());

                        Log.d("1015", "((ImageButton)view).getWidth():"+view.getWidth());
                        Log.d("1015", "((ImageButton)view).getHeight():"+view.getHeight());

                        if(bitmaplayer2.getPixel(pixel_x,pixel_y)==0)
                        {
                            Log.i("test", "talk 透明區域");
                            layer2Transparent = true;
                            layer1.dispatchTouchEvent(event);
                        }
                        else
                        {
                            Log.i("test", "talk 實體區域");
                            layer2Transparent = false;
                            clickanimation(view);
                            Toast.makeText(MainActivity.this, "talk 點擊", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        break;
                    case R.id.shopping:

                        Log.d("1015", "bitmaplayer3.getDensity():"+bitmaplayer3.getDensity());
                        Log.d("1015", "bitmaplayer3.getWidth():"+bitmaplayer3.getWidth());
                        Log.d("1015", "bitmaplayer3.getHeight():"+bitmaplayer3.getHeight());

                        Log.d("1015", "((ImageButton)view).getWidth():"+view.getWidth());
                        Log.d("1015", "((ImageButton)view).getHeight():"+view.getHeight());

                        if(bitmaplayer3.getPixel(pixel_x,pixel_y)==0)
                        {
                            Log.i("test", "shopping 透明區域");
                            layer3Transparent = true;
                            layer2.dispatchTouchEvent(event);
                        }
                        else
                        {
                            Log.i("test", "shopping 實體區域");
                            layer3Transparent = false;
                            clickanimation(view);
                            Toast.makeText(MainActivity.this, "shopping 點擊", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        break;
                    case R.id.coupon:

                        Log.d("1015", "bitmaplayer4.getDensity():"+bitmaplayer4.getDensity());
                        Log.d("1015", "bitmaplayer4.getWidth():"+bitmaplayer4.getWidth());
                        Log.d("1015", "bitmaplayer4.getHeight():"+bitmaplayer4.getHeight());

                        Log.d("1015", "((ImageButton)view).getWidth():"+view.getWidth());
                        Log.d("1015", "((ImageButton)view).getHeight():"+view.getHeight());

                        if(bitmaplayer4.getPixel(pixel_x,pixel_y)==0)
                        {
                            Log.i("test", "coupon 透明區域");
                            layer4Transparent = true;
                            layer3.dispatchTouchEvent(event);
                        }
                        else
                        {
                            Log.i("test", "coupon 實體區域");
                            layer4Transparent = false;
                            clickanimation(view);
                            Toast.makeText(MainActivity.this, "coupon 點擊", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        break;
                    case R.id.video:

                        Log.d("1015", "bitmaplayer5.getDensity():"+bitmaplayer5.getDensity());
                        Log.d("1015", "bitmaplayer5.getWidth():"+bitmaplayer5.getWidth());
                        Log.d("1015", "bitmaplayer5.getHeight():"+bitmaplayer5.getHeight());

                        Log.d("1015", "((ImageButton)view).getWidth():"+view.getWidth());
                        Log.d("1015", "((ImageButton)view).getHeight():"+view.getHeight());

                        if(bitmaplayer5.getPixel(pixel_x,pixel_y)==0)
                        {
                            Log.i("test", "video 透明區域");
                            layer5Transparent = true;
                            layer4.dispatchTouchEvent(event);
                        }
                        else
                        {
                            Log.i("test", "video 實體區域");
                            layer5Transparent = false;
                            clickanimation(view);
                            Toast.makeText(MainActivity.this, "video 點擊", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        break;
                }

            }
//            else if (event.getAction() == MotionEvent.ACTION_UP)
//            {
//                Log.i("log", "action_up");
//                return true;
//            }
//            else if (event.getAction() == MotionEvent.ACTION_MOVE)
//            {
//                Log.i("log", "action_move");
//                return true;
//            }

            return false;
        }
    };

    private void clickanimation(View view){
//            view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.image_click));

        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 1f);
        alphaAnimation.setDuration(100);
        alphaAnimation.setStartOffset(100);
        animationSet.addAnimation(alphaAnimation);
        //animationSet.setStartOffset(10000);
        animationSet.setFillBefore(false);
        animationSet.setFillAfter(true);
        view.startAnimation(animationSet);
    }

    /* REF https://stackoverflow.com/questions/3619693/getting-views-coordinates-relative-to-the-root-layout */

    private int getRelativeTop(View myView) {
        if (myView.getParent() == myView.getRootView())
            return myView.getTop();
        else
            return myView.getTop() + getRelativeTop((View) myView.getParent());
    }

    private int getRelativeLeft(View myView) {
        if (myView.getParent() == myView.getRootView())
            return myView.getLeft();
        else
            return myView.getLeft() + getRelativeLeft((View) myView.getParent());
    }

    /* REF https://developer.android.com/topic/performance/graphics/load-bitmap.html */

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
