package kim.com.test.lottopicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {
    loopThread loop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loop = new loopThread();
        loop.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(loop != null){
            loop.threadWork = false;
            loop.interrupt();
        }

    }

    class loopThread extends Thread{
        public boolean threadWork;
        public loopThread(){
            threadWork = true;
        }
        @Override
        public void run() {
            super.run();
            RandomPicker picker = new RandomPicker();
            while(threadWork){
                try{
                    picker.makeLottoNumberList();
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
