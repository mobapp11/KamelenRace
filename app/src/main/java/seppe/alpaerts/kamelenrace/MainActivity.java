package seppe.alpaerts.kamelenrace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import seppe.alpaerts.kamelenrace.util.ProgressHandler;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbSepperay, pbMagicMike, pbLeonaire;
    private TextView tvSepperay, tvMagicMike, tvLeonaire;
    private Button btnStart;

    private boolean isRunning = false;
    private ProgressHandler handlerSepperay, handlerMagicMike, handlerLeonaire;
    private View.OnClickListener StartListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!isRunning)
                startThread();
            if (!isRunning)
                startThread2();
            if (!isRunning)
                startThread3();

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSepperay = findViewById(R.id.tv_sepperay);
        tvMagicMike = findViewById(R.id.tv_magicmike);
        tvLeonaire = findViewById(R.id.tv_leonaire);
        pbSepperay = findViewById(R.id.pb_sepperay);
        pbMagicMike = findViewById(R.id.pb_magicmike);
        pbLeonaire = findViewById(R.id.pb_leonaire);
        btnStart = findViewById(R.id.btn_start);

        handlerSepperay = new ProgressHandler(pbSepperay, tvSepperay);
        handlerMagicMike = new ProgressHandler(pbMagicMike, tvMagicMike);
        handlerLeonaire = new ProgressHandler(pbLeonaire, tvLeonaire);
        btnStart.setOnClickListener(StartListener);
    }

    private void startThread() {

        final int min = 100;
        final int max = 200;
        final int random = new Random().nextInt((max - min) + 1) + min;
        Thread bgThread = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                for (int i = 0; i <= 20; i++) {

                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Message msgSepperay = new Message();
                    msgSepperay.arg1 = i;
                    handlerSepperay.sendMessage(msgSepperay);


                }
                isRunning = false;
            }


        });
        bgThread.start();
    }

    private void startThread2() {

        final int min = 100;
        final int max = 200;
        final int random = new Random().nextInt((max - min) + 1) + min;

        Thread bgThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                for (int i = 0; i <= 20; i++) {

                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Message msgMagicMike = new Message();
                    msgMagicMike.arg1 = i;
                    handlerMagicMike.sendMessage(msgMagicMike);

                }
                isRunning = false;
            }
        });
        bgThread2.start();
    }

    private void startThread3() {

        final int min = 100;
        final int max = 200;
        final int random = new Random().nextInt((max - min) + 1) + min;
        Thread bgThread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                for (int i = 0; i <= 20; i++) {

                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Message msgLeonaire = new Message();
                    msgLeonaire.arg1 = i;
                    handlerLeonaire.sendMessage(msgLeonaire);

                }
                isRunning = false;
            }
        });
        bgThread3.start();


    }
}


