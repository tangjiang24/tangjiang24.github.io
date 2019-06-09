package com.tj24.demo.countdown;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.tj24.demo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CountDownActivity extends AppCompatActivity {

    LinearLayout container;
    CountDownView countDownView;
    RecyclerView rv;
    CookStepAdapter mAdapter;
    List<CookStep> cookSteps = new ArrayList<>();

    Map<String,CountDownView> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);

        EventBus.getDefault().register(this);
        container = findViewById(R.id.container);
        rv = findViewById(R.id.rv_list);

        countDownView = new CountDownView();
        countDownView.init("ddd",5000,this,container);
        map.put("ddd",countDownView);

        rv.setLayoutManager(new LinearLayoutManager(this));
        cookSteps.add(new CookStep("kobe1","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559845287163&di=93ce4d19fb75b91ab68a28cb1ec17657&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201604%2F25%2F20160425171833_4GuNC.jpeg","1.kobe进球了分钟！"));

        cookSteps.add(new CookStep("kobe2","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559845287163&di=5a85a7d6924cd2bef43b03efd73c621b&imgtype=0&src=http%3A%2F%2Fpayload265.cargocollective.com%2F1%2F8%2F270661%2F7610412%2FNIKE_KOBE9_DAVID_SHAMA_7--ALL_COLOR_o.jpg","2.kobe打铁了！"));

        cookSteps.add(new CookStep("kobe3","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559845287162&di=a7437b9fb308a10fd48f1653b8224c93&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn%2Fw1200h900%2F20180110%2F8412-fyqnick1967639.jpg","3.kobe夺冠了分钟！！！！！"));

        cookSteps.add(new CookStep("kobe4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559845287161&di=58b439b496cb5c87d46bdfc0cf3eb557&imgtype=0&src=http%3A%2F%2Fwww.i-size.com%2Fsite%2Fuserfiles%2F20171026_184803_103.jpg","4.kobe mvp"));

        cookSteps.add(new CookStep("kobe5","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559845287161&di=58b439b496cb5c87d46bdfc0cf3eb557&imgtype=0&src=http%3A%2F%2Fwww.i-size.com%2Fsite%2Fuserfiles%2F20171026_184803_103.jpg","5.kobe分钟 mvp"));

        cookSteps.add(new CookStep("kobe6","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559845287161&di=58b439b496cb5c87d46bdfc0cf3eb557&imgtype=0&src=http%3A%2F%2Fwww.i-size.com%2Fsite%2Fuserfiles%2F20171026_184803_103.jpg","6.kobe mvp"));

        cookSteps.add(new CookStep("kobe7","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559845287161&di=58b439b496cb5c87d46bdfc0cf3eb557&imgtype=0&src=http%3A%2F%2Fwww.i-size.com%2Fsite%2Fuserfiles%2F20171026_184803_103.jpg","7.kobe分钟 mvp"));


        mAdapter = new CookStepAdapter(cookSteps,this, map);
        rv.setAdapter(mAdapter);

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceived(CountDown countDown){
        if(map.containsKey(countDown.getId())){
            if(countDown.getLastTime()==0){
                map.get(countDown.getId()).setViews(CountDown.TIMER_NOT_TIMING,countDown.getTotalTime());
            }else {
                map.get(countDown.getId()).setViews(CountDown.TIMER_TIMING,countDown.getLastTime());
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
