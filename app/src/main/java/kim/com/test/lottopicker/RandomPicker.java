package kim.com.test.lottopicker;

import android.util.Log;

import java.util.Random;

public class RandomPicker {
    int[] lottoNumberList;
    final int LIST_SIZE = 7;
    public RandomPicker(){
        lottoNumberList = new int[LIST_SIZE];
    }
    public void makeLottoNumberList(){
        int i;
        Random random = new Random();
        long seed = System.currentTimeMillis();
        random.setSeed(seed);
        for(i=0; i< LIST_SIZE; i++){
            lottoNumberList[i] = random.nextInt(46);
            Log.d("Random List", ""+i+": "+lottoNumberList[i]);
        }
    }
    private void duplicatedLottoNumberCheck(){

    }
    public int[] getLottoNumberList() {
        return lottoNumberList;
    }
}
