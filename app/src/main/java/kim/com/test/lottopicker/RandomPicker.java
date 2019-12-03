package kim.com.test.lottopicker;

import android.util.Log;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
/** 로또 당첨 숫자를 생성하는 클래스*/
public class RandomPicker {
    private int[] lottoNumberList;
    //로또 당첨 숫자 개수
    private final int LIST_SIZE = 6;
    public RandomPicker(){
        lottoNumberList = new int[LIST_SIZE];
    }
    public void makeLottoNumberList(){
        Random random = new Random();
        long seed = System.currentTimeMillis();
        random.setSeed(seed);
        //자료 구조를 Set로 한 이유는 당첨숫자에 중복되는 숫자가 들어가지 않아야 하기 때문
        Set<Integer> lottoNumberSet = new HashSet<>();
        int i;
        for(i=0; lottoNumberSet.size()< LIST_SIZE; i++){
            //1~45까지의 숫자 중에서 당첨숫자가 나오도록 설정
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
