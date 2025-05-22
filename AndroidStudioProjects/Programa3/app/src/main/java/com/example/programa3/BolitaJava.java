package com.example.programa3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
/*
ALUMNO: MERCADO ROMERO YAHIR RICARDO
PROGRAMACIÓN MOVÍL, GURPO: 2807
 */
public class BolitaJava extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bolita bolita = new Bolita(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(bolita);
        setContentView(ll);
    }

    class Bolita extends View {
        private float posx = 50, posy = 200;

        public Bolita(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint circlePaint = new Paint();
            circlePaint.setColor(Color.BLUE);
            circlePaint.setAntiAlias(true); // Para bordes suaves
            canvas.drawCircle(posx, posy, 50, circlePaint);
        }
        /*
            ALUMNO: MERCADO ROMERO YAHIR RICARDO
            PROGRAMACIÓN MOVÍL, GURPO: 2807
        */
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    posx = event.getX();
                    posy = event.getY();
                    invalidate();
                    return true;
                default:
                    return super.onTouchEvent(event);
            }
        }
    }
}
