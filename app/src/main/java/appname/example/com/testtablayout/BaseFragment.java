package appname.example.com.testtablayout;

import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by xiong on 2017/10/10.
 */

public abstract class BaseFragment extends Fragment  {


    //父类的共有成员变量子类能够共享
    //然后这种写法是在谷歌市场里面！！！
    // public View view;
    Activity mActivity;


    public  Handler basehandler = new Handler();

    private String currentFragment;
    public Handler handler =new Handler();
    public View view;


    @Override
    public void onResume() {
        super.onResume();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //这里不能添加父容器1.24 只能添加子容器
        view = LayoutInflater.from(getContext()).inflate(getlayout(),container,false);
        view.setClickable(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        // Mainactivity.getChildFragmentWebviewCallback(this);
        initialize();

    }


    public void setStateBarheight(View v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = App.StatebarH;
        v.setLayoutParams(layoutParams);
    }




    public abstract int getlayout();

    public abstract void initialize();



    /**
     *
     *  得到权限的中文名字
     *
     *
     *  todo
     *  提示用户哪些权限不能够使用
     *  当大于一一个权限的时候，则提示   相关权限不可用
     *  只有当只有一个权限的时候，则提示 具体的权限名字
     *
     * */
    public String permissiontitle(){
        return null;
    }


    /**
     *
     * 授权之后的行为
     *
     * */
    public void AfterPermission(){

    }





}
