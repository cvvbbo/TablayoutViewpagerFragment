package appname.example.com.testtablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager vp;

   // String[] des = {"尊享赔", "利息低", "高通过率", "优先申请", "优先申请", "优先申请", "优先申请"};
    String[] des = {"尊享赔","利息低", "高通过率", "优先申请"};


    private ArrayList<String> datas = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        vp = findViewById(R.id.viewpager);
        inittab();

    }


    private void inittab() {
       // init1();
        final MenuViewPagerForFragment1 mvf = new MenuViewPagerForFragment1(getSupportFragmentManager(), des);
        Afragment afragment = Afragment.newInstance(datas,1);
        Afragment afragment1 = Afragment.newInstance(datas,2);
        Afragment afragment2 = Afragment.newInstance(datas,3);
        Afragment afragment3 = Afragment.newInstance(datas,4);

        mvf.add(afragment);
        mvf.add(afragment1);
        mvf.add(afragment2);
        mvf.add(afragment3);
        // new PassRateSvipFragment()
        //提前预加载也能够防止被销毁，但是开始可能就很卡(因为预加载很卡，然后不调用这个方法就行，然后在fragmentpageradapter中重写destroyItem（方法为空即可）)
        // vp.setOffscreenPageLimit(3);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

                LogUtil.e("onPageScrolled");
            }

            @Override
            public void onPageSelected(int i) {

                LogUtil.e("onPageSelected---->"+i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                LogUtil.e("onPageScrollStateChanged");

            }
        });
        vp.setAdapter(mvf);
        //可惜，和tablayout结合的viewpager不需要framelayout？2017.
        //tablayout的作用是绑定viewpager。
        tabLayout.setupWithViewPager(vp);
        //下面这个是设置指示器的颜色，就是滑动时候的指示器。4.10
        //tablayout.setSelectedTabIndicatorColor(Color.BLUE);
        //这个是选中颜色和未选中颜色 4.11
        // binding.tablayout.setTabTextColors(Color.GRAY,getActivity().getResources().getColor(R.color.tab_layout_text_color));
        tabLayout.setSelectedTabIndicatorHeight(10);
        //这个就是修改整个tablayout整个背景颜色的方法。4.10
        //tablayout.setBackground(new ColorDrawable(Color.RED));

        // todo 下面这两个是指定切换到某个 item
        vp.setCurrentItem(1);
        tabLayout.getTabAt(1).select();

    }




}
