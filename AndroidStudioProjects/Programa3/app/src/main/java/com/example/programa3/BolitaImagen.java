package com.example.programa3;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class BolitaImagen extends Activity {
    private ImageView movableImage;
    private FrameLayout parentLayout;
    private float dX, dY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bolitaimagen);

        movableImage = findViewById(R.id.movable_image);
        parentLayout = findViewById(R.id.parent_layout);

        movableImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getX();
                        dY = view.getY() - event.getY();
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        float newX = event.getX() + dX;
                        float newY = event.getY() + dY;

                        // Limitar dentro del contenedor
                        int parentWidth = parentLayout.getWidth();
                        int parentHeight = parentLayout.getHeight();
                        int imageWidth = view.getWidth();
                        int imageHeight = view.getHeight();

                        if (newX < 0) newX = 0;
                        if (newY < 0) newY = 0;
                        if (newX + imageWidth > parentWidth) newX = parentWidth - imageWidth;
                        if (newY + imageHeight > parentHeight) newY = parentHeight - imageHeight;

                        view.setX(newX);
                        view.setY(newY);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
}
