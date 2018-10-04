package com.example.a503_08.a1004eventrouting;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    //텍스트 뷰에 출력할 문자열
    String [] ar ={"안녕하세요","녕하세요안","하세요안녕","세요안녕하","요안녕하세"};



    CountDownTimer timer;

    //버튼을 눌렀을 때 호출될 메소드 - layout 파일에 설정
    public void click(View v){
        timer.start();
       /* TextView textView = (TextView)findViewById(R.id.textView);

        try{
            for (int i=0; i<10; i++){
                textView.setText(ar[i%5]);
                Thread.sleep(1000);
            }
        }catch (Exception e){}
*/

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);


        timer = new CountDownTimer(10000,1000){
            TextView textView = (TextView)findViewById(R.id.textView);
            int idx = 0;
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(ar[idx%5]);

                idx = idx +1;
            }

            @Override
            public void onFinish() {
                textView.setText("타이머 종료");
            }
        };
    }
}
