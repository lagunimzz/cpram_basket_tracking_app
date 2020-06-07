//package th.co.cpram.rfiddriver;

import android.os.Bundle;
import android.util.Log;

import com.zebra.rfid.api3.TagData;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.EventChannel;

//public class RFIDListener extends FlutterActivity implements EventChannel.StreamHandler, RFIDHandler.ResponseHandlerInterface {
//    RFIDHandler rfidHandler;
//
//    private EventChannel.EventSink eventSink;
//
//
//    public void onConnect(){
//        rfidHandler = new RFIDHandler();
//        rfidHandler.onCreate(this);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//
//    }
//
//    @Override
//    public void handleTagdata(TagData[] tagData) {
//        eventSink.success(tagData);
//    }
//
//    @Override
//    public void handleTriggerPress(boolean pressed) {
//
//    }
//
//    @Override
//    public void onListen(Object arguments, EventChannel.EventSink events) {
//        eventSink = events;
//        registerIfActive();
//    }
//
//    @Override
//    public void onCancel(Object arguments) {
//
//    }
//
//    public void registerIfActive(){
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//}
