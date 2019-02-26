package io.sado.eventcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegistActivity extends AppCompatActivity {

    private Button buttonRegist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        // 登録ボタン
        buttonRegist = (Button) findViewById(R.id.submit);
        buttonRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), TopActivity.class);
                startActivity(intent);
            }
        });
    }
}
