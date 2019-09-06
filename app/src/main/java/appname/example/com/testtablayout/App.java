package appname.example.com.testtablayout;

import android.app.Application;
import android.content.Context;


public class App extends Application  {

    public static Context c;

    public static  int StatebarH;




    @Override
    public void onCreate() {
        super.onCreate();
        c = this;
       StatebarH = getStatusBarHeight();



    }


    public int getStatusBarHeight() {
        int result = 80;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        LogUtil.e("---stateBar height--->"+result);
        return result;
    }





    //为别的 获activity类提供定位的方法 。取经纬度


}
