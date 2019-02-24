package kim.com.test.lottopicker.lottoview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import kim.com.test.lottopicker.R;

/*
*  Lotto Ball View
* */
public class LottoBallView extends FrameLayout {
    final String tag= "LottoBallView";
    int color;
    Resources resources;
    ImageView ballImageView;
    TextView lottoTextView;
    FrameLayout frameLayout;
    int viewIndex = 0;
    public LottoBallView(Context context) {
        super(context);
        initializeView(context);
    }

    public LottoBallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(context);
    }

    public LottoBallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView(context);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height =  MeasureSpec.getSize(heightMeasureSpec);
        int viewSize;
        if(width>height||width==height){
            viewSize = width;
        }else{
            viewSize = height;
        }
        setMeasuredDimension(width, height);
//        frameLayout.setMinimumWidth(width);
//        frameLayout.setMinimumHeight(width);
//        ballImageView.setMinimumWidth(width);
//        ballImageView.setMinimumHeight(height);
//        lottoTextView.setMinimumWidth(width/2);
//        lottoTextView.setMinimumHeight(width/2);
        Log.d(tag, "MeasureWidth:"+ getMeasuredWidth());
        Log.d(tag, "MeasureHeight:"+ getMeasuredHeight());
        Log.d(tag, "ImageView MeasureWidth:"+ ballImageView.getMeasuredWidth());
        Log.d(tag, "ImageView MeasureHeight:"+ ballImageView.getMeasuredHeight());
        Log.d(tag, "TextView MeasureWidth:"+ lottoTextView.getMeasuredWidth());
        Log.d(tag, "TextView MeasureHeight:"+ lottoTextView.getMeasuredHeight());
    }


    private void initializeView(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.lotto_ball_view,this, true);
        //frameLayout = (FrameLayout) inflater.inflate(R.layout.lotto_ball_view,this, false);
        //frameLayout = this.findViewById(R.id.lottoBallFrameLayout);
        resources = getResources();
        color = resources.getColor(R.color.white);
        ballImageView = this.findViewById(R.id.ballView);//first layer
        ballImageView.setImageResource(R.drawable.ic_lotto_ball_24dp);//android:src 적용
//        ballImageView.setVisibility(INVISIBLE);
        lottoTextView = this.findViewById(R.id.numberView);//second layer
        lottoTextView.setText("0");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(205,205 );
        ballImageView.setLayoutParams(layoutParams);
        //lottoTextView.setLayoutParams(layoutParams);
    }
    public void setLottoText(int lottoNumber){
        lottoTextView.setText(String.valueOf(lottoNumber));
        setBallImageColor(lottoNumber);
        this.setBackgroundColor(Color.MAGENTA);
    }
    /*
     * 로또 번호 범위구간에 따른 볼 이미지의 색상은 다음과 같다.
     * 1~10 : Yellow
     * 11~20: Blue
     * 21~30: Red
     * 31~40: Gray
     * 41~45: Green
     * */
    private void setBallImageColor(int lottoNumber){
        if(lottoNumber>=1&&lottoNumber<=10){
            //Yellow
            color = resources.getColor(R.color.yellow);
        }else if(lottoNumber>=11&&lottoNumber<=20){
            //Blue
            color = resources.getColor(R.color.blue);
        }else if(lottoNumber>=21&&lottoNumber<=30){
            //Red
            color = resources.getColor(R.color.red);
        }else if(lottoNumber>=31&&lottoNumber<=40){
            //Gray
            color = resources.getColor(R.color.gray);
        }else if(lottoNumber>40&&lottoNumber<46) {
            //Green
            color = resources.getColor(R.color.green);
        }else{
            //Others Number color White
            color = resources.getColor(R.color.white);
        }
        ballImageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }
}
