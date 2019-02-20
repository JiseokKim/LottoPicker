package kim.com.test.lottopicker;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {
    loopThread loop;
    ConstraintLayout rootLayout;
//    LinearLayout parentLayout;
//    List<LinearLayout> parentLayoutList = new ArrayList();
//    List<LottoBallView> lottoViewList = new ArrayList();
    RecyclerView mRecyclerView;
    LottoViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        rootLayout = new ConstraintLayout(this);
//        rootLayout.setId(R.id.rootLayout);
        loop = new loopThread();
//        loop.start();
        mRecyclerView = findViewById(R.id.lottoListView);
        mRecyclerView.setHasFixedSize(true);


        mAdapter = new LottoViewAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        Log.d("recyclerview width","width: "+mRecyclerView.getMeasuredWidth());
        Log.d("recyclerview height","height: "+mRecyclerView.getMeasuredHeight());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

//    void setRootLayout(int childLayoutCount){
//        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
//                ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
//        for(int i = 0; i< childLayoutCount; i++) {
//            parentLayoutList.get(i).setLayoutParams(layoutParams);
//            rootLayout.addView(parentLayoutList.get(i));
//        }
//    }
//    void setParentLayout(int childViewCount){
//        for(int i = 0; i < childViewCount;i++ ) {
//            LottoBallView lottoBallView = new LottoBallView(this);
//            lottoViewList.add(lottoBallView);
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(loop != null){
            loop.threadWork = false;
            loop.interrupt();
        }

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        if(hasFocus){
//            Log.d("recyclerview width","width: "+mRecyclerView.getMeasuredWidth());
//            Log.d("recyclerview height","height: "+mRecyclerView.getMeasuredHeight());
//        }
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
