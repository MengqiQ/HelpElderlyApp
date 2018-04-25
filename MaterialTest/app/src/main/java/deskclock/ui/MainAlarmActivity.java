package deskclock.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.materialtest.R;

public class MainAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_main);

        ImageButton button_alarm = (ImageButton) findViewById(R.id.button_alarm);

        button_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.vancior.deskclock.ACTION_ALARMLIST");
                intent.addCategory("com.vancior.deskclock.ALARMLIST_CATEGORY");
                startActivity(intent);
            }
        });
    }
}
