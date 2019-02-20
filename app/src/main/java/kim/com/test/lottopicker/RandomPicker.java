package kim.com.test.lottopicker;

import android.util.Log;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomPicker {
    private int[] lottoNumberList;
    private final int LIST_SIZE = 7;
    public RandomPicker(){
        lottoNumberList = new int[LIST_SIZE];
    }
    public void makeLottoNumberList(){
        Random random = new Random();
        long seed = System.currentTimeMillis();
        random.setSeed(seed);
        Set<Integer> lottoNumberSet = new HashSet<>();
        int i;
        for(i=0; lottoNumberSet.size()< LIST_SIZE; i++){
            lottoNumberSet.add((random.nextInt(45)+1));//(0~44)+1
        }
        i=0;
        Iterator<Integer> iterator = lottoNumberSet.iterator();
        while (iterator.hasNext()){
          lottoNumberList[i] = iterator.next();
          //Log.d("Random List", ""+i+": "+lottoNumberList[i]);
          i++;
        }

    }
    public int[] getLottoNumberList() {
        return lottoNumberList;
    }
}
