package com.example.cedar.myfirstweb;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {

    public class MyView extends View {
        public MyView(Context context){
            super(context);
        }
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.beauty);
            int width  = canvas.getWidth();
            int height = canvas.getHeight();
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            canvas.drawLine(0, 0, width-1, height -1, paint);
            Rect rect1 = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            Rect rect2 = new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            canvas.drawBitmap(bitmap, rect2, rect1, null);
            invalidate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new MyView(this));
    }
}
