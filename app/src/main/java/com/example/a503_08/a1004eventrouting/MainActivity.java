package com.example.a503_08.a1004eventrouting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        String msg = String.format("TouchEvent" + " x:%.1f y:%.1f", x, y);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final Button animationstart =(Button)findViewById(R.id.animationstart);
       final ImageView imageView = (ImageView)findViewById(R.id.imageView);

       animationstart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //애니메이션 가져오기
               //Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
               Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);

               //뷰에 애니메이션 적용
               imageView.startAnimation(animation);
           }
       });




        final Button btn1 = (Button) findViewById(R.id.btn1);

        final Button btn2 = (Button) findViewById(R.id.btn2);


       /* btnfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"첫번째 버튼을 클릭하셨습니다.",Toast.LENGTH_LONG).show();
            }
        });


        btnsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"두번째 버튼을 클릭하셨습니다.",Toast.LENGTH_LONG).show();
            }
        });
        */


        View.OnClickListener eventHandler = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                String msg = btn.getText().toString();

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        };

        //이벤트 처리 객체 연결
        btn1.setOnClickListener(eventHandler);
        btn2.setOnClickListener(eventHandler);


    }
}
