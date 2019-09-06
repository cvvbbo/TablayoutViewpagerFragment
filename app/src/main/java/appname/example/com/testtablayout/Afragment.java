package appname.example.com.testtablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Afragment extends BaseFragment {


    private RecyclerView recyclerView;
    private Myadapter myadapter;
    private ArrayList<String> datas =new ArrayList<>();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Bundle bundle = getArguments();
        int tag = bundle.getInt("tag");

        LogUtil.e("tag-->"+tag);

        if (tag == 0){
            init1();
        }else if (tag ==1){
            init2();
        }else if (tag ==2){
            init3();
        }else if (tag == 3){
            init4();
        }else if (tag == 4){
            init5();

        }
    }

    public void init1(){
        datas.clear();
        Random random = new Random();
        for (int j=0; j<200 ; j++){
            int i = random.nextInt(9)+1;
            datas.add("Afragment"+i+"a");
        }


//        datas.add("Afragment1");
//        datas.add("Afragment2");
//        datas.add("Afragment3");
//        datas.add("Afragment4");
//        datas.add("Afragment5");
//        datas.add("Afragment6");
//        datas.add("Afragment7");
//        datas.add("Afragment8");
//        datas.add("Afragment9");
    }

    public void init2(){
        datas.clear();

        Random random = new Random();
        for (int j=0; j<200 ; j++){
            int i = random.nextInt(10)+1;
            datas.add("Afragment"+i);
        }

//        datas.add("Afragment11");
//        datas.add("Afragment12");
//        datas.add("Afragment13");
//        datas.add("Afragment14");
//        datas.add("Afragment15");
//        datas.add("Afragment16");
//        datas.add("Afragment17");
//        datas.add("Afragment18");
//        datas.add("Afragment19");
    }


    public void init3(){
        datas.clear();

        Random random = new Random();
        for (int j=0; j<200 ; j++){
            int i = random.nextInt(20)+10;
            datas.add("Afragment"+i);
        }

//        datas.add("Afragment21");
//        datas.add("Afragment22");
//        datas.add("Afragment23");
//        datas.add("Afragment24");
//        datas.add("Afragment25");
//        datas.add("Afragment26");
//        datas.add("Afragment27");
//        datas.add("Afragment28");
//        datas.add("Afragment29");
    }



    public void init4(){
        datas.clear();
        Random random = new Random();
        for (int j=0; j<200 ; j++){
            int i = random.nextInt(30)+20;
            datas.add("Afragment"+i);
        }

//        datas.add("Afragment31");
//        datas.add("Afragment32");
//        datas.add("Afragment33");
//        datas.add("Afragment34");
//        datas.add("Afragment35");
//        datas.add("Afragment36");
//        datas.add("Afragment37");
//        datas.add("Afragment38");
//        datas.add("Afragment39");
    }


    public void init5(){
        datas.clear();
        Random random = new Random();
        for (int j=0; j<20 ; j++){
            int i = random.nextInt(40)+30;
            datas.add("Afragment"+i);
        }
    }

    public static Afragment newInstance(ArrayList<String> datas,int tag){
        Afragment afragment = new Afragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("datas",datas);
        bundle.putInt("tag",tag);
        afragment.setArguments(bundle);
       // bundle.putByteArray("datas",);
        return afragment;
    }

    @Override
    public int getlayout() {
        return R.layout.a_view;
    }

    @Override
    public void initialize() {
       // initdata();
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myadapter = new Myadapter();
        recyclerView.setAdapter(myadapter);
        myadapter.setdatas(datas);


    }

//    public void initdata(){
//
//        Bundle bundle = getArguments();
//        datas = bundle.getStringArrayList("datas");
//    }


}
