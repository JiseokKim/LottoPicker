package kim.com.test.lottopicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/*
* 로또 번호 범위구간에 따른 볼 이미지의 색상은 다음과 같다.
* 1~10 : Yellow
* 11~20: Blue
* 21~30: Red
* 31~40: Gray
* 41~45: Green
* */
public class LottoBallView extends View {
    int lottoNumber;

    public LottoBallView(Context context) {
        super(context);
    }

    public LottoBallView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LottoBallView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LottoBallView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
