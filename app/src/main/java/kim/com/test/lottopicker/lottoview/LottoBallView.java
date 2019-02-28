package kim.com.test.lottopicker.lottoview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import kim.com.test.lottopicker.R;

/*
*  Lotto Ball View
* */
public class LottoBallView extends RelativeLayout {
    final String tag= "LottoBallView";
    int color;
    Resources resources;
    ImageView ballImageView;
    TextView lottoTextView;
    int viewSize = 0;
    int index;
    public LottoBallView(Context context, int viewIndex) {
        super(context);
        index = viewIndex;
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
        if(width!=0&&height!=0) {
            setMeasuredDimension(width, height);

            if(width>height||width==height) {
                viewSize = width;
            }else{
                viewSize = height;
            };
            Log.d(tag+index, "Width:"+ width);
            Log.d(tag+index, "Height:"+ height);
            Log.d(tag+index, "MeasureWidth:"+ getMeasuredWidth());
            Log.d(tag+index, "MeasureHeight:"+ getMeasuredHeight());
            Log.d(tag+index, "ImageView MeasureWidth:"+ ballImageView.getMeasuredWidth());
            Log.d(tag+index, "ImageView MeasureHeight:"+ ballImageView.getMeasuredHeight());
            Log.d(tag+index, "TextView MeasureWidth:"+ lottoTextView.getMeasuredWidth());
            Log.d(tag+index, "TextView MeasureHeight:"+ lottoTextView.getMeasuredHeight());
        }
//        frameLayout.setMinimumWidth(width);
//        frameLayout.setMinimumHeight(width);
//        ballImageView.setMinimumWidth(width);
//        ballImageView.setMinimumHeight(height);
//        lottoTextView.setMinimumWidth(width/2);
//        lottoTextView.setMinimumHeight(width/2);
        Log.d(tag+index, "onMeasure()");
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        if(viewSize>0) {
            layoutParams.width = viewSize;
            layoutParams.height = viewSize;
        }
        ballImageView.setLayoutParams(layoutParams);
        lottoTextView.setLayoutParams(layoutParams);
    }
    public void setLottoText(int lottoNumber){
        lottoTextView.setText(String.valueOf(lottoNumber));
        setBallImageColor(lottoNumber);
        //this.setBackgroundColor(Color.MAGENTA);
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
