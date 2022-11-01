
package com.liyangwei.demo;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import android.widget.Toast;

public class RNRnDemoModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNRnDemoModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNRnDemo";
  }

    /**
   * 这里返回的值会被JS模块当做常量来使用
   * 使用方式为
   *
   * NativeModules.RNToast.SHORT === Toast.LENGTH_SHORT
   * NativeModules.RNToast.LONG === Toast.LENGTH_LONG
   *
   * @return
   */
  @Nullable
  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();

    constants.put("SHORT", Toast.LENGTH_SHORT);
    constants.put("LONG", Toast.LENGTH_LONG);

    return  constants;
  }

  /**
   * 这里暴露一个方法给 React Native
   *
   * 在JS中使用方式为：
   *
   * NativeModules.RNToast.show(msg, duration); // duration 可以使用上面 getConstants 方法暴露出来的常量
   *
   * @param msg
   * @param duration
   */
  @ReactMethod
  public void show( String msg, int duration ){
    Toast.makeText(getReactApplicationContext(), msg, duration).show();
  }
  
}